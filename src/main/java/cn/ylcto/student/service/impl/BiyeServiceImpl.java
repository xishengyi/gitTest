package cn.ylcto.student.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ylcto.student.dao.IBiyeDAO;

import cn.ylcto.student.service.IBiyeService;
import cn.ylcto.student.vo.Biye;
@Service
public class BiyeServiceImpl implements IBiyeService{
	@Resource
	private IBiyeDAO biyeDAO;
	@Override
	public List<Biye> findByName(String zwcd) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Biye vo) throws Exception {
		// TODO Auto-generated method stub
		return this.biyeDAO.doCreate(vo);
	}

	@Override
	public List<Biye> list() throws SQLException {
		// TODO Auto-generated method stub
		return this.biyeDAO.findAll();
	}

	@Override
	public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map  = new HashMap<>();
		map.put("allBiye", this.biyeDAO.findAllBySplit(currentPage, lineSize));
        map.put("biyeCount", this.biyeDAO.getAllCount());
        return map;
	}

	@Override
	public boolean update(Biye vo) throws Exception {
		// TODO Auto-generated method stub
		return this.biyeDAO.doUpdate(vo);
	}

	@Override
	public boolean delete(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return this.biyeDAO.doRemoverBatch(ids);
	}

}
