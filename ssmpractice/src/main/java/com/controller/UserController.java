package com.controller;

import com.domain.Result;
import com.domain.User;
import com.service.ResultService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
/**
 * 跳转到登录页面
 */
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 跳转到抽奖页面
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        List<Result> result = resultService.find(userId);
//        判断次数

        modelAndView.addObject("result", result);
        modelAndView.setViewName("user_index");
        return modelAndView;
    }

    //    登录方法
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpSession session) {
        User userResult = userService.findByUsernameAndPassword(user);
        if (userResult != null) {
            session.setAttribute("user", userResult);
            return "redirect:/user/index";
        } else {
            return "login";
        }
    }

    //    抽奖存储
    @Autowired
    private ResultService resultService;
    @ResponseBody
    @RequestMapping(value = "/lucky", method = RequestMethod.POST)
    public Object login(String prize, HttpSession session) {
        User user = (User) session.getAttribute("user");
//        通过查询数据库中的数据来判断抽奖的次数
        List<Result> results = resultService.find(user.getId());
        if (results.size() > 4) {
            System.out.println("抽奖次数已过");
        return "fail";
        }

        Result result = new Result();
        result.setPrize(prize);
        result.setUserId(user.getId());
        resultService.add(result);
        return "success";
    }

}
