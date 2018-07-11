package cn.cloudscope.basic.module.role.service.impl;

import cn.cloudscope.basic.bean.po.Role;
import cn.cloudscope.basic.module.role.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wupanhua on 2018/7/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testFindRolesByUserKey() throws Exception {

        List<Role> roleList = roleService.findRolesByUserKey(12);

        for (Role role: roleList) {
            System.out.println(role.getName());
        }

    }
}