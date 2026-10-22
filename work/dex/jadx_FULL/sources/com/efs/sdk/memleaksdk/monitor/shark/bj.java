package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
public final /* synthetic */ class bj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f29801a;

    static {
        int[] iArr = new int[LeakTraceObject.b.values().length];
        f29801a = iArr;
        iArr[LeakTraceObject.b.UNKNOWN.ordinal()] = 1;
        iArr[LeakTraceObject.b.NOT_LEAKING.ordinal()] = 2;
        iArr[LeakTraceObject.b.LEAKING.ordinal()] = 3;
    }
}
