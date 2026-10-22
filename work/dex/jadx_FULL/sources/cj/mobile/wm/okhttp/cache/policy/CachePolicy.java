package cj.mobile.wm.okhttp.cache.policy;

import cj.mobile.wm.okhttp.cache.CacheEntity;
import cj.mobile.wm.okhttp.callback.Callback;
import okhttp3.Call;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface CachePolicy<T> {
    void cancel();

    boolean isCanceled();

    boolean isExecuted();

    boolean onAnalysisResponse(Call call, Response response);

    void onError(cj.mobile.wm.okhttp.model.Response<T> response);

    void onSuccess(cj.mobile.wm.okhttp.model.Response<T> response);

    CacheEntity<T> prepareCache();

    Call prepareRawCall();

    void requestAsync(CacheEntity<T> cacheEntity, Callback<T> callback);

    cj.mobile.wm.okhttp.model.Response<T> requestSync(CacheEntity<T> cacheEntity);
}
