package com.efs.sdk.base.samplingwhitelist;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SamplingWhiteListUtil {
    private static boolean sHitWL = false;

    public static boolean isHitWL() {
        return sHitWL;
    }

    public static void setHitWL(boolean z) {
        sHitWL = z;
    }
}
