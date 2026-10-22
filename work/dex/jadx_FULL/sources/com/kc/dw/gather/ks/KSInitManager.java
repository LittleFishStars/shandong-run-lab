package com.kc.dw.gather.ks;

import android.location.Location;
import com.kc.dw.base.a;
import com.kc.dw.core.AdSdk;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class KSInitManager extends CustomInitLoader {
    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public String getPlatform() {
        return "KS";
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public String getVersionName() {
        return AdSdk.getKSVersionName();
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public void initADN(String str, String str2, Map<String, Object> map) {
        KsAdSDK.setPersonalRecommend(a.adConfig().getCanUseSdkPersonalRecommend());
        SdkConfig.Builder builder = new SdkConfig.Builder();
        builder.appId(str).showNotification(a.adConfig().enableNotify()).customController(new KsCustomController(this) { // from class: com.kc.dw.gather.ks.KSInitManager.1
            public final KSInitManager this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadInstalledPackages() {
                return a.adConfig().customController() != null ? a.adConfig().customController().canReadInstalledPackages() : super.canReadInstalledPackages();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadLocation() {
                return a.adConfig().customController() != null ? a.adConfig().customController().isCanUseLocation() : super.canReadLocation();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseMacAddress() {
                return a.adConfig().customController() != null ? a.adConfig().customController().canUseMacAddress() : super.canUseMacAddress();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseNetworkState() {
                return a.adConfig().customController() != null ? a.adConfig().customController().canUseNetworkState() : super.canUseNetworkState();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUsePhoneState() {
                return a.adConfig().customController() != null ? a.adConfig().customController().isCanUsePhoneState() : super.canUsePhoneState();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseStoragePermission() {
                return a.adConfig().customController() != null ? a.adConfig().customController().canUseStoragePermission() : super.canUseStoragePermission();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getAndroidId() {
                return a.adConfig().customController() != null ? a.adConfig().customController().getAndroidId() : super.getAndroidId();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getImei() {
                return a.adConfig().customController() != null ? a.adConfig().customController().getDevImei() : super.getImei();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public Location getLocation() {
                return a.adConfig().customController() != null ? a.adConfig().customController().getLocation() : super.getLocation();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getMacAddress() {
                return a.adConfig().customController() != null ? a.adConfig().customController().getMacAddress() : super.getMacAddress();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getOaid() {
                return AdSdk.getLocalOaid();
            }
        }).debug(a.adConfig().enableDebug());
        try {
            KsAdSDK.init(a.getContext(), builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            KsAdSDK.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        callInitSucc();
    }
}
