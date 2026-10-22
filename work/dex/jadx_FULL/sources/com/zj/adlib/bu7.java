package com.zj.adlib;

import android.annotation.SuppressLint;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/zj/adlib/bu7;", "", "Ljavax/net/ssl/SSLSocketFactory;", "d", "()Ljavax/net/ssl/SSLSocketFactory;", "ssLSocketFactory", "", "Ljavax/net/ssl/X509TrustManager;", "e", "()[Ljavax/net/ssl/X509TrustManager;", "trustManager", "Ljavax/net/ssl/HostnameVerifier;", "c", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public final class bu7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bu7 f40840a = new bu7();

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\u000b\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ+\u0010\n\u001a\u00020\u00072\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0017¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/zj/adlib/bu7$a", "Ljavax/net/ssl/X509TrustManager;", "", "Ljava/security/cert/X509Certificate;", "chain", "", "authType", "", "checkClientTrusted", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    @SuppressLint({"CustomX509TrustManager"})
    public static final class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(@Nullable X509Certificate[] chain, @Nullable String authType) {
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(@Nullable X509Certificate[] chain, @Nullable String authType) {
        }

        @Override // javax.net.ssl.X509TrustManager
        @NotNull
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static final boolean b(String str, SSLSession sSLSession) {
        return true;
    }

    @NotNull
    public final HostnameVerifier c() {
        return new HostnameVerifier() { // from class: com.zj.adlib.au7
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return bu7.b(str, sSLSession);
            }
        };
    }

    @NotNull
    public final SSLSocketFactory d() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, e(), new SecureRandom());
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "{\n            val sslCon…t.socketFactory\n        }");
            return socketFactory;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    public final X509TrustManager[] e() {
        return new X509TrustManager[]{new a()};
    }
}
