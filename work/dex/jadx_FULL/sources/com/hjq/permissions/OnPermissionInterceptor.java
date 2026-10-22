package com.hjq.permissions;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface OnPermissionInterceptor {
    default void deniedPermissionRequest(@NonNull Activity activity, @NonNull List<String> list, @NonNull List<String> list2, boolean z, @Nullable OnPermissionCallback onPermissionCallback) {
        if (onPermissionCallback == null) {
            return;
        }
        onPermissionCallback.onDenied(list2, z);
    }

    default void finishPermissionRequest(@NonNull Activity activity, @NonNull List<String> list, boolean z, @Nullable OnPermissionCallback onPermissionCallback) {
    }

    default void grantedPermissionRequest(@NonNull Activity activity, @NonNull List<String> list, @NonNull List<String> list2, boolean z, @Nullable OnPermissionCallback onPermissionCallback) {
        if (onPermissionCallback == null) {
            return;
        }
        onPermissionCallback.onGranted(list2, z);
    }

    default void launchPermissionRequest(@NonNull Activity activity, @NonNull List<String> list, @Nullable OnPermissionCallback onPermissionCallback) {
        PermissionFragment.launch(activity, list, this, onPermissionCallback);
    }
}
