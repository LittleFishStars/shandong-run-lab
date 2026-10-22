package com.efs.sdk.h5pagesdk;

import android.util.Log;
import android.webkit.JavascriptInterface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class UApmJSBridge {
    @JavascriptInterface
    public String getLaunchOptionsSync() {
        try {
            if (H5Manager.getH5ConfigMananger() == null) {
                if (H5Manager.isDebug) {
                    Log.d("getLaunchOptionsSync", "H5Manager.getH5ConfigMananger() is null.");
                }
                return "";
            }
            String strGenerateLaunchOptions = H5Manager.getH5ConfigMananger().generateLaunchOptions();
            if (H5Manager.isDebug) {
                Log.d("getLaunchOptionsSync", strGenerateLaunchOptions);
            }
            return strGenerateLaunchOptions;
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void sendData(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (H5Manager.isDebug) {
                        Log.d("sendData", str);
                    }
                    if (H5Manager.getH5ConfigMananger() != null) {
                        H5Manager.getH5ConfigMananger().sendData(str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
