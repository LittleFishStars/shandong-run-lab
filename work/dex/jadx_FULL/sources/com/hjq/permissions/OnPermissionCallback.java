package com.hjq.permissions;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface OnPermissionCallback {
    default void onDenied(@NonNull List<String> list, boolean z) {
    }

    void onGranted(@NonNull List<String> list, boolean z);
}
