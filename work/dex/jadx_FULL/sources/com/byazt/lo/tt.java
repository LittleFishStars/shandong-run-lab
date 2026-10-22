package com.byazt.lo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.byazt.aas.pf;
import com.byazt.bv.BaseConstants;
import com.byazt.ddx.sp;
import com.byazt.dna.qp;
import com.byazt.ete.ic;
import com.byazt.kt.RecyclerView;
import com.byazt.nr.d;
import com.byazt.nr.h;
import com.byazt.nr.m;
import com.byazt.nr.z;
import com.byazt.ux.n;
import com.byazt.xs.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.shandong_school.splash.SplashActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, 13})
public class tt extends com.byazt.ux.c implements qp.c {
    public final Handler gr;
    public boolean gu;
    public AtomicBoolean md;
    public boolean p;
    public com.byazt.qzm.tt qy;
    public long yv;
    public com.byazt.at.uj zm;

    public tt(Context context, ViewGroup viewGroup, sp spVar, ic icVar, String str, int i) {
        super(context, viewGroup, spVar, icVar, str, i);
        this.gu = false;
        this.gr = new d(Looper.getMainLooper(), this);
        this.p = true;
        this.md = new AtomicBoolean();
        this.yv = System.currentTimeMillis();
    }

    @Override // com.byazt.ouz.sl
    public void a() {
    }

    @Override // com.byazt.ouz.sl
    public long c() {
        return 0L;
    }

    @Override // com.byazt.ouz.sl
    public void c(float f) {
    }

    @Override // com.byazt.ouz.sl
    public void c(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.ouz.sl
    public void c(int i, String str) {
    }

    @Override // com.byazt.ouz.sl
    public void c(ic icVar) {
    }

    @Override // com.byazt.ouz.sl
    public void c(boolean z) {
    }

    @Override // com.byazt.ouz.sl
    public void da() {
    }

    public void gt() {
        if (da.tt(this.n)) {
            this.gr.sendEmptyMessageDelayed(10081, 5000L);
        }
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        int i = message.what;
        if (i != 10081) {
            if (i != 10082) {
                return;
            }
            if (!this.md.get()) {
                this.gr.removeMessages(10082);
                return;
            } else {
                c("\"需要下滑浏览更多才能领取奖励哦\"");
                this.gr.sendEmptyMessageDelayed(10082, SplashActivity.f36053a);
                return;
            }
        }
        com.byazt.ux.tt ttVar = this.my;
        if (ttVar != null) {
            ttVar.c();
            this.md.set(true);
            c("\"需要下滑浏览更多才能领取奖励哦\"");
            this.gr.sendEmptyMessageDelayed(10082, SplashActivity.f36053a);
        }
    }

    @Override // com.byazt.ouz.sl
    public void i() {
    }

    public void m() {
        ScrollView scrollView = new ScrollView(this.tt);
        LinearLayout linearLayout = new LinearLayout(this.tt);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this.tt);
        z.c(this.tt, "tt_ecomm_page_backup_img", imageView, 320);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = pf.ve(this.tt, 10.0f);
        layoutParams.leftMargin = pf.ve(this.tt, 10.0f);
        layoutParams.rightMargin = pf.ve(this.tt, 10.0f);
        linearLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(this.tt);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        z.c(this.tt, "tt_ecomm_page_backup_img", imageView2, 320);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = pf.ve(this.tt, 10.0f);
        layoutParams2.leftMargin = pf.ve(this.tt, 10.0f);
        layoutParams2.rightMargin = pf.ve(this.tt, 10.0f);
        linearLayout.addView(imageView2, layoutParams2);
        scrollView.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        this.ve.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
    }

    public void my() {
        this.gr.removeMessages(10082);
    }

    @Override // com.byazt.ouz.sl
    public void n() {
    }

    @Override // com.byazt.ouz.sl
    public void n(int i) {
    }

