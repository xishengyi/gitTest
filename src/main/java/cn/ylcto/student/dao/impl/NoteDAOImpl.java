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

import cn.ylcto.student.dao.INoteDAO;
import cn.ylcto.student.vo.Note;
@Repository
public class NoteDAOImpl extends SqlSessionDaoSupport implements INoteDAO{
	@Autowired
	public NoteDAOImpl(SqlSessionFactory sqlSessionFactory){
		 super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<Note> findByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("noteNS.findByName",name);
	}
	@Override
	public boolean doCreate(Note vo) throws SQLException {
		// TODO Auto-generated method stub
		 return super.getSqlSession().insert("noteNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Note vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("noteNS.doUpdate", vo) >0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Note findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("noteNS.findAll");
	}

	@Override
	public List<Note> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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
	public List<Note> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
		Map<String,Object> map = new HashMap<>();
        map.put("start",(currentPage-1)*lineSize); // 表示当前页
        map.put("lineSize",lineSize); // 表示当前页
        return super.getSqlSession().selectList("noteNS.findBySplit",map);
	}
	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("noteNS.getAllCount");
	}
	@Override
	public boolean doRemoverBatch(List<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return super.getSqlSession().delete("noteNS.doRemove",ids) > 0;
	}

	

}
