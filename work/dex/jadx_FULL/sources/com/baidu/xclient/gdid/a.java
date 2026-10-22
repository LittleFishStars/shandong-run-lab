package com.baidu.xclient.gdid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.xclient.gdid.jni.Native;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {
    public static Object a(int i, Object obj, Object obj2, Object obj3) {
        return d.a().a(i, obj, obj2, obj3);
    }

    public static String a(Context context) {
        return com.baidu.xclient.gdid.jni.c.a(context).j();
    }

    public static String a(String str) {
        return d.a().a(str);
    }

    public static JSONObject a() {
        return d.a().c();
    }

    public static void a(Context context, String str, String str2) {
        d.a().a(context, str, str2);
    }

    public static void a(Context context, String str, String str2, HashMap<String, String> map) {
        d.a().a(context, str, str2, map);
    }

    public static void a(HashMap<String, String> map) {
        d.a().a(map);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return new Native().ac(bArr, bArr2);
    }

    public static String b() {
        return d.a().e();
    }

    public static String b(Context context) {
        return com.baidu.xclient.gdid.jni.c.a(context).i();
    }

    public static String b(String str) {
        return d.a().b(str);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return new Native().dc(bArr, bArr2);
    }

    public static String c(Context context) {
        return (String) com.baidu.xclient.gdid.j.d.c(context).first;
    }

    public static void c() {
        d.a().b();
    }

    public static String d(Context context) {
        return "";
    }

    public static String e(Context context) {
        return com.baidu.xclient.gdid.jni.c.a(context).h();
    }

    public static boolean f(Context context) {
        return TextUtils.isEmpty(com.baidu.xclient.gdid.jni.c.a(context).a());
    }

    public static String g(Context context) {
        return com.baidu.xclient.gdid.jni.c.a(context).f();
    }

    public static String h(Context context) {
        return com.baidu.xclient.gdid.jni.c.a(context).g();
    }
}
