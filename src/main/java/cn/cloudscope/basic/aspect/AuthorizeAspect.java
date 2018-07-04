package cn.cloudscope.basic.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * AOP 权限检验
 * @author wupanhua
 * @date 2018-07-02
 */
@Aspect
@Component
public class AuthorizeAspect {

    /**
     * 定义拦截规则： 拦截Controller层所有带RequestMapping注解的方法
     * @author wupanhua
     * @date 2018-07-02 15:31
     */
    @Pointcut("execution(public * cn.cloudscope.*.module.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void authorize(){}


    /**
     * 拦截规则具体实现
     * @author wupanhua
     * @date 2018-07-02 15:35
     */
    @Before("authorize()")
    public void  AuthorizeRequest() {

        // 1. 判断当前用户是否已经登录

        // 2. 判断当前用户是否有访问该链接的权限

    }


}
