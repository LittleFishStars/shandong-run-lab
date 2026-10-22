package com.baseflow.permissionhandler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.zj.adlib.go6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class AppSettingsManager {

    @FunctionalInterface
    public interface OpenAppSettingsSuccessCallback {
        void onSuccess(boolean z);
    }

    public void a(Context context, OpenAppSettingsSuccessCallback openAppSettingsSuccessCallback, ErrorCallback errorCallback) {
        if (context == null) {
            Log.d(go6.f16832a, "Context cannot be null.");
            errorCallback.onError("PermissionHandler.AppSettingsManager", "Android context cannot be null.");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(268435456);
            intent.addFlags(1073741824);
            intent.addFlags(8388608);
            context.startActivity(intent);
            openAppSettingsSuccessCallback.onSuccess(true);
        } catch (Exception unused) {
            openAppSettingsSuccessCallback.onSuccess(false);
        }
    }
}
