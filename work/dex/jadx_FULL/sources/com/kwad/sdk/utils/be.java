package com.kwad.sdk.utils;

import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class be {
    public static volatile int bqb;

    private static boolean We() {
        if (!com.kwad.framework.a.a.pe.booleanValue()) {
            return false;
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return false;
    }

    public static com.kwad.sdk.internal.api.a Wf() {
        KsCustomController ksCustomController;
        com.kwad.sdk.internal.api.a aVarP;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) {
                return null;
            }
            try {
                aVarP = com.kwad.sdk.internal.api.a.p(ksCustomController.getKsLocation());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                aVarP = null;
            }
            return aVarP != null ? aVarP : com.kwad.sdk.internal.api.a.a(ksCustomController.getLocation());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean Wg() {
        if (!com.kwad.sdk.core.d.a.pe.booleanValue()) {
            return false;
        }
        try {
            com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String getDevAndroidId() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) ? "" : ksCustomController.getAndroidId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDevImei() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) ? "" : ksCustomController.getImei();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] getDevImeis() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable unused) {
        }
        return new String[]{"", ""};
    }

    public static List<String> getDevInstalledPackages() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    public static String getDevMacAddress() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) ? "" : ksCustomController.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDevOaid() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) ? "" : ksCustomController.getOaid();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean readInstalledPackagesDisable() {
        KsCustomController ksCustomController;
        if (We()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canReadInstalledPackages()) ? false : true;
        } catch (Throwable unused) {
        }
    }

    public static boolean readLocationDisable() {
        KsCustomController ksCustomController;
        if (We()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canReadLocation()) ? false : true;
        } catch (Throwable unused) {
        }
    }

    public static boolean useMacAddressDisable() {
        KsCustomController ksCustomController;
        if (We()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canUseMacAddress()) ? false : true;
        } catch (Throwable unused) {
        }
    }

    public static boolean useNetworkStateDisable() {
        KsCustomController ksCustomController;
        if (We()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canUseNetworkState()) ? false : true;
        } catch (Throwable unused) {
        }
    }

    public static boolean useOaidDisable() {
        KsCustomController ksCustomController;
        if (We()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canUseOaid()) ? false : true;
        } catch (Throwable unused) {
        }
    }

    public static boolean usePhoneStateDisable() {
        KsCustomController ksCustomController;
        if (We()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canUsePhoneState()) ? false : true;
        } catch (Throwable unused) {
        }
    }

    public static boolean useSensorManagerDisable() {
        if (Wg()) {
            return true;
        }
        try {
            return bqb == -1;
        } catch (Throwable unused) {
        }
    }

    public static boolean useStoragePermissionDisable() {
        KsCustomController ksCustomController;
        if (We()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canUseStoragePermission()) ? false : true;
        } catch (Throwable unused) {
        }
    }
}
