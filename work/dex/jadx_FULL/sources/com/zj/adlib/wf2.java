package com.zj.adlib;

import com.facebook.common.internal.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class wf2 implements Supplier<ul5> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45585a = Integer.MAX_VALUE;
    public static final int b = Integer.MAX_VALUE;

    @Override // com.facebook.common.internal.Supplier
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ul5 get() {
        int iB = b();
        return new ul5(iB, Integer.MAX_VALUE, iB, Integer.MAX_VALUE, iB / 8);
    }

    public final int b() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (iMin < 16777216) {
            return 1048576;
        }
        return iMin < 33554432 ? 2097152 : 4194304;
    }
}
