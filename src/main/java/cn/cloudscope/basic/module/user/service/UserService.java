package cn.cloudscope.basic.module.user.service;


import cn.cloudscope.basic.bean.po.User;

import java.util.List;

/**
 * userService 接口
 * @author wupanhua
 * @date 18-7-3 下午2:34
 */
public interface UserService {

    /**
     * 根据用户名和密码查找用户
     * @param user
     * @return
     * @throws Exception
     * @author wupanhua
     */
    User findUserByUserIdAndPassword(User user) throws Exception;

    /**
     * find all user without paging
     * @return
     * @throws Exception
     * @author wupanhua
     */
    List<User> findAllUser() throws Exception;

    /**
     * 根据用户昵称和密码查找用户
     * @param user
     * @return 查找到的用户
     * @author wupanhua
     */
    User findUserIdAndPassword(User user) throws Exception;

    /**
     * 根据用户邮箱和密码查找到用户
     * @param user
     * @return 查找到的用户
     * @autor wupanhua
     */
    User findUserByEamilAndPassword(User user);
}
