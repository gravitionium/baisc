package cn.cloudscope.basic.module.user.service.impl;

import cn.cloudscope.basic.bean.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wupanhua on 2018/7/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testUserService() throws Exception {

        User user = new User();
        user.setUserId("wupanhua");
        user.setPassword("123456");
        user = userService.findUserByUserIdAndPassword(user);

    }

}