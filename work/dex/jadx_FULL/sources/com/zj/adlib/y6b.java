package com.zj.adlib;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.amap.api.col.p0003l.go;
import com.amap.api.col.p0003l.it;
import com.amap.api.col.p0003l.z;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class y6b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f45964a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f20807a = "/a/";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Vector<r4b> f20808a = new Vector<>();
    public static final String b = "b";
    public static final String c = "c";
    public static final String d = "d";
    public static String e = "s";
    public static final String f = "g";
    public static final String g = "h";
    public static final String h = "e";
    public static final String i = "f";
    public static final String j = "j";
    public static final String k = "k";

    public static class a extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f45965a;

        public a(Context context) {
            this.f45965a = context;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            try {
                go.o(this.f45965a);
                go.q(this.f45965a);
                go.p(this.f45965a);
                mbb.b(this.f45965a);
                o9b.d(this.f45965a);
            } catch (RejectedExecutionException unused) {
            } catch (Throwable th) {
                a7b.m(th, "Lg", "proL");
            }
        }
    }

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    public static List<r4b> b() {
        Vector<r4b> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = f20808a;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return f20808a;
        }
    }

    public static void c(Context context) {
        try {
            if (System.currentTimeMillis() - f45964a < 60000) {
                return;
            }
            f45964a = System.currentTimeMillis();
            z.g().b(new a(context));
        } catch (Throwable th) {
            a7b.m(th, "Lg", "proL");
        }
    }

    @TargetApi(9)
    public static void d(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public static void e(r4b r4bVar) {
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    if (r4bVar == null) {
                        return;
                    }
                    if (f20808a.contains(r4bVar)) {
                        return;
                    }
                    f20808a.add(r4bVar);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean f(String[] strArr, String str) {
        if (strArr != null && str != null) {
            try {
                String[] strArrSplit = str.split("\n");
                int length = strArrSplit.length;
                int i2 = 0;
                while (true) {
                    boolean z = true;
                    if (i2 < length) {
                        String strTrim = strArrSplit[i2].trim();
                        if (TextUtils.isEmpty(strTrim) || !strTrim.startsWith("at ") || !strTrim.contains("uncaughtException")) {
                            z = false;
                        }
                        if (z) {
                            return false;
                        }
                        i2++;
                    } else {
                        for (String str2 : strArrSplit) {
                            if (h(strArr, str2.trim())) {
                                return true;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static void g(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public static boolean h(String[] strArr, String str) {
        if (strArr != null && str != null) {
            try {
                for (String str2 : strArr) {
                    str = str.trim();
                    if (str.startsWith("at ")) {
                        if (str.contains(str2 + Consts.DOT) && str.endsWith(")") && !str.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static String i(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f20807a + str;
    }
}
