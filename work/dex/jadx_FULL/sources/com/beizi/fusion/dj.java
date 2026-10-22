package com.beizi.fusion;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.SslError;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.fusion.widget.BZVideoView;
import com.kc.aw.lib.constants.BiddingConst;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class dj extends k3 {
    private ViewGroup P;
    private View Q;
    private p1 R;
    private CountDownTimer S;
    private String T;
    private n7 U;
    private int V;
    private int W;
    private WebView X;
    private zl Y;
    private String Z;
    private BZVideoView a0;
    private boolean b0;
    private boolean c0;
    private boolean d0;
    private boolean e0;
    private boolean f0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            dj.this.S();
        }
    }

    public class b implements of.f {
        public b() {
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
            dj.this.a(8);
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                dj.this.W();
                dj.this.X();
                if (dj.this.c != null) {
                    on onVar = dj.this.c;
                    dj djVar = dj.this;
                    onVar.f(djVar.P, djVar.l);
                }
                if (dj.this.t) {
                    dj.this.u = true;
                    u3.b().a(dj.this.r);
                }
                p1 p1Var = dj.this.R;
                if (p1Var != null) {
                    p1Var.d();
                }
            } catch (Exception unused) {
                dj.this.a(11);
            }
        }
    }

    public class e extends WebViewClient {
        public e() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                dj djVar = dj.this;
                if (djVar.P == null) {
                    djVar.a(10);
                    return;
                }
                if (djVar.X == null) {
                    djVar.a(9);
                    return;
                }
                if (!djVar.E) {
                    dj djVar2 = dj.this;
                    djVar2.P.addView(djVar2.X);
                    dj.this.M();
                    dj.this.N();
                    dj.this.P();
                    return;
                }
                if (dj.this.F) {
                    dj.this.M();
                    dj.this.N();
                }
                zl zlVar = dj.this.Y;
                if (zlVar != null) {
                    zlVar.e();
                }
            } catch (Exception unused) {
                dj.this.a(2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            dj.this.a(2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            dj.this.a(2);
        }
    }

    public class f implements BZVideoView.i {
        public f() {
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void a(int i, int i2) {
            dj.this.a(i, i2);
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void b() {
            dj djVar = dj.this;
            if (djVar.b0) {
                return;
            }
            djVar.b0 = true;
            djVar.a(djVar.a0, 0);
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void a() {
            dj djVar = dj.this;
            if (djVar.f0) {
                return;
            }
            djVar.f0 = true;
            djVar.a(djVar.a0, 100);
        }
    }

    public class g extends CountDownTimer {
        public g(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (dj.this.c != null) {
                dj.this.c.a(false);
            }
            p1 p1Var = dj.this.R;
            if (p1Var != null) {
                p1Var.b();
            }
            CountDownTimer countDownTimer = dj.this.S;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            p1 p1Var = dj.this.R;
            if (p1Var != null) {
                p1Var.a(j);
            }
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27189a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        public i(Context context, String str, String str2, String str3, String str4) {
            this.f27189a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(this.f27189a, (Class<?>) DownloadAppInfoActivity.class);
                intent.putExtra("title_content_key", this.b);
                intent.putExtra("privacy_content_key", this.c);
                intent.putExtra("permission_content_key", this.d);
                intent.putExtra("intro_content_key", this.e);
                intent.setFlags(268435456);
                this.f27189a.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27190a;

        public j(int i) {
            this.f27190a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            dj.this.R.a(this.f27190a);
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            dj.this.P();
        }
    }

    public dj(Context context, ViewGroup viewGroup, View view, String str) {
        super(context, str, th.NEW_SPLASH);
        this.P = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        View viewA;
        FrameLayout frameLayoutB;
        try {
            ViewGroup viewGroup = this.P;
            if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
                Context context = viewGroup.getContext();
                LinearLayout linearLayout = new LinearLayout(this.P.getContext());
                linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                on.e eVarH = this.c.H();
                if (!TextUtils.isEmpty(eVarH.a()) && (frameLayoutB = bq.b(new MutableContextWrapper(context), eVarH)) != null) {
                    linearLayout.addView(frameLayoutB, new FrameLayout.LayoutParams(-2, -2, 17));
                    frameLayoutB.setVisibility(0);
                    frameLayoutB.setOnClickListener(new h());
                }
                on.e eVarH2 = this.c.h();
                if (!TextUtils.isEmpty(eVarH2.a()) && (viewA = bq.a(new MutableContextWrapper(this.P.getContext()), eVarH2)) != null) {
                    linearLayout.addView(viewA, new FrameLayout.LayoutParams(-2, -2, 17));
                    viewA.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewA.getLayoutParams();
                    layoutParams.setMargins(5, 0, 0, 0);
                    layoutParams.gravity = 17;
                    viewA.setLayoutParams(layoutParams);
                }
                ((FrameLayout) this.P).addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                int iA = bq.a(context, 12.0f);
                layoutParams2.setMargins(0, 0, iA, iA);
                linearLayout.setLayoutParams(layoutParams2);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        try {
            on onVar = this.c;
            if (onVar != null && this.P != null) {
                int iE = onVar.E();
                if (iE == 2 || iE == 5) {
                    String strJ = this.c.j();
                    String strK = this.c.k();
                    String strQ = this.c.q();
                    String strO = this.c.o();
                    String strN = !TextUtils.isEmpty(strO) ? strO : this.c.n();
                    String strP = this.c.p();
                    String strR = this.c.r();
                    Context context = this.P.getContext();
                    TextView textView = new TextView(context);
                    textView.setText(Html.fromHtml("应用名称：" + strJ + " | 开发者：" + strK + " | 应用版本：" + strQ + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
                    textView.setTextSize(2, 6.0f);
                    textView.setTextColor(Color.parseColor("#999999"));
                    textView.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
                    textView.setPadding(10, 10, 10, 10);
                    textView.setOnClickListener(new i(context, strJ, strP, strN, strR));
                    int i2 = (to.i(context) * 2) / 3;
                    ViewGroup viewGroup = this.P;
                    if (viewGroup instanceof FrameLayout) {
                        ((FrameLayout) viewGroup).addView(textView, new FrameLayout.LayoutParams(i2, -2, 83));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void O() {
        if (this.U == n7.RENDER_PIC && !TextUtils.isEmpty(this.T)) {
            of.a((Context) null).a(this.T, false, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (this.j) {
            return;
        }
        this.g = true;
        if (this.R != null) {
            Log.e("BeiZisAd", "enter BeiZi ad load");
            this.R.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        try {
            n7 n7Var = this.U;
            if (n7Var == n7.RENDER_PIC) {
                if (TextUtils.isEmpty(this.T)) {
                    a(3);
                    return;
                } else if (this.T.startsWith("http")) {
                    T();
                    return;
                } else {
                    a(7);
                    return;
                }
            }
            if (n7Var == n7.RENDER_H5) {
                if (TextUtils.isEmpty(this.T)) {
                    a(3);
                    return;
                }
                if (this.T.startsWith("http")) {
                    this.T = "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n  <title>Document</title>\n  <style>\n    html, body { width: 100%; height: 100%; margin: 0; padding: 0 }\n    .material-wrap { overflow: hidden; position: relative; height: 100%; background-repeat: no-repeat; background-position: center center; background-size: cover }\n    .filter-shadow { content: \"\"; position: absolute; z-index: 2; top: -3%; left: -3%; right: -3%; bottom: -3%; background: inherit; filter: blur(10px) }\n    .material-wrap .black-shadow { position: absolute; z-index: 3; top: 0; left: 0; right: 0; bottom: 0; background: rgba(0, 0, 0, .05) }\n    .material-wrap .material { position: absolute; z-index: 3; top: 0; left: 0; width: 100%; height: 100%; background-repeat: no-repeat; background-position: center center; background-size: contain }\n  </style>\n</head>\n<body>\n  <div class=\"material-wrap\" style=\"background-image: url('__IMAGE_SRC_PATH__')\">\n    <div class=\"filter-shadow\"></div>\n    <div class=\"black-shadow\"></div>\n    <div class=\"material\" style=\"background-image: url('__IMAGE_SRC_PATH__')\"></div>\n  </div>\n</body>\n</html>\n".replaceAll("__IMAGE_SRC_PATH__", this.T);
                }
                V();
                return;
            }
            if (n7Var != n7.RENDER_VIDEO) {
                a(3);
                return;
            }
            if (TextUtils.isEmpty(this.Z)) {
                a(3);
            } else if (this.Z.startsWith("http")) {
                U();
            } else {
                a(7);
            }
        } catch (Exception unused) {
            a(3);
        }
    }

    private void T() {
        ImageView imageView;
        if (this.E) {
            try {
                imageView = new ImageView(this.P.getContext());
                try {
                    this.P.addView(imageView);
                    if (this.H) {
                        imageView.setAlpha(0.0f);
                    }
                    if (!this.F) {
                        M();
                        N();
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                imageView = null;
            }
        } else {
            imageView = null;
        }
        of.a((Context) null).a(this.T, new d(imageView));
    }

    private void U() {
        try {
            if (this.P == null) {
                a(10);
                return;
            }
            int i2 = this.V;
            int i3 = this.W;
            if (i3 <= 0) {
                i3 = -1;
            }
            this.a0 = new BZVideoView(this.f27459a);
            this.a0.setLayoutParams(new FrameLayout.LayoutParams(i2, i3));
            this.P.setBackgroundColor(Color.parseColor("#000000"));
            this.P.addView(this.a0);
            on onVar = this.c;
            boolean zL0 = onVar != null ? onVar.l0() : false;
            this.a0.setPlayProgressCallback(new f());
            this.a0.initVideoResource(this.Z, null, zL0);
            M();
            N();
            if (!this.E) {
                P();
                return;
            }
            zl zlVar = this.Y;
            if (zlVar != null) {
                zlVar.e();
            }
        } catch (Exception unused) {
            a(8);
        }
    }

    private void V() {
        ViewGroup viewGroup = this.P;
        if (viewGroup == null) {
            a(10);
            return;
        }
        WebView webView = new WebView(viewGroup.getContext());
        this.X = webView;
        kq.c(webView);
        if (this.E) {
            this.P.addView(this.X);
            if (!this.F) {
                M();
                N();
            }
        }
        this.X.setWebViewClient(new e());
        this.X.loadDataWithBaseURL(null, this.T, "text/html", "UTF-8", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        View view = this.Q;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void Q() {
        try {
            this.c.c(true);
            this.c.b(B());
            this.c.a(this.P, "100", "200", BiddingConst.ADN_ID.HW, "206", String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.i, this.l);
            this.i = true;
            p1 p1Var = this.R;
            if (p1Var == null) {
                return;
            }
            p1Var.a();
        } catch (Exception unused) {
        }
    }

    public BZVideoView R() {
        return this.a0;
    }

    public void X() {
        CountDownTimer countDownTimer = this.S;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (this.n <= 0) {
            this.n = 5;
        }
        g gVar = new g(this.n * 1000, 200L);
        this.S = gVar;
        gVar.start();
    }

    public void b(int i2, int i3) {
        this.V = i2;
        this.W = i3;
    }

    @Override // com.beizi.fusion.k3
    public void c() {
        try {
            on onVar = this.c;
            if (onVar != null) {
                onVar.a(false);
            }
            p1 p1Var = this.R;
            if (p1Var != null) {
                p1Var.b();
            }
            CountDownTimer countDownTimer = this.S;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        } catch (Exception unused) {
        }
    }

    public void a(p1 p1Var) {
        this.R = p1Var;
    }

    public void a(View view) {
        ViewGroup viewGroup = this.P;
        if (viewGroup == null) {
            a(11);
        } else {
            this.Q = view;
            viewGroup.post(new c());
        }
    }

    public void b(View.OnTouchListener onTouchListener) {
        WebView webView = this.X;
        if (webView != null) {
            webView.setOnTouchListener(onTouchListener);
            return;
        }
        ViewGroup viewGroup = this.P;
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(onTouchListener);
        }
    }

    public void a(zl zlVar) {
        this.Y = zlVar;
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        double d2 = i3;
        double d3 = i2;
        if (d2 >= 0.25d * d3) {
            try {
                if (!this.c0) {
                    this.c0 = true;
                    a(this.a0, 25);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (d2 >= 0.5d * d3 && !this.d0) {
            this.d0 = true;
            a(this.a0, 50);
        }
        if (d2 < d3 * 0.75d || this.e0) {
            return;
        }
        this.e0 = true;
        a(this.a0, 75);
    }

    public void a(View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            return;
        }
        WebView webView = this.X;
        if (webView != null) {
            webView.setOnTouchListener(onTouchListener);
            return;
        }
        ViewGroup viewGroup = this.P;
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(onTouchListener);
        }
    }

    public void a(g5 g5Var, int i2) {
        try {
            on onVar = this.c;
            if (onVar != null && this.P != null) {
                onVar.c(true);
                this.c.b(B());
                this.c.a(this.P, g5Var, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.i, this.l, i2);
                this.i = true;
                p1 p1Var = this.R;
                if (p1Var == null) {
                    return;
                }
                p1Var.a();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.beizi.fusion.k3
    public void a(int i2) {
        if (this.R == null || this.j || this.g) {
            return;
        }
        this.j = true;
        Handler handler = this.J;
        if (handler != null) {
            handler.post(new j(i2));
        }
    }

    public class d implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f27182a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f27183a;
            final /* synthetic */ Bitmap b;
            final /* synthetic */ ImageView c;

            /* JADX INFO: renamed from: com.beizi.fusion.dj$d$a$a, reason: collision with other inner class name */
            public class RunnableC0305a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ BitmapDrawable f27184a;

                public RunnableC0305a(BitmapDrawable bitmapDrawable) {
                    this.f27184a = bitmapDrawable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ImageView imageView;
                    try {
                        BitmapDrawable bitmapDrawable = this.f27184a;
                        if (bitmapDrawable == null || (imageView = a.this.c) == null) {
                            return;
                        }
                        imageView.setBackground(bitmapDrawable);
                    } catch (Throwable unused) {
                    }
                }
            }

            public a(Context context, Bitmap bitmap, ImageView imageView) {
                this.f27183a = context;
                this.b = bitmap;
                this.c = imageView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                try {
                    Context context = this.f27183a;
                    if (context == null || (bitmap = this.b) == null) {
                        return;
                    }
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(qf.a(context, bitmap, 20.0f));
                    if (dj.this.J != null) {
                        dj.this.J.post(new RunnableC0305a(bitmapDrawable));
                    }
                } catch (Exception unused) {
                }
            }
        }

        public d(ImageView imageView) {
            this.f27182a = imageView;
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            ViewGroup.LayoutParams layoutParams;
            try {
                dj djVar = dj.this;
                if (djVar.P == null) {
                    djVar.a(10);
                    return;
                }
                if (bitmap == null) {
                    djVar.a(8);
                    return;
                }
                Log.e("BeiZisAd", "renderImageView onBitmapLoaded");
                Context context = dj.this.P.getContext();
                float width = (float) ((((double) bitmap.getWidth()) * 1.0d) / ((double) bitmap.getHeight()));
                dj djVar2 = dj.this;
                int i = djVar2.V;
                int i2 = djVar2.W;
                if (i2 <= 0) {
                    i2 = (int) (i / width);
                }
                ImageView imageView = djVar2.E ? this.f27182a : new ImageView(context);
                if (imageView != null && (layoutParams = imageView.getLayoutParams()) != null) {
                    layoutParams.width = i;
                    layoutParams.height = i2;
                    imageView.setLayoutParams(layoutParams);
                }
                float fAbs = Math.abs(((float) ((((double) i) * 1.0d) / ((double) i2))) - width);
                if (fAbs > 0.1f) {
                    w3.c().e().execute(new a(context, bitmap, imageView));
                } else if (fAbs > 0.07d) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                }
                imageView.setImageBitmap(bitmap);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i2);
                if (!dj.this.E) {
                    dj.this.P.addView(imageView, layoutParams2);
                    dj.this.M();
                    dj.this.N();
                    dj.this.P();
                    return;
                }
                imageView.setLayoutParams(layoutParams2);
                if (dj.this.H) {
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "alpha", 0.0f, 1.0f);
                    objectAnimatorOfFloat.setDuration(200L);
                    objectAnimatorOfFloat.start();
                }
                if (dj.this.F) {
                    dj.this.M();
                    dj.this.N();
                }
                zl zlVar = dj.this.Y;
                if (zlVar != null) {
                    zlVar.e();
                }
            } catch (Exception unused) {
                dj.this.a(8);
            }
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
            if (dj.this.E) {
                try {
                    ImageView imageView = this.f27182a;
                    if (imageView != null) {
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        this.f27182a.setImageResource(R.drawable.beizi_bg_place_holder);
                        if (dj.this.H) {
                            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f27182a, "alpha", 0.0f, 1.0f);
                            objectAnimatorOfFloat.setDuration(200L);
                            objectAnimatorOfFloat.start();
                        }
                    }
                    if (dj.this.F) {
                        dj.this.M();
                        dj.this.N();
                    }
                    zl zlVar = dj.this.Y;
                    if (zlVar != null) {
                        zlVar.e();
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            dj.this.a(8);
        }
    }

    @Override // com.beizi.fusion.k3
    public void a(on onVar) {
        this.n = onVar.K();
        this.T = onVar.I();
        this.Z = onVar.e0();
        this.U = onVar.J();
        e(onVar.U());
        a(onVar.c());
        b(onVar.i0());
        if (this.E) {
            this.J.post(new k());
            O();
        } else {
            Handler handler = this.J;
            if (handler != null) {
                handler.post(new a());
            }
        }
    }
}
