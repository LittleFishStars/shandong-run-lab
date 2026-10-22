package com.igexin.assist.control.meizu;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.acse.ottn.p3;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.util.AssistUtils;
import com.meizu.cloud.pushsdk.PushManager;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class FlymePushManager implements AbstractPushManager {
    public static final String PLUGIN_VERSION = "3.2.3";
    public static final String TAG = "Assist_MZ";
    private String appId;
    private String appKey;

    public FlymePushManager(Context context) {
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

    public static boolean checkMZDevice(Context context) {
        try {
            if (isBrandMeizu()) {
                String str = Build.DISPLAY;
                if (!TextUtils.isEmpty(str) && (str.startsWith("Flyme OS") || str.startsWith("Flyme"))) {
                    try {
                        return Integer.valueOf(str.replaceAll("Flyme OS", "").replaceAll("Flyme", "").trim().split("\\.")[0]).intValue() >= 5;
                    } catch (Throwable th) {
                        Log.d("Assist_MZ", th.getMessage());
                        return true;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean isBrandMeizu() {
        try {
            String str = Build.BRAND;
            boolean z = true;
            if (!AssistUtils.BRAND_MZ.equalsIgnoreCase(str) && !"22c4185e".equalsIgnoreCase(str)) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                if (TextUtils.isEmpty((String) cls.getMethod(p3.f, String.class).invoke(cls, "ro.meizu.product.model"))) {
                    z = false;
                }
                Log.d("Assist_MZ", "is mz:".concat(String.valueOf(z)));
            }
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return null;
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
        return false;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(Context context) {
        try {
            if (!TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.appKey)) {
                Log.d("Assist_MZ", "Register meizupush, pkg = " + context.getPackageName());
                PushManager.register(context, this.appId, this.appKey);
                return;
            }
            Log.d("Assist_MZ", "Register meizupush appId not find");
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
