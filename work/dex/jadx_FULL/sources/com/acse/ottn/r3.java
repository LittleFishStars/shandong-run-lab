package com.acse.ottn;

import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23176a = "RomUtils";

    /* JADX WARN: Code duplicated, block: B:38:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0064: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:24:0x0064 */
    public static String a(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    String line = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        h2.a(f23176a, "Exception while closing InputStream", e);
                    }
                    return line;
                } catch (IOException e2) {
                    e = e2;
                    h2.a(f23176a, "Unable to read sysprop " + str, e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            h2.a(f23176a, "Exception while closing InputStream", e3);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e4) {
                        h2.a(f23176a, "Exception while closing InputStream", e4);
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
                bufferedReader3.close();
            }
            throw th;
        }
    }

    public static boolean b() {
        return Build.MANUFACTURER.contains("HUAWEI");
    }

    public static boolean c() throws Throwable {
        String strA = a("ro.build.display.id");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return strA.contains("flyme") || strA.toLowerCase().contains("flyme");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(a(XmSystemUtils.KEY_VERSION_MIUI));
    }

    public static boolean e() {
        String str = Build.MANUFACTURER;
        return str.contains("OPPO") || str.contains("oppo");
    }

    public static double f() throws Throwable {
        try {
            String strA = a("ro.build.version.emui");
            return Double.parseDouble(strA.substring(strA.indexOf(LoginConstants.UNDER_LINE) + 1));
        } catch (Exception e) {
            e.printStackTrace();
            return 4.0d;
        }
    }

    public static int g() throws Throwable {
        String strA = a(XmSystemUtils.KEY_VERSION_MIUI);
        if (strA == null) {
            return -1;
        }
        try {
            return Integer.parseInt(strA.substring(1));
        } catch (Exception unused) {
            h2.b(f23176a, "get miui version code error, version : " + strA);
            return -1;
        }
    }

    public static boolean a() {
        String str = Build.MANUFACTURER;
        return str.contains("QiKU") || str.contains("360");
    }
}
