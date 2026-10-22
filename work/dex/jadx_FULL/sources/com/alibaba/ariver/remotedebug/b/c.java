package com.alibaba.ariver.remotedebug.b;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.DisplayUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.baidu.location.BDLocation;
import com.zj.adlib.ze1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24381a = "AriverRemoteDebug:TinyAppLogHelper";
    public static final String b = "tinyAppStandardLog";
    public static final String c = "category";
    public static final String d = "logId";
    public static final String e = "message";
    public static final String f = "description";
    public static final String g = "output";
    public static final String h = "autoExtra";
    public static final String i = "timestamp";
    public static final String j = "userId";
    public static final String k = "appId";
    public static final String l = "appxVersion";
    public static final String m = "appVersion";
    public static final String n = "url";
    public static final String o = "platform";
    public static final String p = "clientVersion";
    public static final String q = "systemInfo";

    public static String a(Activity activity, Page page, JSONObject jSONObject) {
        try {
            return b(activity, page, a(JSONUtils.getString(jSONObject, "category"), JSONUtils.getString(jSONObject, d), JSONUtils.getString(jSONObject, g), JSONUtils.getString(jSONObject, "description"), JSONUtils.getString(jSONObject, "message"))).toJSONString();
        } catch (Throwable th) {
            RVLogger.w(f24381a, "getCreateScenario", th);
            return null;
        }
    }

    public static JSONObject b(Activity activity, Page page, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("timestamp", (Object) Long.valueOf(System.currentTimeMillis()));
        jSONObject2.put("userId", (Object) ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(page.getApp()));
        jSONObject2.put(p, (Object) ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getProductVersion());
        jSONObject2.put("platform", (Object) "Android");
        Bundle startParams = page.getStartParams();
        jSONObject2.put("appId", (Object) BundleUtils.getString(startParams, "appId"));
        jSONObject2.put("url", (Object) BundleUtils.getString(startParams, "url"));
        jSONObject2.put("appVersion", (Object) BundleUtils.getString(startParams, "appVersion"));
        jSONObject2.put("appxVersion", (Object) ((RVResourceManager) RVProxy.get(RVResourceManager.class)).getInstalledAppVersion(RVConstants.TINY_WEB_COMMON_APPID));
        JSONObject jSONObject3 = new JSONObject();
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            float f2 = displayMetrics.density;
            int iRound = Math.round(displayMetrics.widthPixels / f2);
            jSONObject3.put("pixelRatio", (Object) Float.valueOf(f2));
            jSONObject3.put("windowWidth", (Object) Integer.valueOf(iRound));
            jSONObject3.put("screenWidth", (Object) Integer.valueOf(displayMetrics.widthPixels));
            jSONObject3.put("screenHeight", (Object) Integer.valueOf(displayMetrics.heightPixels));
            jSONObject3.put("windowHeight", (Object) Integer.valueOf(a(page, activity, f2, displayMetrics)));
        }
        jSONObject3.put("brand", (Object) Build.BRAND);
        jSONObject3.put(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM, (Object) Build.VERSION.RELEASE);
        jSONObject3.put("apiLevel", (Object) Integer.valueOf(Build.VERSION.SDK_INT));
        jSONObject3.put(ze1.k, (Object) (Build.MANUFACTURER + " " + Build.MODEL));
        jSONObject3.put("storage", (Object) a(activity.getApplicationContext()));
        jSONObject2.put(q, (Object) jSONObject3);
        if (jSONObject != null) {
            jSONObject.put(h, (Object) jSONObject2);
        }
        return jSONObject;
    }

    public static JSONObject a(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("category", (Object) str);
        jSONObject.put(d, (Object) str2);
        jSONObject.put(g, (Object) str3);
        jSONObject.put("description", (Object) str4);
        jSONObject.put("message", (Object) str5);
        return jSONObject;
    }

    public static String a(JSONObject jSONObject) {
        String string = JSONUtils.getString(jSONObject, "category");
        if (TextUtils.isEmpty(string)) {
            return "log format is error, category is empty.";
        }
        if (TextUtils.isEmpty(JSONUtils.getString(jSONObject, d))) {
            return "log format is error, logId is empty.";
        }
        if (TextUtils.isEmpty(JSONUtils.getString(jSONObject, g))) {
            return "log format is error, output is empty.";
        }
        if (AliyunLogCommon.LogLevel.WARN.equals(string) && TextUtils.isEmpty(JSONUtils.getString(jSONObject, "description"))) {
            return "log format is error, warn log needs description key.";
        }
        if ("error".equals(string) && (TextUtils.isEmpty(JSONUtils.getString(jSONObject, "message")) || TextUtils.isEmpty(JSONUtils.getString(jSONObject, "description")))) {
            return "log format is error, error log needs description and message keys.";
        }
        return null;
    }

    private static int a(Page page, Activity activity, float f2, DisplayMetrics displayMetrics) {
        Render render;
        int iRound;
        int iRound2 = displayMetrics != null ? Math.round((displayMetrics.heightPixels - DisplayUtils.getTitleAndStatusBarHeight(activity)) / f2) : 0;
        return (page == null || (render = page.getRender()) == null || (iRound = Math.round(((float) render.getView().getHeight()) / f2)) <= 0) ? iRound2 : iRound;
    }

    public static String a(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return FileUtils.formatFileSize(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            RVLogger.e(f24381a, "getInternalMemorySize...", th);
            return "";
        }
    }
}
