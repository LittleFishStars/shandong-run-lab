package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.zj.adlib.u15;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class aj {
    private static final String[] b = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f40036a;

    public aj(Context context) {
        this.f40036a = context;
    }

    public static boolean b() {
        try {
            String strA = bf.a("ro.build.display.id");
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            if (strA.contains("flyme") || strA.toLowerCase().contains("flyme")) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0023 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x0024 A[RETURN] */
    public int a() {
        boolean z;
        try {
            for (String str : a(bg.z)) {
                if (new File(str, "su").exists()) {
                    z = true;
                    if (z) {
                        return 1;
                    }
                    return 0;
                }
            }
            z = false;
            if (z) {
                return 1;
            }
            return 0;
        } catch (Exception unused) {
        }
    }

    public String c() {
        try {
            if (Build.VERSION.SDK_INT > 29) {
                return null;
            }
            return aa.a().b("su -v").replace("\n", "");
        } catch (Exception unused) {
            return null;
        }
    }

    public int d() {
        String strA = aa.a().a("ro.secure");
        return (strA == null || !"0".equals(strA)) ? 1 : 0;
    }

    public int e() {
        String strA = aa.a().a("ro.debuggable");
        return (strA == null || !"0".equals(strA)) ? 1 : 0;
    }

    public int f() {
        String strA = aa.a().a("ro.adb.secure");
        return (strA == null || !"0".equals(strA)) ? 1 : 0;
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            String strA = a(" which su ");
            if (TextUtils.isEmpty(strA) || strA.length() <= 2) {
                jSONObject.put("0", 0);
            } else {
                jSONObject.put("0", 1);
                jSONObject.put("0-p", strA);
            }
            String strA2 = a(" id ");
            if (!TextUtils.isEmpty(strA2)) {
                if (strA2.toLowerCase().contains("uid=0")) {
                    jSONObject.put("1", 1);
                } else {
                    jSONObject.put("1", 0);
                }
            }
            String strA3 = a(" busybox df ");
            if (!TextUtils.isEmpty(strA3) && !strA3.contains("not found")) {
                if (strA3.length() > 30) {
                    jSONObject.put("2", 1);
                } else {
                    jSONObject.put("2", 0);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int h() {
        return new File("/system/app/Superuser.apk").exists() ? 1 : 0;
    }

    public String i() {
        for (String str : b) {
            if (new File(str, "magisk").exists()) {
                return str + "magisk";
            }
        }
        return "";
    }

    public String j() {
        for (String str : b) {
            if (new File(str, "su").exists()) {
                return str + "su";
            }
        }
        return "";
    }

    public String k() {
        try {
            throw new Exception("");
        } catch (Exception e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") || stackTraceElement.getMethodName().equals("invoked") || stackTraceElement.getMethodName().equals("main") || stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    return stackTraceElement.getClassName();
                }
            }
            return "";
        }
    }

    private String[] a(String[] strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        try {
            String str = System.getenv("PATH");
            if (str != null && !"".equals(str)) {
                String[] strArrSplit = str.split(u15.f19942b);
                int length = strArrSplit.length;
                for (int i = 0; i < length; i++) {
                    String str2 = strArrSplit[i];
                    if (!str2.endsWith(WVNativeCallbackUtil.SEPERATER)) {
                        str2 = str2 + '/';
                    }
                    if (!arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                return (String[]) arrayList.toArray(new String[0]);
            }
            return (String[]) arrayList.toArray(new String[0]);
        } catch (Exception unused) {
        }
    }

    public String a(String str) {
        try {
            return aa.a().b(str).replace("\n", "");
        } catch (Exception unused) {
            return "";
        }
    }
}
