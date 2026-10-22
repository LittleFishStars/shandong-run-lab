package com.efs.sdk.base.custommapping;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InnerCustomMappingManager {
    private static final int MAX_SIZE = 10;
    private static final int MAX_VALUE_LENGTH = 100;
    private static final String TAG = "CustomMappingManager";
    private static final JSONObject sCustomMappingObj = new JSONObject();
    private static final List<String> STRING_PARAMS_LIST = new ArrayList(Arrays.asList("s1", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10"));

    public static String getCustomMappingJsonStr() {
        String string;
        synchronized (InnerCustomMappingManager.class) {
            try {
                string = sCustomMappingObj.toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return string;
    }

    public static String getStringParam(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !STRING_PARAMS_LIST.contains(str)) {
            Log.e(TAG, "illegal parameter in getStringParam(String key): key/value can't be empty and key must be UAPMCustomMapping.java.");
            return null;
        }
        synchronized (InnerCustomMappingManager.class) {
            try {
                str2 = (String) sCustomMappingObj.opt(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return str2;
    }

    public static boolean putStringParam(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !STRING_PARAMS_LIST.contains(str)) {
            Log.e(TAG, "illegal parameter in putStringParam(String key, String value): key/value can't be empty and key must be UAPMCustomMapping.java.");
            return false;
        }
        if (str2.length() > 100) {
            Log.e(TAG, "illegal parameter in putStringParam(String key, String value): value's length must be less than 100.");
            return false;
        }
        synchronized (InnerCustomMappingManager.class) {
            try {
                sCustomMappingObj.put(str, str2);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
