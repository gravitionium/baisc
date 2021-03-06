package cn.cloudscope.basic.handler;

import cn.cloudscope.basic.bean.vo.JsonResult;
import cn.cloudscope.basic.exception.LoginException;
import cn.cloudscope.basic.exception.ValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wupanhua
 * @date 18-07-09
 */
@ControllerAdvice
public class ExceptionCenter {

    @ExceptionHandler(value = LoginException.class)
    @ResponseBody
    public JsonResult handler(LoginException e) {
        return JsonResult.getInstent(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = ValidException.class)
    @ResponseBody
    public JsonResult handler(ValidException e) {
        return JsonResult.getInstent(e.getCode(), e.getMessage());
    }
}
