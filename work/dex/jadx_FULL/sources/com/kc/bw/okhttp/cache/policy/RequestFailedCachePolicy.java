package com.kc.bw.okhttp.cache.policy;

import android.util.Log;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.cache.CacheEntity;
import com.kc.bw.okhttp.callback.Callback;
import com.kc.bw.okhttp.model.Response;
import com.kc.bw.okhttp.request.base.Request;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class RequestFailedCachePolicy<T> extends BaseCachePolicy<T> {
    public static final String TAG = dexg.dexa("XN`SfrvftuGbjmfeDbdif");

    public RequestFailedCachePolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public void onError(Response<T> response) {
        try {
            Callback<T> callback = this.mCallback;
            if (callback == null) {
                Log.w(TAG, dexg.dexa("poFssps!nDbmmcbdl!jt!ovmm"));
                return;
            }
            CacheEntity<T> cacheEntity = this.cacheEntity;
            if (cacheEntity != null) {
                this.mCallback.onCacheSuccess(Response.success(true, cacheEntity.getData(), response.getRawCall(), response.getRawResponse()));
            } else {
                callback.onError(response);
            }
            this.mCallback.onFinish();
        } catch (Throwable th) {
            Log.w(TAG, dexg.dexa("poFssps!gbjm-") + Log.getStackTraceString(th));
        }
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public void onSuccess(Response<T> response) {
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
            onError(Response.error(false, this.rawCall, null, th));
        }
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public Response<T> requestSync(CacheEntity<T> cacheEntity) {
        try {
            prepareRawCall();
            Response<T> responseRequestNetworkSync = requestNetworkSync();
            return (responseRequestNetworkSync.isSuccessful() || cacheEntity == null) ? responseRequestNetworkSync : Response.success(true, cacheEntity.getData(), this.rawCall, responseRequestNetworkSync.getRawResponse());
        } catch (Throwable th) {
            return Response.error(false, this.rawCall, null, th);
        }
    }
}
