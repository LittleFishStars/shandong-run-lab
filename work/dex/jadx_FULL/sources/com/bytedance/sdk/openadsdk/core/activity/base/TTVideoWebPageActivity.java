package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.cty.BaseLandingPageActivity;
import com.byazt.dh.ve;
import com.byazt.dna.u;
import com.byazt.dyf.tt;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.ete.zb;
import com.byazt.ff.RoundImageView;
import com.byazt.ff.TTProgressBar;
import com.byazt.lbn.TTViewStub;
import com.byazt.nr.da;
import com.byazt.nr.h;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import com.byazt.ua.c;
import com.byazt.un.NativeVideoTsView;
import com.byazt.un.uj;
import com.byazt.vfu.a;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TTVideoWebPageActivity extends BaseLandingPageActivity {
    private long aw;
    private RelativeLayout bx;
    private RelativeLayout l;
    private TextView lo;
    private TextView lt;
    protected NativeVideoTsView nb;
    protected ve pf;
    private RoundImageView pu;
    private int q;
    private FrameLayout sv;
    private c tx;
    private int ic = 0;
    private int hd = 0;
    private int bm = 0;
    private int lr = 0;
    private boolean to = false;
    private final ve.tt tk = new ve.tt() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.1
        @Override // com.byazt.dh.ve.tt
        public void c(boolean z) {
            TTVideoWebPageActivity.this.to = z;
            if (TTVideoWebPageActivity.this.isFinishing()) {
                return;
            }
            if (!z) {
                pf.c((View) TTVideoWebPageActivity.this.qy, 0);
                pf.c((View) TTVideoWebPageActivity.this.bx, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.sv.getLayoutParams();
                marginLayoutParams.width = TTVideoWebPageActivity.this.bm;
                marginLayoutParams.height = TTVideoWebPageActivity.this.lr;
                marginLayoutParams.leftMargin = TTVideoWebPageActivity.this.hd;
                marginLayoutParams.topMargin = TTVideoWebPageActivity.this.ic;
                TTVideoWebPageActivity.this.sv.setLayoutParams(marginLayoutParams);
                return;
            }
            pf.c((View) TTVideoWebPageActivity.this.qy, 8);
            pf.c((View) TTVideoWebPageActivity.this.bx, 8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.sv.getLayoutParams();
            TTVideoWebPageActivity.this.hd = marginLayoutParams2.leftMargin;
            TTVideoWebPageActivity.this.ic = marginLayoutParams2.topMargin;
            TTVideoWebPageActivity.this.bm = marginLayoutParams2.width;
            TTVideoWebPageActivity.this.lr = marginLayoutParams2.height;
            marginLayoutParams2.width = -1;
            marginLayoutParams2.height = -1;
            marginLayoutParams2.topMargin = 0;
            marginLayoutParams2.leftMargin = 0;
            TTVideoWebPageActivity.this.sv.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean kp = false;
    private boolean b = true;
    private final com.byazt.fn.ve kk = new com.byazt.fn.ve() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.2
        @Override // com.byazt.fn.ve
        public void onNetworkChanged(Context context, Intent intent, boolean z, int i) {
            if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
                if (TTVideoWebPageActivity.this.q == 0 && i != 0) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    if (tTVideoWebPageActivity.qy != null && tTVideoWebPageActivity.da != null) {
                        da.tt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TTVideoWebPageActivity tTVideoWebPageActivity2 = TTVideoWebPageActivity.this;
                                SSWebView sSWebView = tTVideoWebPageActivity2.qy;
                                if (sSWebView != null) {
                                    sSWebView.loadUrl(tTVideoWebPageActivity2.da);
                                }
                            }
                        });
                    }
                }
                NativeVideoTsView nativeVideoTsView = TTVideoWebPageActivity.this.nb;
                if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null && !TTVideoWebPageActivity.this.my() && TTVideoWebPageActivity.this.q != i) {
                    ((uj) TTVideoWebPageActivity.this.nb.getNativeVideoController()).c(context, i);
                }
                TTVideoWebPageActivity.this.q = i;
            }
        }
    };

    private boolean gt() {
        tt ttVar = this.zm;
        return ttVar == null || !ttVar.isShow();
    }

    private long m() {
        NativeVideoTsView nativeVideoTsView = this.nb;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0L;
        }
        return this.nb.getNativeVideoController().yp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean my() {
        NativeVideoTsView nativeVideoTsView = this.nb;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.nb.getNativeVideoController().gt();
    }

    private int nu() {
        NativeVideoTsView nativeVideoTsView = this.nb;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.nb.getNativeVideoController().z();
    }

    private void rh() {
        String strAn;
        ic icVar = this.qp;
        if (icVar == null || icVar.i() != 4) {
            return;
        }
        pf.c((View) this.l, 0);
        if (!TextUtils.isEmpty(this.qp.v_())) {
            strAn = this.qp.v_();
        } else if (TextUtils.isEmpty(this.qp.op())) {
            strAn = !TextUtils.isEmpty(this.qp.an()) ? this.qp.an() : "";
        } else {
            strAn = this.qp.op();
        }
        zb zbVarTe = this.qp.te();
        if (zbVarTe != null && zbVarTe.c() != null) {
            pf.c((View) this.pu, 0);
            pf.c((View) this.lo, 4);
            com.byazt.xky.tt.c(zbVarTe).to(this.pu);
        } else if (!TextUtils.isEmpty(strAn)) {
            pf.c((View) this.pu, 4);
            pf.c((View) this.lo, 0);
            this.lo.setText(strAn.substring(0, 1));
        }
        if (this.lt != null && !TextUtils.isEmpty(strAn)) {
            this.lt.setText(strAn);
        }
        if (!TextUtils.isEmpty(this.qp.tj())) {
            this.eo.setText(this.qp.tj());
        }
        pf.c((View) this.lt, 0);
        if (rl()) {
            pf.c((View) this.eo, 8);
        } else {
            pf.c((View) this.eo, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rl() {
        ic icVar = this.qp;
        if (icVar == null) {
            return false;
        }
        int iKz = icVar.kz();
        return this.uj == 1 && "embeded_ad_landingpage".equals(this.ve) && (iKz == 1 || iKz == 2);
    }

    private void z() {
        if (ic.ve(this.qp)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    Activity activity = this.n;
                    this.nb = new NativeVideoTsView(activity != null ? activity.getApplicationContext() : gt.getContext(), this.qp, true, true);
                } else {
                    Activity activity2 = this.n;
                    this.nb = new NativeVideoTsView(activity2 != null ? activity2.getApplicationContext() : gt.getContext(), this.qp, true, false);
                }
                if (this.nb.getNativeVideoController() != null) {
                    this.nb.getNativeVideoController().c(false);
                    if (this.tx != null) {
                        this.nb.getNativeVideoController().ve(this.tx.c);
                    }
                }
                this.nb.setVideoAdInteractionListener(new com.byazt.ozt.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.4
                    @Override // com.byazt.ozt.c, com.byazt.dh.ve.InterfaceC0386ve
                    public void onProgressUpdate(long j, long j2) {
                        if (TTVideoWebPageActivity.this.rl()) {
                            x.m().c(j);
                        }
                    }
                });
                if (!this.gt) {
                    this.aw = 0L;
                }
                if (this.tx != null && this.nb.getNativeVideoController() != null) {
                    this.nb.getNativeVideoController().ve(this.tx.sp);
                    this.nb.getNativeVideoController().uj(this.tx.n);
                }
                if (this.nb.getNativeVideoController() != null) {
                    this.nb.getNativeVideoController().c(false);
                    this.nb.getNativeVideoController().c(this.tk);
                    this.nb.setIsQuiet(this.qp.ab() == 1);
                }
                if (this.nb.c(this.aw, this.b, my())) {
                    this.sv.setVisibility(0);
                    this.sv.removeAllViews();
                    this.sv.addView(this.nb);
                }
                if (my()) {
                    this.nb.uj(true);
                }
                this.pf = this.nb.getNativeVideoController();
            } catch (Exception e) {
                m.c(e);
            }
            if (rh.ve(this.n.getApplicationContext()) == 0) {
                try {
                    h.c(this.n, "\"无网络，请稍后再试\"", 0);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, com.byazt.cty.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        t();
        NativeVideoTsView nativeVideoTsView = this.nb;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.nb.getNativeVideoController().da();
        }
        NativeVideoTsView nativeVideoTsView2 = this.nb;
        if (nativeVideoTsView2 != null) {
            nativeVideoTsView2.gt();
            this.nb = null;
        }
        this.qp = null;
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, android.app.Activity
    public void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        try {
            if (!this.kp && gt()) {
                this.kp = true;
                this.pf.a();
            }
        } catch (Throwable th) {
            m.uj("BaseLandingPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        if (my() || ((nativeVideoTsView2 = this.nb) != null && nativeVideoTsView2.getNativeVideoController() != null && this.nb.getNativeVideoController().gt())) {
            ic icVar = this.qp;
            com.byazt.it.ve veVarC = com.byazt.vif.uj.c(icVar == null ? null : icVar.jl(), "sp_multi_native_video_data");
            veVarC.put("key_video_is_update_flag", true);
            veVarC.put("key_native_video_complete", true);
            veVarC.put("key_video_isfromvideodetailpage", true);
        }
        if (my() || (nativeVideoTsView = this.nb) == null || nativeVideoTsView.getNativeVideoController() == null) {
            return;
        }
        c(this.nb.getNativeVideoController());
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.b = false;
        if (this.kp && yp() && gt()) {
            this.kp = false;
            this.pf.x();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        ic icVar = this.qp;
        bundle.putString("material_meta", icVar != null ? icVar.yg().toString() : null);
        bundle.putLong("video_play_position", this.aw);
        bundle.putBoolean("is_complete", my());
        long jSl = this.aw;
        NativeVideoTsView nativeVideoTsView = this.nb;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            jSl = this.nb.getNativeVideoController().sl();
        }
        bundle.putLong("video_play_position", jSl);
        super.onSaveInstanceState(bundle);
    }

    public void sl() {
        ((u) com.byazt.ut.uj.getService("device_info_new")).registerNetworkMonitor(this.kk);
    }

    public void t() {
        try {
            ((u) com.byazt.ut.uj.getService("device_info_new")).removeNetworkMonitor(this.kk);
        } catch (Exception unused) {
        }
    }

    public boolean u() {
        ve veVar = this.pf;
        return (veVar == null || veVar.nu() == null || !this.pf.nu().isPlaying()) ? false : true;
    }

    public boolean yp() {
        ve veVar = this.pf;
        return (veVar == null || veVar.nu() == null || !this.pf.nu().isPaused()) ? false : true;
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void a() {
        super.a();
        sl();
        z();
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public View sp() {
        return a.c(this.n, this.qp);
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public boolean x() {
        NativeVideoTsView nativeVideoTsView;
        if (super.x()) {
            return true;
        }
        if (!this.to || (nativeVideoTsView = this.nb) == null || nativeVideoTsView.getNativeVideoController() == null) {
            c("detail_back");
            return false;
        }
        ((com.byazt.dh.c) this.nb.getNativeVideoController()).n(null, null);
        this.to = false;
        return true;
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void n() {
        this.gr = (TTProgressBar) findViewById(2114387922);
        this.qy = (SSWebView) findViewById(2114387733);
        this.i = (TTViewStub) findViewById(2114387956);
        c(new tt.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.3
            @Override // com.byazt.dyf.tt.c
            public void c() {
                if (TTVideoWebPageActivity.this.u()) {
                    TTVideoWebPageActivity.this.pf.a();
                }
            }

            @Override // com.byazt.dyf.tt.c
            public void tt() {
                if (TTVideoWebPageActivity.this.yp()) {
                    TTVideoWebPageActivity.this.pf.x();
                }
            }

            @Override // com.byazt.dyf.tt.c
            public void c(int i, String str, boolean z) {
                if (TTVideoWebPageActivity.this.yp()) {
                    TTVideoWebPageActivity.this.pf.x();
                }
            }
        }, true);
        this.sv = (FrameLayout) findViewById(2114387708);
        this.bx = (RelativeLayout) findViewById(2114387943);
        this.l = (RelativeLayout) findViewById(2114387655);
        this.lo = (TextView) findViewById(2114387957);
        this.lt = (TextView) findViewById(2114387764);
        this.eo = (TextView) findViewById(2114387686);
        this.pu = (RoundImageView) findViewById(2114387664);
        rh();
        tt();
        ic icVar = this.qp;
        if (icVar != null && this.bx != null && icVar.pf()) {
            this.bx.setVisibility(8);
        }
        c(true);
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void c(Bundle bundle) {
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        this.q = rh.ve(getApplicationContext());
        Intent intent = getIntent();
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.aw = bundle.getLong("video_play_position", 0L);
        }
        String stringExtra = intent.getStringExtra("multi_process_data");
        if (stringExtra != null) {
            try {
                this.tx = c.c(new JSONObject(stringExtra));
            } catch (Exception unused2) {
            }
            c cVar = this.tx;
            if (cVar != null) {
                this.aw = cVar.sp;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.qp == null) {
                try {
                    this.qp = com.byazt.omf.c.c(new JSONObject(string));
                } catch (Throwable unused3) {
                }
            }
            long j = bundle.getLong("video_play_position");
            if (j > 0) {
                this.aw = j;
            }
        }
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void c(String str) {
        NativeVideoTsView nativeVideoTsView = this.nb;
        com.byazt.ddx.uj.c(this.qp, tt.AD_TAG_FEED, str, m(), nu(), (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) ? null : nb.c(this.qp, this.nb.getNativeVideoController().t(), this.nb.getNativeVideoController().nu()));
    }

    private void c(ve veVar) {
        m.uj("mutilproces", "initFeedNaitiveControllerData-isComplete=" + veVar.gt() + ",position=" + veVar.sl() + ",totalPlayDuration=" + (veVar.yp() + veVar.t()) + ",duration=" + veVar.yp());
        ic icVar = this.qp;
        com.byazt.it.ve veVarC = com.byazt.vif.uj.c(icVar == null ? null : icVar.jl(), "sp_multi_native_video_data");
        veVarC.put("key_video_is_update_flag", true);
        veVarC.put("key_video_isfromvideodetailpage", true);
        veVarC.put("key_native_video_complete", veVar.gt());
        veVarC.put("key_video_current_play_position", veVar.sl());
        veVarC.put("key_video_total_play_duration", veVar.yp() + veVar.t());
        veVarC.put("key_video_duration", veVar.yp());
    }
}
