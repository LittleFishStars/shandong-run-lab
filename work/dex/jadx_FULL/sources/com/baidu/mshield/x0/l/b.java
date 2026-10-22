package com.baidu.mshield.x0.l;

import com.baidu.mshield.x0.d.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f26754a;
    public String b;
    public String c;
    public String d;
    public String e;

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f26754a = jSONObject.optString("0");
            bVar.c = jSONObject.optString("1");
            bVar.d = jSONObject.optString("2");
            bVar.e = jSONObject.optString("3");
            bVar.b = jSONObject.optString("4");
            return bVar;
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
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
            b bVar = (b) obj;
            String str = this.d;
            if (str == null) {
                if (bVar.d != null) {
                    return false;
                }
            } else if (!str.equals(bVar.d)) {
                return false;
            }
            String str2 = this.e;
            if (str2 == null) {
                if (bVar.e != null) {
                    return false;
                }
            } else if (!str2.equals(bVar.e)) {
                return false;
            }
            String str3 = this.b;
            if (str3 == null) {
                if (bVar.b != null) {
                    return false;
                }
            } else if (!str3.equals(bVar.b)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public int hashCode() {
        int iHashCode = 1;
        try {
            String str = this.d;
            int iHashCode2 = 0;
            int iHashCode3 = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.e;
            iHashCode = (str2 == null ? 0 : str2.hashCode()) + iHashCode3;
            int i = iHashCode * 31;
            String str3 = this.b;
            if (str3 != null) {
                iHashCode2 = str3.hashCode();
            }
            return i + iHashCode2;
        } catch (Throwable th) {
            d.a(th);
            return iHashCode;
        }
    }
}
