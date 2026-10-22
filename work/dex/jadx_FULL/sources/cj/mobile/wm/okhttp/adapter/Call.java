package cj.mobile.wm.okhttp.adapter;

import cj.mobile.wm.okhttp.callback.Callback;
import cj.mobile.wm.okhttp.model.Response;
import cj.mobile.wm.okhttp.request.base.Request;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Call<T> {
    void cancel();

    Call<T> clone();

    Response<T> execute();

    void execute(Callback<T> callback);

    Request getRequest();

    boolean isCanceled();

    boolean isExecuted();
}
