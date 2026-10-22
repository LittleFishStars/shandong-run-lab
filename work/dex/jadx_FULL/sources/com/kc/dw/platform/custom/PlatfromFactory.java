package com.kc.dw.platform.custom;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PlatfromFactory {
    private static CustomSdkPlatform customPlatform = new CustomSdkPlatform();

    public static CustomSdkPlatform getCustomPlatfrom() {
        return customPlatform;
    }
}
