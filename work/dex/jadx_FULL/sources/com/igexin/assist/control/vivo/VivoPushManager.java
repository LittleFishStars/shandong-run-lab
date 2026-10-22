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
public class VivoPushManager implements AbstractPushManager {
    public static final String PLUGIN_VERSION = "3.1.2";
    public static final String TAG = "Assist_VV";
    private static final String VIVO_VERSION = "sdk_version_vivo";
    private String mSdkSwitchPath;
    private String mToken = "";
    public static final String VIVO = "Vivo".toLowerCase();
    private static final String phoneBrand = Build.BRAND;

    public VivoPushManager(Context context) {
        try {
            PushConfig pushConfigBuild = new PushConfig.Builder().agreePrivacyStatement(true).build();
            Log.d("Assist_VV", "vivo plugin version = 3.1.2, vivo sdk version = 488");
            this.mSdkSwitchPath = context.getFilesDir().getPath() + "/init.pid";
            PushClient.getInstance(context).initialize(pushConfigBuild);
            PushClient.getInstance(context).checkManifest();
        } catch (Throwable th) {
            Log.e("Assist_VV", th.getMessage());
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

    public static boolean checkVivoDevice(Context context) {
        try {
            boolean zIsSupport = PushClient.getInstance(context).isSupport();
            Log.d("Assist_VV", "the vivo system push support = ".concat(String.valueOf(zIsSupport)));
            return zIsSupport;
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
            return false;
        }
    }

    private boolean isSdkInit() {
        if (this.mSdkSwitchPath != null) {
            return new File(this.mSdkSwitchPath).exists();
        }
        return false;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return null;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getToken(Context context) {
        return this.mToken;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        return false;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(Context context) {
        try {
            Log.d("Assist_VV", "Register vivo push, pkg = " + context.getPackageName());
            if (PushManager.getInstance().isPushTurnedOn(context) || !isSdkInit()) {
                turnOnPush(context);
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
            PushClient.getInstance(context).turnOffPush(new IPushActionListener() { // from class: com.igexin.assist.control.vivo.VivoPushManager.2
                public void onStateChanged(int i) {
                    Log.d("Assist_VV", "turnOffPush finish, state = ".concat(String.valueOf(i)));
                    if (i == 0) {
                        VivoPushManager.this.mToken = "";
                        if (context != null) {
                            Log.d("Assist_VV", "turnOnPush token = \"false\"");
                            MessageManger.getInstance().addMessage(new MessageBean(context, "token", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(final Context context) {
        try {
            PushClient.getInstance(context).turnOnPush(new IPushActionListener() { // from class: com.igexin.assist.control.vivo.VivoPushManager.1
                public void onStateChanged(int i) {
                    Log.d("Assist_VV", "turnOnPush finish, state = ".concat(String.valueOf(i)));
                    if (i == 0) {
                        PushClient.getInstance(context).getRegId(new IPushQueryActionListener() { // from class: com.igexin.assist.control.vivo.VivoPushManager.1.1
                            public void onFail(Integer num) {
                                Log.d("Assist_VV", "get fail token = ".concat(String.valueOf(num)));
                            }

                            public void onSuccess(String str) {
                                VivoPushManager.this.mToken = str;
                                Log.d("Assist_VV", "get success token = " + VivoPushManager.this.mToken);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (context == null || TextUtils.isEmpty(VivoPushManager.this.mToken)) {
                                    return;
                                }
                                MessageBean messageBean = new MessageBean(context, "token", AssistPushConsts.VIVO_PREFIX + VivoPushManager.this.mToken);
                                VivoPushManager.this.addVivoMessageBeanExtra(messageBean);
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
    public void unregister(Context context) {
        try {
            turnOffPush(context);
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
        }
    }
}
