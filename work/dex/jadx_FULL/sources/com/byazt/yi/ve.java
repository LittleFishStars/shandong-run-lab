package com.byazt.yi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.aas.h;
import com.byazt.aas.nb;
import com.byazt.aas.rl;
import com.byazt.bzd.x;
import com.byazt.cf.sp;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.l;
import com.byazt.ete.xd;
import com.byazt.fcd.uj;
import com.byazt.nc.z;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.sbm.a;
import com.byazt.sq.n;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoLandscapeActivity;
import com.kc.aw.lib.constants.PtgRewardConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 216, 54})
public class ve extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f29206a;
    public final Context c;
    public com.byazt.tn.tt da;
    public com.byazt.xjc.ve gr;
    public com.byazt.tn.c i;
    public String m;
    public String n;
    public String nu;
    public boolean rh;
    public com.byazt.pop.c sl;
    public String t;
    public final ic tt;
    public int u;
    public final com.byazt.dj.tt ve;
    public com.byazt.tn.c x;
    public boolean yp;
    public boolean zm;
    public final AtomicBoolean sp = new AtomicBoolean(false);
    public int z = 1;
    public int my = -1;
    public Double gt = null;
    public boolean rl = false;
    public boolean qy = false;
    public long gu = System.currentTimeMillis();
    public boolean uj = false;

    public ve(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        this.c = context;
        this.tt = icVar;
        this.ve = ttVar;
        this.t = icVar.hashCode() + icVar.qy() + hashCode();
        com.byazt.rgb.tt.c(icVar, ttVar, 7, getLifecycleId());
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.rgb.tt.ve(getLifecycleId(), 3);
    }

    @Override // com.byazt.nc.z
    public long getExpirationTimestamp() {
        return this.f29206a;
    }

    @Override // com.byazt.nc.z
    public int getInteractionType() {
        ic icVar = this.tt;
        if (icVar == null) {
            return -1;
        }
        return icVar.i();
    }

    public String getLifecycleId() {
        ic icVar = this.tt;
        if (icVar == null) {
            return null;
        }
        return icVar.zm();
    }

    @Override // com.byazt.nc.z
    public Map<String, Object> getMediaExtraInfo() {
        ic icVar = this.tt;
        if (icVar == null) {
            return null;
        }
        Map<String, Object> mapYt = icVar.yt();
        if (mapYt == null) {
            mapYt = new HashMap<>();
        }
        mapYt.put("expireTimestamp", Long.valueOf(getExpirationTimestamp()));
        mapYt.put("isRDEnable", Boolean.valueOf(kp.uj(this.tt)));
        mapYt.put("isPangle", Boolean.TRUE);
        mapYt.put("adSceneType", Integer.valueOf(uj.c(this.tt)));
        return mapYt;
    }

    @Override // com.byazt.nc.z
    public a getMediationManager() {
        return new com.byazt.ah.uj();
    }

    @Override // com.byazt.nc.z
    public int getRewardVideoAdType() {
        ic icVar = this.tt;
        if (icVar == null) {
            return -1;
        }
        if (rl.ve(icVar)) {
            return 2;
        }
        if (rl.uj(this.tt)) {
            return 1;
        }
        return com.byazt.ex.c.c(this.tt) ? 3 : 0;
    }

    @Override // com.byazt.nc.x
    public void loss(Double d, String str, String str2) {
        if (this.qy) {
            return;
        }
        h.c(this.tt, d, str, str2);
        this.qy = true;
    }

    public void preloadNextVideo() {
        if (this.tt == null || this.ve == null || this.yp || this.zm || gt.tt().hz() != 0) {
            return;
        }
        try {
            if (this.uj) {
                sp.c().c(this.ve);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.nc.x
    public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
        ic icVar = this.tt;
        if (icVar != null) {
            com.byazt.omf.rl.c(icVar.rl(), ttVar, com.byazt.ocd.tt.class);
        }
    }

    public void setCustomPlayAgain(boolean z) {
        this.rh = z;
    }

    @Override // com.byazt.nc.z
    public void setDownloadListener(com.byazt.ocd.ve veVar) {
        this.sl = com.byazt.pop.c.C0504c.c(veVar);
    }

    public void setExpirationTimestamp(long j) {
        this.f29206a = j;
    }

    public void setInsertAdBundle(com.byazt.xjc.ve veVar) {
        this.gr = veVar;
    }

    public void setMetaMd5(String str) {
        this.t = str;
    }

    public void setPlayAgain(boolean z) {
        this.yp = z;
    }

    public void setPlayAgainCount(int i) {
        this.z = i;
    }

    public void setPlayAgainRewardAmount(String str) {
        this.nu = str;
    }

    public void setPlayAgainRewardName(String str) {
        this.m = str;
    }

    public void setPlayAgainSourceRit(int i) {
        this.u = i;
    }

    public void setPreload() {
        if (this.sp.get()) {
            return;
        }
        this.uj = true;
    }

    @Override // com.byazt.nc.x
    public void setPrice(Double d) {
        this.gt = d;
    }

    @Override // com.byazt.nc.z
    public void setRewardAdInteractionListener(com.byazt.tn.c cVar) {
        if (this.sp.get()) {
            c.c(this.t, cVar);
        } else {
            this.x = cVar;
        }
    }

    @Override // com.byazt.nc.z
    public void setRewardPlayAgainController(com.byazt.tn.tt ttVar) {
        if (!this.sp.get()) {
            this.da = ttVar;
        } else {
            setCustomPlayAgain(true);
            c.c(l.tt(this.t), ttVar);
        }
    }

    @Override // com.byazt.nc.z
    public void setRewardPlayAgainInteractionListener(com.byazt.tn.c cVar) {
        if (this.sp.get()) {
            c.c(l.c(this.t), cVar);
        } else {
            this.i = cVar;
        }
    }

    public void setSecondAdPage(boolean z) {
        this.zm = z;
    }

    public void setVideoCacheCallbackResult(int i) {
        this.my = i;
    }

    @Override // com.byazt.nc.z
    public void showRewardVideoAd(Activity activity) {
        com.byazt.rgb.tt.tt(getLifecycleId());
        ic icVar = this.tt;
        String strW_ = icVar != null ? icVar.w_() : "";
        ic icVar2 = this.tt;
        new com.byazt.ddx.c.C0382c().n(icVar2 != null ? icVar2.uj() : "0").c("rewarded_video").tt("show_start").uj(strW_).c((com.byazt.ya.c) null);
        if (activity != null && activity.isFinishing()) {
            m.uj("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.sp.get()) {
            return;
        }
        ic icVar3 = this.tt;
        if (icVar3 != null) {
            com.byazt.iyp.tt.c(icVar3, "rewarded_video", activity, this.n, this.uj);
        }
        this.sp.set(true);
        ic icVar4 = this.tt;
        if (icVar4 == null || xd.z(icVar4) == null) {
            return;
        }
        if (getInteractionType() == 4) {
            x.c(new com.byazt.bwm.sp("reward_register_download") { // from class: com.byazt.yi.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.yih.x.c(ve.this.c, ve.this.tt, "rewarded_video").c(ve.this.sl);
                }
            });
        }
        com.byazt.omf.tt.c().put("reward_video_show_time", System.currentTimeMillis());
        Context context = activity == null ? this.c : activity;
        if (context == null) {
            context = gt.getContext();
        }
        c();
        Intent intent = this.tt.by() == 2 ? new Intent(context, (Class<?>) TTRewardVideoLandscapeActivity.class) : new Intent(context, (Class<?>) TTRewardVideoActivity.class);
        if (activity == null) {
            intent.addFlags(268435456);
        }
        if (this.yp) {
            intent.putExtra("is_play_again", true);
            intent.putExtra("play_again_count", this.z);
        } else {
            this.u = nb.t(this.tt);
        }
        if (this.zm) {
            intent.putExtra("is_second_page", true);
        }
        intent.putExtra("source_rit_id", this.u);
        intent.putExtra("custom_play_again", this.rh);
        com.byazt.dj.tt ttVar = this.ve;
        if (ttVar != null) {
            intent.putExtra("media_extra", ttVar.u());
            intent.putExtra("userData", this.ve.qy());
            intent.putExtra(PtgRewardConstant.REWARD_PARAMS.USER_ID, this.ve.yp());
            intent.putExtra("reward_name", this.ve.gr());
            intent.putExtra("reward_amount", this.ve.zm());
            intent.putExtra("is_adm", !TextUtils.isEmpty(this.ve.rl()));
        }
        if (this.yp && !TextUtils.isEmpty(this.m) && !TextUtils.isEmpty(this.nu)) {
            intent.putExtra("reward_again_name", this.m);
            intent.putExtra("reward_again_amount", this.nu);
        }
        intent.putExtra("is_preload", this.uj);
        intent.putExtra("object_create_ts", this.gu);
        Double d = this.gt;
        intent.putExtra("_client_bidding_aution_price", d != null ? String.valueOf(d) : "");
        if (!TextUtils.isEmpty(this.n)) {
            intent.putExtra("rit_scene", this.n);
        }
        int i = this.my;
        if (i != -1) {
            intent.putExtra("key_video_cache_callback", i);
        }
        nb.c(intent, this.tt);
        intent.putExtra("multi_process_key", this.t);
        com.byazt.xjc.ve veVar = this.gr;
        if (veVar != null) {
            intent.putExtra("insert_ad_bundle", veVar.i().toString());
        }
        c(context, intent);
        com.byazt.dz.uj.c().c(this.tt).c(7);
    }

    @Override // com.byazt.nc.x
    public void win(Double d) {
        if (this.rl) {
            return;
        }
        h.c(this.tt, d);
        this.rl = true;
    }

    private void c() {
        c.c(this.t, new com.byazt.tn.c(null) { // from class: com.byazt.yi.ve.2
            @Override // com.byazt.tn.c
            public void c(Bundle bundle) {
                com.byazt.rgb.tt.c(ve.this.getLifecycleId(), false, bundle != null ? bundle.getBoolean("has_show_event") : false);
                if (ve.this.x != null) {
                    ve.this.x.c(bundle);
                }
            }

            @Override // com.byazt.tn.c
            public void n() {
                if (ve.this.x != null) {
                    ve.this.x.n();
                }
            }

            @Override // com.byazt.tn.c
            public void tt() {
                com.byazt.rgb.tt.ve(ve.this.getLifecycleId(), 1);
                if (ve.this.x != null) {
                    ve.this.x.tt();
                }
            }

            @Override // com.byazt.tn.c
            public void uj() {
                if (ve.this.x != null) {
                    ve.this.x.uj();
                }
            }

            @Override // com.byazt.tn.c
            public void ve() {
                if (ve.this.x != null) {
                    ve.this.x.ve();
                }
            }

            @Override // com.byazt.tn.c
            public void c() {
                com.byazt.rgb.tt.ve(ve.this.getLifecycleId());
                if (ve.this.x != null) {
                    ve.this.x.c();
                }
            }

            @Override // com.byazt.tn.c
            public void c(boolean z, int i, String str, int i2, String str2) {
                if (ve.this.x != null) {
                    ve.this.x.c(z, i, str, i2, str2);
                }
            }

            @Override // com.byazt.tn.c
            public void c(boolean z, int i, Bundle bundle) {
                if (ve.this.x != null) {
                    ve.this.x.c(z, i, bundle);
                }
            }
        });
        if (this.i != null) {
            c.c(l.c(this.t), this.i);
        }
        if (this.da != null) {
            setCustomPlayAgain(true);
            c.c(l.tt(this.t), this.da);
        }
    }

    private void c(Context context, Intent intent) {
        com.byazt.nr.tt.c(context, intent, new com.byazt.nr.tt.c() { // from class: com.byazt.yi.ve.3
            @Override // com.byazt.nr.tt.c
            public void c() {
            }

            @Override // com.byazt.nr.tt.c
            public void c(Throwable th) {
                m.ve("TTRewardVideoAdImpl", "show reward video error: ", th);
            }
        });
        if (this.ve == null) {
            return;
        }
        com.byazt.lvl.c cVarC = com.byazt.lvl.c.c();
        com.byazt.dj.tt ttVar = this.ve;
        cVarC.c(ttVar, ttVar.uj());
        if (l.c(this.tt)) {
            com.byazt.lvl.c.c().tt(this.ve, l.uj(this.tt));
        }
        if (!this.zm && !this.yp) {
            com.byazt.cf.ve.c(7, this.tt);
        }
        preloadNextVideo();
    }

    @Override // com.byazt.nc.z
    public void showRewardVideoAd(Activity activity, Object obj, String str) {
        if (obj == null) {
            m.uj("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String strC = n.c(obj);
        if ("customize_scenes".equalsIgnoreCase(strC)) {
            this.n = str;
        } else {
            this.n = strC;
        }
        showRewardVideoAd(activity);
    }
}
