package com.byazt.ysz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.eia.i;
import com.byazt.ete.ic;
import com.byazt.ete.nu;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import com.kc.aw.lib.constants.PtgRewardConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 589, 46})
public class n extends c {
    private String tt(i iVar, Map<String, Object> map) {
        if (iVar == null) {
            return "";
        }
        try {
            Uri uriC = com.byazt.apd.ve.c(Uri.parse("sslocal://webcast_room"), c(iVar, map));
            m.c(com.byazt.we.ve.TAG, "link: " + uriC.toString());
            return uriC.toString();
        } catch (Throwable th) {
            m.c(th);
            m.uj(com.byazt.we.ve.TAG, "link: null");
            return "";
        }
    }

    @Override // com.byazt.ysz.uj
    public boolean a() {
        return tt() == 2;
    }

    @Override // com.byazt.ysz.uj
    public boolean a_(ic icVar) {
        return c((i) icVar) && this.c != null;
    }

    @Override // com.byazt.ysz.uj
    public int c(Context context, ic icVar, Map<String, Object> map) {
        return -1;
    }

    @Override // com.byazt.ysz.uj
    public int c(com.byazt.cn.tt ttVar, boolean z) {
        return 0;
    }

    @Override // com.byazt.ysz.uj
    public void c(com.byazt.qh.uj ujVar) {
    }

    @Override // com.byazt.ysz.uj
    public void c(String str, boolean z) {
    }

    @Override // com.byazt.ysz.uj
    public int n() {
        boolean zBooleanValue = false;
        if (this.c != null) {
            try {
                Object objApply = this.c.apply(com.byazt.yxi.uj.c().c(3).c(Object.class).c(0, 3).tt());
                if (objApply instanceof Boolean) {
                    zBooleanValue = ((Boolean) objApply).booleanValue();
                }
            } catch (Throwable th) {
                m.tt(com.byazt.we.ve.TAG, th);
            }
        }
        return zBooleanValue ? 2 : 1;
    }

    @Override // com.byazt.ysz.c
    public boolean r_() {
        return true;
    }

    @Override // com.byazt.ysz.uj
    public String sp() {
        if (this.c == null) {
            return null;
        }
        try {
            Object objApply = this.c.apply(com.byazt.yxi.uj.c().c(3).c(Object.class).c(0, 4).tt());
            if (objApply instanceof String) {
                return (String) objApply;
            }
            return null;
        } catch (Throwable th) {
            m.tt(com.byazt.we.ve.TAG, th);
            return null;
        }
    }

    @Override // com.byazt.ysz.uj
    public void uj() {
    }

    @Override // com.byazt.ysz.uj
    public JSONObject x() {
        return this.ve;
    }

