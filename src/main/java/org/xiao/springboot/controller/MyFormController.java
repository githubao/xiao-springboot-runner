package org.xiao.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * 自定义数据绑定的格式
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/3 17:51
 */

@Controller
@RequestMapping("/data-binding")
public class MyFormController {

    @ResponseBody
    @RequestMapping("/date")
    public String getDate(@RequestParam("d") LocalDateTime d) {
        return "received: " + d;
    }

    @ResponseBody
    @RequestMapping("/date2")
    public String getDate(@RequestParam("d") Long d) {
        return "received: " + d;
    }
}
