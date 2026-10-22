package com.huachenjie.common.cache_webview;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.huachenjie.common.cache_webview.interceptor.WebViewCacheInterceptor;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0016J,\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/common/cache_webview/WebViewCacheManager;", "Lcom/huachenjie/common/cache_webview/interceptor/WebViewCacheInterceptor;", "Lcom/huachenjie/common/cache_webview/a$a;", "builder", "", "f", "Landroid/webkit/WebResourceRequest;", "request", "Landroid/webkit/WebResourceResponse;", "d", "", "url", "c", "Landroid/webkit/WebView;", "webView", "b", "", "additionalHttpHeaders", "a", "clearCache", "Lcom/huachenjie/common/cache_webview/a;", "Lcom/huachenjie/common/cache_webview/a;", "mDelegate", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class WebViewCacheManager implements WebViewCacheInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final Lazy<WebViewCacheManager> f8514a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<WebViewCacheManager>() { // from class: com.huachenjie.common.cache_webview.WebViewCacheManager$Companion$instance$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WebViewCacheManager m343invoke() {
            return new WebViewCacheManager(null);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public a mDelegate;

    /* JADX INFO: renamed from: com.huachenjie.common.cache_webview.WebViewCacheManager$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/cache_webview/WebViewCacheManager$a;", "", "Lcom/huachenjie/common/cache_webview/WebViewCacheManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/huachenjie/common/cache_webview/WebViewCacheManager;", "instance", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WebViewCacheManager a() {
            return (WebViewCacheManager) WebViewCacheManager.f8514a.getValue();
        }
    }

    public WebViewCacheManager() {
    }

    public /* synthetic */ WebViewCacheManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.huachenjie.common.cache_webview.interceptor.WebViewCacheInterceptor
    public void a(@NotNull WebView webView, @NotNull String url, @NotNull Map<String, String> additionalHttpHeaders) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(additionalHttpHeaders, "additionalHttpHeaders");
        a aVar = this.mDelegate;
        if (aVar != null) {
            aVar.a(webView, url, additionalHttpHeaders);
        }
    }

    @Override // com.huachenjie.common.cache_webview.interceptor.WebViewCacheInterceptor
    public void b(@NotNull WebView webView, @NotNull String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        a aVar = this.mDelegate;
        if (aVar != null) {
            aVar.b(webView, url);
        }
    }

    @Override // com.huachenjie.common.cache_webview.interceptor.WebViewCacheInterceptor
    @Nullable
    public WebResourceResponse c(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        a aVar = this.mDelegate;
        if (aVar != null) {
            return aVar.c(url);
        }
        return null;
    }

    @Override // com.huachenjie.common.cache_webview.interceptor.WebViewCacheInterceptor
    public void clearCache() {
        a aVar = this.mDelegate;
        if (aVar != null) {
            aVar.clearCache();
        }
    }

    @Override // com.huachenjie.common.cache_webview.interceptor.WebViewCacheInterceptor
    @Nullable
    public WebResourceResponse d(@NotNull WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        a aVar = this.mDelegate;
        if (aVar != null) {
            return aVar.d(request);
        }
        return null;
    }

    public final void f(@Nullable a.C0794a builder) {
        this.mDelegate = builder != null ? builder.a() : null;
    }
}
