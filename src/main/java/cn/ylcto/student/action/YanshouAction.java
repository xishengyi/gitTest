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

import cn.ylcto.student.service.IYanshouService;

import cn.ylcto.student.vo.Yanshou;

import cn.ylcto.util.action.DefaultAction;
@Controller
@RequestMapping(value = "/pages/back/yanshou/*")
public class YanshouAction extends DefaultAction{
	@Resource
    private IYanshouService yanshouService;
	
	@RequestMapping(value = "yanshou_delete")
    public void delete(HttpServletResponse response,HttpServletRequest request){
       try{
        String result [] = request.getParameter("ids").split("\\|");
        List<String> all = new ArrayList<>();
        for (int x = 0;x < result.length;x++){
            all.add(result[x]);
        }
        if (all.size() > 0){
                super.print(response,this.yanshouService.delete(all));
        }else{
            super.print(response,"false"); // 删除数据不成功返回false
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @RequestMapping(value = "yanshou_update")
    public void update(HttpServletResponse response ,Yanshou vo){
        try {
            super.print(response,this.yanshouService.update(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "yanshou_list")
    public void list(HttpServletRequest request, HttpServletResponse response){
        super.handSplit(request,response);
        try {
            Map<String,Object> map = this.yanshouService.listSplit(super.getCurrentPage(),super.getLineSize());
            List<Yanshou> all = (List<Yanshou>) map.get("allYanshou");
            Integer allRecorders = (Integer) map.get("yanshouCount");
            super.printObjectToListSplit(response,"allYanshou",all,allRecorders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping (value = "yanshou_insert")
    public ModelAndView insert(Yanshou vo){
        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
        try {
            if (this.yanshouService.insert(vo)){ // 表示数据增加成功
                super.setMsgAndPath(mav,"yanshou.insert.success","yanshou.login.success");
            }else{  // 表示数据增加失败
                super.setMsgAndPath(mav,"yanshou.insert.failure","yanshou.login.failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
	
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "验收标准";
	}

}
