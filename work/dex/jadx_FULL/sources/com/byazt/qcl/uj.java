package com.byazt.qcl;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.byazt.ete.ic;
import com.byazt.ip.x;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.rgb.n;
import com.byazt.ukr.yp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 578, 15})
public class uj {
    public static String c = "tt_csj_node_line_detail";

    private static String a(tt ttVar) {
        if (ttVar == null) {
            return "";
        }
        String strC = ttVar.c();
        strC.hashCode();
        switch (strC) {
            case "started":
                return "0501";
            case "backgrounded":
                return "0503";
            case "end":
                return "0504";
            case "foregrounded":
                return "0502";
            default:
                return "";
        }
    }

    public static void c(String str, String str2) {
        m.c("Tme_node_line", "remove_n_l  key:" + str);
        tt(str2).remove(str);
    }

    private static String n(tt ttVar) {
        if (ttVar == null) {
            return "";
        }
        String strC = ttVar.c();
        strC.hashCode();
        switch (strC) {
            case "started":
                return "0402";
            case "market_closed":
                return "0404";
            case "download_finished":
                return "0409";
            case "market_opened":
                return "0403";
            case "download_canceled":
                return "0408";
            case "download_started":
                return "0405";
            case "end":
                return "0410";
            case "download_failed":
                return "0407";
            case "download_paused":
                return "0406";
            case "created":
                return "0401";
            default:
                return "";
        }
    }

    private static String sp(tt ttVar) {
        if (ttVar == null) {
            return "";
        }
        String strC = ttVar.c();
        strC.hashCode();
        switch (strC) {
            case "focused":
                return "0603";
            case "end":
                return "0607";
            case "attached":
                return "0602";
            case "created":
                return "0601";
            case "detached":
                return "0606";
            case "invisibled":
                return "0605";
            case "visibled":
                return "0604";
            default:
                return "";
        }
    }

    private static com.byazt.it.ve tt(String str) {
        return com.byazt.vif.uj.c(str, c);
    }

    private static String uj(tt ttVar) {
        if (ttVar == null) {
            return "";
        }
        String strC = ttVar.c();
        strC.hashCode();
        switch (strC) {
            case "started":
                return "0303";
            case "stopped":
                return "0308";
            case "buffered":
                return "0306";
            case "completed":
                return "0309";
            case "prepared":
                return "0304";
            case "paused":
                return "0307";
            case "played":
                return "0305";
            case "end":
                return "0310";
            case "created":
                return "0301";
            case "initialized":
                return "0302";
            default:
                return "";
        }
    }

