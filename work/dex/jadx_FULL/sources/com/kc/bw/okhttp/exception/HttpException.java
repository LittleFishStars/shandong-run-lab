package com.kc.bw.okhttp.exception;

import com.kc.bw.dexg;
import com.kc.bw.okhttp.model.Response;
import com.kc.bw.okhttp.utils.HttpUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HttpException extends RuntimeException {
    public static final long serialVersionUID = 8773734741709178425L;
    public int code;
    public String message;
    public transient Response<?> response;

    public HttpException(Response<?> response) {
        super(getMessage(response));
        this.code = response.code();
        this.message = response.message();
        this.response = response;
    }

    public HttpException(String str) {
        super(str);
    }

    public static HttpException COMMON(String str) {
        return new HttpException(str);
    }

    public static HttpException NET_ERROR() {
        return new HttpException(dexg.dexa("ofuxpsl!fssps\"!iuuq!sftqpotf!dpef!jt!515!ps!6yy\""));
    }

    public static String getMessage(Response<?> response) {
        HttpUtils.checkNotNull(response, dexg.dexa("sftqpotf!>>!ovmm"));
        return dexg.dexa("IUUQ!") + response.code() + " " + response.message();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public Response<?> response() {
        return this.response;
    }
}
