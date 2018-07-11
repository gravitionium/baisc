package cn.cloudscope.basic.exception;

import cn.cloudscope.basic.emum.LoginStatus;

/**
 * @author wupanhua
 * @date 18-7-9
 */
public class LoginException extends RuntimeException {

    private Integer code;

    public LoginException() {
        super();
    }

    public LoginException(LoginStatus fail) {
        super(fail.getMsg());
        this.code = fail.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
