package cn.cloudscope.basic.emum;

/**
 * 登录状态
 * @author wupanhua
 */
public enum LoginStatus {

    SUCCESS(200, "登录成功"),
    FAIL(400, "账户或密码错误")
    ;

    // 状态码
    private Integer code;
    // 信息
    private String msg;

    LoginStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
