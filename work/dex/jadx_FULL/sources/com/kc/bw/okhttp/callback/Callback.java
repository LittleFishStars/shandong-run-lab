package com.kc.bw.okhttp.callback;

import com.kc.bw.okhttp.convert.Converter;
import com.kc.bw.okhttp.model.Progress;
import com.kc.bw.okhttp.model.Response;
import com.kc.bw.okhttp.request.base.Request;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface Callback<T> extends Converter<T> {
    void downloadProgress(Progress progress);

    void onCacheSuccess(Response<T> response);

    void onError(Response<T> response);

    void onFinish();

    void onStart(Request<T, ? extends Request> request);

    void onSuccess(Response<T> response);

    void uploadProgress(Progress progress);
}
