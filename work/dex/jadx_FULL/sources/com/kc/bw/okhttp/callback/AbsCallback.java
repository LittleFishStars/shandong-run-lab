package com.kc.bw.okhttp.callback;

import com.kc.bw.okhttp.model.Progress;
import com.kc.bw.okhttp.model.Response;
import com.kc.bw.okhttp.request.base.Request;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class AbsCallback<T> implements Callback<T> {
    @Override // com.kc.bw.okhttp.callback.Callback
    public void downloadProgress(Progress progress) {
    }

    @Override // com.kc.bw.okhttp.callback.Callback
    public void onCacheSuccess(Response<T> response) {
    }

    @Override // com.kc.bw.okhttp.callback.Callback
    public void onError(Response<T> response) {
    }

    @Override // com.kc.bw.okhttp.callback.Callback
    public void onFinish() {
    }

    @Override // com.kc.bw.okhttp.callback.Callback
    public void onStart(Request<T, ? extends Request> request) {
    }

    @Override // com.kc.bw.okhttp.callback.Callback
    public void uploadProgress(Progress progress) {
    }
}
