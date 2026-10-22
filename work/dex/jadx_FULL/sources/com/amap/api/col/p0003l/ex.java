package com.amap.api.col.p0003l;

import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.amap.api.maps.AMapException;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ex extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25935a;
    private int b;

    public ex(String str) {
        super(str);
        this.b = 1000;
        this.f25935a = str;
        a(str);
    }

    public final String a() {
        return this.f25935a;
    }

    private void a(String str) {
        if ("用户签名未通过".equals(str)) {
            this.b = 1001;
            return;
        }
        if ("用户key不正确或过期".equals(str)) {
            this.b = 1002;
            return;
        }
        if ("请求服务不存在".equals(str)) {
            this.b = 1003;
            return;
        }
        if ("访问已超出日访问量".equals(str)) {
            this.b = 1004;
            return;
        }
        if ("用户访问过于频繁".equals(str)) {
            this.b = 1005;
            return;
        }
        if ("用户IP无效".equals(str)) {
            this.b = 1006;
            return;
        }
        if ("用户域名无效".equals(str)) {
            this.b = 1007;
            return;
        }
        if ("用户MD5安全码未通过".equals(str)) {
            this.b = 1008;
            return;
        }
        if ("请求key与绑定平台不符".equals(str)) {
            this.b = 1009;
            return;
        }
        if ("IP访问超限".equals(str)) {
            this.b = 1010;
            return;
        }
        if ("服务不支持https请求".equals(str)) {
            this.b = 1011;
            return;
        }
        if ("权限不足，服务请求被拒绝".equals(str)) {
            this.b = 1012;
            return;
        }
        if ("开发者删除了key，key被删除后无法正常使用".equals(str)) {
            this.b = 1013;
            return;
        }
        if ("请求服务响应错误".equals(str)) {
            this.b = 1100;
            return;
        }
        if ("引擎返回数据异常".equals(str)) {
            this.b = 1101;
            return;
        }
        if ("服务端请求链接超时".equals(str)) {
            this.b = 1102;
            return;
        }
        if ("读取服务结果超时".equals(str)) {
            this.b = SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_LENGTH;
            return;
        }
        if ("请求参数非法".equals(str)) {
            this.b = 1200;
            return;
        }
        if ("缺少必填参数".equals(str)) {
            this.b = 1201;
            return;
        }
        if ("请求协议非法".equals(str)) {
            this.b = SecExceptionCode.SEC_ERROE_NOCAPTCHA_NO_MEMORY;
            return;
        }
        if ("其他未知错误".equals(str)) {
            this.b = SecExceptionCode.SEC_ERROE_NOCAPTCHA_NOT_INIT_YET;
            return;
        }
        if (AMapException.ERROR_PROTOCOL.equals(str)) {
            this.b = 1801;
            return;
        }
        if (AMapException.ERROR_SOCKE_TIME_OUT.equals(str)) {
            this.b = 1802;
            return;
        }
        if (AMapException.ERROR_URL.equals(str)) {
            this.b = 1803;
            return;
        }
        if (AMapException.ERROR_UNKNOW_HOST.equals(str)) {
            this.b = 1804;
            return;
        }
        if (AlibcProtocolConstant.UNKNOWN_ERROR.equals(str)) {
            this.b = 1900;
            return;
        }
        if (AMapException.ERROR_INVALID_PARAMETER.equals(str)) {
            this.b = SecExceptionCode.SEC_ERROR_GENERIC_AVMP_INVALID_ARGS;
            return;
        }
        if ("http或socket连接失败 - ConnectionException".equals(str)) {
            this.b = 1806;
            return;
        }
        if (AMapException.ERROR_IO.equals(str)) {
            this.b = SecExceptionCode.SEC_ERROR_GENERIC_AVMP_JPG_FILE_MISMATCH;
        } else if (AMapException.ERROR_NULL_PARAMETER.equals(str)) {
            this.b = SecExceptionCode.SEC_ERROR_GENERIC_AVMP_INCORRECT_JPG_FILE;
        } else {
            this.b = 1800;
        }
    }

    public ex() {
        this.f25935a = "";
        this.b = 1000;
    }
}
