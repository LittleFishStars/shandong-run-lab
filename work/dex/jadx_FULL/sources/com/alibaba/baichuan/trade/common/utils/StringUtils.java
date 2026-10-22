package com.alibaba.baichuan.trade.common.utils;

import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StringUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24571a = "StringUtils";

    public static boolean obj2Boolean(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            return str2Boolean(String.valueOf(obj));
        }
        return false;
    }

    public static Long obj2Long(Object obj) {
        if (obj != null) {
            try {
                return Long.valueOf(Long.parseLong(obj.toString()));
            } catch (Exception e) {
                AlibcLogger.e(f24571a, "object to long exception: " + e.getMessage());
            }
        }
        return -1L;
    }

    public static Map<String, Object> obj2MapObject(Object obj) {
        try {
            return (Map) obj;
        } catch (Exception e) {
            AlibcLogger.w(f24571a, Log.getStackTraceString(e));
            return null;
        }
    }

    public static Map<String, String> obj2MapString(Object obj) {
        try {
            return (Map) obj;
        } catch (Exception e) {
            AlibcLogger.e(f24571a, "Object casted to Map exception: " + e.getMessage());
            return null;
        }
    }

    public static String obj2String(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static boolean str2Boolean(String str) {
        return "true".equals(str.toLowerCase()) || "1".equals(str) || "YES".equals(str);
    }
}
