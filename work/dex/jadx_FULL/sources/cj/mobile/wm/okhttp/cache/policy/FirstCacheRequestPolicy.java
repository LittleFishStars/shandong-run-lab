package cj.mobile.wm.okhttp.cache.policy;

import android.util.Log;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.cache.CacheEntity;
import cj.mobile.wm.okhttp.callback.Callback;
import cj.mobile.wm.okhttp.model.Response;
import cj.mobile.wm.okhttp.request.base.Request;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FirstCacheRequestPolicy<T> extends BaseCachePolicy<T> {
    public static final String TAG = dexc.dexa("XN`GjstuDbdifSfrvftu");

    public FirstCacheRequestPolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    public void onCacheSuccess(Response<T> response) {
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
    public void onError(Response<T> response) {
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
    public void onSuccess(Response<T> response) {
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
            if (cacheEntity != null) {
                onCacheSuccess(Response.success(true, cacheEntity.getData(), this.rawCall, null));
            }
            requestNetworkAsync();
        } catch (Throwable th) {
            onError(Response.error(false, this.rawCall, null, th));
        }
    }

    @Override // cj.mobile.wm.okhttp.cache.policy.CachePolicy
    public Response<T> requestSync(CacheEntity<T> cacheEntity) {
        try {
            prepareRawCall();
            if (cacheEntity != null) {
                Response.success(true, cacheEntity.getData(), this.rawCall, null);
            }
            Response<T> responseRequestNetworkSync = requestNetworkSync();
            return (responseRequestNetworkSync.isSuccessful() || cacheEntity == null) ? responseRequestNetworkSync : Response.success(true, cacheEntity.getData(), this.rawCall, responseRequestNetworkSync.getRawResponse());
        } catch (Throwable th) {
            return Response.error(false, this.rawCall, null, th);
        }
    }
}
