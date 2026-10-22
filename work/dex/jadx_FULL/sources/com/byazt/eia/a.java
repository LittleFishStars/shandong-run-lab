package com.byazt.eia;

import android.content.Context;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.byazt.ete.nu;
import com.byazt.ete.pf;
import com.byazt.ete.qy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 1048, 34})
public class a implements c, sl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = "deep_link")
    public JSONObject f28469a;

    @com.byazt.ls.c(c = "url", tt = "DSL")
    public String c;

    @com.byazt.ls.c(c = "download_adapter")
    public com.byazt.pop.ve da;
    public pf gr;

    @com.byazt.ls.c(c = "is_click_button")
    public volatile boolean gt;
    public com.byazt.ete.n gu;

    @com.byazt.ls.c(c = "convert_from_downloader")
    public boolean i;

    @com.byazt.ls.c(c = "reward_live")
    public JSONObject m;

    @com.byazt.ls.c(c = "is_web_meta")
    public boolean my;

    @com.byazt.ls.c(c = "event_tag")
    public String n;

    @com.byazt.ls.c(c = "req_id")
    public String nu;
    public nu qy;

    @com.byazt.ls.c(c = "live_interaction_type")
    public int rh;
    public qy rl;

    @com.byazt.ls.c(c = "convert_tag")
    public String sl;

    @com.byazt.ls.c(c = NativeCallContext.DOMAIN_APP)
    public JSONObject sp;

    @com.byazt.ls.c(c = "sub_convert_link")
    public JSONObject t;

    @com.byazt.ls.c(c = "type", tt = "DSL")
    public int tt;

    @com.byazt.ls.c(c = "if_double_deeplink")
    public int u;

    @com.byazt.ls.c(c = "context")
    public Context uj;

    @com.byazt.ls.c(c = "download_conf.download_type")
    public int ve = -1;

    @com.byazt.ls.c(c = "convert_from_landing_page")
    public boolean x;

    @com.byazt.ls.c(c = MediationConstant.EXTRA_ADID)
    public String yp;

    @com.byazt.ls.c(c = "reward_live_deep_link_params")
    public JSONObject z;

    @Override // com.byazt.eia.sl
    public int a() {
        return this.ve;
    }

    @Override // com.byazt.eia.c
    public Map<String, String> c() {
        return new HashMap();
    }

    public boolean da() {
        return this.x;
    }

    public Context getContext() {
        return this.uj;
    }

    @Override // com.byazt.eia.sl
    public pf gt() {
        if (this.gr == null && tt() != null) {
            this.gr = new pf(tt());
        }
        return this.gr;
    }

    public String i() {
        return this.n;
    }

    public String m() {
        return this.sl;
    }

    @Override // com.byazt.eia.sl
    public int n() {
        return this.rh;
    }

    @Override // com.byazt.eia.sl
    public boolean nu() {
        return this.u == 1;
    }

    @Override // com.byazt.eia.sl
    public String qy() {
        return this.nu;
    }

    public JSONObject rh() {
        return this.m;
    }

    @Override // com.byazt.eia.sl
    public boolean s_() {
        return this.my;
    }

    public boolean sl() {
        return this.i;
    }

    public boolean sp() {
        return this.gt;
    }

    public com.byazt.pop.ve t() {
        return this.da;
    }

    public JSONObject tt() {
        return this.z;
    }

    @Override // com.byazt.eia.sl
    public qy u() {
        if (this.rl == null) {
            this.rl = new qy(this.t, false);
        }
        return this.rl;
    }

    @Override // com.byazt.eia.sl
    public String uj() {
        return this.yp;
    }

    public String ve() {
        return this.c;
    }

    public int x() {
        return this.tt;
    }

    @Override // com.byazt.eia.sl
    public nu yp() {
        if (this.qy == null) {
            this.qy = new nu(this.f28469a);
        }
        return this.qy;
    }

    @Override // com.byazt.eia.sl
    public com.byazt.ete.n z() {
        if (this.gu == null) {
            this.gu = com.byazt.omf.c.tt(this.sp);
        }
        return this.gu;
    }

    @Override // com.byazt.eia.sl
    public boolean z_() {
        return rh() != null && rh().optBoolean("isValid", false);
    }
}
