package cn.ylcto.student.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ylcto.student.dao.IKcpjbzDAO;
import cn.ylcto.student.service.IKcpjbzService;
import cn.ylcto.student.vo.Kcpjbz;
@Service
public class KcpjbzServiceImpl implements IKcpjbzService{
	@Resource
	private IKcpjbzDAO kcpjbzDAO;
	@Override
	public List<Kcpjbz> findByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return this.kcpjbzDAO.findByName(name);
	}

	@Override
	public boolean insert(Kcpjbz vo) throws Exception {
		// TODO Auto-generated method stub
		return this.kcpjbzDAO.doCreate(vo);
	}

	@Override
	public List<Kcpjbz> list() throws SQLException {
		// TODO Auto-generated method stub
		return this.kcpjbzDAO.findAll();
	}

	@Override
	public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map  = new HashMap<>();
		map.put("allKcpjbz", this.kcpjbzDAO.findAllBySplit(currentPage, lineSize));
        map.put("kcpjbzCount", this.kcpjbzDAO.getAllCount());
        return map;
	}

	@Override
	public boolean update(Kcpjbz vo) throws Exception {
		// TODO Auto-generated method stub
		return this.kcpjbzDAO.doUpdate(vo);
	}

	@Override
	public boolean delete(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return this.kcpjbzDAO.doRemoverBatch(ids);
	}

}
