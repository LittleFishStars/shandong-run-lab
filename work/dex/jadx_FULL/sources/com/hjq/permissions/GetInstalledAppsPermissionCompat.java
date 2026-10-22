package com.hjq.permissions;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class GetInstalledAppsPermissionCompat {
    private static final int MIUI_OP_GET_INSTALLED_APPS_DEFAULT_VALUE = 10022;
    private static final String MIUI_OP_GET_INSTALLED_APPS_FIELD_NAME = "OP_GET_INSTALLED_APPS";

    public static Intent getPermissionIntent(@NonNull Context context) {
        if (PhoneRomUtils.isMiui()) {
            return StartActivityManager.addSubIntentToMainIntent(PhoneRomUtils.isMiuiOptimization() ? PermissionIntentManager.getMiuiPermissionPageIntent(context) : null, PermissionIntentManager.getApplicationDetailsIntent(context));
        }
        return PermissionIntentManager.getApplicationDetailsIntent(context);
    }

    public static boolean isDoNotAskAgainPermission(@NonNull Activity activity) {
        if (!AndroidVersion.isAndroid4_4()) {
            return false;
        }
        if (AndroidVersion.isAndroid6() && isSupportGetInstalledAppsPermission(activity)) {
            return (PermissionUtils.checkSelfPermission(activity, Permission.GET_INSTALLED_APPS) || PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.GET_INSTALLED_APPS)) ? false : true;
        }
        if (PhoneRomUtils.isMiui() && isMiuiSupportGetInstalledAppsPermission() && PhoneRomUtils.isMiuiOptimization()) {
            return !isGrantedPermission(activity);
        }
        return false;
    }

    public static boolean isGrantedPermission(@NonNull Context context) {
        if (!AndroidVersion.isAndroid4_4()) {
            return true;
        }
        if (AndroidVersion.isAndroid6() && isSupportGetInstalledAppsPermission(context)) {
            return PermissionUtils.checkSelfPermission(context, Permission.GET_INSTALLED_APPS);
        }
        if (PhoneRomUtils.isMiui() && isMiuiSupportGetInstalledAppsPermission() && PhoneRomUtils.isMiuiOptimization()) {
            return PermissionUtils.checkOpNoThrow(context, MIUI_OP_GET_INSTALLED_APPS_FIELD_NAME, 10022);
        }
        return true;
    }

    private static boolean isMiuiSupportGetInstalledAppsPermission() {
        if (!AndroidVersion.isAndroid4_4()) {
            return true;
        }
        try {
            Class.forName(AppOpsManager.class.getName()).getDeclaredField(MIUI_OP_GET_INSTALLED_APPS_FIELD_NAME);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @RequiresApi(23)
    private static boolean isSupportGetInstalledAppsPermission(Context context) {
        try {
            PermissionInfo permissionInfo = context.getPackageManager().getPermissionInfo(Permission.GET_INSTALLED_APPS, 0);
            if (permissionInfo != null) {
                if (AndroidVersion.isAndroid9()) {
                    return permissionInfo.getProtection() == 1;
                }
                return (permissionInfo.protectionLevel & 15) == 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "oem_installed_apps_runtime_permission_enable") == 1;
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
