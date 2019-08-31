package com.controller;

import com.domain.User;
import com.servie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/find")
    public ModelAndView find() {
        ModelAndView modelAndView=new ModelAndView();
        User user = userService.findById(1);
        modelAndView.setViewName("test");
        modelAndView.addObject("user",user );
        return modelAndView;
    }
}
