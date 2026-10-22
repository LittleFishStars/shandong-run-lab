package com.kc.openset.pine.utils;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class ThreeTuple<A, B, C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public A f39808a;
    public B b;
    public C c;

    static {
        OSETSDKProtected.interface11(4676);
    }

    public ThreeTuple() {
    }

    public ThreeTuple(A a2, B b, C c) {
        this.f39808a = a2;
        this.b = b;
        this.c = c;
    }

    public native boolean equals(Object obj);

    public native int hashCode();

    public native String toString();
}
