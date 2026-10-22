package com.kc.bw.okhttp.cache.policy;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.OkHttp;
import com.kc.bw.okhttp.cache.CacheEntity;
import com.kc.bw.okhttp.cache.CacheMode;
import com.kc.bw.okhttp.callback.Callback;
import com.kc.bw.okhttp.db.CacheManager;
import com.kc.bw.okhttp.exception.HttpException;
import com.kc.bw.okhttp.request.base.Request;
import com.kc.bw.okhttp.utils.AesUtil;
import com.kc.bw.okhttp.utils.GZIPUtils;
import com.kc.bw.okhttp.utils.HeaderParser;
import com.kc.bw.okhttp.utils.HttpUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class BaseCachePolicy<T> implements CachePolicy<T> {
    public static final String TAG = dexg.dexa("XN`CbtfDbdifQpmjdz");
    public CacheEntity<T> cacheEntity;
    public volatile boolean canceled;
    public volatile int currentRetryCount = 0;
    public boolean executed;
    public Callback<T> mCallback;
    public Call rawCall;
    public Request<T, ? extends Request> request;

    public BaseCachePolicy(Request<T, ? extends Request> request) {
        this.request = request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveCache(Headers headers, T t) {
        if (this.request.getCacheMode() == CacheMode.NO_CACHE || (t instanceof Bitmap)) {
            return;
        }
        CacheEntity<T> cacheEntityCreateCacheEntity = HeaderParser.createCacheEntity(headers, t, this.request.getCacheMode(), this.request.getCacheKey());
        if (cacheEntityCreateCacheEntity == null) {
            CacheManager.getInstance().remove(this.request.getCacheKey());
        } else {
            CacheManager.getInstance().replace(this.request.getCacheKey(), cacheEntityCreateCacheEntity);
        }
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public void cancel() {
        this.canceled = true;
        Call call = this.rawCall;
        if (call != null) {
            call.cancel();
        }
    }

    public void doPrintLog(String str) {
        if (str != null) {
            try {
                if (str.length() == 0) {
                    return;
                }
                if (str.length() > 3072) {
                    while (str.length() > 3072) {
                        String strSubstring = str.substring(0, 3072);
                        str = str.replace(strSubstring, "");
                        Log.w(TAG, strSubstring);
                    }
                }
                Log.w(TAG, str);
            } catch (Throwable th) {
                Log.w(TAG, dexg.dexa("epQsjouMph!fssps") + th);
            }
        }
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            Call call = this.rawCall;
            if (call == null || !call.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public boolean isExecuted() {
        return this.executed;
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public boolean onAnalysisResponse(Call call, Response response) {
        return false;
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public CacheEntity<T> prepareCache() {
        if (this.request.getCacheKey() == null) {
            Request<T, ? extends Request> request = this.request;
            request.cacheKey(HttpUtils.createUrlFromParams(request.getBaseUrl(), this.request.getParams().urlParamsMap));
        }
        if (this.request.getCacheMode() == null) {
            this.request.cacheMode(CacheMode.NO_CACHE);
        }
        CacheMode cacheMode = this.request.getCacheMode();
        if (cacheMode != CacheMode.NO_CACHE) {
            CacheEntity<T> cacheEntity = (CacheEntity<T>) CacheManager.getInstance().get(this.request.getCacheKey());
            this.cacheEntity = cacheEntity;
            HeaderParser.addCacheHeaders(this.request, cacheEntity, cacheMode);
            CacheEntity<T> cacheEntity2 = this.cacheEntity;
            if (cacheEntity2 != null && cacheEntity2.checkExpire(cacheMode, this.request.getCacheTime(), System.currentTimeMillis())) {
                this.cacheEntity.setExpire(true);
            }
        }
        CacheEntity<T> cacheEntity3 = this.cacheEntity;
        if (cacheEntity3 == null || cacheEntity3.isExpire() || this.cacheEntity.getData() == null || this.cacheEntity.getResponseHeaders() == null) {
            this.cacheEntity = null;
        }
        return this.cacheEntity;
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public Call prepareRawCall() {
        Call call;
        synchronized (this) {
            if (this.executed) {
                throw HttpException.COMMON(dexg.dexa("Bmsfbez!fyfdvufe\""));
            }
            this.executed = true;
            this.rawCall = this.request.getRawCall();
            if (this.canceled) {
                this.rawCall.cancel();
            }
            call = this.rawCall;
        }
        return call;
    }

    public void printErrorLog(String str, String str2) {
        if (OkHttp.enableHttpLog) {
            StringBuilder sb = new StringBuilder(dexg.dexa("䁑") + Thread.currentThread().getName() + dexg.dexa("䁒"));
            sb.append(str);
            sb.append(dexg.dexa("\u000bsfrvftu!vsm>"));
            sb.append(this.rawCall.request().url());
            sb.append(dexg.dexa("\u000bsfrvftu!nfuipe>"));
            sb.append(this.rawCall.request().method());
            sb.append(dexg.dexa("\u000bsfrvftu!fssps>"));
            sb.append(str2);
            sb.append(dexg.dexa("\u000bꈎ鰖ꆎ辯>"));
            sb.append(this.currentRetryCount + dexg.dexa("0") + this.request.getRetryCount());
            sb.append("\n\t");
            doPrintLog(sb.toString());
        }
    }

    public void printRequestLog(String str) {
        if (OkHttp.enableHttpLog) {
            doPrintLog((dexg.dexa("䁑") + Thread.currentThread().getName() + dexg.dexa("䁒")) + str + dexg.dexa("\u000bsfrvftu!vsm>") + this.rawCall.request().url() + dexg.dexa("\u000bsfrvftu!nfuipe>") + this.rawCall.request().method() + dexg.dexa("\u000bsfrvftu!ifbefst;\u000b") + this.rawCall.request().headers() + "\n\t");
        }
    }

    public void printResponseLog(String str, Response response) {
        String strString;
        if (OkHttp.enableHttpLog) {
            try {
                String strMethod = response.request().method();
                MediaType mediaTypeContentType = response.body().contentType();
                StringBuilder sb = new StringBuilder(dexg.dexa("䁑") + Thread.currentThread().getName() + dexg.dexa("䁒"));
                sb.append(str);
                sb.append(dexg.dexa("\u000bsftqpotf!vsm>"));
                sb.append(response.request().url());
                sb.append(dexg.dexa("\u000bsftqpotf!nfuipe>"));
                sb.append(strMethod);
                sb.append(dexg.dexa("\u000bsftqpotf!dpef>"));
                sb.append(response.code());
                sb.append(dexg.dexa("\u000bsftqpotf!nfejbUzqf>"));
                sb.append(mediaTypeContentType);
                if (dexg.dexa("HFU").equalsIgnoreCase(strMethod)) {
                    if (dexg.dexa("ufyu").equals(mediaTypeContentType == null ? "" : mediaTypeContentType.type()) || ((mediaTypeContentType != null && mediaTypeContentType.toString().startsWith(dexg.dexa("bqqmjdbujpo0ktpo"))) || (mediaTypeContentType != null && mediaTypeContentType.toString().startsWith(dexg.dexa("bqqmjdbujpo0ynm"))))) {
                        strString = response.peekBody(Long.MAX_VALUE).string();
                        sb.append(dexg.dexa("\u000bsftqpotf!cpez>"));
                        sb.append(strString);
                    }
                } else if (dexg.dexa("QPTU").equalsIgnoreCase(strMethod)) {
                    String str2 = response.request().headers().get(dexg.dexa("Dpoufou.Uzqf"));
                    if (TextUtils.isEmpty(str2) || !str2.equalsIgnoreCase(dexg.dexa("bqqmjdbujpo0pdufu.tusfbn"))) {
                        strString = dexg.dexa("\u000bsftqpotf!cpez>") + response.peekBody(Long.MAX_VALUE).string();
                        sb.append(strString);
                    } else {
                        try {
                            byte[] bArrBytes = response.peekBody(Long.MAX_VALUE).bytes();
                            if (bArrBytes != null && bArrBytes.length > 0) {
                                sb.append(dexg.dexa("\u000bsftqpotf!cpez>") + GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(bArrBytes, OkHttp.appToken, dexg.dexa("qptu!sftqpotf"))));
                            }
                        } catch (Throwable th) {
                            Log.w(TAG, dexg.dexa("騤矑qptu鰸粃攎滕狦痈楲鵦!") + th);
                        }
                    }
                }
                sb.append("\n\t");
                doPrintLog(sb.toString());
            } catch (Throwable th2) {
                doPrintLog(dexg.dexa("qsjouSftqpotfMph!gbjm!") + th2);
            }
        }
    }

    public void requestNetworkAsync() {
        requestNetworkAsync(true);
    }

    public void requestNetworkAsync(boolean z) {
        printRequestLog(dexg.dexa("潃箦鰸粃"));
        this.rawCall.enqueue(new okhttp3.Callback(this, z) { // from class: com.kc.bw.okhttp.cache.policy.BaseCachePolicy.1
            public final BaseCachePolicy this$0;
            public final boolean val$hasSuccessCallback;

            {
                this.this$0 = this;
                this.val$hasSuccessCallback = z;
            }

            public void onFailure(Call call, IOException iOException) {
                this.this$0.printErrorLog(dexg.dexa("潃箦鰸粃楲鵦"), iOException.toString());
                if (!(iOException instanceof SocketTimeoutException) || this.this$0.currentRetryCount >= this.this$0.request.getRetryCount()) {
                    if (call.isCanceled()) {
                        return;
                    }
                    this.this$0.onError(com.kc.bw.okhttp.model.Response.error(false, call, null, iOException));
                    return;
                }
                this.this$0.currentRetryCount++;
                BaseCachePolicy baseCachePolicy = this.this$0;
                baseCachePolicy.rawCall = baseCachePolicy.request.getRawCall();
                if (this.this$0.canceled) {
                    this.this$0.rawCall.cancel();
                } else {
                    this.this$0.rawCall.enqueue(this);
                }
            }

            public void onResponse(Call call, Response response) {
                this.this$0.printResponseLog(dexg.dexa("潃箦鰸粃母牑"), response);
                int iCode = response.code();
                if (iCode == 404 || iCode >= 500) {
                    this.this$0.onError(com.kc.bw.okhttp.model.Response.error(false, call, response, HttpException.NET_ERROR()));
                    return;
                }
                if (this.this$0.onAnalysisResponse(call, response)) {
                    return;
                }
                try {
                    T tConvertResponse = this.this$0.request.getConverter().convertResponse(response);
                    this.this$0.saveCache(response.headers(), tConvertResponse);
                    com.kc.bw.okhttp.model.Response<T> responseSuccess = com.kc.bw.okhttp.model.Response.success(false, tConvertResponse, call, response);
                    if (this.val$hasSuccessCallback) {
                        this.this$0.onSuccess(responseSuccess);
                    }
                } catch (Throwable th) {
                    this.this$0.onError(com.kc.bw.okhttp.model.Response.error(false, call, response, th));
                }
            }
        });
    }

    public com.kc.bw.okhttp.model.Response<T> requestNetworkSync() {
        try {
            printRequestLog(dexg.dexa("摍箦鰸粃"));
            Response responseExecute = this.rawCall.execute();
            printResponseLog(dexg.dexa("摍箦鰸粃母牑"), responseExecute);
            int iCode = responseExecute.code();
            if (iCode != 404 && iCode < 500) {
                T tConvertResponse = this.request.getConverter().convertResponse(responseExecute);
                saveCache(responseExecute.headers(), tConvertResponse);
                return com.kc.bw.okhttp.model.Response.success(false, tConvertResponse, this.rawCall, responseExecute);
            }
            return com.kc.bw.okhttp.model.Response.error(false, this.rawCall, responseExecute, HttpException.NET_ERROR());
        } catch (Throwable th) {
            printErrorLog(dexg.dexa("摍箦鰸粃楲鵦"), th.toString());
            if ((th instanceof SocketTimeoutException) && this.currentRetryCount < this.request.getRetryCount()) {
                this.currentRetryCount++;
                this.rawCall = this.request.getRawCall();
                if (this.canceled) {
                    this.rawCall.cancel();
                } else {
                    requestNetworkSync();
                }
            }
            return com.kc.bw.okhttp.model.Response.error(false, this.rawCall, null, th);
        }
    }
}
