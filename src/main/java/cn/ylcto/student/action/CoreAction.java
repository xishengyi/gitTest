package cn.ylcto.student.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.ylcto.student.service.ICoreService;
import cn.ylcto.student.service.INoteService;
import cn.ylcto.student.vo.Core;
import cn.ylcto.student.vo.Note;
import cn.ylcto.util.action.DefaultAction;
@Controller
@RequestMapping(value = "/pages/back/core/*")
public class CoreAction extends DefaultAction{
	@Resource
	private ICoreService coreService;
	@RequestMapping(value = "core_findByName")
	public void findByName(HttpServletResponse response,HttpServletRequest request,@RequestParam String keyword){
		String temp = request.getParameter("keyword");
		List<Core> cores = new ArrayList<>();
		try {
			cores = this.coreService.findByName(keyword);
			Integer count = cores.size();
			super.printObjectToListSplit(response, "allCore", cores, count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "core_delete")
    public void delete(HttpServletResponse response,HttpServletRequest request){
       try{
        String result [] = request.getParameter("ids").split("\\|");
        List<String> all = new ArrayList<>();
        for (int x = 0;x < result.length;x++){
            all.add(result[x]);
        }
        if (all.size() > 0){
                super.print(response,this.coreService.delete(all));
        }else{
            super.print(response,"false"); // 删除数据不成功返回false
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
	@RequestMapping(value = "core_update")
    public void update(HttpServletResponse response ,Core vo){
        try {
            super.print(response,this.coreService.update(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@RequestMapping(value = "core_list")
	public void list(HttpServletRequest request, HttpServletResponse response){
        super.handSplit(request,response);
        try {
            Map<String,Object> map = this.coreService.listSplit(super.getCurrentPage(),super.getLineSize());
            List<Core> all = (List<Core>) map.get("allCore");
            Integer allRecorders = (Integer) map.get("coreCount");
            super.printObjectToListSplit(response,"allCore",all,allRecorders);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	@RequestMapping(value = "core_insert")
	public ModelAndView insert(Core vo){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			if (this.coreService.insert(vo)){
			    super.setMsgAndPath(mav,"core.insert.success","core.login.success");
			}else{
			    super.setMsgAndPath(mav,"core.insert.failure","core.login.failure");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "试卷结构";
	}
}
