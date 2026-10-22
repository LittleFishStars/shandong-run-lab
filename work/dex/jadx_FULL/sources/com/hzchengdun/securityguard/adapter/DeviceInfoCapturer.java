package com.hzchengdun.securityguard.adapter;

import android.content.Context;
import com.hzchengdun.securityguard.open.SecurityGuardManager;
import com.ut.device.UTDevice;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class DeviceInfoCapturer {
    private static final int COMMAND_GET_PACKAGE_NAME = 122;
    private static final int COMMAND_GET_UTDID = 135;

    private DeviceInfoCapturer() {
    }

    public static String doCommandForString(int i) {
        String packageName;
        try {
            if (i != 122) {
                if (i == 135) {
                    packageName = getUTDID();
                }
                return null;
            }
            packageName = SecurityGuardManager.getContext().getPackageName();
            return packageName;
        } catch (Exception unused) {
        }
    }

    private static String getUTDID() {
        String str;
        Exception e;
        try {
            str = (String) UTDevice.class.getMethod("getUtdid", Context.class).invoke(null, SecurityGuardManager.getContext());
            if (str != null) {
                try {
                    if (str.contains("?")) {
                        str = "";
                    }
                } catch (Exception e2) {
                    e = e2;
                    System.err.println(e);
                }
            }
        } catch (Exception e3) {
            str = null;
            e = e3;
        }
        return str != null ? str : "";
    }
}
