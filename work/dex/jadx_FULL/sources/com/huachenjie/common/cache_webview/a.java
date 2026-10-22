package com.huachenjie.common.cache_webview;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.common.net.b;
import com.huachenjie.common.cache_webview.interceptor.ResourceInterceptor;
import com.huachenjie.common.cache_webview.interceptor.WebViewCacheInterceptor;
import com.huachenjie.common.cache_webview.loader.AssetsLoader;
import com.huachenjie.common.cache_webview.loader.DynamicCacheLoader;
import com.ipd.dsp.internal.l0.g;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.g24;
import com.zj.adlib.mg3;
import com.zj.adlib.s91;
import com.zj.adlib.ux5;
import com.zj.adlib.y6b;
import com.zj.adlib.zo5;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\fB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0002J&\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0018H\u0002R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010 R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010 ¨\u0006&"}, d2 = {"Lcom/huachenjie/common/cache_webview/a;", "Lcom/huachenjie/common/cache_webview/interceptor/WebViewCacheInterceptor;", "Landroid/webkit/WebResourceRequest;", "request", "Landroid/webkit/WebResourceResponse;", "d", "", "url", "c", "Landroid/webkit/WebView;", "webView", "", "b", "", "additionalHttpHeaders", "a", "clearCache", y6b.f, "", "f", "Lokhttp3/Request$Builder;", "reqBuilder", "headers", "e", "", y6b.g, "Lcom/huachenjie/common/cache_webview/a$a;", "Lcom/huachenjie/common/cache_webview/a$a;", "builder", "Lokhttp3/OkHttpClient;", "Lokhttp3/OkHttpClient;", "mHttpClient", "Ljava/lang/String;", "mOrigin", "mReferer", "mUserAgent", "<init>", "(Lcom/huachenjie/common/cache_webview/a$a;)V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWebViewCacheDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewCacheDelegate.kt\ncom/huachenjie/common/cache_webview/WebViewCacheDelegate\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,335:1\n215#2,2:336\n*S KotlinDebug\n*F\n+ 1 WebViewCacheDelegate.kt\ncom/huachenjie/common/cache_webview/WebViewCacheDelegate\n*L\n92#1:336,2\n*E\n"})
public final class a implements WebViewCacheInterceptor {

    @NotNull
    public static final String d = "CacheWebView";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final C0794a builder;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String mOrigin;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public OkHttpClient mHttpClient;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public String mReferer;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public String mUserAgent;

