package com.alibaba.analytics.core.a;

import android.net.Uri;
import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.analytics.a.u;
import com.zj.adlib.bv9;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static p f23765a;
    private String[] b = {"B01N16"};
    private List<q> d = new LinkedList();
    private Map<String, String> t = new HashMap();
    private String P = null;

    private p() {
    }

    public static synchronized p a() {
        if (f23765a == null) {
            f23765a = new p();
        }
        return f23765a;
    }

    private void g(String str, String str2) {
        com.alibaba.analytics.a.j.d("UTMCTPKBiz", "", "pConfName", str, "pConfContent", str2);
        if (u.isEmpty(str2)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("kn") && !jSONObjectOptJSONObject.isNull("kn")) {
                    String string = jSONObjectOptJSONObject.getString("kn");
                    if (!"a".equals(string)) {
                        q qVar = new q();
                        String strOptString = jSONObjectOptJSONObject.optString("v");
                        if (u.isEmpty(strOptString)) {
                            strOptString = "${" + string + "}";
                        }
                        String strOptString2 = jSONObjectOptJSONObject.optString(com.alipay.sdk.m.w.a.u, "far");
                        qVar.s(string);
                        qVar.u(strOptString);
                        qVar.t(strOptString2);
                        this.d.add(qVar);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void addTPKCache(String str, String str2) {
        if (!u.isEmpty(str)) {
            if (str2 == null) {
                this.t.remove(str);
            } else {
                this.t.put(str, str2);
            }
        }
    }

    public synchronized void addTPKItem(q qVar) {
        if (qVar != null) {
            this.d.add(qVar);
        }
    }

    public synchronized void sessionTimeout() {
        this.t.clear();
    }

    private String a(String str, Uri uri, Map<String, String> map) {
        String str2;
        if (u.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("${url|") && str.length() > 7) {
            String strSubstring = str.substring(6, str.length() - 1);
            if (!u.isEmpty(strSubstring) && uri != null) {
                return uri.getQueryParameter(strSubstring);
            }
        } else if (str.startsWith("${ut|") && str.length() > 6) {
            String strSubstring2 = str.substring(5, str.length() - 1);
            if (!u.isEmpty(strSubstring2) && map != null) {
                return map.get(strSubstring2);
            }
        } else {
            if (!str.startsWith("${") || str.length() <= 3) {
                return str;
            }
            String strSubstring3 = str.substring(2, str.length() - 1);
            if (!u.isEmpty(strSubstring3)) {
                if (map != null && (str2 = map.get(strSubstring3)) != null) {
                    return str2;
                }
                if (uri != null) {
                    return uri.getQueryParameter(strSubstring3);
                }
            }
        }
        return null;
    }

    public synchronized String a(Uri uri, Map<String, String> map) {
        String value;
        String str = g.a().get("tpk_md5");
        com.alibaba.analytics.a.j.d("UTTPKBiz", "tpk_md5", str);
        if (str != null && !str.equals(this.P) && (value = AnalyticsMgr.getValue("tpk_string")) != null) {
            g(null, value);
            this.P = "" + value.hashCode();
        }
        for (q qVar : this.d) {
            String strR = qVar.r();
            String type = qVar.getType();
            String strS = qVar.s();
            if (u.isEmpty(strR)) {
                return null;
            }
            if (u.isEmpty(this.t.get(strR))) {
                String strA = a(strS, uri, map);
                if (!u.isEmpty(strA)) {
                    this.t.put(strR, strA);
                }
            } else if (!"far".equals(type)) {
                String strA2 = a(strS, uri, map);
                if (!u.isEmpty(strA2)) {
                    this.t.put(strR, strA2);
                }
            }
        }
        if (!this.t.containsKey("ttid") && !u.isEmpty(com.alibaba.analytics.core.a.a().b())) {
            this.t.put("ttid", com.alibaba.analytics.core.a.a().b());
        }
        if (this.t.size() <= 0) {
            return null;
        }
        return bv9.b + u.c(this.t) + "}";
    }
}
