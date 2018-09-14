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

import cn.ylcto.student.dao.IXueyuanDAO;
import cn.ylcto.student.vo.Xueyuan;
@Repository
public class XueyuanDAOImpl extends SqlSessionDaoSupport implements IXueyuanDAO{
	
	@Autowired
	public XueyuanDAOImpl(SqlSessionFactory sqlSessionFactory){
		 super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public boolean doCreate(Xueyuan vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().insert("XueyuanNS.doCreate",vo)>0;
	}

	@Override
	public boolean doUpdate(Xueyuan vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("XueyuanNS.doUpdate",vo)>0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Xueyuan findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Xueyuan> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("XueyuanNS.findAll");
	}

	@Override
	public List<Xueyuan> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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
	public List<Xueyuan> findByName(String xname) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Xueyuan> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
        map.put("start",(currentPage-1)*lineSize); // 表示当前页
        map.put("lineSize",lineSize); // 表示当前页
        return super.getSqlSession().selectList("XueyuanNS.findBySplit",map);
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("XueyuanNS.getAllCount");
	}

	@Override
	public boolean doRemoverBatch(List<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().delete("XueyuanNS.doRemove",ids) > 0;
	}

}