    /* JADX INFO: renamed from: com.huachenjie.common.cache_webview.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bL\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010n\u001a\u00020%¢\u0006\u0004\bo\u0010pJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u001a\u0010\u0016\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 J\u0006\u0010$\u001a\u00020#R\u001a\u0010)\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010&\u001a\u0004\b'\u0010(R\"\u0010/\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00103\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R$\u00108\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u00104\u001a\u0004\b0\u00105\"\u0004\b6\u00107R\"\u0010>\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010A\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u00109\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R\"\u0010E\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bB\u00109\u001a\u0004\bC\u0010;\"\u0004\bD\u0010=R$\u0010K\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010P\u001a\u0004\u0018\u00010\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010L\u001a\u0004\bM\u0010N\"\u0004\b9\u0010OR$\u0010V\u001a\u0004\u0018\u00010\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010\\\u001a\u0004\u0018\u00010\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010a\u001a\u00020\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010]\u001a\u0004\bB\u0010^\"\u0004\b_\u0010`R$\u0010g\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010m\u001a\u00020 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010l¨\u0006q"}, d2 = {"Lcom/huachenjie/common/cache_webview/a$a;", "", "Ljava/io/File;", "file", "r", "w", "", "dir", "p", "", "cacheSize", "s", "time", "t", "L", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "x", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "N", "Lokhttp3/Dns;", "dns", "v", "Lcom/zj/adlib/s91;", "config", "q", "Lcom/huachenjie/common/cache_webview/interceptor/ResourceInterceptor;", "resourceInterceptor", "M", "", AliyunLogCommon.LogLevel.DEBUG, "u", "Lcom/huachenjie/common/cache_webview/a;", "a", "Landroid/content/Context;", "Landroid/content/Context;", y6b.f, "()Landroid/content/Context;", "mContext", "Ljava/io/File;", "d", "()Ljava/io/File;", "A", "(Ljava/io/File;)V", "mCacheFile", "b", "j", "F", "mDynamicCacheFile", "Ljava/lang/String;", "()Ljava/lang/String;", "y", "(Ljava/lang/String;)V", "mAssetsDir", "J", "e", "()J", "B", "(J)V", "mCacheSize", "f", "C", "mConnectTimeout", "c", t.d, "H", "mReadTimeout", "Ljavax/net/ssl/HostnameVerifier;", "k", "()Ljavax/net/ssl/HostnameVerifier;", "G", "(Ljavax/net/ssl/HostnameVerifier;)V", "mHostnameVerifier", "Ljavax/net/ssl/SSLSocketFactory;", "n", "()Ljavax/net/ssl/SSLSocketFactory;", "(Ljavax/net/ssl/SSLSocketFactory;)V", "mSSLSocketFactory", "Ljavax/net/ssl/X509TrustManager;", j.b, "()Ljavax/net/ssl/X509TrustManager;", "K", "(Ljavax/net/ssl/X509TrustManager;)V", "mX509TrustManager", "Lokhttp3/Dns;", "i", "()Lokhttp3/Dns;", "E", "(Lokhttp3/Dns;)V", "mDns", "Lcom/zj/adlib/s91;", "()Lcom/zj/adlib/s91;", j.o, "(Lcom/zj/adlib/s91;)V", "mCacheExtensionConfig", "Lcom/huachenjie/common/cache_webview/interceptor/ResourceInterceptor;", "m", "()Lcom/huachenjie/common/cache_webview/interceptor/ResourceInterceptor;", "I", "(Lcom/huachenjie/common/cache_webview/interceptor/ResourceInterceptor;)V", "mResourceInterceptor", "Z", y6b.g, "()Z", "D", "(Z)V", "mDebug", "context", "<init>", "(Landroid/content/Context;)V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class C0794a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public long mCacheSize;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public final Context mContext;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @Nullable
        public ResourceInterceptor mResourceInterceptor;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public s91 mCacheExtensionConfig;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public File mCacheFile;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @Nullable
        public String mAssetsDir;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @Nullable
        public HostnameVerifier mHostnameVerifier;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @Nullable
        public SSLSocketFactory mSSLSocketFactory;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @Nullable
        public X509TrustManager mX509TrustManager;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @Nullable
        public Dns mDns;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        public boolean mDebug;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public long mConnectTimeout;

        /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
        @Nullable
        public File mDynamicCacheFile;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public long mReadTimeout;

        public C0794a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.mCacheSize = g.g;
            this.mConnectTimeout = 20L;
            this.mReadTimeout = 20L;
            this.mDebug = true;
            this.mContext = context;
            this.mCacheFile = new File(context.getCacheDir(), "CacheWebViewCache");
            this.mCacheExtensionConfig = new s91();
        }

        public final void A(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "<set-?>");
            this.mCacheFile = file;
        }

        public final void B(long j) {
            this.mCacheSize = j;
        }

        public final void C(long j) {
            this.mConnectTimeout = j;
        }

        public final void D(boolean z) {
            this.mDebug = z;
        }

        public final void E(@Nullable Dns dns) {
            this.mDns = dns;
        }

        public final void F(@Nullable File file) {
            this.mDynamicCacheFile = file;
        }

        public final void G(@Nullable HostnameVerifier hostnameVerifier) {
            this.mHostnameVerifier = hostnameVerifier;
        }

        public final void H(long j) {
            this.mReadTimeout = j;
        }

        public final void I(@Nullable ResourceInterceptor resourceInterceptor) {
            this.mResourceInterceptor = resourceInterceptor;
        }

        public final void J(@Nullable SSLSocketFactory sSLSocketFactory) {
            this.mSSLSocketFactory = sSLSocketFactory;
        }

        public final void K(@Nullable X509TrustManager x509TrustManager) {
            this.mX509TrustManager = x509TrustManager;
        }

        @NotNull
        public final C0794a L(long time) {
            if (time >= 0) {
                this.mReadTimeout = time;
            }
            return this;
        }

        @NotNull
        public final C0794a M(@Nullable ResourceInterceptor resourceInterceptor) {
            this.mResourceInterceptor = resourceInterceptor;
            return this;
        }

        @NotNull
        public final C0794a N(@Nullable SSLSocketFactory sslSocketFactory, @Nullable X509TrustManager trustManager) {
            if (sslSocketFactory != null && trustManager != null) {
                this.mSSLSocketFactory = sslSocketFactory;
                this.mX509TrustManager = trustManager;
            }
            return this;
        }

        @NotNull
        public final a a() {
            return new a(this);
        }

        @Nullable
        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getMAssetsDir() {
            return this.mAssetsDir;
        }

        @NotNull
        /* JADX INFO: renamed from: c, reason: from getter */
        public final s91 getMCacheExtensionConfig() {
            return this.mCacheExtensionConfig;
        }

