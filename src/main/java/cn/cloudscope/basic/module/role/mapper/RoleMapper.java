package cn.cloudscope.basic.module.role.mapper;

import cn.cloudscope.basic.bean.po.Role;

import java.util.List;

/**
 * Created by wupanhua on 2018/7/11.
 */
public interface RoleMapper {

    /**
     * 根据用户名获取角色列表
     * @param id
     * @return
     * @author wupanhua
     * @date 18-07-11
     */
    List<Role> findRolesByUserKey(Integer id);
}
