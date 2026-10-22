package com.getui.gtc.base.http;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Call {

    public interface Callback {
        void onFailure(Call call, Exception exc);

        void onResponse(Call call, Response response);
    }

    void cancel();

    void enqueue(Callback callback);

    Response execute() throws Exception;

    boolean isCanceled();

    boolean isExecuted();

    Request request();
}
