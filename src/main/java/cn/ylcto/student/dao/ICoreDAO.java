package cn.ylcto.student.dao;

import java.sql.SQLException;
import java.util.List;

import cn.ylcto.student.vo.Core;

public interface ICoreDAO extends IDAO<String,Core> {
	public List<Core> findByName(String name)throws SQLException;
	/**
	 * 实现数据分页
	 * @param currentPage 表示当前页
	 * @param lineSize 表示每页显示记录数
	 * @return 返回满足条件的数据，失败返回null
	 * @throws SQLException
	 */
	public List<Core> findAllBySplit(Integer currentPage,Integer lineSize) throws SQLException;
	
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
