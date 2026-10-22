package com.byazt.cz;

import android.text.TextUtils;
import com.byazt.ly.uj;
import com.byazt.nr.m;
import com.byazt.px.tt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 605, 20})
public class c {
    public static final ArrayList<C0381c> c = new ArrayList<>();
    public static final String[] tt;
    public static final ArrayList<String> uj;
    public static final ArrayList<String> ve;

    /* JADX INFO: renamed from: com.byazt.cz.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 605, 44})
    public static class C0381c {
        public String c;
        public int tt;
        public String ve;

        public C0381c(String str, int i, String str2) {
            this.c = str;
            this.tt = i;
            this.ve = str2;
        }
    }

    static {
        String[] strArr = {"TTTransparentActivity", "openadsdk", "com.byazt.mta", "com.qq", "com.kwad", "baidu", "mbridge", "sigmob", MediationConstant.ADN_UNITY, MediationConstant.ADN_KLEVIN};
        tt = strArr;
        ve = new ArrayList<>(Arrays.asList(strArr));
        uj = new ArrayList<>();
    }

    public static boolean c(String str, int i, int i2) {
        ArrayList<C0381c> arrayList = c;
        if (arrayList.size() <= 0) {
            return TextUtils.equals("baidu", str);
        }
        for (C0381c c0381c : arrayList) {
            if (c0381c != null && TextUtils.equals(c0381c.c, str) && i2 == c0381c.tt) {
                String str2 = c0381c.ve;
                uj ujVarC = tt.c().c(str);
                String networkSdkVersion = ujVarC != null ? ujVarC.getNetworkSdkVersion() : null;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(networkSdkVersion)) {
                    if (str2.startsWith("<=")) {
                        return c(networkSdkVersion, str2);
                    }
                    if (str2.startsWith(">=")) {
                        return tt(networkSdkVersion, str2);
                    }
                }
            }
        }
        return false;
    }

    private static boolean tt(String str, String str2) {
        return ve(str, str2) >= 0;
    }

    private static int ve(String str, String str2) {
        String strSubstring = str2.substring(2);
        if (str.startsWith("v") || str.startsWith("V")) {
            str = str.substring(1);
        }
        return str.compareTo(strSubstring);
    }

    public static boolean tt(String str) {
        com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- activityStr: ".concat(String.valueOf(str)));
        Iterator<String> it = ve.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return ve(str);
            }
        }
        return false;
    }

    private static boolean ve(String str) {
        ArrayList<String> arrayList = uj;
        if (arrayList.size() == 0) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean c(String str, String str2) {
        return ve(str, str2) <= 0;
    }

    public static void c(String str) {
        ArrayList<String> arrayList;
        List listAsList;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                ve.clear();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("act_str");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i);
                        if (!TextUtils.isEmpty(strOptString)) {
                            ve.add(strOptString);
                        }
                    }
                }
                uj.clear();
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("not_act_str");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                        if (!TextUtils.isEmpty(strOptString2)) {
                            uj.add(strOptString2);
                        }
                    }
                }
                c.clear();
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("not_support");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray3.optJSONObject(i3);
                        if (jSONObjectOptJSONObject != null) {
                            c.add(new C0381c(jSONObjectOptJSONObject.optString("adn"), jSONObjectOptJSONObject.optInt("subtype"), jSONObjectOptJSONObject.optString("versions")));
                        }
                    }
                }
                arrayList = ve;
                listAsList = Arrays.asList(tt);
            } catch (JSONException e) {
                m.c(e);
                arrayList = ve;
                listAsList = Arrays.asList(tt);
            }
            arrayList.addAll(listAsList);
        } catch (Throwable th) {
            ve.addAll(Arrays.asList(tt));
            throw th;
        }
    }
}
