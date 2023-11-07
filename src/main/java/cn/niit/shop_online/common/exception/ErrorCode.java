package cn.niit.shop_online.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNAUTHTHORIZED(401,"登陆失败，请重新登录"),
    INTERNAL_SERVER_ERROR(500,"服务器异常，请稍后在试");

    private final int code;
    private final String msg;
}
