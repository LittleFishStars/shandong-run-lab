package com.byazt.eia;

import android.content.Context;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.ete.hq;
import com.zj.adlib.ha0;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 1048, 15})
public class uj implements c, da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = LoginConstants.EXT)
    public String f28472a;

    @com.byazt.ls.c(c = "path", tt = "DSL")
    public String c;

    @com.byazt.ls.c(c = "landing_page_source")
    public int da;

    @com.byazt.ls.c(c = "event_tag")
    public String i;

    @com.byazt.ls.c(c = ha0.c)
    public String n;

    @com.byazt.ls.c(c = "context")
    public Context sp;

    @com.byazt.ls.c(c = "name", tt = "DSL")
    public String tt;

    @com.byazt.ls.c(c = "wc_miniapp_info")
    public JSONObject uj;

    @com.byazt.ls.c(c = "type", tt = "DSL")
    public int ve;

    @com.byazt.ls.c(c = "convert_from_landing_page")
    public boolean x;

    @Override // com.byazt.eia.da
    public hq A_() {
        return hq.c(this.uj);
    }

    @Override // com.byazt.eia.c
    public Map<String, String> c() {
        return new HashMap();
    }

    public int da() {
        return this.ve;
    }

    public Context getContext() {
        return this.sp;
    }

    public String i() {
        return this.tt;
    }

    public String sp() {
        return this.c;
    }

    public boolean tt() {
        return this.x;
    }

    public int uj() {
        return this.da;
    }

    public String ve() {
        return this.i;
    }

    @Override // com.byazt.eia.da
    public String w_() {
        return this.f28472a;
    }

    @Override // com.byazt.eia.da
    public String x() {
        return this.n;
    }
}
