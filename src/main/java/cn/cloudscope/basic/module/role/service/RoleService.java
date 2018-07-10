package cn.cloudscope.basic.module.role.service;

import cn.cloudscope.basic.bean.po.Role;

import java.util.List;

/**
 * Created by wupanhua on 2018/7/10.
 */
public interface RoleService {

    /**
     * 根据用户主键找到角色
     * @param id
     * @return
     */
    List<Role> findRolesByUserKey(Integer id);
}
