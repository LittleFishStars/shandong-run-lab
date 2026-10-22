package com.ltmb.gromoreadapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import com.kc.openset.constant.DeviceIdType;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.interfaces.listener.SdkDeviceInfoListener;
import com.ltmb.ltsdk.interfaces.listener.SdkInitListener;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class LTGroMoreInit extends MediationCustomInitLoader {
    private void initSDK(Context context, MediationCustomInitConfig mediationCustomInitConfig, final Map<String, Object> map) {
        LTAdSdk.getInstance().init(context, mediationCustomInitConfig.getAppId(), "", new SdkDeviceInfoListener(this) { // from class: com.ltmb.gromoreadapter.LTGroMoreInit.1
            public String getDevOAid() {
                Map map2 = map;
                return (map2 == null || !map2.containsKey(DeviceIdType.OAID)) ? "" : (String) map.get(DeviceIdType.OAID);
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
        }, new SdkInitListener() { // from class: com.ltmb.gromoreadapter.LTGroMoreInit.2
            public void onSdkInitFailed(int i, String str) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.ltmb.gromoreadapter.LTGroMoreInit.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }

            public void onSdkInitSuccess() {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ltmb.gromoreadapter.LTGroMoreInit.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LTGroMoreInit.this.callInitSuccess();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeADN$0(Context context, MediationCustomInitConfig mediationCustomInitConfig, Map map) {
        LTAdSdk.setPrivacyEnable(true);
        initSDK(context, mediationCustomInitConfig, map);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader
    public String getBiddingToken(Context context, Map<String, Object> map) {
        return "bidding token";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader
    public String getNetworkSdkVersion() {
        return "2.7.4";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader
    public String getSdkInfo(Context context, Map<String, Object> map) {
        return "sdk info";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader
    public void initializeADN(final Context context, final MediationCustomInitConfig mediationCustomInitConfig, final Map<String, Object> map) {
        Log.i("TMe", "customInitConfig = " + mediationCustomInitConfig);
        if (isInit()) {
            return;
        }
        new Thread(new Runnable() { // from class: com.zj.adlib.mv4
            @Override // java.lang.Runnable
            public final void run() {
                this.f18317a.lambda$initializeADN$0(context, mediationCustomInitConfig, map);
            }
        }).start();
    }
}
