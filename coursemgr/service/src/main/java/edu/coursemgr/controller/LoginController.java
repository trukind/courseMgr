package edu.coursemgr.controller;

import edu.coursemgr.model.User;
import edu.coursemgr.service.interfaces.LoginService;
import edu.coursemgr.common.Constant;
import edu.coursemgr.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value="/login", method=RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody Map<String, Object> requestMap) throws Exception {
        // 校验验证码
        String code = getParam(requestMap, "verificationCode");
        String sessionCode = findSession(Constant.SessionKey.SESSION_KEY_OF_RAND_CODE);

        boolean illegal = code == null || code.isEmpty()
                || !code.toUpperCase().equals(sessionCode.toUpperCase());
        if (illegal) {
            throw new Exception("验证码输入有误");
        }
        String serialNo = getParam(requestMap,"username");
        String password = getParam(requestMap,"password");
        String role = getParam(requestMap,"role");
        return customResponse("token", loginService.login(serialNo, password, role));
    }

    @RequestMapping(value="/getUserInfo", method=RequestMethod.POST)
    @ResponseBody
    public Object getUserInfo(@RequestBody Map<String, Object> requestMap) throws Exception {
        String serialNo = getParam(requestMap, "serialNo");
        return loginService.getUserInfo(serialNo);
    }

    @RequestMapping(value="/getRoleList", method=RequestMethod.GET)
    @ResponseBody
    public Object getRoleList() throws Exception {
        return loginService.getRoleList();
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    @ResponseBody
    public Object update(@RequestBody User userInfo) throws Exception {
        if (CommonUtils.isEmpty(userInfo.getName())) {
            throw new Exception("姓名不能为空");
        }
        return loginService.update(userInfo);
    }

    @RequestMapping(value="/findUser", method=RequestMethod.POST)
    @ResponseBody
    public Object findUser(@RequestBody Map<String, Object> requestMap) throws Exception {
        String serialNo = getParam(requestMap, "serialNo");
        return loginService.findUser(serialNo);
    }

    public Object redister(@RequestBody User user) throws Exception {
        if (null == user) {
            throw new Exception("信息不能为空");
        }
        return loginService.register(user);
    }
}
