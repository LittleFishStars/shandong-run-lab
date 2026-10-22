package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
class PermissionDelegateImplV21 extends PermissionDelegateImplV19 {
    @RequiresApi(21)
    private static Intent getPackagePermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
        if (AndroidVersion.isAndroid10()) {
            intent.setData(PermissionUtils.getPackageNameUri(context));
        }
        return !PermissionUtils.areActivityIntent(context, intent) ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : intent;
    }

    @RequiresApi(21)
    private static boolean isGrantedPackagePermission(@NonNull Context context) {
        return PermissionUtils.checkOpNoThrow(context, "android:get_usage_stats");
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionSettingIntent(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.PACKAGE_USAGE_STATS)) {
            return !AndroidVersion.isAndroid5() ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : getPackagePermissionIntent(context);
        }
        return super.getPermissionSettingIntent(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.PACKAGE_USAGE_STATS)) {
            return false;
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (!PermissionUtils.equalsPermission(str, Permission.PACKAGE_USAGE_STATS)) {
            return super.isGrantedPermission(context, str);
        }
        if (AndroidVersion.isAndroid5()) {
            return isGrantedPackagePermission(context);
        }
        return true;
    }
}
