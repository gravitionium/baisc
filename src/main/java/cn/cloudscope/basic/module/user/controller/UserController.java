package cn.cloudscope.basic.module.user.controller;

import cn.cloudscope.basic.bean.po.User;
import cn.cloudscope.basic.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * UserController
 * @author wupanhua
 * @date 18-7-3 下午12:03
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findAllUser")
    public List<User> findAllUser() throws Exception {
        return userService.findAllUser();
    }

}
