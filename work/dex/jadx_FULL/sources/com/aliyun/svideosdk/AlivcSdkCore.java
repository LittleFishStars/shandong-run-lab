package com.aliyun.svideosdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.Visible;
import com.aliyun.common.utils.l;
import com.aliyun.common.utils.n;
import com.aliyun.common.utils.r;
import com.aliyun.common.utils.t;
import com.aliyun.svideosdk.common.AlivcSdkConfig;
import com.aliyun.svideosdk.license.ILicenseNativeInitCallback;
import com.aliyun.svideosdk.license.LicenseManager;
import com.huachenjie.common.constants.UserConstants;
import com.igexin.push.core.b;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AlivcSdkCore {
    private static final String TAG = "AlivcSdkCore";
    protected static long mNativeHandle;
    private static com.aliyun.svideosdk.b.a mReporter;
    private static AlivcDebugLoggerLevel sDebugLoggerLevel = AlivcDebugLoggerLevel.AlivcDLNormal;
    private static AlivcLogLevel mLogLevel = AlivcLogLevel.AlivcLogWarn;
    public static String APP_PRIVATE_DIR = null;
    public static String APP_PUBLIC_DIR = null;

    @Visible
    public enum AlivcDebugLoggerLevel {
        AlivcDLClose(1),
        AlivcDLNormal(2),
        AlivcDLAll(3);

        int value;

        AlivcDebugLoggerLevel(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    @Visible
    public enum AlivcLogLevel {
        AlivcLogClose(1),
        AlivcLogVerbose(2),
        AlivcLogDebug(3),
        AlivcLogInfo(4),
        AlivcLogWarn(5),
        AlivcLogError(6),
        AlivcLogFatal(7);

        int value;

        AlivcLogLevel(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f25606a;
        final /* synthetic */ ILicenseNativeInitCallback b;

        public a(Context context, ILicenseNativeInitCallback iLicenseNativeInitCallback) {
            this.f25606a = context;
            this.b = iLicenseNativeInitCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlivcSdkCore.initLicense(this.f25606a, this.b);
        }
    }

    @Deprecated
    public static AlivcDebugLoggerLevel getDebugLoggerLevel() {
        return sDebugLoggerLevel;
    }

    public static AlivcLogLevel getLogLevel() {
        return mLogLevel;
    }

    private static void initInner(Context context, AlivcSdkConfig alivcSdkConfig) {
        com.aliyun.common.utils.a.a(context);
        APP_PRIVATE_DIR = context.getDir("svideo_libs", 0).getAbsolutePath();
        Log.d("AliYunLog", "register, APP_PRIVATE_DIR = " + APP_PRIVATE_DIR);
        APP_PUBLIC_DIR = context.getExternalFilesDir(null).getAbsolutePath();
        Log.d("AliYunLog", "register, APP_PUBLIC_DIR = " + APP_PUBLIC_DIR);
        n.a().a(context);
        com.aliyun.svideosdk.nativeload.a.loadLibrary();
        if (mNativeHandle == 0) {
            setSdkInfo(context);
            if (mReporter == null) {
                mReporter = new com.aliyun.svideosdk.b.a(context);
            }
            long jNativeInit = nativeInit(context.getApplicationContext(), APP_PUBLIC_DIR, alivcSdkConfig.isCrashOn(), mReporter.a());
            mNativeHandle = jNativeInit;
            mReporter.a(jNativeInit != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean initLicense(Context context, ILicenseNativeInitCallback iLicenseNativeInitCallback) {
        if (context == null) {
            return false;
        }
        return nativeSetUpLicense(context, LicenseManager.getInstance().setCallback(iLicenseNativeInitCallback));
    }

    private static native long nativeInit(Context context, String str, boolean z, long j);

    private static native void nativeSetDLLevel(int i);

    private static native void nativeSetLogLevel(int i);

    private static native void nativeSetLogPath(String str);

    private static native void nativeSetSdkInfo(String str, String str2);

    private static native boolean nativeSetUpLicense(Object obj, Object obj2);

    private static native void nativeUnInit(long j);

    private static String reflectGetAioInfo(Class<?> cls, String str) throws Exception {
        return (String) cls.getMethod(str, new Class[0]).invoke(null, new Object[0]);
    }

    public static boolean register(Context context) {
        return register(context, new AlivcSdkConfig());
    }

    public static boolean register(Context context, AlivcSdkConfig alivcSdkConfig) {
        initInner(context, alivcSdkConfig);
        return initLicense(context, null);
    }

    public static void registerAsync(Context context, AlivcSdkConfig alivcSdkConfig, ILicenseNativeInitCallback iLicenseNativeInitCallback) {
        initInner(context, alivcSdkConfig);
        r.a(new a(context, iLicenseNativeInitCallback));
    }

    @Deprecated
    public static void setDebugLoggerLevel(AlivcDebugLoggerLevel alivcDebugLoggerLevel) {
        sDebugLoggerLevel = alivcDebugLoggerLevel;
        nativeSetDLLevel(alivcDebugLoggerLevel.getValue());
    }

    public static void setLogLevel(AlivcLogLevel alivcLogLevel) {
        mLogLevel = alivcLogLevel;
        nativeSetLogLevel(alivcLogLevel.getValue());
    }

    public static void setLogPath(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "setLogPath failed!! path = " + str);
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                if (!file.mkdirs()) {
                    Log.e(TAG, "setLogPath mkdirs failed!!path = " + str);
                    return;
                }
            } catch (Exception e) {
                Log.e(TAG, "setLogPath failed!! path = " + str, e);
                return;
            }
        } else if (!file.isDirectory()) {
            Log.e(TAG, "setLogPath failed, your path is an exist file !! path = " + str);
            return;
        }
        nativeSetLogPath(str);
    }

    private static native void setNativeDebugParams(int i);

    private static void setSdkInfo(Context context) {
        nativeSetSdkInfo("sty", "svideo_pro");
        nativeSetSdkInfo("svr", "6.7.0");
        nativeSetSdkInfo("sbi", "");
        nativeSetSdkInfo("sbt", "");
        nativeSetSdkInfo(b.aC, context.getPackageName());
        nativeSetSdkInfo("pvr", l.a(context));
        nativeSetSdkInfo(UserConstants.URL_PARAMS.b, t.c());
        nativeSetSdkInfo("ncn", "all_in_one");
    }

    public static void unregister() {
        long j = mNativeHandle;
        if (j != 0) {
            nativeUnInit(j);
            mNativeHandle = 0L;
        }
        com.aliyun.svideosdk.b.a aVar = mReporter;
        if (aVar != null) {
            aVar.b();
            mReporter = null;
        }
    }
}
