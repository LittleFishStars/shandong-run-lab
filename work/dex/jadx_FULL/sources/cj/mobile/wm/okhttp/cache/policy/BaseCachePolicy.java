package cj.mobile.wm.okhttp.cache.policy;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.OkHttp;
import cj.mobile.wm.okhttp.cache.CacheEntity;
import cj.mobile.wm.okhttp.cache.CacheMode;
import cj.mobile.wm.okhttp.callback.Callback;
import cj.mobile.wm.okhttp.db.CacheManager;
import cj.mobile.wm.okhttp.exception.HttpException;
import cj.mobile.wm.okhttp.request.base.Request;
import cj.mobile.wm.okhttp.utils.AesUtil;
import cj.mobile.wm.okhttp.utils.GZIPUtils;
import cj.mobile.wm.okhttp.utils.HeaderParser;
import cj.mobile.wm.okhttp.utils.HttpUtils;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseCachePolicy<T> implements CachePolicy<T> {
    public static final String TAG = dexc.dexa("XN`CbtfDbdifQpmjdz");
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

    @Override // cj.mobile.wm.okhttp.cache.policy.CachePolicy
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
                Log.w(TAG, dexc.dexa("epQsjouMph!fssps") + th);
            }
        }
    }

    @Override // cj.mobile.wm.okhttp.cache.policy.CachePolicy
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

    @Override // cj.mobile.wm.okhttp.cache.policy.CachePolicy
    public boolean isExecuted() {
        return this.executed;
    }

    @Override // cj.mobile.wm.okhttp.cache.policy.CachePolicy
    public boolean onAnalysisResponse(Call call, Response response) {
        return false;
    }

    @Override // cj.mobile.wm.okhttp.cache.policy.CachePolicy
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

    @Override // cj.mobile.wm.okhttp.cache.policy.CachePolicy
    public synchronized Call prepareRawCall() {
        if (this.executed) {
            throw HttpException.COMMON(dexc.dexa("Bmsfbez!fyfdvufe\""));
        }
        this.executed = true;
        this.rawCall = this.request.getRawCall();
        if (this.canceled) {
            this.rawCall.cancel();
        }
        return this.rawCall;
    }

    public void printErrorLog(String str, String str2) {
        if (OkHttp.enableHttpLog) {
            StringBuilder sb = new StringBuilder(dexc.dexa("䁑") + Thread.currentThread().getName() + dexc.dexa("䁒"));
            sb.append(str);
            sb.append(dexc.dexa("\u000bsfrvftu!vsm>"));
            sb.append(this.rawCall.request().url());
            sb.append(dexc.dexa("\u000bsfrvftu!nfuipe>"));
            sb.append(this.rawCall.request().method());
            sb.append(dexc.dexa("\u000bsfrvftu!fssps>"));
            sb.append(str2);
            sb.append(dexc.dexa("\u000bꈎ鰖ꆎ辯>"));
            sb.append(this.currentRetryCount + dexc.dexa("0") + this.request.getRetryCount());
            sb.append("\n\t");
            doPrintLog(sb.toString());
        }
    }

    public void printRequestLog(String str) {
        if (OkHttp.enableHttpLog) {
            doPrintLog((dexc.dexa("䁑") + Thread.currentThread().getName() + dexc.dexa("䁒")) + str + dexc.dexa("\u000bsfrvftu!vsm>") + this.rawCall.request().url() + dexc.dexa("\u000bsfrvftu!nfuipe>") + this.rawCall.request().method() + dexc.dexa("\u000bsfrvftu!ifbefst;\u000b") + this.rawCall.request().headers() + "\n\t");
        }
    }

    public void printResponseLog(String str, Response response) {
        String strString;
        if (OkHttp.enableHttpLog) {
            try {
                String strMethod = response.request().method();
                MediaType mediaTypeContentType = response.body().contentType();
                StringBuilder sb = new StringBuilder(dexc.dexa("䁑") + Thread.currentThread().getName() + dexc.dexa("䁒"));
                sb.append(str);
                sb.append(dexc.dexa("\u000bsftqpotf!vsm>"));
                sb.append(response.request().url());
                sb.append(dexc.dexa("\u000bsftqpotf!nfuipe>"));
                sb.append(strMethod);
                sb.append(dexc.dexa("\u000bsftqpotf!dpef>"));
                sb.append(response.code());
                sb.append(dexc.dexa("\u000bsftqpotf!nfejbUzqf>"));
                sb.append(mediaTypeContentType);
                if (dexc.dexa("HFU").equalsIgnoreCase(strMethod)) {
                    if (dexc.dexa("ufyu").equals(mediaTypeContentType == null ? "" : mediaTypeContentType.type()) || ((mediaTypeContentType != null && mediaTypeContentType.toString().startsWith(dexc.dexa("bqqmjdbujpo0ktpo"))) || (mediaTypeContentType != null && mediaTypeContentType.toString().startsWith(dexc.dexa("bqqmjdbujpo0ynm"))))) {
                        strString = response.peekBody(Long.MAX_VALUE).string();
                        sb.append(dexc.dexa("\u000bsftqpotf!cpez>"));
                        sb.append(strString);
                    }
                } else if (dexc.dexa("QPTU").equalsIgnoreCase(strMethod)) {
                    String str2 = response.request().headers().get(dexc.dexa("Dpoufou.Uzqf"));
                    if (TextUtils.isEmpty(str2) || !str2.equalsIgnoreCase(dexc.dexa("bqqmjdbujpo0pdufu.tusfbn"))) {
                        strString = dexc.dexa("\u000bsftqpotf!cpez>") + response.peekBody(Long.MAX_VALUE).string();
                        sb.append(strString);
                    } else {
                        try {
                            byte[] bArrBytes = response.peekBody(Long.MAX_VALUE).bytes();
                            if (bArrBytes != null && bArrBytes.length > 0) {
                                sb.append(dexc.dexa("\u000bsftqpotf!cpez>") + GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(bArrBytes, OkHttp.appToken, dexc.dexa("qptu!sftqpotf"))));
                            }
                        } catch (Throwable th) {
                            Log.w(TAG, dexc.dexa("騤矑qptu鰸粃攎滕狦痈楲鵦!") + th);
                        }
                    }
                }
                sb.append("\n\t");
                doPrintLog(sb.toString());
            } catch (Throwable th2) {
                doPrintLog(dexc.dexa("qsjouSftqpotfMph!gbjm!") + th2);
            }
        }
    }

    public void requestNetworkAsync() {
        requestNetworkAsync(true);
    }

    public void requestNetworkAsync(final boolean z) {
        printRequestLog(dexc.dexa("潃箦鰸粃"));
        this.rawCall.enqueue(new okhttp3.Callback() { // from class: cj.mobile.wm.okhttp.cache.policy.BaseCachePolicy.1
            public void onFailure(Call call, IOException iOException) {
                BaseCachePolicy.this.printErrorLog(dexc.dexa("潃箦鰸粃楲鵦"), iOException.toString());
                if (!(iOException instanceof SocketTimeoutException) || BaseCachePolicy.this.currentRetryCount >= BaseCachePolicy.this.request.getRetryCount()) {
                    if (call.isCanceled()) {
                        return;
                    }
                    BaseCachePolicy.this.onError(cj.mobile.wm.okhttp.model.Response.error(false, call, null, iOException));
                    return;
                }
                BaseCachePolicy.this.currentRetryCount++;
                BaseCachePolicy baseCachePolicy = BaseCachePolicy.this;
                baseCachePolicy.rawCall = baseCachePolicy.request.getRawCall();
                if (BaseCachePolicy.this.canceled) {
                    BaseCachePolicy.this.rawCall.cancel();
                } else {
                    BaseCachePolicy.this.rawCall.enqueue(this);
                }
            }

            public void onResponse(Call call, Response response) {
                BaseCachePolicy.this.printResponseLog(dexc.dexa("潃箦鰸粃母牑"), response);
                int iCode = response.code();
                if (iCode == 404 || iCode >= 500) {
                    BaseCachePolicy.this.onError(cj.mobile.wm.okhttp.model.Response.error(false, call, response, HttpException.NET_ERROR()));
                    return;
                }
                if (BaseCachePolicy.this.onAnalysisResponse(call, response)) {
                    return;
                }
                try {
                    T tConvertResponse = BaseCachePolicy.this.request.getConverter().convertResponse(response);
                    BaseCachePolicy.this.saveCache(response.headers(), tConvertResponse);
                    cj.mobile.wm.okhttp.model.Response<T> responseSuccess = cj.mobile.wm.okhttp.model.Response.success(false, tConvertResponse, call, response);
                    if (z) {
                        BaseCachePolicy.this.onSuccess(responseSuccess);
                    }
                } catch (Throwable th) {
                    BaseCachePolicy.this.onError(cj.mobile.wm.okhttp.model.Response.error(false, call, response, th));
                }
            }
        });
    }

    public cj.mobile.wm.okhttp.model.Response<T> requestNetworkSync() {
        try {
            printRequestLog(dexc.dexa("摍箦鰸粃"));
            Response responseExecute = this.rawCall.execute();
            printResponseLog(dexc.dexa("摍箦鰸粃母牑"), responseExecute);
            int iCode = responseExecute.code();
            if (iCode != 404 && iCode < 500) {
                T tConvertResponse = this.request.getConverter().convertResponse(responseExecute);
                saveCache(responseExecute.headers(), tConvertResponse);
                return cj.mobile.wm.okhttp.model.Response.success(false, tConvertResponse, this.rawCall, responseExecute);
            }
            return cj.mobile.wm.okhttp.model.Response.error(false, this.rawCall, responseExecute, HttpException.NET_ERROR());
        } catch (Throwable th) {
            printErrorLog(dexc.dexa("摍箦鰸粃楲鵦"), th.toString());
            if ((th instanceof SocketTimeoutException) && this.currentRetryCount < this.request.getRetryCount()) {
                this.currentRetryCount++;
                this.rawCall = this.request.getRawCall();
                if (this.canceled) {
                    this.rawCall.cancel();
                } else {
                    requestNetworkSync();
                }
            }
            return cj.mobile.wm.okhttp.model.Response.error(false, this.rawCall, null, th);
        }
    }
}
