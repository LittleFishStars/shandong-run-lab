package cn.hzjizhun.admin.base;

import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.e;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22703a;
    public static String b;

    public static String a() {
        if (b == null) {
            String str = f22703a;
            if (str != null) {
                str.equals("");
            } else {
                String strB = b(XmSystemUtils.KEY_VERSION_MIUI);
                b = strB;
                if (TextUtils.isEmpty(strB)) {
                    String strB2 = b("ro.build.version.emui");
                    b = strB2;
                    if (TextUtils.isEmpty(strB2)) {
                        String strB3 = b(e.d);
                        b = strB3;
                        if (TextUtils.isEmpty(strB3)) {
                            String strB4 = b("ro.vivo.os.version");
                            b = strB4;
                            if (TextUtils.isEmpty(strB4)) {
                                String strB5 = b("ro.smartisan.version");
                                b = strB5;
                                if (TextUtils.isEmpty(strB5)) {
                                    String strB6 = b("ro.build.version.oplusrom");
                                    b = strB6;
                                    if (TextUtils.isEmpty(strB6)) {
                                        String str2 = Build.DISPLAY;
                                        b = str2;
                                        if (str2.toUpperCase().contains("FLYME")) {
                                            f22703a = "FLYME";
                                        } else {
                                            b = "unknown";
                                            f22703a = Build.MANUFACTURER.toUpperCase();
                                        }
                                    } else {
                                        f22703a = "ONEPLUS";
                                    }
                                } else {
                                    f22703a = "SMARTISAN";
                                }
                            } else {
                                f22703a = "VIVO";
                            }
                        } else {
                            f22703a = "OPPO";
                        }
                    } else {
                        f22703a = "EMUI";
                    }
                } else {
                    f22703a = "MIUI";
                }
                f22703a.equals("");
            }
        }
        return b;
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(str)).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                    return line;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return line;
                }
            } catch (Throwable unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }
}
