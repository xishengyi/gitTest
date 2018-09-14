package cn.ylcto.student.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ylcto.student.dao.ICourseDAO;
import cn.ylcto.student.service.ICourseService;
import cn.ylcto.student.vo.Course;
@Service
public class CourseServiceImpl implements ICourseService{
	@Resource
	private ICourseDAO courseDAO;
	@Override
	public List<Course> findByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return this.courseDAO.findByName(name);
	}

	@Override
	public boolean insert(Course vo) throws Exception {
		// TODO Auto-generated method stub
		return this.courseDAO.doCreate(vo);
	}

	@Override
	public List<Course> list() throws SQLException {
		// TODO Auto-generated method stub
		return this.courseDAO.findAll();
	}

	@Override
	public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map  = new HashMap<>();
		map.put("allCourse", this.courseDAO.findAllBySplit(currentPage, lineSize));
        map.put("courseCount", this.courseDAO.getAllCount());
        return map;
	}

	@Override
	public boolean update(Course vo) throws Exception {
		// TODO Auto-generated method stub
		return this.courseDAO.doUpdate(vo);
	}

	@Override
	public boolean delete(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return this.courseDAO.doRemoverBatch(ids);
	}

}
