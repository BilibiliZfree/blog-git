package com.may.controller.userController;

import com.may.model.UserInfo;
import com.may.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author 紫枫伊
 * @since : 2021/6/24 15:27
 * @code : updateTime 2021/6/28 10:31
 * @code : description 注册控制器
 */
@Controller
@RequestMapping("/user")
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }


/**
 * @author : 紫枫伊
 * @since : 2021/6/28 10:44
 * @code : updateTime 2021/6/28 10:44
 * @code : descriptions 注册提交
 */
    @PostMapping("/register")
    public String register(@RequestParam("account") String account,@RequestParam("password") String password,
                           @RequestParam("email") String email,@RequestParam("telephone") String telephone,
                           HttpSession session){
        UserInfo newUser = new UserInfo();
        newUser.setAccount(account);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setTelephone(telephone);
        userService.User_saveNewUser(newUser);
        newUser.setPassword(null);
        session.setAttribute("user",newUser);
        return "/blog/blog";
    }
}
