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


import cn.ylcto.student.service.ITeacherService;
import cn.ylcto.student.vo.Teacher;
import cn.ylcto.util.action.DefaultAction;
@Controller
@RequestMapping(value = "/pages/back/teacher/*")
public class TeacherAction  extends DefaultAction {
	@Resource
	private ITeacherService teacherService;
	
	@RequestMapping(value = "teacher_findByName")
	public void findByName(HttpServletResponse response,HttpServletRequest request,@RequestParam(value="keyword",required=false) String keyword){
		String temp = request.getParameter("keyword");
		List<Teacher> teachers = new ArrayList<>();
		try {
			teachers = this.teacherService.findByName(keyword);
			Integer count = teachers.size();
			super.printObjectToListSplit(response, "allTeacher", teachers, count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "teacher_delete")
    public void delete(HttpServletResponse response,HttpServletRequest request){
       try{
        String result [] = request.getParameter("ids").split("\\|");
        List<String> all = new ArrayList<>();
        for (int x = 0;x < result.length;x++){
            all.add(result[x]);
        }
        if (all.size() > 0){
                super.print(response,this.teacherService.delete(all));
        }else{
            super.print(response,"false"); // 删除数据不成功返回false
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
	@RequestMapping(value = "teacher_update")
    public void update(HttpServletResponse response ,Teacher vo){
        try {
            super.print(response,this.teacherService.update(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@RequestMapping(value = "teacher_list")
	public void list(HttpServletRequest request, HttpServletResponse response){
        super.handSplit(request,response);
        try {
            Map<String,Object> map = this.teacherService.listSplit(super.getCurrentPage(),super.getLineSize());
            List<Teacher> all = (List<Teacher>) map.get("allTeacher");
            Integer allRecorders = (Integer) map.get("teacherCount");
            super.printObjectToListSplit(response,"allTeacher",all,allRecorders);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	@RequestMapping(value = "teacher_insert")
	public ModelAndView insert(Teacher vo){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			if (this.teacherService.insert(vo)){
			    super.setMsgAndPath(mav,"teacher.insert.success","teacher.login.success");
			}else{
			    super.setMsgAndPath(mav,"teacher.insert.failure","teacher.login.failure");
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
		return "教师";
	}

}
