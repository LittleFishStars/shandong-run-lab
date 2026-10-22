package com.kc.bw.okhttp.cache.policy;

import android.util.Log;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.cache.CacheEntity;
import com.kc.bw.okhttp.callback.Callback;
import com.kc.bw.okhttp.exception.CacheException;
import com.kc.bw.okhttp.request.base.Request;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import okhttp3.Call;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DefaultCachePolicy<T> extends BaseCachePolicy<T> {
    public static final String TAG = dexg.dexa("XN`EfgbvmuDbdifQpmjdz");

    public DefaultCachePolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    @Override // com.kc.bw.okhttp.cache.policy.BaseCachePolicy, com.kc.bw.okhttp.cache.policy.CachePolicy
    public boolean onAnalysisResponse(Call call, Response response) {
        if (response.code() != 304) {
            return false;
        }
        CacheEntity<T> cacheEntity = this.cacheEntity;
        if (cacheEntity == null) {
            onError(com.kc.bw.okhttp.model.Response.error(true, call, response, CacheException.NON_AND_304(this.request.getCacheKey())));
        } else {
            onCacheSuccess(com.kc.bw.okhttp.model.Response.success(true, cacheEntity.getData(), call, response));
        }
        return true;
    }

    public void onCacheSuccess(com.kc.bw.okhttp.model.Response<T> response) {
        try {
            Callback<T> callback = this.mCallback;
            if (callback != null) {
                callback.onCacheSuccess(response);
                this.mCallback.onFinish();
            } else {
                Log.w(TAG, dexg.dexa("poDbdifTvddftt!nDbmmcbdl!jt!ovmm"));
            }
        } catch (Throwable th) {
            Log.w(TAG, dexg.dexa("poDbdifTvddftt!gbjm-") + Log.getStackTraceString(th));
        }
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public void onError(com.kc.bw.okhttp.model.Response<T> response) {
        try {
            Callback<T> callback = this.mCallback;
            if (callback != null) {
                callback.onError(response);
                this.mCallback.onFinish();
            } else {
                Log.w(TAG, dexg.dexa("poFssps!nDbmmcbdl!jt!ovmm"));
            }
        } catch (Throwable th) {
            Log.w(TAG, dexg.dexa("poFssps!gbjm-") + Log.getStackTraceString(th));
        }
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public void onSuccess(com.kc.bw.okhttp.model.Response<T> response) {
        try {
            Callback<T> callback = this.mCallback;
            if (callback != null) {
                callback.onSuccess(response);
                this.mCallback.onFinish();
            } else {
                Log.w(TAG, dexg.dexa("poTvddftt!nDbmmcbdl!jt!ovmm"));
            }
        } catch (Throwable th) {
            Log.w(TAG, dexg.dexa("poTvddftt!gbjm-") + Log.getStackTraceString(th));
        }
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public void requestAsync(CacheEntity<T> cacheEntity, Callback<T> callback) {
        this.mCallback = callback;
        try {
            prepareRawCall();
            requestNetworkAsync();
        } catch (Throwable th) {
            onError(com.kc.bw.okhttp.model.Response.error(false, this.rawCall, null, th));
        }
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public com.kc.bw.okhttp.model.Response<T> requestSync(CacheEntity<T> cacheEntity) {
        try {
            prepareRawCall();
            com.kc.bw.okhttp.model.Response<T> responseRequestNetworkSync = requestNetworkSync();
            if (responseRequestNetworkSync.isSuccessful() && responseRequestNetworkSync.code() == 304) {
                return cacheEntity == null ? com.kc.bw.okhttp.model.Response.error(true, this.rawCall, responseRequestNetworkSync.getRawResponse(), CacheException.NON_AND_304(this.request.getCacheKey())) : com.kc.bw.okhttp.model.Response.success(true, cacheEntity.getData(), this.rawCall, responseRequestNetworkSync.getRawResponse());
            }
            return responseRequestNetworkSync;
        } catch (Throwable th) {
            return com.kc.bw.okhttp.model.Response.error(false, this.rawCall, null, th);
        }
    }
}
