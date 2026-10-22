package com.aliyun.svideosdk.common;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class NativeAdaptiveUtil extends com.aliyun.svideosdk.nativeload.a {
    public static void decoderAdaptiveList(String[] strArr, int[] iArr) {
        nativeDecoderAdaptiveList(strArr, iArr);
    }

    public static void disableHardDecoderAdaptiveList(String[] strArr, int[] iArr) {
        nativeDisableHardDecoderAdaptiveList(strArr, iArr);
    }

    public static void encoderAdaptiveList(String[] strArr, int[] iArr) {
        nativeEncoderAdaptiveList(strArr, iArr);
    }

    public static boolean isDeviceDecoderEnable() {
        return nativeIsDeviceDecoderEnable();
    }

    private static native void nativeDecoderAdaptiveList(String[] strArr, int[] iArr);

    private static native void nativeDisableHardDecoderAdaptiveList(String[] strArr, int[] iArr);

    private static native void nativeEncoderAdaptiveList(String[] strArr, int[] iArr);

    private static native boolean nativeIsDeviceDecoderEnable();

    private static native void nativeSetFastEncode(boolean z);

    private static native void nativeSetHWDecoderEnable(boolean z);

    private static native void nativeSetHWEncoderEnable(boolean z);

    public static void setFastEncode(boolean z) {
        nativeSetFastEncode(z);
    }

    public static void setHWDecoderEnable(boolean z) {
        nativeSetHWDecoderEnable(z);
    }

    public static void setHWEncoderEnable(boolean z) {
        nativeSetHWEncoderEnable(z);
    }
}
