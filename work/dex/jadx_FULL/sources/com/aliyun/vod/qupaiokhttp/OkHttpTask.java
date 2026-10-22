package com.aliyun.vod.qupaiokhttp;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.o.b;
import com.aliyun.vod.common.utils.StringUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.SoftReference;
import java.lang.reflect.Type;
import java.net.SocketTimeoutException;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class OkHttpTask {
    public static final String DEFAULT_HTTP_TASK_KEY = "default_http_task_key";
    private BaseHttpRequestCallback callback;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Headers headers;
    private Method method;
    private OkHttpClient okHttpClient;
    private RequestParams params;
    private String requestKey;
    private String url;

    /* JADX INFO: renamed from: com.aliyun.vod.qupaiokhttp.OkHttpTask$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$vod$qupaiokhttp$Method;

        static {
            int[] iArr = new int[Method.values().length];
            $SwitchMap$com$aliyun$vod$qupaiokhttp$Method = iArr;
            try {
                iArr[Method.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$vod$qupaiokhttp$Method[Method.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$vod$qupaiokhttp$Method[Method.HEAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$vod$qupaiokhttp$Method[Method.POST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$aliyun$vod$qupaiokhttp$Method[Method.PUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$aliyun$vod$qupaiokhttp$Method[Method.PATCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class MyOkHttpCallBack implements Callback, ProgressCallback {
        private SoftReference<OkHttpTask> ref;

        public MyOkHttpCallBack(OkHttpTask okHttpTask) {
            this.ref = new SoftReference<>(okHttpTask);
        }

        public void onFailure(Call call, IOException iOException) {
            OkHttpTask okHttpTask = this.ref.get();
            if (okHttpTask != null) {
                okHttpTask.onFailure(call, iOException);
            }
        }

        public void onResponse(Call call, Response response) throws IOException {
            OkHttpTask okHttpTask = this.ref.get();
            if (okHttpTask != null) {
                okHttpTask.onResponse(call, response);
            }
        }

        @Override // com.aliyun.vod.qupaiokhttp.ProgressCallback
        public void updateProgress(int i, long j, boolean z) {
            OkHttpTask okHttpTask = this.ref.get();
            if (okHttpTask != null) {
                okHttpTask.updateProgress(i, j, z);
            }
        }
    }

    public OkHttpTask(Method method, String str, RequestParams requestParams, OkHttpClient.Builder builder, BaseHttpRequestCallback baseHttpRequestCallback) {
        this.method = method;
        this.url = str;
        this.callback = baseHttpRequestCallback;
        if (requestParams == null) {
            this.params = new RequestParams();
        } else {
            this.params = requestParams;
        }
        String httpTaskKey = this.params.getHttpTaskKey();
        this.requestKey = httpTaskKey;
        if (StringUtils.isEmpty(httpTaskKey)) {
            this.requestKey = DEFAULT_HTTP_TASK_KEY;
        }
        HttpTaskHandler.getInstance().addTask(this.requestKey, this);
        this.okHttpClient = builder.build();
    }

    private void handlerResponse(final ResponseData responseData, Response response) {
        String strString;
        if (response != null) {
            responseData.setResponseNull(false);
            responseData.setCode(response.code());
            responseData.setMessage(response.message());
            responseData.setSuccess(response.isSuccessful());
            try {
                strString = response.body().string();
            } catch (IOException e) {
                ILogger.e(e);
                strString = "";
            }
            responseData.setResponse(strString);
            responseData.setHeaders(response.headers());
        } else {
            responseData.setResponseNull(true);
            responseData.setCode(1003);
            if (responseData.isTimeout()) {
                responseData.setMessage("request timeout");
            } else {
                responseData.setMessage("http exception");
            }
        }
        responseData.setHttpResponse(response);
        this.handler.post(new Runnable() { // from class: com.aliyun.vod.qupaiokhttp.OkHttpTask.2
            @Override // java.lang.Runnable
            public void run() {
                OkHttpTask.this.onPostExecute(responseData);
            }
        });
    }

    private void parseResponseBody(ResponseData responseData, BaseHttpRequestCallback baseHttpRequestCallback) {
        if (baseHttpRequestCallback == null) {
            return;
        }
        String response = responseData.getResponse();
        StringUtils.isEmpty(response);
        Type type = baseHttpRequestCallback.type;
        if (type != String.class && type != Object.class) {
            baseHttpRequestCallback.onFailure(1002, "Data parse exception");
        } else {
            baseHttpRequestCallback.onSuccess(responseData.getHeaders(), response);
            baseHttpRequestCallback.onSuccess(response);
        }
    }

    public void execute() {
        Headers.Builder builder = this.params.headers;
        if (builder != null) {
            this.headers = builder.build();
        }
        BaseHttpRequestCallback baseHttpRequestCallback = this.callback;
        if (baseHttpRequestCallback != null) {
            baseHttpRequestCallback.onStart();
        }
        try {
            run();
        } catch (Exception e) {
            ILogger.e(e);
        }
    }

    public String getUrl() {
        return this.url;
    }

    public void onFailure(Call call, IOException iOException) {
        ResponseData responseData = new ResponseData();
        if (iOException instanceof SocketTimeoutException) {
            responseData.setTimeout(true);
        } else if ((iOException instanceof InterruptedIOException) && TextUtils.equals(iOException.getMessage(), b.r0)) {
            responseData.setTimeout(true);
        }
        handlerResponse(responseData, null);
    }

    public void onPostExecute(ResponseData responseData) {
        Headers headers;
        OkHttpCallManager.getInstance().removeCall(this.url);
        HttpTaskHandler.getInstance().removeTask(this.requestKey);
        BaseHttpRequestCallback baseHttpRequestCallback = this.callback;
        if (baseHttpRequestCallback != null) {
            baseHttpRequestCallback.setResponseHeaders(responseData.getHeaders());
            this.callback.onResponse(responseData.getHttpResponse(), responseData.getResponse(), responseData.getHeaders());
            this.callback.onResponse(responseData.getResponse(), responseData.getHeaders());
        }
        int code = responseData.getCode();
        String message = responseData.getMessage();
        if (responseData.isResponseNull()) {
            if (Constants.DEBUG) {
                ILogger.d("url=" + this.url + "\n response failure code=" + code + " msg=" + message, new Object[0]);
            }
            BaseHttpRequestCallback baseHttpRequestCallback2 = this.callback;
            if (baseHttpRequestCallback2 != null) {
                baseHttpRequestCallback2.onFailure(code, message);
            }
        } else if (responseData.isSuccess()) {
            responseData.getResponse();
            if (Constants.DEBUG && (headers = responseData.getHeaders()) != null) {
                headers.toString();
            }
            parseResponseBody(responseData, this.callback);
        } else {
            if (Constants.DEBUG) {
                ILogger.d("url=" + this.url + "\n response failure code=" + code + " msg=" + message, new Object[0]);
            }
            BaseHttpRequestCallback baseHttpRequestCallback3 = this.callback;
            if (baseHttpRequestCallback3 != null) {
                baseHttpRequestCallback3.onFailure(code, message);
            }
        }
        BaseHttpRequestCallback baseHttpRequestCallback4 = this.callback;
        if (baseHttpRequestCallback4 != null) {
            baseHttpRequestCallback4.onFinish();
        }
    }

    public void onResponse(Call call, Response response) throws IOException {
        handlerResponse(new ResponseData(), response);
    }

    public void run() throws Exception {
        String str = this.url;
        Request.Builder builder = new Request.Builder();
        MyOkHttpCallBack myOkHttpCallBack = new MyOkHttpCallBack(this);
        switch (AnonymousClass3.$SwitchMap$com$aliyun$vod$qupaiokhttp$Method[this.method.ordinal()]) {
            case 1:
                this.url = Utils.getFullUrl(this.url, this.params.getFormParams(), this.params.isUrlEncoder());
                builder.get();
                break;
            case 2:
                this.url = Utils.getFullUrl(this.url, this.params.getFormParams(), this.params.isUrlEncoder());
                builder.delete();
                break;
            case 3:
                this.url = Utils.getFullUrl(this.url, this.params.getFormParams(), this.params.isUrlEncoder());
                builder.head();
                break;
            case 4:
                RequestBody requestBody = this.params.getRequestBody();
                if (requestBody != null) {
                    builder.post(new ProgressRequestBody(requestBody, myOkHttpCallBack));
                }
                break;
            case 5:
                RequestBody requestBody2 = this.params.getRequestBody();
                if (requestBody2 != null) {
                    builder.put(new ProgressRequestBody(requestBody2, myOkHttpCallBack));
                }
                break;
            case 6:
                RequestBody requestBody3 = this.params.getRequestBody();
                if (requestBody3 != null) {
                    builder.put(new ProgressRequestBody(requestBody3, myOkHttpCallBack));
                }
                break;
        }
        CacheControl cacheControl = this.params.cacheControl;
        if (cacheControl != null) {
            builder.cacheControl(cacheControl);
        }
        builder.url(this.url).tag(str).headers(this.headers);
        Request requestBuild = builder.build();
        if (Constants.DEBUG) {
            ILogger.d("url=" + str + "?" + this.params.toString() + "\n header=" + this.headers.toString(), new Object[0]);
        }
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        OkHttpCallManager.getInstance().addCall(this.url, callNewCall);
        callNewCall.enqueue(myOkHttpCallBack);
    }

    public void updateProgress(final int i, final long j, final boolean z) {
        this.handler.post(new Runnable() { // from class: com.aliyun.vod.qupaiokhttp.OkHttpTask.1
            @Override // java.lang.Runnable
            public void run() {
                if (OkHttpTask.this.callback != null) {
                    OkHttpTask.this.callback.onProgress(i, j, z);
                }
            }
        });
    }
}
