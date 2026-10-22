package com.zj.adlib;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ue2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45126a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f20048a = new SparseIntArray(0);

    public static nu6 a() {
        return new nu6(0, b(), f20048a);
    }

    public static int b() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return iMin > 16777216 ? (iMin / 4) * 3 : iMin / 2;
    }
}
