package com.byazt.cj;

import android.content.Context;
import com.byazt.ete.ic;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 67})
public class u implements com.byazt.kkb.ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = "convert_from_landing_page")
    public boolean f28362a;

    @com.byazt.ls.c(c = "material_meta")
    public ic c;

    @com.byazt.ls.c(c = "pip_controller")
    public com.byazt.zd.tt da;

    @com.byazt.ls.c(c = "convert_tag")
    public String i;

    @com.byazt.ls.c(c = "app_info")
    public JSONObject n;

    @com.byazt.ls.c(c = "is_click_button")
    public volatile boolean sl;

    @com.byazt.ls.c(c = "convert_from_downloader")
    public boolean sp;

    @com.byazt.ls.c(c = "context")
    public Context tt;

    @com.byazt.ls.c(c = "deep_link")
    public JSONObject uj;

    @com.byazt.ls.c(c = "event_tag")
    public String ve;

    @com.byazt.ls.c(c = "download_adapter")
    public com.byazt.pop.ve x;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        com.byazt.bb.sp spVar = new com.byazt.bb.sp(com.byazt.omf.c.tt(this.n), this.tt, this.c, map2);
        spVar.c(this.ve);
        com.byazt.bb.ve veVar = new com.byazt.bb.ve(spVar, this.c, this.ve, new com.byazt.ete.nu(this.uj), this.tt, map2, false);
        veVar.tt(this.sp);
        veVar.c(this.f28362a);
        veVar.c(this.x);
        veVar.c(this.i);
        veVar.c(this.da);
        veVar.ve(this.sl);
        if (veVar.c(map2)) {
            cVar.c(map2);
            return true;
        }
        cVar.c(map2, (com.byazt.qb.c) null);
        return true;
    }
}
