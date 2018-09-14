package cn.ylcto.student.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.ylcto.student.service.IXueyuanService;
import cn.ylcto.student.vo.Note;
import cn.ylcto.student.vo.Xueyuan;
import cn.ylcto.util.action.DefaultAction;
@Controller
@RequestMapping(value = "/pages/back/xueyuan/*")
public class XueyuanAction extends DefaultAction {

	@Resource
	private IXueyuanService xueyuanService;
	@RequestMapping(value = "xueyuan_findByName")
	public void findByName(HttpServletResponse response,HttpServletRequest request,@RequestParam String keyword){
		String temp = request.getParameter("keyword");
		List<Xueyuan> xueyuans = new ArrayList<>();
		try {
			xueyuans = this.xueyuanService.findByName(keyword);
			Integer count = xueyuans.size();
			super.printObjectToListSplit(response, "allNote", xueyuans, count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "xueyuan_delete")
    public void delete(HttpServletResponse response,HttpServletRequest request){
       try{
        String result [] = request.getParameter("ids").split("\\|");
        List<String> all = new ArrayList<>();
        for (int x = 0;x < result.length;x++){
            all.add(result[x]);
        }
        if (all.size() > 0){
                super.print(response,this.xueyuanService.delete(all));
        }else{
            super.print(response,"false"); // 删除数据不成功返回false
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
	
	@RequestMapping(value = "xueyuan_update")
    public void update(HttpServletResponse response ,Xueyuan vo){
        try {
            super.print(response,this.xueyuanService.update(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
	@RequestMapping(value = "xueyuan_list")
	public void list(HttpServletRequest request, HttpServletResponse response){
        super.handSplit(request,response);
        try {
            Map<String,Object> map = this.xueyuanService.listSplit(super.getCurrentPage(),super.getLineSize());
            List<Xueyuan> all = (List<Xueyuan>) map.get("allXueyuan");
            Integer allRecorders = (Integer) map.get("xueyuanCount");
            super.printObjectToListSplit(response,"allXueyuan",all,allRecorders);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@RequestMapping(value = "xueyuan_insert")
	public ModelAndView insert(Xueyuan vo){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			if (this.xueyuanService.insert(vo)){
			    super.setMsgAndPath(mav,"xueyuan.insert.success","xueyuan.login.success");
			}else{
			    super.setMsgAndPath(mav,"xueyuan.insert.failure","xueyuan.login.failure");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}
	
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "学院";
	}

}
