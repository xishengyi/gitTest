package cn.ylcto.student.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import cn.ylcto.student.vo.Xueyuan;

public interface IXueyuanService {
	
	public List<Xueyuan> findByName(String xname)throws SQLException;
	
	/**
	 * 实现数据的增加操作
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	 public boolean insert(Xueyuan vo)throws Exception;
	 
	 /**
	  * 实现数据的全部列出操作
	  * @return
	  * @throws SQLException
	  */
	 public List<Xueyuan> list()throws SQLException;
	 
	 /**
	     * 实现数据分页查询操作
	     * @param currentPage 表示当前页
	     * @param lineSize 表示每页显示记录数
	     * @return
	     * @throws Exception
	     */
	 public Map<String,Object> listSplit(int currentPage,int lineSize)throws Exception;
	 
	 /**
	     * 实现数据更新操作方法
	     * @param vo 表示要执行更新操作的数据
	     * @return 成功返回true,失败返回false
	     * @throws Exception
	     */
	 public boolean update(Xueyuan vo)throws Exception;
	 
	 /**
	     * 实现数据批量删除操作
	     * @param ids 表示要执行删除的操作的集合数据
	     * @return
	     * @throws Exception
	     */
	 public boolean delete(List<String> ids)throws Exception;
}
