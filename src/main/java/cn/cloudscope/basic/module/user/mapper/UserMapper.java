package cn.cloudscope.basic.module.user.mapper;


import cn.cloudscope.basic.bean.po.User;

import java.util.List;

/**
 * @author wupanhua
 * @date 18-7-3 下午5:32
 */
public interface UserMapper {

    User findUserByUserIdAndPassword(User user);

    List<User> findAllUser();
}
