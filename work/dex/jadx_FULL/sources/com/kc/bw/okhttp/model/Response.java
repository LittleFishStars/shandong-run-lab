package com.kc.bw.okhttp.model;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import okhttp3.Call;
import okhttp3.Headers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class Response<T> {
    public T body;
    public boolean isFromCache;
    public Call rawCall;
    public okhttp3.Response rawResponse;
    public Throwable throwable;

    public static <T> Response<T> error(boolean z, Call call, okhttp3.Response response, Throwable th) {
        Response<T> response2 = new Response<>();
        response2.setFromCache(z);
        response2.setRawCall(call);
        response2.setRawResponse(response);
        response2.setException(th);
        return response2;
    }

    public static <T> Response<T> success(boolean z, T t, Call call, okhttp3.Response response) {
        Response<T> response2 = new Response<>();
        response2.setFromCache(z);
        response2.setBody(t);
        response2.setRawCall(call);
        response2.setRawResponse(response);
        return response2;
    }

    public T body() {
        return this.body;
    }

    public int code() {
        okhttp3.Response response = this.rawResponse;
        if (response == null) {
            return -1;
        }
        return response.code();
    }

    public Throwable getException() {
        return this.throwable;
    }

    public Call getRawCall() {
        return this.rawCall;
    }

    public okhttp3.Response getRawResponse() {
        return this.rawResponse;
    }

    public Headers headers() {
        okhttp3.Response response = this.rawResponse;
        if (response == null) {
            return null;
        }
        return response.headers();
    }

    public boolean isFromCache() {
        return this.isFromCache;
    }

    public boolean isSuccessful() {
        return this.throwable == null;
    }

    public String message() {
        okhttp3.Response response = this.rawResponse;
        if (response == null) {
            return null;
        }
        return response.message();
    }

    public void setBody(T t) {
        this.body = t;
    }

    public void setException(Throwable th) {
        this.throwable = th;
    }

    public void setFromCache(boolean z) {
        this.isFromCache = z;
    }

    public void setRawCall(Call call) {
        this.rawCall = call;
    }

    public void setRawResponse(okhttp3.Response response) {
        this.rawResponse = response;
    }
}
