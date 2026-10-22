package com.beizi.ad.v2.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.beizi.fusion.R;
import com.beizi.fusion.a4;
import com.beizi.fusion.bm;
import com.beizi.fusion.d9;
import com.beizi.fusion.kq;
import com.beizi.fusion.nh;
import com.beizi.fusion.of;
import com.beizi.fusion.ol;
import com.beizi.fusion.po;
import com.beizi.fusion.wp;
import com.beizi.fusion.x1;
import com.zj.adlib.u15;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BeiZiLandingPageActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f26887a;
    private ProgressBar b;
    private boolean c;
    private boolean d;
    private String e;
    private String f;
    private boolean g;
    private boolean h;
    private x1.b.C0333b i;
    private boolean j;
    private nh l;
    private View m;
    private RelativeLayout n;
    private ImageView o;
    private boolean p;
    private long x;
    private boolean y;
    private boolean k = true;
    private int q = -1;
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = 0;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiLandingPageActivity.this.a();
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            BeiZiLandingPageActivity.this.h = true;
            return false;
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiLandingPageActivity.this.f();
        }
    }

    public class e implements of.f {
        public e() {
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                ImageView imageView = BeiZiLandingPageActivity.this.o;
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
                BeiZiLandingPageActivity beiZiLandingPageActivity = BeiZiLandingPageActivity.this;
                if (beiZiLandingPageActivity.q == 1 && beiZiLandingPageActivity.r == 1) {
                    beiZiLandingPageActivity.f();
                }
            }
        }
    }

    public class g extends wp {
        public g(Activity activity) {
            super(activity);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (callback != null) {
                try {
                    callback.invoke(str, false, false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            ProgressBar progressBar = BeiZiLandingPageActivity.this.b;
            if (progressBar == null) {
                return;
            }
            if (i < 100 && progressBar.getVisibility() == 8) {
                BeiZiLandingPageActivity.this.b.setVisibility(0);
            }
            BeiZiLandingPageActivity.this.b.setProgress(i);
            if (i == 100) {
                BeiZiLandingPageActivity.this.b.setVisibility(8);
            }
        }

        @Override // com.beizi.fusion.wp, android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
            if (view instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) view;
                if (frameLayout.getFocusedChild() instanceof VideoView) {
                    VideoView videoView = (VideoView) frameLayout.getFocusedChild();
                    frameLayout.removeView(videoView);
                    BeiZiLandingPageActivity.this.setContentView(videoView);
                    videoView.start();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            WebView webView = this.f26887a;
            if (webView != null) {
                webView.destroy();
            }
            finish();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.l == null || TextUtils.isEmpty(this.e) || this.y) {
            return;
        }
        this.y = true;
        String strI = this.l.i();
        if (TextUtils.isEmpty(strI)) {
            return;
        }
        boolean zA = ol.a(this.l.e());
        this.p = zA;
        if (zA) {
            WebView webView = this.f26887a;
            if (webView != null) {
                webView.setOnTouchListener(new b());
            }
            int iH = this.l.h();
            View view = this.m;
            if (view != null && iH == 1) {
                view.setVisibility(0);
                this.m.setOnClickListener(new c());
            }
            this.q = this.l.c();
            this.r = this.l.d();
            this.s = this.l.f();
            this.t = this.l.g();
            this.u = this.l.a();
            this.v = this.l.b();
            if (TextUtils.isEmpty(strI)) {
                RelativeLayout relativeLayout = this.n;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            } else {
                RelativeLayout relativeLayout2 = this.n;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(0);
                }
                this.n.setOnClickListener(new d());
                of.a(this).a(strI, new e());
            }
            if (this.q == 1) {
                int i = this.r;
                if (i == 0 || i == 2) {
                    f();
                }
            }
        }
    }

    private void c() {
        try {
            Bundle bundleExtra = getIntent().getBundleExtra("data");
            if (bundleExtra == null) {
                return;
            }
            if (bundleExtra.containsKey("isRedirectionCanJump")) {
                this.c = bundleExtra.getBoolean("isRedirectionCanJump", false);
            }
            if (bundleExtra.containsKey("isDownload")) {
                this.d = bundleExtra.getBoolean("isDownload", false);
            }
            if (bundleExtra.containsKey("landingPageUrl")) {
                this.f = bundleExtra.getString("landingPageUrl");
            }
            if (bundleExtra.containsKey("deeplinkUrl")) {
                this.e = bundleExtra.getString("deeplinkUrl");
            }
            if (bundleExtra.containsKey("followTrackExt")) {
                this.i = (x1.b.C0333b) bundleExtra.getSerializable("followTrackExt");
            }
            if (bundleExtra.containsKey("lpOptimizeModule")) {
                this.l = (nh) bundleExtra.getSerializable("lpOptimizeModule");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d() {
        try {
            this.f26887a = (WebView) findViewById(R.id.lp_web_view);
            ((ImageView) findViewById(R.id.lp_close_iv)).setOnClickListener(new a());
            this.b = (ProgressBar) findViewById(R.id.lp_progress_bar);
            this.m = findViewById(R.id.lp_mask_view);
            this.n = (RelativeLayout) findViewById(R.id.lp_dialog_container_rl);
            this.o = (ImageView) findViewById(R.id.lp_dialog_iv);
            e();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void e() {
        if (this.f26887a == null || TextUtils.isEmpty(this.f)) {
            return;
        }
        kq.c(this.f26887a);
        this.f26887a.loadUrl(this.f, d9.a());
        this.f26887a.setWebViewClient(new f());
        this.f26887a.setWebChromeClient(new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (!this.p) {
                int i = this.w + 1;
                this.w = i;
                int i2 = this.q;
                if (i2 <= 1 && this.s <= 0) {
                    g();
                    return;
                }
                if (this.s == 1) {
                    if (i2 == 1) {
                        if (i >= this.t + 1) {
                            g();
                            return;
                        }
                        return;
                    } else {
                        if (i >= this.t) {
                            g();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (TextUtils.isEmpty(this.e)) {
                int i3 = this.w + 1;
                this.w = i3;
                int i4 = this.q;
                if (i4 <= 1 && this.s <= 0) {
                    g();
                    return;
                }
                if (this.s == 1) {
                    if (i4 == 1) {
                        if (i3 >= this.t + 1) {
                            g();
                            return;
                        }
                        return;
                    } else {
                        if (i3 >= this.t) {
                            g();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            this.j = true;
            this.g = true;
            Uri uri = Uri.parse(this.e);
            if (uri.getScheme() != null && uri.getScheme().equals("bzopen") && !TextUtils.isEmpty(uri.getHost()) && uri.getPathSegments().size() > 0) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.MAIN");
                intent.setFlags(268435456);
                intent.addCategory("android.intent.category.LAUNCHER");
                String queryParameter = uri.getQueryParameter("flags");
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        if (queryParameter.startsWith("0x") || queryParameter.startsWith("0X")) {
                            intent.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
                        } else {
                            intent.setFlags(Integer.parseInt(queryParameter));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                intent.setComponent(new ComponentName(uri.getHost(), uri.getPathSegments().get(0)));
                String queryParameter2 = uri.getQueryParameter("rect");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    try {
                        String[] strArrSplit = queryParameter2.split(u15.f19942b);
                        if (strArrSplit.length == 4) {
                            Rect rect = new Rect();
                            rect.set(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), Integer.parseInt(strArrSplit[3]));
                            intent.setSourceBounds(rect);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                startActivity(intent);
            } else if (this.e.startsWith("hwpps://landingpage")) {
                Intent intent2 = new Intent();
                intent2.setData(uri);
                intent2.addFlags(268435456);
                startActivity(intent2);
            } else if (this.e.startsWith("intent")) {
                Intent uri2 = Intent.parseUri(this.e, 1);
                uri2.addFlags(268435456);
                startActivity(uri2);
            } else {
                Intent intent3 = new Intent("android.intent.action.VIEW", uri);
                intent3.addFlags(805339136);
                startActivity(intent3);
            }
            x1.b.C0333b c0333b = this.i;
            if (c0333b != null) {
                List listF = c0333b.f();
                this.i.h(null);
                bm.a(listF);
                List listD = this.i.d();
                this.i.f(null);
                bm.a(listD);
            }
            int i5 = this.w + 1;
            this.w = i5;
            int i6 = this.q;
            if (i6 > 1 || this.s > 0) {
                if (this.s == 1) {
                    if (i6 == 1) {
                        if (i5 < this.t + 1) {
                        }
                    } else {
                        if (i5 < this.t) {
                        }
                    }
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                x1.b.C0333b c0333b2 = this.i;
                if (c0333b2 != null) {
                    List listC = c0333b2.c();
                    this.i.e(null);
                    bm.a(listC);
                }
                this.w++;
                if (this.q > 1 || this.s > 0) {
                }
            } finally {
                int i7 = this.w + 1;
                this.w = i7;
                int i8 = this.q;
                if (i8 <= 1 && this.s <= 0) {
                    g();
                } else if (this.s == 1) {
                    if (i8 == 1) {
                        if (i7 >= this.t + 1) {
                            g();
                        }
                    } else if (i7 >= this.t) {
                        g();
                    }
                }
            }
        }
    }

    private void g() {
        try {
            RelativeLayout relativeLayout = this.n;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                this.n.setOnClickListener(null);
            }
            View view = this.m;
            if (view != null) {
                view.setVisibility(8);
                this.m.setOnClickListener(null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            RelativeLayout relativeLayout = this.n;
            if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                WebView webView = this.f26887a;
                if (webView == null || !webView.canGoBack()) {
                    a();
                } else {
                    this.f26887a.goBack();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activtiy_beizi_landingpage);
        c();
        d();
    }

    @Override // android.app.Activity
    public void onResume() {
        List listK;
        super.onResume();
        try {
            if (!this.k) {
                this.j = false;
                x1.b.C0333b c0333b = this.i;
                if (c0333b != null && (listK = c0333b.k()) != null && listK.size() > 0) {
                    List listJ = this.i.j();
                    this.i.p(null);
                    bm.a(listJ);
                }
            }
            if (this.u == 1 && System.currentTimeMillis() - this.x < this.v) {
                f();
            }
            this.x = 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.k = false;
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        try {
            this.x = System.currentTimeMillis();
            if (this.j) {
                x1.b.C0333b c0333b = this.i;
                if (c0333b != null) {
                    List listK = c0333b.k();
                    this.i.q(null);
                    bm.a(listK);
                }
                g();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return !c(str) || this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (this.p) {
            if (this.g && !this.h) {
                return;
            } else {
                this.g = true;
            }
        }
        Uri uri = po.b(str) ? null : Uri.parse(str);
        if (uri == null) {
            return;
        }
        this.j = true;
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(268435456);
        try {
            startActivity(intent);
            x1.b.C0333b c0333b = this.i;
            if (c0333b != null) {
                List listF = c0333b.f();
                this.i.h(null);
                bm.a(listF);
                List listD = this.i.d();
                this.i.f(null);
                bm.a(listD);
            }
        } catch (Exception unused) {
        }
    }

    public class f extends WebViewClient {
        public f() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            BeiZiLandingPageActivity.this.b();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                Uri url = webResourceRequest.getUrl();
                if (url == null) {
                    return false;
                }
                String string = url.toString();
                if (!string.startsWith("http")) {
                    if (BeiZiLandingPageActivity.this.a(string) && !BeiZiLandingPageActivity.this.b(string)) {
                        BeiZiLandingPageActivity.this.d(string);
                    }
                    return true;
                }
                Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
                if (requestHeaders == null || requestHeaders.size() == 0) {
                    requestHeaders = new HashMap<>();
                }
                requestHeaders.put(com.google.common.net.b.c1, "");
                webView.loadUrl(string, requestHeaders);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("http")) {
                return false;
            }
            if (!BeiZiLandingPageActivity.this.a(str) || BeiZiLandingPageActivity.this.b(str)) {
                return true;
            }
            BeiZiLandingPageActivity.this.d(str);
            return true;
        }
    }

    private boolean c(String str) {
        List listI = a4.j().i();
        if (listI == null || listI.size() <= 0) {
            return false;
        }
        Iterator it = listI.iterator();
        while (it.hasNext()) {
            if (str.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        try {
            List listE = a4.j().e();
            if (listE != null && listE.size() > 0) {
                Iterator it = listE.iterator();
                while (it.hasNext()) {
                    if (str.contains((String) it.next())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
