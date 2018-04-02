package org.xiao.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xiao.springboot.aop.Function;

/**
 * 控制器
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/2 17:25
 */

@RestController
//@Controller
public class XiaoController {

//    @Function("private")
    @Function("public")
    @RequestMapping("/hello")
    @ResponseBody
    public String quake(String name) {
        return "hello, " + name;
    }

}
