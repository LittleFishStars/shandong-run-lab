package com.kc.dw.gather.duomeng;

import android.location.Location;
import com.domob.sdk.common.config.DMConfig;
import com.domob.sdk.common.config.PermissionConfig;
import com.domob.sdk.platform.DMAdSdk;
import com.kc.dw.base.a;
import com.kc.dw.core.AdSdk;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DMInitManager extends CustomInitLoader {
    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public String getPlatform() {
        return "DM";
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public String getVersionName() {
        return AdSdk.getDuoMengVersionName();
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public void initADN(String str, String str2, Map<String, Object> map) {
        try {
            DMAdSdk.getInstance().init(a.getContext(), new DMConfig().debug(false).setPermission(new PermissionConfig(this) { // from class: com.kc.dw.gather.duomeng.DMInitManager.1
                public final DMInitManager this$0;

                {
                    this.this$0 = this;
                }

                public String getAndroidId() {
                    return a.adConfig().customController() != null ? a.adConfig().customController().getAndroidId() : super.getAndroidId();
                }

                public String getImei() {
                    return super.getImei();
                }

                public Location getLocation() {
                    return a.adConfig().customController() != null ? a.adConfig().customController().getLocation() : super.getLocation();
                }

                public String getOAID() {
                    return AdSdk.getLocalOaid();
                }

                public boolean isCanGetAndroidId() {
                    return a.adConfig().customController() != null ? a.adConfig().customController().isCanUseAndroidId() : super.isCanGetAndroidId();
                }

                public boolean isCanGetAppList() {
                    return a.adConfig().customController() != null ? a.adConfig().customController().canReadInstalledPackages() : super.isCanGetAppList();
                }

                public boolean isCanGetLocation() {
                    return a.adConfig().customController() != null ? a.adConfig().customController().isCanUseLocation() : super.isCanGetLocation();
                }

                public boolean isCanGetOAID() {
                    return false;
                }

                public boolean isCanGetPhoneState() {
                    return a.adConfig().customController() != null ? a.adConfig().customController().isCanUsePhoneState() : super.isCanGetPhoneState();
                }

                public boolean isCanUseStorage() {
                    return a.adConfig().customController() != null ? a.adConfig().customController().canUseStoragePermission() : super.isCanUseStorage();
                }

                public boolean isUsePersonalRecommend() {
                    return a.adConfig().getCanUseSdkPersonalRecommend();
                }
            }));
            callInitSucc();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
