package cn.ylcto.student.action;

import cn.ylcto.student.service.IAdminService;
import cn.ylcto.student.vo.Admin;
import cn.ylcto.util.MD5Code;
import cn.ylcto.util.action.DefaultAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping(value = "/pages/back/*")
public class AdminLoginAction extends DefaultAction {
    @Resource
    private IAdminService adminService;

    @RequestMapping(value = "admin_login")
    public ModelAndView login(HttpServletRequest request,Admin admin){
        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
        try {
            // 实现登录密码加盐操作
            admin.setPassword(new MD5Code().getMD5ofStr(admin.getPassword()+admin.getEmail()));
            Admin vo = this.adminService.login(admin); // 登录成功后还要取得最后一次登录日期
            if (vo != null){
                super.setMsgAndPath(mav,"admin.insert.success","admin.login.success");
                request.getSession().setAttribute("email",vo.getEmail());
                request.getSession().setAttribute("lastdate",new SimpleDateFormat("yyyy-MM-dd").format(vo.getLastdate())); // 取得最后一次登录日期操作
            }else{
                super.setMsgAndPath(mav,"admin.insert.failure","admin.login.failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping(value = "admin_logout")
    public ModelAndView logout(HttpServletRequest request){
        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
        request.getSession().invalidate(); // 表示session失效
        super.setMsgAndPath(mav,"admin.logout.success","admin.logout.failure");
        return mav;
    }
    @Override
    public String getText() {
        return "管理员";
    }
}
