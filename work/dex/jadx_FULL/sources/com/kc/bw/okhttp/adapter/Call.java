package com.kc.bw.okhttp.adapter;

import com.kc.bw.okhttp.callback.Callback;
import com.kc.bw.okhttp.model.Response;
import com.kc.bw.okhttp.request.base.Request;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface Call<T> {
    void cancel();

    Call<T> clone();

    Response<T> execute();

    void execute(Callback<T> callback);

    Request getRequest();

    boolean isCanceled();

    boolean isExecuted();
}
