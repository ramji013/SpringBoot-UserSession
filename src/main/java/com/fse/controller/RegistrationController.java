package com.fse.controller;

import com.fse.entity.User;
import com.fse.pojo.UserBean;
import com.fse.pojo.UserSession;
import com.fse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSession session;

    @ModelAttribute("user")
    public UserBean userRegistrationDto() {
        return new UserBean();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registration", new UserBean());
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserBean userDto, BindingResult bindingResult) {

        if(session.getCaptcha() != userDto.getCaptcha()){
            bindingResult.rejectValue("captcha", "Captcha matching failed");
          // bindingResult.r
           // return new ModelAndView("registration");
        }
        User existing = userService.findByUserName(userDto.getUserName());
        if (existing != null) {
           // result.rejectValue("email", null, "There is already an account registered with that email");
            System.out.println(" user exists");
        }

        /*if (result.hasErrors()) {
            return "registration";
        }*/
        System.out.println("%%%%%%%%%%%%%%%%%%%%%% "+ userDto.getUserName());
        System.out.println(userDto.getPassword());
        userService.saveOrUpdate(userDto);
        ModelAndView modelAndView = new ModelAndView("/user");
        modelAndView.addObject("name", userDto.getUserName());
        return modelAndView;
    }

}
