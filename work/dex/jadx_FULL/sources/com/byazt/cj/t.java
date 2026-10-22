package com.byazt.cj;

import android.content.Context;
import com.byazt.ete.ic;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 66})
public class t implements com.byazt.kkb.ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = "landing_page_source")
    public int f28360a;

    @com.byazt.ls.c(c = "material_meta")
    public ic c;

    @com.byazt.ls.c(c = "wc_miniapp_info")
    public JSONObject n;

    @com.byazt.ls.c(c = "context")
    public Context tt;

    @com.byazt.ls.c(c = "event_tag")
    public String uj;

    @com.byazt.ls.c(c = "convert_from_landing_page")
    public boolean ve;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        if (!c()) {
            cVar.c(map2, (com.byazt.qb.c) null);
            return true;
        }
        if (new com.byazt.bb.x(this.c, this.tt, this.ve, this.uj, map2, cVar, this.f28360a, false).c(new HashMap())) {
            cVar.c(map2);
        } else {
            cVar.c(map2, (com.byazt.qb.c) null);
        }
        return true;
    }

    private boolean c() {
        return (this.c == null || this.tt == null || this.n == null) ? false : true;
    }
}
