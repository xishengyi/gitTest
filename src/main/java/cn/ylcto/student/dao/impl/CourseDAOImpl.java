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

import cn.ylcto.student.dao.ICourseDAO;
import cn.ylcto.student.vo.Course;
@Repository
public class CourseDAOImpl extends SqlSessionDaoSupport implements ICourseDAO {
	@Autowired
	public CourseDAOImpl(SqlSessionFactory sqlSessionFactory){
		 super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public boolean doCreate(Course vo) throws SQLException {
		// TODO Auto-generated method stub
		 return super.getSqlSession().insert("courseNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Course vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("courseNS.doUpdate", vo) >0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Course findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("courseNS.findAll");
	}

	@Override
	public List<Course> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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
	public List<Course> findByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("courseNS.findByName",name);
	}

	@Override
	public List<Course> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
        map.put("start",(currentPage-1)*lineSize); // 表示当前页
        map.put("lineSize",lineSize); // 表示当前页
        return super.getSqlSession().selectList("courseNS.findBySplit",map);
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("courseNS.getAllCount");
	}

	@Override
	public boolean doRemoverBatch(List<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().delete("courseNS.doRemove",ids) > 0;
	}

}
