package com.alibaba.ariver.app.api.permission;

import android.app.Activity;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVNativePermissionRequestProxy extends Proxiable {
    void addPermRequstCallback(int i, IPermissionRequestCallback iPermissionRequestCallback);

    int getRequestCode();

    void onRequestPermissionResult(int i, String[] strArr, int[] iArr);

    void requestPermissions(Activity activity, String[] strArr, int i);
}
