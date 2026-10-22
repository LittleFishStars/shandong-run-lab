package com.zj.adlib;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class o3d extends n7d {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f18552a = new Object[4];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43661a = 0;

    public o3d(int i) {
    }

    public final o3d a(Object obj) {
        obj.getClass();
        b(this.f43661a + 1);
        Object[] objArr = this.f18552a;
        int i = this.f43661a;
        this.f43661a = i + 1;
        objArr[i] = obj;
        return this;
    }

    public final void b(int i) {
        Object[] objArr = this.f18552a;
        int length = objArr.length;
        if (length >= i) {
            if (this.f18551a) {
                this.f18552a = (Object[]) objArr.clone();
                this.f18551a = false;
                return;
            }
            return;
        }
        int i2 = length + (length >> 1) + 1;
        if (i2 < i) {
            int iHighestOneBit = Integer.highestOneBit(i - 1);
            i2 = iHighestOneBit + iHighestOneBit;
        }
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        this.f18552a = Arrays.copyOf(objArr, i2);
        this.f18551a = false;
    }
}
