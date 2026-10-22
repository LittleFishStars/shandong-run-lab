package com.zj.adlib;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class f15 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41568a = "HCJ";

    public static File a(Context context, String str) {
        File file = new File(context.getCacheDir().getPath() + File.separator + str);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
        return file;
    }

    public static o41 b(Context context) {
        o41 o41VarG = c25.G();
        o41VarG.k(a(context, "log"));
        o41VarG.i(31);
        o41VarG.g(31);
        o41VarG.s(f41568a);
        o41VarG.e(7);
        o41VarG.f(new ei4("192.168.2.128", 9085, 9084, 9083));
        o41VarG.c(true);
        o41VarG.r(false);
        o41VarG.q(true);
        o41VarG.o(true);
        o41VarG.m(true);
        o41VarG.n(true);
        o41VarG.p(true);
        return o41VarG;
    }
}
