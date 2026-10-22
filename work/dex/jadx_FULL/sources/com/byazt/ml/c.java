package com.byazt.ml;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.bv.BaseConstants;
import com.byazt.nr.m;
import com.byazt.nys.PluginConstants;
import com.byazt.vb.n;
import com.byazt.vb.uj;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, TTAdConstant.STYLE_SIZE_RADIO_2_3, 20})
public class c {
    public static final LinkedList<String> c = new LinkedList<>();
    public static final LinkedList<String> tt = new LinkedList<>();
    public static final LinkedList<String> ve = new LinkedList<>();
    public static final LinkedList<String> uj = new LinkedList<>();
    public static final Map<String, Integer> n = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f28795a = "upload_init";
    public static int sp = 0;
    public static int x = 0;
    public static AtomicLong i = new AtomicLong();
    public static AtomicLong da = new AtomicLong();

    private static synchronized void a(String str) {
        LinkedList<String> linkedList = uj;
        if (linkedList.size() < 10) {
            linkedList.add(str);
        } else {
            linkedList.removeFirst();
            linkedList.add(str);
        }
    }

    public static synchronized int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Map<String, Integer> map = n;
        Integer num = map.get(str);
        if (num == null) {
            map.put(str, 1);
            return 1;
        }
        int iIntValue = num.intValue() + 1;
        map.put(str, Integer.valueOf(iIntValue));
        return iIntValue;
    }

    public static boolean c(int i2) {
        return i2 == 72 || i2 == 71;
    }

    public static boolean i(com.byazt.vb.tt ttVar, n nVar) {
        return ttVar != null && ttVar.uj() == 0 && c(nVar);
    }

    private static synchronized String n(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = ve;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        return sb.toString();
    }

    public static void sp(com.byazt.vb.tt ttVar, n nVar) {
        try {
            if (ttVar.uj() == 0 && nVar.uj() != null && nVar.uj().yp()) {
                JSONObject jSONObjectSp = ttVar.sp();
                String strC = c(ttVar, nVar);
                if (ve(strC)) {
                    return;
                }
                String strOptString = jSONObjectSp.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("will_send_labels", n(strC));
                    jSONObject.put("send_success_valid_labels", tt());
                    jSONObjectSp.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(strOptString);
                if (TextUtils.isEmpty(jSONObject2.optString("will_send_labels"))) {
                    jSONObject2.put("will_send_labels", n(strC));
                    jSONObject2.put("send_success_valid_labels", tt());
                }
                jSONObjectSp.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    public static String tt(int i2) {
        switch (i2) {
            case 71:
                return "flush once";
            case 72:
                return "flush memory db";
            case 73:
                return "flush memory";
            case 74:
                return "new event";
            case 75:
            default:
                return "default";
            case 76:
                return "empty message";
            case 77:
                return "net error";
            case 78:
                return "direct upload";
        }
    }

    public static synchronized String tt(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = c;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        return sb.toString();
    }

    private static synchronized String uj(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = tt;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        return sb.toString();
    }

    public static String ve(com.byazt.vb.tt ttVar, n nVar) {
        if (nVar == null || nVar.uj() == null || !nVar.uj().c()) {
            return "";
        }
        String strC = c(ttVar, nVar);
        if (!TextUtils.isEmpty(strC)) {
            return "label:" + strC;
        }
        if (TextUtils.isEmpty(tt(ttVar, nVar))) {
            return null;
        }
        return "type:" + tt(ttVar, nVar);
    }

    public static boolean ve(String str) {
        return false;
    }

    public static void x(com.byazt.vb.tt ttVar, n nVar) {
        if (nVar == null || nVar.uj() == null || !nVar.uj().ve()) {
            return;
        }
        try {
            com.byazt.mv.tt.c.c(System.currentTimeMillis() - ttVar.x(), ttVar);
            ttVar.tt(System.currentTimeMillis());
            if (ttVar.uj() == 0 && nVar.uj() != null && nVar.uj().yp()) {
                String strC = c(ttVar, nVar);
                if (ve(strC)) {
                    return;
                }
                JSONObject jSONObjectSp = ttVar.sp();
                String strOptString = ttVar.sp().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("save_success_labels", uj(strC));
                    jSONObjectSp.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                } else {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject2.optString("save_success_labels"))) {
                        jSONObject2.put("save_success_labels", uj(strC));
                    }
                    jSONObjectSp.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String a(com.byazt.vb.tt ttVar, n nVar) {
        if (ttVar != null && ttVar.sp() != null && !tt(nVar) && !uj(nVar)) {
            String strOptString = ttVar.sp().optString("log_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    return new JSONObject(strOptString).optString("req_id");
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        }
        return null;
    }

    public static boolean ve(n nVar) {
        return nVar != null && TextUtils.equals(nVar.n(), MediationConstant.ADN_PANGLE);
    }

    public static String c(com.byazt.vb.tt ttVar, n nVar) {
        if (ttVar == null || ttVar.sp() == null || tt(nVar) || uj(nVar)) {
            return null;
        }
        if (ttVar.tt() == 3) {
            return ttVar.sp().optString("event");
        }
        return ttVar.sp().optString("label");
    }

    public static synchronized int n(com.byazt.vb.tt ttVar, n nVar) {
        if (ttVar != null) {
            if (ttVar.sp() != null) {
                try {
                    return new JSONObject(ttVar.sp().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optInt("sdk_event_self_count");
                } catch (Exception e) {
                    m.c(e);
                    return 0;
                }
            }
        }
        return 0;
    }

    private static synchronized String tt() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator<String> it = uj.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        return sb.toString();
    }

    public static String uj(com.byazt.vb.tt ttVar, n nVar) {
        if (ttVar != null && ttVar.sp() != null && ttVar.uj() == 1) {
            JSONObject jSONObjectSp = ttVar.sp();
            String strOptString = jSONObjectSp.optString("event_extra");
            String strOptString2 = jSONObjectSp.optString(PluginConstants.KEY_PLUGIN_VERSION);
            try {
                return new JSONObject(strOptString).optInt("stats_index") + LoginConstants.UNDER_LINE + strOptString2;
            } catch (JSONException e) {
                m.c(e);
            }
        }
        return "-1";
    }

    public static boolean ve(com.byazt.vb.tt ttVar) {
        return ttVar != null && ttVar.uj() == 0 && ttVar.n() == 1;
    }

    public static int ve(List<com.byazt.vb.tt> list, n nVar) {
        JSONObject jSONObjectSp;
        String strOptString;
        if (list != null && list.size() == 1) {
            try {
                com.byazt.vb.tt ttVar = list.get(0);
                if (ttVar != null && ttVar.n() == 1 && (jSONObjectSp = ttVar.sp()) != null && ttVar.uj() == 0) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectSp.optJSONObject("params");
                    if (jSONObjectOptJSONObject == null) {
                        strOptString = jSONObjectSp.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                    } else {
                        strOptString = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                    }
                    JSONObject jSONObject = new JSONObject(strOptString);
                    int iOptInt = jSONObject.optInt("inner_appid", 0);
                    if (iOptInt != 0) {
                        jSONObject.remove("inner_appid");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectSp.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                        } else {
                            jSONObjectOptJSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                            jSONObjectSp.put("params", jSONObjectOptJSONObject);
                        }
                        return iOptInt;
                    }
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return 0;
    }

    public static boolean a(com.byazt.vb.tt ttVar) {
        return ttVar != null && ttVar.uj() == 1 && ttVar.n() == 2;
    }

    public static String tt(com.byazt.vb.tt ttVar, n nVar) {
        if (ttVar == null || ttVar.sp() == null || tt(nVar) || uj(nVar)) {
            return null;
        }
        return ttVar.sp().optString("type");
    }

    public static void c(List<com.byazt.vb.tt> list, String str) {
        com.byazt.vb.tt ttVar;
        JSONObject jSONObjectSp;
        JSONObject jSONObjectSp2;
        if (list != null) {
            try {
                if (list.isEmpty() || (ttVar = list.get(0)) == null) {
                    return;
                }
                byte bUj = ttVar.uj();
                if (bUj == 0) {
                    long jIncrementAndGet = i.incrementAndGet();
                    for (com.byazt.vb.tt ttVar2 : list) {
                        if (ttVar2 != null && (jSONObjectSp = ttVar2.sp()) != null) {
                            String strOptString = jSONObjectSp.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                            if (!TextUtils.isEmpty(strOptString)) {
                                jSONObjectSp.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, c(strOptString, jIncrementAndGet));
                            }
                        }
                    }
                    return;
                }
                if (bUj != 1) {
                    return;
                }
                long jIncrementAndGet2 = da.incrementAndGet();
                for (com.byazt.vb.tt ttVar3 : list) {
                    if (ttVar3 != null && (jSONObjectSp2 = ttVar3.sp()) != null) {
                        String strOptString2 = jSONObjectSp2.optString("event_extra");
                        if (!TextUtils.isEmpty(strOptString2)) {
                            jSONObjectSp2.put("event_extra", c(strOptString2, jIncrementAndGet2));
                        }
                    }
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
    }

    private static int tt(List<com.byazt.vb.tt> list, boolean z) {
        int i2 = 0;
        if (list != null && !list.isEmpty()) {
            for (com.byazt.vb.tt ttVar : list) {
                if (ttVar != null && (!z || ttVar.da() <= 1)) {
                    if (tt(ttVar)) {
                        i2++;
                    }
                }
            }
        }
        return i2;
    }

    public static boolean n(n nVar) {
        return c(nVar) || ve(nVar);
    }

    public static boolean uj(n nVar) {
        return nVar != null && TextUtils.equals(nVar.n(), "pgl_mediation");
    }

    public static boolean n(com.byazt.vb.tt ttVar) {
        return ttVar != null && ttVar.uj() == 0 && ttVar.n() == 2;
    }

    public static boolean uj(com.byazt.vb.tt ttVar) {
        return ttVar != null && ttVar.uj() == 3 && ttVar.n() == 2;
    }

    public static boolean sp(com.byazt.vb.tt ttVar) {
        return ttVar != null && ttVar.uj() == 1 && ttVar.n() == 3;
    }

    public static boolean x(com.byazt.vb.tt ttVar) {
        return ttVar != null && ttVar.uj() == 2 && ttVar.n() == 3;
    }

    public static boolean tt(com.byazt.vb.tt ttVar) {
        if (ttVar == null) {
            return false;
        }
        try {
            return ttVar.uj() == 0 && ttVar.sp() != null && "click".equals(ttVar.sp().optString("label"));
        } catch (Throwable unused) {
        }
    }

    public static boolean tt(n nVar) {
        return nVar != null && TextUtils.equals(nVar.n(), "csj_mediation");
    }

    public static boolean tt(List<com.byazt.vb.tt> list, n nVar) {
        com.byazt.vb.tt ttVar;
        return (list == null || list.size() == 0 || (ttVar = list.get(0)) == null || ttVar.uj() != 0 || !c(nVar)) ? false : true;
    }

    private static String c(String str, long j) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("upload_count", j);
            jSONObject.put("upload_ts", System.currentTimeMillis());
            return jSONObject.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String c(JSONObject jSONObject, n nVar) {
        if (jSONObject != null && !tt(nVar) && !uj(nVar)) {
            String strOptString = jSONObject.optString("log_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    return new JSONObject(strOptString).optString("rit");
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        }
        return "";
    }

    public static void c(List<com.byazt.vb.tt> list, n nVar) {
        try {
            if (nVar.uj().ve()) {
                for (com.byazt.vb.tt ttVar : list) {
                    if (ttVar != null && ttVar.i() != 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - ttVar.i();
                        com.byazt.sl.c cVar = com.byazt.mv.tt.c;
                        cVar.x().incrementAndGet();
                        cVar.u().getAndAdd(jCurrentTimeMillis);
                        ttVar.ve(System.currentTimeMillis());
                    }
                    if (ttVar != null) {
                        sp(ttVar, nVar);
                    }
                }
                com.byazt.sl.c cVar2 = com.byazt.mv.tt.c;
                cVar2.da().getAndAdd(list.size());
                cVar2.gu().getAndAdd(c(list));
                cVar2.gr().getAndAdd(c(list, false));
                cVar2.zm().getAndAdd(c(list, true));
                cVar2.p().getAndAdd(tt(list, false));
                cVar2.md().getAndAdd(tt(list, true));
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    private static int c(List<com.byazt.vb.tt> list) {
        int i2 = 0;
        if (list != null && !list.isEmpty()) {
            for (com.byazt.vb.tt ttVar : list) {
                if (ttVar != null && ttVar.da() <= 1) {
                    i2++;
                }
            }
        }
        return i2;
    }

    private static int c(List<com.byazt.vb.tt> list, boolean z) {
        int i2 = 0;
        if (list != null && !list.isEmpty()) {
            for (com.byazt.vb.tt ttVar : list) {
                if (ttVar != null && (!z || ttVar.da() <= 1)) {
                    if (c(ttVar)) {
                        i2++;
                    }
                }
            }
        }
        return i2;
    }

    public static boolean c(com.byazt.vb.tt ttVar) {
        if (ttVar == null) {
            return false;
        }
        try {
            return ttVar.uj() == 0 && ttVar.sp() != null && "show".equals(ttVar.sp().optString("label"));
        } catch (Throwable unused) {
        }
    }

    public static boolean c(n nVar) {
        return nVar != null && TextUtils.equals(nVar.n(), "csj");
    }

    public static void c(JSONObject jSONObject, com.byazt.fo.c cVar, n nVar, int i2) {
        uj ujVarUj;
        if (nVar != null && (ujVarUj = nVar.uj()) != null && ujVarUj.c() && n(nVar)) {
            jSONObject.optString("label");
        }
    }

    public static void c(List<com.byazt.vb.tt> list, int i2, String str, n nVar) {
        uj ujVarUj;
        if (nVar == null || (ujVarUj = nVar.uj()) == null || !ujVarUj.c() || list == null || tt(nVar) || uj(nVar)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (com.byazt.vb.tt ttVar : list) {
            if (ttVar.uj() == 0) {
                JSONObject jSONObjectSp = ttVar.sp();
                String strC = c(ttVar, nVar);
                if (ttVar.tt() == 3) {
                    if (jSONObjectSp != null) {
                        strC = jSONObjectSp.optString("event");
                    }
                    sb.append(" [v3:");
                    sb.append(strC);
                    sb.append("] ");
                } else {
                    long jC = c(nVar, ttVar);
                    int iN = n(ttVar, nVar);
                    sb.append(" [");
                    sb.append(jC);
                    sb.append(LoginConstants.UNDER_LINE);
                    sb.append(strC);
                    if (iN == 0) {
                        sb.append("] ");
                    } else {
                        sb.append(LoginConstants.UNDER_LINE);
                        sb.append(iN);
                        sb.append("] ");
                    }
                }
                z = true;
            } else if (ttVar.uj() == 1) {
                String strTt = tt(ttVar, nVar);
                String strUj = uj(ttVar, nVar);
                sb.append(" [");
                sb.append(strUj);
                sb.append(LoginConstants.UNDER_LINE);
                sb.append(strTt);
                sb.append("] ");
            }
        }
        if (z) {
            ve.tt("_upload", "ads:" + ((Object) sb) + tt(i2) + "," + str + ",total:" + list.size(), nVar);
            return;
        }
        ve.tt("_upload", "stats:" + ((Object) sb) + tt(i2) + "," + str + ",total:" + list.size(), nVar);
    }

    private static void c(com.byazt.vb.tt ttVar, String str, uj ujVar, n nVar) {
        String strC = c(ttVar, nVar);
        if (ve(strC)) {
            return;
        }
        String strA = a(ttVar, nVar);
        if (ttVar.uj() == 0 && ujVar.yp()) {
            a(strC + LoginConstants.UNDER_LINE + strA + LoginConstants.UNDER_LINE + str);
        }
    }

    public static long c(n nVar, com.byazt.vb.tt ttVar) {
        if (ttVar != null && ttVar.sp() != null) {
            try {
                return new JSONObject(ttVar.sp().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optLong("sdk_event_index");
            } catch (Exception e) {
                ve.ve(e.getMessage(), nVar);
            }
        }
        return 0L;
    }

    public static void c(boolean z, int i2, String str, String str2, int i3, String str3) {
        sp++;
        if (z) {
            x++;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("suc", z);
            jSONObject.put("scnt", x);
            jSONObject.put("acnt", sp);
            jSONObject.put("code", i2);
            jSONObject.put("reqid", str2);
            jSONObject.put("len:", i3);
            jSONObject.put("rit", str3);
            jSONObject.put("msg", str);
            uj ujVarUj = com.byazt.epi.c.tt("csj").uj();
            if (ujVarUj != null) {
                jSONObject.put("url", ujVarUj.t().a());
            } else {
                jSONObject.put("url", "emptyurl");
            }
            f28795a = jSONObject.toString();
        } catch (Exception unused) {
            f28795a = "unknown_json";
        }
    }

    public static String c() {
        return f28795a;
    }

    public static void c(com.byazt.vb.tt ttVar, n nVar, String str) {
        uj ujVarUj;
        if (tt(nVar) || nVar == null || uj(nVar) || (ujVarUj = com.byazt.epi.c.tt(nVar.n()).uj()) == null || !ujVarUj.c()) {
            return;
        }
        if (!TextUtils.isEmpty(tt(ttVar, nVar))) {
            uj(ttVar, nVar);
        }
        if (TextUtils.isEmpty(c(ttVar, nVar))) {
            return;
        }
        c(nVar, ttVar);
    }

    public static void c(List<com.byazt.vb.tt> list, n nVar, String str) {
        if (nVar == null) {
            return;
        }
        try {
            uj ujVarUj = nVar.uj();
            if (ujVarUj == null || !ujVarUj.c()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (com.byazt.vb.tt ttVar : list) {
                if (ttVar.uj() == 1) {
                    sb.append(tt(ttVar, nVar));
                    sb.append(LoginConstants.UNDER_LINE);
                    sb.append(uj(ttVar, nVar));
                    sb.append("; ");
                } else if (ttVar.uj() == 0) {
                    if (ttVar.tt() == 3) {
                        if (ttVar.sp() != null) {
                            sb.append(ttVar.sp().optString("event"));
                            long jC = c(nVar, ttVar);
                            if (jC != 0) {
                                sb.append(LoginConstants.UNDER_LINE);
                                sb.append(jC);
                            }
                            sb.append("; ");
                        } else {
                            ve.tt("_delete", "v3_error", nVar);
                        }
                    } else {
                        sb.append(c(ttVar, nVar));
                        long jC2 = c(nVar, ttVar);
                        if (jC2 != 0) {
                            sb.append(LoginConstants.UNDER_LINE);
                            sb.append(jC2);
                        }
                        sb.append("; ");
                    }
                }
            }
            sb.append("]");
            sb.append(" total:" + list.size());
            sb.append(" table:" + str);
            ve.tt("_remove", sb.toString(), nVar);
        } catch (Exception e) {
            ve.ve("_delete error", e.getMessage(), nVar);
        }
    }

    public static void c(int i2, List<com.byazt.vb.tt> list, long j, n nVar, com.byazt.lph.tt ttVar, com.byazt.uf.tt ttVar2) {
        com.byazt.vb.tt ttVar3;
        if (nVar != null) {
            try {
                if (nVar.uj().ve()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - j;
                    if (i2 == 200) {
                        com.byazt.sl.c cVar = com.byazt.mv.tt.c;
                        cVar.nb().getAndAdd(jCurrentTimeMillis);
                        cVar.cu().incrementAndGet();
                        cVar.qy().getAndAdd(list.size());
                        cVar.yv().getAndAdd(c(list, false));
                        cVar.h().getAndAdd(tt(list, false));
                        cVar.n().getAndAdd(list.size());
                        return;
                    }
                    ve.ve("-------AdThread code is " + i2 + " error  ------------", nVar);
                    byte bUj = -1;
                    if (i2 == -1) {
                        com.byazt.sl.c cVar2 = com.byazt.mv.tt.c;
                        cVar2.zb().getAndAdd(list.size());
                        cVar2.d().getAndAdd(c(list, false));
                        cVar2.eo().getAndAdd(tt(list, false));
                    } else {
                        com.byazt.mv.tt.c.sp().getAndAdd(list.size());
                    }
                    com.byazt.sl.c cVar3 = com.byazt.mv.tt.c;
                    cVar3.pf().getAndAdd(jCurrentTimeMillis);
                    cVar3.qp().incrementAndGet();
                    if (!list.isEmpty() && (ttVar3 = list.get(0)) != null) {
                        bUj = ttVar3.uj();
                    }
                    if (ttVar != null) {
                        String str = ttVar.uj;
                        int i3 = ttVar.tt;
                        String str2 = ttVar.ve;
                        StringBuffer stringBufferBx = cVar3.bx();
                        stringBufferBx.append((int) bUj);
                        stringBufferBx.append(LoginConstants.UNDER_LINE);
                        stringBufferBx.append(str);
                        stringBufferBx.append(LoginConstants.UNDER_LINE);
                        stringBufferBx.append(i3);
                        stringBufferBx.append(LoginConstants.UNDER_LINE);
                        stringBufferBx.append(str2);
                        stringBufferBx.append(" ");
                    } else {
                        StringBuffer stringBufferBx2 = cVar3.bx();
                        stringBufferBx2.append((int) bUj);
                        stringBufferBx2.append(LoginConstants.UNDER_LINE);
                        stringBufferBx2.append(i2);
                        stringBufferBx2.append(" ");
                    }
                    if (ttVar2 != null) {
                        String strTt = ttVar2.tt();
                        boolean zC = ttVar2.c();
                        StringBuffer stringBufferSv = cVar3.sv();
                        stringBufferSv.append((int) bUj);
                        stringBufferSv.append(LoginConstants.UNDER_LINE);
                        stringBufferSv.append(zC);
                        stringBufferSv.append(LoginConstants.UNDER_LINE);
                        stringBufferSv.append(strTt);
                        return;
                    }
                    StringBuffer stringBufferSv2 = cVar3.sv();
                    stringBufferSv2.append((int) bUj);
                    stringBufferSv2.append("_ok");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void c(List<com.byazt.vb.tt> list, String str, n nVar) {
        try {
            uj ujVarUj = nVar.uj();
            if (ujVarUj != null && ujVarUj.ve() && list != null && ujVarUj.yp()) {
                for (com.byazt.vb.tt ttVar : list) {
                    if (ttVar != null) {
                        c(ttVar, str, ujVarUj, nVar);
                    }
                }
            }
        } catch (Exception e) {
            ve.ve(e.getMessage(), nVar);
        }
    }
}
