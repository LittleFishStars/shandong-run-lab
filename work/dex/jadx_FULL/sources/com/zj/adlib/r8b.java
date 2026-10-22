package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class r8b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f44399a;
    public static byte[] b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f19248a;

    public r8b(String str) {
        this.f19248a = p4b.d(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public static int a(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            a7b.m(th, "csp", "giv");
            return i;
        }
    }

    public static SharedPreferences.Editor b(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (Throwable th) {
                v6b.b(th, RVParams.SHOW_PROGRESS, "ge");
            }
        }
        return null;
    }

    public static String c(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return s4b.g(q(context, s4b.z(context.getSharedPreferences(str, 0).getString(str2, ""))));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void d(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putString(str2, s4b.F(m(context, s4b.p(str3))));
            e(editorEdit);
        } catch (Throwable unused) {
        }
    }

    public static void e(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.apply();
        } catch (Throwable th) {
            v6b.b(th, RVParams.SHOW_PROGRESS, "cm");
        }
    }

    public static void f(SharedPreferences.Editor editor, String str) {
        if (editor != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                editor.remove(str);
            } catch (Throwable th) {
                v6b.b(th, RVParams.SHOW_PROGRESS, "rk");
            }
        }
    }

    public static void g(SharedPreferences.Editor editor, String str, int i) {
        try {
            editor.putInt(str, i);
        } catch (Throwable th) {
            a7b.m(th, "csp", "putPrefsInt");
        }
    }

    public static void h(SharedPreferences.Editor editor, String str, long j) {
        if (editor == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            editor.putLong(str, j);
        } catch (Throwable th) {
            a7b.m(th, "csp", "plv");
        }
    }

    public static void i(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th) {
                v6b.b(th, RVParams.SHOW_PROGRESS, "ps");
            }
        }
    }

    public static void j(SharedPreferences.Editor editor, String str, boolean z) {
        try {
            editor.putBoolean(str, z);
        } catch (Throwable th) {
            a7b.m(th, "csp", "setPrefsStr");
        }
    }

    public static boolean k(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            a7b.m(th, "csp", "gbv");
            return z;
        }
    }

    public static byte[] l(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = f44399a;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bytes = j4b.j(context).getBytes();
        f44399a = bytes;
        return bytes;
    }

    public static byte[] m(Context context, byte[] bArr) {
        try {
            return m4b.h(l(context), bArr, p(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static long n(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, 0L);
        } catch (Throwable th) {
            a7b.m(th, "csp", "glv");
            return 0L;
        }
    }

    public static String o(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            a7b.m(th, "csp", "gsv");
            return str3;
        }
    }

    public static byte[] p(Context context) {
        byte[] bArr = b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(l(context), 0, l(context).length / 2);
        b = bArrCopyOfRange;
        return bArrCopyOfRange;
    }

    public static byte[] q(Context context, byte[] bArr) {
        try {
            return m4b.e(l(context), bArr, p(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
