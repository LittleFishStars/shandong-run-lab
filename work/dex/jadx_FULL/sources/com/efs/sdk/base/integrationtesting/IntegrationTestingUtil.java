package com.efs.sdk.base.integrationtesting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class IntegrationTestingUtil {
    private static boolean sIsInPeriod = false;

    public static boolean isIntegrationTestingInPeriod() {
        return sIsInPeriod;
    }

    public static void setIntegrationTestingInPeriod(boolean z) {
        sIsInPeriod = z;
    }
}
