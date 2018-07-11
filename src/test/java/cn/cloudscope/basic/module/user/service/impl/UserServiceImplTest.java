package cn.cloudscope.basic.module.user.service.impl;

import cn.cloudscope.basic.bean.po.User;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testUserService() throws Exception {

        User user = new User();
        user.setUserId("wupanhua");
        user.setPassword("156");
        user = userService.loginByUserIdAndPassword(user);

        log.debug("获取到用户:{}", user.getUserId());
        log.error("获取到用户:{}", user.getUserId());

    }

}