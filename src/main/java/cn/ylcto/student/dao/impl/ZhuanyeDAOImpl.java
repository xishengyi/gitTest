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

import cn.ylcto.student.dao.IZhuanyeDAO;
import cn.ylcto.student.vo.Zhuanye;
@Repository
public class ZhuanyeDAOImpl extends SqlSessionDaoSupport implements IZhuanyeDAO{
	@Autowired
    public ZhuanyeDAOImpl(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	@Override
	public boolean doCreate(Zhuanye vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().insert("ZhuanyeNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Zhuanye vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("ZhuanyeNS.doUpdate" ,vo)>0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Zhuanye findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zhuanye> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zhuanye> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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
	public List<Zhuanye> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
        map.put("start",(currentPage-1)*lineSize); // 表示当前页
        map.put("lineSize",lineSize); // 表示当前页
        return super.getSqlSession().selectList("ZhuanyeNS.findBySplit",map);
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("ZhuanyeNS.getAllCount");
	}

	@Override
	public boolean doRemoverBatch(List<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		 return super.getSqlSession().delete("ZhuanyeNS.doRemove",ids) > 0;
	}

}
