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

import cn.ylcto.student.service.IBiyeService;
import cn.ylcto.student.service.IXueyuanService;
import cn.ylcto.student.vo.Biye;
import cn.ylcto.student.vo.Xueyuan;
import cn.ylcto.util.action.DefaultAction;
@Controller
@RequestMapping(value = "/pages/back/biye/*")
public class BiyeAction extends DefaultAction{
	
	@Resource
	private IBiyeService biyeService;
	@RequestMapping(value = "biye_findByName")
	public void findByName(HttpServletResponse response,HttpServletRequest request,@RequestParam String keyword){
		String temp = request.getParameter("keyword");
		List<Biye> biyes = new ArrayList<>();
		try {
			biyes = this.biyeService.findByName(keyword);
			Integer count = biyes.size();
			super.printObjectToListSplit(response, "allNote", biyes, count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "biye_delete")
    public void delete(HttpServletResponse response,HttpServletRequest request){
       try{
        String result [] = request.getParameter("ids").split("\\|");
        List<String> all = new ArrayList<>();
        for (int x = 0;x < result.length;x++){
            all.add(result[x]);
        }
        if (all.size() > 0){
                super.print(response,this.biyeService.delete(all));
        }else{
            super.print(response,"false"); // 删除数据不成功返回false
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
	
	@RequestMapping(value = "biye_update")
    public void update(HttpServletResponse response ,Biye vo){
        try {
            super.print(response,this.biyeService.update(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
	@RequestMapping(value = "biye_list")
	public void list(HttpServletRequest request, HttpServletResponse response){
        super.handSplit(request,response);
        try {
            Map<String,Object> map = this.biyeService.listSplit(super.getCurrentPage(),super.getLineSize());
            List<Biye> all = (List<Biye>) map.get("allBiye");
            Integer allRecorders = (Integer) map.get("biyeCount");
            super.printObjectToListSplit(response,"allBiye",all,allRecorders);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@RequestMapping(value = "biye_insert")
	public ModelAndView insert(Biye vo){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			if (this.biyeService.insert(vo)){
			    super.setMsgAndPath(mav,"biye.insert.success","biye.login.success");
			}else{
			    super.setMsgAndPath(mav,"biye.insert.failure","biye.login.failure");
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
		return "毕业要求";
	}

}
