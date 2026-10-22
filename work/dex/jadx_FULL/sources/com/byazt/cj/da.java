package com.byazt.cj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 72})
public class da implements com.byazt.kkb.ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = "convert_from_landing_page")
    public boolean f28355a;

    @com.byazt.ls.c(c = "material_meta")
    public ic c;

    @com.byazt.ls.c(c = "event_tag")
    public String da;

    @com.byazt.ls.c(c = "is_from_video_layout")
    public boolean i;

    @com.byazt.ls.c(c = "is_open_web_page")
    public boolean n;

    @com.byazt.ls.c(c = "pip_controller")
    public com.byazt.zd.tt sp;

    @com.byazt.ls.c(c = "context")
    public Context tt;

    @com.byazt.ls.c(c = "interaction_type")
    public int uj;

    @com.byazt.ls.c(c = "url")
    public String ve;

    @com.byazt.ls.c(c = "open_video_detail_page_direct")
    public boolean x;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, final Map<String, Object> map2, final com.byazt.cq.c cVar) {
        if (this.n) {
            return true;
        }
        if (this.f28355a) {
            cVar.c(map2, (com.byazt.qb.c) null);
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(LoginConstants.EXT, this.c.w_());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.c.n()));
            jSONObject.putOpt("req_id", this.c.qy());
            jSONObject.putOpt("uchain", Boolean.TRUE);
        } catch (JSONException unused) {
        }
        com.byazt.ukr.yp.c().c("landing_page", "native", 0, jSONObject);
        if (this.uj == 2) {
            boolean zC = c();
            if (zC) {
                cVar.c(map2);
            } else {
                cVar.c(map2, (com.byazt.qb.c) null);
            }
            return zC;
        }
        com.byazt.zd.tt ttVar = this.sp;
        if (ttVar != null && new com.byazt.szt.tt(ttVar).c(new HashMap())) {
            cVar.c(map2);
            return true;
        }
        Intent intent = new Intent(this.tt, com.byazt.ppf.tt.c(this.x, this.c, this.i, map2));
        if (!(this.tt instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("is_outer_click", true);
        intent.putExtra("event_tag", this.da);
        ic icVar = this.c;
        if (icVar != null) {
            intent.putExtra("get_phone_num_status", icVar.sp());
        }
        if (map == null) {
            com.byazt.nr.m.uj("UChain_LP", "param == null");
            map = new HashMap<>();
        }
        map.putAll(map2);
        map.remove("context");
        map.remove("activity_type");
        Object objRemove = map.remove("landing_page_source");
        nb.c(map, this.c);
        int i = -1;
        if (!(objRemove == null || TextUtils.isEmpty(objRemove.toString()))) {
            try {
                i = Integer.parseInt(objRemove.toString());
            } catch (Exception unused2) {
            }
        }
        intent.putExtra("landing_page_source", i);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && !"log_extra".equals(key)) {
                intent.putExtra(key, value.toString());
            }
        }
        intent.putExtra("web_dl_factors", com.byazt.ppf.ve.tt(map2));
        com.byazt.nr.tt.c(this.tt, intent, new com.byazt.nr.tt.c() { // from class: com.byazt.cj.da.1
            @Override // com.byazt.nr.tt.c
            public void c() {
                cVar.c(map2);
                map2.put("is_open_web_page", Boolean.TRUE);
            }

            @Override // com.byazt.nr.tt.c
            public void c(Throwable th) {
                cVar.c(map2, (com.byazt.qb.c) null);
            }
        });
        return true;
    }

    private boolean c() {
        if (!com.byazt.nr.rh.c(this.ve)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(this.ve));
            if (!(this.tt instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.byazt.nr.tt.c(this.tt, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
