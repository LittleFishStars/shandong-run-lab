package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
class PermissionDelegateImplV33 extends PermissionDelegateImplV31 {
    @Override // com.hjq.permissions.PermissionDelegateImplV31, com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionSettingIntent(@NonNull Context context, @NonNull String str) {
        return PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS) ? NotificationPermissionCompat.getPermissionIntent(context) : super.getPermissionSettingIntent(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV31, com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.BODY_SENSORS_BACKGROUND)) {
            if (!AndroidVersion.isAndroid6()) {
                return false;
            }
            if (!AndroidVersion.isAndroid13()) {
                return (PermissionUtils.checkSelfPermission(activity, Permission.BODY_SENSORS) || PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.BODY_SENSORS)) ? false : true;
            }
            if (PermissionUtils.checkSelfPermission(activity, Permission.BODY_SENSORS)) {
                return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return !PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.BODY_SENSORS);
        }
        if (PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS)) {
            if (AndroidVersion.isAndroid13()) {
                return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return false;
        }
        if (PermissionUtils.equalsPermission(str, Permission.NEARBY_WIFI_DEVICES)) {
            if (!AndroidVersion.isAndroid6()) {
                return false;
            }
            if (AndroidVersion.isAndroid13()) {
                return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return (PermissionUtils.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") || PermissionUtils.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION")) ? false : true;
        }
        if (PermissionUtils.containsPermission(new String[]{Permission.READ_MEDIA_IMAGES, Permission.READ_MEDIA_VIDEO, Permission.READ_MEDIA_AUDIO}, str)) {
            if (!AndroidVersion.isAndroid6()) {
                return false;
            }
            if (AndroidVersion.isAndroid13()) {
                return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return (PermissionUtils.checkSelfPermission(activity, "android.permission.READ_EXTERNAL_STORAGE") || PermissionUtils.shouldShowRequestPermissionRationale(activity, "android.permission.READ_EXTERNAL_STORAGE")) ? false : true;
        }
        if (AndroidVersion.isAndroid13() && AndroidVersion.getTargetSdkVersionCode(activity) >= 33) {
            if (PermissionUtils.equalsPermission(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return false;
            }
            if (PermissionUtils.equalsPermission(str, "android.permission.READ_EXTERNAL_STORAGE")) {
                return (PermissionUtils.checkSelfPermission(activity, Permission.READ_MEDIA_IMAGES) || PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.READ_MEDIA_IMAGES) || PermissionUtils.checkSelfPermission(activity, Permission.READ_MEDIA_VIDEO) || PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.READ_MEDIA_VIDEO) || PermissionUtils.checkSelfPermission(activity, Permission.READ_MEDIA_AUDIO) || PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.READ_MEDIA_AUDIO)) ? false : true;
            }
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV31, com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.BODY_SENSORS_BACKGROUND)) {
            if (!AndroidVersion.isAndroid6()) {
                return true;
            }
            if (AndroidVersion.isAndroid13()) {
                return PermissionUtils.checkSelfPermission(context, Permission.BODY_SENSORS) && PermissionUtils.checkSelfPermission(context, str);
            }
            return PermissionUtils.checkSelfPermission(context, Permission.BODY_SENSORS);
        }
        if (PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS)) {
            return !AndroidVersion.isAndroid13() ? NotificationPermissionCompat.isGrantedPermission(context) : PermissionUtils.checkSelfPermission(context, str);
        }
        if (PermissionUtils.equalsPermission(str, Permission.NEARBY_WIFI_DEVICES)) {
            if (AndroidVersion.isAndroid6()) {
                return !AndroidVersion.isAndroid13() ? PermissionUtils.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") : PermissionUtils.checkSelfPermission(context, str);
            }
            return true;
        }
        if (PermissionUtils.containsPermission(new String[]{Permission.READ_MEDIA_IMAGES, Permission.READ_MEDIA_VIDEO, Permission.READ_MEDIA_AUDIO}, str)) {
            if (AndroidVersion.isAndroid6()) {
                return !AndroidVersion.isAndroid13() ? PermissionUtils.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") : PermissionUtils.checkSelfPermission(context, str);
            }
            return true;
        }
        if (AndroidVersion.isAndroid13() && AndroidVersion.getTargetSdkVersionCode(context) >= 33) {
            if (PermissionUtils.equalsPermission(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return true;
            }
            if (PermissionUtils.equalsPermission(str, "android.permission.READ_EXTERNAL_STORAGE")) {
                return PermissionUtils.checkSelfPermission(context, Permission.READ_MEDIA_IMAGES) && PermissionUtils.checkSelfPermission(context, Permission.READ_MEDIA_VIDEO) && PermissionUtils.checkSelfPermission(context, Permission.READ_MEDIA_AUDIO);
            }
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplBase, com.hjq.permissions.PermissionDelegate
    public boolean recheckPermissionResult(@NonNull Context context, @NonNull String str, boolean z) {
        return (AndroidVersion.isAndroid13() && AndroidVersion.getTargetSdkVersionCode(context) >= 33 && PermissionUtils.equalsPermission(str, "android.permission.WRITE_EXTERNAL_STORAGE")) ? isGrantedPermission(context, str) : super.recheckPermissionResult(context, str, z);
    }
}
