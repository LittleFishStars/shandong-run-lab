package android.taobao.windvane.util;

import android.app.Application;
import android.content.res.Resources;
import android.taobao.windvane.config.GlobalConfig;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class EnvUtil {
    private static boolean DEBUG = false;
    private static boolean inited = false;
    private static boolean openSpdyforDebug = false;

    private static synchronized void init() {
        if (!inited) {
            try {
                Application application = GlobalConfig.context;
                if (application != null) {
                    DEBUG = (application.getApplicationInfo().flags & 2) != 0;
                    inited = true;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean isAppDebug() {
        if (!inited) {
            init();
        }
        return DEBUG;
    }

    public static boolean isCN() {
        try {
            return Resources.getSystem().getConfiguration().locale.getLanguage().contains("zh");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isDebug() {
        return TaoLog.getLogStatus() && isAppDebug();
    }

    public static boolean isOpenSpdyforDebug() {
        return openSpdyforDebug;
    }

    public static boolean isTaobao() {
        Application application = GlobalConfig.context;
        if (application != null) {
            return AlibcProtocolConstant.APPLINK_PACKAGE_NAME.equals(application.getPackageName());
        }
        return false;
    }

    public static void setOpenSpdyforDebug(boolean z) {
        openSpdyforDebug = z;
    }
}
