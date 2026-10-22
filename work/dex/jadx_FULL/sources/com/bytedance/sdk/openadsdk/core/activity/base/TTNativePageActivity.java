package com.bytedance.sdk.openadsdk.core.activity.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.bv.BaseConstants;
import com.byazt.cty.BaseLandingPageActivity;
import com.byazt.ddx.sp;
import com.byazt.dna.qp;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.fh.a;
import com.byazt.lbn.TTViewStub;
import com.byazt.lo.tt;
import com.byazt.nr.d;
import com.byazt.nr.m;
import com.byazt.nr.z;
import com.byazt.omf.x;
import com.byazt.pg.c;
import com.byazt.wz.uj;
import com.byazt.xs.da;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TTNativePageActivity extends BaseLandingPageActivity implements qp.c {
    private static WeakReference<uj> nb;
    private ImageView aw;
    private com.byazt.lo.uj bm;
    private TTViewStub bx;
    private FrameLayout hd;
    private sp ic;
    private int kp;
    private c l;
    private boolean lo;
    private tt lr;
    private boolean lt;
    private TTViewStub pf;
    private FrameLayout pu;
    private long q;
    private TTViewStub sv;
    private int tk;
    private boolean to;
    private boolean b = true;
    private final d kk = new d(Looper.getMainLooper(), this);

    private void gt() {
        this.tk = 0;
        if (this.lt) {
            this.tk = a.c;
        } else if (this.to && !a.uj) {
            this.tk = kp.yp(this.qp);
        }
        ve(this.tk);
        if (this.tk > 0 && !this.kk.hasMessages(10)) {
            if (this.lt) {
                this.kk.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.to) {
                this.kk.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    private com.byazt.ua.c m() {
        String stringExtra = getIntent().getStringExtra("multi_process_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        try {
            return com.byazt.ua.c.c(new JSONObject(stringExtra));
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    private boolean my() {
        return ic.uj(this.qp);
    }

    private void nu() {
        com.byazt.seg.c cVarV = this.qp.v();
        if (cVarV == null) {
            return;
        }
        int iUj = cVarV.uj();
        if (iUj == 2) {
            com.byazt.lo.uj ujVar = new com.byazt.lo.uj(this.n, this.hd, this.ic, this.qp, this.ve, this.uj);
            this.bm = ujVar;
            ujVar.t();
            return;
        }
        if (iUj == 3) {
            tt ttVar = new tt(this.n, this.hd, this.ic, this.qp, this.ve, this.uj);
            this.lr = ttVar;
            ttVar.tt(false);
            this.lr.t();
            if (TextUtils.equals(cVarV.c(), "3")) {
                return;
            }
            final ImageView imageView = new ImageView(this.n);
            float fVe = pf.ve(this.n, 18.0f);
            float fVe2 = pf.ve(this.n, 18.0f);
            int i = (int) fVe;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.gravity = 53;
            int i2 = (int) fVe2;
            layoutParams.setMargins(i2, i2, i2, i2);
            this.pu.addView(imageView, layoutParams);
            z.c((Context) this.n, "tt_unmute", imageView, 320);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity tTNativePageActivity = TTNativePageActivity.this;
                    tTNativePageActivity.lo = !tTNativePageActivity.lo;
                    TTNativePageActivity tTNativePageActivity2 = TTNativePageActivity.this;
                    z.c((Context) tTNativePageActivity2.n, tTNativePageActivity2.lo ? "tt_mute" : "tt_unmute", imageView, 320);
                    TTNativePageActivity.this.lr.ve(TTNativePageActivity.this.lo);
                }
            });
        }
    }

    private boolean rh() {
        return this.lt || this.to;
    }

    private void u() {
        ic icVar = this.qp;
        if (icVar == null || icVar.v() == null || this.qp.v().uj() != 3) {
            return;
        }
        com.byazt.ab.tt.c().c(this.qp);
    }

    private void ve(int i) {
        if (i <= 0) {
            if (this.lt) {
                pf.c(this.m, "领取成功");
                return;
            } else {
                if (this.to) {
                    pf.c((View) this.aw, 8);
                    pf.c(this.m, "恭喜你！福利已领取");
                    return;
                }
                return;
            }
        }
        if (this.lt) {
            pf.c(this.m, i + "s后可领取奖励");
            return;
        }
        if (this.to) {
            SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
            spannableString.setSpan(new ForegroundColorSpan(-65536), spannableString.length() + (-4), spannableString.length(), 17);
            pf.c(this.m, spannableString);
        }
    }

    private void yp() {
        this.to = kp.my(this.qp);
        boolean zRh = kp.rh(this.qp);
        this.lt = zRh;
        if (this.to) {
            if (!a.uj) {
                this.lt = false;
            } else if (zRh) {
                this.to = false;
            }
        }
    }

    private void z() {
        this.q = System.currentTimeMillis();
        sp spVar = new sp(this.qp);
        this.ic = spVar;
        spVar.c(true);
        this.ic.c();
        if (!da.x(this.qp)) {
            nu();
            return;
        }
        c cVar = new c(this, this.hd, this.ic, this.qp, this.ve, this.uj, m());
        this.l = cVar;
        cVar.c(new com.byazt.qj.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.4
            @Override // com.byazt.qj.c
            public void c(int i) {
                TTNativePageActivity.this.tt(i);
            }

            @Override // com.byazt.qj.c
            public void c(View view) {
            }
        });
        this.l.c();
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void a() {
        com.byazt.ddx.uj.c(this.qp, getClass().getName());
        u();
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message.what == 10 && rh()) {
            int i = this.kp + 1;
            this.kp = i;
            if (this.lt) {
                a.tt = i;
            }
            int iMax = Math.max(0, this.tk - i);
            ve(iMax);
            if (iMax <= 0 && this.to) {
                a.uj = true;
            }
            this.kk.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void n() {
        TTViewStub tTViewStub;
        this.pu = (FrameLayout) findViewById(2114387634);
        this.hd = (FrameLayout) findViewById(2114387720);
        this.i = (TTViewStub) findViewById(2114387956);
        this.pf = (TTViewStub) findViewById(2114387770);
        this.bx = (TTViewStub) findViewById(2114387792);
        this.sv = (TTViewStub) findViewById(2114387933);
        yp();
        ic icVar = this.qp;
        if (icVar != null && icVar.wq() != null) {
            this.qp.wq().c("landing_page");
        }
        if (this.lt || this.to) {
            TTViewStub tTViewStub2 = this.sv;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.aw = (ImageView) findViewById(2114387843);
        } else {
            int iMd = x.m().md();
            if (iMd == 0) {
                TTViewStub tTViewStub3 = this.pf;
                if (tTViewStub3 != null) {
                    tTViewStub3.setVisibility(0);
                }
            } else if (iMd == 1 && (tTViewStub = this.bx) != null) {
                tTViewStub.setVisibility(0);
            }
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.yp = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.z = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        this.m = (TextView) findViewById(2114387952);
        this.nu = (TextView) findViewById(2114387627);
        TextView textView = this.m;
        if (textView != null && !this.lt && !this.to) {
            textView.setText(TextUtils.isEmpty(this.u) ? "广告" : this.u);
        }
        TextView textView2 = this.nu;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.c(new com.byazt.dyf.tt.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.3.1
                        @Override // com.byazt.dyf.tt.c
                        public void c() {
                            TTNativePageActivity.this.sl();
                        }

                        @Override // com.byazt.dyf.tt.c
                        public void tt() {
                            TTNativePageActivity.this.t();
                        }

                        @Override // com.byazt.dyf.tt.c
                        public void c(int i, String str, boolean z) {
                            TTNativePageActivity.this.t();
                        }
                    });
                }
            });
        }
        z();
        c(4);
        if (this.lt || this.to) {
            gt();
        }
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, com.byazt.cty.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable th) {
            m.c(th);
        }
        c cVar = this.l;
        if (cVar != null) {
            cVar.uj();
        }
        tt ttVar = this.lr;
        if (ttVar != null) {
            ttVar.z();
        }
        sp spVar = this.ic;
        if (spVar != null) {
            spVar.uj();
        }
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        c cVar = this.l;
        if (cVar != null) {
            cVar.tt();
        }
        sl();
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        sp spVar = this.ic;
        if (spVar != null) {
            spVar.ve();
        }
        t();
        c cVar = this.l;
        if (cVar != null) {
            cVar.ve();
        }
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        sp spVar = this.ic;
        if (spVar != null) {
            spVar.c(0);
        }
        if (this.b) {
            this.b = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.q);
                jSONObject.put("end", System.currentTimeMillis());
                com.byazt.ic.c.c(jSONObject, this.qp);
            } catch (JSONException e) {
                m.c(e);
            }
            com.byazt.ddx.uj.c(this.qp, "landingpage", "agg_stay_page", new com.byazt.ya.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.6
                @Override // com.byazt.ya.c
                public void onSend(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            });
        }
    }

    public void sl() {
        if (rh()) {
            this.kk.removeMessages(10);
        }
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public View sp() {
        return com.byazt.vfu.a.nb(this.n);
    }

    public void t() {
        if (!rh() || this.kk.hasMessages(10)) {
            return;
        }
        this.kk.sendEmptyMessageDelayed(10, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(int i) {
        WeakReference<uj> weakReference;
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if (!intent.getBooleanExtra("is_replace_dialog", false) || (weakReference = nb) == null || weakReference.get() == null) {
            Intent intent2 = (ic.ve(this.qp) && nb.sp(this.qp)) ? new Intent(this, (Class<?>) TTVideoWebPageActivity.class) : new Intent(this, (Class<?>) TTWebPageActivity.class);
            intent2.putExtras(intent);
            try {
                com.byazt.nr.tt.c(this.n, intent2, null);
            } catch (Throwable th) {
                m.tt("TTNativePageActivity", th);
            }
        } else {
            nb.get().c(false);
            nb.get().c(nb.qy(this.qp), false);
            nb = null;
        }
        finish();
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void c(Bundle bundle) {
        setRequestedOrientation(1);
        getWindow().addFlags(1024);
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void c(int i) {
        if (my()) {
            pf.c((View) this.z, 4);
        } else {
            if (this.z == null || !my()) {
                return;
            }
            pf.c((View) this.z, i);
        }
    }

    public static void c(uj ujVar) {
        nb = new WeakReference<>(ujVar);
    }
}
