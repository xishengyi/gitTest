package cn.ylcto.student.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ylcto.student.dao.IXueyuanDAO;
import cn.ylcto.student.service.IXueyuanService;
import cn.ylcto.student.vo.Xueyuan;
@Service
public class XueyuanServiceImpl implements IXueyuanService{
	@Resource
	private IXueyuanDAO xueyuanDAO;
	@Override
	public List<Xueyuan> findByName(String xname) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Xueyuan vo) throws Exception {
		// TODO Auto-generated method stub
		return this.xueyuanDAO.doCreate(vo);
	}

	@Override
	public List<Xueyuan> list() throws SQLException {
		// TODO Auto-generated method stub
		return this.xueyuanDAO.findAll();
	}

	@Override
	public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map  = new HashMap<>();
		map.put("allXueyuan", this.xueyuanDAO.findAllBySplit(currentPage, lineSize));
       // map.put("allNote",this.noteDAO.findAllBySplit(currentPage,lineSize));
       // map.put("noteCount",this.noteDAO.getAllCount());
        map.put("xueyuanCount", this.xueyuanDAO.getAllCount());
        return map;
	}

	@Override
	public boolean update(Xueyuan vo) throws Exception {
		// TODO Auto-generated method stub
		return this.xueyuanDAO.doUpdate(vo);
	}

	@Override
	public boolean delete(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return this.xueyuanDAO.doRemoverBatch(ids);
	}

}
