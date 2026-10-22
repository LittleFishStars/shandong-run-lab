package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.utils.Checker;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class OpenDevice {
    private OpenDevice() {
    }

    public static OpenDeviceClient getOpenDeviceClient(Context context) {
        Checker.assertNonNull(context);
        return new OpenDeviceClientImpl(context);
    }
}
