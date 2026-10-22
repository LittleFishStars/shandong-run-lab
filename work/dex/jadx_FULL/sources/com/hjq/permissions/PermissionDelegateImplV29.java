package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
class PermissionDelegateImplV29 extends PermissionDelegateImplV28 {
    @RequiresApi(23)
    private boolean isGrantedReadStoragePermission(@NonNull Context context) {
        if (AndroidVersion.isAndroid13() && AndroidVersion.getTargetSdkVersionCode(context) >= 33) {
            return PermissionUtils.checkSelfPermission(context, Permission.READ_MEDIA_IMAGES) || isGrantedPermission(context, Permission.MANAGE_EXTERNAL_STORAGE);
        }
        if (!AndroidVersion.isAndroid11() || AndroidVersion.getTargetSdkVersionCode(context) < 30) {
            return PermissionUtils.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE");
        }
        return PermissionUtils.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") || isGrantedPermission(context, Permission.MANAGE_EXTERNAL_STORAGE);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.ACCESS_BACKGROUND_LOCATION)) {
            if (!AndroidVersion.isAndroid6()) {
                return false;
            }
            if (!AndroidVersion.isAndroid10()) {
                return (PermissionUtils.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") || PermissionUtils.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION")) ? false : true;
            }
            if (PermissionUtils.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION")) {
                return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return !PermissionUtils.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION");
        }
        if (PermissionUtils.equalsPermission(str, Permission.ACCESS_MEDIA_LOCATION)) {
            if (!AndroidVersion.isAndroid6()) {
                return false;
            }
            if (AndroidVersion.isAndroid10()) {
                return (!isGrantedReadStoragePermission(activity) || PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return (PermissionUtils.checkSelfPermission(activity, "android.permission.READ_EXTERNAL_STORAGE") || PermissionUtils.shouldShowRequestPermissionRationale(activity, "android.permission.READ_EXTERNAL_STORAGE")) ? false : true;
        }
        if (!PermissionUtils.equalsPermission(str, Permission.ACTIVITY_RECOGNITION)) {
            return super.isDoNotAskAgainPermission(activity, str);
        }
        if (AndroidVersion.isAndroid10()) {
            return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        return false;
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.ACCESS_MEDIA_LOCATION)) {
            if (!AndroidVersion.isAndroid6()) {
                return true;
            }
            if (AndroidVersion.isAndroid10()) {
                return isGrantedReadStoragePermission(context) && PermissionUtils.checkSelfPermission(context, Permission.ACCESS_MEDIA_LOCATION);
            }
            return PermissionUtils.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE");
        }
        if (PermissionUtils.equalsPermission(str, Permission.ACCESS_BACKGROUND_LOCATION)) {
            if (AndroidVersion.isAndroid6()) {
                return !AndroidVersion.isAndroid10() ? PermissionUtils.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") : PermissionUtils.checkSelfPermission(context, str);
            }
            return true;
        }
        if (!PermissionUtils.equalsPermission(str, Permission.ACTIVITY_RECOGNITION)) {
            return super.isGrantedPermission(context, str);
        }
        if (AndroidVersion.isAndroid10()) {
            return PermissionUtils.checkSelfPermission(context, str);
        }
        return true;
    }
}
