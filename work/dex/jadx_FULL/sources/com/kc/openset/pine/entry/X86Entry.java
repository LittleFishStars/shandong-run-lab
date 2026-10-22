package com.kc.openset.pine.entry;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.pine.Pine;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class X86Entry {
    private static final int[] EMPTY_INT_ARRAY;

    static {
        OSETSDKProtected.interface11(4589);
        EMPTY_INT_ARRAY = new int[0];
    }

    private X86Entry() {
    }

    private static native boolean booleanBridge(int i, int i2, int i3) throws Throwable;

    private static native byte byteBridge(int i, int i2, int i3) throws Throwable;

    private static native char charBridge(int i, int i2, int i3) throws Throwable;

    private static native double doubleBridge(int i, int i2, int i3);

    private static native float floatBridge(int i, int i2, int i3);

    private static native int[] getArgsAsInts(Pine.HookRecord hookRecord, int i, int i2);

    private static native Object handleBridge(int i, int i2, int i3) throws Throwable;

    private static native int intBridge(int i, int i2, int i3);

    private static native long longBridge(int i, int i2, int i3);

    private static native Object objectBridge(int i, int i2, int i3) throws Throwable;

    private static native short shortBridge(int i, int i2, int i3) throws Throwable;

    private static native void voidBridge(int i, int i2, int i3);
}
