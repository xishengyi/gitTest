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

import cn.ylcto.student.service.IKcpjbzService;
import cn.ylcto.student.vo.Kcpjbz;
import cn.ylcto.student.vo.Teacher;
import cn.ylcto.util.action.DefaultAction;
@Controller
@RequestMapping(value = "/pages/back/kcpjbz/*")
public class KcpjbzAction extends DefaultAction {
	@Resource
	private IKcpjbzService kcpjbzService;
	@RequestMapping(value = "kcpjbz_findByName")
	public void findByName(HttpServletResponse response,HttpServletRequest request,@RequestParam(value="keyword",required=false) String keyword){
		String temp = request.getParameter("keyword");
		List<Kcpjbz> kcpjbz = new ArrayList<>();
		try {
			kcpjbz = this.kcpjbzService.findByName(keyword);
			Integer count = kcpjbz.size();
			super.printObjectToListSplit(response, "allKcpjbz", kcpjbz, count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "kcpjbz_delete")
    public void delete(HttpServletResponse response,HttpServletRequest request){
       try{
        String result [] = request.getParameter("ids").split("\\|");
        List<String> all = new ArrayList<>();
        for (int x = 0;x < result.length;x++){
            all.add(result[x]);
        }
        if (all.size() > 0){
                super.print(response,this.kcpjbzService.delete(all));
        }else{
            super.print(response,"false"); // 删除数据不成功返回false
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
	@RequestMapping(value = "kcpjbz_update")
    public void update(HttpServletResponse response ,Kcpjbz vo){
        try {
            super.print(response,this.kcpjbzService.update(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@RequestMapping(value = "kcpjbz_list")
	public void list(HttpServletRequest request, HttpServletResponse response){
        super.handSplit(request,response);
        try {
            Map<String,Object> map = this.kcpjbzService.listSplit(super.getCurrentPage(),super.getLineSize());
            List<Kcpjbz> all = (List<Kcpjbz>) map.get("allKcpjbz");
            Integer allRecorders = (Integer) map.get("kcpjbzCount");
            super.printObjectToListSplit(response,"allKcpjbz",all,allRecorders);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	@RequestMapping(value = "kcpjbz_insert")
	public ModelAndView insert(Kcpjbz vo){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			if (this.kcpjbzService.insert(vo)){
			    super.setMsgAndPath(mav,"kcpjbz.insert.success","kcpjbz.login.success");
			}else{
			    super.setMsgAndPath(mav,"kcpjbz.insert.failure","kcpjbz.login.failure");
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
		return "课程评价标准";
	}

}
