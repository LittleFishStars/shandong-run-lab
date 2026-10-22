package com.baseflow.permissionhandler;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.zj.adlib.go6;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ServiceManager {

    @FunctionalInterface
    public interface SuccessCallback {
        void onSuccess(int i);
    }

    public static boolean d(Context context) {
        return false;
    }

    public static boolean f(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(int i, Context context, SuccessCallback successCallback, ErrorCallback errorCallback) {
        if (context == null) {
            Log.d(go6.f16832a, "Context cannot be null.");
            errorCallback.onError("PermissionHandler.ServiceManager", "Android context cannot be null.");
            return;
        }
        if (i == 3 || i == 4 || i == 5) {
            successCallback.onSuccess(e(context) ? 1 : 0);
            return;
        }
        if (i == 21) {
            successCallback.onSuccess(c(context) ? 1 : 0);
            return;
        }
        if (i != 8) {
            if (i == 16) {
                successCallback.onSuccess(1);
                return;
            } else {
                successCallback.onSuccess(2);
                return;
            }
        }
        PackageManager packageManager = context.getPackageManager();
        if (!packageManager.hasSystemFeature("android.hardware.telephony")) {
            successCallback.onSuccess(2);
            return;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        if (telephonyManager == null || telephonyManager.getPhoneType() == 0) {
            successCallback.onSuccess(2);
            return;
        }
        if (b(packageManager).isEmpty()) {
            successCallback.onSuccess(2);
        } else if (telephonyManager.getSimState() != 5) {
            successCallback.onSuccess(0);
        } else {
            successCallback.onSuccess(1);
        }
    }

    public final List<ResolveInfo> b(PackageManager packageManager) {
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:123123"));
        return Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0L)) : packageManager.queryIntentActivities(intent, 0);
    }

    public final boolean c(Context context) {
        return ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter().isEnabled();
    }

    public final boolean e(Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            return f(context);
        }
        LocationManager locationManager = (LocationManager) context.getSystemService(LocationManager.class);
        if (locationManager == null) {
            return false;
        }
        return locationManager.isLocationEnabled();
    }
}
