package com.acse.ottn;

import androidx.annotation.Nullable;
import com.zj.adlib.u15;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p1 extends EventListener {
    public static final String d = "HttpEventListener";
    public static final EventListener.Factory e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f23124a;
    public final long b;
    public StringBuilder c;

    public class a implements EventListener.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicLong f23125a = new AtomicLong(1);

        public EventListener create(Call call) {
            return new p1(this.f23125a.getAndIncrement(), call.request().url(), System.nanoTime());
        }
    }

    public p1(long j, HttpUrl httpUrl, long j2) {
        this.f23124a = j;
        this.b = j2;
        StringBuilder sb = new StringBuilder(httpUrl.toString());
        sb.append(" ");
        sb.append(j);
        sb.append(u15.f19942b);
        this.c = sb;
    }

    public final void a(String str) {
        long jNanoTime = System.nanoTime() - this.b;
        StringBuilder sb = this.c;
        sb.append(String.format(Locale.CHINA, "%.3f-%s", Double.valueOf(jNanoTime / 1.0E9d), str));
        sb.append(com.alipay.sdk.m.y.l.b);
        if (str.equalsIgnoreCase("callEnd") || str.equalsIgnoreCase("callFailed")) {
            h2.a(d, this.c.toString());
        }
    }

    public void callEnd(Call call) {
        super.callEnd(call);
        a("callEnd");
    }

    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        a("callFailed");
    }

    public void callStart(Call call) {
        super.callStart(call);
        a("callStart");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        a("connectEnd");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        a("connectFailed");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        a("connectStart");
    }

    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        a("connectionAcquired");
    }

    public void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        a("connectionReleased");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        a("dnsEnd");
    }

    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        a("dnsStart");
    }

    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        a("requestBodyEnd");
    }

    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        a("requestBodyStart");
    }

    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        a("requestHeadersEnd");
    }

    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        a("requestHeadersStart");
    }

    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        a("responseBodyEnd");
    }

    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        a("responseBodyStart");
    }

    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        a("responseHeadersEnd");
    }

    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        a("responseHeadersStart");
    }

    public void secureConnectEnd(Call call, @Nullable Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        a("secureConnectEnd");
    }

    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        a("secureConnectStart");
    }
}
