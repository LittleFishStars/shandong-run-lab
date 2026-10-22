package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
public final /* synthetic */ class as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f29754a;
    public static final /* synthetic */ int[] b;
    public static final /* synthetic */ int[] c;
    public static final /* synthetic */ int[] d;

    static {
        int[] iArr = new int[LeakTraceObject.b.values().length];
        f29754a = iArr;
        LeakTraceObject.b bVar = LeakTraceObject.b.LEAKING;
        iArr[bVar.ordinal()] = 1;
        LeakTraceObject.b bVar2 = LeakTraceObject.b.UNKNOWN;
        iArr[bVar2.ordinal()] = 2;
        LeakTraceObject.b bVar3 = LeakTraceObject.b.NOT_LEAKING;
        iArr[bVar3.ordinal()] = 3;
        int[] iArr2 = new int[LeakTraceObject.b.values().length];
        b = iArr2;
        iArr2[bVar.ordinal()] = 1;
        iArr2[bVar2.ordinal()] = 2;
        iArr2[bVar3.ordinal()] = 3;
        int[] iArr3 = new int[LeakTraceObject.b.values().length];
        c = iArr3;
        iArr3[bVar2.ordinal()] = 1;
        iArr3[bVar3.ordinal()] = 2;
        iArr3[bVar.ordinal()] = 3;
        int[] iArr4 = new int[LeakTraceObject.b.values().length];
        d = iArr4;
        iArr4[bVar2.ordinal()] = 1;
        iArr4[bVar.ordinal()] = 2;
        iArr4[bVar3.ordinal()] = 3;
    }
}
