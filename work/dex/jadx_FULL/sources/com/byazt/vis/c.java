package com.byazt.vis;

import android.content.Context;
import android.view.View;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.dna.u;
import com.byazt.ete.da;
import com.byazt.ete.h;
import com.byazt.ete.i;
import com.byazt.ete.ic;
import com.byazt.omf.x;
import com.byazt.ut.uj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1810, 20})
public class c extends tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f29131a;
    public i n;
    public String sl;
    public String sp;
    public com.byazt.zd.tt t;
    public boolean x;
    public int i = -1;
    public int da = -1;
    public boolean u = false;

    public c() {
    }

    private void a() {
        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
        long j = veVarC.get("click_to_live_duration", 0L);
        if (j == 0) {
            Map<String, Object> map = this.f29131a;
            if (map != null) {
                map.remove("click_livead_duration");
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        HashMap map2 = new HashMap();
        map2.put("click_livead_duration", Long.valueOf(jCurrentTimeMillis));
        c(map2);
        veVarC.get("click_to_live_duration", 0L);
    }

    public void c(boolean z) {
        this.u = z;
    }

    public Map<String, Object> n() {
        return this.f29131a;
    }

    public void tt(boolean z) {
        this.x = z;
    }

    public i uj() {
        int i = this.i;
        if (i != -1) {
            this.i = -1;
        } else {
            i = -1;
        }
        u uVar = (u) uj.getService("device_info_new");
        float fA = pf.a(this.tt);
        int displayDpi = uVar.getDisplayDpi();
        float fSp = pf.sp(this.tt);
        View viewDa = this.ve.da();
        View viewI = this.ve.i();
        return new i.c().a(this.ve.nu()).n(this.ve.rh()).uj(this.ve.my()).ve(this.ve.gt()).tt(this.ve.z()).c(this.ve.m()).tt(pf.c(viewDa)).c(pf.c(viewI)).ve(pf.ve(viewDa)).uj(pf.ve(viewI)).uj(this.ve.n()).n(this.ve.a()).a(this.ve.sp()).c(this.ve.u()).ve(x.m().tt() ? 1 : 2).c(this.sl).c(fA).tt(displayDpi).tt(fSp).sp(i).x(this.da).i(this.ve.qy()).n(this.ve.rl()).c(this.ve.uj()).tt(this.ve.tt()).c(this.ve.ve()).c(com.byazt.wz.x.tt(this.c)).c();
    }

    public String ve() {
        return this.sl;
    }

    public void c(String str) {
        this.sp = str;
    }

    public void tt() {
        this.da = 1;
    }

    public void c() {
        this.i = 1;
    }

    public void tt(String str) {
        this.sl = str;
    }

    public void c(i iVar) {
        this.n = iVar;
    }

    public c(ic icVar, Context context) {
        this.c = icVar;
        this.tt = context;
        this.f29131a = new HashMap();
    }

    @Override // com.byazt.vis.tt, com.byazt.zo.c
    public int c(Map<String, Object> map, com.byazt.zo.ve veVar) {
        if (this.u) {
            return 0;
        }
        com.byazt.zd.tt ttVar = this.t;
        if (ttVar != null && ttVar.sl() == 1) {
            return 0;
        }
        if (this.ve == null) {
            this.ve = new da();
        }
        if ("splash_ad".equals(this.sp) || "cache_splash_ad".equals(this.sp) || "splash_ad_landingpage".equals(this.sp)) {
            this.i = this.i == 1 ? 1 : 0;
        }
        Object obj = map.get("convert_res");
        boolean zBooleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
        if (this.n == null) {
            this.n = uj();
        }
        Object obj2 = map.get("is_reward_live");
        if (obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false) {
            a();
        }
        if (map.containsKey("reward_browse_banner_from")) {
            this.f29131a.put("refer", MediationConstant.RIT_TYPE_BANNER);
        }
        if (h.c(this.c) && !com.byazt.dl.uj.c(String.valueOf(nb.t(this.c))) && this.c.zo() != null) {
            this.f29131a.put("refresh_num", Integer.valueOf(this.c.zo().ve()));
        }
        Object obj3 = map.get("click_saas_action");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.f29131a.put("click_saas_action", obj3);
        }
        Object obj4 = map.get("click_saas_area");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.f29131a.put("click_saas_area", obj4);
        }
        c(true);
        com.byazt.ddx.uj.c("click", this.c, this.n, this.sp, zBooleanValue, this.f29131a, this.ve.x() ? 1 : 2, this.x, this.ve.c());
        return 0;
    }

    public void c(Map<String, Object> map) {
        Map<String, Object> map2 = this.f29131a;
        if (map2 == null) {
            this.f29131a = map;
        } else {
            map2.putAll(map);
        }
    }

    public void c(com.byazt.zd.tt ttVar) {
        this.t = ttVar;
    }
}
