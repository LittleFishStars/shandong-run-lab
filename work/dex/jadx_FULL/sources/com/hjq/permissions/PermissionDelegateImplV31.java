package com.hjq.permissions;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
class PermissionDelegateImplV31 extends PermissionDelegateImplV30 {
    @RequiresApi(31)
    private static Intent getAlarmPermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
        intent.setData(PermissionUtils.getPackageNameUri(context));
        return !PermissionUtils.areActivityIntent(context, intent) ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : intent;
    }

    @RequiresApi(31)
    private static boolean isGrantedAlarmPermission(@NonNull Context context) {
        return ((AlarmManager) context.getSystemService(AlarmManager.class)).canScheduleExactAlarms();
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionSettingIntent(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.SCHEDULE_EXACT_ALARM)) {
            return !AndroidVersion.isAndroid12() ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : getAlarmPermissionIntent(context);
        }
        return super.getPermissionSettingIntent(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.SCHEDULE_EXACT_ALARM)) {
            return false;
        }
        if (PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_SCAN)) {
            if (!AndroidVersion.isAndroid6()) {
                return false;
            }
            if (AndroidVersion.isAndroid12()) {
                return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return (PermissionUtils.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") || PermissionUtils.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION")) ? false : true;
        }
        if (PermissionUtils.containsPermission(new String[]{Permission.BLUETOOTH_CONNECT, Permission.BLUETOOTH_ADVERTISE}, str)) {
            return (!AndroidVersion.isAndroid12() || PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        if (!PermissionUtils.equalsPermission(str, Permission.ACCESS_BACKGROUND_LOCATION) || !AndroidVersion.isAndroid6() || AndroidVersion.getTargetSdkVersionCode(activity) < 31) {
            return super.isDoNotAskAgainPermission(activity, str);
        }
        if (PermissionUtils.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") || PermissionUtils.checkSelfPermission(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
            return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        return (PermissionUtils.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION") || PermissionUtils.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_COARSE_LOCATION")) ? false : true;
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.SCHEDULE_EXACT_ALARM)) {
            if (AndroidVersion.isAndroid12()) {
                return isGrantedAlarmPermission(context);
            }
            return true;
        }
        if (PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_SCAN)) {
            if (AndroidVersion.isAndroid6()) {
                return !AndroidVersion.isAndroid12() ? PermissionUtils.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") : PermissionUtils.checkSelfPermission(context, str);
            }
            return true;
        }
        if (!PermissionUtils.containsPermission(new String[]{Permission.BLUETOOTH_CONNECT, Permission.BLUETOOTH_ADVERTISE}, str)) {
            return super.isGrantedPermission(context, str);
        }
        if (AndroidVersion.isAndroid12()) {
            return PermissionUtils.checkSelfPermission(context, str);
        }
        return true;
    }
}
