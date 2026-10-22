package com.efs.sdk.launch;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.ProcessUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f29632a = "";

    public static String a(Context context) {
        Class<?> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.UMConfigure");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getUMIDString", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, context);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putString("first_launch_cache", str);
        editorEdit.commit();
    }

    public static String b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null) {
            return null;
        }
        return sharedPreferences.getString("first_launch_cache", null);
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putString("first_launch_cache", null);
        editorEdit.commit();
    }

    public static boolean d(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences2;
        if ((context == null || (sharedPreferences2 = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null) ? false : sharedPreferences2.getBoolean("is_install", false)) {
            return false;
        }
        if (context != null && (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) != null && (editorEdit = sharedPreferences.edit()) != null) {
            editorEdit.putBoolean("is_install", true);
            editorEdit.commit();
        }
        return true;
    }

    public static boolean e(Context context) {
        try {
            String currentProcessName = ProcessUtil.getCurrentProcessName();
            String packageName = context.getApplicationContext().getPackageName();
            return (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