        @NotNull
        /* JADX INFO: renamed from: d, reason: from getter */
        public final File getMCacheFile() {
            return this.mCacheFile;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final long getMCacheSize() {
            return this.mCacheSize;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final long getMConnectTimeout() {
            return this.mConnectTimeout;
        }

        @NotNull
        /* JADX INFO: renamed from: g, reason: from getter */
        public final Context getMContext() {
            return this.mContext;
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final boolean getMDebug() {
            return this.mDebug;
        }

        @Nullable
        /* JADX INFO: renamed from: i, reason: from getter */
        public final Dns getMDns() {
            return this.mDns;
        }

        @Nullable
        /* JADX INFO: renamed from: j, reason: from getter */
        public final File getMDynamicCacheFile() {
            return this.mDynamicCacheFile;
        }

        @Nullable
        /* JADX INFO: renamed from: k, reason: from getter */
        public final HostnameVerifier getMHostnameVerifier() {
            return this.mHostnameVerifier;
        }

        /* JADX INFO: renamed from: l, reason: from getter */
        public final long getMReadTimeout() {
            return this.mReadTimeout;
        }

        @Nullable
        /* JADX INFO: renamed from: m, reason: from getter */
        public final ResourceInterceptor getMResourceInterceptor() {
            return this.mResourceInterceptor;
        }

        @Nullable
        /* JADX INFO: renamed from: n, reason: from getter */
        public final SSLSocketFactory getMSSLSocketFactory() {
            return this.mSSLSocketFactory;
        }

        @Nullable
        /* JADX INFO: renamed from: o, reason: from getter */
        public final X509TrustManager getMX509TrustManager() {
            return this.mX509TrustManager;
        }

        @NotNull
        public final C0794a p(@Nullable String dir) {
            if (dir != null) {
                this.mAssetsDir = dir;
            }
            return this;
        }

        @NotNull
        public final C0794a q(@Nullable s91 config) {
            if (config != null) {
                this.mCacheExtensionConfig = config;
            }
            return this;
        }

        @NotNull
        public final C0794a r(@Nullable File file) {
            if (file != null) {
                this.mCacheFile = file;
            }
            return this;
        }

        @NotNull
        public final C0794a s(long cacheSize) {
            if (cacheSize > 1024) {
                this.mCacheSize = cacheSize;
            }
            return this;
        }

        @NotNull
        public final C0794a t(long time) {
            if (time >= 0) {
                this.mConnectTimeout = time;
            }
            return this;
        }

        @NotNull
        public final C0794a u(boolean debug) {
            this.mDebug = debug;
            return this;
        }

        @NotNull
        public final C0794a v(@Nullable Dns dns) {
            this.mDns = dns;
            return this;
        }

        @NotNull
        public final C0794a w(@Nullable File file) {
            if (file != null) {
                this.mDynamicCacheFile = file;
            }
            return this;
        }

        @NotNull
        public final C0794a x(@NotNull HostnameVerifier hostnameVerifier) {
            Intrinsics.checkNotNullParameter(hostnameVerifier, "hostnameVerifier");
            this.mHostnameVerifier = hostnameVerifier;
            return this;
        }

        public final void y(@Nullable String str) {
            this.mAssetsDir = str;
        }

        public final void z(@NotNull s91 s91Var) {
            Intrinsics.checkNotNullParameter(s91Var, "<set-?>");
            this.mCacheExtensionConfig = s91Var;
        }
    }

    public a(@NotNull C0794a c0794a) {
        Intrinsics.checkNotNullParameter(c0794a, "builder");
        this.builder = c0794a;
        this.mOrigin = "";
        this.mReferer = "";
        this.mUserAgent = "";
        g();
    }

    @Override // com.huachenjie.common.cache_webview.interceptor.WebViewCacheInterceptor
    public void a(@NotNull WebView webView, @NotNull String url, @NotNull Map<String, String> additionalHttpHeaders) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(additionalHttpHeaders, "additionalHttpHeaders");
        if (URLUtil.isValidUrl(url)) {
            webView.loadUrl(url, additionalHttpHeaders);
            String url2 = webView.getUrl();
            this.mReferer = url2;
            this.mOrigin = ux5.f45244a.a(url2);
            String userAgentString = webView.getSettings().getUserAgentString();
            Intrinsics.checkNotNullExpressionValue(userAgentString, "webView.settings.userAgentString");
            this.mUserAgent = userAgentString;
        }
    }

    @Override // com.huachenjie.common.cache_webview.interceptor.WebViewCacheInterceptor
    public void b(@NotNull WebView webView, @NotNull String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        if (URLUtil.isValidUrl(url)) {
            webView.loadUrl(url);
            String url2 = webView.getUrl();
            this.mReferer = url2;
            this.mOrigin = ux5.f45244a.a(url2);
            String userAgentString = webView.getSettings().getUserAgentString();
            Intrinsics.checkNotNullExpressionValue(userAgentString, "webView.settings.userAgentString");
            this.mUserAgent = userAgentString;
        }
    }

    @Override // com.huachenjie.common.cache_webview.interceptor.WebViewCacheInterceptor
    @Nullable
    public WebResourceResponse c(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(this.mOrigin)) {
            String str = this.mOrigin;
            Intrinsics.checkNotNull(str);
            map.put(b.F, str);
        }
        if (!TextUtils.isEmpty(this.mReferer)) {
            String str2 = this.mReferer;
            Intrinsics.checkNotNull(str2);
            map.put("Referer", str2);
        }
        if (!TextUtils.isEmpty(this.mUserAgent)) {
            map.put("User-Agent", this.mUserAgent);
        }
        return h(url, map);
    }

