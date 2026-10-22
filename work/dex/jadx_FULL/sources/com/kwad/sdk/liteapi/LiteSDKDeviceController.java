package com.kwad.sdk.liteapi;

import android.location.Location;
import androidx.annotation.Keep;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class LiteSDKDeviceController {
    public static String getDevAndroidId() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) ? "" : ksCustomController.getAndroidId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDevImei() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) ? "" : ksCustomController.getImei();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] getDevImeis() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
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
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    public static Location getDevLocation() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) {
                return null;
            }
            return ksCustomController.getLocation();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getDevMacAddress() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) ? "" : ksCustomController.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDevOaid() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) ? "" : ksCustomController.getOaid();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean readInstalledPackagesDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canReadInstalledPackages()) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean readLocationDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canReadLocation()) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean useMacAddressDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canUseMacAddress()) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean useNetworkStateDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canUseNetworkState()) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean useOaidDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canUseOaid()) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean usePhoneStateDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canUsePhoneState()) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean useStoragePermissionDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null || ksCustomController.canUseStoragePermission()) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
