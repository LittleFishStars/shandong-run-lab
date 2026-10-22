package com.kc.bw.okhttp.request.base;

import android.text.TextUtils;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.OkHttp;
import com.kc.bw.okhttp.adapter.AdapterParam;
import com.kc.bw.okhttp.adapter.CacheCall;
import com.kc.bw.okhttp.adapter.Call;
import com.kc.bw.okhttp.adapter.CallAdapter;
import com.kc.bw.okhttp.cache.CacheMode;
import com.kc.bw.okhttp.cache.policy.CachePolicy;
import com.kc.bw.okhttp.callback.Callback;
import com.kc.bw.okhttp.convert.Converter;
import com.kc.bw.okhttp.model.HttpHeaders;
import com.kc.bw.okhttp.model.HttpMethod;
import com.kc.bw.okhttp.model.HttpParams;
import com.kc.bw.okhttp.request.base.Request;
import com.kc.bw.okhttp.utils.HttpUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class Request<T, R extends Request> implements Serializable {
    public static final String TAG = dexg.dexa("XN`Sfrvftu");
    public static final long serialVersionUID = -7174118653689916252L;
    public String baseUrl;
    public String cacheKey;
    public CacheMode cacheMode;
    public transient CachePolicy<T> cachePolicy;
    public long cacheTime;
    public transient Call<T> call;
    public transient Callback<T> callback;
    public transient OkHttpClient client;
    public transient Converter<T> converter;
    public transient okhttp3.Request mRequest;
    public int retryCount;
    public transient Object tag;
    public transient ProgressRequestBody.UploadInterceptor uploadInterceptor;
    public String url;
    public HttpParams params = new HttpParams();
    public HttpHeaders headers = new HttpHeaders();

    public Request(String str) {
        try {
            this.url = str;
            this.baseUrl = str;
            OkHttp okHttp = OkHttp.getInstance();
            String acceptLanguage = HttpHeaders.getAcceptLanguage();
            if (!TextUtils.isEmpty(acceptLanguage)) {
                headers(dexg.dexa("Bddfqu.Mbohvbhf"), acceptLanguage);
            }
            if (okHttp.getGlobalDefaultHeaders() != null) {
                headers(okHttp.getGlobalDefaultHeaders());
            }
            if (okHttp.getCommonParams() != null) {
                params(okHttp.getCommonParams());
            }
            this.retryCount = okHttp.getRetryCount();
            this.cacheMode = okHttp.getCacheMode();
            this.cacheTime = okHttp.getCacheTime();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Call<T> adapt() {
        Call<T> call = this.call;
        return call == null ? new CacheCall(this) : call;
    }

    public <E> E adapt(AdapterParam adapterParam, CallAdapter<T, E> callAdapter) {
        Call<T> cacheCall = this.call;
        if (cacheCall == null) {
            cacheCall = new CacheCall<>(this);
        }
        return callAdapter.adapt(cacheCall, adapterParam);
    }

    public <E> E adapt(CallAdapter<T, E> callAdapter) {
        Call<T> cacheCall = this.call;
        if (cacheCall == null) {
            cacheCall = new CacheCall<>(this);
        }
        return callAdapter.adapt(cacheCall, null);
    }

    public R addUrlParams(String str, List<String> list) {
        this.params.putUrlParams(str, list);
        return this;
    }

    public R cacheKey(String str) {
        HttpUtils.checkNotNull(str, dexg.dexa("dbdifLfz!>>!ovmm"));
        this.cacheKey = str;
        return this;
    }

    public R cacheMode(CacheMode cacheMode) {
        this.cacheMode = cacheMode;
        return this;
    }

    public R cachePolicy(CachePolicy<T> cachePolicy) {
        HttpUtils.checkNotNull(cachePolicy, dexg.dexa("dbdifQpmjdz!>>!ovmm"));
        this.cachePolicy = cachePolicy;
        return this;
    }

    public R cacheTime(long j) {
        if (j <= -1) {
            j = -1;
        }
        this.cacheTime = j;
        return this;
    }

    public R call(Call<T> call) {
        HttpUtils.checkNotNull(call, dexg.dexa("dbmm!>>!ovmm"));
        this.call = call;
        return this;
    }

    public R client(OkHttpClient okHttpClient) {
        HttpUtils.checkNotNull(okHttpClient, dexg.dexa("PlIuuqDmjfou!>>!ovmm"));
        this.client = okHttpClient;
        return this;
    }

    public R converter(Converter<T> converter) {
        HttpUtils.checkNotNull(converter, dexg.dexa("dpowfsufs!>>!ovmm"));
        this.converter = converter;
        return this;
    }

    public Response execute() {
        return getRawCall().execute();
    }

    public void execute(Callback<T> callback) {
        HttpUtils.checkNotNull(callback, dexg.dexa("dbmmcbdl!>>!ovmm"));
        this.callback = callback;
        adapt().execute(callback);
    }

    public abstract okhttp3.Request generateRequest(RequestBody requestBody);

    public abstract RequestBody generateRequestBody();

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public CacheMode getCacheMode() {
        return this.cacheMode;
    }

    public CachePolicy<T> getCachePolicy() {
        return this.cachePolicy;
    }

    public long getCacheTime() {
        return this.cacheTime;
    }

    public Converter<T> getConverter() {
        if (this.converter == null) {
            this.converter = this.callback;
        }
        HttpUtils.checkNotNull(this.converter, dexg.dexa("dpowfsufs!>>!ovmm-!ep!zpv!gpshfu!up!dbmm!Sfrvftu$dpowfsufs)Dpowfsufs=U?*!@"));
        return this.converter;
    }

    public HttpParams.FileWrapper getFileParam(String str) {
        List<HttpParams.FileWrapper> list = this.params.fileParamsMap.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    public abstract HttpMethod getMethod();

    public HttpParams getParams() {
        return this.params;
    }

    public okhttp3.Call getRawCall() {
        okhttp3.Request requestGenerateRequest;
        RequestBody requestBodyGenerateRequestBody = generateRequestBody();
        if (requestBodyGenerateRequestBody != null) {
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(requestBodyGenerateRequestBody, this.callback);
            progressRequestBody.setInterceptor(this.uploadInterceptor);
            requestGenerateRequest = generateRequest(progressRequestBody);
        } else {
            requestGenerateRequest = generateRequest(null);
        }
        this.mRequest = requestGenerateRequest;
        if (this.client == null) {
            this.client = OkHttp.getInstance().getOkHttpClient();
        }
        return this.client.newCall(this.mRequest);
    }

    public okhttp3.Request getRequest() {
        return this.mRequest;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public Object getTag() {
        return this.tag;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUrlParam(String str) {
        List<String> list = this.params.urlParamsMap.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public R headers(HttpHeaders httpHeaders) {
        if (httpHeaders != null && !httpHeaders.isEmpty()) {
            this.headers.put(httpHeaders);
        }
        return this;
    }

    public R headers(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.headers.put(str, str2);
        }
        return this;
    }

    public R params(HttpParams httpParams) {
        this.params.put(httpParams);
        return this;
    }

    public R params(String str, char c, boolean... zArr) {
        this.params.put(str, c, zArr);
        return this;
    }

    public R params(String str, double d, boolean... zArr) {
        this.params.put(str, d, zArr);
        return this;
    }

    public R params(String str, float f, boolean... zArr) {
        this.params.put(str, f, zArr);
        return this;
    }

    public R params(String str, int i, boolean... zArr) {
        this.params.put(str, i, zArr);
        return this;
    }

    public R params(String str, long j, boolean... zArr) {
        this.params.put(str, j, zArr);
        return this;
    }

    public R params(String str, String str2, boolean... zArr) {
        this.params.put(str, str2, zArr);
        return this;
    }

    public R params(String str, boolean z, boolean... zArr) {
        this.params.put(str, z, zArr);
        return this;
    }

    public R params(Map<String, String> map, boolean... zArr) {
        this.params.put(map, zArr);
        return this;
    }

    public R removeAllHeaders() {
        this.headers.clear();
        return this;
    }

    public R removeAllParams() {
        this.params.clear();
        return this;
    }

    public R removeHeader(String str) {
        this.headers.remove(str);
        return this;
    }

    public R removeParam(String str) {
        this.params.remove(str);
        return this;
    }

    public R retryCount(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(dexg.dexa("sfuszDpvou!nvtu!?!1"));
        }
        this.retryCount = i;
        return this;
    }

    public void setCallback(Callback<T> callback) {
        this.callback = callback;
    }

    public R tag(Object obj) {
        this.tag = obj;
        return this;
    }

    public R uploadInterceptor(ProgressRequestBody.UploadInterceptor uploadInterceptor) {
        this.uploadInterceptor = uploadInterceptor;
        return this;
    }
}
