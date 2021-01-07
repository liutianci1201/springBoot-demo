package com.huaxin.cloud.tms.adl.rest;

import com.huaxin.cloud.tms.adl.domain.Permission;
import com.huaxin.cloud.tms.adl.enums.ResultCodeEnum;
import com.huaxin.cloud.tms.adl.service.UserService;
import com.huaxin.cloud.tms.adl.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *    登录接口
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-07 14:38
 */
@Api(tags = "登录")
@Slf4j
@RestController
@RequestMapping(value = "/auth")
public class LoginRest {

    @Resource
    private UserService userService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "用户登录", notes = "输入用户名密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", dataType = "String")
    })
    public HttpResult<LoginVO> login(@RequestParam(required = true,name = "userName") String userName,
                                     @RequestParam(required = true,name = "password") String password){
        try {
            return HttpResult.success(userService.login(userName, password));
        }catch (UnknownAccountException e) {
            return HttpResult.failure(ResultCodeEnum.SERVER_ERROR.getCode(), "账号不存在");
        }catch (IncorrectCredentialsException e) {
            return HttpResult.failure(ResultCodeEnum.SERVER_ERROR.getCode(), "密码不正确");
        }catch (LockedAccountException e){
            return HttpResult.failure(ResultCodeEnum.SERVER_ERROR.getCode(), "用户已被禁用");
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return HttpResult.failure(ResultCodeEnum.SERVER_ERROR.getCode(), e.getMessage());
        }
    }

    @ApiOperation(value = "未登录跳转", notes = "跳转请求")
    @PostMapping("/un_auth")
    public HttpResult unAuth() {
        return HttpResult.failure(ResultCodeEnum.SERVER_ERROR.getCode(), "用户未登录");
    }

    @ApiOperation(value = "未授权跳转", notes = "跳转请求")
    @PostMapping("/unauthorized")
    public String unauthorized() {
        throw new UnauthorizedException();
    }

    @PostMapping(value = "/menu")
    public HttpResult<List<Permission>> menu() {
        try {
            return HttpResult.success(userService.menuList());
        }catch (Exception e){
            return HttpResult.failure(ResultCodeEnum.SERVER_ERROR.getCode(), "用户已被禁用");
        }
    }

    @GetMapping("/logout")
    public HttpResult logout() {
        try {
            userService.logout();
            return HttpResult.success();
        }catch (Exception e){
            return HttpResult.failure(ResultCodeEnum.SERVER_ERROR.getCode(), e.getMessage());
        }

    }
}
