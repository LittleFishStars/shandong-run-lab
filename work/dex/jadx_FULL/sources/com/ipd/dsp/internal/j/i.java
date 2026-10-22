package com.ipd.dsp.internal.j;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i implements a<int[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38353a = "IntegerArrayPool";

    @Override // com.ipd.dsp.internal.j.a
    public String a() {
        return f38353a;
    }

    @Override // com.ipd.dsp.internal.j.a
    public int b() {
        return 4;
    }

    @Override // com.ipd.dsp.internal.j.a
    public int a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.ipd.dsp.internal.j.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i) {
        return new int[i];
    }
}
