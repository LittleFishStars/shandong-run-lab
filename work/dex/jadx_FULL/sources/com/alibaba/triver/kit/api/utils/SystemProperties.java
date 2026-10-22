package com.alibaba.triver.kit.api.utils;

import android.text.TextUtils;
import android.util.Log;
import com.acse.ottn.p3;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SystemProperties {
    private static final String TAG = "SystemProperties";

    public static boolean getBooleanValue(String str, String str2) {
        String stringValue = getStringValue(str, str2);
        if ("true".equals(stringValue)) {
            return true;
        }
        AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(stringValue);
        return false;
    }

    public static String getStringValue(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(p3.f, String.class).invoke(cls, str);
        } catch (Exception e) {
            Log.e(TAG, "get() ERROR!!! Exception!", e);
            return "";
        }
    }

    public static boolean hasKeyWithExpectedValue(String str, String str2) {
        return TextUtils.equals(getStringValue(str), str2);
    }

    public static String getStringValue(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            Log.e(TAG, "get() ERROR!!! Exception!", e);
            return str2;
        }
    }
}