    public void nu() {
        rh();
        if (this.p) {
            this.p = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.yv);
                jSONObject.put("end", System.currentTimeMillis());
            } catch (JSONException e) {
                m.c(e);
            }
            com.byazt.ddx.uj.c(this.n, "landingpage", "agg_stay_page", new com.byazt.ya.c() { // from class: com.byazt.lo.tt.3
                @Override // com.byazt.ya.c
                public void onSend(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            });
        }
    }

    public void rh() {
        Handler handler = this.gr;
        if (handler != null) {
            handler.removeMessages(10081);
            this.gr.removeMessages(10082);
        }
    }

    @Override // com.byazt.ouz.sl
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.ouz.sl
    public void sp() {
    }

    @Override // com.byazt.ouz.sl
    public int tt() {
        return 0;
    }

    @Override // com.byazt.ouz.sl
    public void tt(int i) {
    }

    @Override // com.byazt.ouz.sl
    public void uj() {
    }

    @Override // com.byazt.ouz.sl
    public void uj(int i) {
    }

    @Override // com.byazt.ux.uj
    public void uj(com.byazt.xj.ve<View> veVar) {
    }

    @Override // com.byazt.ouz.sl
    public int ve() {
        return 0;
    }

    @Override // com.byazt.ouz.sl
    public void ve(int i) {
    }

    @Override // com.byazt.ouz.sl
    public void x() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(@NonNull List<ic> list) {
        this.m = list.size();
        this.nu = list.size();
        this.rh = yp();
        ic icVar = list.get(0);
        if (icVar != null) {
            this.yp = icVar.jm();
        }
        this.i = c(list);
        n.c(this.c, new n.c() { // from class: com.byazt.lo.tt.2
            @Override // com.byazt.ux.n.c
            public void c(JSONObject jSONObject) {
                if (jSONObject != null) {
                    tt ttVar = tt.this;
                    ttVar.c(jSONObject, (List<com.byazt.pj.ve>) ttVar.i);
                } else {
                    tt.this.uj.c(-1, "template info load fail");
                    if (tt.this.f29120a != null) {
                        tt.this.f29120a.c(-1);
                    }
                }
            }
        });
    }

    public void a(int i) {
        if (i == 0) {
            if (this.md.get()) {
                return;
            }
            this.gr.sendEmptyMessageDelayed(10081, 5000L);
            return;
        }
        if (this.md.get()) {
            com.byazt.ux.tt ttVar = this.my;
            if (ttVar != null) {
                ttVar.tt();
            }
            this.md.set(false);
        }
        this.gr.removeMessages(10081);
        this.gr.removeMessages(10082);
    }

    @Override // com.byazt.ux.uj
    public void n(com.byazt.xj.ve<View> veVar) {
        JSONObject jSONObjectDa;
        if (veVar == null || (jSONObjectDa = veVar.da()) == null) {
            return;
        }
        com.byazt.sa.uj ujVarUj = veVar.uj("video_".concat(String.valueOf(jSONObjectDa.optInt("image_mode"))));
        if (ujVarUj instanceof com.byazt.qzm.tt) {
            com.byazt.qzm.tt ttVar = (com.byazt.qzm.tt) ujVarUj;
            this.qy = ttVar;
            ttVar.uj(this.gu);
            this.qy.b();
        }
    }

    @Override // com.byazt.ux.c
    public List<com.byazt.pj.ve> sl() {
        this.i = new ArrayList();
        JSONObject jSONObjectYg = this.n.yg();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "android");
            jSONObjectYg.put("env_info", jSONObject);
        } catch (JSONException e) {
            m.c(e);
        }
        this.i.add(new com.byazt.pj.ve(jSONObjectYg, -2134548432));
        return this.i;
    }

    @Override // com.byazt.ux.c
    public void t() {
        try {
            this.z = da.c(this.n);
            JSONObject jSONObjectJm = this.n.jm();
            this.zm = new com.byazt.at.uj() { // from class: com.byazt.lo.tt.1
                @Override // com.byazt.at.uj
                public void c(boolean z, List<ic> list, boolean z2) {
                    if (!z) {
                        if (tt.this.rl.get() > 0) {
                            tt.this.rl.get();
                            tt.this.rl.decrementAndGet();
                            tt.this.t();
                            return;
                        } else {
                            tt.this.uj.c(-3, "ad meta info load fail");
                            if (tt.this.f29120a != null) {
                                tt.this.f29120a.c(-3);
                                return;
                            }
                            return;
                        }
                    }
                    if (list != null && list.size() > 0) {
                        tt.this.tt(list);
                        return;
                    }
                    if (tt.this.rl.get() <= 0) {
                        if (tt.this.f29120a != null) {
                            tt.this.f29120a.c(-2);
                        }
                    } else {
                        tt.this.rl.get();
                        tt.this.rl.decrementAndGet();
                        tt.this.t();
                    }
                }
            };
            ic icVar = this.n;
            boolean z = false;
            if ((icVar == null || icVar.os() == null || this.n.os().ve() == null || this.n.os().ve().optInt("use_gnd_prefetch", 0) == 1) && com.byazt.ab.tt.c().c(this.n, this.zm)) {
                z = true;
            }
            if (z) {
                return;
            }
            ic icVar2 = this.n;
            com.byazt.hy.tt.c(icVar2, jSONObjectJm, this.zm, icVar2.ij());
        } catch (Exception e) {
            if (this.rl.get() > 0) {
                this.rl.get();
                this.rl.decrementAndGet();
                t();
            } else {
                this.uj.c(-3, e.getMessage());
                com.byazt.qj.c cVar = this.f29120a;
                if (cVar != null) {
                    cVar.c(-3);
                }
            }
        }
    }

    public void ve(boolean z) {
        this.gu = z;
        com.byazt.qzm.tt ttVar = this.qy;
        if (ttVar != null) {
            ttVar.uj(z);
        }
    }

    @Override // com.byazt.ux.c
    public void z() {
        super.z();
        com.byazt.ab.tt.c().tt(this.n);
        rh();
    }

    @Override // com.byazt.ux.uj
    public void c(int i, int i2) {
        if (i2 > 0) {
            this.da.set(1);
        }
    }

    @Override // com.byazt.ux.uj
    public void c(RecyclerView recyclerView, int i) {
        if (da.tt(this.n)) {
            a(i);
        }
    }

    @Override // com.byazt.ux.ve
    public void ve(com.byazt.xj.ve veVar) {
        ic icVarC;
        if (veVar == null) {
            return;
        }
        if (veVar.da().has("ugen_sub_meta")) {
            icVarC = com.byazt.omf.c.c(veVar.da().optJSONObject("ugen_sub_meta"));
        } else {
            icVarC = com.byazt.omf.c.c(veVar.da());
        }
        if (icVarC != null) {
            c(icVarC, veVar);
        }
    }

    @Override // com.byazt.ux.uj
    public void c(com.byazt.xj.ve veVar, int i, View view, com.byazt.pj.ve veVar2) {
        if (veVar2 == null || veVar2.c() == null) {
            return;
        }
        int iHashCode = veVar2.c().hashCode();
        if (this.sl.get(Integer.valueOf(iHashCode)) != null && this.sl.containsKey(Integer.valueOf(iHashCode)) && this.sl.get(Integer.valueOf(iHashCode)).booleanValue()) {
            return;
        }
        c(veVar2.c());
        if (i == this.rh) {
            c(veVar);
        }
        this.sl.put(Integer.valueOf(iHashCode), Boolean.TRUE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("is_slide", 1);
        } catch (JSONException e) {
            m.c(e);
        }
        if (this.da.get() == 1) {
            com.byazt.ddx.uj.c(this.n, this.t, "ugeno_coin_eCommerce_is_slide", jSONObject);
        }
    }

    @Override // com.byazt.ux.uj
    public void a(com.byazt.xj.ve<View> veVar) {
        JSONObject jSONObjectDa;
        if (veVar == null || (jSONObjectDa = veVar.da()) == null) {
            return;
        }
        com.byazt.sa.uj ujVarUj = veVar.uj("video_".concat(String.valueOf(jSONObjectDa.optInt("image_mode"))));
        if (ujVarUj instanceof com.byazt.qzm.tt) {
            ((com.byazt.qzm.tt) ujVarUj).tx();
        }
    }

    @Override // com.byazt.ouz.sl
    public void c(int i) {
        com.byazt.qzm.tt ttVar = this.qy;
        if (ttVar == null) {
            m.uj("BasePageInflater", "onChangeVideoState,mVideoComponent is null !!!!!!!!!!!!");
        } else if (i == 2) {
            ttVar.kk();
        } else if (i == 3) {
            ttVar.q();
        }
    }

    public void c(String str) {
        ViewGroup viewGroup = this.ve;
        if (viewGroup == null || !viewGroup.isShown()) {
            return;
        }
        h.tt(this.tt, str, 0, 49, 0, 60);
    }
}
