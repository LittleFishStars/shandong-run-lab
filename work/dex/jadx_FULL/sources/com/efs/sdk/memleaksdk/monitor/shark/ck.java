package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
public final /* synthetic */ class ck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f29831a;

    static {
        int[] iArr = new int[HprofRecordTag.values().length];
        f29831a = iArr;
        iArr[HprofRecordTag.STRING_IN_UTF8.ordinal()] = 1;
        iArr[HprofRecordTag.LOAD_CLASS.ordinal()] = 2;
        iArr[HprofRecordTag.ROOT_UNKNOWN.ordinal()] = 3;
        iArr[HprofRecordTag.ROOT_JNI_GLOBAL.ordinal()] = 4;
        iArr[HprofRecordTag.ROOT_JNI_LOCAL.ordinal()] = 5;
        iArr[HprofRecordTag.ROOT_JAVA_FRAME.ordinal()] = 6;
        iArr[HprofRecordTag.ROOT_NATIVE_STACK.ordinal()] = 7;
        iArr[HprofRecordTag.ROOT_STICKY_CLASS.ordinal()] = 8;
        iArr[HprofRecordTag.ROOT_THREAD_BLOCK.ordinal()] = 9;
        iArr[HprofRecordTag.ROOT_MONITOR_USED.ordinal()] = 10;
        iArr[HprofRecordTag.ROOT_THREAD_OBJECT.ordinal()] = 11;
        iArr[HprofRecordTag.ROOT_INTERNED_STRING.ordinal()] = 12;
        iArr[HprofRecordTag.ROOT_FINALIZING.ordinal()] = 13;
        iArr[HprofRecordTag.ROOT_DEBUGGER.ordinal()] = 14;
        iArr[HprofRecordTag.ROOT_REFERENCE_CLEANUP.ordinal()] = 15;
        iArr[HprofRecordTag.ROOT_VM_INTERNAL.ordinal()] = 16;
        iArr[HprofRecordTag.ROOT_JNI_MONITOR.ordinal()] = 17;
        iArr[HprofRecordTag.ROOT_UNREACHABLE.ordinal()] = 18;
        iArr[HprofRecordTag.CLASS_DUMP.ordinal()] = 19;
        iArr[HprofRecordTag.INSTANCE_DUMP.ordinal()] = 20;
        iArr[HprofRecordTag.OBJECT_ARRAY_DUMP.ordinal()] = 21;
        iArr[HprofRecordTag.PRIMITIVE_ARRAY_DUMP.ordinal()] = 22;
    }
}
