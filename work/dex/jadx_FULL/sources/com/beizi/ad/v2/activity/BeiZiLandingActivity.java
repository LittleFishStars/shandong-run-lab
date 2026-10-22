package com.beizi.ad.v2.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
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
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity;
import com.beizi.ad.lance.ApkBean;
import com.beizi.fusion.R;
import com.beizi.fusion.a4;
import com.beizi.fusion.a8;
import com.beizi.fusion.bm;
import com.beizi.fusion.d9;
import com.beizi.fusion.f8;
import com.beizi.fusion.h3;
import com.beizi.fusion.hq;
import com.beizi.fusion.kq;
import com.beizi.fusion.m1;
import com.beizi.fusion.nh;
import com.beizi.fusion.of;
import com.beizi.fusion.ol;
import com.beizi.fusion.pg;
import com.beizi.fusion.po;
import com.beizi.fusion.wp;
import com.beizi.fusion.x1;
import com.beizi.fusion.zh;
import com.zj.adlib.u15;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BeiZiLandingActivity extends Activity {
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private boolean L;
    private int M;
    private boolean N;
    private int O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f26879a;
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
    private int y;
    private String z;
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
            BeiZiLandingActivity.this.a();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiLandingActivity.this.j();
        }
    }

    public class d implements of.f {
        public d() {
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                ImageView imageView = BeiZiLandingActivity.this.o;
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
                BeiZiLandingActivity beiZiLandingActivity = BeiZiLandingActivity.this;
                if (beiZiLandingActivity.q == 1 && beiZiLandingActivity.r == 1) {
                    beiZiLandingActivity.j();
                }
            }
        }
    }

    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            BeiZiLandingActivity.this.h = true;
            return false;
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
            ProgressBar progressBar = BeiZiLandingActivity.this.b;
            if (progressBar == null) {
                return;
            }
            if (i < 100 && progressBar.getVisibility() == 8) {
                BeiZiLandingActivity.this.b.setVisibility(0);
            }
            BeiZiLandingActivity.this.b.setProgress(i);
            if (i == 100) {
                BeiZiLandingActivity.this.b.setVisibility(8);
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
                    BeiZiLandingActivity.this.setContentView(videoView);
                    videoView.start();
                }
            }
        }
    }

    public class h implements m1 {
        public h() {
        }

        @Override // com.beizi.fusion.m1
        public void a() {
            x1.b.C0333b c0333b = BeiZiLandingActivity.this.i;
            if (c0333b != null) {
                List listF = c0333b.f();
                BeiZiLandingActivity.this.i.h(null);
                bm.a(listF);
                List listD = BeiZiLandingActivity.this.i.d();
                BeiZiLandingActivity.this.i.f(null);
                bm.a(listD);
            }
        }

        @Override // com.beizi.fusion.m1
        public void b() {
            x1.b.C0333b c0333b = BeiZiLandingActivity.this.i;
            if (c0333b != null) {
                List listC = c0333b.c();
                BeiZiLandingActivity.this.i.e(null);
                bm.a(listC);
            }
            BeiZiLandingActivity.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            WebView webView = this.f26879a;
            if (webView != null) {
                webView.destroy();
            }
            finish();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.l == null || TextUtils.isEmpty(this.e) || this.W) {
            return;
        }
        this.W = true;
        String strI = this.l.i();
        if (TextUtils.isEmpty(strI)) {
            return;
        }
        boolean zA = ol.a(this.l.e());
        this.p = zA;
        if (zA) {
            int iH = this.l.h();
            View view = this.m;
            if (view != null && iH == 1) {
                view.setVisibility(0);
                this.m.setOnClickListener(new b());
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
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout2 = this.n;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            this.n.setOnClickListener(new c());
            of.a(this).a(strI, new d());
        }
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

    private void e() {
        try {
            Bundle bundleExtra = getIntent().getBundleExtra("data");
            if (bundleExtra != null) {
                if (bundleExtra.containsKey("requestUUID")) {
                    this.T = bundleExtra.getString("requestUUID");
                }
                if (bundleExtra.containsKey("isRedirectionCanJump")) {
                    this.c = bundleExtra.getBoolean("isRedirectionCanJump", false);
                }
                if (bundleExtra.containsKey("isDownload")) {
                    this.d = bundleExtra.getBoolean("isDownload", false);
                }
                if (bundleExtra.containsKey("deeplinkUrl")) {
                    this.e = bundleExtra.getString("deeplinkUrl");
                }
                if (bundleExtra.containsKey("landingPageUrl")) {
                    this.f = bundleExtra.getString("landingPageUrl");
                }
                if (bundleExtra.containsKey("lpOptimizeModule")) {
                    this.l = (nh) bundleExtra.getSerializable("lpOptimizeModule");
                }
                if (bundleExtra.containsKey("apkName")) {
                    this.z = bundleExtra.getString("apkName");
                }
                if (bundleExtra.containsKey("appDeveloper")) {
                    this.F = bundleExtra.getString("appDeveloper");
                }
                if (bundleExtra.containsKey("appVersion")) {
                    this.E = bundleExtra.getString("appVersion");
                }
                if (bundleExtra.containsKey("appPrivacyUrl")) {
                    this.I = bundleExtra.getString("appPrivacyUrl");
                }
                if (bundleExtra.containsKey("appintro")) {
                    this.K = bundleExtra.getString("appintro");
                }
                if (bundleExtra.containsKey("appPermissionsUrl")) {
                    this.H = bundleExtra.getString("appPermissionsUrl");
                }
                if (bundleExtra.containsKey("appPermissionsDesc")) {
                    this.G = bundleExtra.getString("appPermissionsDesc");
                }
                if (bundleExtra.containsKey("interactType")) {
                    this.y = bundleExtra.getInt("interactType");
                }
                if (bundleExtra.containsKey("appDownloadURL")) {
                    this.D = bundleExtra.getString("appDownloadURL");
                }
                if (bundleExtra.containsKey(ALPParamConstant.PACKAGENAME)) {
                    this.A = bundleExtra.getString(ALPParamConstant.PACKAGENAME);
                }
                if (bundleExtra.containsKey("appDesc")) {
                    this.C = bundleExtra.getString("appDesc");
                }
                if (bundleExtra.containsKey("appIconURL")) {
                    this.J = bundleExtra.getString("appIconURL");
                }
                if (bundleExtra.containsKey("isCloseConfirmDialog")) {
                    this.L = bundleExtra.getBoolean("isCloseConfirmDialog");
                }
                if (bundleExtra.containsKey("isMiniProgram")) {
                    int i = bundleExtra.getInt("isMiniProgram");
                    this.O = i;
                    if (i == 1) {
                        if (bundleExtra.containsKey("miniProgramId")) {
                            this.P = bundleExtra.getString("miniProgramId");
                        }
                        if (bundleExtra.containsKey("miniProgramPath")) {
                            this.Q = bundleExtra.getString("miniProgramPath");
                        }
                        if (bundleExtra.containsKey("miniProgramExt")) {
                            this.R = bundleExtra.getString("miniProgramExt");
                        }
                        if (bundleExtra.containsKey("wechat_canvas")) {
                            this.S = bundleExtra.getString("wechat_canvas");
                        }
                    }
                }
                if (!TextUtils.isEmpty(this.T)) {
                    this.i = f8.a().b(this.T);
                }
                if (this.i == null && bundleExtra.containsKey("followTrackExt")) {
                    this.i = (x1.b.C0333b) bundleExtra.getSerializable("followTrackExt");
                }
                if (bundleExtra.containsKey(LoginConstants.TOKEN_INFO)) {
                    this.U = bundleExtra.getString(LoginConstants.TOKEN_INFO);
                }
                if (bundleExtra.containsKey("oppoReqId")) {
                    this.V = bundleExtra.getString("oppoReqId");
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f() {
        try {
            this.f26879a = (WebView) findViewById(R.id.lp_web_view);
            ((ImageView) findViewById(R.id.lp_close_iv)).setOnClickListener(new a());
            this.b = (ProgressBar) findViewById(R.id.lp_progress_bar);
            this.m = findViewById(R.id.lp_mask_view);
            this.n = (RelativeLayout) findViewById(R.id.lp_dialog_container_rl);
            this.o = (ImageView) findViewById(R.id.lp_dialog_iv);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void g() {
        if (this.f26879a == null || TextUtils.isEmpty(this.f)) {
            return;
        }
        WebView webView = this.f26879a;
        if (webView != null) {
            webView.setOnTouchListener(new e());
        }
        kq.c(this.f26879a);
        this.f26879a.loadUrl(this.f, d9.a());
        this.f26879a.setWebViewClient(new f());
        this.f26879a.setWebChromeClient(new g(this));
    }

    private boolean h() {
        int i = this.y;
        if (i == 2) {
            return !TextUtils.isEmpty(this.D) && this.D.startsWith("http");
        }
        return i == 5 && !TextUtils.isEmpty(this.D);
    }

    private boolean i() {
        if (TextUtils.isEmpty(this.z) || TextUtils.isEmpty(this.F) || TextUtils.isEmpty(this.E) || TextUtils.isEmpty(this.I) || TextUtils.isEmpty(this.K)) {
            return false;
        }
        if (TextUtils.isEmpty(this.H) && TextUtils.isEmpty(this.G)) {
            return false;
        }
        int i = this.y;
        return i == 2 || i == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            if (!this.N && !this.p) {
                int i = this.w + 1;
                this.w = i;
                int i2 = this.q;
                if (i2 <= 1 && this.s <= 0) {
                    k();
                    return;
                }
                if (this.s == 1) {
                    if (i2 == 1) {
                        if (i >= this.t + 1) {
                            k();
                            return;
                        }
                        return;
                    } else {
                        if (i >= this.t) {
                            k();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (TextUtils.isEmpty(this.e)) {
                if (this.N) {
                    b();
                }
                int i3 = this.w + 1;
                this.w = i3;
                int i4 = this.q;
                if (i4 <= 1 && this.s <= 0) {
                    k();
                    return;
                }
                if (this.s == 1) {
                    if (i4 == 1) {
                        if (i3 >= this.t + 1) {
                            k();
                            return;
                        }
                        return;
                    } else {
                        if (i3 >= this.t) {
                            k();
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
                if (this.N) {
                    b();
                }
                this.w++;
                if (this.q > 1 || this.s > 0) {
                }
            } finally {
                int i7 = this.w + 1;
                this.w = i7;
                int i8 = this.q;
                if (i8 <= 1 && this.s <= 0) {
                    k();
                } else if (this.s == 1) {
                    if (i8 == 1) {
                        if (i7 >= this.t + 1) {
                            k();
                        }
                    } else if (i7 >= this.t) {
                        k();
                    }
                }
            }
        }
    }

    private void k() {
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

    private void l() {
        x1.b.C0333b c0333b;
        x1.b.C0333b c0333b2;
        try {
            if (this.O == 0) {
                return;
            }
            if (!TextUtils.isEmpty(this.P) && !TextUtils.isEmpty(this.Q)) {
                if (!hq.a(this, this.P, this.Q, this.R) || (c0333b2 = this.i) == null) {
                    return;
                }
                List listH = c0333b2.h();
                this.i.k(null);
                bm.a(listH);
                return;
            }
            if (TextUtils.isEmpty(this.S) || !hq.a(this, this.S) || (c0333b = this.i) == null) {
                return;
            }
            List listH2 = c0333b.h();
            this.i.k(null);
            bm.a(listH2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            RelativeLayout relativeLayout = this.n;
            if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                WebView webView = this.f26879a;
                if (webView == null || !webView.canGoBack()) {
                    a();
                } else {
                    this.f26879a.goBack();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setContentView(R.layout.activtiy_beizi_landingpage);
            e();
            f();
            this.N = true;
            if (!d()) {
                j();
                this.N = false;
            }
            g();
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (TextUtils.isEmpty(this.T)) {
                return;
            }
            f8.a().b(this.i, this.T);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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
                j();
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
                k();
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
    public void b() {
        try {
            if (i() && h()) {
                int i = this.y;
                if (i == 2) {
                    if (a8.a(this, this.A)) {
                        a8.b(this, this.A);
                        x1.b.C0333b c0333b = this.i;
                        if (c0333b != null) {
                            List listI = c0333b.i();
                            this.i.l(null);
                            bm.a(listI);
                            return;
                        }
                        return;
                    }
                    a(this, 1);
                    return;
                }
                if (i == 5) {
                    if (!TextUtils.isEmpty(this.B) && a8.a(this, this.B)) {
                        a8.b(this, this.B);
                        return;
                    }
                    if (pg.a(this, this.D)) {
                        if (!this.L && this.M != 0) {
                            a(this, 2);
                            return;
                        }
                        a(this.D, this);
                        x1.b.C0333b c0333b2 = this.i;
                        if (c0333b2 != null) {
                            List listI2 = c0333b2.i();
                            this.i.l(null);
                            bm.a(listI2);
                            return;
                        }
                        return;
                    }
                    l();
                    return;
                }
                return;
            }
            l();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    private void a(Context context, int i) {
        try {
            File fileF = a8.f(context);
            String absolutePath = fileF != null ? fileF.getAbsolutePath() : "";
            ApkBean apkBean = new ApkBean(this.D, this.A + ".apk", this.A, absolutePath, this.z, this.C, context.getPackageName() + ".bz.fileprovider", this.i, this.E, this.F, this.G, this.H, this.I, this.J, this.K);
            apkBean.setSendLocalBroadcast(true);
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", apkBean);
            bundle.putInt("type", i);
            bundle.putBoolean("isCanJump", this.c);
            bundle.putBoolean("isDownload", i());
            if (i == 2) {
                x1.b.C0333b c0333b = this.i;
                if (c0333b != null) {
                    bundle.putStringArrayList("openList", (ArrayList) c0333b.i());
                }
                bundle.putString("landingPageUrl", this.f);
            }
            if (!TextUtils.isEmpty(this.e)) {
                bundle.putString("deeplinkUrl", this.e);
            }
            Serializable serializable = this.l;
            if (serializable != null) {
                bundle.putSerializable("lpOptimizeModule", serializable);
            }
            bundle.putBoolean("isForbidOpenLandingPage", true);
            Intent intent = new Intent(context, (Class<?>) BeiZiDownloadDialogActivity.class);
            intent.putExtra("data", bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public class f extends WebViewClient {
        public f() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            BeiZiLandingActivity.this.c();
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
                    if (BeiZiLandingActivity.this.a(string) && !BeiZiLandingActivity.this.b(string)) {
                        BeiZiLandingActivity.this.d(string);
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
            if (!BeiZiLandingActivity.this.a(str) || BeiZiLandingActivity.this.b(str)) {
                return true;
            }
            BeiZiLandingActivity.this.d(str);
            return true;
        }
    }

    private boolean d() {
        try {
            if (TextUtils.isEmpty(this.U) || TextUtils.isEmpty(this.V) || !a4.j().p()) {
                return false;
            }
            String strA = h3.a(this.U);
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            new zh().a(this.e, strA, this.V, new h());
            int i = this.w + 1;
            this.w = i;
            int i2 = this.q;
            if (i2 <= 1 && this.s <= 0) {
                k();
            } else if (this.s == 1) {
                if (i2 == 1) {
                    if (i >= this.t + 1) {
                        k();
                    }
                } else if (i >= this.t) {
                    k();
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
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
}
