package com.igexin.push.f.a;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.http.Call;
import com.getui.gtc.base.http.GtHttpClient;
import com.getui.gtc.base.http.Interceptor;
import com.getui.gtc.base.http.LoggerInterceptor;
import com.getui.gtc.base.http.MediaType;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.RequestBody;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.http.crypt.GtRASCryptoInterceptor;
import com.getui.gtc.base.util.NetworkUtil;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static GtHttpClient f38115a = new GtHttpClient.Builder().addInterceptor(new LoggerInterceptor(com.igexin.c.a.c.a.a().f37831a)).addInterceptor(new Interceptor() { // from class: com.igexin.push.f.a.c.1
        @Override // com.getui.gtc.base.http.Interceptor
        public final Response intercept(Interceptor.Chain chain) throws IOException {
            if (GtcProvider.context() == null || NetworkUtil.isNetWorkAvailable(GtcProvider.context())) {
                return chain.proceed(chain.request());
            }
            throw new IllegalStateException("network is not available");
        }
    }).build();
    private static String b = "c";

    public static void a(String str, byte[] bArr, Call.Callback callback) {
        try {
            f38115a.newCall(new Request.Builder().url(str).method("POST").cryptInterceptor(new GtRASCryptoInterceptor(com.igexin.push.a.j, com.igexin.push.a.k)).body(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), bArr)).build()).enqueue(callback);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
