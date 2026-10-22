package com.jiagu.sdk;

import android.app.Application;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OSETSDKProtected {
    private static Map<Integer, String> strings;

    static {
        System.loadLibrary("jiagu_sdk_OSETSDKProtected");
        strings = new ConcurrentHashMap();
    }

    public static String getString2(int i) {
        String str = strings.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        String strInterface14 = interface14(i);
        strings.put(Integer.valueOf(i), strInterface14);
        return strInterface14;
    }

    public static String getString2(String str) {
        try {
            return getString2(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void install(Application application) {
    }

    public static native void interface11(int i);

    public static native String interface14(int i);
}
