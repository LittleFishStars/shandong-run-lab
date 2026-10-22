package com.igexin.assist.control.meizu;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.util.AssistUtils;
import com.meizu.cloud.pushsdk.PushManager;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ManufacturePushManager implements AbstractPushManager {
    public static final String PLUGIN_VERSION = "3.2.3";
    public static final String TAG = "Assist_MZ";
    private String appId;
    private String appKey;
    private Context context;

    public ManufacturePushManager(Context context) {
        this.appId = "";
        this.appKey = "";
        String str = "4.2.2";
        try {
            try {
                for (Field field : PushManager.class.getDeclaredFields()) {
                    if (Modifier.isFinal(field.getModifiers()) && "TAG".equals(field.getName())) {
                        str = (String) field.get(null);
                    }
                }
            } catch (Throwable th) {
                Log.d("Assist_MZ", th.getMessage());
                return;
            }
        } catch (Exception unused) {
        }
        Log.d("Assist_MZ", "meizu plugin version = 3.2.3, meizu sdk version = ".concat(String.valueOf(str)));
        this.context = context;
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        String appIdByBuildConfig = Utils.getAppIdByBuildConfig(applicationInfo);
        this.appId = appIdByBuildConfig;
        if (TextUtils.isEmpty(appIdByBuildConfig)) {
            String str2 = (String) applicationInfo.metaData.get(AssistPushConsts.MEIZUPUSH_APPID);
            this.appId = str2;
            this.appId = str2.replace(AssistPushConsts.MZ_PREFIX, "");
        }
        String appKeyByBuildConfig = Utils.getAppKeyByBuildConfig(applicationInfo);
        this.appKey = appKeyByBuildConfig;
        if (TextUtils.isEmpty(appKeyByBuildConfig)) {
            String str3 = (String) applicationInfo.metaData.get(AssistPushConsts.MEIZUPUSH_APPKEY);
            this.appKey = str3;
            this.appKey = str3.replace(AssistPushConsts.MZ_PREFIX, "");
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0032  */
    private static boolean isBrandMeizu() {
        boolean z;
        try {
            String strA = i.a("ro.meizu.product.model");
            Log.d("Assist_MZ", "brand = ".concat(String.valueOf(strA)));
            if (TextUtils.isEmpty(strA)) {
                String str = Build.BRAND;
                if (AssistUtils.BRAND_MZ.equalsIgnoreCase(str) || "22c4185e".equalsIgnoreCase(str)) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = true;
            }
            Log.d("Assist_MZ", "is mz:".concat(String.valueOf(z)));
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return "4";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getToken(Context context) {
        if (context == null) {
            return null;
        }
        return PushManager.getPushId(context);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        try {
            return isBrandMeizu();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(Context context) {
        try {
            if (!TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.appKey) && context != null) {
                Log.d("Assist_MZ", "Register meizupush, pkg = " + context.getPackageName());
                if (isSupport()) {
                    PushManager.register(context, this.appId, this.appKey);
                    return;
                } else {
                    Log.d("Assist_MZ", "meizupush not support.");
                    return;
                }
            }
            Log.d("Assist_MZ", "Register meizupush appId not find, or context null.");
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(Context context, int i, int i2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(Context context) {
        if (context == null) {
            return;
        }
        String pushId = PushManager.getPushId(context);
        if (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(pushId)) {
            return;
        }
        PushManager.switchPush(context, this.appId, this.appKey, pushId, false);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(Context context) {
        if (context == null) {
            return;
        }
        String pushId = PushManager.getPushId(context);
        if (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(pushId)) {
            return;
        }
        PushManager.switchPush(context, this.appId, this.appKey, pushId, true);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(Context context) {
        try {
            if (!TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.appKey)) {
                Log.d("Assist_MZ", "|Unregister meizupush");
                PushManager.unRegister(context, this.appId, this.appKey);
                return;
            }
            Log.d("Assist_MZ", "|Unregister meizupush appId not find");
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }
}
