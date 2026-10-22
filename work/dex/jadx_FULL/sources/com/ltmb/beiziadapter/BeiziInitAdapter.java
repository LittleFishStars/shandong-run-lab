package com.ltmb.beiziadapter;

import android.content.Context;
import android.util.Log;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.interfaces.listener.SdkDeviceInfoListener;
import com.ltmb.ltsdk.interfaces.listener.SdkInitListener;
import xyz.adscope.amps.AMPSSDK;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class BeiziInitAdapter extends AMPSChannelInitMediation {
    public static BeiziInitAdapter b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f40239a = false;

    public static synchronized BeiziInitAdapter getInstance() {
        if (b == null) {
            synchronized (BeiziInitAdapter.class) {
                b = new BeiziInitAdapter();
            }
        }
        return b;
    }

    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, final IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        Context context = AMPSSDK.getContext();
        if (LTAdSdk.isInitSuccess() || this.f40239a) {
            initSDKSuccess(iAMPSChannelInitCallBack);
            return;
        }
        String appId = aMPSInitAdapterConfig.getAppId();
        Log.d("beiziadapter-init", "appid=" + appId);
        LTAdSdk.setPrivacyEnable(true);
        LTAdSdk.getInstance().init(context, appId, (String) null, new SdkDeviceInfoListener(this) { // from class: com.ltmb.beiziadapter.BeiziInitAdapter.1
            public String getDevOAid() {
                return null;
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
        }, new SdkInitListener() { // from class: com.ltmb.beiziadapter.BeiziInitAdapter.2
            public void onSdkInitFailed(int i, String str) {
                IAMPSChannelInitCallBack iAMPSChannelInitCallBack2 = iAMPSChannelInitCallBack;
                if (iAMPSChannelInitCallBack2 != null) {
                    iAMPSChannelInitCallBack2.failCallBack(new AMPSError(String.valueOf(i), str));
                }
            }

            public void onSdkInitSuccess() {
                IAMPSChannelInitCallBack iAMPSChannelInitCallBack2 = iAMPSChannelInitCallBack;
                if (iAMPSChannelInitCallBack2 != null) {
                    iAMPSChannelInitCallBack2.successCallBack();
                }
                BeiziInitAdapter.this.f40239a = true;
            }
        });
    }
}
