package com.beizi.fusion;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static t3 f27741a = null;
    private static boolean b = false;

    public static void a(Context context, String str, t3 t3Var) {
        f27741a = t3Var;
        a4.j().a(context, str);
    }

    public static boolean b() {
        return b;
    }

    public static void c(String str) {
        a4.j().c(str);
    }

    public static void d(String str) {
        a4.j().d(str);
    }

    public static void e(String str) {
        a4.j().g = str;
    }

    public static void b(String str) {
        a4.j().b(str);
    }

    public static t3 a() {
        return f27741a;
    }

    public static void a(boolean z) {
        b = z;
    }

    public static void a(List list) {
        a4.j().a(list);
    }

    public static String a(String str) {
        return a4.j().a(str);
    }
}
