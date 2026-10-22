package com.zj.adlib;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class gg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41897a = 4194304;
    public static final int b = 131072;
    public static final int c = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray a(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static nu6 b() {
        int i = c;
        return new nu6(4194304, i * 4194304, a(131072, 4194304, i), 131072, 4194304, i);
    }
}
