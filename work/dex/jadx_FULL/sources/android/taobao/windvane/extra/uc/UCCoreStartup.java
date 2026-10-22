package android.taobao.windvane.extra.uc;

import android.app.Application;
import android.content.Context;
import android.taobao.windvane.base.m;
import android.taobao.windvane.c.b;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.extra.c.c;
import android.taobao.windvane.util.TaoLog;
import com.uc.webview.export.extension.UCCore;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class UCCoreStartup {
    private static final boolean ENABLE_ANDROID_LOG = false;
    private static final boolean ENABLE_PREPROCESS = true;
    private static final String TAG = "UCCoreStartup";
    private static final AtomicBoolean sPreprocessAtomic = new AtomicBoolean(false);
    private static UCCoreStartup sUCCoreStartup;

    private void asyncPreprocess() {
        b.a().a(new Runnable() { // from class: android.taobao.windvane.extra.uc.UCCoreStartup.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UCCoreStartup.printAndroidLogE("asyncPreprocess");
                    UCCore.preInitCore(10, GlobalConfig.context, (Object[]) null);
                } catch (Throwable th) {
                    TaoLog.e(UCCoreStartup.TAG, "asyncPreprocess fail " + th.getMessage());
                }
            }
        });
    }

    public static UCCoreStartup getInstance() {
        if (sUCCoreStartup == null) {
            synchronized (b.class) {
                if (sUCCoreStartup == null) {
                    printAndroidLogE("UCCoreStartup instance enable preprocess true");
                    sUCCoreStartup = new UCCoreStartup();
                }
            }
        }
        return sUCCoreStartup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printAndroidLogE(String str) {
        TaoLog.e(TAG, str);
    }

    public static String ucCoreRootDirPath(Context context, String str) {
        return UCCore.getExtractDirPath(context, c.b(str));
    }

    public void initPreprocess() {
        if (sPreprocessAtomic.compareAndSet(false, true)) {
            try {
                asyncPreprocess();
            } catch (Throwable th) {
                TaoLog.e(TAG, "initPreprocess fail " + th.getMessage());
            }
        }
    }

    public void preDecompress(Context context, String str) {
        printAndroidLogE("preDecompress " + context + ", " + str);
    }

    public void preInitUCCore(Context context, String str) {
        printAndroidLogE("preInitUCCore " + context + ", " + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            TaoLog.i(TAG, "trying to init uc core");
            if (GlobalConfig.context == null && (context instanceof Application)) {
                GlobalConfig.context = (Application) context;
            }
            android.taobao.windvane.base.b bVar = (android.taobao.windvane.base.b) m.a().b(android.taobao.windvane.base.b.class);
            if (bVar != null) {
                bVar.b();
            }
            Class.forName("android.taobao.windvane.extra.uc.WVUCWebView");
        } catch (Throwable th) {
            TaoLog.e(TAG, "failed to load WVUCWebView " + th.getMessage());
        }
        printAndroidLogE("initU4Core elapse: " + Long.toString(System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public void preloadClass(ClassLoader classLoader) {
        printAndroidLogE("preloadClass " + classLoader);
        try {
            UCCore.preInitCore(2, GlobalConfig.context, (Object[]) null);
        } catch (Throwable th) {
            TaoLog.e(TAG, "preloadClass fail " + th.getMessage());
        }
    }

    public void preloadIcu(Context context, String str) {
        printAndroidLogE("preloadIcu " + context + ", " + str);
        try {
            UCCore.preInitCore(9, context, new Object[]{ucCoreRootDirPath(context, str)});
        } catch (Throwable th) {
            TaoLog.e(TAG, "preloadIcu fail " + th.getMessage());
        }
    }

    public void preloadIo(Context context, String str) {
        printAndroidLogE("preloadIo " + context + ", " + str);
        try {
            UCCore.preInitCore(1, context, new Object[]{c.b(str)});
            UCCore.preInitCore(6, context, new Object[]{c.b(str)});
        } catch (Throwable th) {
            TaoLog.e(TAG, "preloadIo fail " + th.getMessage());
        }
    }

    public void preloadPak(Context context, String str) {
        printAndroidLogE("preloadPak " + context + ", " + str);
        try {
            UCCore.preInitCore(8, context, new Object[]{ucCoreRootDirPath(context, str)});
        } catch (Throwable th) {
            TaoLog.e(TAG, "preloadPak fail " + th.getMessage());
        }
    }

    public void preloadSo(Context context, String str) {
        printAndroidLogE("preloadSo " + context + ", " + str);
        StringBuilder sb = new StringBuilder();
        sb.append("preloadSo inject: ");
        sb.append(GlobalConfig.getInstance().getInjectCode());
        printAndroidLogE(sb.toString());
        try {
            UCCore.preInitCore(5, context, new Object[]{ucCoreRootDirPath(context, str)});
        } catch (Throwable th) {
            TaoLog.e(TAG, "preloadSo fail " + th.getMessage());
        }
    }
}
