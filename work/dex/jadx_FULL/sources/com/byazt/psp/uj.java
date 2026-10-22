package com.byazt.psp;

import android.text.TextUtils;
import com.byazt.nbs.da;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsIsEncryptVersion, 15})
public class uj {
    public static final Map<String, com.byazt.nbs.tt> c = new ConcurrentHashMap();

    public static void c(int i, String str, int i2, double d) {
        com.byazt.nbs.tt ttVarC;
        com.byazt.nbs.uj ujVarN;
        if (com.byazt.bp.tt.tt().kk() && (ttVarC = com.byazt.bp.tt.tt().c(str, i2, 101)) != null) {
            if (ttVarC.i() == 1 && i == 1) {
                n.uj().c(i2, d);
                return;
            }
            if (ttVarC.i() != 2 || (ujVarN = com.byazt.bp.tt.tt().n(str)) == null) {
                return;
            }
            if (i == 2 && ujVarN.ve() == 2) {
                tt.uj().c(str, 2, d);
            } else {
                if (i != 1 || ujVarN.ve() == 2) {
                    return;
                }
                tt.uj().c(str, ujVarN.ve(), d);
            }
        }
    }

    public static void c(com.byazt.nbs.tt ttVar, double d, String str, int i) {
        if (!com.byazt.bp.tt.tt().kk() || ttVar == null) {
            return;
        }
        if (ttVar.i() == 2) {
            c(2, str, i, d);
        } else if (ttVar.i() == 3 || ttVar.i() == 4) {
            tt.uj().c(ttVar.nb(), "_last_load_cpm_", ttVar.cu(), d);
        }
    }

    public static void c(String str, String str2, int i, JSONObject jSONObject) {
        com.byazt.nbs.tt ttVarC;
        if (com.byazt.bp.tt.tt().kk() && (ttVarC = com.byazt.ck.uj.c().c(str, i, 101)) != null) {
            if ("mediation_request".equals(str2)) {
                if (ttVarC.i() == 1) {
                    n.uj().c(String.valueOf(i), jSONObject, ttVarC.x());
                    return;
                } else {
                    if (ttVarC.i() == 2) {
                        tt.uj().c(String.valueOf(i), jSONObject, ttVarC.x());
                        return;
                    }
                    return;
                }
            }
            if (ttVarC.i() != 2 || "sdk_init".equals(str2) || "sdk_init_end".equals(str2) || "get_config_start".equals(str2) || "get_config_final".equals(str2)) {
                return;
            }
            tt.uj().ve(String.valueOf(i), jSONObject, ttVarC.x());
        }
    }

    public static com.byazt.nbs.tt c(com.byazt.nbs.tt ttVar, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (ttVar != null && com.byazt.bp.tt.tt().kk()) {
            if (i == 101) {
                return c.get(ttVar.nb());
            }
            if (i == 100 && (ttVar.i() == 2 || ttVar.i() == 3 || ttVar.i() == 4)) {
                List<da> listC = ve.c(ttVar, ttVar.nb());
                Object obj = ttVar.x().get("rule_in_use");
                int iIntValue = obj != null ? ((Integer) obj).intValue() : -1;
                ttVar.x().put(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                if (listC == null || iIntValue == 0) {
                    return ttVar;
                }
                com.byazt.nbs.tt ttVarClone = ttVar.clone();
                if (ttVarClone.yp()) {
                    ttVarClone.tt(listC);
                } else {
                    ttVarClone.c(listC);
                }
                Object obj2 = ttVarClone.x().get("max_ecpm");
                Object obj3 = ttVarClone.x().get("min_ecpm");
                if (obj2 != null) {
                    ttVarClone.uj(((Double) obj2).doubleValue());
                }
                if (obj3 != null) {
                    ttVarClone.n(((Double) obj3).doubleValue());
                }
                c.put(ttVar.nb(), ttVarClone);
                ttVarClone.x().put(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                return ttVarClone;
            }
        }
        return null;
    }

    public static int c(String str, int i, Map<String, Object> map) {
        com.byazt.nbs.uj ujVarN;
        int iC;
        if (!TextUtils.isEmpty(str) && i == 1 && (ujVarN = com.byazt.bp.tt.tt().n(str)) != null) {
            int iVe = ujVarN.ve();
            String strUj = ujVarN.uj();
            if (iVe > 0 && !TextUtils.isEmpty(strUj)) {
                double dC = tt.uj().c(3, str, iVe);
                List<com.byazt.nbs.ve> listA = com.byazt.bp.tt.tt().a(String.valueOf(i));
                if (listA != null && listA.size() > 0) {
                    Iterator<com.byazt.nbs.ve> it = listA.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            iC = 0;
                            break;
                        }
                        com.byazt.nbs.ve next = it.next();
                        if (dC > next.a() && dC <= next.n()) {
                            iC = ujVarN.c(String.valueOf(next.ve()));
                            map.put("refresh_time", Integer.valueOf(iC));
                            break;
                        }
                    }
                } else {
                    iC = 0;
                    break;
                }
                if (iC >= 10000 && iC <= 180000) {
                    return iC;
                }
            }
        }
        return 0;
    }

    public static void c(int i, String str, JSONObject jSONObject) {
        com.byazt.nbs.uj ujVarN;
        if (com.byazt.bp.tt.tt().kk() && i == 2 && (ujVarN = com.byazt.bp.tt.tt().n(str)) != null) {
            try {
                jSONObject.putOpt("dynamic_rule_id", ujVarN.uj());
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public static void c(List<com.byazt.yl.ve> list, com.byazt.nbs.tt ttVar) {
        Object obj;
        if (!com.byazt.bp.tt.tt().kk() || list == null || ttVar == null) {
            return;
        }
        for (com.byazt.yl.ve veVar : list) {
            if (veVar != null) {
                if (ttVar.i() == 1) {
                    veVar.getMediaExtraInfo().put(MediationConstant.KEY_GM_USB, n.ve(ttVar.pf()));
                } else if (ttVar.i() == 2 && (obj = ttVar.x().get("user_label_value")) != null) {
                    veVar.getMediaExtraInfo().put(MediationConstant.KEY_GM_USB, ((com.byazt.nbs.ve) obj).c());
                }
            }
        }
    }

    public static void c(boolean z, com.byazt.ng.uj ujVar, JSONObject jSONObject, Map<String, Object> map) {
        if (ujVar == null || !com.byazt.bp.tt.tt().kk()) {
            return;
        }
        n.uj().c(z, ujVar, jSONObject, map);
    }

    public static void c(int i, List<da> list, Map<String, Object> map) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (da daVar : list) {
            if (daVar != null && daVar.my() == 0) {
                jSONArray.put(daVar.rh());
            }
        }
        if (map != null) {
            map.put("rit_ids", jSONArray);
        }
    }
}
