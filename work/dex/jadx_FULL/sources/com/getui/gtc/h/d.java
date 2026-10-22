package com.getui.gtc.h;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.http.GtHttpClient;
import com.getui.gtc.base.http.Interceptor;
import com.getui.gtc.base.http.LoggerInterceptor;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.util.NetworkUtil;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static GtHttpClient f30374a = new GtHttpClient.Builder().addInterceptor(new LoggerInterceptor(com.getui.gtc.i.c.a.C0658a.f30380a.f30379a)).addInterceptor(new Interceptor() { // from class: com.getui.gtc.h.d.1
        @Override // com.getui.gtc.base.http.Interceptor
        public final Response intercept(Interceptor.Chain chain) throws IOException {
            if (NetworkUtil.isNetWorkAvailable(GtcProvider.context())) {
                return chain.proceed(chain.request());
            }
            throw new IllegalStateException("network is not available");
        }
    }).build();
}