    @Override // com.byazt.ysz.uj
    public int c(Context context, i iVar, Map<String, Object> map) {
        int i;
        String str;
        if (context == null || iVar == null) {
            return -1;
        }
        if (!c(iVar)) {
            m.c(com.byazt.we.ve.TAG, "mata has not le property");
            return -1;
        }
        String str2 = map != null ? (String) map.get("event_tag") : "";
        int iN = iVar.n();
        int iIntValue = 1;
        if (!a()) {
            c(com.byazt.ppf.ve.c(iVar, map), str2, iN, 1, iN == 7 ? 1 : 2);
            return 1;
        }
        if (this.c != null) {
            int iTt = 0;
            Object objApply = this.c.apply(com.byazt.yxi.uj.c().c(0).c(Integer.class).c(0, tt(iVar, map)).tt());
            iIntValue = objApply != null ? ((Integer) objApply).intValue() : 0;
            if (iIntValue != 0) {
                iTt = 3;
            } else if (c(iVar, 0) && (iTt = tt(iVar)) == 0) {
                try {
                    new com.byazt.glq.c().c(str2).c(context, map, iVar);
                } catch (Exception e) {
                    m.c(e);
                    iTt = 3;
                }
            }
            if (iIntValue == 0) {
                str = "le openliv succ";
            } else {
                str = "callR: " + iIntValue;
            }
            m.c(com.byazt.we.ve.TAG, str);
            i = iTt;
        } else {
            i = 1;
        }
        c(com.byazt.ppf.ve.c(iVar, map), str2, iN, iN, i);
        return iIntValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(String str, ic icVar, long j) {
        try {
            if (this.c == null) {
                return;
            }
            Map<String, String> mapC = c(icVar, (Map<String, Object>) null);
            Map<String, String> mapC2 = com.byazt.ex.c.c(gt.getContext());
            mapC2.put("room_id", mapC.get("room_id"));
            mapC2.put("anchor_id", mapC.get("owner_open_id"));
            mapC2.put("enter_from_merge", mapC.get("enter_from_merge"));
            mapC2.put("enter_method", mapC.get("enter_method"));
            mapC2.put("action_type", "click");
            mapC2.put("request_id", mapC.get("request_id"));
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            mapC2.put("duration", sb.toString());
            mapC2.put("is_other_channel", "union_ad");
            mapC2.put("IESLiveEffectAdTrackExtraServiceKey", mapC.get("IESLiveEffectAdTrackExtraServiceKey"));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : mapC2.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            this.c.apply(com.byazt.yxi.uj.c().c(4).c(Void.class).c(0, str).c(1, jSONObject).tt());
        } catch (Throwable th) {
            if (m.ve()) {
                m.ve("TTInnerLiveHelper", "Throwable : ", th);
            }
        }
    }

    public Map<String, String> c(i iVar, Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (iVar == null) {
            return map2;
        }
        map2.put("room_id", iVar.da());
        if (this.c != null) {
            int iSl = nb.sl(com.byazt.ppf.ve.c(iVar, map));
            String str = (String) this.c.apply(com.byazt.yxi.uj.c().c(1).c(String.class).c(0, Integer.valueOf(iSl)).tt());
            String str2 = (String) this.c.apply(com.byazt.yxi.uj.c().c(2).c(String.class).c(0, Integer.valueOf(iSl)).c(1, Boolean.valueOf(com.byazt.ex.c.c(com.byazt.ppf.ve.c(iVar, map)))).tt());
            map2.put("enter_from_merge", str);
            map2.put("enter_method", str2);
        }
        map2.put(com.alipay.sdk.m.n.c.f, "aweme");
        map2.put("is_other_channel", "union_ad");
        String strC = c(iVar, iVar.t(), map);
        if (!TextUtils.isEmpty(strC)) {
            map2.put("ecom_live_params", strC);
        }
        nu nuVarYp = iVar.yp();
        if (nuVarYp != null && !TextUtils.isEmpty(nuVarYp.tt())) {
            try {
                Uri uri = Uri.parse(nuVarYp.tt());
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                String strOptString = jSONObject.optString("log_extra");
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject3 = new JSONObject(strOptString);
                    jSONObject3.put("ad_event_aid", jSONObject.optString("aid"));
                    jSONObject3.put("ad_event_source", com.byazt.apd.ve.c(uri, "source"));
                    jSONObject3.put("ad_event_gd_label", com.byazt.apd.ve.c(uri, "gd_label"));
                    jSONObject3.put("ad_event_union_user_id", com.byazt.apd.ve.c(uri, "union_user_id"));
                    jSONObject3.put("ad_event_app_siteid", x.m().rl());
                    jSONObject3.put("ad_event_live_type", "1");
                    map2.put("log_extra", jSONObject3.toString());
                    jSONObject2.put("log_extra", jSONObject3.toString());
                }
                String strOptString2 = jSONObject.optString("cid");
                jSONObject2.put("creativeID", strOptString2);
                map2.put("creative_id", strOptString2);
                map2.put("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                String strC2 = com.byazt.apd.ve.c(uri, "owner_open_id");
                if (TextUtils.isEmpty(strC2)) {
                    strC2 = com.byazt.apd.ve.c(uri, PtgRewardConstant.REWARD_PARAMS.USER_ID);
                }
                map2.put("owner_open_id", strC2);
                String strC3 = com.byazt.apd.ve.c(uri, "pangle_live_room_data");
                if (!TextUtils.isEmpty(strC3)) {
                    map2.put("pangle_live_room_data", strC3);
                }
                map2.put("request_id", com.byazt.apd.ve.c(uri, "request_id"));
            } catch (Exception e) {
                m.c(e);
            }
        }
        return map2;
    }

    @Override // com.byazt.ysz.uj
    public int tt() {
        if (this.c != null) {
            try {
                Object objApply = this.c.apply(com.byazt.yxi.uj.c().c(3).c(Object.class).c(0, 1).tt());
                if (objApply instanceof Integer) {
                    return ((Integer) objApply).intValue();
                }
            } catch (Throwable th) {
                m.tt(com.byazt.we.ve.TAG, th);
            }
        }
        return 0;
    }

    @Override // com.byazt.ysz.uj
    public int tt(ic icVar) {
        if (this.c != null) {
            long jC = c(icVar);
            if (jC == 0) {
                return 1;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putLong("room_id", jC);
                Object objApply = this.c.apply(com.byazt.yxi.uj.c().c(3).c(Object.class).c(0, 2).c(1, bundle).tt());
                if (objApply instanceof Integer) {
                    return ((Integer) objApply).intValue();
                }
            } catch (Throwable th) {
                m.tt(com.byazt.we.ve.TAG, th);
            }
        }
        return 0;
    }

    @Override // com.byazt.ysz.c, com.byazt.ysz.uj
    public void c(final String str, final ic icVar, final long j) {
        com.byazt.bzd.x.tt(new Runnable() { // from class: com.byazt.ysz.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.tt(str, icVar, j);
            }
        });
    }

    @Override // com.byazt.ysz.uj
    public int c(i iVar, ve veVar, String str, Map<String, Object> map) {
        if (iVar == null || TextUtils.isEmpty(iVar.t_()) || this.c == null) {
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", iVar.t_());
            Object objApply = this.c.apply(com.byazt.yxi.uj.c().c(3).c(Object.class).c(0, 5).c(1, bundle).tt());
            if (objApply == null) {
                return 4;
            }
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    @Override // com.byazt.ysz.uj
    public int c(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", str);
            Object objApply = this.c.apply(com.byazt.yxi.uj.c().c(3).c(Object.class).c(0, 6).c(1, bundle).tt());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
