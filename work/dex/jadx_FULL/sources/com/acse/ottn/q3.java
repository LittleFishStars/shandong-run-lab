package com.acse.ottn;

import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.zj.adlib.ao7;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class q3 {
    public static final String e = "RetrofitServiceManager";
    public static final String f = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f23142a = {"1", "2", "3", "4", "5", "6", "7", PrepareException.ERROR_AUTH_FAIL, "9", "0", "a", "b", "c", "d", "e", "f", y6b.f, y6b.g, "i", "j", "k", com.kuaishou.weapon.p0.t.d, "m", "n", com.google.android.exoplayer2.source.rtsp.j.b, "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", com.google.android.exoplayer2.source.rtsp.j.o};
    public final HttpLoggingInterceptor b;
    public final Interceptor c;
    public final OkHttpClient d;

    public class a implements HttpLoggingInterceptor.Logger {
        public a() {
        }

        public void log(String str) {
            if (str.contains("http://118.89.189.246")) {
                return;
            }
            h2.a(q3.e, str);
        }
    }

    public class b implements Interceptor {
        public b() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request.Builder builderNewBuilder = chain.request().newBuilder();
            builderNewBuilder.addHeader("Accept", ze1.g);
            builderNewBuilder.addHeader("Content-Type", "application/json;utf-8");
            return chain.proceed(builderNewBuilder.build());
        }
    }

    public class c implements HostnameVerifier {
        public c() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public q3() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new a());
        this.b = httpLoggingInterceptor;
        b bVar = new b();
        this.c = bVar;
        OkHttpClient.Builder builderAddInterceptor = new OkHttpClient.Builder().addInterceptor(bVar).addInterceptor(httpLoggingInterceptor);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.d = builderAddInterceptor.connectTimeout(10L, timeUnit).readTimeout(20L, timeUnit).retryOnConnectionFailure(true).sslSocketFactory(x3.b(), x3.d()).hostnameVerifier(new c()).build();
    }

    public retrofit2.g a() {
        this.b.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new retrofit2.g.b().j(this.d).b(d1.a()).a(ao7.d(Schedulers.io())).c(c() == null ? "" : c()).f();
    }

    public retrofit2.g b() {
        return new retrofit2.g.b().j(this.d).b(c1.a()).a(ao7.d(Schedulers.io())).c(c() == null ? "" : c()).f();
    }

    public abstract String c();
}
