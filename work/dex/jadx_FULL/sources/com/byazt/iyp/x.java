package com.byazt.iyp;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 71})
public final class x {
    public static volatile String c;
    public static volatile String tt;
    public static final String[] uj = {"android.app", "android.os", "android.view.Choreographer", "android.view.View.perform", "android.view.ViewRootImpl", "androidx.compose", "androidx.activity.compose", "androidx.recyclerview.widget.LinearLayoutManager", "androidx.recyclerview.widget.GridLayoutManager", "androidx.recyclerview.widget.StaggeredGridLayoutManager", "androidx.recyclerview.widget.LinearLayoutManager", "androidx.recyclerview.widget.GridLayoutManager", "androidx.recyclerview.widget.StaggeredGridLayoutManager"};
    public static volatile String ve;

    private x() {
    }

    private static boolean c(String str) {
        if (str == null) {
            return true;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'd') {
            if (str.startsWith("dalvik.")) {
                return true;
            }
        } else if (cCharAt == 'j') {
            if (str.startsWith("java.lang.Thread") || str.startsWith("java.lang.reflect.") || str.startsWith("javax")) {
                return true;
            }
        } else if (cCharAt == 'c') {
            if (str.startsWith("com.android.")) {
                return true;
            }
        } else {
            if (cCharAt != 'a') {
                if (cCharAt != 'k' || (!str.startsWith("kotlin.") && !str.startsWith("kotlinx."))) {
                    break;
                }
                return true;
            }
            int i = 0;
            while (true) {
                String[] strArr = uj;
                if (i >= strArr.length) {
                    break;
                }
                if (str.startsWith(strArr[i])) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    private static String tt() {
        return c(1, x.class.getName(), 2);
    }

    private static String c(int i) {
        if (i == 1) {
            return c;
        }
        if (i != 2) {
            return i != 3 ? "" : ve;
        }
        return tt;
    }

    private static void c(int i, String str) {
        if (i == 1) {
            c = str;
        } else if (i == 2) {
            tt = str;
        } else {
            if (i != 3) {
                return;
            }
            ve = str;
        }
    }

    private static String c(int i, String str, int i2) {
        String strC = c(i);
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        String strC2 = c(str, i2);
        c(i, strC2);
        return strC2;
    }

    private static String c(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length < 2) {
            return "";
        }
        if (strArrSplit.length < i || !"com".equals(strArrSplit[0])) {
            i = Math.min(i, strArrSplit.length - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append('.');
            }
            sb.append(strArrSplit[i2]);
        }
        return sb.toString();
    }

    private static boolean c(String str, String str2) {
        int length;
        int length2;
        if (TextUtils.isEmpty(str2) || (length = str.length()) < (length2 = str2.length()) || str.charAt(0) != str2.charAt(0)) {
            return false;
        }
        if (length2 <= 1 || length <= 1 || str.charAt(1) == str2.charAt(1)) {
            return str.startsWith(str2);
        }
        return false;
    }

    public static boolean c(float f, String str) {
        if (f <= 0.0f) {
            return false;
        }
        if (f >= 1.0f) {
            return true;
        }
        return ((str != null ? str.hashCode() : (int) System.nanoTime()) & Integer.MAX_VALUE) % 1000000 < ((int) (f * 1000000.0f));
    }

    public static StackTraceElement[] c() {
        return Thread.currentThread().getStackTrace();
    }

    public static JSONArray c(StackTraceElement[] stackTraceElementArr, int i) {
        return c(stackTraceElementArr, i, false, true);
    }

    public static String c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        return com.byazt.nr.a.tt(jSONArray.toString());
    }

    private static JSONArray c(StackTraceElement[] stackTraceElementArr, int i, boolean z, boolean z2) {
        String className;
        StringBuilder sb;
        JSONArray jSONArray = new JSONArray();
        if (i > 0 && stackTraceElementArr != null && stackTraceElementArr.length != 0) {
            String strTt = tt();
            boolean z3 = !TextUtils.isEmpty(strTt);
            int i2 = 0;
            for (int i3 = 0; i3 < stackTraceElementArr.length && i2 < i; i3++) {
                StackTraceElement stackTraceElement = stackTraceElementArr[i3];
                if (stackTraceElement != null && (className = stackTraceElement.getClassName()) != null && className.length() != 0 && !c(className) && ((!z3 || !c(className, strTt) || c(stackTraceElement)) && !c(className, "com.byazt"))) {
                    if (z) {
                        String fileName = stackTraceElement.getFileName();
                        int lineNumber = stackTraceElement.getLineNumber();
                        sb = new StringBuilder(className.length() + 24);
                        sb.append(className);
                        sb.append('.');
                        sb.append(stackTraceElement.getMethodName());
                        sb.append('(');
                        if (fileName != null) {
                            sb.append(fileName);
                        }
                        sb.append(com.google.common.net.c.b);
                        sb.append(lineNumber);
                        sb.append(')');
                    } else {
                        sb = new StringBuilder(className.length() + 8);
                        sb.append(className);
                        sb.append('.');
                        sb.append(stackTraceElement.getMethodName());
                    }
                    jSONArray.put(sb.toString());
                    i2++;
                }
            }
        }
        return jSONArray;
    }

    private static boolean c(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            return false;
        }
        String methodName = stackTraceElement.getMethodName();
        if (TextUtils.isEmpty(methodName)) {
            return false;
        }
        if (methodName.startsWith(TrackLoadSettingsAtom.TYPE)) {
            return methodName.endsWith("Ad") || "loadStream".equals(methodName);
        }
        return "showRewardVideoAd".equals(methodName) || "showFullScreenVideoAd".equals(methodName) || "showSplashView".equals(methodName) || "getAdView".equals(methodName) || "getExpressAdView".equals(methodName) || "getSplashView".equals(methodName) || "getSplashCardView".equals(methodName);
    }
}
