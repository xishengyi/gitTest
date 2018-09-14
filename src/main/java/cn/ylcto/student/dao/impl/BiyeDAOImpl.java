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

import cn.ylcto.student.dao.IBiyeDAO;
import cn.ylcto.student.vo.Biye;
@Repository
public class BiyeDAOImpl extends SqlSessionDaoSupport implements IBiyeDAO{
	@Autowired
	public BiyeDAOImpl(SqlSessionFactory sqlSessionFactory){
		 super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public boolean doCreate(Biye vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().insert("BiyeNS.doCreate",vo)>0;
	}

	@Override
	public boolean doUpdate(Biye vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("BiyeNS.doUpdate",vo)>0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Biye findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Biye> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("BiyeNS.findAll");
	}

	@Override
	public List<Biye> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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
	public List<Biye> findByName(String zwcd) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Biye> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
        map.put("start",(currentPage-1)*lineSize); // 表示当前页
        map.put("lineSize",lineSize); // 表示当前页
        return super.getSqlSession().selectList("BiyeNS.findBySplit",map);
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("BiyeNS.getAllCount");
	}

	@Override
	public boolean doRemoverBatch(List<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().delete("BiyeNS.doRemove",ids) > 0;
	}

}
