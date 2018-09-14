package cn.ylcto.student.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import cn.ylcto.student.dao.ITeacherDAO;
import cn.ylcto.student.service.ITeacherService;
import cn.ylcto.student.vo.Teacher;
@Service
public class TeacherServiceImpl implements ITeacherService {
	@Resource
	private ITeacherDAO teacherDAO;
	@Override
	public List<Teacher> findByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return this.teacherDAO.findByName(name);
	}

	@Override
	public boolean insert(Teacher vo) throws Exception {
		// TODO Auto-generated method stub
		return this.teacherDAO.doCreate(vo);
	}

	@Override
	public List<Teacher> list() throws SQLException {
		// TODO Auto-generated method stub
		return this.teacherDAO.findAll();
	}

	@Override
	public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map  = new HashMap<>();
		map.put("allTeacher", this.teacherDAO.findAllBySplit(currentPage, lineSize));
        map.put("teacherCount", this.teacherDAO.getAllCount());
        return map;
	}

	@Override
	public boolean update(Teacher vo) throws Exception {
		// TODO Auto-generated method stub
		return this.teacherDAO.doUpdate(vo);
	}

	@Override
	public boolean delete(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return this.teacherDAO.doRemoverBatch(ids);
	}

}
