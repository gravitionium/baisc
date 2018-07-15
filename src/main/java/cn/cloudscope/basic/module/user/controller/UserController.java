package cn.cloudscope.basic.module.user.controller;

import cn.cloudscope.basic.bean.po.User;
import cn.cloudscope.basic.bean.vo.JsonResult;
import cn.cloudscope.basic.bean.vo.LoginVo;
import cn.cloudscope.basic.emum.ConstEnum;
import cn.cloudscope.basic.emum.LoginStatus;
import cn.cloudscope.basic.exception.ValidException;
import cn.cloudscope.basic.module.role.service.RoleService;
import cn.cloudscope.basic.module.user.service.UserService;
import cn.cloudscope.basic.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;


/**
 * UserController
 * @author wupanhua
 * @date 18-7-3 下午12:03
 */
@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 获得所有用户
     * @return
     * @throws Exception
     * @author wupanhua
     */
    @GetMapping("findAllUser")
    public List<User> findAllUser() throws Exception {
        return userService.findAllUser();
    }

    /**
     * 使用账户名和密码登录
     * @param loginVo
     * @return
     * @throws Exception
     * @author wupanhua
     */
    @PostMapping("findByUserId")
    public JsonResult loginByUserId(@RequestBody @Valid LoginVo loginVo, BindingResult bindingResult, HttpSession session) throws Exception {

        if (bindingResult.hasErrors()) {
            throw new ValidException(bindingResult.getAllErrors(), LoginStatus.VALID.getCode(), LoginStatus.VALID.getMsg());
        }

        User user = new User();
        BeanUtils.copyProperties(loginVo, user);
        user = userService.loginByUserIdAndPassword(user);

        // 将带有角色的用户存入session
        session.setAttribute(ConstEnum.SESSIONUSER.getNickName(), user);
        log.info("用户: {} ,在 {} 登录成功", user.getUserId(), DateUtil.getFullStringDate(new Date()));

        return JsonResult.getInstent(LoginStatus.SUCCESS.getCode(), LoginStatus.SUCCESS.getMsg());
    }

    /**
     * 使用邮件和密码登录
     * @param user
     * @return
     * @throws Exception
     * @author wupanhua
     */
    @PostMapping("findByEmail")
    public JsonResult<User> loginByUserEmail(User user) throws Exception {

        user = userService.findUserByEamilAndPassword(user);

        // 返回数据
        return JsonResult.getInstent(LoginStatus.SUCCESS.getCode(), LoginStatus.SUCCESS.getMsg());
    }

    /**
     * 登录系统
     * @param session
     * @return
     * @throws Exception
     * @author wupanhua
     */
    @GetMapping("logout")
    public JsonResult<User> logout(HttpSession session) throws Exception {
        User user = (User)session.getAttribute(ConstEnum.SESSIONUSER.getNickName());
        if (user != null) {
            log.info("用户: {} , 在 {} 登出系统", user.getUserId(), DateUtil.getFullStringDate(new Date()));
            session.removeAttribute(ConstEnum.SESSIONUSER.getNickName());
        }
        return JsonResult.getInstent(LoginStatus.LOGOUT.getCode(), LoginStatus.LOGOUT.getMsg());
    }

}