    private static void ve(String str, String str2) {
        String str3;
        JSONObject jSONObjectTt;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String strOptString = jSONObject.optString("node_line_name");
            final String strOptString2 = jSONObject.optString("lifecycle_id");
            final int iOptInt = jSONObject.optInt("video_type", -1);
            final int iOptInt2 = jSONObject.optInt("download_type", -1);
            final String strOptString3 = jSONObject.optString("ad_load_id");
            final String strOptString4 = jSONObject.optString("ad_show_id");
            final String strOptString5 = jSONObject.optString("node_line_version");
            final int iOptInt3 = jSONObject.optInt("unexpected_type");
            final int iOptInt4 = jSONObject.optInt("bidding_type");
            String strOptString6 = jSONObject.optString("node_line");
            final JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("node_line_detail");
            if (!"app_node_line".equals(strOptString) || TextUtils.isEmpty(strOptString6) || strOptString6.contains("0504") || jSONArrayOptJSONArray == null || (jSONObjectTt = tt(str2, strOptString2)) == null) {
                str3 = strOptString6;
            } else {
                str3 = strOptString6 + "0504";
                jSONArrayOptJSONArray.put(jSONObjectTt);
            }
            final String strOptString7 = jSONObject.optString("creative_id");
            final String strOptString8 = jSONObject.optString("req_id");
            final String strOptString9 = jSONObject.optString("extra");
            final int iOptInt5 = jSONObject.optInt("ad_type");
            final String strOptString10 = jSONObject.optString("rit");
            final String strOptString11 = jSONObject.optString("ad_info");
            long jOptLong = jSONObject.optLong("ts");
            final boolean zOptBoolean = jSONObject.optBoolean("need_node_line_detail");
            final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("key_element_info");
            final JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("no_action_array");
            final JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("motion_info");
            final String strOptString12 = jSONObject.optString("style_id");
            final int iOptInt6 = jSONObject.optInt("style_category");
            final int iOptInt7 = jSONObject.optInt("component_type");
            final int iOptInt8 = jSONObject.optInt("render_sequence");
            final int iOptInt9 = jSONObject.optInt("display_area");
            final JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("container_rect");
            final JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("image_rect");
            final JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("video_rect");
            final int iOptInt10 = jSONObject.optInt("image_mode");
            final String str4 = str3;
            yp.c().c(jOptLong, strOptString, new com.byazt.ee.c() { // from class: com.byazt.qcl.uj.1
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() throws Exception {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        if (!TextUtils.isEmpty(strOptString2)) {
                            jSONObject2.putOpt("lifecycle_id", strOptString2);
                        }
                        if (!TextUtils.isEmpty(strOptString3)) {
                            jSONObject2.putOpt("ad_load_id", strOptString3);
                        }
                        if (!TextUtils.isEmpty(strOptString4)) {
                            jSONObject2.putOpt("ad_show_id", strOptString4);
                        }
                        int i = iOptInt;
                        if (i > 0) {
                            jSONObject2.putOpt("video_type", Integer.valueOf(i));
                        }
                        int i2 = iOptInt2;
                        if (i2 > 0) {
                            jSONObject2.putOpt("download_type", Integer.valueOf(i2));
                        }
                        jSONObject2.putOpt("key_element_info", jSONObjectOptJSONObject);
                        jSONObject2.putOpt("no_action_array", jSONArrayOptJSONArray2);
                        jSONObject2.putOpt("motion_info", jSONObjectOptJSONObject2);
                        jSONObject2.putOpt("bidding_type", Integer.valueOf(iOptInt4));
                        jSONObject2.putOpt("is_from_cache", 1);
                        jSONObject2.putOpt("node_line_version", strOptString5);
                        jSONObject2.putOpt("unexpected_type", Integer.valueOf(iOptInt3));
                        jSONObject2.putOpt("node_line", str4);
                        if (zOptBoolean) {
                            jSONObject2.putOpt("node_line_detail", jSONArrayOptJSONArray);
                        }
                        if ("easy_play_node_line".equals(strOptString)) {
                            if (!TextUtils.isEmpty(strOptString12)) {
                                jSONObject2.putOpt("style_id", strOptString12);
                            }
                            jSONObject2.putOpt("style_category", Integer.valueOf(iOptInt6));
                            jSONObject2.putOpt("component_type", Integer.valueOf(iOptInt7));
                            jSONObject2.putOpt("render_sequence", Integer.valueOf(iOptInt8));
                            jSONObject2.putOpt("display_area", Integer.valueOf(iOptInt9));
                        }
                        if ("view_node_line".equals(strOptString)) {
                            jSONObject2.putOpt("container_rect", jSONObjectOptJSONObject3);
                            jSONObject2.putOpt("image_rect", jSONObjectOptJSONObject4);
                            jSONObject2.putOpt("video_rect", jSONObjectOptJSONObject5);
                            int i3 = iOptInt10;
                            if (i3 > 0) {
                                jSONObject2.putOpt("image_mode", Integer.valueOf(i3));
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    return com.byazt.qal.tt.tt().uj(strOptString7).a(strOptString8).x(strOptString9).c(iOptInt5).ve(strOptString10).i(strOptString11).tt(jSONObject2.toString());
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static String x(tt ttVar) {
        if (ttVar == null) {
            return "";
        }
        String strC = ttVar.c();
        strC.hashCode();
        switch (strC) {
            case "started":
                return "0702";
            case "render_started":
                return "0704";
            case "loaded":
                return "0703";
            case "showed":
                return "0706";
            case "rendered":
                return "0705";
            case "end":
                return "0708";
            case "clicked":
                return "0707";
            case "created":
                return "0701";
            default:
                return "";
        }
    }

    private static JSONObject tt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                m.c("Tme_node_line", "report_app_exit_start lifecycleId：" + str2);
                com.byazt.it.ve veVarTt = n.tt(str);
                if (veVarTt == null) {
                    return null;
                }
                String str3 = veVarTt.get(c.c(NativeCallContext.DOMAIN_APP) + str2, "");
                if (TextUtils.isEmpty(str3)) {
                    return null;
                }
                return new JSONObject(str3);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static void c(String str, String str2, String str3) {
        m.c("Tme_node_line", "save_n_l key:" + str);
        tt(str3).put(str, str2);
    }

    public static void c(String str) {
        m.c("Tme_node_line", "report_n_l_start");
        com.byazt.it.ve veVarTt = tt(str);
        Map all = veVarTt.getAll();
        if (all == null || all.isEmpty()) {
            return;
        }
        m.c("Tme_node_line", "n_l_map.size:" + all.size());
        for (String str2 : all.keySet()) {
            Object obj = all.get(str2);
            if (str2 != null && (str2.startsWith("key_tt_csj_node_line_") || str2.startsWith("key_tt_csj_other_node_line_"))) {
                if (obj instanceof String) {
                    ve((String) obj, str);
                }
                veVarTt.remove(str2);
            }
        }
    }

    private static String tt(tt ttVar) {
        if (ttVar == null) {
            return "";
        }
        String strC = ttVar.c();
        strC.hashCode();
        switch (strC) {
            case "started":
                return "0101";
            case "loaded":
                return "0104";
            case "received":
                return "0103";
            case "reqed":
                return "0102";
            default:
                return "";
        }
    }

    public static JSONArray tt(List<tt> list) {
        JSONArray jSONArray = new JSONArray();
        for (tt ttVar : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("l_type", ttVar.tt());
                jSONObject.putOpt("type", ttVar.c());
                jSONObject.putOpt("ts", Long.valueOf(ttVar.ve()));
                if (ttVar.uj() >= 0) {
                    jSONObject.putOpt("source", Integer.valueOf(ttVar.uj()));
                }
                if (ttVar.n() >= 0 && "showed".equals(ttVar.c())) {
                    boolean z = true;
                    if (ttVar.n() != 1) {
                        z = false;
                    }
                    jSONObject.putOpt("create_show_tracker", Boolean.valueOf(z));
                }
            } catch (Throwable unused) {
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static void c(final List<tt> list, final com.byazt.ip.c cVar, String str, final JSONObject jSONObject) {
        if (cVar == null || jSONObject == null) {
            return;
        }
        m.c("Tme_node_line", "send_n_l_event");
        yp.c().c(System.currentTimeMillis() / 1000, str, new com.byazt.ee.c() { // from class: com.byazt.qcl.uj.2
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                boolean zWn = gt.tt().wn();
                try {
                    jSONObject.putOpt("bidding_type", Integer.valueOf(uj.c(cVar)));
                    jSONObject.putOpt("node_line_version", "1.0.0");
                    jSONObject.putOpt("unexpected_type", Integer.valueOf(cVar.da));
                    jSONObject.putOpt("node_line", uj.c((List<tt>) list));
                    if (zWn) {
                        jSONObject.putOpt("node_line_detail", uj.tt((List<tt>) list));
                    }
                } catch (Throwable unused) {
                }
                com.byazt.qal.tt<com.byazt.qal.tt> ttVarTt = com.byazt.qal.tt.tt();
                ic icVar = cVar.i;
                if (icVar != null) {
                    ttVarTt = ttVarTt.uj(icVar.uj()).a(cVar.i.qy()).x(cVar.i.w_()).i(cVar.i.mk());
                }
                return ttVarTt.c(cVar.sp).ve(cVar.x).tt(jSONObject.toString());
            }
        });
    }

    public static String c(List<tt> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<tt> it = list.iterator();
        while (it.hasNext()) {
            sb.append(c(it.next()));
        }
        return sb.toString();
    }

    public static String c(tt ttVar) {
        if (ttVar == null) {
            return "";
        }
        if ("ad_load".equals(ttVar.tt())) {
            return tt(ttVar);
        }
        if ("ad_show".equals(ttVar.tt())) {
            return ve(ttVar);
        }
        if ("video".equals(ttVar.tt())) {
            return uj(ttVar);
        }
        if ("download".equals(ttVar.tt())) {
            return n(ttVar);
        }
        if (NativeCallContext.DOMAIN_APP.equals(ttVar.tt())) {
            return a(ttVar);
        }
        if ("view".equals(ttVar.tt())) {
            return sp(ttVar);
        }
        return "easy_play".equals(ttVar.tt()) ? x(ttVar) : "";
    }

    public static int c(com.byazt.ip.c cVar) {
        ic icVar;
        if (cVar != null && (icVar = cVar.i) != null) {
            try {
                Map<String, Object> mapYt = icVar.yt();
                if (mapYt == null) {
                    return 0;
                }
                Object obj = mapYt.get("sdk_bidding_type");
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue();
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    private static String ve(tt ttVar) {
        if (ttVar == null) {
            return "";
        }
        String strC = ttVar.c();
        strC.hashCode();
        switch (strC) {
            case "started":
                return "0202";
            case "showed":
                return "0203";
            case "end":
                return "0205";
            case "clicked":
                return "0204";
            case "created":
                return "0201";
            case "invisibled":
                return "0207";
            case "visibled":
                return "0206";
            default:
                return "";
        }
    }

    public static void c(JSONObject jSONObject, com.byazt.ip.c cVar, List<tt> list, String str) {
        if (jSONObject == null || cVar == null || list == null) {
            return;
        }
        try {
            jSONObject.putOpt("node_line_version", "1.0.0");
            jSONObject.putOpt("unexpected_type", Integer.valueOf(cVar.da));
            jSONObject.putOpt("bidding_type", Integer.valueOf(c(cVar)));
            jSONObject.putOpt("node_line", c(list));
            jSONObject.putOpt("node_line_detail", tt(list));
            ic icVar = cVar.i;
            if (icVar != null) {
                jSONObject.putOpt("creative_id", icVar.uj());
                jSONObject.putOpt("req_id", cVar.i.qy());
                jSONObject.putOpt("extra", cVar.i.w_());
                jSONObject.putOpt("ad_info", cVar.i.mk());
            }
            jSONObject.putOpt("ad_type", Integer.valueOf(cVar.sp));
            if (!TextUtils.isEmpty(cVar.x)) {
                jSONObject.putOpt("rit", cVar.x);
            }
            jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis() / 1000));
            jSONObject.putOpt("need_node_line_detail", Boolean.valueOf(gt.tt().wn()));
            c(c.c(str) + cVar.c(), jSONObject.toString(), cVar.tt());
        } catch (Throwable unused) {
        }
    }

    public static int c(x xVar) {
        if (xVar == null) {
            return 0;
        }
        Object objC = xVar.c("source");
        if (objC instanceof Integer) {
            return ((Integer) objC).intValue();
        }
        return 0;
    }
}
