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
public class NoCachePolicy<T> extends BaseCachePolicy<T> {
    public static final String TAG = dexg.dexa("XN`OpDbdifQpmjdz");

    public NoCachePolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    @Override // com.kc.bw.okhttp.cache.policy.CachePolicy
    public void onError(Response<T> response) {
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
            return requestNetworkSync();
        } catch (Throwable th) {
            return Response.error(false, this.rawCall, null, th);
        }
    }
}
