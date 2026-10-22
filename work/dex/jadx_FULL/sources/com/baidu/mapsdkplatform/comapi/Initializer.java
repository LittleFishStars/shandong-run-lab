package com.baidu.mapsdkplatform.comapi;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.CommonInfo;
import com.baidu.mapapi.ISDKInitializerListener;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.f;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comapi.util.a.a;
import com.baidu.platform.comapi.util.a.b;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Initializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f26671a = false;
    private static CommonInfo b = null;
    private static boolean c = false;

    private Initializer() {
    }

    private static boolean a(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            File file = new File(str + "/check.0");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            if (!file.exists()) {
                return true;
            }
            file.delete();
            return true;
        } catch (IOException e) {
            Log.e("SDKInitializer", "SDCard cache path invalid", e);
            throw new IllegalArgumentException("BDMapSDKException: Provided sdcard cache path invalid can not used.");
        }
    }

    public static CommonInfo getCommonInfo() {
        return b;
    }

    public static void initialize(Context context, boolean z, String str, String str2, String str3, ISDKInitializerListener iSDKInitializerListener) {
        if (f26671a) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("BDMapSDKException: context can not be null");
        }
        if (!(context instanceof Application)) {
            throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
        }
        NativeLoader.setContext(context);
        NativeLoader.a(z, str);
        JNIInitializer.setContext((Application) context);
        SysOSUtil.getInstance().init(new b(), new a());
        if (a(str2)) {
            EnvironmentUtilities.setSDCardPath(str2);
        }
        EnvironmentUtilities.initAppDirectory(context);
        BMapManagerInternal.getInstance().a(context);
        BMapManagerInternal.getInstance().permcheck();
        if (OpenLogUtil.isNativeLogAnalysisEnable()) {
            com.baidu.mapsdkplatform.comapi.a.a.b.c().a(context);
        }
        f26671a = true;
        if (iSDKInitializerListener != null) {
            iSDKInitializerListener.initializerFinish();
        }
    }

    public static boolean isAgreePrivacyMode() {
        return c;
    }

    public static boolean isInitialized() {
        return f26671a;
    }

    public static void onBackground() {
        f.a(false);
    }

    public static void onForeground() {
        f.a(true);
    }

    public static void setCommonInfo(CommonInfo commonInfo) {
        b = commonInfo;
    }

    public static void setPrivacyMode(Context context, boolean z) {
        if (context == null) {
            throw new IllegalArgumentException("BDMapSDKException: context can not be null");
        }
        if (!(context instanceof Application)) {
            throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
        }
        c = z;
        PermissionCheck.setPrivacyMode(z);
        f.b(z);
        LBSAuthManager.getInstance(context).setPrivacyMode(z);
    }
}
