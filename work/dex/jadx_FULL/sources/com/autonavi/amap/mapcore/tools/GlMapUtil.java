package com.autonavi.amap.mapcore.tools;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.TypedValue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GlMapUtil {
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_1 = 2;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_1_EAGLE_EYE = 3;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_2 = 4;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_2_EAGLE_EYE = 5;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_3 = 6;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_3_EAGLE_EYE = 7;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_1 = 3;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_1_EAGLE_EYE = 4;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_2 = 5;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_2_EAGLE_EYE = 6;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_3 = 7;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_3_EAGLE_EYE = 8;
    public static final int AN_ENGINE_ID_EAGLE_EYE = 2;
    public static final int AN_ENGINE_ID_INVALID = -1;
    public static final int AN_ENGINE_ID_MAIN = 1;
    public static final int DEVICE_DISPLAY_DPI_HIGH = 320;
    public static final int DEVICE_DISPLAY_DPI_LOW = 120;
    public static final int DEVICE_DISPLAY_DPI_MEDIAN = 240;
    public static final int DEVICE_DISPLAY_DPI_NORMAL = 160;
    public static final int DEVICE_DISPLAY_DPI_XHIGH = 480;
    public static final int DEVICE_DISPLAY_DPI_XXHIGH = 640;

    public static byte[] decodeAssetResData(Context context, String str) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i < 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    inputStreamOpen.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (IOException | OutOfMemoryError unused) {
            return null;
        }
    }

    public static int dipToPixel(Context context, int i) {
        if (context == null) {
            return i;
        }
        try {
            return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
        } catch (Exception unused) {
            return i;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String getString(Context context, int i) {
        return context.getResources().getString(i);
    }

    public static boolean isAssic(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c >= 256 || c <= 0) {
                return false;
            }
        }
        return true;
    }

    public static int spToPixel(Context context, int i) {
        return (int) TypedValue.applyDimension(2, i, context.getResources().getDisplayMetrics());
    }
}
