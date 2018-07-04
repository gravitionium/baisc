package cn.cloudscope.basic.module.user.controller;

import cn.cloudscope.basic.bean.po.User;
import cn.cloudscope.basic.bean.vo.JsonResult;
import cn.cloudscope.basic.emum.LoginStatus;
import cn.cloudscope.basic.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * UserController
 * @author wupanhua
 * @date 18-7-3 下午12:03
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

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
     * @param user
     * @return
     * @throws Exception
     * @author wupanhua
     */
    @PostMapping("findByUserId")
    public JsonResult loginByUserId(User user) throws Exception {

        user = userService.findUserIdAndPassword(user);

        if (user == null) {
            return JsonResult.getInstent(LoginStatus.FAIL.getCode(), LoginStatus.FAIL.getMsg());
        }

        // 再获取到用户的角色放入session

        // 返回数据
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

        if (user == null) {
            return JsonResult.getInstent(LoginStatus.FAIL.getCode(), LoginStatus.FAIL.getMsg());
        }

        // 再获取到用户的角色放入session

        // 返回数据
        return JsonResult.getInstent(LoginStatus.SUCCESS.getCode(), LoginStatus.SUCCESS.getMsg());
    }

}
