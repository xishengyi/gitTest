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

import cn.ylcto.student.dao.IKcpjbzDAO;
import cn.ylcto.student.dao.ITeacherDAO;
import cn.ylcto.student.vo.Kcpjbz;
@Repository
public class KcpjbzDAOImpl extends SqlSessionDaoSupport implements IKcpjbzDAO {
	@Autowired
	public KcpjbzDAOImpl(SqlSessionFactory sqlSessionFactory){
		 super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public boolean doCreate(Kcpjbz vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().insert("kcpjbzNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Kcpjbz vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("kcpjbzNS.doUpdate", vo) >0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Kcpjbz findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kcpjbz> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("kcpjbzNS.findAll");
	}

	@Override
	public List<Kcpjbz> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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
	public List<Kcpjbz> findByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("kcpjbzNS.findByName",name);
	}

	@Override
	public List<Kcpjbz> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
        map.put("start",(currentPage-1)*lineSize); // 表示当前页
        map.put("lineSize",lineSize); // 表示当前页
        return super.getSqlSession().selectList("kcpjbzNS.findBySplit",map);
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("kcpjbzNS.getAllCount");
	}

	@Override
	public boolean doRemoverBatch(List<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().delete("kcpjbzNS.doRemove",ids) > 0;
	}

}
