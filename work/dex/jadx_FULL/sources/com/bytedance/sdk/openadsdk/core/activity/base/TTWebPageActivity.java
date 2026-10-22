package com.bytedance.sdk.openadsdk.core.activity.base;

import android.R;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.byazt.aas.cu;
import com.byazt.aas.pf;
import com.byazt.ab.tt;
import com.byazt.cty.BaseLandingPageActivity;
import com.byazt.dna.qp;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ff.TTProgressBar;
import com.byazt.fh.a;
import com.byazt.lbn.TTViewStub;
import com.byazt.nr.d;
import com.byazt.omf.x;
import com.byazt.ows.c;
import com.byazt.ows.uj;
import com.byazt.ows.ve;
import com.byazt.vfu.n;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TTWebPageActivity extends BaseLandingPageActivity implements qp.c {
    private static final String nb = "TTWebPageActivity";
    private int aw;
    private boolean bx;
    private final d hd = new d(Looper.getMainLooper(), this);
    private int ic;
    private ImageView pf;
    private boolean sv;

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (z()) {
            this.hd.removeMessages(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu() {
        if (!z() || this.hd.hasMessages(10)) {
            return;
        }
        this.hd.sendEmptyMessageDelayed(10, 1000L);
    }

    private void u() {
        TTViewStub tTViewStub;
        this.sv = kp.my(this.qp);
        boolean z = kp.rh(this.qp) && !a.ve;
        this.bx = z;
        if (this.sv) {
            if (!a.uj) {
                this.bx = false;
            } else if (z) {
                this.sv = false;
            }
        }
        if (this.bx || this.sv) {
            TTViewStub tTViewStub2 = this.x;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.pf = (ImageView) findViewById(2114387843);
            return;
        }
        ic icVar = this.qp;
        if (icVar != null && icVar.pf()) {
            TTViewStub tTViewStub3 = this.f28377a;
            if (tTViewStub3 != null) {
                tTViewStub3.setVisibility(8);
            }
            TTViewStub tTViewStub4 = this.sp;
            if (tTViewStub4 != null) {
                tTViewStub4.setVisibility(8);
                return;
            }
            return;
        }
        int iMd = x.m().md();
        if (iMd != 0) {
            if (iMd == 1 && (tTViewStub = this.sp) != null) {
                tTViewStub.setVisibility(0);
                return;
            }
            return;
        }
        TTViewStub tTViewStub5 = this.f28377a;
        if (tTViewStub5 != null) {
            tTViewStub5.setVisibility(0);
        }
    }

    private void yp() {
        this.aw = 0;
        if (this.bx) {
            this.aw = a.c;
        } else if (this.sv && !a.uj) {
            this.aw = kp.yp(this.qp);
        }
        tt(this.aw);
        if (this.aw > 0 && !this.hd.hasMessages(10)) {
            if (this.bx) {
                this.hd.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.sv) {
                this.hd.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    private boolean z() {
        return this.bx || this.sv;
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void a() {
        super.a();
        tt.c().c(this.qp);
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message.what == 10 && z()) {
            int i = this.ic + 1;
            this.ic = i;
            if (this.bx) {
                a.tt = i;
            }
            int iMax = Math.max(0, this.aw - i);
            tt(iMax);
            if (iMax <= 0 && this.sv) {
                a.uj = true;
            }
            this.hd.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void n() {
        u();
        boolean z = z();
        c(new com.byazt.dyf.tt.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.1
            @Override // com.byazt.dyf.tt.c
            public void c() {
                TTWebPageActivity.this.m();
            }

            @Override // com.byazt.dyf.tt.c
            public void tt() {
                TTWebPageActivity.this.nu();
            }

            @Override // com.byazt.dyf.tt.c
            public void c(int i, String str, boolean z2) {
                TTWebPageActivity.this.nu();
            }
        }, !z);
        if (z) {
            yp();
        }
        tt();
        c(false);
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, com.byazt.cty.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        tt.c().tt(this.qp);
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        m();
        tt(false);
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        nu();
        tt(true);
    }

    public int sl() {
        return -1;
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public View sp() {
        Activity activity = this.n;
        if (activity == null) {
            return null;
        }
        Resources resources = activity.getResources();
        LinearLayout linearLayoutT = t();
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayoutT.setOrientation(1);
        linearLayoutT.setLayoutParams(layoutParams);
        TTViewStub tTViewStub = new TTViewStub(this.n, new com.byazt.ows.tt());
        this.f28377a = tTViewStub;
        tTViewStub.setId(2114387770);
        linearLayoutT.addView(this.f28377a, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub2 = new TTViewStub(this.n, new ve());
        this.sp = tTViewStub2;
        tTViewStub2.setId(2114387792);
        linearLayoutT.addView(this.sp, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub3 = new TTViewStub(this.n, new uj());
        this.x = tTViewStub3;
        tTViewStub3.setId(2114387933);
        linearLayoutT.addView(this.x, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.n);
        linearLayoutT.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        SSWebView sSWebView = new SSWebView(this.n);
        this.qy = sSWebView;
        sSWebView.setMaterialMeta(cu.c(this.qp));
        this.qy.setId(2114387733);
        this.qy.setLayoutParams(new FrameLayout.LayoutParams(-1, sl()));
        frameLayout.addView(this.qy);
        try {
            this.qy.setBackgroundColor(0);
            this.qy.setBackgroundResource(R.color.transparent);
        } catch (Exception unused) {
        }
        TTViewStub tTViewStub4 = new TTViewStub(this.n, new c());
        this.i = tTViewStub4;
        tTViewStub4.setId(2114387956);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 48.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 81;
        frameLayout.addView(this.i, layoutParams2);
        TTProgressBar tTProgressBar = new TTProgressBar(this.n, null, R.style.Widget.ProgressBar.Horizontal);
        this.gr = tTProgressBar;
        tTProgressBar.setId(2114387922);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics()));
        layoutParams3.gravity = 49;
        this.gr.setLayoutParams(layoutParams3);
        this.gr.setProgress(1);
        this.gr.setProgressDrawable(n.c());
        frameLayout.addView(this.gr);
        return linearLayoutT;
    }

    public LinearLayout t() {
        return new LinearLayout(this.n);
    }

    private void tt(boolean z) {
        com.byazt.omf.d dVar;
        ic icVar = this.qp;
        if (icVar == null || !icVar.bz() || (dVar = this.yv) == null) {
            return;
        }
        dVar.sl(z);
    }

    private void tt(int i) {
        if (i > 0) {
            if (this.bx) {
                pf.c(this.m, i + "s后可领取奖励");
                return;
            }
            if (this.sv) {
                SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
                spannableString.setSpan(new ForegroundColorSpan(-65536), spannableString.length() + (-4), spannableString.length(), 17);
                pf.c(this.m, spannableString);
                return;
            }
            return;
        }
        if (this.bx) {
            pf.c(this.m, "领取成功");
        } else if (this.sv) {
            pf.c((View) this.pf, 8);
            pf.c(this.m, "恭喜你！福利已领取");
        }
    }
}
