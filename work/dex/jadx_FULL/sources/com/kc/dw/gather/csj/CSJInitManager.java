package com.kc.dw.gather.csj;

import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.kc.dw.base.a;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.utils.n1;
import com.kc.dw.core.utils.w0;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CSJInitManager extends CustomInitLoader {
    private String appName;
    private String personalTypeValue = "1";

    private TTAdConfig buildTTConfig(String str) {
        this.personalTypeValue = a.adConfig().getCanUseSdkPersonalRecommend() ? "1" : "0";
        TTAdConfig.Builder builder = new TTAdConfig.Builder();
        if (n1.b) {
            try {
                Method declaredMethod = TTAdConfig.Builder.class.getDeclaredMethod("useMediation", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(builder, Boolean.TRUE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        builder.appId(str).appName(this.appName).titleBarTheme(1).data(getData(this.personalTypeValue)).allowShowNotify(a.adConfig().enableNotify()).supportMultiProcess(false).customController(new TTCustomController(this) { // from class: com.kc.dw.gather.csj.CSJInitManager.2
            public final CSJInitManager this$0;

            {
                this.this$0 = this;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean alist() {
                return a.adConfig().customController() != null ? a.adConfig().customController().canReadInstalledPackages() : super.alist();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevImei() {
                return a.adConfig().customController() != null ? a.adConfig().customController().getDevImei() : super.getDevImei();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevOaid() {
                return AdSdk.getLocalOaid();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getMacAddress() {
                return a.adConfig().customController() != null ? a.adConfig().customController().getMacAddress() : super.getMacAddress();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public LocationProvider getTTLocation() {
                return a.adConfig().customController() != null ? a.adConfig().customController().getTTLocation() : super.getTTLocation();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseAndroidId() {
                return a.adConfig().customController() != null ? a.adConfig().customController().isCanUseAndroidId() : super.isCanUseAndroidId();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseLocation() {
                if (a.adConfig().customController() != null) {
                    return a.adConfig().customController().isCanUseLocation();
                }
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePermissionRecordAudio() {
                return a.adConfig().customController() != null ? a.adConfig().customController().isCanUsePermissionRecordAudio() : super.isCanUsePermissionRecordAudio();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePhoneState() {
                if (a.adConfig().customController() == null) {
                    return super.isCanUsePhoneState();
                }
                if (a.adConfig().customController().isCsjUsePhoneState()) {
                    return a.adConfig().customController().isCanUsePhoneState();
                }
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWifiState() {
                return a.adConfig().customController() != null ? a.adConfig().customController().isCanUseWifiState() : super.isCanUseWifiState();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWriteExternal() {
                return a.adConfig().customController() != null ? a.adConfig().customController().canUseStoragePermission() : super.isCanUseWriteExternal();
            }
        });
        if (a.adConfig().userKeywords() != null) {
            builder.keywords(a.adConfig().userKeywords());
        }
        int iDownloadConfirm = a.adConfig().downloadConfirm();
        if (iDownloadConfirm == 1) {
            builder.directDownloadNetworkType(new int[0]);
        } else if (iDownloadConfirm != 2) {
            builder.directDownloadNetworkType(4);
        } else {
            builder.directDownloadNetworkType(4, 1);
        }
        builder.debug(a.adConfig().enableDebug());
        return builder.build();
    }

    private String getData(String str) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "personal_ads_type");
            jSONObject.put("value", str);
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public String getPlatform() {
        return "CSJ";
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public String getVersionName() {
        return AdSdk.getCSJVersionName();
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public void initADN(String str, String str2, Map<String, Object> map) {
        try {
            this.appName = w0.d(a.getContext());
            TTAdSdk.init(a.getContext(), buildTTConfig(str));
            TTAdSdk.start(new TTAdSdk.Callback(this) { // from class: com.kc.dw.gather.csj.CSJInitManager.1
                public final CSJInitManager this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                public void fail(int i, String str3) {
                    this.this$0.callInitFail();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                public void success() {
                    this.this$0.callInitSucc();
                }
            });
        } catch (Exception e) {
            callInitFail();
            e.printStackTrace();
        }
    }
}
