package cn.cloudscope.basic.module.user.service.impl;

import cn.cloudscope.basic.bean.po.Role;
import cn.cloudscope.basic.bean.po.User;
import cn.cloudscope.basic.emum.LoginStatus;
import cn.cloudscope.basic.exception.LoginException;
import cn.cloudscope.basic.module.role.mapper.RoleMapper;
import cn.cloudscope.basic.module.user.mapper.UserMapper;
import cn.cloudscope.basic.module.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author wupanhua
 * @date 18-7-3 下午2:35
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据用户名和密码查找用户
     * @param user 待查询
     * @return 查询结果
     * @throws Exception
     * @author wupanhua
     */
    @Override
    public User loginByUserIdAndPassword(User user) throws Exception {

        // 是否存在此用户
        user = userMapper.findUserByUserIdAndPassword(user);
        if (user == null) {
            throw new LoginException(LoginStatus.FAIL);
        }

        // 该用户名下是否有角色
        List<Role> roles = roleMapper.findRolesByUserKey(user.getId());
        if (roles == null || roles.isEmpty()) {
            log.error("登录用户: {} ,名下无角色", user.getUsername());
            throw new LoginException(LoginStatus.NOROLE);
        }
        user.setRoleArrayList(roles);

        // 更新用户登录时间
        user.setLastLoginDate(new Date());
        userMapper.updateLastLoginDate(user);

        return user;
    }

    /**
     * find all user without paging
     * @return
     * @throws Exception
     * @author wupanhua
     */
    @Override
    public List<User> findAllUser() throws Exception {
        return userMapper.findAllUser();
    }

    /**
     * 根据用户邮箱和密码查找到用户
     * @param user
     * @return 查找到的用户
     * @autor wupanhua
     */
    @Override
    public User findUserByEamilAndPassword(User user) {
        return userMapper.findUserByEmailAndPassword(user);
    }
}
