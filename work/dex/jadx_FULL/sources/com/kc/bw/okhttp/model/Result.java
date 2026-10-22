package com.kc.bw.okhttp.model;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class Result<T> {
    public final Throwable error;
    public final Response<T> response;

    public Result(Response<T> response, Throwable th) {
        this.response = response;
        this.error = th;
    }

    public static <T> Result<T> error(Throwable th) {
        if (th != null) {
            return new Result<>(null, th);
        }
        throw new NullPointerException(dexg.dexa("fssps!>>!ovmm"));
    }

    public static <T> Result<T> response(Response<T> response) {
        if (response != null) {
            return new Result<>(response, null);
        }
        throw new NullPointerException(dexg.dexa("sftqpotf!>>!ovmm"));
    }

    public Throwable error() {
        return this.error;
    }

    public boolean isError() {
        return this.error != null;
    }

    public Response<T> response() {
        return this.response;
    }

    public String toString() {
        StringBuilder sb;
        if (this.error != null) {
            sb = new StringBuilder();
            sb.append(dexg.dexa("Sftvmu|jtFssps>usvf-!fssps>#"));
            sb.append(this.error);
            sb.append(dexg.dexa("#~"));
        } else {
            sb = new StringBuilder();
            sb.append(dexg.dexa("Sftvmu|jtFssps>gbmtf-!sftqpotf>"));
            sb.append(this.response);
            sb.append('}');
        }
        return sb.toString();
    }
}
