package com.hjq.permissions;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
class PermissionDelegateImplV23 extends PermissionDelegateImplV21 {
    @RequiresApi(23)
    private static Intent getIgnoreBatteryPermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(PermissionUtils.getPackageNameUri(context));
        if (!PermissionUtils.areActivityIntent(context, intent)) {
            intent = new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
        }
        return !PermissionUtils.areActivityIntent(context, intent) ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : intent;
    }

    @RequiresApi(23)
    private static Intent getNotDisturbPermissionIntent(@NonNull Context context) {
        Intent intent;
        if (AndroidVersion.isAndroid10()) {
            intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_DETAIL_SETTINGS");
            intent.setData(PermissionUtils.getPackageNameUri(context));
            if (PhoneRomUtils.isHarmonyOs() || PhoneRomUtils.isMagicOs()) {
                intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
            }
        } else {
            intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
        }
        return !PermissionUtils.areActivityIntent(context, intent) ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : intent;
    }

    @RequiresApi(23)
    private static Intent getSettingPermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(PermissionUtils.getPackageNameUri(context));
        return !PermissionUtils.areActivityIntent(context, intent) ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : intent;
    }

    @RequiresApi(23)
    private static boolean isGrantedIgnoreBatteryPermission(@NonNull Context context) {
        return ((PowerManager) context.getSystemService(PowerManager.class)).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    @RequiresApi(23)
    private static boolean isGrantedNotDisturbPermission(@NonNull Context context) {
        return ((NotificationManager) context.getSystemService(NotificationManager.class)).isNotificationPolicyAccessGranted();
    }

    @RequiresApi(23)
    private static boolean isGrantedSettingPermission(@NonNull Context context) {
        return Settings.System.canWrite(context);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionSettingIntent(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.GET_INSTALLED_APPS)) {
            return GetInstalledAppsPermissionCompat.getPermissionIntent(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.SYSTEM_ALERT_WINDOW)) {
            return WindowPermissionCompat.getPermissionIntent(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.WRITE_SETTINGS)) {
            return !AndroidVersion.isAndroid6() ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : getSettingPermissionIntent(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.ACCESS_NOTIFICATION_POLICY)) {
            return !AndroidVersion.isAndroid6() ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : getNotDisturbPermissionIntent(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)) {
            return !AndroidVersion.isAndroid6() ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : getIgnoreBatteryPermissionIntent(context);
        }
        return super.getPermissionSettingIntent(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (PermissionHelper.isSpecialPermission(str)) {
            if (PermissionUtils.containsPermission(new String[]{Permission.SYSTEM_ALERT_WINDOW, Permission.WRITE_SETTINGS, Permission.ACCESS_NOTIFICATION_POLICY, Permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS}, str)) {
                return false;
            }
            return super.isDoNotAskAgainPermission(activity, str);
        }
        if (PermissionUtils.equalsPermission(str, Permission.GET_INSTALLED_APPS)) {
            return GetInstalledAppsPermissionCompat.isDoNotAskAgainPermission(activity);
        }
        return (!AndroidVersion.isAndroid6() || PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (!PermissionHelper.isSpecialPermission(str)) {
            if (PermissionUtils.equalsPermission(str, Permission.GET_INSTALLED_APPS)) {
                return GetInstalledAppsPermissionCompat.isGrantedPermission(context);
            }
            if (AndroidVersion.isAndroid6()) {
                return PermissionUtils.checkSelfPermission(context, str);
            }
            return true;
        }
        if (PermissionUtils.equalsPermission(str, Permission.SYSTEM_ALERT_WINDOW)) {
            return WindowPermissionCompat.isGrantedPermission(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.WRITE_SETTINGS)) {
            if (AndroidVersion.isAndroid6()) {
                return isGrantedSettingPermission(context);
            }
            return true;
        }
        if (PermissionUtils.equalsPermission(str, Permission.ACCESS_NOTIFICATION_POLICY)) {
            if (AndroidVersion.isAndroid6()) {
                return isGrantedNotDisturbPermission(context);
            }
            return true;
        }
        if (!PermissionUtils.equalsPermission(str, Permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)) {
            return super.isGrantedPermission(context, str);
        }
        if (AndroidVersion.isAndroid6()) {
            return isGrantedIgnoreBatteryPermission(context);
        }
        return true;
    }

    @Override // com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean recheckPermissionResult(@NonNull Context context, @NonNull String str, boolean z) {
        return PermissionUtils.equalsPermission(str, Permission.GET_INSTALLED_APPS) ? isGrantedPermission(context, str) : super.recheckPermissionResult(context, str, z);
    }
}
