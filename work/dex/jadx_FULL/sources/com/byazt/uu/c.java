package com.byazt.uu;

import android.text.TextUtils;
import com.alipay.sdk.m.n.b;
import com.byazt.yf.sl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1497, 20})
public class c extends tt {
    public com.byazt.nbs.c c;
    public sl tt;

    public c(com.byazt.nbs.c cVar) {
        this.c = cVar;
    }

    private String a() {
        com.byazt.nbs.c cVar = this.c;
        if (cVar != null) {
            return cVar.ve();
        }
        sl slVar = this.tt;
        return slVar != null ? slVar.uj() : "";
    }

    private String n() {
        com.byazt.nbs.c cVar = this.c;
        if (cVar != null) {
            return cVar.tt();
        }
        sl slVar = this.tt;
        return slVar != null ? slVar.ve() : "";
    }

    @Override // com.byazt.uu.tt
    public Map<String, Object> c() {
        HashMap map = new HashMap();
        map.put("app_id", n());
        map.put(b.h, a());
        map.put("app_name", com.byazt.bp.c.t().my());
        if ("baidu".equals(tt())) {
            map.put("baidu_https", Boolean.valueOf(com.byazt.bp.c.t().p()));
            if (!TextUtils.isEmpty(com.byazt.bp.c.t().a())) {
                map.put("baidu_wx_app_id", com.byazt.bp.c.t().a());
            }
            Map<String, Object> mapGr = com.byazt.bp.c.t().gr();
            if (mapGr != null) {
                map.put(MediationConstant.GM_EXTRA_KEY_CLOSE_SHAKE, mapGr.get(MediationConstant.GM_EXTRA_KEY_CLOSE_SHAKE));
            }
        }
        return map;
    }

    @Override // com.byazt.uu.tt
    public String tt() {
        com.byazt.nbs.c cVar = this.c;
        if (cVar != null) {
            return cVar.c();
        }
        sl slVar = this.tt;
        return slVar != null ? slVar.n() : "";
    }

    @Override // com.byazt.uu.tt
    public String ve() {
        return "";
    }

    public c(sl slVar) {
        this.tt = slVar;
    }
}
