package cn.ylcto.student.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.service.IZhuanyeService;
import cn.ylcto.student.vo.Student;
import cn.ylcto.student.vo.Zhuanye;
import cn.ylcto.util.action.DefaultAction;
@Controller
@RequestMapping(value = "/pages/back/zhuanye/*")
public class ZhuanyeAction extends DefaultAction{
	    @Resource
	    private IZhuanyeService zhuanyeService;
	 
	 @RequestMapping(value = "zhuanye_delete")
	    public void delete(HttpServletResponse response,HttpServletRequest request){
	       try{
	        String result [] = request.getParameter("ids").split("\\|");
	        List<String> all = new ArrayList<>();
	        for (int x = 0;x < result.length;x++){
	            all.add(result[x]);
	        }
	        if (all.size() > 0){
	                super.print(response,this.zhuanyeService.delete(all));
	        }else{
	            super.print(response,"false"); // 删除数据不成功返回false
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    }

	    @RequestMapping(value = "zhuanye_update")
	    public void update(HttpServletResponse response ,Zhuanye vo){
	        try {
	            super.print(response,this.zhuanyeService.update(vo));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @RequestMapping(value = "zhuanye_list")
	    public void list(HttpServletRequest request, HttpServletResponse response){
	        super.handSplit(request,response);
	        try {
	            Map<String,Object> map = this.zhuanyeService.listSplit(super.getCurrentPage(),super.getLineSize());
	            List<Zhuanye> all = (List<Zhuanye>) map.get("allZhuanye");
	            Integer allRecorders = (Integer) map.get("zhuanyeCount");
	            super.printObjectToListSplit(response,"allZhuanye",all,allRecorders);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    @RequestMapping (value = "zhuanye_insert")
	    public ModelAndView insert(Zhuanye vo){
	        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
	        try {
	            if (this.zhuanyeService.insert(vo)){ // 表示数据增加成功
	                super.setMsgAndPath(mav,"zhuanye.insert.success","zhuanye.login.success");
	            }else{  // 表示数据增加失败
	                super.setMsgAndPath(mav,"zhuanye.insert.failure","zhuanye.login.failure");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return mav;
	    }
	 
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "专业";
	}

}
