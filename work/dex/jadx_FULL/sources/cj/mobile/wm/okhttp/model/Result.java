package cj.mobile.wm.okhttp.model;

import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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
        throw new NullPointerException(dexc.dexa("fssps!>>!ovmm"));
    }

    public static <T> Result<T> response(Response<T> response) {
        if (response != null) {
            return new Result<>(response, null);
        }
        throw new NullPointerException(dexc.dexa("sftqpotf!>>!ovmm"));
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
            sb.append(dexc.dexa("Sftvmu|jtFssps>usvf-!fssps>#"));
            sb.append(this.error);
            sb.append(dexc.dexa("#~"));
        } else {
            sb = new StringBuilder();
            sb.append(dexc.dexa("Sftvmu|jtFssps>gbmtf-!sftqpotf>"));
            sb.append(this.response);
            sb.append('}');
        }
        return sb.toString();
    }
}
