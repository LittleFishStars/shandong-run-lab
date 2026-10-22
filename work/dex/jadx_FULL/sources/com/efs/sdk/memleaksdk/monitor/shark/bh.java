package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
public final /* synthetic */ class bh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f29797a;

    static {
        int[] iArr = new int[LeakTraceObject.b.values().length];
        f29797a = iArr;
        iArr[LeakTraceObject.b.UNKNOWN.ordinal()] = 1;
        iArr[LeakTraceObject.b.NOT_LEAKING.ordinal()] = 2;
    }
}
