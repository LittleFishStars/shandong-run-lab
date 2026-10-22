package com.aliyun.vod.qupaiokhttp;

import java.lang.reflect.Type;
import okhttp3.Headers;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BaseHttpRequestCallback<T> {
    public static final int ERROR_RESPONSE_DATA_PARSE_EXCEPTION = 1002;
    public static final int ERROR_RESPONSE_UNKNOWN = 1003;
    protected Headers headers;
    protected Type type = ClassTypeReflect.getModelClazz(getClass());

    public Headers getHeaders() {
        return this.headers;
    }

    public void onFailure(int i, String str) {
    }

    public void onFinish() {
    }

    public void onProgress(int i, long j, boolean z) {
    }

    public void onResponse(String str, Headers headers) {
    }

    public void onResponse(Response response, String str, Headers headers) {
    }

    public void onStart() {
    }

    public void onSuccess(T t) {
    }

    public void onSuccess(Headers headers, T t) {
    }

    public void setResponseHeaders(Headers headers) {
        this.headers = headers;
    }
}
