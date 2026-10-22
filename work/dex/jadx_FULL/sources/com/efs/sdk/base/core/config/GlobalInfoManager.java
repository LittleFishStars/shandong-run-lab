package com.efs.sdk.base.core.config;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.ali.auth.third.login.LoginConstants;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.PackageUtil;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.core.util.c;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.huachenjie.common.constants.UserConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.push.core.b;
import com.zj.adlib.c49;
import com.zj.adlib.dv9;
import com.zj.adlib.ze1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class GlobalInfoManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GlobalInfo f29587a;
    private Context b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final GlobalInfoManager f29588a = new GlobalInfoManager(0);
    }

    public /* synthetic */ GlobalInfoManager(byte b) {
        this();
    }

    private static String a(Context context) {
        Class<?> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getSid", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, context);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public static GlobalInfoManager getInstance() {
        return a.f29588a;
    }

    public GlobalInfo getGlobalInfo() {
        try {
            String strA = a(this.b);
            if (!TextUtils.isEmpty(strA)) {
                this.f29587a.a("um_session_id", strA);
            }
        } catch (Throwable th) {
            Log.d("efs.info.manager", "refreshSessionId caused error: " + th.getMessage());
        }
        return this.f29587a;
    }

    public String getNetStatus() {
        return this.f29587a.b("net", NetworkUtil.NETWORK_CLASS_DISCONNECTED).toString();
    }

    public void initGlobalInfo() {
        Log.e("ballack", "initGlobalInfo called once.");
        GlobalInfo globalInfo = new GlobalInfo();
        this.f29587a = globalInfo;
        globalInfo.a("appid", ControllerCenter.getGlobalEnvStruct().getAppid());
        int iMyPid = ProcessUtil.myPid();
        this.f29587a.a("pid", Integer.valueOf(iMyPid));
        this.f29587a.a("ps", ProcessUtil.getProcessName(iMyPid));
        String strA = c.a(this.b);
        this.f29587a.a("wid", strA);
        if (TextUtils.isEmpty(ControllerCenter.getGlobalEnvStruct().getUid())) {
            this.f29587a.a(UserConstants.URL_PARAMS.b, strA);
        } else {
            this.f29587a.a(UserConstants.URL_PARAMS.b, ControllerCenter.getGlobalEnvStruct().getUid());
        }
        GlobalInfo globalInfo2 = this.f29587a;
        com.efs.sdk.base.core.a.a.a();
        globalInfo2.a("stime", Long.valueOf(com.efs.sdk.base.core.a.a.b() - Process.getElapsedCpuTime()));
        this.f29587a.a(b.aC, PackageUtil.getPackageName(this.b));
        this.f29587a.a("ver", PackageUtil.getAppVersionName(this.b));
        this.f29587a.a("vcode", PackageUtil.getAppVersionCode(this.b));
        this.f29587a.a(HiAnalyticsConstant.BI_KEY_SDK_VER, BuildConfig.VERSION_NAME);
        this.f29587a.a("brand", Build.BRAND.toLowerCase());
        GlobalInfo globalInfo3 = this.f29587a;
        String str = Build.MODEL;
        globalInfo3.a(ze1.k, str == null ? "unknown" : str.replace(" ", c49.f40900a).replace(LoginConstants.UNDER_LINE, c49.f40900a).toLowerCase());
        this.f29587a.a("build_model", str);
        DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
        this.f29587a.a("dsp_w", Integer.valueOf(displayMetrics.widthPixels));
        this.f29587a.a("dsp_h", Integer.valueOf(displayMetrics.heightPixels));
        this.f29587a.a("fr", "android");
        this.f29587a.a("rom", Build.VERSION.RELEASE);
        this.f29587a.a("sdk", Integer.valueOf(Build.VERSION.SDK_INT));
        this.f29587a.a(dv9.h, Locale.getDefault().getLanguage());
        this.f29587a.a("tzone", TimeZone.getDefault().getID());
        this.f29587a.a("net", NetworkUtil.getNetworkType(this.b));
        try {
            String[] networkAccessMode = NetworkUtil.getNetworkAccessMode(this.b);
            if (NetworkUtil.WIFI.equals(networkAccessMode[0])) {
                this.f29587a.a("um_access", "wifi");
            } else if (NetworkUtil.MOBILE_NETWORK.equals(networkAccessMode[0])) {
                this.f29587a.a("um_access", NetworkUtil.MOBILE_NETWORK);
            } else {
                this.f29587a.a("um_access", "unknow");
            }
            if (!"".equals(networkAccessMode[1])) {
                this.f29587a.a("um_access_subtype", networkAccessMode[1]);
            }
            this.f29587a.a("um_network_type", Integer.valueOf(NetworkUtil.getNetworkTypeUmeng(this.b)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this.f29587a.a("log_uid", EncodeUtil.base64DecodeToStr(ControllerCenter.getGlobalEnvStruct().getLogUid().getBytes()));
            this.f29587a.a("log_did", ControllerCenter.getGlobalEnvStruct().getLogDid());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void refreshNetStatus() {
        String networkType = NetworkUtil.getNetworkType(ControllerCenter.getGlobalEnvStruct().mAppContext);
        Log.w("efs.info.manager", "network change: ".concat(String.valueOf(networkType)));
        this.f29587a.a("net", networkType);
    }

    private GlobalInfoManager() {
        this.b = ControllerCenter.getGlobalEnvStruct().mAppContext;
    }
}
