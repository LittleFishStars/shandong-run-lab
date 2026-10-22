package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class bh3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40752a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f15525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xg7[] f15526a;

    public bh3(int i, int[] iArr, int i2, int i3, int i4) {
        this.f40752a = i;
        this.f15525a = iArr;
        float f = i4;
        this.f15526a = new xg7[]{new xg7(i2, f), new xg7(i3, f)};
    }

    public xg7[] a() {
        return this.f15526a;
    }

    public int[] b() {
        return this.f15525a;
    }

    public int c() {
        return this.f40752a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof bh3) && this.f40752a == ((bh3) obj).f40752a;
    }

    public int hashCode() {
        return this.f40752a;
    }
}
