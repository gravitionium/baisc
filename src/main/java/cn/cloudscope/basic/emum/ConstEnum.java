package cn.cloudscope.basic.emum;

/**
 * Created by wupanhua on 2018/7/10.
 */
public enum ConstEnum {

    SESSIONUSER("USER", "存在session中的用户key"),
    SESSIONROLE("ROLE", "存在session中的角色key")
    ;

    // 简称
    private String nickName;
    // 描述
    private String descript;

    ConstEnum() {
    }

    ConstEnum(String nickName, String descript) {
        this.nickName = nickName;
        this.descript = descript;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
