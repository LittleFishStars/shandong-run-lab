package com.getui.gtc.base.http;

import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Interceptor {

    public interface Chain {
        HttpURLConnection connection();

        Response proceed(Request request) throws IOException;

        Request request();
    }

    Response intercept(Chain chain) throws IOException;
}
