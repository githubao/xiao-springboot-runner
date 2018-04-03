package org.xiao.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiao.springboot.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户 service
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/3 19:55
 */

@Service
public class UserService {

    private static final Map<Long, User> userMap = new HashMap<>();

    static {
        userMap.put(1L, new User(1L, "xiao"));
    }

    public User getUser(Long id) {
        return userMap.getOrDefault(id, null);
    }

    public User saveUser(Long id) {
        userMap.put(id, new User(id, "new add"));
        return userMap.get(id);
    }
}
