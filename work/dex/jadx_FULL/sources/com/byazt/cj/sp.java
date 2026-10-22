package com.byazt.cj;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.byazt.ete.gt;
import com.byazt.ete.ic;
import com.byazt.su.DownloadStatusChangeListener;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 91})
public class sp implements com.byazt.kkb.ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = "download_popup_manager")
    public com.byazt.yzg.ve f28359a;

    @com.byazt.ls.c(c = "material_meta")
    public ic c;

    @com.byazt.ls.c(c = "download_url")
    public String da;

    @com.byazt.ls.c(c = "is_click_button")
    public volatile boolean i;

    @com.byazt.ls.c(c = "download_status_listener")
    public DownloadStatusChangeListener n;

    @com.byazt.ls.c(c = "download_conf")
    public JSONObject sl;

    @com.byazt.ls.c(c = NativeCallContext.DOMAIN_APP)
    public JSONObject t;

    @com.byazt.ls.c(c = "context")
    public Context tt;

    @com.byazt.ls.c(c = "dialog_to_landing_page_convert")
    public com.byazt.hl.c u;

    @com.byazt.ls.c(c = "event_tag")
    public String uj;

    @com.byazt.ls.c(c = "is_open_market_intercept_for_dsp")
    public volatile boolean x;

    @com.byazt.ls.c(c = "pip_controller")
    public com.byazt.zd.tt yp;

    @com.byazt.ls.c(c = "enable_update_download_model")
    public boolean z;

    @com.byazt.ls.c(c = "convert_from_landing_page")
    public volatile boolean ve = false;

    @com.byazt.ls.c(c = "need_check_compliance")
    public int sp = 0;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        if (!c()) {
            cVar.c(map2, (com.byazt.qb.c) null);
            return true;
        }
        int iUj = com.byazt.bb.c.uj(map2);
        com.byazt.bb.uj ujVar = new com.byazt.bb.uj(this.c, this.tt, this.uj, this.f28359a, this.da, this.z, map2, false);
        ujVar.tt(this.i);
        ujVar.c(this.x, iUj);
        ujVar.c(this.n);
        ujVar.c(this.ve);
        ujVar.c(this.sp);
        ujVar.c(this.u);
        ujVar.c(new gt(this.sl));
        if (new com.byazt.szt.tt(ujVar, this.yp).c(map2)) {
            cVar.c(map2);
        } else {
            cVar.c(map2, (com.byazt.qb.c) null);
        }
        return true;
    }

    private boolean c() {
        if (this.c == null || this.tt == null) {
            return false;
        }
        if (TextUtils.isEmpty(this.da)) {
            com.byazt.ete.n nVarTt = com.byazt.omf.c.tt(this.t);
            if (nVarTt != null) {
                this.da = nVarTt.tt();
            }
            if (TextUtils.isEmpty(this.da)) {
                return false;
            }
        }
        return (TextUtils.isEmpty(this.uj) || this.f28359a == null) ? false : true;
    }
}
