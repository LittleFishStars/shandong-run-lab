package com.alipay.sdk.app;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EnvUtils {
    private static EnvEnum mEnv = EnvEnum.ONLINE;

    public enum EnvEnum {
        ONLINE,
        PRE_SANDBOX,
        SANDBOX
    }

    public static EnvEnum geEnv() {
        return mEnv;
    }

    public static boolean isNewSanBox() {
        return mEnv == EnvEnum.SANDBOX;
    }

    public static boolean isPreSandBox() {
        return mEnv == EnvEnum.PRE_SANDBOX;
    }

    public static boolean isSandBox() {
        return isPreSandBox() || isNewSanBox();
    }

    public static void setEnv(EnvEnum envEnum) {
        mEnv = envEnum;
    }
}
