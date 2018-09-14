package cn.ylcto.student.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import cn.ylcto.student.dao.INoteDAO;
import cn.ylcto.student.service.INoteService;
import cn.ylcto.student.vo.Note;
@Service
public class NoteServiceImpl implements INoteService{
	 @Resource
	private INoteDAO noteDAO;
	@Override
	public boolean insert(Note vo) throws Exception {
		
        return this.noteDAO.doCreate(vo);
	}

	@Override
	public List<Note> list() throws SQLException {
		// TODO Auto-generated method stub
		return this.noteDAO.findAll();
	}

	@Override
	public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
		Map<String,Object> map  = new HashMap<>();
		map.put("allNote", this.noteDAO.findAllBySplit(currentPage, lineSize));
       // map.put("allNote",this.noteDAO.findAllBySplit(currentPage,lineSize));
       // map.put("noteCount",this.noteDAO.getAllCount());
        map.put("noteCount", this.noteDAO.getAllCount());
        return map;
	}

	@Override
	public boolean update(Note vo) throws Exception {
		// TODO Auto-generated method stub
		return this.noteDAO.doUpdate(vo);
	}

	@Override
	public boolean delete(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ids);
		return this.noteDAO.doRemoverBatch(ids);
	}

	@Override
	public List<Note> findByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return this.noteDAO.findByName(name);
	}

}
