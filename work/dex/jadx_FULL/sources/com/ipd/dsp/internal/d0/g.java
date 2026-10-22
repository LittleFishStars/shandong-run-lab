package com.ipd.dsp.internal.d0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g<T> implements com.ipd.dsp.internal.b.b.InterfaceC0859b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f38275a;

    public g(int i, int i2) {
        this.f38275a = new int[]{i, i2};
    }

    @Override // com.ipd.dsp.internal.b.b.InterfaceC0859b
    @Nullable
    public int[] a(@NonNull T t, int i, int i2) {
        return this.f38275a;
    }
}
