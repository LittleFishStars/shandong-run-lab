package com.byazt.sc;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.c0.d;
import com.byazt.eu.ve;
import com.byazt.ly.uj;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2144, 20})
public class c {
    public final Map<String, com.byazt.id.c> c = new ConcurrentHashMap();

    public Map<String, com.byazt.id.c> c() {
        return this.c;
    }

    public Map<String, Object> tt(Context context, Map<String, Object> map, String str) {
        ve.c(context);
        com.byazt.id.c cVarC = c(str);
        if (cVarC != null) {
            HashMap map2 = new HashMap();
            map2.put("buyerId", cVarC.getBiddingToken(context, map));
            map2.put(d.E, cVarC.getSdkInfo(context, map));
            return map2;
        }
        uj ujVarTt = tt(str);
        if (ujVarTt == null) {
            return null;
        }
        return ujVarTt.getBiddingTokenMap(context, map);
    }

    public void c(String str, com.byazt.id.c cVar) {
        this.c.put(str, cVar);
    }

    public com.byazt.id.c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.c.get(str);
    }

    public String c(Context context, Map<String, Object> map, String str) {
        ve.c(context);
        com.byazt.id.c cVarC = c(str);
        if (cVarC != null) {
            return cVarC.getBiddingToken(null, null);
        }
        uj ujVarTt = tt(str);
        if (ujVarTt == null) {
            return null;
        }
        return ujVarTt.getBiddingToken(context, map);
    }

    public uj tt(String str) {
        return com.byazt.px.tt.c().c(str);
    }
}
