package com.aliyun.vod.qupaiokhttp;

import android.util.Log;
import com.aliyun.vod.common.utils.StringUtils;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class HttpRequest {
    public static void cancel(String str) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        Call call = OkHttpCallManager.getInstance().getCall(str);
        if (call != null) {
            call.cancel();
        }
        OkHttpCallManager.getInstance().removeCall(str);
    }

    public static void delete(String str) {
        delete(str, null, null);
    }

    public static void download(String str, File file) {
        download(str, file, null);
    }

    private static void executeRequest(Method method, String str, RequestParams requestParams, OkHttpClient.Builder builder, BaseHttpRequestCallback baseHttpRequestCallback) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        if (builder == null) {
            builder = OkHttpFinal.getInstance().getOkHttpClientBuilder();
        }
        new OkHttpTask(method, str, requestParams, builder, baseHttpRequestCallback).execute();
    }

    public static void get(String str) {
        get(str, null, null);
    }

    public static void head(String str) {
        head(str, null, null);
    }

    public static void patch(String str) {
        patch(str, null, null);
    }

    public static void post(String str) {
        post(str, null, null);
    }

    public static void put(String str) {
        put(str, null, null);
    }

    public static void delete(String str, RequestParams requestParams) {
        delete(str, requestParams, null);
    }

    public static void download(String str, File file, FileDownloadCallback fileDownloadCallback) {
        if (StringUtils.isEmpty(str) || file == null) {
            return;
        }
        new FileDownloadTask(str, file, fileDownloadCallback).execute(new Void[0]);
    }

    public static void get(String str, RequestParams requestParams) {
        get(str, requestParams, null);
    }

    public static void head(String str, RequestParams requestParams) {
        head(str, requestParams, null);
    }

    public static void patch(String str, RequestParams requestParams) {
        patch(str, requestParams, null);
    }

    public static void post(String str, RequestParams requestParams) {
        post(str, requestParams, null);
    }

    public static void put(String str, RequestParams requestParams) {
        put(str, requestParams, null);
    }

    public static void delete(String str, BaseHttpRequestCallback baseHttpRequestCallback) {
        delete(str, null, baseHttpRequestCallback);
    }

    public static void get(String str, BaseHttpRequestCallback baseHttpRequestCallback) {
        Log.d("AliYunLog", "HttpGet:" + str);
        get(str, null, baseHttpRequestCallback);
    }

    public static void head(String str, BaseHttpRequestCallback baseHttpRequestCallback) {
        head(str, null, baseHttpRequestCallback);
    }

    public static void patch(String str, BaseHttpRequestCallback baseHttpRequestCallback) {
        patch(str, null, baseHttpRequestCallback);
    }

    public static void post(String str, BaseHttpRequestCallback baseHttpRequestCallback) {
        post(str, null, baseHttpRequestCallback);
    }

    public static void put(String str, BaseHttpRequestCallback baseHttpRequestCallback) {
        put(str, null, baseHttpRequestCallback);
    }

    public static void delete(String str, RequestParams requestParams, BaseHttpRequestCallback baseHttpRequestCallback) {
        delete(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void head(String str, RequestParams requestParams, BaseHttpRequestCallback baseHttpRequestCallback) {
        head(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void patch(String str, RequestParams requestParams, BaseHttpRequestCallback baseHttpRequestCallback) {
        patch(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void post(String str, RequestParams requestParams, BaseHttpRequestCallback baseHttpRequestCallback) {
        post(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void put(String str, RequestParams requestParams, BaseHttpRequestCallback baseHttpRequestCallback) {
        put(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void delete(String str, RequestParams requestParams, long j, BaseHttpRequestCallback baseHttpRequestCallback) {
        OkHttpClient.Builder okHttpClientBuilder = OkHttpFinal.getInstance().getOkHttpClientBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(Method.DELETE, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void get(String str, RequestParams requestParams, BaseHttpRequestCallback baseHttpRequestCallback) {
        get(str, requestParams, 30000L, baseHttpRequestCallback);
    }

    public static void head(String str, RequestParams requestParams, long j, BaseHttpRequestCallback baseHttpRequestCallback) {
        OkHttpClient.Builder okHttpClientBuilder = OkHttpFinal.getInstance().getOkHttpClientBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(Method.HEAD, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void patch(String str, RequestParams requestParams, long j, BaseHttpRequestCallback baseHttpRequestCallback) {
        OkHttpClient.Builder okHttpClientBuilder = OkHttpFinal.getInstance().getOkHttpClientBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(Method.PATCH, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void post(String str, RequestParams requestParams, long j, BaseHttpRequestCallback baseHttpRequestCallback) {
        OkHttpClient.Builder okHttpClientBuilder = OkHttpFinal.getInstance().getOkHttpClientBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(Method.POST, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void put(String str, RequestParams requestParams, long j, BaseHttpRequestCallback baseHttpRequestCallback) {
        OkHttpClient.Builder okHttpClientBuilder = OkHttpFinal.getInstance().getOkHttpClientBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(Method.PUT, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void get(String str, RequestParams requestParams, long j, BaseHttpRequestCallback baseHttpRequestCallback) {
        OkHttpClient.Builder okHttpClientBuilder = OkHttpFinal.getInstance().getOkHttpClientBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        okHttpClientBuilder.readTimeout(j, timeUnit);
        okHttpClientBuilder.connectTimeout(j, timeUnit);
        okHttpClientBuilder.writeTimeout(j, timeUnit);
        executeRequest(Method.GET, str, requestParams, okHttpClientBuilder, baseHttpRequestCallback);
    }

    public static void delete(String str, RequestParams requestParams, OkHttpClient.Builder builder, BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(Method.DELETE, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void head(String str, RequestParams requestParams, OkHttpClient.Builder builder, BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(Method.HEAD, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void patch(String str, RequestParams requestParams, OkHttpClient.Builder builder, BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(Method.PATCH, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void post(String str, RequestParams requestParams, OkHttpClient.Builder builder, BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(Method.POST, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void put(String str, RequestParams requestParams, OkHttpClient.Builder builder, BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(Method.PUT, str, requestParams, builder, baseHttpRequestCallback);
    }

    public static void get(String str, RequestParams requestParams, OkHttpClient.Builder builder, BaseHttpRequestCallback baseHttpRequestCallback) {
        executeRequest(Method.GET, str, requestParams, builder, baseHttpRequestCallback);
    }
}
