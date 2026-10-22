package cj.mobile.p;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import cj.mobile.a.s;
import com.kc.openset.constant.DeviceIdType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22642a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static int e = -1;
    public static String f = "";

    public static String a(Context context) {
        String str = "";
        if (!"".equals(b.T)) {
            return b.T;
        }
        try {
            if (j.b(context, "and_id").equals("")) {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                a(context, string);
                return string;
            }
            char[] charArray = j.b(context, "and_id").toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (i % 2 == 0) {
                    str = str + charArray[i];
                }
            }
            b.T = str;
            return str;
        } catch (Exception unused) {
            b.T = "f0f0f0f0f0f0";
            return "f0f0f0f0f0f0";
        }
    }

    public static void b(Context context, String str) {
        j.a(context, DeviceIdType.IMEI, str);
    }

    public static void c(Context context, String str) {
        j.a(context, DeviceIdType.OAID, str);
        j.a(context, "cj-oaid", str);
    }

    public static String d(Context context) {
        if (!f.equals("")) {
            return f;
        }
        if (context == null) {
            return "0000-0000-0000-0000";
        }
        if (j.b(context, "random").equals("")) {
            String strA = a();
            f = strA;
            j.a(context, "random", strA);
        } else {
            f = j.b(context, "random");
        }
        return f;
    }

    public static String e(Context context) {
        String str = b.S;
        if (str == null || str.equals("")) {
            b.S = j.b(context, DeviceIdType.IMEI);
        }
        return b.S;
    }

    public static String f(Context context) {
        String str = b.R;
        if (str == null || str.equals("")) {
            b.R = j.b(context, DeviceIdType.OAID);
        }
        String str2 = b.R;
        if (str2 != null && !str2.equals("")) {
            return b.R;
        }
        if (b.k0) {
            try {
                Class.forName("cj.mobile.wm.appsdkdex.WMAdSdk");
                String strA = new s().a(context);
                if (strA != null && !strA.equals("")) {
                    b.R = strA;
                    c(context, strA);
                }
            } catch (Exception unused) {
            }
        }
        return b.R;
    }

    public static String b() {
        String str = f22642a;
        if (str == null || str.equals("")) {
            try {
                f22642a = Build.BRAND;
            } catch (Exception unused) {
                f22642a = "unknown";
            }
        }
        return f22642a;
    }

    public static String c() {
        String str = b;
        if (str != null && str.equals("")) {
            try {
                b = Build.MODEL;
            } catch (Exception unused) {
                b = "unknown";
            }
        }
        return b;
    }

    public static int b(Context context) {
        if (e == -1) {
            if (context != null) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
                    if (packageInfo != null) {
                        e = packageInfo.versionCode;
                    } else {
                        e = 0;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    e = 0;
                }
            } else {
                e = -1;
            }
        }
        return e;
    }

    public static String c(Context context) {
        String str = d;
        if (str == null || str.equals("")) {
            if (context != null) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
                    if (packageInfo != null) {
                        d = packageInfo.versionName;
                    } else {
                        d = "unknown";
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    d = "unknown";
                }
            } else {
                d = "context=null";
            }
        }
        return d;
    }

    public static String d() {
        String str = c;
        if (str == null || str.equals("")) {
            try {
                c = Build.VERSION.RELEASE;
            } catch (Exception unused) {
                c = "unknown";
            }
        }
        return c;
    }

    public static void a(Context context, String str) {
        b.T = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append(str.charAt(i));
            stringBuffer.append(str.charAt(i));
        }
        j.a(context, "and_id", stringBuffer.toString());
    }

    public static String a() {
        String str = System.currentTimeMillis() + "";
        for (int i = 0; i < 10; i++) {
            str = str + ((char) ((Math.random() * 26.0d) + 97.0d));
        }
        return str;
    }
}
