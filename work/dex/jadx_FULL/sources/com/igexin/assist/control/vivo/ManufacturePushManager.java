package com.igexin.assist.control.vivo;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.sdk.PushManager;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.vivo.push.PushConfig;
import com.vivo.push.listener.IPushQueryActionListener;
import java.io.File;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ManufacturePushManager implements AbstractPushManager {
    public static final String PLUGIN_VERSION = "3.1.2";
    public static final String TAG = "Assist_VV";
    private static final String VIVO_VERSION = "sdk_version_vivo";
    private Context context;
    private String mSdkSwitchPath;
    private String mToken = "";
    public static final String VIVO = "Vivo".toLowerCase();
    private static final String phoneBrand = Build.BRAND;

    public ManufacturePushManager(Context context) {
        try {
            PushConfig pushConfigBuild = new PushConfig.Builder().agreePrivacyStatement(true).build();
            this.context = context;
            Log.d("Assist_VV", "vivo plugin version = 3.1.2, vivo sdk version = 488");
            this.mSdkSwitchPath = context.getFilesDir().getPath() + "/init.pid";
            PushClient.getInstance(context).initialize(pushConfigBuild);
            PushClient.getInstance(context).checkManifest();
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVivoMessageBeanExtra(MessageBean messageBean) {
        try {
            Field declaredField = MessageBean.class.getDeclaredField("extra");
            declaredField.setAccessible(true);
            ((Bundle) declaredField.get(messageBean)).putBoolean("isForce", true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean isSdkInit() {
        if (this.mSdkSwitchPath != null) {
            return new File(this.mSdkSwitchPath).exists();
        }
        return false;
    }

    private void turnOnPush(final Context context, final boolean z) {
        try {
            PushClient.getInstance(context).turnOnPush(new IPushActionListener() { // from class: com.igexin.assist.control.vivo.ManufacturePushManager.1
                public void onStateChanged(int i) {
                    Log.d("Assist_VV", "turnOnPush finish, state = ".concat(String.valueOf(i)));
                    if (i == 0) {
                        PushClient.getInstance(context).getRegId(new IPushQueryActionListener() { // from class: com.igexin.assist.control.vivo.ManufacturePushManager.1.1
                            public void onFail(Integer num) {
                                Log.d("Assist_VV", "get fail token = ".concat(String.valueOf(num)));
                            }

                            public void onSuccess(String str) {
                                ManufacturePushManager.this.mToken = str;
                                Log.d("Assist_VV", "get success token = " + ManufacturePushManager.this.mToken);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (context == null || TextUtils.isEmpty(ManufacturePushManager.this.mToken)) {
                                    return;
                                }
                                MessageBean messageBean = new MessageBean(context, "token", AssistPushConsts.VIVO_PREFIX + ManufacturePushManager.this.mToken);
                                AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                                if (z) {
                                    ManufacturePushManager.this.addVivoMessageBeanExtra(messageBean);
                                }
                                MessageManger.getInstance().addMessage(messageBean);
                            }
                        });
                    } else if (i == 101) {
                        Log.d("Assist_VV", "the vivo rom not support system push");
                    }
                }
            });
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return "6";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getToken(Context context) {
        return this.mToken;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        try {
            if (!TextUtils.equals(VIVO, phoneBrand.toLowerCase())) {
                return false;
            }
            boolean zIsSupport = PushClient.getInstance(this.context).isSupport();
            Log.d("Assist_VV", "the vivo system push support = ".concat(String.valueOf(zIsSupport)));
            return zIsSupport;
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(Context context) {
        try {
            Log.d("Assist_VV", "Register vivo push, pkg = " + context.getPackageName());
            if (!PushManager.getInstance().isPushTurnedOn(context) && isSdkInit()) {
                Log.d("Assist_VV", "gt push off.");
                return;
            }
            if (isSupport()) {
                turnOnPush(context, false);
            } else {
                Log.d("Assist_VV", "vivopush not support.");
            }
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(Context context, int i, int i2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(final Context context) {
        try {
            PushClient.getInstance(context).turnOffPush(new IPushActionListener() { // from class: com.igexin.assist.control.vivo.ManufacturePushManager.2
                public void onStateChanged(int i) {
                    ManufacturePushManager.this.mToken = "";
                    Log.d("Assist_VV", "turnOffPush finish, state = ".concat(String.valueOf(i)));
                    if (context != null) {
                        Log.d("Assist_VV", "turnOnPush token = \"false\"");
                        MessageManger.getInstance().addMessage(new MessageBean(context, "token", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
                    }
                }
            });
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(Context context) {
        turnOnPush(context, true);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(Context context) {
        try {
            turnOffPush(context);
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
        }
    }
}
