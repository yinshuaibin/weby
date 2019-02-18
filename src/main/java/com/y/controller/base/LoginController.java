package com.y.controller.base;

import com.y.bean.User;
import com.y.exception.Yexception;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController extends BaseController {


    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody User user){
        Map<String,Object> resultMap = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassWord());
        try {
            subject.login(token);
            resultMap.put("token", subject.getSession().getId());
            resultMap.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            resultMap.put("msg", "密码错误");
        } catch (Yexception e) {
            resultMap.put("msg", "登录失败，这是个自定义异常");
        } catch (AuthenticationException e) {
            resultMap.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * 未登录请求
     * @return
     */
    @RequestMapping("/loginSuccess")
    public Map<String,Object> loginSuccess(){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg","您尚未登录,请登录");
        resultMap.put("code","1000");
        return resultMap;
    }
}
