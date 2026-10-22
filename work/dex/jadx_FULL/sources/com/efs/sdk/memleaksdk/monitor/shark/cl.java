package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
public final /* synthetic */ class cl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f29832a;

    static {
        int[] iArr = new int[HprofRecordTag.values().length];
        f29832a = iArr;
        iArr[HprofRecordTag.CLASS_DUMP.ordinal()] = 1;
        iArr[HprofRecordTag.INSTANCE_DUMP.ordinal()] = 2;
        iArr[HprofRecordTag.OBJECT_ARRAY_DUMP.ordinal()] = 3;
        iArr[HprofRecordTag.PRIMITIVE_ARRAY_DUMP.ordinal()] = 4;
    }
}
