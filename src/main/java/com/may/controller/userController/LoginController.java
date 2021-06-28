package com.may.controller.userController;

import com.may.model.UserInfo;
import com.may.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author 紫枫伊
 * @since : createTime 2021-6-24 15:20
 * @code : updateTime 2021-6-28 10:33
 * @code : description: 验证用户登陆控制器
 */
@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @author 紫枫伊
     * @since : 2021/6/28 10:34
     * @code : updateTime 2021/6/28 10:34
     * @code : description: 登陆验证
     */
    @RequestMapping("/user/login")
        public String login(@RequestParam("account") String account,
                            @RequestParam("password") String password,
                            HttpSession session,
                            Model model){
        UserInfo user = userService.User_ChkLogin(account,password);
        if (user != null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "redirect:/home";
        }else{
            model.addAttribute("aaa","bbb");
            return "redirect:/index.html";
        }
    }


    @GetMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }


}