    @Override // com.huachenjie.common.cache_webview.interceptor.WebViewCacheInterceptor
    public void clearCache() {
        mg3 mg3Var = mg3.f43296a;
        String absolutePath = this.builder.getMCacheFile().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "builder.mCacheFile.absolutePath");
        mg3Var.a(absolutePath, true);
    }

    @Override // com.huachenjie.common.cache_webview.interceptor.WebViewCacheInterceptor
    @Nullable
    public WebResourceResponse d(@NotNull WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        String string = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "request.url.toString()");
        Map<String, String> requestHeaders = request.getRequestHeaders();
        Intrinsics.checkNotNullExpressionValue(requestHeaders, "request.requestHeaders");
        return h(string, requestHeaders);
    }

    public final void e(Request.Builder reqBuilder, Map<String, String> headers) {
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                reqBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    public final boolean f(String url) {
        if ((url == null || url.length() == 0) || !StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
            return false;
        }
        ResourceInterceptor mResourceInterceptor = this.builder.getMResourceInterceptor();
        if ((mResourceInterceptor == null || mResourceInterceptor.a(url)) ? false : true) {
            return false;
        }
        String strA = zo5.f46308a.a(url);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return this.builder.getMCacheExtensionConfig().c(strA);
    }

    public final void g() {
        OkHttpClient.Builder builderCache = new OkHttpClient.Builder().cache(new Cache(this.builder.getMCacheFile(), this.builder.getMCacheSize()));
        long mConnectTimeout = this.builder.getMConnectTimeout();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderAddNetworkInterceptor = builderCache.connectTimeout(mConnectTimeout, timeUnit).readTimeout(this.builder.getMReadTimeout(), timeUnit).addNetworkInterceptor(new g24());
        if (this.builder.getMHostnameVerifier() != null) {
            HostnameVerifier mHostnameVerifier = this.builder.getMHostnameVerifier();
            Intrinsics.checkNotNull(mHostnameVerifier);
            builderAddNetworkInterceptor.hostnameVerifier(mHostnameVerifier);
        }
        if (this.builder.getMSSLSocketFactory() != null && this.builder.getMX509TrustManager() != null) {
            SSLSocketFactory mSSLSocketFactory = this.builder.getMSSLSocketFactory();
            Intrinsics.checkNotNull(mSSLSocketFactory);
            X509TrustManager mX509TrustManager = this.builder.getMX509TrustManager();
            Intrinsics.checkNotNull(mX509TrustManager);
            builderAddNetworkInterceptor.sslSocketFactory(mSSLSocketFactory, mX509TrustManager);
        }
        if (this.builder.getMDns() != null) {
            Dns mDns = this.builder.getMDns();
            Intrinsics.checkNotNull(mDns);
            builderAddNetworkInterceptor.dns(mDns);
        }
        this.mHttpClient = builderAddNetworkInterceptor.build();
    }

    public final WebResourceResponse h(String url, Map<String, String> headers) {
        FileInputStream fileInputStream = null;
        if (StringsKt.startsWith(url, s91.f19553a, true)) {
            try {
                String strSubstring = url.substring(18);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                FileInputStream fileInputStream2 = new FileInputStream(new File(strSubstring));
                if (this.builder.getMDebug()) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("from local resource: %s", Arrays.copyOf(new Object[]{url}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    Log.d(d, str);
                    String strSubstring2 = url.substring(18);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                    String str2 = String.format("local path: %s", Arrays.copyOf(new Object[]{strSubstring2}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                    Log.d(d, str2);
                }
                String strB = zo5.f46308a.b(url);
                headers.put("Access-Control-Allow-Origin", "*");
                return new WebResourceResponse(strB, "", 200, "OK", headers, fileInputStream2);
            } catch (Exception e) {
                e.printStackTrace();
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str3 = String.format("Exception: %s", Arrays.copyOf(new Object[]{e.getMessage()}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
                Log.d(d, str3);
                return null;
            }
        }
        if (!f(url)) {
            return null;
        }
        if (this.builder.getMDynamicCacheFile() != null) {
            DynamicCacheLoader dynamicCacheLoaderA = DynamicCacheLoader.INSTANCE.a();
            File mDynamicCacheFile = this.builder.getMDynamicCacheFile();
            Intrinsics.checkNotNull(mDynamicCacheFile);
            File fileB = dynamicCacheLoaderA.b(mDynamicCacheFile, url);
            if (fileB != null) {
                if (this.builder.getMDebug()) {
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    String str4 = String.format("from dynamic file: %s", Arrays.copyOf(new Object[]{url}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
                    Log.d(d, str4);
                }
                try {
                    fileInputStream = new FileInputStream(fileB);
                } catch (FileNotFoundException unused) {
                }
                return new WebResourceResponse(zo5.f46308a.b(url), "", fileInputStream);
            }
        }
        if (this.builder.getMAssetsDir() != null) {
            AssetsLoader assetsLoaderA = AssetsLoader.INSTANCE.a();
            Context mContext = this.builder.getMContext();
            String mAssetsDir = this.builder.getMAssetsDir();
            Intrinsics.checkNotNull(mAssetsDir);
            InputStream inputStreamC = assetsLoaderA.c(mContext, mAssetsDir, url);
            if (inputStreamC != null) {
                if (this.builder.getMDebug()) {
                    StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                    String str5 = String.format("from assets: %s", Arrays.copyOf(new Object[]{url}, 1));
                    Intrinsics.checkNotNullExpressionValue(str5, "format(format, *args)");
                    Log.d(d, str5);
                }
                return new WebResourceResponse(zo5.f46308a.b(url), "", inputStreamC);
            }
        }
        try {
            Request.Builder builderUrl = new Request.Builder().url(url);
            e(builderUrl, headers);
            Request requestBuild = builderUrl.build();
            OkHttpClient okHttpClient = this.mHttpClient;
            if (okHttpClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHttpClient");
                okHttpClient = null;
            }
            Response responseExecute = okHttpClient.newCall(requestBuild).execute();
            if (responseExecute.code() == 504) {
                return null;
            }
            if (responseExecute.cacheResponse() != null) {
                if (this.builder.getMDebug()) {
                    StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                    String str6 = String.format("from cache: %s", Arrays.copyOf(new Object[]{url}, 1));
                    Intrinsics.checkNotNullExpressionValue(str6, "format(format, *args)");
                    Log.d(d, str6);
                }
            } else if (this.builder.getMDebug()) {
                StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                String str7 = String.format("from server: %s", Arrays.copyOf(new Object[]{url}, 1));
                Intrinsics.checkNotNullExpressionValue(str7, "format(format, *args)");
                Log.d(d, str7);
            }
            String strMessage = responseExecute.message();
            if (TextUtils.isEmpty(strMessage)) {
                strMessage = "OK";
            }
            String strB2 = zo5.f46308a.b(url);
            ResponseBody responseBodyBody = responseExecute.body();
            WebResourceResponse webResourceResponse = new WebResourceResponse(strB2, "", responseBodyBody != null ? responseBodyBody.byteStream() : null);
            webResourceResponse.setStatusCodeAndReasonPhrase(responseExecute.code(), strMessage);
            webResourceResponse.setResponseHeaders(ux5.f45244a.b(responseExecute.headers().toMultimap()));
            return webResourceResponse;
        } catch (Exception unused2) {
            return null;
        }
    }
}
