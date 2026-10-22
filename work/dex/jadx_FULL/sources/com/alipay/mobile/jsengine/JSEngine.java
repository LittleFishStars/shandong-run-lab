package com.alipay.mobile.jsengine;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JSEngine {
    public static String LIBV8LC_SO = "libv8lc.so";
    public static String LIBWEBVIEWUC_SO = "libwebviewuc.so";
    public static String TAG = "jsengine";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f25355a = false;
    private static String b = null;
    private static final String c = "plugins_lib";

    public static boolean Initialize(Delegate delegate) {
        if (f25355a) {
            return true;
        }
        synchronized (JSEngine.class) {
            if (f25355a) {
                return true;
            }
            System.loadLibrary("jsengine-loadso");
            try {
                cloneUCSoFilesIfNeeded(delegate);
                loadV8SoFiles(delegate);
                f25355a = true;
                return true;
            } catch (Throwable th) {
                LogData logDataSeedId = LogData.seedId("TINY_APP_JS_ENGINE");
                logDataSeedId.param1().add("type", c.f25231a).param2().add("message", th.getMessage().replace("\n", " ")).param3().add("diskInfo", delegate.getDiskInfo());
                delegate.log(logDataSeedId);
                delegate.e(TAG, "JSEngine failed to initialize", th);
                return false;
            }
        }
    }

    public static native void _setCodeCacheOptions(String str, long j);

    public static native void _setCodeCacheOptionsEx(String str, long j, int i);

    public static native void _setSnapshotMemThreshold(int i);

    private static String a(Context context) {
        return context.getDir(c, 0).getAbsolutePath();
    }

    public static boolean b(String str) {
        return new File(str).exists();
    }

    public static void cloneUCSoFilesIfNeeded(Delegate delegate) {
        int iNativeHackElf;
        String webViewCoreSoPath = getWebViewCoreSoPath(delegate);
        b = webViewCoreSoPath;
        String v8SoAbsolutePath = getV8SoAbsolutePath(delegate.getContext());
        Object objTakeProcessLock = delegate.takeProcessLock(v8SoAbsolutePath + ".lock");
        if (b(v8SoAbsolutePath)) {
            iNativeHackElf = nativeVerifyElf(v8SoAbsolutePath, LIBV8LC_SO);
            if (iNativeHackElf == 0) {
                delegate.releaseProcessLock(objTakeProcessLock);
                return;
            }
            delegate.e(TAG, LIBV8LC_SO + " is invalid, err: " + iNativeHackElf);
            a(v8SoAbsolutePath);
        } else {
            iNativeHackElf = -1;
        }
        for (int i = 0; i < 10; i++) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                iNativeHackElf = nativeHackElf(webViewCoreSoPath, v8SoAbsolutePath, LIBV8LC_SO);
                delegate.d(TAG, "modifySoname " + webViewCoreSoPath + " -> " + v8SoAbsolutePath + " : " + iNativeHackElf + ", cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (iNativeHackElf == 0) {
                    iNativeHackElf = nativeVerifyElf(v8SoAbsolutePath, LIBV8LC_SO);
                    if (iNativeHackElf == 0) {
                        break;
                    }
                    delegate.e(TAG, LIBV8LC_SO + " is invalid, err: " + iNativeHackElf);
                }
                a(v8SoAbsolutePath);
                a(200L);
            } catch (Throwable th) {
                delegate.d(TAG, "modifySoname exception " + th);
            }
        }
        delegate.releaseProcessLock(objTakeProcessLock);
        if (iNativeHackElf == 0) {
            return;
        }
        throw new IllegalStateException("modifySoname failed rc=" + iNativeHackElf);
    }

    public static String getLibWebViewUCSoPath() {
        return b;
    }

    public static String getV8SoAbsolutePath(Context context) {
        return a(context) + WVNativeCallbackUtil.SEPERATER + LIBV8LC_SO;
    }

    public static String getWebViewCoreSoPath(Delegate delegate) {
        String webViewCoreSoPath = delegate.getWebViewCoreSoPath();
        if (!TextUtils.isEmpty(webViewCoreSoPath) && !webViewCoreSoPath.contains(LIBWEBVIEWUC_SO)) {
            webViewCoreSoPath = webViewCoreSoPath + WVNativeCallbackUtil.SEPERATER + LIBWEBVIEWUC_SO;
        }
        if (TextUtils.isEmpty(webViewCoreSoPath) || !b(webViewCoreSoPath)) {
            delegate.d(TAG, "getWebViewCoreSoPath => " + webViewCoreSoPath);
            delegate.unzipWebViewCoreSo();
            webViewCoreSoPath = delegate.getWebViewCoreSoPath();
            if (TextUtils.isEmpty(webViewCoreSoPath)) {
                LogData logDataSeedId = LogData.seedId("TINY_APP_JS_ENGINE");
                logDataSeedId.param1().add("type", c.f25231a).param2().add("message", "getWebViewCoreSoPath return null");
                delegate.log(logDataSeedId);
                throw new IllegalStateException("getWebViewCoreSoPath return null");
            }
            if (!webViewCoreSoPath.contains(LIBWEBVIEWUC_SO)) {
                webViewCoreSoPath = webViewCoreSoPath + WVNativeCallbackUtil.SEPERATER + LIBWEBVIEWUC_SO;
            }
            if (!b(webViewCoreSoPath)) {
                throw new IllegalStateException("UC library can not found");
            }
        }
        return webViewCoreSoPath;
    }

    public static void loadV8SoFiles(Delegate delegate) {
        if (a(delegate, "v8lc") || nativeLoadSo(getV8SoAbsolutePath(delegate.getContext())) != 0) {
            delegate.d(TAG, "successfully loaded V8 library");
            return;
        }
        String str = "failed to load " + LIBV8LC_SO;
        delegate.e(TAG, str);
        throw new IllegalStateException(str);
    }

    public static native long nativeDecompress(String str, String str2);

    public static native int nativeHackElf(String str, String str2, String str3);

    public static native boolean nativeLinkAndroidNamespace(ClassLoader classLoader, ClassLoader classLoader2, String str);

    public static native long nativeLoadSo(String str);

    public static native int nativeVerifyElf(String str, String str2);

    private static boolean a(Delegate delegate, String str) {
        Runtime.getRuntime();
        try {
            System.loadLibrary(str);
            return false;
        } catch (Throwable th) {
            delegate.e(TAG, "Runtime loadLibrary exception", th);
            LogData logDataSeedId = LogData.seedId("TINY_APP_JS_ENGINE");
            logDataSeedId.param1().add("type", c.f25231a).param2().add("message", th.getMessage().replace("\n", " "));
            delegate.log(logDataSeedId);
            return false;
        }
    }

    public static void a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    public static void a(String str) {
        try {
            new File(str).delete();
        } catch (Throwable unused) {
        }
    }
}
