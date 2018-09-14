package cn.ylcto.student.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ylcto.student.dao.ICoreDAO;
import cn.ylcto.student.vo.Core;
@Repository
public class CoreDAOImpl extends SqlSessionDaoSupport implements ICoreDAO{
	@Autowired
	public CoreDAOImpl(SqlSessionFactory sqlSessionFactory){
		 super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public boolean doCreate(Core vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().insert("coreNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Core vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("coreNS.doUpdate",vo)>0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Core findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Core> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("coreNS.findAll");
	}

	@Override
	public List<Core> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Core> findByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("coreNS.findByName",name);
	}

	@Override
	public List<Core> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
        map.put("start",(currentPage-1)*lineSize); // 表示当前页
        map.put("lineSize",lineSize); // 表示当前页
        return super.getSqlSession().selectList("coreNS.findBySplit",map);
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("coreNS.getAllCount");
	}

	@Override
	public boolean doRemoverBatch(List<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().delete("coreNS.doRemove",ids) > 0;
	}

}
