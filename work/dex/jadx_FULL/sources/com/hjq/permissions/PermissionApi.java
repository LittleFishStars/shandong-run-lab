package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class PermissionApi {

    @NonNull
    private static final PermissionDelegate DELEGATE = new PermissionDelegateImplV34();

    public static boolean containsSpecialPermission(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (isSpecialPermission(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> getDeniedPermissions(@NonNull Context context, @NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (!isGrantedPermission(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static List<String> getGrantedPermissions(@NonNull Context context, @NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (isGrantedPermission(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static Intent getPermissionSettingIntent(@NonNull Context context, @NonNull String str) {
        return DELEGATE.getPermissionSettingIntent(context, str);
    }

    public static Intent getSmartPermissionIntent(@NonNull Context context, @Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            return PermissionIntentManager.getApplicationDetailsIntent(context);
        }
        if (!containsSpecialPermission(list)) {
            return list.size() == 1 ? getPermissionSettingIntent(context, list.get(0)) : PermissionIntentManager.getApplicationDetailsIntent(context, list);
        }
        int size = list.size();
        if (size == 1) {
            return getPermissionSettingIntent(context, list.get(0));
        }
        if (size != 2) {
            if (size == 3 && AndroidVersion.isAndroid11() && PermissionUtils.containsPermission(list, Permission.MANAGE_EXTERNAL_STORAGE) && PermissionUtils.containsPermission(list, "android.permission.READ_EXTERNAL_STORAGE") && PermissionUtils.containsPermission(list, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return getPermissionSettingIntent(context, Permission.MANAGE_EXTERNAL_STORAGE);
            }
        } else if (!AndroidVersion.isAndroid13() && PermissionUtils.containsPermission(list, Permission.NOTIFICATION_SERVICE) && PermissionUtils.containsPermission(list, Permission.POST_NOTIFICATIONS)) {
            return getPermissionSettingIntent(context, Permission.NOTIFICATION_SERVICE);
        }
        return PermissionIntentManager.getApplicationDetailsIntent(context);
    }

    public static boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        return DELEGATE.isDoNotAskAgainPermission(activity, str);
    }

    public static boolean isDoNotAskAgainPermissions(@NonNull Activity activity, @NonNull List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (isDoNotAskAgainPermission(activity, it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        return DELEGATE.isGrantedPermission(context, str);
    }

    public static boolean isGrantedPermissions(@NonNull Context context, @NonNull List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!isGrantedPermission(context, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSpecialPermission(@NonNull String str) {
        return PermissionHelper.isSpecialPermission(str);
    }

    public static boolean recheckPermissionResult(@NonNull Context context, @NonNull String str, boolean z) {
        return DELEGATE.recheckPermissionResult(context, str, z);
    }

    public static List<String> getDeniedPermissions(@NonNull List<String> list, @NonNull int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == -1) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    public static List<String> getGrantedPermissions(@NonNull List<String> list, @NonNull int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == 0) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }
}
