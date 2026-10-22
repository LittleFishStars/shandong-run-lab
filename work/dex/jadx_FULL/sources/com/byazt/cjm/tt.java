package com.byazt.cjm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.bwm.n;
import com.byazt.bwm.sp;
import com.byazt.bzd.x;
import com.byazt.ddx.uj;
import com.byazt.ete.l;
import com.byazt.ff.TTProgressBar;
import com.byazt.nc.z;
import com.byazt.nr.h;
import com.byazt.omf.gt;
import com.byazt.omf.yp;
import com.byazt.qq.da;
import com.igexin.push.core.b;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1243, 13})
public class tt implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28366a;
    public final c.InterfaceC0377c c;
    public com.byazt.hc.c tt;
    public boolean x;
    public final AtomicBoolean ve = new AtomicBoolean(false);
    public final AtomicBoolean uj = new AtomicBoolean(false);
    public final AtomicBoolean n = new AtomicBoolean(false);
    public int sp = 0;
    public boolean i = true;
    public String da = "";
    public String sl = "";
    public String t = "";
    public String u = "";
    public String yp = "";

    public tt(c.InterfaceC0377c interfaceC0377c) {
        this.c = interfaceC0377c;
    }

    private void sl() {
        n.tt(new sp("executeMultiProcessCallback") { // from class: com.byazt.cjm.tt.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    yp.c.c(com.byazt.wzi.c.c(gt.getContext()).c(5)).ve(l.tt(tt.this.c.tt()), "recycleRes", null);
                } catch (Throwable unused) {
                }
            }
        }, 5);
    }

    private boolean da() {
        if (!l.tt(this.c.c())) {
            return false;
        }
        if (this.ve.get()) {
            return true;
        }
        da daVar = new da() { // from class: com.byazt.cjm.tt.4
            @Override // com.byazt.qq.da
            public void c() {
                if (tt.this.ve.get()) {
                    return;
                }
                if (tt.this.tt != null) {
                    tt.this.tt.uj();
                }
                tt.this.i();
                uj.c(tt.this.c.c(), "reward_endcard", "reward_again", b.r);
            }

            @Override // com.byazt.qq.da
            public void tt() {
                if (tt.this.ve.get()) {
                    return;
                }
                uj.c(tt.this.c.c(), "reward_endcard", "popup_cancel", (String) null);
                tt.this.c.ve();
            }
        };
        com.byazt.hc.tt ttVar = new com.byazt.hc.tt(this.c.getActivity(), this.c.c());
        this.tt = ttVar;
        ttVar.uj(this.da);
        this.tt.ve(this.sl);
        this.tt.c(this.yp);
        this.c.uj();
        return this.tt.c(daVar).ve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            this.ve.set(true);
            String strUj = l.uj(this.c.c());
            if (TextUtils.isEmpty(strUj)) {
                strUj = String.valueOf(this.f28366a);
            }
            if (TextUtils.isEmpty(strUj)) {
                strUj = String.valueOf(nb.t(this.c.c()));
            }
            com.byazt.cf.sp.c().c(com.byazt.lvl.c.c().c(this.c.c(), strUj), l.ve(this.c.c()), this.sp, new com.byazt.cf.uj(new com.byazt.nh.sp(null) { // from class: com.byazt.cjm.tt.3
                @Override // com.byazt.nh.sp
                public void c() {
                }

                @Override // com.byazt.nh.sp
                public void c(int i, String str) {
                    x.c(new Runnable() { // from class: com.byazt.cjm.tt.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            tt.this.uj("当前无新视频，请点击重试");
                            tt.this.ve.set(false);
                            if (tt.this.tt != null) {
                                tt.this.tt.n();
                            }
                            tt.this.c.c(8, null);
                        }
                    });
                }

                @Override // com.byazt.nh.sp
                public void tt(z zVar) {
                }

                @Override // com.byazt.nh.sp
                public void c(final z zVar) {
                    x.c(new Runnable() { // from class: com.byazt.cjm.tt.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            z zVar2 = zVar;
                            if (zVar2 instanceof com.byazt.yi.ve) {
                                com.byazt.yi.ve veVar = (com.byazt.yi.ve) zVar2;
                                veVar.setPlayAgain(true);
                                veVar.setPlayAgainSourceRit(tt.this.f28366a);
                                veVar.setPlayAgainCount(tt.this.sp + 1);
                                veVar.setMetaMd5(tt.this.c.tt());
                                if (!TextUtils.isEmpty(tt.this.da) && !TextUtils.isEmpty(tt.this.sl)) {
                                    veVar.setPlayAgainRewardAmount(tt.this.sl);
                                    veVar.setPlayAgainRewardName(tt.this.da);
                                }
                                veVar.setCustomPlayAgain(tt.this.x);
                                veVar.showRewardVideoAd(tt.this.c.getActivity());
                                tt.this.c.n();
                                tt.this.uj.set(true);
                            } else {
                                tt.this.uj("当前无新视频，请点击重试");
                                tt.this.ve.set(false);
                            }
                            tt.this.c.c(8, null);
                        }
                    });
                }
            }));
        } catch (Throwable unused) {
            this.ve.set(false);
            uj("当前无新视频，请退出后重试");
        }
    }

    @Override // com.byazt.cjm.c
    public String a() {
        return this.t;
    }

    @Override // com.byazt.cjm.c
    public boolean n() {
        com.byazt.hc.c cVar = this.tt;
        if (cVar == null) {
            return false;
        }
        return cVar.tt();
    }

    @Override // com.byazt.cjm.c
    public String sp() {
        return this.u;
    }

    @Override // com.byazt.cjm.c
    public void tt(boolean z) {
        this.x = z;
    }

    @Override // com.byazt.cjm.c
    public void uj() {
        c.InterfaceC0377c interfaceC0377c = this.c;
        if (interfaceC0377c == null || interfaceC0377c.getActivity() == null || this.c.c() == null || !l.c(this.c.c())) {
            return;
        }
        if (!this.x) {
            boolean z = this.sp == 0;
            this.c.c(z, null, null);
            this.i = z;
        } else {
            this.i = false;
            this.c.c(false, this.da, this.sl);
            final int i = this.sp + 1;
            n.tt(new sp("executeMultiProcessCallback") { // from class: com.byazt.cjm.tt.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        yp ypVarC = yp.c.c(com.byazt.wzi.c.c(gt.getContext()).c(5));
                        Bundle bundle = new Bundle();
                        bundle.putInt("callback_extra_key_next_play_again_count", i);
                        tt.this.c(ypVarC.ve(l.tt(tt.this.c.tt()), "getPlayAgainCondition", bundle));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        }
    }

    @Override // com.byazt.cjm.c
    public boolean ve(int i) {
        c.InterfaceC0377c interfaceC0377c = this.c;
        if (interfaceC0377c == null || interfaceC0377c.getActivity() == null || this.c.c() == null || this.ve.get() || !this.i) {
            return false;
        }
        if (i == 1) {
            c.InterfaceC0377c interfaceC0377c2 = this.c;
            interfaceC0377c2.c(0, c(interfaceC0377c2.getActivity()));
            i();
            uj.c(this.c.c(), "reward_endcard", "reward_again", "endcard");
        } else {
            if (i == 2) {
                return da();
            }
            if (i == 3) {
                c.InterfaceC0377c interfaceC0377c3 = this.c;
                interfaceC0377c3.c(0, c(interfaceC0377c3.getActivity()));
                i();
                uj.c(this.c.c(), "reward_endcard", "reward_again", "videoplaying");
            }
        }
        return true;
    }

    @Override // com.byazt.cjm.c
    public String x() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isPlayAgain", this.n.get());
            jSONObject.put("mSourceRitId", this.f28366a);
            jSONObject.put("mNowPlayAgainCount", this.sp);
            jSONObject.put("isCustomPlayAgain", this.x);
            jSONObject.put("isCanPlayAgain", this.i);
            jSONObject.put("mPlayAgainRewardName", this.da);
            jSONObject.put("mPlayAgainRewardAmount", this.sl);
            jSONObject.put("mLastRewardName", this.t);
            jSONObject.put("mLastRewardAmount", this.u);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.cjm.c
    public void tt(int i) {
        this.f28366a = i;
    }

    @Override // com.byazt.cjm.c
    public void c(boolean z) {
        this.n.set(z);
    }

    @Override // com.byazt.cjm.c
    public boolean tt() {
        return this.uj.get();
    }

    @Override // com.byazt.cjm.c
    public void c(int i) {
        this.sp = i;
    }

    @Override // com.byazt.cjm.c
    public void tt(String str) {
        this.u = str;
    }

    @Override // com.byazt.cjm.c
    public boolean c() {
        return this.n.get();
    }

    @Override // com.byazt.cjm.c
    public void c(String str) {
        this.t = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bundle bundle) {
        boolean z = bundle.getBoolean("play_again_allow");
        this.da = bundle.getString("play_again_reward_name");
        this.sl = bundle.getString("play_again_reward_amount");
        this.yp = bundle.getString("extra_info");
        this.i = z;
        if (z) {
            x.c(new Runnable() { // from class: com.byazt.cjm.tt.2
                @Override // java.lang.Runnable
                public void run() {
                    tt.this.c.c(true, tt.this.da, tt.this.sl);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(final String str) {
        c.InterfaceC0377c interfaceC0377c = this.c;
        if (interfaceC0377c == null || interfaceC0377c.getActivity() == null) {
            return;
        }
        x.c(new Runnable() { // from class: com.byazt.cjm.tt.5
            @Override // java.lang.Runnable
            public void run() {
                h.c(tt.this.c.getActivity(), str, 0);
            }
        });
    }

    @Override // com.byazt.cjm.c
    public void ve() {
        com.byazt.hc.c cVar = this.tt;
        if (cVar != null) {
            cVar.ve();
        }
        sl();
    }

    private TTProgressBar c(final Context context) {
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(240, 240);
        layoutParams.gravity = 17;
        tTProgressBar.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#77000000"));
        gradientDrawable.setCornerRadius(pf.ve(context, 2.0f));
        tTProgressBar.setBackground(gradientDrawable);
        int iVe = pf.ve(context, 10.0f);
        tTProgressBar.setPadding(iVe, iVe, iVe, iVe);
        com.byazt.nr.z.c(context, "tt_normalscreen_loading", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.cjm.tt.6
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(com.byazt.vfu.n.c(context, new BitmapDrawable(context.getResources(), bitmap), 0, 360, 0.5f, 0.5f));
            }
        }, 320);
        return tTProgressBar;
    }

    @Override // com.byazt.cjm.c
    public void ve(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.n.set(jSONObject.getBoolean("isPlayAgain"));
            this.f28366a = jSONObject.optInt("mSourceRitId");
            this.sp = jSONObject.optInt("mNowPlayAgainCount");
            this.x = jSONObject.optBoolean("isCustomPlayAgain");
            this.i = jSONObject.optBoolean("isCanPlayAgain");
            this.da = jSONObject.optString("mPlayAgainRewardName");
            this.sl = jSONObject.optString("mPlayAgainRewardAmount");
            this.t = jSONObject.optString("mLastRewardName");
            this.sl = jSONObject.optString("mPlayAgainRewardAmount");
        } catch (Exception unused) {
        }
    }
}
