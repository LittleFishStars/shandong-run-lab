package com.kc.bw.okhttp.cache.policy;

import com.kc.bw.okhttp.cache.CacheEntity;
import com.kc.bw.okhttp.callback.Callback;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import okhttp3.Call;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface CachePolicy<T> {
    void cancel();

    boolean isCanceled();

    boolean isExecuted();

    boolean onAnalysisResponse(Call call, Response response);

    void onError(com.kc.bw.okhttp.model.Response<T> response);

    void onSuccess(com.kc.bw.okhttp.model.Response<T> response);

    CacheEntity<T> prepareCache();

    Call prepareRawCall();

    void requestAsync(CacheEntity<T> cacheEntity, Callback<T> callback);

    com.kc.bw.okhttp.model.Response<T> requestSync(CacheEntity<T> cacheEntity);
}
