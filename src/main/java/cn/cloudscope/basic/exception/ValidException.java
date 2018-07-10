package cn.cloudscope.basic.exception;

import cn.cloudscope.basic.emum.LoginStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author wupanhua
 * @date 18-7-9
 */
@Slf4j
public class ValidException extends RuntimeException {

    private Integer code;

    public ValidException() {
        super();
    }

    public ValidException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ValidException(List<ObjectError> allErrors, Integer code, String message) {

        super(message);

        for (ObjectError error: allErrors) {
            log.error("校验信息:{}", error.getDefaultMessage());
        }
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
