package com.fl.saas;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fl.saas.adx.util.DeviceUtil;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.fl.saas.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class C1406e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f30156a;
    private String b;
    private C1404d0 c;
    private final String d;
    private final String e;
    private final String f;

    /* JADX INFO: renamed from: com.fl.saas.e0$a */
    public class a implements T {
        public a() {
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            E0 e0A;
            int i;
            if (TextUtils.isEmpty(str) || C1406e0.this.c == null) {
                e0A = E0.a();
                i = 2;
            } else if (TextUtils.isEmpty(C1406e0.this.c.d()) || Pattern.compile(C1406e0.this.c.d()).matcher(str).matches()) {
                C1406e0.this.a(str);
                return;
            } else {
                e0A = E0.a();
                i = 0;
            }
            e0A.a(i);
        }

        @Override // com.fl.saas.T
        public void b(String str) {
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
            E0.a().a(2);
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.e0$b */
    public class b extends WebViewClient {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (C1406e0.this.f30156a != null) {
                C1406e0.this.f30156a.destroy();
                C1406e0.this.f30156a = null;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            C1406e0.this.f30156a.loadUrl("javascript:a('" + C1406e0.this.b + "')");
            E0.a().a(1);
            int iA = S0.a().a("kShowNumber", 0) + 1;
            S0.a().b("kShowDay", DeviceUtil.getDate());
            S0.a().b("kShowSec", System.currentTimeMillis() / 1000);
            S0.a().b("kShowNumber", iA);
            DeviceUtil.postUIDelayed(2000L, new Runnable() { // from class: com.fl.saas.k1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30183a.a();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.e0$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final C1406e0 f30159a = new C1406e0(null);
    }

    private C1406e0() {
        this.d = "kShowDay";
        this.e = "kShowNumber";
        this.f = "kShowSec";
    }

    public /* synthetic */ C1406e0(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        C1401c.c().a(this.c.e(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            Activity topActivity = DeviceUtil.getTopActivity();
            if (topActivity == null) {
                return;
            }
            this.b = str;
            WebView webView = new WebView(topActivity);
            this.f30156a = webView;
            webView.setWebChromeClient(new WebChromeClient());
            this.f30156a.setWebViewClient(new b());
            this.f30156a.getSettings().setJavaScriptEnabled(true);
            this.f30156a.loadDataWithBaseURL("about:blank", "<html>\n<body><script>async function a(b) {" + new String(AbstractC1421m.b(this.c.a()), StandardCharsets.UTF_8) + "}</script></body></html>", "text/html", "UTF-8", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static C1406e0 a() {
        return c.f30159a;
    }

    private void a(long j) {
        DeviceUtil.postUIDelayed(j, new Runnable() { // from class: com.zj.adlib.a0b
            @Override // java.lang.Runnable
            public final void run() {
                this.f40428a.b();
            }
        });
    }

    public void a(C1404d0 c1404d0) {
        this.c = c1404d0;
        if (c1404d0 == null || TextUtils.isEmpty(c1404d0.e())) {
            return;
        }
        int iF = this.c.f();
        String strA = S0.a().a("kShowDay", "");
        int iA = S0.a().a("kShowNumber", 0);
        long jA = S0.a().a("kShowSec", 0L);
        long j = iF;
        long j2 = j * 1000;
        if (!DeviceUtil.getDate().equals(strA)) {
            S0.a().b("kShowNumber", 0);
        } else {
            if (this.c.b() != 0 && iA >= this.c.b()) {
                return;
            }
            int iC = this.c.c() * 60;
            if (jA > 0 && iC > 0 && ((System.currentTimeMillis() / 1000) - jA) + j < iC) {
                return;
            }
        }
        a(j2);
    }
}
