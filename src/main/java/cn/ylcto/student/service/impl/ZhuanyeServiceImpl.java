package cn.ylcto.student.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ylcto.student.dao.IZhuanyeDAO;
import cn.ylcto.student.service.IZhuanyeService;
import cn.ylcto.student.vo.Zhuanye;
@Service
public class ZhuanyeServiceImpl implements IZhuanyeService{
	 @Resource
	 private IZhuanyeDAO zhuanyeDAO;
	@Override
	public boolean insert(Zhuanye vo) throws Exception {
		// TODO Auto-generated method stub
		return this.zhuanyeDAO.doCreate(vo);
	}

	@Override
	public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map  = new HashMap<>();
        map.put("allZhuanye",this.zhuanyeDAO.findAllBySplit(currentPage,lineSize));
        map.put("zhuanyeCount",this.zhuanyeDAO.getAllCount());
        return map;
	}

	@Override
	public boolean update(Zhuanye vo) throws Exception {
		// TODO Auto-generated method stub
		return this.zhuanyeDAO.doUpdate(vo);
	}

	@Override
	public boolean delete(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return this.zhuanyeDAO.doRemoverBatch(ids);
	}

}
