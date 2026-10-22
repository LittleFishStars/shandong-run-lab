package com.baidu.xclient.gdid.j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.baidu.sec.privacy.f.g;
import java.io.File;
import java.io.FileFilter;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26836a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().matches("^cpu\\d+");
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("1", d(context));
            jSONObject2.put("2", com.baidu.xclient.gdid.d.a().a(context));
            jSONObject2.put("3", b(context));
            jSONObject2.put("4", com.baidu.mshield.b.b.a.a(context));
            jSONObject2.put("5", str);
            jSONObject2.put("6", System.currentTimeMillis());
            jSONObject2.put("7", "");
            jSONObject2.put(PrepareException.ERROR_AUTH_FAIL, com.baidu.xclient.gdid.d.c);
            jSONObject2.put("9", com.baidu.xclient.gdid.f.b);
            jSONObject2.put("10", com.baidu.xclient.gdid.f.c);
            jSONObject2.put("11", "");
            jSONObject2.put("12", "");
            jSONObject2.put("13", 1);
            jSONObject2.put("14", com.baidu.xclient.gdid.d.a().c("ws"));
            jSONObject2.put("20", com.baidu.mshield.b.b.a.c(context));
            jSONObject2.put("21", com.baidu.mshield.b.b.a.b(context));
            jSONObject2.put("22", "");
            jSONObject2.put("23", "");
            jSONObject2.put("30", "");
            jSONObject2.put("module_section", jSONArray);
            return jSONObject2;
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static void a(Throwable th) {
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo networkInfoA = com.baidu.mshield.b.e.b.a(context);
            if (networkInfoA == null) {
                return false;
            }
            return networkInfoA.isConnected();
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static byte[] a() {
        char[] cArr = new char[16];
        try {
            char[] charArray = f26836a.toCharArray();
            for (int i = 0; i < 16; i++) {
                int iNextInt = new Random().nextInt(62);
                if (iNextInt >= 0 && iNextInt < charArray.length) {
                    cArr[i] = charArray[iNextInt];
                }
            }
        } catch (Throwable th) {
            a(th);
        }
        return new String(cArr).getBytes();
    }

    public static String b() {
        try {
            return g.a("ro.build.fingerprint", "");
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String b(Context context) {
        String str = "";
        try {
            PackageInfo packageInfoA = com.baidu.mshield.b.e.c.a(context, com.baidu.xclient.gdid.d.a().a(context), 0);
            String str2 = packageInfoA != null ? packageInfoA.versionName : "";
            try {
                return TextUtils.isEmpty(str2) ? "" : str2;
            } catch (Throwable th) {
                str = str2;
                th = th;
                a(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int c() {
        try {
            File file = new File("/sys/devices/system/cpu");
            if (file.exists() && file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles(new a());
                if (fileArrListFiles == null) {
                    return 0;
                }
                return fileArrListFiles.length;
            }
            return -1;
        } catch (Throwable th) {
            a(th);
            return -1;
        }
    }

    public static Pair<String, String> c(Context context) {
        Pair<String, String> pairC = com.baidu.sec.privacy.e.a.a(context).c();
        return pairC == null ? new Pair<>("", "") : pairC;
    }

    public static String d(Context context) {
        try {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }
}
