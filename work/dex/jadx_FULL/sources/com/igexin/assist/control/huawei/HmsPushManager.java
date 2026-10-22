package com.igexin.assist.control.huawei;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.HmsMessaging;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.util.AssistUtils;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class HmsPushManager implements AbstractPushManager {
    private static final String PACKAGE_HUAWEI = "com.huawei.hwid";
    public static final String PLUGIN_VERSION = "3.1.1";
    public static final String TAG = "Assist_HW";
    private String appId;
    private String token = "";
    private final Object object = new Object();

    public HmsPushManager(Context context) {
        try {
            Log.d("Assist_HW", "huawei plugin version = 3.1.1, huawei sdk version = " + ((String) context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("com.huawei.hms.client.service.name:push")).split(u15.f19942b)[1]);
        } catch (Throwable th) {
            Log.d("Assist_HW", th.getMessage());
            Log.d("Assist_HW", "huawei plugin version = 3.1.1, not meta-data");
        }
    }

    public static boolean checkHWDevice(Context context) {
        try {
            String str = Build.BRAND;
            Log.d("Assist_HW", "brand =  " + str);
            if (str.equalsIgnoreCase(AssistUtils.BRAND_HW)) {
                return true;
            }
            if (!str.equalsIgnoreCase(AssistUtils.BRAND_HON)) {
                return false;
            }
            boolean zIsHonorNewDevice = Utils.isHonorNewDevice();
            Log.d("Assist_HW", "is honor newDevice :  " + zIsHonorNewDevice);
            return !zIsHonorNewDevice;
        } catch (Throwable th) {
            Log.d("Assist_HW", "check hw device error = " + th);
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return null;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getToken(Context context) {
        return this.token;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        return false;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(final Context context) {
        Log.d("Assist_HW", "Register hmspush, pkg = " + context.getPackageName());
        new Thread() { // from class: com.igexin.assist.control.huawei.HmsPushManager.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    synchronized (HmsPushManager.this.object) {
                        if (TextUtils.isEmpty(HmsPushManager.this.appId)) {
                            HmsPushManager.this.appId = AGConnectServicesConfig.fromContext(context).getString("client/app_id");
                        }
                    }
                    HmsPushManager.this.token = HmsInstanceId.getInstance(context).getToken(HmsPushManager.this.appId, HmsMessaging.DEFAULT_TOKEN_SCOPE);
                    Log.i("Assist_HW", "get hms token:" + HmsPushManager.this.token);
                    if (TextUtils.isEmpty(HmsPushManager.this.token)) {
                        return;
                    }
                    MessageManger.getInstance().addMessage(new MessageBean(context, "token", AssistPushConsts.HW_PREFIX + HmsPushManager.this.token));
                } catch (Throwable th) {
                    Log.e("Assist_HW", "get hms token failed:" + th.getMessage());
                }
            }
        }.start();
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(Context context, int i, int i2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(Context context) {
        Log.d("Assist_HW", "turnOffPush");
        HmsMessaging.getInstance(context).turnOffPush().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.igexin.assist.control.huawei.HmsPushManager.4
            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.i("Assist_HW", "turnOffPush Complete");
                    return;
                }
                Log.e("Assist_HW", "turnOffPush failed: ret=" + task.getException().getMessage());
            }
        });
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(Context context) {
        Log.d("Assist_HW", "turnOnPush");
        HmsMessaging.getInstance(context).turnOnPush().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.igexin.assist.control.huawei.HmsPushManager.3
            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.i("Assist_HW", "turnOnPush Complete");
                    return;
                }
                Log.e("Assist_HW", "turnOnPush failed: ret=" + task.getException().getMessage());
            }
        });
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(final Context context) {
        new Thread() { // from class: com.igexin.assist.control.huawei.HmsPushManager.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    HmsInstanceId.getInstance(context).deleteToken(AGConnectServicesConfig.fromContext(context).getString("client/app_id"), HmsMessaging.DEFAULT_TOKEN_SCOPE);
                    Log.i("Assist_HW", "deleteToken success.");
                } catch (ApiException e) {
                    Log.e("Assist_HW", "deleteToken failed." + e);
                }
            }
        }.start();
    }
}
