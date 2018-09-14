package cn.ylcto.student.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ylcto.student.dao.IYanshouDAO;

import cn.ylcto.student.service.IYanshouService;
import cn.ylcto.student.vo.Yanshou;
@Service
public class YanshouServiceImpl implements IYanshouService{
	@Resource
	 private IYanshouDAO yanshouDAO;
	@Override
	public boolean insert(Yanshou vo) throws Exception {
		// TODO Auto-generated method stub
		return this.yanshouDAO.doCreate(vo);
	}

	@Override
	public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map  = new HashMap<>();
        map.put("allYanshou",this.yanshouDAO.findAllBySplit(currentPage,lineSize));
        map.put("yanshouCount",this.yanshouDAO.getAllCount());
        return map;
	}

	@Override
	public boolean update(Yanshou vo) throws Exception {
		// TODO Auto-generated method stub
		return this.yanshouDAO.doUpdate(vo);
	}

	@Override
	public boolean delete(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return this.yanshouDAO.doRemoverBatch(ids);
	}

}
