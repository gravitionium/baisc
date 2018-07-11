package cn.cloudscope.basic.bean.po;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wupanhua on 2018/7/10.
 */
@Data
public class Role implements Serializable{

    // 角色主键
    private String id;
    // 角色名称
    private String name;

    public Role() {
    }

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
