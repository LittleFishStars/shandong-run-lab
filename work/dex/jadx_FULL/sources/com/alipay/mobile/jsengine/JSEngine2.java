package com.alipay.mobile.jsengine;

import android.content.Context;
import android.os.SystemClock;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JSEngine2 {
    public static String LIBV8UC_SO = "libv8uc.so";
    public static String LIBWEBVIEWUC_SO = "libwebviewuc.so";
    public static String TAG = "jsengine";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f25356a = false;
    private static volatile boolean b = false;
    private static String c = "libv8uc.so:libjsengine-platform.so:libjsengine-api.so";
    private static ClassLoader d = null;
    private static String e = null;
    private static boolean f = false;
    private static final String g = "plugins_lib";
    private static final String h = "libv8.ant.so";
    private static final String i = "libv8_7z.so";
    private static final String j = "libv8_upgrade_7z.so";
    public static long sCopySoCost;
    public static long sInitUCCost;
    public static long sLoadSoCost;

    public static synchronized boolean Initialize(Delegate delegate) {
        return Initialize(delegate, JSEngine.class.getClassLoader(), true);
    }

    private static String a(Context context) {
        String str = b(context) + WVNativeCallbackUtil.SEPERATER;
        String str2 = str + j;
        if (JSEngine.b(str2)) {
            return str2;
        }
        String str3 = str + i;
        if (JSEngine.b(str3)) {
            return str3;
        }
        String str4 = context.getApplicationInfo().nativeLibraryDir + WVNativeCallbackUtil.SEPERATER;
        String str5 = str4 + i;
        if (JSEngine.b(str5)) {
            return str5;
        }
        String str6 = str4 + j;
        if (JSEngine.b(str6)) {
            return str6;
        }
        return null;
    }

    private static String b(Context context) {
        return context.getDir(g, 0).getAbsolutePath();
    }

    public static void cloneUCSoFilesIfNeeded(Delegate delegate) {
        int iNativeHackElf;
        String webViewCoreSoPath = getWebViewCoreSoPath(delegate);
        e = webViewCoreSoPath;
        String v8SoAbsolutePath = getV8SoAbsolutePath(delegate.getContext());
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Object objTakeProcessLock = delegate.takeProcessLock(v8SoAbsolutePath + ".lock");
        if (JSEngine.b(v8SoAbsolutePath)) {
            iNativeHackElf = JSEngine.nativeVerifyElf(v8SoAbsolutePath, LIBV8UC_SO);
            if (iNativeHackElf == 0) {
                delegate.releaseProcessLock(objTakeProcessLock);
                return;
            }
            delegate.e(TAG, LIBV8UC_SO + " is invalid, err: " + iNativeHackElf);
            JSEngine.a(v8SoAbsolutePath);
        } else {
            iNativeHackElf = -1;
        }
        for (int i2 = 0; i2 < 10; i2++) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                iNativeHackElf = JSEngine.nativeHackElf(webViewCoreSoPath, v8SoAbsolutePath, LIBV8UC_SO);
                delegate.d(TAG, "modifySoname " + webViewCoreSoPath + " -> " + v8SoAbsolutePath + " : " + iNativeHackElf + ", cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (iNativeHackElf == 0) {
                    iNativeHackElf = JSEngine.nativeVerifyElf(v8SoAbsolutePath, LIBV8UC_SO);
                    if (iNativeHackElf == 0) {
                        break;
                    }
                    delegate.e(TAG, LIBV8UC_SO + " is invalid, err: " + iNativeHackElf);
                }
                JSEngine.a(v8SoAbsolutePath);
                JSEngine.a(200L);
            } catch (Throwable th) {
                delegate.d(TAG, "modifySoname exception " + th);
            }
        }
        delegate.releaseProcessLock(objTakeProcessLock);
        sCopySoCost = SystemClock.elapsedRealtime() - jElapsedRealtime;
        if (iNativeHackElf == 0) {
            return;
        }
        throw new IllegalStateException("modifySoname failed rc=" + iNativeHackElf);
    }

    public static String getLibWebViewUCSoPath() {
        return e;
    }

    public static String getV8SoAbsolutePath(Context context) {
        return b(context) + WVNativeCallbackUtil.SEPERATER + LIBV8UC_SO;
    }

    public static String getWebViewCoreSoPath(Delegate delegate) {
        String webViewCoreSoPath = delegate.getWebViewCoreSoPath();
        if (!TextUtils.isEmpty(webViewCoreSoPath) && !webViewCoreSoPath.contains(LIBWEBVIEWUC_SO)) {
            webViewCoreSoPath = webViewCoreSoPath + WVNativeCallbackUtil.SEPERATER + LIBWEBVIEWUC_SO;
        }
        if (TextUtils.isEmpty(webViewCoreSoPath) || !JSEngine.b(webViewCoreSoPath)) {
            delegate.d(TAG, "getWebViewCoreSoPath => " + webViewCoreSoPath);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            delegate.unzipWebViewCoreSo();
            sInitUCCost = SystemClock.elapsedRealtime() - jElapsedRealtime;
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
            if (!JSEngine.b(webViewCoreSoPath)) {
                throw new IllegalStateException("UC library can not found");
            }
        }
        return webViewCoreSoPath;
    }

    public static boolean initializeForV8Test(Delegate delegate) {
        if (f) {
            return true;
        }
        if (f25356a) {
            return false;
        }
        synchronized (JSEngine.class) {
            if (f25356a) {
                return false;
            }
            System.loadLibrary("jsengine-loadso");
            JSEngine.class.getClassLoader();
            Context context = delegate.getContext();
            String str = b(context) + WVNativeCallbackUtil.SEPERATER;
            String str2 = str + h;
            String str3 = str + j;
            Object objTakeProcessLock = delegate.takeProcessLock(str2 + ".lock");
            if (!JSEngine.b(str2)) {
                String strA = a(context);
                if (TextUtils.isEmpty(strA)) {
                    delegate.releaseProcessLock(objTakeProcessLock);
                    delegate.e(TAG, "not found libv8_7z.so");
                    throw new IllegalStateException("not found libv8_7z.so");
                }
                if (!a(str2, strA)) {
                    delegate.releaseProcessLock(objTakeProcessLock);
                    delegate.e(TAG, "failed to decompress " + strA);
                    throw new IllegalStateException("failed to decompress " + strA);
                }
                if (strA.endsWith(j)) {
                    JSEngine.a(strA);
                }
            } else if (JSEngine.b(str3)) {
                if (a(str2, str3)) {
                    delegate.e(TAG, "successfully to upgrade v8 with " + str3);
                } else {
                    delegate.e(TAG, "failed to upgrade v8 with " + str3);
                }
                JSEngine.a(str3);
            }
            delegate.releaseProcessLock(objTakeProcessLock);
            if (!a(delegate, "v8.ant")) {
                delegate.e(TAG, "failed to load libv8.ant.so");
                throw new IllegalStateException("failed to load libv8.ant.so");
            }
            setOptions(delegate);
            b = true;
            f = true;
            delegate.d(TAG, "successfully loaded the new V8 library");
            return true;
        }
    }

    public static synchronized boolean isInitialized() {
        return f25356a;
    }

    public static boolean linkAndroidNamespace(ClassLoader classLoader, String str) {
        return false;
    }

    public static void loadV8SoFiles(Delegate delegate, ClassLoader classLoader, boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String v8SoAbsolutePath = getV8SoAbsolutePath(delegate.getContext());
        NativeLibs.addExtraNativeLibraryDirectories(delegate, delegate.getContext(), classLoader);
        try {
            delegate.d(TAG, "loading " + v8SoAbsolutePath);
            System.load(v8SoAbsolutePath);
            delegate.d(TAG, "successfull loaded " + v8SoAbsolutePath);
        } catch (Throwable th) {
            delegate.e(TAG, "System.load failed", th);
            if (JSEngine.nativeLoadSo(v8SoAbsolutePath) == 0) {
                String str = "failed to load " + LIBV8UC_SO;
                delegate.e(TAG, str);
                throw new IllegalStateException(str);
            }
        }
        if (!a(delegate, "jsengine-platform")) {
            delegate.e(TAG, "failed to load jsengine-platform");
            throw new IllegalStateException("failed to load jsengine-platform");
        }
        if (z) {
            if (!a(delegate, "jsengine-api")) {
                delegate.e(TAG, "failed to load jsengine-api");
                throw new IllegalStateException("failed to load jsengine-api");
            }
            b = true;
        }
        sLoadSoCost = SystemClock.elapsedRealtime() - jElapsedRealtime;
        delegate.d(TAG, "successfully loaded V8 library");
    }

    public static void setOptions(Delegate delegate) {
        File filesDir = delegate.getContext().getFilesDir();
        if (filesDir != null) {
            File file = new File(filesDir, "code_cache");
            if (!file.exists()) {
                delegate.d(TAG, "Creating code-cache dir " + file.toString());
                file.mkdirs();
            }
            JSEngine._setCodeCacheOptionsEx(file.toString(), 604800L, delegate.getConfig("ta_v8_cache_mode", 1));
        }
        JSEngine._setSnapshotMemThreshold(delegate.getConfig("ta_v8_snapshot_mem_threshold", 12));
    }

    public static synchronized boolean Initialize(Delegate delegate, ClassLoader classLoader, boolean z) {
        if (f25356a) {
            return true;
        }
        synchronized (JSEngine.class) {
            if (f25356a) {
                return true;
            }
            System.loadLibrary("jsengine-loadso");
            try {
                cloneUCSoFilesIfNeeded(delegate);
                loadV8SoFiles(delegate, classLoader, z);
                setOptions(delegate);
                f25356a = true;
                return true;
            } catch (Throwable th) {
                LogData logDataSeedId = LogData.seedId("TINY_APP_JS_ENGINE");
                logDataSeedId.param1().add("type", c.f25231a).param2().add("message", th.getMessage().replace("\n", " ")).param3().add("diskInfo", delegate == null ? "" : delegate.getDiskInfo());
                if (delegate != null) {
                    delegate.log(logDataSeedId);
                    delegate.e(TAG, "JSEngine failed to initialize", th);
                }
                return false;
            }
        }
    }

    private static boolean a(String str, String str2) {
        return JSEngine.nativeDecompress(str, str2) == 0;
    }

    private static boolean a(Delegate delegate, String str) {
        try {
            delegate.d(TAG, "loading " + str);
            System.loadLibrary(str);
            delegate.d(TAG, "successfull loaded " + str);
            return true;
        } catch (Throwable th) {
            delegate.e(TAG, "Runtime loadLibrary exception", th);
            LogData logDataSeedId = LogData.seedId("TINY_APP_JS_ENGINE");
            logDataSeedId.param1().add("type", c.f25231a).param2().add("message", th.toString());
            delegate.log(logDataSeedId);
            return false;
        }
    }
}
