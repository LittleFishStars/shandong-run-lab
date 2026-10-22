package com.kc.openset.oaid;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class OAIDRom {
    private static final String TAG = OSETSDKProtected.getString2(1846);

    static {
        OSETSDKProtected.interface11(4481);
    }

    private OAIDRom() {
    }

    public static native boolean is360OS();

    public static native boolean isASUS();

    public static native boolean isBlackShark();

    public static native boolean isCoolpad(Context context);

    public static native boolean isCoosea();

    public static native boolean isEmui();

    public static native boolean isFreeme();

    public static native boolean isHarmonyOS();

    public static native boolean isHonor();

    public static native boolean isHuawei();

    public static native boolean isLenovo();

    public static native boolean isMagicUI();

    public static native boolean isMeizu();

    public static native boolean isMiui();

    public static native boolean isMiuiGlobal();

    @Deprecated(forRemoval = true, since = "4.2.14")
    public static native boolean isMotolora();

    public static native boolean isMotorola();

    public static native boolean isNubia();

    public static native boolean isOnePlus();

    public static native boolean isOppo();

    public static native boolean isSSUI();

    public static native boolean isSamsung();

    public static native boolean isVivo();

    public static native boolean isXiaomi();

    public static native boolean isZTE();

    public static native String sysProperty(String str, String str2);
}
