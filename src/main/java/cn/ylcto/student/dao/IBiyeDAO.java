package cn.ylcto.student.dao;

import java.sql.SQLException;
import java.util.List;

import cn.ylcto.student.vo.Biye;


public interface IBiyeDAO extends IDAO<String,Biye> {
	public List<Biye> findByName(String zwcd)throws SQLException;
	/**
	 * 实现数据分页
	 * @param currentPage 表示当前页
	 * @param lineSize 表示每页显示记录数
	 * @return 返回满足条件的数据，失败返回null
	 * @throws SQLException
	 */
	public List<Biye> findAllBySplit(Integer currentPage,Integer lineSize) throws SQLException;
	
	/**
	 * 实现数据量统计操作
	 * @return 成功返回数据量，失败返回0
	 * @throws SQLException
	 */
	public Integer getAllCount() throws SQLException;
	
	/**
	 * 实现数据批量删除操作
	 * @param ids 表示要执行删除操作的数据集合
	 * @return
	 * @throws SQLException
	 */
	public boolean doRemoverBatch(List<String> ids) throws SQLException;
}
