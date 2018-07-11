package cn.cloudscope.basic.bean.po;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户关联角色实体类
 * @author wupanhua
 * @date 18-07-11
 */
@Data
public class UserUnionRole implements Serializable {

    // 主键
    private String id;
    // 用户主键
    private String userId;
    // 角色主键
    private String roleId;

    public UserUnionRole() {
    }

    public UserUnionRole(String id, String userId, String roleId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
    }
}
