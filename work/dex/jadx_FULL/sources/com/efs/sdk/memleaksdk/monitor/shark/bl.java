package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
public final /* synthetic */ class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f29804a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[LeakTraceReference.b.values().length];
        f29804a = iArr;
        LeakTraceReference.b bVar = LeakTraceReference.b.ARRAY_ENTRY;
        iArr[bVar.ordinal()] = 1;
        LeakTraceReference.b bVar2 = LeakTraceReference.b.STATIC_FIELD;
        iArr[bVar2.ordinal()] = 2;
        LeakTraceReference.b bVar3 = LeakTraceReference.b.INSTANCE_FIELD;
        iArr[bVar3.ordinal()] = 3;
        LeakTraceReference.b bVar4 = LeakTraceReference.b.LOCAL;
        iArr[bVar4.ordinal()] = 4;
        int[] iArr2 = new int[LeakTraceReference.b.values().length];
        b = iArr2;
        iArr2[bVar.ordinal()] = 1;
        iArr2[bVar2.ordinal()] = 2;
        iArr2[bVar3.ordinal()] = 3;
        iArr2[bVar4.ordinal()] = 4;
    }
}
