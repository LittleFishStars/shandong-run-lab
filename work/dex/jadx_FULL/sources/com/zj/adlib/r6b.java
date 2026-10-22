package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class r6b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r4b f44385a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Map<String, r6b> f44386a = new HashMap();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f44387a;
        public String b;
        public String c;

        public b(String str, String str2, String str3) {
            this.f44387a = str;
            this.b = str2;
            this.c = str3;
        }

        public static b a(JSONObject jSONObject) {
            try {
                return new b(jSONObject.optString("sdkVersion"), jSONObject.optString("cpuType"), jSONObject.optString("content"));
            } catch (Throwable unused) {
                return null;
            }
        }

        public static List<b> d(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(a(jSONArray.getJSONObject(i)));
                }
                return arrayList;
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }

        public static JSONArray e(List<b> list) {
            if (list == null) {
                return new JSONArray();
            }
            JSONArray jSONArray = new JSONArray();
            for (b bVar : list) {
                if (bVar != null) {
                    if (!TextUtils.isEmpty(bVar.c)) {
                        jSONArray.put(bVar.f());
                    }
                }
            }
            return jSONArray;
        }

        public final JSONObject f() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sdkVersion", this.f44387a);
                jSONObject.put("cpuType", this.b);
                jSONObject.put("content", this.c);
                return jSONObject;
            } catch (Throwable unused) {
                return new JSONObject();
            }
        }

        public final boolean g(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                str = this.f44387a;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.b;
            }
            return this.f44387a.equals(str) && this.b.equals(str2);
        }
    }

    public r6b(r4b r4bVar) {
        this.f44385a = r4bVar;
    }

    public static r6b a(r4b r4bVar) {
        if (r4bVar == null || TextUtils.isEmpty(r4bVar.a())) {
            return null;
        }
        if (a.f44386a.get(r4bVar.a()) == null) {
            a.f44386a.put(r4bVar.a(), new r6b(r4bVar));
        }
        return a.f44386a.get(r4bVar.a());
    }

    public static String b(Context context, String str, String str2) {
        return e(context, "C7ADB20F22F238708BA5EE26D0401DB9" + p4b.d(str), "ik".concat(String.valueOf(str2)));
    }

    public static String e(Context context, String str, String str2) {
        return (context == null || TextUtils.isEmpty(str2)) ? "" : s4b.g(i4b.e(s4b.z(context.getSharedPreferences(str, 0).getString(str2, ""))));
    }

    public static void f(Context context, String str, String str2, String str3) {
        if (str3 == null || TextUtils.isEmpty(str)) {
            return;
        }
        g(context, "C7ADB20F22F238708BA5EE26D0401DB9" + p4b.d(str), "ik".concat(String.valueOf(str2)), str3);
    }

    public static void g(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        String strF = s4b.F(i4b.c(s4b.p(str3)));
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putString(str2, strF);
        editorEdit.commit();
    }

    public final String c(Context context, String str, String str2, String str3) {
        r4b r4bVar;
        if (context != null && (r4bVar = this.f44385a) != null && !TextUtils.isEmpty(r4bVar.a())) {
            List<b> listD = b.d(b(context, this.f44385a.a(), str3));
            if (listD.size() == 0) {
                return "";
            }
            for (int i = 0; i < listD.size(); i++) {
                b bVar = listD.get(i);
                if (bVar.g(str, str2)) {
                    return bVar.c;
                }
            }
        }
        return null;
    }

    public final void d(Context context, String str, String str2, String str3, String str4) {
        r4b r4bVar;
        if (context == null || (r4bVar = this.f44385a) == null || TextUtils.isEmpty(r4bVar.a())) {
            return;
        }
        List<b> listD = b.d(b(context, this.f44385a.a(), str3));
        for (int i = 0; i < listD.size(); i++) {
            b bVar = listD.get(i);
            if (bVar.g(str, str2)) {
                bVar.c = str4;
                f(context, this.f44385a.a(), str3, b.e(listD).toString());
                return;
            }
        }
        listD.add(new b(str, str2, str4));
        f(context, this.f44385a.a(), str3, b.e(listD).toString());
    }
}
