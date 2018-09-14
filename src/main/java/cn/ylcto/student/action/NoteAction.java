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

import cn.ylcto.student.service.INoteService;
import cn.ylcto.student.vo.Note;
import cn.ylcto.util.action.DefaultAction;
@Controller
@RequestMapping(value = "/pages/back/note/*")
public class NoteAction  extends DefaultAction{
	@Resource
	private INoteService noteService;
	@RequestMapping(value = "note_findByName")
	public void findByName(HttpServletResponse response,HttpServletRequest request,@RequestParam String keyword){
		String temp = request.getParameter("keyword");
		List<Note> notes = new ArrayList<>();
		try {
			notes = this.noteService.findByName(keyword);
			Integer count = notes.size();
			super.printObjectToListSplit(response, "allNote", notes, count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "note_delete")
    public void delete(HttpServletResponse response,HttpServletRequest request){
       try{
        String result [] = request.getParameter("ids").split("\\|");
        List<String> all = new ArrayList<>();
        for (int x = 0;x < result.length;x++){
            all.add(result[x]);
        }
        if (all.size() > 0){
                super.print(response,this.noteService.delete(all));
        }else{
            super.print(response,"false"); // 删除数据不成功返回false
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
	@RequestMapping(value = "note_update")
    public void update(HttpServletResponse response ,Note vo){
        try {
            super.print(response,this.noteService.update(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@RequestMapping(value = "note_list")
	public void list(HttpServletRequest request, HttpServletResponse response){
        super.handSplit(request,response);
        try {
            Map<String,Object> map = this.noteService.listSplit(super.getCurrentPage(),super.getLineSize());
            List<Note> all = (List<Note>) map.get("allNote");
            Integer allRecorders = (Integer) map.get("noteCount");
            super.printObjectToListSplit(response,"allNote",all,allRecorders);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	@RequestMapping(value = "note_insert")
	public ModelAndView insert(Note vo){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			if (this.noteService.insert(vo)){
			    super.setMsgAndPath(mav,"note.insert.success","note.login.success");
			}else{
			    super.setMsgAndPath(mav,"note.insert.failure","note.login.failure");
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
		return "标记";
	}

}
