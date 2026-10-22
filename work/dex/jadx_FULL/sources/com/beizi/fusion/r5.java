package com.beizi.fusion;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class r5 {
    public static String a() {
        return "scope_com";
    }

    public static void a(Context context, String str, String str2, boolean z) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(str2, z);
        editorEdit.apply();
    }

    public static void b(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str2, str3);
        editorEdit.apply();
    }

    public static Set c(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getStringSet(str2, null);
        }
        return null;
    }

    public static boolean a(Context context, String str, String str2, Set set) {
        SharedPreferences sharedPreferences;
        if (context == null || set == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(str2);
        editorEdit.putStringSet(str2, new HashSet(set));
        return editorEdit.commit();
    }

    public static void b(Context context, String str, String str2, long j) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong(str2, j);
        editorEdit.apply();
    }

    public static boolean b(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str2, false);
        }
        return false;
    }

    public static Map a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        return null;
    }

    public static String a(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return sharedPreferences != null ? sharedPreferences.getString(str2, str3) : str3;
    }

    public static long a(Context context, String str, String str2, long j) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return sharedPreferences != null ? sharedPreferences.getLong(str2, j) : j;
    }

    public static boolean a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return false;
        }
        return sharedPreferences.contains(str2);
    }

    public static String a(String str) {
        return String.format("scope_basic_%s", str);
    }
}
