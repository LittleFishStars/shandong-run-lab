package com.byazt.cty;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.byazt.aas.md;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ddx.a;
import com.byazt.dn.UgenBanner;
import com.byazt.el.SSWebView;
import com.byazt.ete.bm;
import com.byazt.ete.ic;
import com.byazt.ete.nu;
import com.byazt.ete.qp;
import com.byazt.ff.TTProgressBar;
import com.byazt.lbn.TTViewStub;
import com.byazt.nr.m;
import com.byazt.nt.n;
import com.byazt.omf.cu;
import com.byazt.omf.d;
import com.byazt.omf.gt;
import com.byazt.omf.gu;
import com.byazt.omf.p;
import com.byazt.omf.rl;
import com.byazt.pop.ve;
import com.byazt.tjs.uj;
import com.byazt.vfu.sp;
import com.byazt.wg.tt;
import com.byazt.yih.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, SecExceptionCode.SEC_ERROR_MIDDLE_TIER_UNKONWN_ERROR})
public abstract class BaseLandingPageActivity extends BaseThemeActivity implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTViewStub f28377a;
    public String c;
    public com.byazt.wz.c d;
    public String da;
    public TextView eo;
    public TTProgressBar gr;
    public uj gu;
    public TTViewStub i;
    public TextView m;
    public Button md;
    public tt my;
    public Activity n;
    public UgenBanner nb;
    public TextView nu;
    public boolean pf;
    public SSWebView qy;
    public a rh;
    public com.byazt.jwd.uj rl;
    public boolean sl;
    public TTViewStub sp;
    public String tt;
    public String u;
    public int uj;
    public String ve;
    public TTViewStub x;
    public ImageView yp;
    public d yv;
    public ImageView z;
    public View zb;
    public com.byazt.dyf.tt zm;
    public boolean bx = false;
    public int t = 0;
    public boolean gt = false;
    public JSONArray p = null;
    public String sv = "立即下载";
    public AtomicBoolean h = new AtomicBoolean(true);
    public long aw = Long.MIN_VALUE;
    public final Map<String, ve> or = Collections.synchronizedMap(new HashMap());
    public com.byazt.pop.c cu = new com.byazt.pop.c() { // from class: com.byazt.cty.BaseLandingPageActivity.1
        @Override // com.byazt.pop.c
        public void c() {
            BaseLandingPageActivity baseLandingPageActivity = BaseLandingPageActivity.this;
            baseLandingPageActivity.tt(baseLandingPageActivity.c());
            com.byazt.nt.c.c(BaseLandingPageActivity.this.c);
        }

        @Override // com.byazt.pop.c
        public void tt(long j, long j2, String str, String str2) {
            BaseLandingPageActivity.this.tt("暂停");
            com.byazt.nt.c.tt(BaseLandingPageActivity.this.c, j, j2);
        }

        @Override // com.byazt.pop.c
        public void ve(long j, long j2, String str, String str2) {
            BaseLandingPageActivity.this.tt("下载失败");
            com.byazt.nt.c.ve(BaseLandingPageActivity.this.c, j, j2);
        }

        @Override // com.byazt.pop.c
        public void c(long j, long j2, String str, String str2) {
            BaseLandingPageActivity.this.tt("下载中...");
            com.byazt.nt.c.c(BaseLandingPageActivity.this.c, j, j2);
        }

        @Override // com.byazt.pop.c
        public void c(long j, String str, String str2) {
            BaseLandingPageActivity.this.tt("点击安装");
            com.byazt.nt.c.tt(BaseLandingPageActivity.this.c);
        }

        @Override // com.byazt.pop.c
        public void c(String str, String str2) {
            BaseLandingPageActivity.this.tt("点击打开");
            com.byazt.nt.c.ve(BaseLandingPageActivity.this.c);
        }
    };

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 172})
    public static class c implements DownloadListener {
        public Map<String, ve> c;
        public boolean n;
        public ic tt;
        public String uj;
        public Context ve;

        public c(Map<String, ve> map, ic icVar, Context context, String str, boolean z) {
            this.c = map;
            this.tt = icVar;
            this.ve = context;
            this.uj = str;
            this.n = z;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Map<String, ve> map = this.c;
            if (map != null && map.containsKey(str)) {
                ve veVar = this.c.get(str);
                if (veVar != null) {
                    veVar.c(nb.qy(this.tt), false);
                    return;
                }
                return;
            }
            ve veVarC = x.c(this.ve, str, this.tt, this.uj);
            veVarC.c(com.byazt.wz.x.c(this.tt));
            veVarC.uj(this.n);
            this.c.put(str, veVarC);
            veVarC.c(nb.qy(this.tt), false);
        }
    }

    private void sl() {
        ic icVar = this.qp;
        if (icVar == null) {
            return;
        }
        this.gu = uj.c(this.n, icVar, this.da);
    }

    private void t() {
        if (this.qy == null) {
            return;
        }
        u();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.qp);
        d dVar = new d(this.n);
        this.yv = dVar;
        dVar.uj(this.sl);
        this.yv.tt(this.qy).c(this.qp).ve(arrayList).tt(this.c).uj(this.tt).ve(this.uj).c(this.ve).n(nb.my(this.qp)).c(this.qy).c(true).tt(com.byazt.wz.x.c(this.qp)).c(this);
    }

    private void u() {
        ic icVar = this.qp;
        if (icVar == null || this.qy == null) {
            return;
        }
        String strRl = icVar.rl();
        if (TextUtils.isEmpty(strRl)) {
            return;
        }
        com.byazt.nl.c.c(strRl, this.qy.getInnerIWebView());
    }

    private com.byazt.seg.c yp() {
        nu nuVarYp = this.qp.yp();
        if (nuVarYp == null) {
            return null;
        }
        String strA = nuVarYp.a();
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        com.byazt.seg.c cVar = new com.byazt.seg.c();
        cVar.ve(strA);
        cVar.tt(nuVarYp.sp());
        cVar.c(strA);
        return cVar;
    }

    private boolean z() {
        nu nuVarYp = this.qp.yp();
        if (nuVarYp == null) {
            return false;
        }
        nuVarYp.c(true);
        int iVe = nuVarYp.ve();
        return (iVe == 1 || iVe == 2) && !this.pf;
    }

    public void a() {
        com.byazt.ddx.uj.c(this.qp, getClass().getName());
        com.byazt.ddx.uj.tt(this.qp);
        this.my = new tt(this.rh.c());
    }

    public String c() {
        ic icVar = this.qp;
        if (icVar != null && !TextUtils.isEmpty(icVar.tj())) {
            this.sv = this.qp.tj();
        }
        return this.sv;
    }

    public void c(Bundle bundle) {
    }

    public void c(String str) {
    }

    public void da() {
        sp.c(this);
    }

    public void i() {
        if (this.qp == null) {
            return;
        }
        JSONArray jSONArrayVe = ve(this.da);
        int iT = nb.t(this.qp);
        int iSl = nb.sl(this.qp);
        gu<com.byazt.ddx.c> guVarC = gt.c();
        if (jSONArrayVe == null || guVarC == null || iT <= 0 || iSl <= 0) {
            return;
        }
        bm bmVar = new bm();
        bmVar.f28481a = jSONArrayVe;
        com.byazt.dj.tt ttVarIj = this.qp.ij();
        if (ttVarIj == null) {
            return;
        }
        guVarC.c(md.tt(ttVarIj).ve(6).c(), bmVar, iSl, new gu.tt() { // from class: com.byazt.cty.BaseLandingPageActivity.2
            @Override // com.byazt.omf.gu.tt
            public void c(int i, String str, com.byazt.ete.tt ttVar) {
                BaseLandingPageActivity.this.c(0);
                ttVar.c(i);
                com.byazt.ete.tt.c(ttVar);
            }

            @Override // com.byazt.omf.gu.tt
            public void c(com.byazt.ete.c cVar, com.byazt.ete.tt ttVar) {
                if (cVar != null) {
                    try {
                        BaseLandingPageActivity.this.h.set(false);
                        BaseLandingPageActivity.this.yv.c(cVar.ve());
                    } catch (Exception unused) {
                        BaseLandingPageActivity.this.c(0);
                    }
                }
            }
        });
    }

    public void n() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tt ttVar = this.my;
        if (ttVar != null) {
            ttVar.c(this.n, this.qp);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (x()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        tt();
    }

    @Override // com.byazt.cty.BaseThemeActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        da();
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.ve = intent.getStringExtra("event_tag");
        this.c = intent.getStringExtra(MediationConstant.EXTRA_ADID);
        this.uj = intent.getIntExtra("landing_page_source", -1);
        this.sl = intent.getBooleanExtra("is_outer_click", false);
        this.da = intent.getStringExtra("url");
        this.bx = intent.getBooleanExtra("web_dl_factors", false) && !TextUtils.isEmpty(this.da) && this.da.contains("chengzijianzhan");
        this.da = nb.tt(this.qp, this.da);
        this.u = intent.getStringExtra("title");
        this.t = intent.getIntExtra("get_phone_num_status", 0);
        this.gt = intent.getBooleanExtra("video_is_auto_play", true);
        ic icVar = this.qp;
        if (icVar == null) {
            finish();
            return;
        }
        this.tt = icVar.w_();
        this.n = this;
        c(bundle);
        try {
            gt.c(this.n);
        } catch (Throwable unused) {
        }
        View viewSp = sp();
        this.zb = viewSp;
        setContentView(viewSp);
        n();
        a();
        if (this.qp.d() || !Build.BRAND.equalsIgnoreCase("xiaomi") || Build.VERSION.SDK_INT < 36) {
            return;
        }
        this.zb.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.cty.BaseLandingPageActivity.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                View view = BaseLandingPageActivity.this.zb;
                if (view != null) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    float fDa = pf.da((Context) null);
                    if (iArr[1] <= 0) {
                        view.setPadding(0, (int) fDa, 0, 0);
                    }
                }
            }
        });
    }

    @Override // com.byazt.cty.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        com.byazt.ocd.tt ttVar;
        super.onDestroy();
        a aVar = this.rh;
        if (aVar != null) {
            aVar.sp();
        }
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.qy;
        if (sSWebView != null) {
            com.byazt.nl.c.c(sSWebView);
            cu.c(this.n, this.qy);
            cu.c(this.qy);
        }
        this.qy = null;
        uj ujVar = this.gu;
        if (ujVar != null) {
            ujVar.uj();
        }
        d dVar = this.yv;
        if (dVar != null) {
            dVar.eo();
        }
        com.byazt.wz.c cVar = this.d;
        if (cVar != null) {
            cVar.ve();
        }
        for (Map.Entry<String, ve> entry : this.or.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().ve();
            }
        }
        this.or.clear();
        a aVar2 = this.rh;
        if (aVar2 != null) {
            aVar2.a();
        }
        UgenBanner ugenBanner = this.nb;
        if (ugenBanner != null) {
            ugenBanner.c();
        }
        ic icVar = this.qp;
        if (icVar == null) {
            return;
        }
        nu nuVarYp = icVar.yp();
        if (nuVarYp != null) {
            nuVarYp.c(false);
        }
        if (!this.qp.hs() || this.qp.lz() < 0 || (ttVar = (com.byazt.ocd.tt) rl.c(this.qp.rl(), com.byazt.ocd.tt.class)) == null) {
            return;
        }
        boolean z = System.currentTimeMillis() - this.aw >= ((long) this.qp.lz()) * 1000;
        if (z) {
            com.byazt.ddx.uj.c(this.qp, 4);
        }
        ttVar.c(z ? 5 : 6, null);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        tt ttVar = this.my;
        if (ttVar != null) {
            ttVar.c(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        d dVar = this.yv;
        if (dVar != null) {
            dVar.d();
        }
        for (Map.Entry<String, ve> entry : this.or.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue();
            }
        }
        com.byazt.jwd.uj ujVar = this.rl;
        if (ujVar != null) {
            ujVar.ve();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Window window = getWindow();
        if (this.aw == Long.MIN_VALUE) {
            this.aw = System.currentTimeMillis();
        }
        if (window != null) {
            com.byazt.qw.x.c(window.getDecorView());
        }
        d dVar = this.yv;
        if (dVar != null) {
            dVar.h();
            this.yv.c(new SSWebView.tt() { // from class: com.byazt.cty.BaseLandingPageActivity.10
                @Override // com.byazt.el.SSWebView.tt
                public void c(int i) {
                    BaseLandingPageActivity.this.yv.c(i);
                }
            });
        }
        com.byazt.wz.c cVar = this.d;
        if (cVar != null) {
            cVar.tt();
        }
        for (Map.Entry<String, ve> entry : this.or.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().tt();
            }
        }
        a aVar = this.rh;
        if (aVar != null) {
            aVar.uj();
        }
        com.byazt.jwd.uj ujVar = this.rl;
        if (ujVar != null) {
            ujVar.tt(true);
        }
        i();
        if (this.qp == null || !z()) {
            return;
        }
        if (this.nb == null) {
            this.nb = new UgenBanner(this);
        }
        addContentView(this.nb, new ViewGroup.LayoutParams(-1, -2));
        this.pf = true;
        com.byazt.ete.n nVarZ = this.qp.z();
        String strVe = nVarZ != null ? nVarZ.ve() : this.qp.an();
        this.nb.setTopMargin(pf.ve(this, 50.0f));
        this.nb.c(yp(), this.qp, new com.byazt.hkv.tt(this, this.qp, this.ve, this.uj), strVe, this.qp.v_(), "立即打开", true);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.byazt.qqc.ve veVarC = com.byazt.qqc.ve.c();
        ic icVar = this.qp;
        veVarC.c(this, icVar, nb.zm(icVar));
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        a aVar = this.rh;
        if (aVar != null) {
            aVar.n();
        }
        com.byazt.qqc.ve.c().tt((Context) this, this.qp, false);
    }

    public abstract View sp();

    public void tt() {
        ic icVar = this.qp;
        if (icVar == null || icVar.i() != 4) {
            return;
        }
        TTViewStub tTViewStub = this.i;
        if (tTViewStub != null) {
            tTViewStub.setVisibility(0);
        }
        Button button = (Button) findViewById(2114387729);
        this.md = button;
        if (button != null) {
            tt(c());
            if (this.d == null) {
                this.d = x.c(this.n, this.qp, TextUtils.isEmpty(this.ve) ? nb.c(this.uj) : this.ve);
            }
            this.d.c(this.n, false);
            this.d.c(com.byazt.wz.x.c(this.qp));
            this.d.a(true);
            this.d.uj(this.bx);
            this.d.c(this.cu, false);
            com.byazt.hkv.c cVar = new com.byazt.hkv.c(this.n, this.qp, "embeded_ad_landingpage", this.uj);
            ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).ve(true);
            ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).c(true);
            ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).c((ve) this.d);
            this.md.setOnClickListener(cVar);
            this.md.setOnTouchListener(cVar);
            TextView textView = this.eo;
            if (textView != null) {
                textView.setOnClickListener(cVar);
                this.eo.setOnTouchListener(cVar);
            }
        }
    }

    public void uj() {
        c("detail_skip");
        finish();
    }

    public void ve() {
        if (pf.c(this.qy)) {
            return;
        }
        tt ttVar = this.my;
        if (ttVar != null) {
            ttVar.c(0);
        }
        onBackPressed();
    }

    public boolean x() {
        try {
            if ((ic.uj(this.qp) || qp.c(this.qp)) && pf.c(this.qy)) {
                return true;
            }
            tt ttVar = this.my;
            return ttVar != null && ttVar.tt(this.n, this.qp);
        } catch (Exception unused) {
            return false;
        }
    }

    public void c(final com.byazt.dyf.tt.c cVar, boolean z) {
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.yp = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.cty.BaseLandingPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseLandingPageActivity.this.ve();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.z = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.cty.BaseLandingPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseLandingPageActivity.this.uj();
                }
            });
        }
        TextView textView = (TextView) findViewById(2114387952);
        this.m = textView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(this.u) ? "广告" : this.u);
        }
        TextView textView2 = (TextView) findViewById(2114387627);
        this.nu = textView2;
        if (textView2 != null) {
            ic icVar = this.qp;
            if (icVar != null && icVar.wq() != null) {
                this.qp.wq().c("landing_page");
            }
            this.nu.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.cty.BaseLandingPageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseLandingPageActivity.this.c(cVar);
                }
            });
        }
        c(4);
    }

    private JSONArray ve(String str) {
        int i;
        JSONArray jSONArray = this.p;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.p;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("?id=");
        int iIndexOf2 = str.indexOf("&");
        if (iIndexOf == -1 || iIndexOf2 == -1 || (i = iIndexOf + 4) >= iIndexOf2) {
            return null;
        }
        String strSubstring = str.substring(i, iIndexOf2);
        if (TextUtils.isEmpty(strSubstring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(strSubstring);
        return jSONArray2;
    }

    public void c(com.byazt.dyf.tt.c cVar) {
        if (this.qp == null || isFinishing()) {
            return;
        }
        if (this.zm == null) {
            tt(cVar);
        }
        com.byazt.dyf.tt ttVar = this.zm;
        if (ttVar != null) {
            ttVar.showDislikeDialog();
        }
    }

    public void c(boolean z) {
        com.byazt.jwd.tt.c(this.n).c(z).tt(false).c(this.qy);
        SSWebView sSWebView = this.qy;
        Context applicationContext = getApplicationContext();
        ic icVar = this.qp;
        sSWebView.addJavascriptInterface(new com.byazt.kz.c(sSWebView, applicationContext, icVar != null ? icVar.sp() : this.t, this.qp), "CCWifiJSBridge");
        this.rh = new a(this.qp, this.qy).tt(true).tt(System.currentTimeMillis()).uj(this.qy.getCreateDuration());
        sl();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.c);
            jSONObject.put("url", this.da);
            jSONObject.put("web_title", this.u);
            jSONObject.put("is_multi_process", com.byazt.ue.tt.c());
            jSONObject.put("event_tag", this.ve);
        } catch (JSONException unused) {
        }
        this.rh.c(jSONObject);
        t();
        com.byazt.jwd.uj ujVar = new com.byazt.jwd.uj(this.n, this.yv, this.c, this.rh, this.gu) { // from class: com.byazt.cty.BaseLandingPageActivity.7
            public final long i = System.currentTimeMillis();

            @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    BaseLandingPageActivity baseLandingPageActivity = BaseLandingPageActivity.this;
                    if (baseLandingPageActivity.gr != null && !baseLandingPageActivity.isFinishing()) {
                        BaseLandingPageActivity.this.gr.setVisibility(8);
                    }
                    if (webView != null) {
                        webView.evaluateJavascript(BaseLandingPageActivity.c(this.i), null);
                    }
                } catch (Throwable unused2) {
                }
            }
        };
        this.rl = ujVar;
        this.qy.setWebViewClient(ujVar);
        com.byazt.aas.gt.c(this.qy, p.uj, ic.n(this.qp));
        this.qy.setMixedContentMode(0);
        this.qy.setWebChromeClient(new com.byazt.jwd.ve(this.yv, this.rh) { // from class: com.byazt.cty.BaseLandingPageActivity.8
            @Override // com.byazt.jwd.ve, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                BaseLandingPageActivity baseLandingPageActivity = BaseLandingPageActivity.this;
                if (baseLandingPageActivity.gr == null || baseLandingPageActivity.isFinishing()) {
                    return;
                }
                if (i == 100 && BaseLandingPageActivity.this.gr.isShown()) {
                    BaseLandingPageActivity.this.gr.setVisibility(8);
                } else {
                    BaseLandingPageActivity.this.gr.setProgress(i);
                }
            }
        });
        this.qy.setDownloadListener(new c(this.or, this.qp, this.n, this.ve, this.bx));
        this.qy.setVisibility(0);
        this.rh.ve(System.currentTimeMillis());
        this.qy.loadUrl(this.da);
    }

    public void tt(com.byazt.dyf.tt.c cVar) {
        try {
            com.byazt.dyf.tt ttVar = new com.byazt.dyf.tt(this.n, this.qp.wq(), this.ve, true, com.byazt.xky.tt.c());
            this.zm = ttVar;
            com.byazt.tl.ve.c(this.n, this.qp, ttVar);
            this.zm.setDislikeInteractionCallback(cVar);
        } catch (Exception e) {
            m.ve(e.getMessage());
        }
    }

    public void tt(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.md) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.byazt.cty.BaseLandingPageActivity.9
            @Override // java.lang.Runnable
            public void run() {
                BaseLandingPageActivity baseLandingPageActivity = BaseLandingPageActivity.this;
                if (baseLandingPageActivity.md == null || baseLandingPageActivity.isFinishing()) {
                    return;
                }
                BaseLandingPageActivity.this.md.setText(str);
            }
        });
    }

    public void c(int i) {
        if (ic.uj(this.qp)) {
            pf.c((View) this.z, 4);
        } else if (ic.uj(this.qp)) {
            pf.c((View) this.z, i);
        }
    }

    @Override // com.byazt.nt.n
    public void c(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.p = jSONArray;
        i();
    }

    public static String c(long j) {
        return "const existingScript = document.getElementById('" + j + "');if (!existingScript) {var script = document.createElement('script');script.id = '" + j + "';script.src = '" + ("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/stylex-infra-mono/landing-sdk/index.js?t=" + System.currentTimeMillis()) + "';document.head?.appendChild(script);}";
    }
}
