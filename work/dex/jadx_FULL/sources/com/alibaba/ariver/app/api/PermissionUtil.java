package com.alibaba.ariver.app.api;

import android.app.Activity;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.kernel.common.RVProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PermissionUtil {
    public static void requestPermissions(Activity activity, String[] strArr, IPermissionRequestCallback iPermissionRequestCallback) {
        RVNativePermissionRequestProxy rVNativePermissionRequestProxy = (RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class);
        int requestCode = rVNativePermissionRequestProxy.getRequestCode();
        rVNativePermissionRequestProxy.addPermRequstCallback(requestCode, iPermissionRequestCallback);
        rVNativePermissionRequestProxy.requestPermissions(activity, strArr, requestCode);
    }
}
