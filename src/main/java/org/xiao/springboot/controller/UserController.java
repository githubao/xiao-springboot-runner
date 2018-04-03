package org.xiao.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.xiao.springboot.entity.User;
import org.xiao.springboot.service.UserService;

/**
 * 用户类
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/3 19:54
 */

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}.html")
    public ModelAndView getUser(@PathVariable Long id, ModelAndView view) {
        Integer.parseInt("sd");

        User user = userService.getUser(id);
        view.addObject(user);
        view.setViewName("/user");
        return view;
    }

    @PostMapping("/{id}.html")
    public RedirectView getUser(@PathVariable Long id) {
        userService.saveUser(id);
        return new RedirectView(String.format("%s.html", id));
    }

}
