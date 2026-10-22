package com.zj.adlib;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class y91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static z91 f45978a;

    public static void a() {
        b(i());
    }

    public static void b(@NonNull z91 z91Var) {
        z91Var.a();
    }

    public static <T> T c(@NonNull String str) {
        return (T) d(str, i());
    }

    public static <T> T d(@NonNull String str, @NonNull z91 z91Var) {
        return (T) z91Var.b(str);
    }

    public static <T> T e(@NonNull String str, T t) {
        return (T) f(str, t, i());
    }

    public static <T> T f(@NonNull String str, T t, @NonNull z91 z91Var) {
        return (T) z91Var.c(str, t);
    }

    public static int g() {
        return h(i());
    }

    public static int h(@NonNull z91 z91Var) {
        return z91Var.d();
    }

    public static z91 i() {
        z91 z91Var = f45978a;
        return z91Var != null ? z91Var : z91.e();
    }

    public static void j(@NonNull String str, Object obj) {
        m(str, obj, i());
    }

    public static void k(@NonNull String str, Object obj, int i) {
        l(str, obj, i, i());
    }

    public static void l(@NonNull String str, Object obj, int i, @NonNull z91 z91Var) {
        z91Var.i(str, obj, i);
    }

    public static void m(@NonNull String str, Object obj, @NonNull z91 z91Var) {
        z91Var.h(str, obj);
    }

    public static Object n(@NonNull String str) {
        return o(str, i());
    }

    public static Object o(@NonNull String str, @NonNull z91 z91Var) {
        return z91Var.j(str);
    }

    public static void p(z91 z91Var) {
        f45978a = z91Var;
    }
}
