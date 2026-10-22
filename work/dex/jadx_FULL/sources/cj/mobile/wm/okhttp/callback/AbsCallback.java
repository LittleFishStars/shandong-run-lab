package cj.mobile.wm.okhttp.callback;

import cj.mobile.wm.okhttp.model.Progress;
import cj.mobile.wm.okhttp.model.Response;
import cj.mobile.wm.okhttp.request.base.Request;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AbsCallback<T> implements Callback<T> {
    @Override // cj.mobile.wm.okhttp.callback.Callback
    public void downloadProgress(Progress progress) {
    }

    @Override // cj.mobile.wm.okhttp.callback.Callback
    public void onCacheSuccess(Response<T> response) {
    }

    @Override // cj.mobile.wm.okhttp.callback.Callback
    public void onError(Response<T> response) {
    }

    @Override // cj.mobile.wm.okhttp.callback.Callback
    public void onFinish() {
    }

    @Override // cj.mobile.wm.okhttp.callback.Callback
    public void onStart(Request<T, ? extends Request> request) {
    }

    @Override // cj.mobile.wm.okhttp.callback.Callback
    public void uploadProgress(Progress progress) {
    }
}
