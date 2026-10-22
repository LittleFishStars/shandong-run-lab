package com.igexin.assist.control.oppo;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.zj.adlib.u15;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class OppoPushManager implements ICallBackResultService, AbstractPushManager {
    public static final String PLUGIN_VERSION = "3.4.0";
    public static final String TAG = "Assist_OP";
    private String appKey;
    private String appSecret;
    private Context context;

    public OppoPushManager(Context context) {
        this.appKey = "";
        this.appSecret = "";
        try {
            Log.d("Assist_OP", "oppo plugin version = 3.4.0, oppo sdk version = " + HeytapPushManager.getSDKVersionName());
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            String appKeyByBuildConfig = Utils.getAppKeyByBuildConfig(applicationInfo);
            this.appKey = appKeyByBuildConfig;
            if (TextUtils.isEmpty(appKeyByBuildConfig)) {
                String str = (String) applicationInfo.metaData.get(AssistPushConsts.OPPOPUSH_APPKEY);
                this.appKey = str;
                this.appKey = str.replace(AssistPushConsts.OPPO_PREFIX, "");
            }
            String appSecretByBuildConfig = Utils.getAppSecretByBuildConfig(applicationInfo);
            this.appSecret = appSecretByBuildConfig;
            if (TextUtils.isEmpty(appSecretByBuildConfig)) {
                String str2 = (String) applicationInfo.metaData.get(AssistPushConsts.OPPOPUSH_APPSECRET);
                this.appSecret = str2;
                this.appSecret = str2.replace(AssistPushConsts.OPPO_PREFIX, "");
            }
            createNotificationChannel(context);
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
        }
    }

    public static boolean checkOppoDevice(Context context) {
        try {
            HeytapPushManager.init(context, false);
            return HeytapPushManager.isSupportPush(context);
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
            return false;
        }
    }

    private void createNotificationChannel(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Class<?> cls = Class.forName("android.app.NotificationChannel");
        Constructor<?> constructor = cls.getConstructor(String.class, CharSequence.class, Integer.TYPE);
        if (constructor == null || ((Parcelable) NotificationManager.class.getMethod("getNotificationChannel", String.class).invoke(notificationManager, "Default")) != null) {
            return;
        }
        NotificationManager.class.getMethod("createNotificationChannel", cls).invoke(notificationManager, (Parcelable) constructor.newInstance("Default", "Default", 3));
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return null;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getToken(Context context) {
        return HeytapPushManager.getRegisterID();
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            HeytapPushManager.init(context, false);
            boolean zIsSupportPush = HeytapPushManager.isSupportPush(this.context);
            Log.d("Assist_OP", "is oppo:".concat(String.valueOf(zIsSupportPush)));
            return zIsSupportPush;
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
            return false;
        }
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onError(int i, String str, String str2, String str3) {
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onGetNotificationStatus(int i, int i2) {
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onGetPushStatus(int i, int i2) {
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0054 A[Catch: all -> 0x0078, TryCatch #0 {all -> 0x0078, blocks: (B:3:0x0002, B:6:0x0021, B:8:0x0027, B:10:0x002f, B:13:0x003d, B:27:0x0066, B:14:0x0042, B:18:0x004b, B:21:0x0054, B:22:0x0059, B:24:0x005d), top: B:32:0x0002 }] */
    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onRegister(int i, String str, String str2, String str3) {
        try {
            Log.d("Assist_OP", "onToken :" + str + ", code = " + i);
            if (this.context == null || i != 0 || TextUtils.isEmpty(str) || str.equalsIgnoreCase("InvalidAppKey")) {
                return;
            }
            String strConcat = "";
            String[] strArrSplit = str.split(LoginConstants.UNDER_LINE);
            if (strArrSplit.length == 1) {
                strConcat = AssistPushConsts.OPPO_PREFIX.concat(str);
            } else if (strArrSplit.length == 2) {
                if (strArrSplit[0].equalsIgnoreCase("CN")) {
                    strConcat = AssistPushConsts.OPPO_PREFIX.concat(str);
                } else {
                    strConcat = "OPG_".concat(str);
                }
            } else if (strArrSplit.length == 3) {
                if (strArrSplit[1].equalsIgnoreCase("CN")) {
                    strConcat = AssistPushConsts.OPPO_PREFIX.concat(str);
                } else {
                    strConcat = "OPG_".concat(str);
                }
            }
            MessageManger.getInstance().addMessage(new MessageBean(this.context, "token", strConcat));
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
        }
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onSetPushTime(int i, String str) {
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onUnRegister(int i, String str, String str2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(Context context) {
        try {
            this.context = context;
            if (!TextUtils.isEmpty(this.appKey) && !TextUtils.isEmpty(this.appSecret)) {
                Log.d("Assist_OP", "Register oppo push, pkg = " + context.getPackageName() + ", appKey = " + this.appKey + ", appSecret = " + this.appSecret);
                if (isSupport()) {
                    HeytapPushManager.register(context, this.appKey, this.appSecret, this);
                    return;
                } else {
                    Log.d("Assist_OP", "not support oppo push.");
                    return;
                }
            }
            Log.d("Assist_OP", "Register oppo push appKey or appSecret is null or empty");
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(Context context, int i, int i2) {
        if (i2 == 0) {
            turnOnPush(context);
            return;
        }
        int i3 = (i + i2) % 24;
        Log.d("Assist_OP", "getui setSilentTime" + i + u15.f19942b + i2);
        Log.d("Assist_OP", "oppo push setAcceptTime" + i3 + u15.f19942b + i);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < 7; i4++) {
            arrayList.add(Integer.valueOf(i4));
        }
        HeytapPushManager.setPushTime(arrayList, i3, 0, i, 0);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(Context context) {
        try {
            HeytapPushManager.pausePush();
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(Context context) {
        try {
            HeytapPushManager.resumePush();
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(Context context) {
        try {
            HeytapPushManager.unRegister();
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
        }
    }
}
