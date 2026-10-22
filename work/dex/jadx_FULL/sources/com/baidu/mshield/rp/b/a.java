package com.baidu.mshield.rp.b;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f26712a;
    public String b;
    public String c;
    public String d;
    public String e;

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", aVar.f26712a);
            jSONObject.put("1", aVar.c);
            jSONObject.put("2", aVar.d);
            jSONObject.put("3", aVar.e);
            jSONObject.put("4", aVar.b);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return jSONObject.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        try {
            if (getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            String str = this.d;
            if (str == null) {
                if (aVar.d != null) {
                    return false;
                }
            } else if (!str.equals(aVar.d)) {
                return false;
            }
            String str2 = this.e;
            if (str2 == null) {
                if (aVar.e != null) {
                    return false;
                }
            } else if (!str2.equals(aVar.e)) {
                return false;
            }
            String str3 = this.b;
            if (str3 == null) {
                if (aVar.b != null) {
                    return false;
                }
            } else if (!str3.equals(aVar.b)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public int hashCode() {
        int iHashCode = 0;
        try {
            String str = this.d;
            int iHashCode2 = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.e;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.b;
            if (str3 != null) {
                iHashCode = str3.hashCode();
            }
            return iHashCode3 + iHashCode;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return 0;
        }
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f26712a = jSONObject.optString("0");
            aVar.c = jSONObject.optString("1");
            aVar.d = jSONObject.optString("2");
            aVar.e = jSONObject.optString("3");
            aVar.b = jSONObject.optString("4");
            return aVar;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }
}
