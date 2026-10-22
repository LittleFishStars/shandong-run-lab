package cj.mobile.wm.okhttp.callback;

import cj.mobile.wm.okhttp.convert.Converter;
import cj.mobile.wm.okhttp.model.Progress;
import cj.mobile.wm.okhttp.model.Response;
import cj.mobile.wm.okhttp.request.base.Request;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Callback<T> extends Converter<T> {
    void downloadProgress(Progress progress);

    void onCacheSuccess(Response<T> response);

    void onError(Response<T> response);

    void onFinish();

    void onStart(Request<T, ? extends Request> request);

    void onSuccess(Response<T> response);

    void uploadProgress(Progress progress);
}
