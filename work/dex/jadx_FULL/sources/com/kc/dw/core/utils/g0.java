package com.kc.dw.core.utils;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.domain.SdkAdInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.net.URLEncoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f39365a = 0;

    public static String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            return TextUtils.replace(str, new String[]{"__MS_EVENT_SEC__", "__MS_EVENT_MSEC__"}, new String[]{String.valueOf(jCurrentTimeMillis / 1000), String.valueOf(jCurrentTimeMillis)}).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, int i) {
        try {
            return TextUtils.isEmpty(str) ? str : TextUtils.replace(str, new String[]{"__REWARD_TMP_ID__"}, new String[]{String.valueOf(i)}).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static String a(String str, int i, int i2) {
        try {
            return TextUtils.isEmpty(str) ? "" : TextUtils.replace(str, new String[]{"__WIDTH__", "__HEIGHT__"}, new String[]{String.valueOf((int) DimensionUtils.px2dip(com.kc.dw.base.a.getContext(), i)), String.valueOf((int) DimensionUtils.px2dip(com.kc.dw.base.a.getContext(), i2))}).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, int i, AdType adType) {
        try {
            int iA = h.a(i, adType.value());
            if (adType != AdType.SPLASH) {
                if ((i & 128) == 128) {
                    iA &= -129;
                }
                if ((i & 32) == 32) {
                    iA &= -33;
                }
            }
            return str.replace("__MS_CT__", iA + "");
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static String a(String str, long j) {
        try {
            return TextUtils.isEmpty(str) ? "" : TextUtils.replace(str, new String[]{"__FINAL__", "__PST__"}, new String[]{String.valueOf(1), String.valueOf(j)}).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void a(SdkAdInfo sdkAdInfo, View view) {
        if (sdkAdInfo == null || view == null) {
            return;
        }
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            String imp = sdkAdInfo.getImp();
            if (!TextUtils.isEmpty(imp)) {
                sdkAdInfo.setImp(a(imp, width, height));
            }
            String clk = sdkAdInfo.getClk();
            if (TextUtils.isEmpty(clk)) {
                return;
            }
            sdkAdInfo.setClk(a(clk, width, height));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] a(String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    for (int i = 0; i < strArr.length; i++) {
                        strArr[i] = TextUtils.replace(strArr[i], new String[]{"__M_SHOW_RATI__", "__M_SCREEN_X__", "__M_SCREEN_Y__"}, new String[]{String.valueOf(100), String.valueOf(0), String.valueOf(0)}).toString();
                    }
                    LogUtil.dev("g0", "replaceHWParams fullscreen");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return strArr;
    }

    public static String[] a(String[] strArr, int i) {
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        strArr[i2] = TextUtils.replace(strArr[i2], new String[]{"__MS_DP_OPEN__"}, new String[]{String.valueOf(i)}).toString();
                    }
                    LogUtil.dev("g0", "replaceDPOpen");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return strArr;
    }

    public static String[] a(String[] strArr, View view, View view2) {
        String str;
        int measuredHeight;
        int iWidth;
        int iHeight;
        int measuredWidth;
        if (strArr != null) {
            try {
                if (strArr.length != 0 && view != null) {
                    Rect rect = new Rect();
                    int[] iArr = new int[2];
                    if (view.getGlobalVisibleRect(rect)) {
                        iWidth = rect.width();
                        iHeight = rect.height();
                        view.getLocationInWindow(iArr);
                        measuredWidth = view.getMeasuredWidth();
                        measuredHeight = view.getMeasuredHeight();
                    } else {
                        if (view2 == null) {
                            str = "replaceHWParams view not visible";
                        } else if (view2.getGlobalVisibleRect(rect)) {
                            LogUtil.dev("g0", "replaceHWParams backUpView visible");
                            int iWidth2 = rect.width();
                            iHeight = rect.height();
                            view2.getLocationInWindow(iArr);
                            measuredWidth = view2.getMeasuredWidth();
                            int measuredHeight2 = view2.getMeasuredHeight();
                            iWidth = iWidth2;
                            measuredHeight = measuredHeight2;
                        } else {
                            str = "replaceHWParams backUpView not visible";
                        }
                        LogUtil.dev("g0", str);
                        measuredHeight = 0;
                        iWidth = 0;
                        iHeight = 0;
                        measuredWidth = 0;
                    }
                    int i = ((iWidth * iHeight) * 100) / (measuredWidth * measuredHeight);
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        strArr[i2] = TextUtils.replace(strArr[i2], new String[]{"__M_SHOW_RATI__", "__M_SCREEN_X__", "__M_SCREEN_Y__"}, new String[]{String.valueOf(i), String.valueOf(iArr[0]), String.valueOf(iArr[1])}).toString();
                    }
                    LogUtil.dev("g0", "replaceHWParams ratio：" + i + " x:" + iArr[0] + " y:" + iArr[1]);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return strArr;
    }

    public static String[] a(String[] strArr, String str) {
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    String[] strArr2 = new String[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        if (!TextUtils.isEmpty(strArr[i])) {
                            strArr2[i] = TextUtils.replace(strArr[i], new String[]{"__ACCEPT_ID__"}, new String[]{str}).toString();
                        }
                    }
                    return strArr2;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return strArr;
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static void b(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            try {
                strArr[i] = strArr[i].replace("__MS_CR__", String.valueOf(1));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public static String[] b(String[] strArr, int i) {
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        strArr[i2] = TextUtils.replace(strArr[i2], new String[]{"__MS_DP_SIGN__"}, new String[]{String.valueOf(i)}).toString();
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return strArr;
    }

    public static String[] b(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            try {
                strArr[i] = TextUtils.replace(strArr[i], new String[]{"__MS_STAT__"}, new String[]{str}).toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strArr;
    }

    public static String[] c(String[] strArr, int i) {
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        strArr[i2] = a(strArr[i2], i);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return strArr;
    }
}
