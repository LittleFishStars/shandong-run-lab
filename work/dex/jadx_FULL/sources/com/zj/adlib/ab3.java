package com.zj.adlib;

import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ab3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40500a = 2018001;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f15236a = "ExoPlayerLib";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean f15238a = true;
    public static final String b = "2.18.1";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final boolean f15239b = true;
    public static final String c = "ExoPlayerLib/2.18.1";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final HashSet<String> f15237a = new HashSet<>();
    public static String d = "goog.exo.core";

    public static synchronized void a(String str) {
        if (f15237a.add(str)) {
            d += ", " + str;
        }
    }

    public static synchronized String b() {
        return d;
    }
}
