package com.beizi.ad.v2.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import android.widget.TextView;
import android.widget.VideoView;
import androidx.camera.video.AudioStats;
import com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.view.CustomRoundImageView;
import com.beizi.ad.lance.ApkBean;
import com.beizi.fusion.R;
import com.beizi.fusion.a4;
import com.beizi.fusion.a8;
import com.beizi.fusion.bm;
import com.beizi.fusion.bq;
import com.beizi.fusion.c4;
import com.beizi.fusion.d9;
import com.beizi.fusion.g5;
import com.beizi.fusion.gp;
import com.beizi.fusion.hq;
import com.beizi.fusion.kh;
import com.beizi.fusion.kj;
import com.beizi.fusion.kl;
import com.beizi.fusion.kq;
import com.beizi.fusion.lj;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.ng;
import com.beizi.fusion.nh;
import com.beizi.fusion.of;
import com.beizi.fusion.ol;
import com.beizi.fusion.pg;
import com.beizi.fusion.po;
import com.beizi.fusion.q1;
import com.beizi.fusion.rn;
import com.beizi.fusion.sn;
import com.beizi.fusion.so;
import com.beizi.fusion.to;
import com.beizi.fusion.widget.BZCarouselView;
import com.beizi.fusion.wp;
import com.beizi.fusion.x1;
import com.zj.adlib.bv9;
import com.zj.adlib.u15;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BeiZiNewLandingPageActivity extends Activity {
    private gp A;
    private List D;
    private List E;
    private BZCarouselView G;
    private TextView H;
    private float I;
    private float J;
    private float K;
    private float L;
    private boolean M;
    private int N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f26920a;
    private boolean a0;
    private ProgressBar b;
    private int b0;
    private boolean c;
    private x1.d c0;
    private String d;
    private int d0;
    private String e;
    private String e0;
    private String f;
    private String f0;
    private boolean g;
    private String g0;
    private boolean h;
    private String h0;
    private boolean i;
    private lj i0;
    private sn j0;
    private nh k;
    private View k0;
    private View l;
    private RelativeLayout l0;
    private RelativeLayout m;
    private CustomRoundImageView m0;
    private ImageView n;
    private ImageView n0;
    private boolean o;
    private long w;
    private RelativeLayout x;
    private FrameLayout y;
    private c4 z;
    private boolean j = true;
    private int p = -1;
    private int q = -1;
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = 0;
    private int B = 0;
    private int C = 3;
    private int F = 0;

    public class a implements of.f {
        public a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                ImageView imageView = BeiZiNewLandingPageActivity.this.n;
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
                BeiZiNewLandingPageActivity beiZiNewLandingPageActivity = BeiZiNewLandingPageActivity.this;
                if (beiZiNewLandingPageActivity.p == 1 && beiZiNewLandingPageActivity.q == 1) {
                    beiZiNewLandingPageActivity.i();
                }
            }
        }
    }

    public class c extends wp {
        public c(Activity activity) {
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
            ProgressBar progressBar = BeiZiNewLandingPageActivity.this.b;
            if (progressBar == null) {
                return;
            }
            if (i < 100 && progressBar.getVisibility() == 8) {
                BeiZiNewLandingPageActivity.this.b.setVisibility(0);
            }
            BeiZiNewLandingPageActivity.this.b.setProgress(i);
            if (i == 100) {
                BeiZiNewLandingPageActivity.this.b.setVisibility(8);
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
                    BeiZiNewLandingPageActivity.this.setContentView(videoView);
                    videoView.start();
                }
            }
        }
    }

    public class d implements lj.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x1.d f26923a;

        public d(x1.d dVar) {
            this.f26923a = dVar;
        }

        @Override // com.beizi.fusion.lj.e
        public void a() {
            BeiZiNewLandingPageActivity.this.a(this.f26923a);
        }

        @Override // com.beizi.fusion.lj.e
        public void b() {
            try {
                c4 c4Var = BeiZiNewLandingPageActivity.this.z;
                if (c4Var != null) {
                    c4Var.c(true);
                }
                BeiZiNewLandingPageActivity beiZiNewLandingPageActivity = BeiZiNewLandingPageActivity.this;
                beiZiNewLandingPageActivity.a(this.f26923a, beiZiNewLandingPageActivity.y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class e implements sn.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f26924a;
        final /* synthetic */ x1.d b;

        public e(int i, x1.d dVar) {
            this.f26924a = i;
            this.b = dVar;
        }

        @Override // com.beizi.fusion.sn.f
        public void a() {
            FrameLayout frameLayout;
            kh.a("BeiZisAd", "handleShakeViewContent click");
            try {
                c4 c4Var = BeiZiNewLandingPageActivity.this.z;
                if (c4Var != null) {
                    c4Var.d(true);
                }
                if (this.f26924a == 1) {
                    BeiZiNewLandingPageActivity beiZiNewLandingPageActivity = BeiZiNewLandingPageActivity.this;
                    View view = beiZiNewLandingPageActivity.k0;
                    if (view != null && (frameLayout = beiZiNewLandingPageActivity.y) != null) {
                        frameLayout.removeView(view);
                        BeiZiNewLandingPageActivity.this.k0 = null;
                    }
                    sn snVar = BeiZiNewLandingPageActivity.this.j0;
                    if (snVar != null) {
                        snVar.k();
                        BeiZiNewLandingPageActivity.this.j0 = null;
                    }
                }
                BeiZiNewLandingPageActivity.this.a(this.b, "", "", "", "", "", "", "", "", 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x1.d f26925a;

        public f(x1.d dVar) {
            this.f26925a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                RelativeLayout relativeLayout = BeiZiNewLandingPageActivity.this.l0;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                BeiZiNewLandingPageActivity beiZiNewLandingPageActivity = BeiZiNewLandingPageActivity.this;
                beiZiNewLandingPageActivity.a(this.f26925a, String.valueOf(beiZiNewLandingPageActivity.I), String.valueOf(BeiZiNewLandingPageActivity.this.J), String.valueOf(BeiZiNewLandingPageActivity.this.K), String.valueOf(BeiZiNewLandingPageActivity.this.L), String.valueOf(BeiZiNewLandingPageActivity.this.I), String.valueOf(BeiZiNewLandingPageActivity.this.J), String.valueOf(BeiZiNewLandingPageActivity.this.K), String.valueOf(BeiZiNewLandingPageActivity.this.L), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class g implements of.f {
        public g() {
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                BeiZiNewLandingPageActivity beiZiNewLandingPageActivity = BeiZiNewLandingPageActivity.this;
                if (beiZiNewLandingPageActivity.m0 != null) {
                    int iJ = so.j(beiZiNewLandingPageActivity) - so.a(BeiZiNewLandingPageActivity.this, 60.0f);
                    int iG = so.g(BeiZiNewLandingPageActivity.this) - so.a(BeiZiNewLandingPageActivity.this, 120.0f);
                    if (width > iJ) {
                        width = iJ;
                    }
                    if (height > iG) {
                        height = iG;
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                    layoutParams.addRule(13);
                    BeiZiNewLandingPageActivity.this.m0.setLayoutParams(layoutParams);
                    BeiZiNewLandingPageActivity beiZiNewLandingPageActivity2 = BeiZiNewLandingPageActivity.this;
                    beiZiNewLandingPageActivity2.m0.setRectRadius(bq.a(beiZiNewLandingPageActivity2, 6.0f));
                    BeiZiNewLandingPageActivity.this.m0.setImageBitmap(bitmap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x1.d f26927a;

        public h(x1.d dVar) {
            this.f26927a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                RelativeLayout relativeLayout = BeiZiNewLandingPageActivity.this.l0;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                gp gpVar = BeiZiNewLandingPageActivity.this.A;
                if (gpVar != null && gpVar.c() == 1) {
                    BeiZiNewLandingPageActivity.this.A.d(0);
                    BeiZiNewLandingPageActivity beiZiNewLandingPageActivity = BeiZiNewLandingPageActivity.this;
                    c4 c4Var = beiZiNewLandingPageActivity.z;
                    if (c4Var != null) {
                        c4Var.a(beiZiNewLandingPageActivity.A);
                    }
                    BeiZiNewLandingPageActivity beiZiNewLandingPageActivity2 = BeiZiNewLandingPageActivity.this;
                    beiZiNewLandingPageActivity2.a(this.f26927a, String.valueOf(beiZiNewLandingPageActivity2.I), String.valueOf(BeiZiNewLandingPageActivity.this.J), String.valueOf(BeiZiNewLandingPageActivity.this.K), String.valueOf(BeiZiNewLandingPageActivity.this.L), String.valueOf(BeiZiNewLandingPageActivity.this.I), String.valueOf(BeiZiNewLandingPageActivity.this.J), String.valueOf(BeiZiNewLandingPageActivity.this.K), String.valueOf(BeiZiNewLandingPageActivity.this.L), 0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class i implements View.OnTouchListener {
        public i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            BeiZiNewLandingPageActivity.this.I = motionEvent.getX();
            BeiZiNewLandingPageActivity.this.J = motionEvent.getY();
            BeiZiNewLandingPageActivity.this.K = motionEvent.getX();
            BeiZiNewLandingPageActivity.this.L = motionEvent.getY();
            return false;
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                BeiZiNewLandingPageActivity beiZiNewLandingPageActivity = BeiZiNewLandingPageActivity.this;
                boolean zL = beiZiNewLandingPageActivity.B == 1 ? beiZiNewLandingPageActivity.l() : false;
                BeiZiNewLandingPageActivity beiZiNewLandingPageActivity2 = BeiZiNewLandingPageActivity.this;
                beiZiNewLandingPageActivity2.B = 0;
                gp gpVar = beiZiNewLandingPageActivity2.A;
                if (gpVar != null) {
                    gpVar.a(0);
                    BeiZiNewLandingPageActivity beiZiNewLandingPageActivity3 = BeiZiNewLandingPageActivity.this;
                    c4 c4Var = beiZiNewLandingPageActivity3.z;
                    if (c4Var != null) {
                        c4Var.a(beiZiNewLandingPageActivity3.A);
                    }
                }
                if (zL) {
                    return;
                }
                BeiZiNewLandingPageActivity.this.a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class k implements View.OnTouchListener {
        public k() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            BeiZiNewLandingPageActivity.this.h = true;
            return false;
        }
    }

    public class l implements BZCarouselView.e {
        public l() {
        }

        @Override // com.beizi.fusion.widget.BZCarouselView.e
        public void a(int i) {
            try {
                BeiZiNewLandingPageActivity beiZiNewLandingPageActivity = BeiZiNewLandingPageActivity.this;
                beiZiNewLandingPageActivity.F = i;
                x1.d dVar = (x1.d) beiZiNewLandingPageActivity.D.get(i);
                BeiZiNewLandingPageActivity beiZiNewLandingPageActivity2 = BeiZiNewLandingPageActivity.this;
                beiZiNewLandingPageActivity2.a(dVar, beiZiNewLandingPageActivity2.y);
                BeiZiNewLandingPageActivity.this.c(dVar);
                BeiZiNewLandingPageActivity beiZiNewLandingPageActivity3 = BeiZiNewLandingPageActivity.this;
                beiZiNewLandingPageActivity3.a((kl) beiZiNewLandingPageActivity3.E.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                BeiZiNewLandingPageActivity beiZiNewLandingPageActivity = BeiZiNewLandingPageActivity.this;
                beiZiNewLandingPageActivity.i = true;
                x1.d dVar = (x1.d) beiZiNewLandingPageActivity.D.get(beiZiNewLandingPageActivity.F);
                BeiZiNewLandingPageActivity beiZiNewLandingPageActivity2 = BeiZiNewLandingPageActivity.this;
                beiZiNewLandingPageActivity2.a(dVar, String.valueOf(beiZiNewLandingPageActivity2.I), String.valueOf(BeiZiNewLandingPageActivity.this.J), String.valueOf(BeiZiNewLandingPageActivity.this.K), String.valueOf(BeiZiNewLandingPageActivity.this.L), String.valueOf(BeiZiNewLandingPageActivity.this.I), String.valueOf(BeiZiNewLandingPageActivity.this.J), String.valueOf(BeiZiNewLandingPageActivity.this.K), String.valueOf(BeiZiNewLandingPageActivity.this.L), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class n implements View.OnTouchListener {
        public n() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            BeiZiNewLandingPageActivity.this.I = motionEvent.getX();
            BeiZiNewLandingPageActivity.this.J = motionEvent.getY();
            BeiZiNewLandingPageActivity.this.K = motionEvent.getX();
            BeiZiNewLandingPageActivity.this.L = motionEvent.getY();
            return false;
        }
    }

    public class o implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f26934a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        public o(String str, String str2, String str3, String str4) {
            this.f26934a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(BeiZiNewLandingPageActivity.this, (Class<?>) DownloadAppInfoActivity.class);
                intent.putExtra("title_content_key", this.f26934a);
                intent.putExtra("privacy_content_key", this.b);
                intent.putExtra("permission_content_key", this.c);
                intent.putExtra("intro_content_key", this.d);
                intent.setFlags(268435456);
                BeiZiNewLandingPageActivity.this.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public class p implements View.OnTouchListener {
        public p() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            BeiZiNewLandingPageActivity.this.h = true;
            return false;
        }
    }

    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiNewLandingPageActivity.this.i();
        }
    }

    private void a(List list, int i2, int i3) {
        if (list == null || list.isEmpty() || this.z == null) {
            return;
        }
        BZCarouselView bZCarouselView = new BZCarouselView(this);
        this.G = bZCarouselView;
        bZCarouselView.setOnContentChangeListener(new l());
        this.G.setImageUrls(list, i2, i3);
        this.G.setScrollInterval(this.C);
        this.y.setVisibility(0);
        this.y.addView(this.G);
        this.y.setOnClickListener(new m());
        this.y.setOnTouchListener(new n());
        if (list.size() == 1) {
            a((kl) this.E.get(0));
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        return !d(str) || this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
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
    public void d() {
        if (this.k == null || TextUtils.isEmpty(this.d) || this.M) {
            return;
        }
        this.M = true;
        String strI = this.k.i();
        if (TextUtils.isEmpty(strI)) {
            return;
        }
        boolean zA = ol.a(this.k.e());
        this.o = zA;
        if (zA) {
            WebView webView = this.f26920a;
            if (webView != null) {
                webView.setOnTouchListener(new p());
            }
            int iH = this.k.h();
            View view = this.l;
            if (view != null && iH == 1) {
                view.setVisibility(0);
                this.l.setOnClickListener(new q());
            }
            this.p = this.k.c();
            this.q = this.k.d();
            this.r = this.k.f();
            this.s = this.k.g();
            this.t = this.k.a();
            this.u = this.k.b();
            if (TextUtils.isEmpty(strI)) {
                RelativeLayout relativeLayout = this.m;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            } else {
                RelativeLayout relativeLayout2 = this.m;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(0);
                }
                this.m.setOnClickListener(new r());
                of.a(this).a(strI, new a());
            }
            if (this.p == 1) {
                int i2 = this.q;
                if (i2 == 0 || i2 == 2) {
                    i();
                }
            }
        }
    }

    private void e() {
        List listJ;
        kl klVarA;
        try {
            if (this.z == null) {
                return;
            }
            this.x = (RelativeLayout) findViewById(R.id.lp_new_root_container_rl);
            this.H = (TextView) findViewById(R.id.lp_new_group_download_tv);
            List<x1.d> listS = this.z.s();
            this.D = new ArrayList();
            if (listS != null && listS.size() > 0) {
                for (x1.d dVar : listS) {
                    if (dVar != null) {
                        if (dVar.x() == 0) {
                            this.D.add(0, dVar);
                        }
                        if (dVar.x() == 1) {
                            this.D.add(dVar);
                        }
                    }
                }
            }
            int iJ = so.j(this);
            int i2 = (int) (((double) iJ) * 0.5625d);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iJ, i2);
            List list = this.D;
            if (list != null && list.size() > 0) {
                FrameLayout frameLayout = (FrameLayout) findViewById(R.id.lp_new_group_image_container_fl);
                this.y = frameLayout;
                frameLayout.setVisibility(0);
                this.y.setLayoutParams(layoutParams);
                ArrayList arrayList = null;
                for (x1.d dVar2 : this.D) {
                    if (dVar2 != null && (listJ = dVar2.j()) != null && listJ.size() > 0 && (klVarA = a(((x1.a) listJ.get(0)).d())) != null) {
                        String strI = klVarA.i();
                        if (!TextUtils.isEmpty(strI)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(strI);
                            if (this.E == null) {
                                this.E = new ArrayList();
                            }
                            x1.b bVarL = dVar2.l();
                            if (bVarL != null) {
                                klVarA.c(bVarL.a());
                                klVarA.a(bVarL.n());
                                klVarA.a(bVarL.c());
                                klVarA.g(bVarL.i());
                                klVarA.d(bVarL.f());
                                klVarA.e(bVarL.g());
                                klVarA.f(bVarL.h());
                                klVarA.h(bVarL.j());
                                klVarA.i(bVarL.k());
                                klVarA.b(bVarL.d());
                            }
                            this.E.add(klVarA);
                        }
                    }
                }
                a(arrayList, iJ, i2);
            }
            this.f26920a = (WebView) findViewById(R.id.lp_new_web_view);
            ((ImageView) findViewById(R.id.lp_new_close_iv)).setOnClickListener(new j());
            this.b = (ProgressBar) findViewById(R.id.lp_new_progress_bar);
            this.l = findViewById(R.id.lp_new_mask_view);
            this.m = (RelativeLayout) findViewById(R.id.lp_new_dialog_container_rl);
            this.n = (ImageView) findViewById(R.id.lp_new_dialog_iv);
            f();
            WebView webView = this.f26920a;
            if (webView != null) {
                webView.setOnTouchListener(new k());
            }
            k();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f() {
        WebView webView = this.f26920a;
        if (webView == null) {
            return;
        }
        kq.c(webView);
        if (!TextUtils.isEmpty(this.e)) {
            this.f26920a.loadUrl(this.e, d9.a());
        }
        this.f26920a.setWebViewClient(new b());
        this.f26920a.setWebChromeClient(new c(this));
    }

    private boolean g() {
        int i2 = this.N;
        if (i2 == 2) {
            return !TextUtils.isEmpty(this.S) && this.S.startsWith("http");
        }
        return i2 == 5 && !TextUtils.isEmpty(this.S);
    }

    private boolean h() {
        if (TextUtils.isEmpty(this.O) || TextUtils.isEmpty(this.U) || TextUtils.isEmpty(this.T) || TextUtils.isEmpty(this.X) || TextUtils.isEmpty(this.Z)) {
            return false;
        }
        if (TextUtils.isEmpty(this.W) && TextUtils.isEmpty(this.V)) {
            return false;
        }
        int i2 = this.N;
        return i2 == 2 || i2 == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        x1.b.C0333b c0333bB = b();
        try {
            if (!this.o) {
                int i2 = this.v + 1;
                this.v = i2;
                int i3 = this.p;
                if (i3 <= 1 && this.r <= 0) {
                    j();
                    return;
                }
                if (this.r == 1) {
                    if (i3 == 1) {
                        if (i2 >= this.s + 1) {
                            j();
                            return;
                        }
                        return;
                    } else {
                        if (i2 >= this.s) {
                            j();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (TextUtils.isEmpty(this.d)) {
                int i4 = this.v + 1;
                this.v = i4;
                int i5 = this.p;
                if (i5 <= 1 && this.r <= 0) {
                    j();
                    return;
                }
                if (this.r == 1) {
                    if (i5 == 1) {
                        if (i4 >= this.s + 1) {
                            j();
                            return;
                        }
                        return;
                    } else {
                        if (i4 >= this.s) {
                            j();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            this.i = true;
            this.g = true;
            Uri uri = Uri.parse(this.d);
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
            } else if (this.d.startsWith("hwpps://landingpage")) {
                Intent intent2 = new Intent();
                intent2.setData(uri);
                intent2.addFlags(268435456);
                startActivity(intent2);
            } else if (this.d.startsWith("intent")) {
                Intent uri2 = Intent.parseUri(this.d, 1);
                uri2.addFlags(268435456);
                startActivity(uri2);
            } else {
                Intent intent3 = new Intent("android.intent.action.VIEW", uri);
                intent3.addFlags(805339136);
                startActivity(intent3);
            }
            if (c0333bB != null) {
                List listF = c0333bB.f();
                c0333bB.h(null);
                bm.a(listF);
                List listD = c0333bB.d();
                c0333bB.f(null);
                bm.a(listD);
            }
            int i6 = this.v + 1;
            this.v = i6;
            int i7 = this.p;
            if (i7 > 1 || this.r > 0) {
                if (this.r == 1) {
                    if (i7 == 1) {
                        if (i6 < this.s + 1) {
                        }
                    } else {
                        if (i6 < this.s) {
                        }
                    }
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (c0333bB != null) {
                    List listC = c0333bB.c();
                    c0333bB.e(null);
                    bm.a(listC);
                }
                this.v++;
                if (this.p > 1 || this.r > 0) {
                }
            } finally {
                int i8 = this.v + 1;
                this.v = i8;
                int i9 = this.p;
                if (i9 <= 1 && this.r <= 0) {
                    j();
                } else if (this.r == 1) {
                    if (i9 == 1) {
                        if (i8 >= this.s + 1) {
                            j();
                        }
                    } else if (i8 >= this.s) {
                        j();
                    }
                }
            }
        }
    }

    private void j() {
        try {
            RelativeLayout relativeLayout = this.m;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                this.m.setOnClickListener(null);
            }
            View view = this.l;
            if (view != null) {
                view.setVisibility(8);
                this.l.setOnClickListener(null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void k() {
        c4 c4Var;
        kj kjVarU;
        kl klVarA;
        try {
            if (this.x != null && (c4Var = this.z) != null && (kjVarU = c4Var.u()) != null && !this.z.z()) {
                x1.d dVarC = this.z.c(2);
                if (dVarC == null) {
                    dVarC = this.z.c(0);
                }
                if (dVarC == null) {
                    return;
                }
                List listJ = dVarC.j();
                if (listJ != null && listJ.size() > 0 && (klVarA = a(((x1.a) listJ.get(0)).d())) != null) {
                    String strI = klVarA.i();
                    if (!TextUtils.isEmpty(strI)) {
                        kjVarU.c(strI);
                    }
                    String strL = klVarA.l();
                    if (!TextUtils.isEmpty(strL)) {
                        kjVarU.d(strL);
                    }
                    String strK = klVarA.k();
                    if (!TextUtils.isEmpty(strK)) {
                        kjVarU.b(strK);
                    }
                }
                this.i0 = new lj();
                this.i0.a(this.x, to.h(this), to.g(this), kjVarU, new d(dVarC));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        c4 c4Var;
        x1.d dVarC;
        List listJ;
        kl klVarA;
        try {
            if (this.B != 1 || (c4Var = this.z) == null || (dVarC = c4Var.c(4)) == null || (listJ = dVarC.j()) == null || listJ.isEmpty() || (klVarA = a(((x1.a) listJ.get(0)).d())) == null) {
                return false;
            }
            String strI = klVarA.i();
            if (TextUtils.isEmpty(strI)) {
                return false;
            }
            this.l0 = (RelativeLayout) findViewById(R.id.lp_new_privilege_container_rl);
            this.m0 = (CustomRoundImageView) findViewById(R.id.lp_new_privilege_iv);
            this.n0 = (ImageView) findViewById(R.id.lp_new_privilege_close_iv);
            this.l0.setVisibility(0);
            this.m0.setOnClickListener(new f(dVarC));
            of.a(this).a(strI, new g());
            this.n0.setOnClickListener(new h(dVarC));
            this.l0.setOnTouchListener(new i());
            a(dVarC, this.l0);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void m() {
        try {
            BZCarouselView bZCarouselView = this.G;
            if (bZCarouselView != null) {
                bZCarouselView.startCarousel();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void n() {
        x1.b.C0333b c0333bB;
        x1.b.C0333b c0333bB2;
        try {
            if (this.d0 == 0) {
                return;
            }
            if (!TextUtils.isEmpty(this.e0) && !TextUtils.isEmpty(this.f0)) {
                if (!hq.a(this, this.e0, this.f0, this.g0) || (c0333bB2 = b()) == null) {
                    return;
                }
                List listH = c0333bB2.h();
                c0333bB2.k(null);
                bm.a(listH);
                return;
            }
            if (TextUtils.isEmpty(this.h0) || !hq.a(this, this.h0) || (c0333bB = b()) == null) {
                return;
            }
            List listH2 = c0333bB.h();
            c0333bB.k(null);
            bm.a(listH2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void o() {
        try {
            BZCarouselView bZCarouselView = this.G;
            if (bZCarouselView != null) {
                bZCarouselView.stopCarousel();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        WebView webView;
        try {
            RelativeLayout relativeLayout = this.m;
            if ((relativeLayout == null || relativeLayout.getVisibility() != 0) && (webView = this.f26920a) != null && webView.canGoBack()) {
                this.f26920a.goBack();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activtiy_beizi_new_landingpage);
            c4 c4Var = c4.w0;
            this.z = c4Var;
            if (c4Var == null) {
                finish();
                return;
            }
            this.b0 = c4Var.t();
            gp gpVarV = this.z.v();
            this.A = gpVarV;
            if (gpVarV != null) {
                this.B = gpVarV.a();
                int iB = this.A.b();
                this.C = iB;
                if (iB <= 0) {
                    this.C = 3;
                }
            }
            x1.d dVarC = this.z.c(0);
            if (dVarC == null) {
                finish();
            } else {
                b(dVarC);
                e();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            lj ljVar = this.i0;
            if (ljVar != null) {
                ljVar.b();
            }
            sn snVar = this.j0;
            if (snVar != null) {
                snVar.k();
            }
            this.j0 = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        sn snVar = this.j0;
        if (snVar != null) {
            snVar.l();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        List listK;
        super.onResume();
        try {
            if (this.z == null) {
                finish();
                return;
            }
            if (!this.j) {
                this.i = false;
                x1.b.C0333b c0333bB = b();
                if (c0333bB != null && (listK = c0333bB.k()) != null && listK.size() > 0) {
                    List listJ = c0333bB.j();
                    c0333bB.p(null);
                    bm.a(listJ);
                }
                m();
                if (!TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(this.e) && !this.e.equals(this.f)) {
                    this.f26920a.loadUrl(this.e, d9.a());
                }
            }
            if (this.t == 1 && System.currentTimeMillis() - this.w < this.u) {
                i();
            }
            this.w = 0L;
            sn snVar = this.j0;
            if (snVar != null) {
                snVar.m();
            }
            this.j = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        try {
            this.w = System.currentTimeMillis();
            if (this.i) {
                this.f = null;
                x1.b.C0333b c0333bB = b();
                if (c0333bB != null) {
                    List listK = c0333bB.k();
                    c0333bB.q(null);
                    bm.a(listK);
                }
                j();
            }
            o();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(x1.d dVar) {
        this.c0 = dVar;
        d(dVar);
        if (!TextUtils.isEmpty(this.d)) {
            x1.b.C0333b c0333bB = b();
            try {
                this.g = true;
                this.i = true;
                Uri uri = Uri.parse(this.d);
                if (uri.getScheme() != null && uri.getScheme().equals("bzopen") && !TextUtils.isEmpty(uri.getHost()) && uri.getPathSegments().size() > 0) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.MAIN");
                    intent.setFlags(268435456);
                    intent.addCategory("android.intent.category.LAUNCHER");
                    String queryParameter = uri.getQueryParameter("flags");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        try {
                            if (!queryParameter.startsWith("0x") && !queryParameter.startsWith("0X")) {
                                intent.setFlags(Integer.parseInt(queryParameter));
                            } else {
                                intent.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
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
                } else if (this.d.startsWith("hwpps://landingpage")) {
                    Intent intent2 = new Intent();
                    intent2.setData(uri);
                    intent2.addFlags(268435456);
                    startActivity(intent2);
                } else if (this.d.startsWith("intent")) {
                    Intent uri2 = Intent.parseUri(this.d, 1);
                    uri2.addFlags(268435456);
                    startActivity(uri2);
                } else {
                    Intent intent3 = new Intent("android.intent.action.VIEW", uri);
                    intent3.addFlags(805339136);
                    startActivity(intent3);
                }
                if (c0333bB != null) {
                    List listF = c0333bB.f();
                    c0333bB.h(null);
                    bm.a(listF);
                    List listD = c0333bB.d();
                    c0333bB.f(null);
                    bm.a(listD);
                    return;
                }
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                if (c0333bB != null) {
                    List listC = c0333bB.c();
                    c0333bB.e(null);
                    bm.a(listC);
                }
                c();
                return;
            }
        }
        c();
    }

    private void c() {
        try {
            if (h() && g()) {
                x1.b.C0333b c0333bB = b();
                int i2 = this.N;
                if (i2 == 2) {
                    if (a8.a(this, this.P)) {
                        a8.b(this, this.P);
                        if (c0333bB != null) {
                            List listI = c0333bB.i();
                            c0333bB.l(null);
                            bm.a(listI);
                            return;
                        }
                        return;
                    }
                    a(this, 1);
                    return;
                }
                if (i2 == 5) {
                    if (!TextUtils.isEmpty(this.Q) && a8.a(this, this.Q)) {
                        a8.b(this, this.Q);
                        return;
                    }
                    if (pg.a(this, this.S)) {
                        if (!this.a0 && this.b0 != 0) {
                            a(this, 2);
                            return;
                        }
                        a(this.S, this);
                        if (c0333bB != null) {
                            List listI2 = c0333bB.i();
                            c0333bB.l(null);
                            bm.a(listI2);
                            return;
                        }
                        return;
                    }
                    n();
                    return;
                }
                return;
            }
            n();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            BeiZiNewLandingPageActivity.this.d();
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
                    if (BeiZiNewLandingPageActivity.this.b(string) && !BeiZiNewLandingPageActivity.this.c(string)) {
                        BeiZiNewLandingPageActivity.this.e(string);
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
            if (!BeiZiNewLandingPageActivity.this.b(str) || BeiZiNewLandingPageActivity.this.c(str)) {
                return true;
            }
            BeiZiNewLandingPageActivity.this.e(str);
            return true;
        }
    }

    public void a(kl klVar) {
        try {
            TextView textView = this.H;
            if (textView == null) {
                return;
            }
            if (klVar == null) {
                textView.setVisibility(8);
                return;
            }
            if (!klVar.m()) {
                this.H.setVisibility(8);
                return;
            }
            int iJ = klVar.j();
            if (iJ != 2 && iJ != 5) {
                this.H.setVisibility(8);
                return;
            }
            this.H.setVisibility(0);
            String strB = klVar.b();
            String strA = klVar.a();
            String strF = klVar.f();
            String strD = klVar.d();
            String strC = !TextUtils.isEmpty(strD) ? strD : klVar.c();
            String strE = klVar.e();
            String strG = klVar.g();
            this.H.setText(Html.fromHtml("应用名称：" + strB + " | 开发者：" + strA + " | 应用版本：" + strF + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
            this.H.setTextColor(Color.parseColor("#999999"));
            this.H.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
            this.H.setOnClickListener(new o(strB, strE, strC, strG));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(x1.d dVar) {
        rn rnVarW;
        FrameLayout frameLayout;
        try {
            View view = this.k0;
            if (view != null && (frameLayout = this.y) != null) {
                frameLayout.removeView(view);
                this.k0 = null;
            }
            sn snVar = this.j0;
            if (snVar != null) {
                snVar.k();
                this.j0 = null;
            }
            if (dVar == null || q1.h().u() || (rnVarW = dVar.w()) == null) {
                return;
            }
            int iG = rnVarW.g();
            int i2 = rnVarW.i();
            double dK = rnVarW.k();
            double dJ = rnVarW.j();
            int iH = rnVarW.h();
            int iB = rnVarW.b();
            double d2 = rnVarW.d();
            double dC = rnVarW.c();
            int iA = rnVarW.a();
            int iE = rnVarW.e();
            int iF = rnVarW.f();
            boolean z = true;
            if (iE != 1 || iB <= 0 || d2 <= AudioStats.AUDIO_AMPLITUDE_NONE || dC <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                z = false;
            }
            boolean zA = this.z.A();
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = new AdSpacesBean.BuyerBean.ShakeViewBean();
            if (zA && z) {
                shakeViewBean.setShakeCount(iB);
                shakeViewBean.setShakeStartAmplitude(d2);
                shakeViewBean.setShakeEndAmplitude(dC);
                shakeViewBean.setRegulatoryAngle(iA);
            } else {
                shakeViewBean.setShakeCount(i2);
                shakeViewBean.setShakeStartAmplitude(dK);
                shakeViewBean.setShakeEndAmplitude(dJ);
                shakeViewBean.setRegulatoryAngle(iH);
            }
            sn snVar2 = new sn(this, shakeViewBean, null, dVar.b());
            this.j0 = snVar2;
            View viewA = snVar2.a(this.y);
            this.k0 = viewA;
            if (viewA != null) {
                if (iG == 0) {
                    viewA.setVisibility(4);
                } else {
                    viewA.setVisibility(0);
                }
            }
            this.j0.a(new e(iF, dVar));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean d(String str) {
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

    private void d(x1.d dVar) {
        x1.b bVarL;
        c4 c4Var;
        this.f = this.e;
        this.c = false;
        this.N = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = false;
        this.e = null;
        this.d = null;
        this.d0 = 0;
        this.e0 = null;
        this.f0 = null;
        this.g0 = null;
        this.h0 = null;
        if (this.z == null || dVar == null || (bVarL = dVar.l()) == null) {
            return;
        }
        this.e = bVarL.p();
        if (TextUtils.isEmpty(this.f)) {
            this.f = this.e;
        }
        this.d = bVarL.k();
        this.N = bVarL.n();
        this.O = bVarL.a();
        this.P = bVarL.t();
        if (this.c0.x() == 0 && (c4Var = this.z) != null) {
            this.Q = c4Var.e();
        }
        this.R = bVarL.b();
        this.S = bVarL.d();
        this.T = bVarL.i();
        this.U = bVarL.c();
        this.V = bVarL.f();
        this.W = bVarL.g();
        this.X = bVarL.h();
        this.Y = bVarL.e();
        this.Z = bVarL.j();
        x1.b.a aVarL = bVarL.l();
        if (aVarL != null) {
            if (aVarL.a() == 1) {
                this.c = true;
            }
            if (aVarL.b() == 1) {
                this.a0 = true;
            }
        }
        this.d0 = bVarL.o();
        this.e0 = bVarL.r();
        this.f0 = bVarL.s();
        this.g0 = bVarL.q();
        this.h0 = bVarL.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            WebView webView = this.f26920a;
            if (webView != null) {
                webView.destroy();
            }
            finish();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, int i2) {
        try {
            File fileF = a8.f(context);
            String absolutePath = fileF != null ? fileF.getAbsolutePath() : "";
            x1.b.C0333b c0333bB = b();
            ApkBean apkBean = new ApkBean(this.S, this.P + ".apk", this.P, absolutePath, this.O, this.R, context.getPackageName() + ".bz.fileprovider", c0333bB, this.T, this.U, this.V, this.W, this.X, this.Y, this.Z);
            apkBean.setSendLocalBroadcast(true);
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", apkBean);
            bundle.putInt("type", i2);
            bundle.putBoolean("isCanJump", this.c);
            bundle.putBoolean("isDownload", h());
            if (i2 == 2) {
                if (c0333bB != null) {
                    bundle.putStringArrayList("openList", (ArrayList) c0333bB.i());
                }
                bundle.putString("landingPageUrl", this.e);
            }
            if (!TextUtils.isEmpty(this.d)) {
                bundle.putString("deeplinkUrl", this.d);
            }
            Serializable serializable = this.k;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (!this.g || this.h) {
            this.g = true;
            Uri uri = po.b(str) ? null : Uri.parse(str);
            if (uri == null) {
                return;
            }
            this.i = true;
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setFlags(268435456);
            try {
                startActivity(intent);
                x1.b.C0333b c0333bB = b();
                if (c0333bB != null) {
                    List listF = c0333bB.f();
                    c0333bB.h(null);
                    bm.a(listF);
                    List listD = c0333bB.d();
                    c0333bB.f(null);
                    bm.a(listD);
                }
            } catch (Exception unused) {
            }
        }
    }

    private x1.b.C0333b b() {
        x1.d dVar;
        x1.b bVarL;
        try {
            if (this.z == null || (dVar = this.c0) == null || (bVarL = dVar.l()) == null) {
                return null;
            }
            return bVarL.m();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean a(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private kl a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith(bv9.b)) {
                JSONObject jSONObject = new JSONObject(str);
                String strE = jSONObject.has("title") ? ng.e(jSONObject, "title") : null;
                String strE2 = jSONObject.has("desc") ? ng.e(jSONObject, "desc") : null;
                String strE3 = jSONObject.has("appIcon") ? ng.e(jSONObject, "appIcon") : null;
                String strE4 = jSONObject.has("Image") ? ng.e(jSONObject, "Image") : null;
                kl klVar = new kl();
                klVar.m(strE);
                klVar.l(strE2);
                klVar.j(strE3);
                klVar.k(strE4);
                return klVar;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x1.d dVar, ViewGroup viewGroup) {
        c4 c4Var;
        if (dVar == null) {
            return;
        }
        try {
            if (dVar.x() == 0 || (c4Var = this.z) == null || viewGroup == null) {
                return;
            }
            c4Var.a(dVar, viewGroup);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x1.d dVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        if (dVar == null) {
            return;
        }
        try {
            if (this.z == null) {
                return;
            }
            if (dVar.x() != 0) {
                g5 g5Var = new g5();
                g5Var.g(str);
                g5Var.c(str5);
                g5Var.h(str2);
                g5Var.d(str6);
                g5Var.e(str3);
                g5Var.a(str7);
                g5Var.f(str4);
                g5Var.b(str8);
                this.z.a(dVar, this.y, g5Var, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), i2);
            }
            b(dVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x1.d dVar) {
        try {
            int[] iArr = new int[2];
            int width = this.y.getWidth();
            int height = this.y.getHeight();
            this.y.getLocationOnScreen(iArr);
            int[] iArrB = ol.b(width / 2, height / 2);
            a(dVar, String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
