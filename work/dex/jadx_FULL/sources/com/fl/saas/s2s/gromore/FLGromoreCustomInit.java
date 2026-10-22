package com.fl.saas.s2s.gromore;

import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.manager.YdConfig;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLGromoreCustomInit extends MediationCustomInitLoader {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeADN$0(Context context, MediationCustomInitConfig mediationCustomInitConfig) {
        YdConfig.getInstance().init(context, mediationCustomInitConfig.getAppId());
        callInitSuccess();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader
    public String getNetworkSdkVersion() {
        return "2.9.0";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader
    public void initializeADN(final Context context, final MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map) {
        LogcatUtil.d("YdSdk-FLGromoreCustomInit", "initializeADN:" + isInit());
        if (isInit()) {
            return;
        }
        new Thread(new Runnable() { // from class: com.zj.adlib.jc3
            @Override // java.lang.Runnable
            public final void run() {
                this.f17358a.lambda$initializeADN$0(context, mediationCustomInitConfig);
            }
        }).start();
    }
}
