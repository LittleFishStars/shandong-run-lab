package com.byazt.cj;

import android.content.Context;
import com.byazt.ete.ic;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 71})
public class x implements com.byazt.kkb.ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = "event_tag")
    public String f28365a;

    @com.byazt.ls.c(c = "convert_from_landing_page")
    public boolean c;

    @com.byazt.ls.c(c = "is_from_new_click_event")
    public boolean da;

    @com.byazt.ls.c(c = "is_show_download_dialog")
    public boolean i = true;

    @com.byazt.ls.c(c = "app_manage_model")
    public com.byazt.ete.uj n;

    @com.byazt.ls.c(c = "dynamic_download_dialog_type")
    public int sl;

    @com.byazt.ls.c(c = "download_url")
    public String sp;

    @com.byazt.ls.c(c = "is_direct_download")
    public boolean t;

    @com.byazt.ls.c(c = "context")
    public Context tt;

    @com.byazt.ls.c(c = "download_dialog_listener")
    public com.byazt.av.c u;

    @com.byazt.ls.c(c = "is_app_market_convert")
    public boolean uj;

    @com.byazt.ls.c(c = "material_meta")
    public ic ve;

    @com.byazt.ls.c(c = "start_download_listener")
    public com.byazt.av.tt x;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        com.byazt.yzg.ve veVar = new com.byazt.yzg.ve(this.tt, this.ve);
        veVar.ve(this.t);
        veVar.c(this.i);
        veVar.c(this.sl);
        veVar.tt(this.da);
        veVar.c(this.u);
        veVar.c(c());
        if (!veVar.uj(false)) {
            cVar.c(map2, (com.byazt.qb.c) null);
            return true;
        }
        veVar.c(this.n, this.f28365a, this.sp, this.x);
        cVar.c(map2);
        return true;
    }

    private com.byazt.yzg.c c() {
        if (this.uj) {
            return new com.byazt.yzg.n();
        }
        if (this.c) {
            return new com.byazt.yzg.uj();
        }
        return new com.byazt.yzg.tt();
    }
}
