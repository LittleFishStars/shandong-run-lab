package com.byazt.qx;

import androidx.annotation.Nullable;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 126})
public class bx extends com.byazt.pct.n<JSONObject, JSONObject> {
    public com.byazt.ete.ic c;

    public bx(com.byazt.ete.ic icVar) {
        this.c = icVar;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.ete.ic icVar) {
        nuVar.c("sendEventCode", (com.byazt.pct.n<?, ?>) new bx(icVar));
    }

    @Override // com.byazt.pct.n
    @Nullable
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        com.byazt.ocd.tt ttVar;
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.ete.ic icVar = this.c;
        if (icVar != null && (ttVar = (com.byazt.ocd.tt) com.byazt.omf.rl.c(icVar.rl(), com.byazt.ocd.tt.class)) != null) {
            HashMap map = new HashMap();
            int iOptInt = jSONObject.optInt("event_code", -1);
            if (iOptInt >= 200) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(AliyunLogCommon.LogLevel.INFO);
                if (jSONObjectOptJSONObject != null) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObjectOptJSONObject.opt(next));
                    }
                }
                ttVar.c(iOptInt, map);
            }
        }
        return jSONObject2;
    }
}
