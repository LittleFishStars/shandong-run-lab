package cj.mobile.wm;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f1 {
    public static String dexa;

    public static String dexa(Throwable th) {
        if (th == null) {
            return "本次throwable为null";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.toString();
    }

    public static void dexa(Exception exc) {
        dexa("", exc);
    }

    public static void dexa(String str, Exception exc) {
        dexa(str, exc, "");
    }

    public static void dexa(String str, Exception exc, String str2) {
        if (dexd(str, "e")) {
            dexb("InsightSDK", "[" + str + "] " + dexa((Throwable) exc), "e");
        }
    }

    public static void dexa(String str, String str2) {
        if (dexd(str, "d")) {
            dexb("InsightSDK", "[" + str + "] " + str2, "d");
        }
    }

    public static void dexa(String str, String str2, String str3) {
        if (dexd(str, "e")) {
            dexb("InsightSDK", "[" + str + "] " + str2, "e");
        }
    }

    public static void dexa(String str, String str2, Throwable th) {
        if (dexd(str, "d")) {
            dexb("InsightSDK", "[" + str + "] " + str2 + dexa(th), "d");
        }
    }

    public static void dexa(String str, String... strArr) {
        if (dexd(str, "d")) {
            dexb("InsightSDK", dexb(str, strArr), "d");
        }
    }

    public static boolean dexa() {
        if (dexa == null) {
            dexa = be.dexa("debug.insight.log.enable", "0");
        }
        return "1".equals(dexa);
    }

    public static String dexb(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static void dexb(String str, String str2) {
        dexa(str, str2, "");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void dexb(String str, String str2, String str3) {
        String strSubstring = str2 + " [SDK Version:]";
        int length = 2001 - str.length();
        str3.hashCode();
        switch (str3) {
            case "d":
                while (strSubstring.length() > length) {
                    Log.d(str, strSubstring.substring(0, length));
                    strSubstring = strSubstring.substring(length);
                }
                Log.d(str, strSubstring);
                break;
            case "e":
                while (strSubstring.length() > length) {
                    Log.e(str, strSubstring.substring(0, length));
                    strSubstring = strSubstring.substring(length);
                }
                Log.e(str, strSubstring);
                break;
            case "i":
                while (strSubstring.length() > length) {
                    Log.i(str, strSubstring.substring(0, length));
                    strSubstring = strSubstring.substring(length);
                }
                Log.i(str, strSubstring);
                break;
            case "v":
                while (strSubstring.length() > length) {
                    Log.v(str, strSubstring.substring(0, length));
                    strSubstring = strSubstring.substring(length);
                }
                Log.v(str, strSubstring);
                break;
            case "w":
                while (strSubstring.length() > length) {
                    Log.w(str, strSubstring.substring(0, length));
                    strSubstring = strSubstring.substring(length);
                }
                Log.w(str, strSubstring);
                break;
        }
    }

    public static void dexb(String str, String str2, Throwable th) {
        String str3 = str2 + dexa(th);
        if (dexd(str, "e")) {
            dexb("InsightSDK", "[" + str + "] " + str3, "e");
        }
    }

    public static void dexc(String str, String str2) {
        if (dexd(str, "i")) {
            dexb("InsightSDK", "[" + str + "] " + str2, "i");
        }
    }

    public static boolean dexd(String str, String str2) {
        return dexa();
    }
}
