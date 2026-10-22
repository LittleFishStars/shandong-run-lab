package com.igexin.assist.control.xiaomi;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ManufacturePushManager implements AbstractPushManager {
    private static final String PACKAGE_XIAOMI = "com.xiaomi.xmsf";
    public static final String PLUGIN_VERSION = "3.3.1";
    public static final String TAG = "Assist_XM";
    public static final String XIAOMI_VERSION = "5_6_2-C";
    private String appId;
    private String appKey;
    private Context context;

    public ManufacturePushManager(Context context) {
        this.appId = "";
        this.appKey = "";
        try {
            this.context = context;
            Log.d("Assist_XM", "xiaomi plugin version = 3.3.1, xiaomi sdk version = 5_6_2-C");
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            String appIdByBuildConfig = Utils.getAppIdByBuildConfig(applicationInfo);
            this.appId = appIdByBuildConfig;
            if (TextUtils.isEmpty(appIdByBuildConfig)) {
                String str = (String) applicationInfo.metaData.get(AssistPushConsts.MIPUSH_APPID);
                this.appId = str;
                this.appId = str.replace(AssistPushConsts.XM_PREFIX, "");
            }
            String appKeyByBuildConfig = Utils.getAppKeyByBuildConfig(applicationInfo);
            this.appKey = appKeyByBuildConfig;
            if (TextUtils.isEmpty(appKeyByBuildConfig)) {
                String str2 = (String) applicationInfo.metaData.get(AssistPushConsts.MIPUSH_APPKEY);
                this.appKey = str2;
                this.appKey = str2.replace(AssistPushConsts.XM_PREFIX, "");
            }
        } catch (Throwable th) {
            Log.d("Assist_XM", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return "3";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getToken(Context context) {
        if (context == null) {
            return null;
        }
        return MiPushClient.getRegId(context);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        PackageInfo packageInfo;
        try {
            return XmSystemUtils.isBrandXiaoMi() && (packageInfo = this.context.getPackageManager().getPackageInfo(PACKAGE_XIAOMI, 0)) != null && packageInfo.versionCode >= 105;
        } catch (Throwable th) {
            Log.d("Assist_XM", "support error is : " + th.toString());
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(Context context) {
        try {
            if (!TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.appKey) && context != null) {
                Log.d("Assist_XM", "Register mipush, pkg = " + context.getPackageName());
                if (isSupport()) {
                    MiPushClient.registerPush(context, this.appId, this.appKey);
                    return;
                } else {
                    Log.d("Assist_XM", "mipush not support.");
                    return;
                }
            }
            Log.d("Assist_XM", "Register mipush appId or appKey is empty, or context null.");
        } catch (Throwable th) {
            Log.d("Assist_XM", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(Context context, int i, int i2) {
        if (i2 == 0) {
            turnOnPush(context);
            return;
        }
        int i3 = (i + i2) % 24;
        Log.d("Assist_XM", "getui setSilentTime" + i + u15.f19942b + i2);
        Log.d("Assist_XM", "mipush setAcceptTime" + i3 + u15.f19942b + i);
        MiPushClient.setAcceptTime(context, i3, 0, i, 0, (String) null);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(Context context) {
        if (context == null) {
            return;
        }
        MiPushClient.pausePush(context, this.appId);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(Context context) {
        if (context == null) {
            return;
        }
        MiPushClient.resumePush(context, this.appId);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(Context context) {
        try {
            Log.d("Assist_XM", "Unregister mipush");
            if (context == null) {
                return;
            }
            MiPushClient.unregisterPush(context);
        } catch (Throwable th) {
            Log.d("Assist_XM", th.getMessage());
        }
    }
}
