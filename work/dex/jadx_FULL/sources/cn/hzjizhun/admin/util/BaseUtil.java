package cn.hzjizhun.admin.util;

import android.content.Context;
import android.webkit.WebView;
import cn.hzjizhun.admin.base.utils.CrashRecorder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BaseUtil {
    public static void crashReportInit(Context context) {
        try {
            if (isImportBase()) {
                CrashRecorder.getInstance().init(context);
            }
        } catch (Throwable unused) {
        }
    }

    public static void injectMIDIBlockerJS(WebView webView) {
        try {
            isImportBase();
        } catch (Throwable unused) {
        }
    }

    private static boolean isImportBase() {
        return true;
    }
}
