package cn.ylcto.student.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ylcto.student.dao.ICoreDAO;
import cn.ylcto.student.service.ICoreService;
import cn.ylcto.student.vo.Core;
@Service
public class CoreServiceImpl implements ICoreService {
	 @Resource
	 private ICoreDAO coreDAO;
	@Override
	public List<Core> findByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return this.coreDAO.findByName(name);
	}

	@Override
	public boolean insert(Core vo) throws Exception {
		// TODO Auto-generated method stub
		return this.coreDAO.doCreate(vo);
	}

	@Override
	public List<Core> list() throws SQLException {
		// TODO Auto-generated method stub
		return this.coreDAO.findAll();
	}

	@Override
	public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
		Map<String,Object> map  = new HashMap<>();
		map.put("allCore", this.coreDAO.findAllBySplit(currentPage, lineSize));
		map.put("coreCount", this.coreDAO.getAllCount());
        return map;
	}

	@Override
	public boolean update(Core vo) throws Exception {
		// TODO Auto-generated method stub
		return this.coreDAO.doUpdate(vo);
	}

	@Override
	public boolean delete(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return this.coreDAO.doRemoverBatch(ids);
	}

}
