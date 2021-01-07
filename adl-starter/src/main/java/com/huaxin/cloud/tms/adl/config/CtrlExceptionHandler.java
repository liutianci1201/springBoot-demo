package com.huaxin.cloud.tms.adl.config;

import com.huaxin.cloud.tms.adl.enums.ResultCodeEnum;
import com.huaxin.cloud.tms.adl.rest.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.ExpiredSessionException;
import org.apache.shiro.session.UnknownSessionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * <p>
 *     全局异常处理
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-07 10:54
 */
@Slf4j
@RestControllerAdvice
public class CtrlExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public HttpResult handleShiroException(UnauthorizedException ex) {
        log.error(ex.getMessage(), ex);
        return HttpResult.failure(ResultCodeEnum.SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(AuthorizationException.class)
    public HttpResult authorizationException(AuthorizationException ex) {
        log.error(ex.getMessage(), ex);
        return HttpResult.failure(ResultCodeEnum.FILE_PERMISSION);
    }

    @ResponseBody
    @ExceptionHandler(ExpiredSessionException.class)
    public HttpResult expiredSessionException (ExpiredSessionException ex) {
        log.error(ex.getMessage(), ex);
        return HttpResult.failure(ResultCodeEnum.SESSION_FAILED);
    }

    @ResponseBody
    @ExceptionHandler(UnknownSessionException.class)
    public HttpResult unknownSessionException (UnknownSessionException ex) {
        log.error(ex.getMessage(), ex);
        return HttpResult.failure(ResultCodeEnum.SESSION_UNKNOWN);
    }

}
