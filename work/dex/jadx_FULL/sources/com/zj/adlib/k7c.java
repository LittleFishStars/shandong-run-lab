package com.zj.adlib;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class k7c extends s7c {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f17602a = new Object[4];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42758a = 0;

    public k7c(int i) {
    }

    @CanIgnoreReturnValue
    public final k7c a(Object obj) {
        obj.getClass();
        b(this.f42758a + 1);
        Object[] objArr = this.f17602a;
        int i = this.f42758a;
        this.f42758a = i + 1;
        objArr[i] = obj;
        return this;
    }

    public final void b(int i) {
        Object[] objArr = this.f17602a;
        int length = objArr.length;
        if (length >= i) {
            if (this.f17601a) {
                this.f17602a = (Object[]) objArr.clone();
                this.f17601a = false;
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
        this.f17602a = Arrays.copyOf(objArr, i2);
        this.f17601a = false;
    }
}
