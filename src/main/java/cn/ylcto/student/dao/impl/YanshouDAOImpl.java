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

import cn.ylcto.student.dao.IYanshouDAO;
import cn.ylcto.student.vo.Yanshou;
@Repository
public class YanshouDAOImpl extends SqlSessionDaoSupport implements IYanshouDAO {
	@Autowired
    public YanshouDAOImpl(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	@Override
	public boolean doCreate(Yanshou vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().insert("YanshouNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Yanshou vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("YanshouNS.doUpdate" ,vo)>0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Yanshou findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Yanshou> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Yanshou> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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
	public List<Yanshou> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
        map.put("start",(currentPage-1)*lineSize); // 表示当前页
        map.put("lineSize",lineSize); // 表示当前页
        return super.getSqlSession().selectList("YanshouNS.findBySplit",map);
		
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("YanshouNS.getAllCount");
		
	}

	@Override
	public boolean doRemoverBatch(List<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().delete("YanshouNS.doRemove",ids) > 0;
	}

}
