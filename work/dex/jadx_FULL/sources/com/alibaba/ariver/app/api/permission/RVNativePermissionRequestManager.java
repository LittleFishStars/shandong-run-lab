package com.alibaba.ariver.app.api.permission;

import android.app.Activity;
import androidx.collection.SparseArrayCompat;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVNativePermissionRequestManager implements RVNativePermissionRequestProxy {
    protected SparseArrayCompat<IPermissionRequestCallback> callbackArray = new SparseArrayCompat<>();
    protected AtomicInteger lastRequestCode = new AtomicInteger(1024);

    @Override // com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy
    public void addPermRequstCallback(int i, IPermissionRequestCallback iPermissionRequestCallback) {
        SparseArrayCompat<IPermissionRequestCallback> sparseArrayCompat = this.callbackArray;
        if (sparseArrayCompat != null) {
            sparseArrayCompat.put(i, iPermissionRequestCallback);
        }
    }

    @Override // com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy
    public int getRequestCode() {
        return this.lastRequestCode.addAndGet(1) & 255;
    }

    @Override // com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        IPermissionRequestCallback iPermissionRequestCallback;
        SparseArrayCompat<IPermissionRequestCallback> sparseArrayCompat = this.callbackArray;
        if (sparseArrayCompat == null || (iPermissionRequestCallback = sparseArrayCompat.get(i)) == null) {
            return;
        }
        iPermissionRequestCallback.onRequestPermissionResult(i, strArr, iArr);
        this.callbackArray.remove(i);
    }

    @Override // com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy
    public void requestPermissions(Activity activity, String[] strArr, int i) {
        if (activity != null) {
            activity.requestPermissions(strArr, i);
        }
    }
}
