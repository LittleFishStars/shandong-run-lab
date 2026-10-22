package com.byazt.ete;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 121})
public class cu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f28484a;
    public static final Set<String> c;
    public static boolean da;
    public static final Set<String> i;
    public static final Set<String> n;
    public static final Map<String, String> sl;
    public static final Set<String> sp;
    public static volatile boolean t;
    public static final Set<String> x;
    public int tt;
    public static final Set<String> ve = new HashSet();
    public static final Set<String> uj = new CopyOnWriteArraySet();

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        n = copyOnWriteArraySet;
        f28484a = new CopyOnWriteArraySet();
        sp = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        x = copyOnWriteArraySet2;
        i = new CopyOnWriteArraySet();
        da = false;
        sl = new HashMap();
        c = new CopyOnWriteArraySet();
        t = false;
        copyOnWriteArraySet2.addAll(Arrays.asList(".*thefatherofsalmon\\.com.*@3", ".*qallzmx\\.quicklyopen\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*@3"));
        copyOnWriteArraySet.addAll(Arrays.asList("^hap://app", "^hwfastapp://", ".*thefatherofsalmon\\.com.*", ".*qallzmx\\.quicklyopen\\.com.*", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*"));
    }

    public cu(JSONObject jSONObject) {
        this.tt = jSONObject.optInt("block_auto_open");
    }

    public static void tt(JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("turn_up_white_list");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                uj.clear();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i2);
                    if (!TextUtils.isEmpty(strOptString)) {
                        uj.add(strOptString);
                    }
                }
            }
        } catch (Exception unused) {
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("turn_up_black_list_1");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                n.clear();
                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i3);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        n.add(strOptString2);
                    }
                }
            }
        } catch (Exception unused2) {
        }
        try {
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("turn_up_black_list_2");
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                f28484a.clear();
                for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                    String strOptString3 = jSONArrayOptJSONArray3.optString(i4);
                    if (!TextUtils.isEmpty(strOptString3)) {
                        f28484a.add(strOptString3);
                    }
                }
            }
        } catch (Exception unused3) {
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("url_report_rule_list");
                if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                    sp.clear();
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray4.length(); i5++) {
                        String strOptString4 = jSONArrayOptJSONArray4.optString(i5);
                        if (!TextUtils.isEmpty(strOptString4)) {
                            sp.add(strOptString4);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("net_url_block_list");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    x.clear();
                    for (int i6 = 0; i6 < jSONArrayOptJSONArray5.length(); i6++) {
                        String strOptString5 = jSONArrayOptJSONArray5.optString(i6);
                        if (!TextUtils.isEmpty(strOptString5)) {
                            x.add(strOptString5);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray("dialog_black_list");
                if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                    i.clear();
                    for (int i7 = 0; i7 < jSONArrayOptJSONArray6.length(); i7++) {
                        String strOptString6 = jSONArrayOptJSONArray6.optString(i7);
                        if (!TextUtils.isEmpty(strOptString6)) {
                            i.add(strOptString6);
                        }
                    }
                }
            } catch (Exception unused4) {
            }
        }
        da = true;
    }

    public void c(JSONObject jSONObject) {
        try {
            jSONObject.put("block_auto_open", this.tt);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    public static void c(com.byazt.it.n nVar) {
        nVar.put("turn_up_white_list", uj);
        nVar.put("turn_up_black_list_1", n);
        nVar.put("turn_up_black_list_2", f28484a);
        nVar.put("url_report_rule_list", sp);
        nVar.put("net_url_block_list", x);
        nVar.put("_turn_up_is_get_list", da);
        nVar.put("dialog_black_list", i);
    }

    public static int c(ic icVar) {
        cu cuVarDp;
        if (icVar == null || (cuVarDp = icVar.dp()) == null) {
            return 0;
        }
        return cuVarDp.tt;
    }

    public static boolean c(WebView webView, AtomicInteger atomicInteger, com.byazt.omf.d dVar, String str, boolean z, boolean z2) {
        if (!str.startsWith("bytedance") && !str.startsWith("nativeapp") && !str.startsWith("bds")) {
            if (!com.byazt.aas.nb.c(str, atomicInteger) && c(webView, atomicInteger, str, true)) {
                return true;
            }
            if (dVar == null || !TextUtils.isEmpty(tt(str, ve)) || !TextUtils.isEmpty(tt(str, uj))) {
                return false;
            }
            String strTt = tt(str, sp);
            if (!TextUtils.isEmpty(strTt)) {
                tt(dVar.x(), str, strTt);
            }
            String strC = c(str, dVar.n(z2), z, z2);
            if (!TextUtils.isEmpty(strC) && da) {
                c(dVar.x(), str, strC);
            }
            if (!TextUtils.isEmpty(strC)) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(WebView webView, AtomicInteger atomicInteger, String str, boolean z) {
        if (TextUtils.isEmpty(str) || webView == null) {
            return false;
        }
        final String[] strArr = {""};
        try {
            final String path = Uri.parse(str).getPath();
            Map<String, String> map = sl;
            if (map.containsKey(path)) {
                return c(atomicInteger, map.get(path), str, webView, z);
            }
            if (!t) {
                for (String str2 : com.byazt.aas.eo.c("cloud_path_check_res").get("cloud_path_check_res", new HashSet())) {
                    if (!TextUtils.isEmpty(str2)) {
                        String[] strArrSplit = str2.split(",");
                        sl.put(strArrSplit[0], strArrSplit[1]);
                    }
                }
                Map<String, String> map2 = sl;
                if (map2.containsKey(path)) {
                    return c(atomicInteger, map2.get(path), str, webView, z);
                }
            }
            com.byazt.va.n nVarTt = com.byazt.hy.n.c().tt().tt();
            nVarTt.c(Uri.parse("https://scc.bytedance.com/scc_sdk/url_scan_v4").buildUpon().appendQueryParameter("aid", "1181").appendQueryParameter("device_platform", "android").appendQueryParameter("device_id", com.byazt.aas.z.c()).appendQueryParameter("scc_mode", "raw").appendQueryParameter("scc_from", com.ipd.dsp.internal.e1.b.F).toString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("scene", "common");
            jSONObject.put("url", str);
            jSONObject.put("extra", "");
            nVarTt.c(jSONObject);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            nVarTt.c(new com.byazt.mh.c() { // from class: com.byazt.ete.cu.1
                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                    try {
                        strArr[0] = new JSONObject(ttVar.n()).optJSONObject("data").optString("label");
                        if (TextUtils.isEmpty(strArr[0])) {
                            return;
                        }
                        if (cu.sl.size() > 1000) {
                            Iterator it = cu.sl.entrySet().iterator();
                            for (int i2 = 0; i2 < 200; i2++) {
                                it.next();
                                it.remove();
                            }
                        }
                        cu.sl.put(path, strArr[0]);
                        if (!cu.t) {
                            boolean unused = cu.t = true;
                            com.byazt.nr.da.c().postDelayed(new Runnable() { // from class: com.byazt.ete.cu.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.byazt.iy.n nVarC = com.byazt.aas.eo.c("cloud_path_check_res");
                                    nVarC.clear();
                                    HashSet hashSet = new HashSet();
                                    for (Map.Entry entry : cu.sl.entrySet()) {
                                        hashSet.add(((String) entry.getKey()) + "," + ((String) entry.getValue()));
                                    }
                                    nVarC.put("cloud_path_check_res", hashSet);
                                    boolean unused2 = cu.t = false;
                                }
                            }, 1800000L);
                        }
                    } catch (Throwable unused2) {
                    }
                    countDownLatch.countDown();
                }

                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, IOException iOException) {
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            return c(atomicInteger, strArr[0], str, webView, z);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void tt(com.byazt.it.n nVar) {
        Set<String> set = uj;
        set.addAll(nVar.get("turn_up_white_list", set));
        Set<String> set2 = n;
        set2.addAll(nVar.get("turn_up_black_list_1", set2));
        Set<String> set3 = f28484a;
        set3.addAll(nVar.get("turn_up_black_list_2", set3));
        Set<String> set4 = sp;
        set4.addAll(nVar.get("url_report_rule_list", set4));
        Set<String> set5 = x;
        set5.addAll(nVar.get("net_url_block_list", set5));
        da = nVar.get("_turn_up_is_get_list", false);
        Set<String> set6 = i;
        set6.addAll(nVar.get("dialog_black_list", set6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String tt(String str, Set<String> set) {
        if (str == null) {
            return null;
        }
        try {
            for (String str2 : set) {
                if (!TextUtils.isEmpty(str2) && Pattern.compile(str2).matcher(str).find()) {
                    return str2;
                }
            }
            return null;
        } catch (Exception e) {
            com.byazt.nr.m.uj("JumpModel", e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x0046  */
    private static boolean c(AtomicInteger atomicInteger, String str, String str2, WebView webView, boolean z) {
        byte b;
        if (webView == null || TextUtils.isEmpty(str) || atomicInteger == null) {
            return false;
        }
        if (atomicInteger.get() == 1) {
            return true;
        }
        switch (str) {
            case "unknown":
                b = 1;
                break;
            case "gray":
                b = 2;
                break;
            case "black":
                b = 0;
                break;
            case "white":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b != 0) {
            return false;
        }
        atomicInteger.set(1);
        com.byazt.aas.n.c(webView.getContext(), (String) null, true, (com.byazt.aas.n.c) null);
        return true;
    }

    public static void tt(final ic icVar, final String str, final String str2) {
        com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.ete.cu.4
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", icVar.gu());
                jSONObject2.put("cid", icVar.uj());
                jSONObject2.put("req_id", icVar.qy());
                jSONObject2.put("customer_id", com.byazt.aas.nb.yp(icVar));
                jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject2.toString());
                jSONObject.putOpt("pattern", str2);
                return com.byazt.qal.tt.tt().c("stats_url_report_rule").x(icVar.w_()).tt(jSONObject.toString());
            }
        }, "stats_url_report_rule");
    }

    public static com.byazt.gqp.i tt() {
        return new com.byazt.gqp.i() { // from class: com.byazt.ete.cu.5
            @Override // com.byazt.gqp.i
            public com.byazt.gqp.m c(com.byazt.gqp.i.c cVar) throws IOException {
                String str;
                com.byazt.gqp.m mVarC = cVar.c(cVar.c());
                String str2 = "";
                final String strC = mVarC.c("csj-location-record", "");
                final String strC2 = mVarC.c("csj-source-from", "");
                final String strC3 = mVarC.c("csj-extra-info", "");
                if (mVarC.ve() == 8848) {
                    final String strN = mVarC.n();
                    com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.ete.cu.5.1
                        @Override // com.byazt.ee.c
                        public com.byazt.qal.c c() throws Exception {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.putOpt("url", strN);
                            jSONObject.putOpt("sourceFrom", strC2);
                            jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, strC3);
                            return com.byazt.qal.tt.tt().c("stats_net_block_url").tt(jSONObject.toString());
                        }
                    }, "stats_net_block_url");
                }
                int i2 = 0;
                try {
                    String[] strArrC = cu.c(strC);
                    if (strArrC == null || strArrC.length <= 1) {
                        str = "";
                    } else {
                        String str3 = strArrC[0];
                        try {
                            str = strArrC[strArrC.length - 1];
                            str2 = str3;
                        } catch (Exception unused) {
                            str = "";
                            str2 = str3;
                        }
                    }
                    try {
                        i2 = Integer.parseInt(strC2);
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    str = "";
                }
                final String str4 = str2;
                final String str5 = str;
                if (TextUtils.isEmpty(strC) || i2 == 0 || !TextUtils.isEmpty(cu.tt(str4, cu.uj))) {
                    return mVarC;
                }
                com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.ete.cu.5.2
                    @Override // com.byazt.ee.c
                    public com.byazt.qal.c c() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("url", strC);
                        jSONObject.putOpt("sourceFrom", strC2);
                        jSONObject.putOpt("sourceUrl", str4);
                        jSONObject.putOpt("destUrl", str5);
                        jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, strC3);
                        return com.byazt.qal.tt.tt().c("stats_net_locations_url").tt(jSONObject.toString());
                    }
                }, "stats_net_locations_url");
                return mVarC;
            }
        };
    }

    public static boolean c(WebView webView, AtomicInteger atomicInteger, com.byazt.omf.d dVar, WebResourceRequest webResourceRequest, boolean z, boolean z2) {
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
            return false;
        }
        return c(webView, atomicInteger, dVar, url.toString(), z, z2);
    }

    public static boolean c(final com.byazt.omf.d dVar, final int i2, final String str) {
        final String strTt = tt(str, i);
        boolean z = (da && TextUtils.isEmpty(strTt)) ? false : true;
        final boolean z2 = z;
        com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.ete.cu.2
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("url", str);
                    jSONObject.putOpt("type", Integer.valueOf(i2));
                    jSONObject.putOpt("is_block", Boolean.valueOf(z2));
                    jSONObject.putOpt("is_get_setting", Boolean.valueOf(cu.da));
                    jSONObject.putOpt("pattern", strTt);
                    jSONObject.putOpt("customer_id", com.byazt.aas.nb.yp(dVar.x()));
                    return com.byazt.qal.tt.tt().c("stats_dialog_report_rule").x(dVar.x().w_()).tt(jSONObject.toString());
                } catch (Throwable unused) {
                    return com.byazt.qal.tt.tt();
                }
            }
        }, "stats_dialog_report_rule");
        return z;
    }

    private static String c(String str, int i2, boolean z, boolean z2) {
        boolean z3 = (!z2 || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
        if (i2 == 1) {
            if (da) {
                return tt(str, f28484a);
            }
            return null;
        }
        if (i2 == 2) {
            if (!da) {
                if (z) {
                    return "local://no-setting";
                }
                return null;
            }
            if (z3) {
                return "local://short-internal";
            }
            String strTt = tt(str, n);
            if (!TextUtils.isEmpty(strTt)) {
                return strTt;
            }
            String strTt2 = tt(str, f28484a);
            if (TextUtils.isEmpty(strTt2)) {
                return null;
            }
            return strTt2;
        }
        if (i2 != 3) {
            return null;
        }
        if (z || !da) {
            return "local://preload-setting:" + da;
        }
        if (z3) {
            return "local://short-internal";
        }
        String strTt3 = tt(str, n);
        if (!TextUtils.isEmpty(strTt3)) {
            return strTt3;
        }
        String strTt4 = tt(str, f28484a);
        if (TextUtils.isEmpty(strTt4)) {
            return null;
        }
        return strTt4;
    }

    public static void c(final ic icVar, final String str, final String str2) {
        com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.ete.cu.3
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", icVar.gu());
                jSONObject2.put("cid", icVar.uj());
                jSONObject2.put("req_id", icVar.qy());
                jSONObject2.put("customer_id", com.byazt.aas.nb.yp(icVar));
                jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject2.toString());
                jSONObject.putOpt("pattern", str2);
                return com.byazt.qal.tt.tt().c("stats_block_report").x(icVar.w_()).tt(jSONObject.toString());
            }
        }, "stats_block_report");
    }

    public static Set<String> c() {
        return x;
    }

    public static String[] c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(1, str.length() - 1).split(",");
    }
}
