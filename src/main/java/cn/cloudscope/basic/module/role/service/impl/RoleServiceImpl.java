package cn.cloudscope.basic.module.role.service.impl;

import cn.cloudscope.basic.bean.po.Role;
import cn.cloudscope.basic.module.role.mapper.RoleMapper;
import cn.cloudscope.basic.module.role.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wupanhua on 2018/7/10.
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据用户主键获取角色列表
     * @param id
     * @return list 角色列表
     * @author wupanhua
     * @date 18-07-11
     */
    @Override
    public List<Role> findRolesByUserKey(Integer id) {
        List<Role> roles = roleMapper.findRolesByUserKey(id);
        return roles;
    }
}
