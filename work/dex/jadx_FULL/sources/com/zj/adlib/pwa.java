package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class pwa {
    public static Long a(Context context, String str, String str2, Long l) {
        Object objD = d(context, str, str2, l);
        return objD != null ? (Long) objD : l;
    }

    public static String b(Context context, String str, String str2, String str3) {
        Object objD = d(context, str, str2, str3);
        return objD != null ? (String) objD : str3;
    }

    public static void c(Context context, String str, String str2, Object obj) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        if (obj instanceof String) {
            editorEdit.putString(str2, (String) obj);
        } else if (obj instanceof Integer) {
            editorEdit.putInt(str2, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            editorEdit.putBoolean(str2, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            editorEdit.putFloat(str2, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            editorEdit.putLong(str2, ((Long) obj).longValue());
        } else {
            editorEdit.putString(str2, obj.toString());
        }
        editorEdit.apply();
    }

    public static Object d(Context context, String str, String str2, Object obj) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (obj instanceof String) {
            return sharedPreferences.getString(str2, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str2, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str2, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str2, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str2, ((Long) obj).longValue()));
        }
        return null;
    }
}
