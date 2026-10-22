package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
class PermissionDelegateImplV26 extends PermissionDelegateImplV23 {
    @RequiresApi(26)
    private static Intent getInstallPermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        intent.setData(PermissionUtils.getPackageNameUri(context));
        return !PermissionUtils.areActivityIntent(context, intent) ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : intent;
    }

    @RequiresApi(26)
    private static Intent getPictureInPicturePermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS");
        intent.setData(PermissionUtils.getPackageNameUri(context));
        return !PermissionUtils.areActivityIntent(context, intent) ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : intent;
    }

    @RequiresApi(26)
    private static boolean isGrantedInstallPermission(@NonNull Context context) {
        return context.getPackageManager().canRequestPackageInstalls();
    }

    @RequiresApi(26)
    private static boolean isGrantedPictureInPicturePermission(@NonNull Context context) {
        return PermissionUtils.checkOpNoThrow(context, "android:picture_in_picture");
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionSettingIntent(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.REQUEST_INSTALL_PACKAGES)) {
            return !AndroidVersion.isAndroid8() ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : getInstallPermissionIntent(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.PICTURE_IN_PICTURE)) {
            return !AndroidVersion.isAndroid8() ? PermissionDelegateImplBase.getApplicationDetailsIntent(context) : getPictureInPicturePermissionIntent(context);
        }
        return super.getPermissionSettingIntent(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.REQUEST_INSTALL_PACKAGES) || PermissionUtils.equalsPermission(str, Permission.PICTURE_IN_PICTURE)) {
            return false;
        }
        if (!PermissionUtils.equalsPermission(str, Permission.READ_PHONE_NUMBERS)) {
            if (PermissionUtils.equalsPermission(str, Permission.ANSWER_PHONE_CALLS)) {
                return (!AndroidVersion.isAndroid8() || PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return super.isDoNotAskAgainPermission(activity, str);
        }
        if (!AndroidVersion.isAndroid6()) {
            return false;
        }
        if (AndroidVersion.isAndroid8()) {
            return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        return (PermissionUtils.checkSelfPermission(activity, "android.permission.READ_PHONE_STATE") || PermissionUtils.shouldShowRequestPermissionRationale(activity, "android.permission.READ_PHONE_STATE")) ? false : true;
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.REQUEST_INSTALL_PACKAGES)) {
            if (AndroidVersion.isAndroid8()) {
                return isGrantedInstallPermission(context);
            }
            return true;
        }
        if (PermissionUtils.equalsPermission(str, Permission.PICTURE_IN_PICTURE)) {
            if (AndroidVersion.isAndroid8()) {
                return isGrantedPictureInPicturePermission(context);
            }
            return true;
        }
        if (PermissionUtils.equalsPermission(str, Permission.READ_PHONE_NUMBERS)) {
            if (AndroidVersion.isAndroid6()) {
                return !AndroidVersion.isAndroid8() ? PermissionUtils.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") : PermissionUtils.checkSelfPermission(context, str);
            }
            return true;
        }
        if (!PermissionUtils.equalsPermission(str, Permission.ANSWER_PHONE_CALLS)) {
            return super.isGrantedPermission(context, str);
        }
        if (AndroidVersion.isAndroid8()) {
            return PermissionUtils.checkSelfPermission(context, str);
        }
        return true;
    }
}
