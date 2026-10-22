package com.byazt.bg;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1535, 54})
public class ve {
    public static void c(com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar, Map<String, Object> map) {
        if (com.byazt.bp.tt.tt().l()) {
            String strGt = ttVar != null ? ttVar.gt() : null;
            tt ttVarPu = com.byazt.bp.tt.tt().pu();
            if (ttVarPu != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("lt_days", Integer.valueOf(ttVarPu.c()));
                    jSONObject.putOpt("rule_id", ttVarPu.ve(strGt));
                } catch (Exception e) {
                    com.byazt.eu.tt.uj("AdLoadEventManager", "put 元素 异常：" + e.getMessage());
                }
                try {
                    jSONObject.putOpt("score", Float.valueOf(com.byazt.bp.c.t().c(strGt)));
                } catch (Exception e2) {
                    com.byazt.eu.tt.uj("AdLoadEventManager", "put 元素异常：" + e2.getMessage());
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("dis_c", Integer.valueOf(c.tt(strGt)));
                    jSONObject2.putOpt("ins_d", Integer.valueOf(c.n()));
                    jSONObject2.putOpt("act_d", Integer.valueOf(c.tt()));
                    jSONObject2.putOpt("act_times", Integer.valueOf(c.uj()));
                    jSONObject.putOpt("active_target", jSONObject2);
                } catch (Exception e3) {
                    com.byazt.eu.tt.uj("AdLoadEventManager", "put 元素异常：" + e3.getMessage());
                }
                if (ttVar != null && ttVar.cu() != null) {
                    Map<String, Object> mapCu = ttVar.cu();
                    if (mapCu.containsKey(MediationConstant.KEY_USE_POLICY)) {
                        try {
                            jSONObject.putOpt("user_enter", mapCu.get(MediationConstant.KEY_USE_POLICY));
                        } catch (Exception e4) {
                            com.byazt.eu.tt.uj("AdLoadEventManager", "put 元素异常：" + e4.getMessage());
                        }
                    }
                }
                map.put("dynamic_policy", jSONObject);
            }
        }
    }
}
