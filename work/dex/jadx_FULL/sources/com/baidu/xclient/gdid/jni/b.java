package com.baidu.xclient.gdid.jni;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.xclient.gdid.e;
import com.baidu.xclient.gdid.j.d;
import com.google.android.exoplayer2.source.rtsp.j;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f26839a;
    public c b;
    public Context c;

    public b(Context context) {
        this.c = context;
        this.b = c.a(context);
    }

    public static b a(Context context) {
        if (f26839a == null) {
            synchronized (b.class) {
                if (f26839a == null) {
                    f26839a = new b(context);
                }
            }
        }
        return f26839a;
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject(e.e().k());
            JSONObject jSONObject2 = new JSONObject();
            a(jSONObject2);
            a(jSONObject2, jSONObject);
            b(jSONObject2, jSONObject);
            a(this.c, jSONObject2, jSONObject);
            c(jSONObject2, jSONObject);
            a(this.c, jSONObject2, true);
            a(this.c, jSONObject2, false);
            a(jSONObject2, true);
            a(jSONObject2, false);
            byte[] bArrA = this.b.a(jSONObject2.toString().getBytes());
            return bArrA == null ? "" : Base64.encodeToString(bArrA, 10);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public final JSONObject a(Context context, JSONObject jSONObject, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            int i3 = 1;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (i3 < i) {
                    i3++;
                } else {
                    if (i3 >= i + i2) {
                        break;
                    }
                    i3++;
                    String strOptString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(strOptString)) {
                        PackageInfo packageInfoA = com.baidu.mshield.b.e.c.a(context, strOptString, 0);
                        JSONObject jSONObject3 = new JSONObject();
                        if (packageInfoA == null) {
                            jSONObject3.put("0", -1);
                            jSONObject3.put("1", "");
                            jSONObject3.put("2", 0);
                            jSONObject3.put("3", 0);
                        } else {
                            jSONObject3.put("0", 0);
                            jSONObject3.put("1", packageInfoA.versionName);
                            jSONObject3.put("2", packageInfoA.firstInstallTime);
                            jSONObject3.put("3", packageInfoA.lastUpdateTime);
                        }
                        jSONObject2.put(next, jSONObject3);
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return jSONObject2;
    }

    public final JSONObject a(JSONObject jSONObject, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            int i3 = 1;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (i3 < i) {
                    i3++;
                } else {
                    if (i3 >= i + i2) {
                        break;
                    }
                    i3++;
                    String strOptString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(strOptString)) {
                        jSONObject2.put(next, new JSONObject(this.b.a(strOptString)));
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return jSONObject2;
    }

    public final void a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        PackageInfo packageInfoA;
        try {
            if (!a.a(this.c, jSONObject2, "1", 0, 1, jSONObject2.optInt("4", 0)) || (packageInfoA = com.baidu.mshield.b.e.c.a(context, com.baidu.xclient.gdid.d.a().a(context), 0)) == null) {
                jSONObject.put(String.valueOf(20), 0);
            } else {
                jSONObject.put(String.valueOf(20), packageInfoA.firstInstallTime);
            }
            a(jSONObject, 52, this.b.d());
            jSONObject.put(String.valueOf(54), this.b.c());
            a(jSONObject, 58, this.b.b());
            String[] strArrA = a.a(this.b.b("/proc/cpuinfo"));
            a(jSONObject, 60, strArrA[0]);
            a(jSONObject, 61, strArrA[1]);
            jSONObject.put(String.valueOf(62), d.c());
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(Context context, JSONObject jSONObject, boolean z) {
        String strR;
        int iOptInt;
        int iZ;
        int i;
        try {
            JSONObject jSONObject2 = new JSONObject(e.e().k());
            int i2 = 20;
            if (z) {
                strR = jSONObject2.optString("9");
                iOptInt = jSONObject2.optInt("x", 20);
                iZ = e.e().A();
                i = 22;
            } else {
                strR = e.e().r();
                iOptInt = jSONObject2.optInt("y", 20);
                iZ = e.e().z();
                i = 21;
            }
            String strD = strR;
            int i3 = iZ;
            int i4 = i;
            if (iOptInt <= 20 && iOptInt != 0) {
                i2 = iOptInt;
            }
            if (a.a(this.c, jSONObject2, "", 0, 1, jSONObject2.optInt("4", 0))) {
                if (!TextUtils.isEmpty(strD)) {
                    strD = this.b.d(strD);
                }
                if (TextUtils.isEmpty(strD)) {
                    jSONObject.put(String.valueOf(i4), new JSONObject());
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(strD);
                int length = jSONObject3.length();
                Pair<Integer, Integer> pairA = a.a(i3, length, i2);
                int iIntValue = ((Integer) pairA.first).intValue();
                int iIntValue2 = ((Integer) pairA.second).intValue();
                jSONObject.put(String.valueOf(i4), a(context, jSONObject3, iIntValue, iIntValue2));
                int i5 = iIntValue + iIntValue2;
                if (i5 <= length) {
                    length = i5;
                }
                if (z) {
                    e.e().h(length);
                } else {
                    e.e().g(length);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            a(jSONObject, 3, this.b.f());
            a(jSONObject, 4, com.baidu.xclient.gdid.d.a().c("mod"));
            a(jSONObject, 5, this.b.k());
            a(jSONObject, 6, this.b.j());
            a(jSONObject, 7, this.b.i());
            a(jSONObject, 8, this.b.h());
            a(jSONObject, 9, this.b.g());
            a(jSONObject, 50, this.b.c("ro.build.fingerprint"));
            a(jSONObject, 53, com.baidu.xclient.gdid.d.a().c("arv"));
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, int i, String str) {
        try {
            String strValueOf = String.valueOf(i);
            if (str == null) {
                str = "";
            }
            jSONObject.put(strValueOf, str);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (a.a(this.c, jSONObject2, "2", 0, 1, jSONObject2.optInt("4", 0))) {
                String[] strArrSplit = this.b.e(Environment.getExternalStorageDirectory().getAbsolutePath()).split("\\|");
                if (TextUtils.isEmpty(strArrSplit[0])) {
                    jSONObject.put(String.valueOf(10), 0);
                } else {
                    jSONObject.put(String.valueOf(10), Long.valueOf(strArrSplit[0]));
                }
                if (!TextUtils.isEmpty(strArrSplit[1])) {
                    jSONObject.put(String.valueOf(11), Long.valueOf(strArrSplit[1]));
                    return;
                }
            } else {
                jSONObject.put(String.valueOf(10), 0);
            }
            jSONObject.put(String.valueOf(11), 0);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, boolean z) {
        boolean zA;
        String strS;
        int iOptInt;
        int iA;
        int i;
        try {
            JSONObject jSONObject2 = new JSONObject(e.e().k());
            int iOptInt2 = jSONObject2.optInt("4", 0);
            int i2 = 20;
            if (z) {
                zA = a.a(this.c, jSONObject2, "", 0, 1, iOptInt2);
                strS = jSONObject2.optString("10");
                iOptInt = jSONObject2.optInt("u", 20);
                iA = e.e().b();
                i = 59;
            } else {
                zA = a.a(this.c, jSONObject2, "", 0, 1, iOptInt2);
                strS = e.e().s();
                iOptInt = jSONObject2.optInt(j.o, 20);
                iA = e.e().a();
                i = 56;
            }
            if (iOptInt <= 20 && iOptInt != 0) {
                i2 = iOptInt;
            }
            if (zA) {
                if (!TextUtils.isEmpty(strS)) {
                    strS = this.b.d(strS);
                }
                if (TextUtils.isEmpty(strS)) {
                    jSONObject.put(String.valueOf(i), new JSONObject());
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(strS);
                int length = jSONObject3.length();
                Pair<Integer, Integer> pairA = a.a(iA, length, i2);
                int iIntValue = ((Integer) pairA.first).intValue();
                int iIntValue2 = ((Integer) pairA.second).intValue();
                jSONObject.put(String.valueOf(i), a(jSONObject3, iIntValue, iIntValue2));
                int i3 = iIntValue + iIntValue2;
                if (i3 <= length) {
                    length = i3;
                }
                if (z) {
                    e.e().j(length);
                } else {
                    e.e().i(length);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void b(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (a.a(this.c, jSONObject2, "2", 0, 1, jSONObject2.optInt("4", 0))) {
                String[] strArrSplit = this.b.e(Environment.getDataDirectory().getAbsolutePath()).split("\\|");
                if (TextUtils.isEmpty(strArrSplit[0])) {
                    jSONObject.put(String.valueOf(12), 0);
                } else {
                    jSONObject.put(String.valueOf(12), Long.valueOf(strArrSplit[0]));
                }
                if (!TextUtils.isEmpty(strArrSplit[1])) {
                    jSONObject.put(String.valueOf(13), Long.valueOf(strArrSplit[1]));
                    return;
                }
            } else {
                jSONObject.put(String.valueOf(12), 0);
            }
            jSONObject.put(String.valueOf(13), 0);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void c(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (a.a(this.c, jSONObject2, "s", 1, 1, jSONObject2.optInt("4", 0))) {
                String strC = com.baidu.xclient.gdid.d.a().c("sl");
                if (TextUtils.isEmpty(strC)) {
                    jSONObject.put(String.valueOf(57), 0);
                } else if (TextUtils.isEmpty(strC)) {
                    jSONObject.put(String.valueOf(57), 0);
                } else {
                    jSONObject.put(String.valueOf(57), com.baidu.mshield.b.f.c.a(strC));
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
