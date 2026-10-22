package com.kwad.sdk.components;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g {
    public static boolean dP(String str) {
        DevelopMangerComponents.DevelopValue developValueDO = d.dO(str);
        return developValueDO != null && ((Boolean) developValueDO.getValue()).booleanValue();
    }

    public static boolean encryptDisable() {
        return dP("KEY_HOST_ENCRYPT_DISABLE");
    }
}
