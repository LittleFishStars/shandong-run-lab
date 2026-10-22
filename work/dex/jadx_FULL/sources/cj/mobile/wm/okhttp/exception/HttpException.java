package cj.mobile.wm.okhttp.exception;

import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.model.Response;
import cj.mobile.wm.okhttp.utils.HttpUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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
        return new HttpException(dexc.dexa("ofuxpsl!fssps\"!iuuq!sftqpotf!dpef!jt!515!ps!6yy\""));
    }

    public static String getMessage(Response<?> response) {
        HttpUtils.checkNotNull(response, dexc.dexa("sftqpotf!>>!ovmm"));
        return dexc.dexa("IUUQ!") + response.code() + " " + response.message();
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
