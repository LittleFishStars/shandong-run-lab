package cj.mobile.wm.okhttp.cache.policy;

import android.util.Log;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.cache.CacheEntity;
import cj.mobile.wm.okhttp.callback.Callback;
import cj.mobile.wm.okhttp.exception.CacheException;
import cj.mobile.wm.okhttp.request.base.Request;
import okhttp3.Call;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultCachePolicy<T> extends BaseCachePolicy<T> {
    public static final String TAG = dexc.dexa("XN`EfgbvmuDbdifQpmjdz");

    public DefaultCachePolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    @Override // cj.mobile.wm.okhttp.cache.policy.BaseCachePolicy, cj.mobile.wm.okhttp.cache.policy.CachePolicy
    public boolean onAnalysisResponse(Call call, Response response) {
        if (response.code() != 304) {
            return false;
        }
        CacheEntity<T> cacheEntity = this.cacheEntity;
        if (cacheEntity == null) {
            onError(cj.mobile.wm.okhttp.model.Response.error(true, call, response, CacheException.NON_AND_304(this.request.getCacheKey())));
        } else {
            onCacheSuccess(cj.mobile.wm.okhttp.model.Response.success(true, cacheEntity.getData(), call, response));
        }
        return true;
    }

    public void onCacheSuccess(cj.mobile.wm.okhttp.model.Response<T> response) {
        try {
            Callback<T> callback = this.mCallback;
            if (callback != null) {
                callback.onCacheSuccess(response);
                this.mCallback.onFinish();
            } else {
                Log.w(TAG, dexc.dexa("poDbdifTvddftt!nDbmmcbdl!jt!ovmm"));
            }
        } catch (Throwable th) {
            Log.w(TAG, dexc.dexa("poDbdifTvddftt!gbjm-") + Log.getStackTraceString(th));
        }
    }

    @Override // cj.mobile.wm.okhttp.cache.policy.CachePolicy
    public void onError(cj.mobile.wm.okhttp.model.Response<T> response) {
        try {
            Callback<T> callback = this.mCallback;
            if (callback != null) {
                callback.onError(response);
                this.mCallback.onFinish();
            } else {
                Log.w(TAG, dexc.dexa("poFssps!nDbmmcbdl!jt!ovmm"));
            }
        } catch (Throwable th) {
            Log.w(TAG, dexc.dexa("poFssps!gbjm-") + Log.getStackTraceString(th));
        }
    }

    @Override // cj.mobile.wm.okhttp.cache.policy.CachePolicy
    public void onSuccess(cj.mobile.wm.okhttp.model.Response<T> response) {
        try {
            Callback<T> callback = this.mCallback;
            if (callback != null) {
                callback.onSuccess(response);
                this.mCallback.onFinish();
            } else {
                Log.w(TAG, dexc.dexa("poTvddftt!nDbmmcbdl!jt!ovmm"));
            }
        } catch (Throwable th) {
            Log.w(TAG, dexc.dexa("poTvddftt!gbjm-") + Log.getStackTraceString(th));
        }
    }

    @Override // cj.mobile.wm.okhttp.cache.policy.CachePolicy
    public void requestAsync(CacheEntity<T> cacheEntity, Callback<T> callback) {
        this.mCallback = callback;
        try {
            prepareRawCall();
            requestNetworkAsync();
        } catch (Throwable th) {
            onError(cj.mobile.wm.okhttp.model.Response.error(false, this.rawCall, null, th));
        }
    }

    @Override // cj.mobile.wm.okhttp.cache.policy.CachePolicy
    public cj.mobile.wm.okhttp.model.Response<T> requestSync(CacheEntity<T> cacheEntity) {
        try {
            prepareRawCall();
            cj.mobile.wm.okhttp.model.Response<T> responseRequestNetworkSync = requestNetworkSync();
            if (responseRequestNetworkSync.isSuccessful() && responseRequestNetworkSync.code() == 304) {
                return cacheEntity == null ? cj.mobile.wm.okhttp.model.Response.error(true, this.rawCall, responseRequestNetworkSync.getRawResponse(), CacheException.NON_AND_304(this.request.getCacheKey())) : cj.mobile.wm.okhttp.model.Response.success(true, cacheEntity.getData(), this.rawCall, responseRequestNetworkSync.getRawResponse());
            }
            return responseRequestNetworkSync;
        } catch (Throwable th) {
            return cj.mobile.wm.okhttp.model.Response.error(false, this.rawCall, null, th);
        }
    }
}
