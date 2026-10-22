package com.alibaba.ariver.commonability.core.util;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23950a = "CommonAbility#ConfigService";

    public static String a(String str, String str2) {
        try {
            RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
            return rVConfigService == null ? str2 : rVConfigService.getConfig(str, str2);
        } catch (Exception e) {
            RVLogger.e(f23950a, "getString:" + str, e);
            return str2;
        }
    }

    public static boolean a(String str, boolean z) {
        try {
            String strA = a(str, String.valueOf(z));
            return (TextUtils.equals(strA, "true") || TextUtils.equals(strA, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) ? Boolean.parseBoolean(strA) : z;
        } catch (Exception e) {
            RVLogger.e(f23950a, "getBoolean:" + str, e);
            return z;
        }
    }

    public static int a(String str, int i) {
        try {
            String strA = a(str, String.valueOf(i));
            return !TextUtils.isDigitsOnly(strA) ? i : Integer.parseInt(strA);
        } catch (Exception e) {
            RVLogger.e(f23950a, "getInt:" + str, e);
            return i;
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
            if (rVConfigService != null && !TextUtils.isEmpty(str)) {
                String config = rVConfigService.getConfig(str2, "");
                if (TextUtils.isEmpty(config)) {
                    return str3;
                }
                JSONObject object = JSON.parseObject(config);
                Set<String> setKeySet = object.keySet();
                if (setKeySet.isEmpty()) {
                    return str3;
                }
                for (String str4 : setKeySet) {
                    JSONArray jSONArray = object.getJSONArray(str4);
                    if (!jSONArray.isEmpty() && (jSONArray.contains(str) || jSONArray.contains("all"))) {
                        return str4;
                    }
                }
            }
            return str3;
        } catch (Throwable th) {
            RVLogger.e(f23950a, th);
            return str3;
        }
    }

    public static boolean a(String str, String str2, boolean z) {
        try {
            String strA = a(str, str2, String.valueOf(z));
            return (TextUtils.equals(strA, "true") || TextUtils.equals(strA, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) ? Boolean.parseBoolean(strA) : z;
        } catch (Exception e) {
            RVLogger.e(f23950a, "getBoolean:" + str2, e);
            return z;
        }
    }

    public static int a(String str, String str2, int i) {
        try {
            String strA = a(str, str2, String.valueOf(i));
            return !TextUtils.isDigitsOnly(strA) ? i : Integer.parseInt(strA);
        } catch (Exception e) {
            RVLogger.e(f23950a, "getInt:" + str2, e);
            return i;
        }
    }
}
