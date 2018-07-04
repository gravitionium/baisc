package cn.cloudscope.basic.bean.po;

import lombok.Data;

import java.util.Date;

/**
 * @author wupanhua
 * @date 18-7-3 下午2:57
 */
@Data
public class User {

    /** 主键 */
    private Integer id;
    /** 用户昵称 */
    private String userId;
    /** 密码 */
    private String password;
    /** 用户姓名 */
    private String username;
    /** 性别 */
    private String gender;
    /** 电子邮箱 */
    private String email;
    /** 移动电话 */
    private String mobilephone;
    /** 电话 */
    private String telephone;
    /** 职位 */
    private String job;
    /** 用户组主键(可以是部门，公司) */
    private String groupId;
    /** 账户类型：1：普通用户，2：VIP用户，3：超级管理员 */
    private Integer type;
    /** 账户状态：0：禁用，1：启用，2：邮箱未验证，3：手机号未验证 */
    private Integer status;
    /** 最后一次登录时间 */
    private Date lastLoginDate;
    /** 创建时间 */
    private Date createDate;
    /** 更新时间 */
    private Date updateDate;

    public User() {
    }

    public User(Integer id, String userId, String password, String username, String gender, String email, String mobilephone, String telephone, String job, String groupId, Integer type, Integer status, Date lastLoginDate, Date createDate, Date updateDate) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.mobilephone = mobilephone;
        this.telephone = telephone;
        this.job = job;
        this.groupId = groupId;
        this.type = type;
        this.status = status;
        this.lastLoginDate = lastLoginDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
