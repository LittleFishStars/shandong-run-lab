package android.taobao.windvane.extra.c;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.util.TaoLog;
import com.uc.webview.export.extension.UCCore;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21225a = "WVCoreUtils";
    public static final String b = "ISX86";
    public static final long c = 0;
    public static final long d = 1;
    public static final long e = 2;
    private static String f = null;
    private static String g = null;
    private static String[] h = null;
    private static String i = null;
    private static String[] j = null;
    private static String k = null;
    private static final String l = "libkernelu4_7z_uc.so";
    private static final String m = "lib";

    public static void a(int i2) {
    }

    public static boolean a(String str) {
        String str2;
        String strD;
        String str3;
        if (k == null) {
            k = System.getProperty("os.arch");
        }
        String str4 = k;
        if (str4 != null && str4.toLowerCase().contains(str)) {
            return true;
        }
        if (f == null) {
            try {
                f = Build.CPU_ABI;
                g = Build.CPU_ABI2;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String str5 = f;
        if (str5 != null && str5.toLowerCase().contains(str)) {
            return true;
        }
        if (h == null) {
            try {
                h = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        String[] strArr = h;
        if (strArr != null && strArr.length > 0 && (str3 = strArr[0]) != null && str3.toLowerCase().contains(str)) {
            return true;
        }
        if (i == null) {
            i = d("ro.product.cpu.abi");
        }
        String str6 = i;
        if (str6 != null && str6.toLowerCase().contains(str)) {
            return true;
        }
        if (j == null && (strD = d("ro.product.cpu.abilist")) != null && strD.length() != 0) {
            j = strD.split(",");
        }
        String[] strArr2 = j;
        return strArr2 != null && strArr2.length > 0 && (str2 = strArr2[0]) != null && str2.toLowerCase().contains(str);
    }

    public static String b(String str) {
        return new File(str, l).getAbsolutePath();
    }

    public static void b() {
    }

    public static void c(String str) {
    }

    private static boolean c() {
        try {
            Object objInvoke = ClassLoader.class.getDeclaredMethod("findLibrary", String.class).invoke(GlobalConfig.context.getClassLoader(), "art");
            if (objInvoke != null) {
                return ((String) objInvoke).contains("lib64");
            }
            return false;
        } catch (Exception unused) {
            return d();
        }
    }

    private static boolean d() {
        String[] strArr = Build.SUPPORTED_ABIS;
        String str = strArr.length > 0 ? strArr[0] : null;
        return str != null && str.contains("arm64");
    }

    public static String b(Context context) {
        return a(context, context.getApplicationInfo().nativeLibraryDir);
    }

    private static String d(String str) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        try {
            fileInputStream = new FileInputStream(new File("/system/build.prop"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.contains(str)) {
                                String[] strArrSplit = line.split("=");
                                if (strArrSplit.length == 2 && strArrSplit[0].trim().equals(str)) {
                                    String strTrim = strArrSplit[1].trim();
                                    a(bufferedReader);
                                    a(inputStreamReader);
                                    a(fileInputStream);
                                    return strTrim;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                th.printStackTrace();
                            } finally {
                                a(bufferedReader);
                                a(inputStreamReader);
                                a(fileInputStream);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            fileInputStream = null;
            bufferedReader = null;
        }
        return null;
    }

    public static boolean a() {
        boolean zIs64Bit = Process.is64Bit();
        TaoLog.i(f21225a, "is 64 bit = [" + zIs64Bit + "]");
        return zIs64Bit;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String a(Context context) {
        return b(context.getApplicationInfo().nativeLibraryDir);
    }

    public static String a(Context context, String str) {
        return new File(UCCore.getExtractDirPath(context, b(str)), m).getAbsolutePath();
    }
}
