package com.byazt.ete;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 517})
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<g> f28499a;
    public int c;
    public String n;
    public String tt;
    public String uj;
    public String ve;

    public l(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.c = 0;
        this.ve = "再看一个获取";
        this.uj = "更多奖励";
        this.f28499a = new ArrayList<>();
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("play_again")) == null) {
            return;
        }
        this.c = jSONObjectOptJSONObject.optInt("again_type", 0);
        this.ve = jSONObjectOptJSONObject.optString("entrance_prefix", "再看一个获取");
        this.uj = jSONObjectOptJSONObject.optString("entrance_suffix", "更多奖励");
        this.tt = jSONObjectOptJSONObject.optString("pre_sessions");
        this.n = jSONObjectOptJSONObject.optString("play_again_rit");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("again_dialog_config");
        if (jSONArrayOptJSONArray != null) {
            this.f28499a = new ArrayList<>();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    this.f28499a.add(new g(jSONObjectOptJSONObject2));
                }
            }
        }
    }

    private static l a(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.ef();
    }

    public static ArrayList<g> n(ic icVar) {
        l lVarA = a(icVar);
        return lVarA != null ? lVarA.f28499a : new ArrayList<>();
    }

    public static boolean tt(ic icVar) {
        l lVarA = a(icVar);
        if (lVarA == null) {
            return false;
        }
        int i = lVarA.c;
        return (i == 1 || i == 3) && c(icVar);
    }

    public static String uj(ic icVar) {
        l lVarA = a(icVar);
        if (lVarA == null) {
            return null;
        }
        return lVarA.n;
    }

    public static String ve(ic icVar) {
        l lVarA = a(icVar);
        if (lVarA == null) {
            return null;
        }
        return lVarA.tt;
    }

    public void c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("again_type", this.c);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        try {
            jSONObject2.put("entrance_prefix", this.ve);
        } catch (JSONException e2) {
            com.byazt.nr.m.c(e2);
        }
        try {
            jSONObject2.put("entrance_suffix", this.uj);
        } catch (JSONException e3) {
            com.byazt.nr.m.c(e3);
        }
        try {
            jSONObject2.put("pre_sessions", this.tt);
        } catch (JSONException e4) {
            com.byazt.nr.m.c(e4);
        }
        try {
            jSONObject2.put("play_again_rit", this.n);
        } catch (JSONException e5) {
            com.byazt.nr.m.c(e5);
        }
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList<g> arrayList = this.f28499a;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<g> it = this.f28499a.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().c());
                }
            }
            jSONObject2.put("again_dialog_config", jSONArray);
            try {
                jSONObject.put("play_again", jSONObject2);
            } catch (JSONException e6) {
                com.byazt.nr.m.c(e6);
            }
        } catch (JSONException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static String tt(String str) {
        return str + "custom_again";
    }

    public static boolean c(ic icVar) {
        l lVarA = a(icVar);
        if (lVarA == null || lt.c(icVar)) {
            return false;
        }
        int i = lVarA.c;
        return (i == 1 || i == 2 || i == 3) && !TextUtils.isEmpty(lVarA.tt);
    }

    public static String c(String str) {
        return str + "again";
    }

    public static String c(ic icVar, String str, String str2) {
        l lVarA = a(icVar);
        if (lVarA == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return "再看一个获取更多奖励";
            }
            return "再看一个获取" + str2 + str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(lVarA.ve) ? "再看一个获取" : lVarA.ve);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            sb.append(TextUtils.isEmpty(lVarA.uj) ? "更多奖励" : lVarA.uj);
        } else {
            sb.append(str2);
            sb.append(str);
        }
        return sb.toString();
    }
}
