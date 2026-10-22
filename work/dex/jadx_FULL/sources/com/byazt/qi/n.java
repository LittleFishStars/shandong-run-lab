package com.byazt.qi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.alibaba.triver.embed.video.video.h;
import com.aliyun.vod.log.core.AliyunLogCommon;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 527, 46})
public class n {
    public static volatile boolean c = false;

    public static void c(Context context) {
        if (c || context == null) {
            return;
        }
        tt(context);
        ve(context);
        uj(context);
        n(context);
        c = true;
    }

    private static void n(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        a.c(1009, new Object[]{Integer.valueOf(telephonyManager != null ? telephonyManager.getSimState() : -1)});
    }

    private static void tt(Context context) {
        boolean booleanExtra;
        double intExtra = -0.1d;
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                booleanExtra = intentRegisterReceiver.getBooleanExtra("present", false);
                try {
                    intExtra = ((double) intentRegisterReceiver.getIntExtra("temperature", -1)) / 10.0d;
                } catch (Throwable unused) {
                }
            } else {
                booleanExtra = true;
            }
        } catch (Throwable unused2) {
        }
        a.c(1006, new Object[]{Boolean.valueOf(booleanExtra), Double.valueOf(intExtra)});
    }

    private static void uj(Context context) {
        int i;
        Configuration configuration = context.getResources().getConfiguration();
        a.c(1008, new Object[]{Boolean.valueOf(configuration == null || !((i = configuration.touchscreen) == 1 || i == 0))});
    }

    private static void ve(Context context) {
        int i;
        int i2;
        CameraManager cameraManager = (CameraManager) context.getSystemService(h.d);
        if (cameraManager != null) {
            try {
                i = 0;
                i2 = 0;
                for (String str : cameraManager.getCameraIdList()) {
                    int iIntValue = ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)).intValue();
                    if (iIntValue == 0) {
                        i++;
                    } else if (iIntValue == 1) {
                        i2++;
                    }
                }
            } catch (Throwable unused) {
                i = -1;
                i2 = i;
            }
            a.c(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
        }
        i = -2;
        i2 = i;
        a.c(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
    }
}
