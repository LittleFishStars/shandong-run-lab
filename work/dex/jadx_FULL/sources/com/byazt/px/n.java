package com.byazt.px;

import android.util.SparseArray;
import com.byazt.omf.p;
import com.byazt.yf.da;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 690, 46})
public class n {

    @com.byazt.zqa.c(c = {0, 1, 690, 151})
    public static class c extends sp {
        public c(com.byazt.je.tt ttVar) {
            super(ttVar);
        }

        @Override // com.byazt.px.sp
        public boolean isLimitPersonalAds() {
            int iR = com.byazt.bp.tt.tt().r();
            if (iR > 0) {
                return true;
            }
            if (iR < 0) {
                return false;
            }
            return super.isLimitPersonalAds();
        }

        @Override // com.byazt.px.sp
        public boolean isProgrammaticRecommend() {
            int iS = com.byazt.bp.tt.tt().s();
            if (iS > 0) {
                return false;
            }
            if (iS < 0) {
                return true;
            }
            return super.isProgrammaticRecommend();
        }
    }

    public static void c(com.byazt.yxi.uj ujVar) {
        com.byazt.dj.c cVar = new com.byazt.dj.c(com.byazt.bp.c.t().cu().sparseArray());
        ujVar.c(8475, com.byazt.lq.uj.c(c(cVar.sl())));
        ujVar.c(8457, com.byazt.lq.uj.c(c(cVar.z())));
        ujVar.c(1, Boolean.valueOf(com.byazt.ck.tt.c().sp()));
    }

    public static JSONObject tt() {
        try {
            JSONObject jSONObject = new JSONObject();
            Map<String, com.byazt.ly.uj> mapTt = tt.c().tt();
            if (mapTt != null && mapTt.size() > 0) {
                for (Map.Entry<String, com.byazt.ly.uj> entry : mapTt.entrySet()) {
                    String key = entry.getKey();
                    com.byazt.ly.uj value = entry.getValue();
                    long jInitDuration = value.initDuration();
                    int iInitStatus = value.initStatus();
                    if (jInitDuration != 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("status", iInitStatus);
                        jSONObject2.put("duration", jInitDuration);
                        jSONObject.put(key, jSONObject2);
                        value.clearInitStatus();
                    }
                }
            }
            if (com.byazt.tjo.a.c > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", 1);
                jSONObject3.put("duration", com.byazt.tjo.a.c);
                jSONObject3.put("plugin", p.tt() ? 1 : 0);
                jSONObject3.put("layer_real_cost_time", com.byazt.tjo.a.ve);
                jSONObject.put(MediationConstant.ADN_PANGLE, jSONObject3);
                com.byazt.tjo.a.c = 0L;
            }
            if (com.byazt.tjo.a.tt > 0) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("status", 1);
                jSONObject4.put("duration", com.byazt.tjo.a.tt);
                jSONObject4.put("plugin", p.tt() ? 1 : 0);
                jSONObject4.put("layer_real_cost_time", com.byazt.tjo.a.uj);
                jSONObject.put("fusion", jSONObject4);
                com.byazt.tjo.a.tt = 0L;
            }
            if (com.byazt.px.c.uj() != null && com.byazt.px.c.uj().c() != null && com.byazt.px.c.uj().c().size() > 0) {
                for (Map.Entry<String, com.byazt.id.c> entry2 : com.byazt.px.c.uj().c().entrySet()) {
                    String key2 = entry2.getKey();
                    com.byazt.id.c value2 = entry2.getValue();
                    long jInitDuration2 = value2.initDuration();
                    int iInitStatus2 = value2.initStatus();
                    if (jInitDuration2 != 0) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("status", iInitStatus2);
                        jSONObject5.put("duration", jInitDuration2);
                        jSONObject.put(key2, jSONObject5);
                        value2.clearInitStatus();
                    }
                }
            }
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void c(com.byazt.yxi.uj ujVar, com.byazt.yxi.uj ujVar2) {
        ujVar.c(8424, com.byazt.lq.uj.c(ujVar2.tt()));
    }

    public static SparseArray<Object> c(com.byazt.je.c cVar) {
        if (cVar == null) {
            return null;
        }
        com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
        ujVarC.c(8458, Boolean.valueOf(cVar.n()));
        ujVarC.c(8459, cVar.sl());
        ujVarC.c(8460, cVar.c());
        ujVarC.c(8461, Boolean.valueOf(cVar.tt()));
        ujVarC.c(8310, new x(cVar.ve()));
        ujVarC.c(8462, cVar.uj());
        ujVarC.c(8463, cVar.a());
        ujVarC.c(8464, cVar.sp());
        ujVarC.c(8465, Boolean.valueOf(cVar.x()));
        ujVarC.c(8466, Boolean.valueOf(cVar.i()));
        ujVarC.c(8467, Boolean.valueOf(cVar.da()));
        return ujVarC.tt();
    }

    public static SparseArray<Object> c(com.byazt.dj.uj ujVar) {
        com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
        if (ujVar != null) {
            ujVarC.c(8311, new c(ujVar.getMediationPrivacyConfig()));
            ujVarC.c(8023, Boolean.valueOf(ujVar.isCanUsePhoneState()));
            ujVarC.c(8024, Boolean.valueOf(ujVar.isCanUseLocation()));
            ujVarC.c(8025, Boolean.valueOf(ujVar.isCanUseWriteExternal()));
            ujVarC.c(8026, Boolean.valueOf(ujVar.alist()));
            ujVarC.c(8480, Boolean.valueOf(ujVar.isCanUseWifiState()));
            ujVarC.c(8479, Boolean.valueOf(ujVar.isCanUseAndroidId()));
            ujVarC.c(8312, ujVar.getTTLocation() != null ? new a(ujVar.getTTLocation()) : null);
            ujVarC.c(8483, ujVar.getTTLocation());
            ujVarC.c(8484, ujVar.getDevImei());
            ujVarC.c(8485, ujVar.getAndroidId());
            ujVarC.c(8486, ujVar.getDevOaid());
            ujVarC.c(8487, ujVar.getMacAddress());
            ujVarC.c(8554, ujVar.userPrivacyConfig());
            ujVarC.c(8549, Boolean.valueOf(ujVar.isCanUsePermissionRecordAudio()));
        } else {
            ujVarC.c(8311, new c(null));
            Boolean bool = Boolean.TRUE;
            ujVarC.c(8023, bool);
            ujVarC.c(8024, bool);
            ujVarC.c(8025, bool);
            ujVarC.c(8026, bool);
            ujVarC.c(8480, bool);
            ujVarC.c(8479, bool);
            ujVarC.c(8312, new a(null));
            ujVarC.c(8483, null);
            ujVarC.c(8484, "");
            ujVarC.c(8485, "");
            ujVarC.c(8486, "");
            ujVarC.c(8487, "");
            ujVarC.c(8549, bool);
        }
        return ujVarC.tt();
    }

    public static void c() {
        da.c(new com.byazt.dj.c(com.byazt.bp.c.t().cu().sparseArray()).sl());
    }
}
