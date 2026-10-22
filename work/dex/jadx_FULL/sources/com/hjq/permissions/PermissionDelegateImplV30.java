package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
class PermissionDelegateImplV30 extends PermissionDelegateImplV29 {
    @RequiresApi(30)
    private static Intent getManageStoragePermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(PermissionUtils.getPackageNameUri(context));
        if (!PermissionUtils.areActivityIntent(context, intent)) {
            intent = new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
        }
        return !PermissionUtils.areActivityIntent(context, intent) ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : intent;
    }

    @RequiresApi(30)
    private static boolean isGrantedManageStoragePermission() {
        return Environment.isExternalStorageManager();
    }

    @RequiresApi(29)
    private static boolean isUseDeprecationExternalStorage() {
        return Environment.isExternalStorageLegacy();
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionSettingIntent(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE)) {
            return !AndroidVersion.isAndroid11() ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : getManageStoragePermissionIntent(context);
        }
        return super.getPermissionSettingIntent(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE)) {
            return false;
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (!PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE)) {
            return super.isGrantedPermission(context, str);
        }
        if (!AndroidVersion.isAndroid6()) {
            return true;
        }
        if (AndroidVersion.isAndroid11()) {
            return isGrantedManageStoragePermission();
        }
        if (!AndroidVersion.isAndroid10() || isUseDeprecationExternalStorage()) {
            return PermissionUtils.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") && PermissionUtils.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return false;
    }
}
