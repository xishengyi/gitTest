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

import cn.ylcto.student.service.ICourseService;
import cn.ylcto.student.vo.Course;
import cn.ylcto.util.action.DefaultAction;
@Controller
@RequestMapping(value = "/pages/back/course/*")
public class CourseAction extends DefaultAction {
	@Resource
	private ICourseService courseService;
	@RequestMapping(value = "course_findByName")
	public void findByName(HttpServletResponse response,HttpServletRequest request,@RequestParam String keyword){
		String temp = request.getParameter("keyword");
		List<Course> course = new ArrayList<>();
		try {
			course = this.courseService.findByName(keyword);
			Integer count = course.size();
			super.printObjectToListSplit(response, "allCourse", course, count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "course_delete")
    public void delete(HttpServletResponse response,HttpServletRequest request){
       try{
        String result [] = request.getParameter("ids").split("\\|");
        List<String> all = new ArrayList<>();
        for (int x = 0;x < result.length;x++){
            all.add(result[x]);
        }
        if (all.size() > 0){
                super.print(response,this.courseService.delete(all));
        }else{
            super.print(response,"false"); // 删除数据不成功返回false
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
	@RequestMapping(value = "course_update")
    public void update(HttpServletResponse response ,Course vo){
        try {
            super.print(response,this.courseService.update(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@RequestMapping(value = "course_list")
	public void list(HttpServletRequest request, HttpServletResponse response){
        super.handSplit(request,response);
        try {
            Map<String,Object> map = this.courseService.listSplit(super.getCurrentPage(),super.getLineSize());
            List<Course> all = (List<Course>) map.get("allCourse");
            Integer allRecorders = (Integer) map.get("courseCount");
            super.printObjectToListSplit(response,"allCourse",all,allRecorders);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	@RequestMapping(value = "course_insert")
	public ModelAndView insert(Course vo){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			if (this.courseService.insert(vo)){
			    super.setMsgAndPath(mav,"course.insert.success","course.login.success");
			}else{
			    super.setMsgAndPath(mav,"course.insert.failure","course.login.failure");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}
	
//	@RequestMapping(value = "course_insert")
//	public ModelAndView insert(Course vo){
//		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
//		try {
//			if (this.courseService.insert(vo)){
//			    super.setMsgAndPath(mav,"course.insert.success","course.login.success");
//			}else{
//			    super.setMsgAndPath(mav,"course.insert.failure","course.login.failure");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return mav;
//	}
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "课程";
	}

}
