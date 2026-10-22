package com.example.topon_adapter.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.MediationInitCallback;
import com.example.topon_adapter.adapter.LtAdInitManager;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.interfaces.listener.SdkDeviceInfoListener;
import com.ltmb.ltsdk.interfaces.listener.SdkInitListener;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LtAdInitManager extends ATInitMediation {
    private static final Object lock = new Object();
    private static volatile LtAdInitManager sInstance;
    private int mAppId;
    private Context mApplicationContext;
    private String wxAppId = "";
    private final Handler handler = new Handler(Looper.getMainLooper());
    private Object appIdObj = null;

    /* JADX INFO: renamed from: com.example.topon_adapter.adapter.LtAdInitManager$2, reason: invalid class name */
    public class AnonymousClass2 implements SdkInitListener {
        final /* synthetic */ MediationInitCallback val$callback;

        public AnonymousClass2(MediationInitCallback mediationInitCallback) {
            this.val$callback = mediationInitCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSdkInitFailed$1(MediationInitCallback mediationInitCallback, int i, String str) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onFail("SDK init failed: " + i + " - " + str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSdkInitSuccess$0(MediationInitCallback mediationInitCallback) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
            }
        }

        public void onSdkInitFailed(final int i, final String str) {
            LtAdInitManager ltAdInitManager = LtAdInitManager.this;
            final MediationInitCallback mediationInitCallback = this.val$callback;
            ltAdInitManager.postMainThread(new Runnable() { // from class: com.example.topon_adapter.adapter.a
                @Override // java.lang.Runnable
                public final void run() {
                    LtAdInitManager.AnonymousClass2.lambda$onSdkInitFailed$1(mediationInitCallback, i, str);
                }
            });
        }

        public void onSdkInitSuccess() {
            LtAdInitManager ltAdInitManager = LtAdInitManager.this;
            final MediationInitCallback mediationInitCallback = this.val$callback;
            ltAdInitManager.postMainThread(new Runnable() { // from class: com.example.topon_adapter.adapter.b
                @Override // java.lang.Runnable
                public final void run() {
                    LtAdInitManager.AnonymousClass2.lambda$onSdkInitSuccess$0(mediationInitCallback);
                }
            });
        }
    }

    private LtAdInitManager() {
    }

    public static LtAdInitManager getInstance() {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new LtAdInitManager();
                }
            }
        }
        return sInstance;
    }

    private void initLtmbSdk(Context context, int i, String str, final MediationInitCallback mediationInitCallback) {
        try {
            LTAdSdk.getInstance().init(context, i, str, new SdkDeviceInfoListener() { // from class: com.example.topon_adapter.adapter.LtAdInitManager.1
                public String getDevOAid() {
                    return "";
                }

                public boolean isUsReqeustAndroidId() {
                    return true;
                }

                public boolean isUsRequestImei() {
                    return true;
                }

                public boolean isUsRequestInstallPackages() {
                    return true;
                }

                public boolean isUsRequestLocation() {
                    return true;
                }

                public boolean isUsRequestOAid() {
                    return true;
                }
            }, new AnonymousClass2(mediationInitCallback));
        } catch (Exception e) {
            postMainThread(new Runnable() { // from class: com.zj.adlib.m45
                @Override // java.lang.Runnable
                public final void run() {
                    LtAdInitManager.lambda$initLtmbSdk$7(mediationInitCallback, e);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initLtmbSdk$7(MediationInitCallback mediationInitCallback, Exception exc) {
        if (mediationInitCallback != null) {
            mediationInitCallback.onFail("Init exception: " + exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initSDK$0(MediationInitCallback mediationInitCallback) {
        if (mediationInitCallback != null) {
            mediationInitCallback.onFail("Context is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initSDK$1(MediationInitCallback mediationInitCallback) {
        if (mediationInitCallback != null) {
            mediationInitCallback.onFail("请检查taku后台自定义广告网络中是否添加了正确的 appid key，字段名称必须是 appId 或 appid");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initSDK$2(MediationInitCallback mediationInitCallback) {
        if (mediationInitCallback != null) {
            mediationInitCallback.onFail("请检查taku后台自定义广告网络中是否添加了正确的 appid key，字段名称必须是 appId 或 appid");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSDK$3(MediationInitCallback mediationInitCallback) {
        if (mediationInitCallback != null) {
            mediationInitCallback.onFail("Invalid app_id format: " + this.appIdObj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initSDK$4(MediationInitCallback mediationInitCallback) {
        if (mediationInitCallback != null) {
            mediationInitCallback.onFail("app_id is required");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initSDK$5(MediationInitCallback mediationInitCallback, Exception exc) {
        if (mediationInitCallback != null) {
            mediationInitCallback.onFail("Parse config error: " + exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initSDK$6(MediationInitCallback mediationInitCallback) {
        if (mediationInitCallback != null) {
            mediationInitCallback.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postMainThread(Runnable runnable) {
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public String getNetworkName() {
        return "LTAdSdk";
    }

    public String getNetworkSDKVersion() {
        return "2.9.0";
    }

    public String getNetworkVersion() {
        return getNetworkSDKVersion();
    }

    public void initSDK(Context context, Map<String, Object> map, final MediationInitCallback mediationInitCallback) {
        if (context == null) {
            postMainThread(new Runnable() { // from class: com.zj.adlib.n45
                @Override // java.lang.Runnable
                public final void run() {
                    LtAdInitManager.lambda$initSDK$0(mediationInitCallback);
                }
            });
            return;
        }
        this.mApplicationContext = context.getApplicationContext();
        try {
            if (map == null) {
                postMainThread(new Runnable() { // from class: com.zj.adlib.o45
                    @Override // java.lang.Runnable
                    public final void run() {
                        LtAdInitManager.lambda$initSDK$1(mediationInitCallback);
                    }
                });
                return;
            }
            for (String str : map.keySet()) {
                if (!str.equalsIgnoreCase("appid")) {
                    if (str.equalsIgnoreCase("appld")) {
                        this.appIdObj = map.get(str);
                        break;
                    }
                } else {
                    this.appIdObj = map.get(str);
                    break;
                }
            }
            Object obj = this.appIdObj;
            if (obj == null) {
                postMainThread(new Runnable() { // from class: com.zj.adlib.p45
                    @Override // java.lang.Runnable
                    public final void run() {
                        LtAdInitManager.lambda$initSDK$2(mediationInitCallback);
                    }
                });
                return;
            }
            if (obj instanceof Integer) {
                this.mAppId = ((Integer) obj).intValue();
            } else if (!(obj instanceof String)) {
                postMainThread(new Runnable() { // from class: com.zj.adlib.s45
                    @Override // java.lang.Runnable
                    public final void run() {
                        LtAdInitManager.lambda$initSDK$4(mediationInitCallback);
                    }
                });
                return;
            } else {
                try {
                    this.mAppId = Integer.parseInt((String) obj);
                } catch (NumberFormatException unused) {
                    postMainThread(new Runnable() { // from class: com.zj.adlib.r45
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f19225a.lambda$initSDK$3(mediationInitCallback);
                        }
                    });
                    return;
                }
            }
            LTAdSdk.setPrivacyEnable(true);
            if (LTAdSdk.isInitSuccess()) {
                postMainThread(new Runnable() { // from class: com.zj.adlib.q45
                    @Override // java.lang.Runnable
                    public final void run() {
                        LtAdInitManager.lambda$initSDK$6(mediationInitCallback);
                    }
                });
            } else {
                initLtmbSdk(this.mApplicationContext, this.mAppId, this.wxAppId, mediationInitCallback);
            }
        } catch (Exception e) {
            postMainThread(new Runnable() { // from class: com.zj.adlib.t45
                @Override // java.lang.Runnable
                public final void run() {
                    LtAdInitManager.lambda$initSDK$5(mediationInitCallback, e);
                }
            });
        }
    }

    public boolean setUserDataConsent(Context context, boolean z, boolean z2) {
        return true;
    }
}
