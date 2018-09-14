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

import cn.ylcto.student.dao.ITeacherDAO;
import cn.ylcto.student.vo.Teacher;
@Repository
public class TeacherDAOImpl extends SqlSessionDaoSupport implements ITeacherDAO {
	@Autowired
	public TeacherDAOImpl(SqlSessionFactory sqlSessionFactory){
		 super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public boolean doCreate(Teacher vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().insert("teacherNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Teacher vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("teacherNS.doUpdate", vo) >0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Teacher findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("teacherNS.findAll");
	}

	@Override
	public List<Teacher> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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
	public List<Teacher> findByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("teacherNS.findByName",name);
	}

	@Override
	public List<Teacher> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
        map.put("start",(currentPage-1)*lineSize); // 表示当前页
        map.put("lineSize",lineSize); // 表示当前页
        return super.getSqlSession().selectList("teacherNS.findBySplit",map);
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("teacherNS.getAllCount");
	}

	@Override
	public boolean doRemoverBatch(List<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().delete("teacherNS.doRemove",ids) > 0;
	}

}
