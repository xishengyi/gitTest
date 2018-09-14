package cn.ylcto.util.utils;
 
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
 
 
/**
 * 
 * office excel工具类
 * 
 *
 */
public final class ExcelUtils {
	
	private static final SimpleDateFormat DATE_FORAMT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 
	 * 导出最精简的excel
	 * 
	 * @param headers (不是必填) excel头列 比如: 姓名  年龄  性别 ..
	 * @param datas (必填) 数据列(请确保和列的顺序保持一致)
	 * @param fileName 生成excel的文件名称，如果不传则默认为随机生成
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws IOException  
	 */
	public static void generateCreateExcel(List<String> headers, List<List<Object>> datas, String fileName,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		Workbook workbook = generateCreateExcel(headers, datas);
		
		/*// 文件名处理一下
		fileName = (StringUtils.isEmpty(fileName) ? UUID.randomUUID().toString() : fileName) + "."
				+ XSSFWorkbookType.XLSX.getExtension();*/
		fileName = (StringUtils.isEmpty(fileName)?UUID.randomUUID().toString() : fileName)+".xlsx";
		//fileName = "xxx.XLSX";
		String userAgent = request.getHeader("User-Agent");
        if (userAgent.toUpperCase().contains("MSIE") || userAgent.toUpperCase().contains("RV:11")) {
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.displayName());
        }
        else {
            fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        }
        
		response.reset(); // 清空response
		response.setContentType("application/x-msdownload");
		response.setHeader("Connection", "close"); // 表示不能用浏览器直接打开
		response.setHeader("content-disposition", "attachment;filename=" + fileName);
		response.setCharacterEncoding("UTF-8");
		
        // 文件流输出
		try {
			workbook.write(response.getOutputStream());
		}
		catch (IOException e) {
			throw new IOException("could not write to response. cause: ", e);
		}
		/*finally {
			if (workbook != null)
				workbook.close();
		}*/
	}
	
	/**
	 * 生成一个workbook
	 * 
	 * @param headers (不是必填) excel头列 比如: 姓名  年龄  性别 ..
	 * @param datas(必填) 数据列(请确保和列的顺序保持一致)
	 * @return
	 */
	public static Workbook generateCreateExcel(List<String> headers, List<List<Object>> datas) {
		
		XSSFWorkbook book = null;
		
		// 如果内容为空则直接返回一个空的book
		if (CollectionUtils.isEmpty(datas)) {
			return book;
		}
		
		// 先创建一发book,并建一个sheet
		book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet();
		
		// 设置自适应列宽
		List<Integer> maxCalls = getMaxCall(headers, datas);
		for (int i = 0, j = maxCalls.size(); i < j; i++) {
			// 最大列宽设置
			if (maxCalls.get(i) > 30) {
				sheet.setColumnWidth(i, 30 * 256);
			} else {
				sheet.setColumnWidth(i, maxCalls.get(i) * 256);
			}
		}
		
		// 是否有头，如果有则先把表头建好
		if (CollectionUtils.isNotEmpty(headers)) {
			// 创建第一行，表头行
			XSSFRow titleRow = sheet.createRow(0);
			
			XSSFCell titleCell = null;
			XSSFRichTextString titleText = null;
			// 把表头放到第一个行里面
			for (int i = 0; i < headers.size(); i++) {
				// 有几个列头 就在一行中创建多少个单元格
				titleCell = titleRow.createCell(i);
				
				// 给创建的单元格里面设值
				titleText = new XSSFRichTextString(headers.get(i));
				titleCell.setCellValue(titleText);
			}
		}
		
		// 处理内容
		if (CollectionUtils.isNotEmpty(datas)) {
			
			// 如果有列表头则row重1开始。否则重0开始
			int dataRowIdx = CollectionUtils.isNotEmpty(headers) ? 1 : 0;
			
			XSSFRow dataRow = null; 
			XSSFCell dataCell = null;
			List<Object> dataList = null;
			
			// 开始处理行和单元格
			for (int i = 0; i < datas.size(); i++) {
				
				// 创建内容的行
				dataRow = sheet.createRow(i + dataRowIdx);
				
				dataList = datas.get(i);
				// 将内容放到对应的行中
				for (int j = 0; j < dataList.size(); j++) {
					// 有多少个内容就有多少个单元格
					dataCell = dataRow.createCell(j);
					
					// 设值单元格的值
					setValue(dataCell, dataList.get(j));
				}
			}
		}
		
		return book;
	}
	
	private static void setValue(Cell cell, Object value) {
		
		// 如果是null 则设值为空
		if (Objects.isNull(value)) {
			cell.setCellValue("");
		}
		else if (value.getClass() == String.class) {
			cell.setCellValue(String.valueOf(value));
		}
		else if (value.getClass() == Integer.class) {
			cell.setCellValue((Integer) value);
		}
		else if (value.getClass() == Double.class) {
			cell.setCellValue((Double) value);
		}
		else if (value.getClass() == Date.class) {
			cell.setCellValue(DATE_FORAMT.format(value));
		}
		else if (value.getClass() == Long.class) {
			cell.setCellValue((Long) value);
		}
		else {
			cell.setCellValue(new XSSFRichTextString(String.valueOf(value)));
		}
	}
	
	/**
	 * 最大列宽
	 * 
	 * @param headers
	 * @param datas
	 * @return
	 */
	private static List<Integer> getMaxCall(List<String> headers, List<List<Object>> datas) {
		// 创建最大列宽集合
		List<Integer> maxCall = new ArrayList<>();
		List<List<Integer>> lss = new ArrayList<>();
		// 计算标题行数据的列宽
		List<Integer> hls = new ArrayList<>();
		for (int m = 0; m < headers.size(); m++) {
			int length = headers.get(m).getBytes().length;
			hls.add(length);
			// 最大列宽赋初值
			maxCall.add(0);
		}
		lss.add(hls);
		
		// 计算内容行数据的列宽
		for (int i = 0, j = datas.size(); i < j; i++) {
			List<Integer> dls = new ArrayList<>();
			for (int m = 0, n = datas.get(i).size(); m < n; m++) {
				Object obj = datas.get(i).get(m);
				if (obj == null) {
					dls.add(0);
					continue;
				}
				if (obj.getClass() == Date.class) {
					// 日期格式类型转换
					obj = DATE_FORAMT.format(obj);
				}
				int length = obj.toString().getBytes().length;
				dls.add(length);
			}
			lss.add(dls);
		}
		// 根据列宽计算出每列的最大宽度
		for (int i = 0, j = lss.size(); i < j; i++) {
			for (int m = 0, n = lss.get(i).size(); m < n; m++) {
				Integer a = lss.get(i).get(m);
				Integer b = maxCall.get(m);
				if (a > b) {
					maxCall.set(m, a);
				}
			}
		}
		return maxCall;
	}
}
//	public static void main(String[] args) {
//		List<String> headers = new ArrayList<>();
//		
//		headers.add("姓名");
//		headers.add("性别");
//		headers.add("年龄");
//		
//		List<List<Object>> datas = new ArrayList<>();
//		List<Object> data = new ArrayList<>();
//		
//		data.add("没有数据");
//		datas.add(data);
//		
//		Workbook workbook = generateCreateExcel(headers, datas);
//		OutputStream out = null;
//		try {
//			out = new FileOutputStream(new File("d:/data/1.xlsx"));
//			workbook.write(out);
//			
//			System.out.println("--------- over --------");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				workbook.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				out.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}
