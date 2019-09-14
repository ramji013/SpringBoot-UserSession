package com.fse.controller;

import com.fse.entity.User;
import com.fse.pojo.UserBean;
import com.fse.pojo.UserSession;
import com.fse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSession session;


    @ModelAttribute("user")
    public UserBean userLoginDto() {
        return new UserBean();
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("login", new UserBean());
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") @Valid UserBean userDto){
        System.out.println("######################## " + userDto.getUserName());
        User existing = userService.findByUserName(userDto.getUserName());
        ModelAndView modelAndView = null;
        if(existing!=null)
            if("ADMIN".equalsIgnoreCase(existing.getRoles().getRole())){
                modelAndView = new ModelAndView("/admin");
            }else if("USER".equalsIgnoreCase(existing.getRoles().getRole())){
                modelAndView = new ModelAndView("/user");
            }else{
                modelAndView = new ModelAndView("/403");
            }
        modelAndView.addObject("userDetail", existing);
        return modelAndView;
    }
}
