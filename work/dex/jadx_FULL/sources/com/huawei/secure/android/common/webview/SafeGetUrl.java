package com.huawei.secure.android.common.webview;

import android.util.Log;
import android.webkit.WebView;
import com.huawei.secure.android.common.util.b;
import com.huawei.secure.android.common.util.c;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SafeGetUrl {
    private static final String c = "SafeGetUrl";
    private static final long d = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37772a;
    private WebView b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f37773a;

        public a(CountDownLatch countDownLatch) {
            this.f37773a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            SafeGetUrl safeGetUrl = SafeGetUrl.this;
            safeGetUrl.setUrl(safeGetUrl.b.getUrl());
            this.f37773a.countDown();
        }
    }

    public SafeGetUrl() {
    }

    public String getUrlMethod() {
        if (this.b == null) {
            return "";
        }
        if (b.a()) {
            return this.b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.a(new a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Log.e(c, "getUrlMethod: InterruptedException " + e.getMessage(), e);
        }
        return this.f37772a;
    }

    public WebView getWebView() {
        return this.b;
    }

    public void setUrl(String str) {
        this.f37772a = str;
    }

    public void setWebView(WebView webView) {
        this.b = webView;
    }

    public SafeGetUrl(WebView webView) {
        this.b = webView;
    }
}
