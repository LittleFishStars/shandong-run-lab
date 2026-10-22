package com.alipay.sdk.m.e;

import android.util.Log;
import com.zj.adlib.c49;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25429a = "OpenId";
    public static boolean b = false;

    public static void a(boolean z) {
        Log.d(f25429a, "setDebug:" + z);
        b = z;
    }

    public static void b(String str, Object... objArr) {
        if (b) {
            Log.d(f25429a, a(str, objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (b) {
            Log.e(f25429a, a(str, objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        if (b) {
            Log.i(f25429a, a(str, objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        if (b) {
            Log.w(f25429a, a(str, objArr));
        }
    }

    public static String a(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = c49.f40900a;
        }
        int i = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(a(objArr[i], objArr[i2]));
                if (i2 < length - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }

    public static String a(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }
}
