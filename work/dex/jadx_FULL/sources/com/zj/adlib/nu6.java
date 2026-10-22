package com.zj.adlib;

import android.util.SparseIntArray;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class nu6 {
    public static final int f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseIntArray f18513a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public nu6(int i, @Nullable SparseIntArray sparseIntArray) {
        this(i, i, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public nu6(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public nu6(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        ax6.o(i >= 0 && i2 >= i);
        this.b = i;
        this.f43610a = i2;
        this.f18513a = sparseIntArray;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }
}
