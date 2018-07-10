package cn.cloudscope.basic.module.user.service.impl;

import cn.cloudscope.basic.bean.po.User;
import cn.cloudscope.basic.emum.LoginStatus;
import cn.cloudscope.basic.exception.UserException;
import cn.cloudscope.basic.module.user.mapper.UserMapper;
import cn.cloudscope.basic.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wupanhua
 * @date 18-7-3 下午2:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名和密码查找用户
     * @param user 待查询
     * @return 查询结果
     * @throws Exception
     * @author wupanhua
     */
    @Override
    public User findUserByUserIdAndPassword(User user) throws Exception {
        return userMapper.findUserByUserIdAndPassword(user);
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
