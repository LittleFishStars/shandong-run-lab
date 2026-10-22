package com.baidu.location.b;

import android.text.TextUtils;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class r {
    private static final Lock c = new ReentrantLock();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OkHttpClient f26388a;
    private String b = null;

    public interface a {
        void a(int i, String str);

        void a(int i, String str, byte[] bArr);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final r f26390a = new r();
    }

    public r() {
        b();
    }

    public static r a() {
        return b.f26390a;
    }

    private RequestBody a(Map<String, Object> map) {
        c.lock();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        MediaType mediaType = MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE);
        String string = sb.toString();
        c.unlock();
        return RequestBody.create(mediaType, string);
    }

    private synchronized void b() {
        try {
            if (this.f26388a == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                try {
                    String str = com.baidu.location.e.h.aZ;
                    int i = com.baidu.location.e.h.ba;
                    if (!TextUtils.isEmpty(str) && i != -1) {
                        builder.proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(str, i)));
                        final String str2 = com.baidu.location.e.h.bb;
                        final String str3 = com.baidu.location.e.h.bc;
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            builder.authenticator(new Authenticator() { // from class: com.baidu.location.b.r.1
                                public Request authenticate(Route route, Response response) {
                                    return response.request().newBuilder().header(com.google.common.net.b.H, Credentials.basic(str2, str3)).build();
                                }
                            });
                        }
                    }
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    this.f26388a = builder.connectTimeout(12000L, timeUnit).readTimeout(12000L, timeUnit).writeTimeout(12000L, timeUnit).dns(l.a().c()).build();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private Request.Builder c() {
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        String str = com.baidu.location.e.h.aw;
        if (str != null) {
            builder.addHeader("bd-loc-android", str);
        }
        return builder;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(Map<String, Object> map, String str, a aVar) {
        StringBuilder sb;
        try {
            RequestBody requestBodyA = a(map);
            Request.Builder builderC = c();
            String str2 = this.b;
            if (str2 != null) {
                builderC.addHeader("alwd", str2);
            }
            Response responseExecute = this.f26388a.newCall(builderC.url(str).post(requestBodyA).build()).execute();
            if (!responseExecute.isSuccessful()) {
                aVar.a(responseExecute.code(), responseExecute.message());
            } else if (responseExecute.body() != null) {
                aVar.a(200, responseExecute.body().string(), new byte[1]);
            } else {
                aVar.a(400, responseExecute.message());
            }
        } catch (IOException e) {
            e = e;
            e.printStackTrace();
            if (aVar != null) {
                sb = new StringBuilder();
                sb.append("e=");
                sb.append(e.getMessage());
                aVar.a(-100, sb.toString());
            }
        } catch (Exception e2) {
            e = e2;
            if (aVar != null) {
                sb = new StringBuilder();
                sb.append("e=");
                sb.append(e.getMessage());
                aVar.a(-100, sb.toString());
            }
        }
    }
}
