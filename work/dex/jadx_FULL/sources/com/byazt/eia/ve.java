package com.byazt.eia;

import android.content.Context;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.ha0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 1048, 54})
public class ve implements c, x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = "pip_controller")
    public com.byazt.zd.tt f28473a;

    @com.byazt.ls.c(c = "url", tt = "DSL")
    public String c;

    @com.byazt.ls.c(c = "open_video_detail_page_direct")
    public boolean da;

    @com.byazt.ls.c(c = "icon.url")
    public String gt;

    @com.byazt.ls.c(c = "landing_page_source")
    public int i = -1;

    @com.byazt.ls.c(c = "live_interaction_type")
    public int m;

    @com.byazt.ls.c(c = MediationConstant.EXTRA_ADID)
    public String my;

    @com.byazt.ls.c(c = "convert_from_landing_page")
    public boolean n;

    @com.byazt.ls.c(c = "req_id")
    public String nu;

    @com.byazt.ls.c(c = "gecko_id")
    public String rh;

    @com.byazt.ls.c(c = "union_session_key")
    public String rl;

    @com.byazt.ls.c(c = "is_from_video_layout")
    public boolean sl;

    @com.byazt.ls.c(c = "event_tag")
    public String sp;

    @com.byazt.ls.c(c = ha0.c)
    public String t;

    @com.byazt.ls.c(c = "title", tt = "DSL")
    public String tt;

    @com.byazt.ls.c(c = "interaction_type")
    public int u;

    @com.byazt.ls.c(c = "is_open_web_page")
    public boolean uj;

    @com.byazt.ls.c(c = "context")
    public Context ve;

    @com.byazt.ls.c(c = "landing_page_url")
    public String x;

    @com.byazt.ls.c(c = "get_phone_num_status")
    public int yp;

    @com.byazt.ls.c(c = LoginConstants.EXT)
    public String z;

    @Override // com.byazt.eia.c
    public Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("title", "title");
        map.put("button_text", "button_text");
        map.put("block_auto_open", "block_auto_open");
        map.put("disable_top_bar", "disable_top_bar");
        map.put("disable_safe_area", "disable_safe_area");
        map.put("disable_rtn_button", "disable_rtn_button");
        return map;
    }

    public Context getContext() {
        return this.ve;
    }

    @Override // com.byazt.eia.x
    public int i() {
        return this.u;
    }

    public boolean m() {
        return this.da;
    }

    @Override // com.byazt.eia.x
    public int n() {
        return this.m;
    }

    public boolean nu() {
        return this.sl;
    }

    @Override // com.byazt.eia.x
    public String qy() {
        return this.nu;
    }

    @Override // com.byazt.eia.x
    public String rl() {
        return this.rl;
    }

    public boolean sl() {
        return this.uj;
    }

    @Override // com.byazt.eia.x
    public int sp() {
        return this.yp;
    }

    public boolean t() {
        return this.n;
    }

    @Override // com.byazt.eia.x
    public String tt() {
        return this.gt;
    }

    public com.byazt.zd.tt u() {
        return this.f28473a;
    }

    @Override // com.byazt.eia.x
    public String uj() {
        return this.my;
    }

    @Override // com.byazt.eia.x
    public String v_() {
        return this.tt;
    }

    @Override // com.byazt.eia.x
    public String ve() {
        return this.rh;
    }

    @Override // com.byazt.eia.x
    public String w_() {
        return this.z;
    }

    @Override // com.byazt.eia.x
    public String x() {
        return this.t;
    }

    public String yp() {
        return this.sp;
    }

    public String z() {
        return !TextUtils.isEmpty(this.x) ? this.x : this.c;
    }
}
