package cn.cloudscope.basic.bean.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * Created by wupanhua on 2018/7/10.
 */
@Data
public class LoginVo {

    // 账户
    @NotEmpty(message = "账户不能为空")
    @Length(min = 6, max = 12, message = "账户名的标准长度为6-12位")
    private String userId;

    // 密码
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 12, message = "密码的标准长度为6-12位")
    private String password;

    public LoginVo() {
    }

    public LoginVo(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
