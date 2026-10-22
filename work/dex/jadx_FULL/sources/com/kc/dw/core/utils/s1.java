package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class s1 {
    public static void a(String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (str != null && str.length() > 0) {
                            z.a(com.kc.dw.base.a.getContext(), str.replace("__MS_EVENT__", "14").replace("__MS_EVENT_MSEC__", String.valueOf(System.currentTimeMillis())).replace("__ERROR_CODE__", "").replace("__ERROR_MESSAGE__", ""), new j());
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(String[] strArr, int i, int i2, String str) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str2 : strArr) {
                        if (str2 != null && str2.length() > 0) {
                            z.a(com.kc.dw.base.a.getContext(), str2.replace("__MS_EVENT__", String.valueOf(i)).replace("__MS_EVENT_MSEC__", String.valueOf(System.currentTimeMillis())).replace("__ERROR_CODE__", g0.b(String.valueOf(i2))).replace("__ERROR_MESSAGE__", g0.b(str)), new j());
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(String[] strArr, String str) {
        if (p0.k > 0) {
            a(strArr, 12, 9000000, str);
        }
    }

    public static boolean a(String str, int i, int i2) {
        long jA = r.a().a("adg_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jA < ((long) i2) * 1000) {
            return false;
        }
        r rVarA = r.a();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_adp");
        return jCurrentTimeMillis - rVarA.a(sb.toString(), 0L) >= ((long) i) * 1000;
    }

    public static void b(String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (str != null && str.length() > 0) {
                            z.a(com.kc.dw.base.a.getContext(), str.replace("__MS_EVENT__", "11").replace("__MS_EVENT_MSEC__", String.valueOf(System.currentTimeMillis())).replace("__ERROR_CODE__", "").replace("__ERROR_MESSAGE__", ""), new j());
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
