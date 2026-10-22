package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface PermissionDelegate {
    Intent getPermissionSettingIntent(@NonNull Context context, @NonNull String str);

    boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str);

    boolean isGrantedPermission(@NonNull Context context, @NonNull String str);

    boolean recheckPermissionResult(@NonNull Context context, @NonNull String str, boolean z);
}
