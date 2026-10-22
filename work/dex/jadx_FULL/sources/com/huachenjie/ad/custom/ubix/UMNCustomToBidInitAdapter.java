package com.huachenjie.ad.custom.ubix;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.text.TextUtils;
import android.util.Log;
import com.ubixnow.core.api.UMNAdConfig;
import com.ubixnow.core.api.UMNAdManager;
import com.ubixnow.core.api.UMNInitCallBack;
import com.ubixnow.core.api.UMNPrivacyConfig;
import com.windmill.sdk.WindMillAd;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.custom.WMCustomAdapterProxy;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class UMNCustomToBidInitAdapter extends WMCustomAdapterProxy {
    private final String TAG = getClass().getSimpleName();
    private UMNPrivacyConfig privacyConfig;

    public int baseOnToBidCustomAdapterVersion() {
        return 2;
    }

    public String getNetworkSdkVersion() {
        return UMNAdManager.getSdkVersion();
    }

    public UMNPrivacyConfig getPrivacyConfig() {
        UMNPrivacyConfig uMNPrivacyConfig = new UMNPrivacyConfig() { // from class: com.huachenjie.ad.custom.ubix.UMNCustomToBidInitAdapter.1
            public boolean appList() {
                if (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null) {
                    return true;
                }
                return WindMillAd.sharedAds().getAdConfig().getCustomController().isCanUseAppList();
            }

            public String getA() {
                return (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null) ? "" : WindMillAd.sharedAds().getAdConfig().getCustomController().getAndroidId();
            }

            public List<String> getAppList() {
                List installedPackages;
                if (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null || (installedPackages = WindMillAd.sharedAds().getAdConfig().getCustomController().getInstalledPackages()) == null || installedPackages.isEmpty()) {
                    return super.getAppList();
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = installedPackages.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PackageInfo) it.next()).packageName);
                }
                return arrayList;
            }

            public String getDevImei() {
                return (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null) ? "" : WindMillAd.sharedAds().getAdConfig().getCustomController().getDevImei();
            }

            public Location getLocation() {
                if (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null) {
                    return null;
                }
                return WindMillAd.sharedAds().getAdConfig().getCustomController().getLocation();
            }

            public String getMacAddress() {
                return (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null) ? "" : WindMillAd.sharedAds().getAdConfig().getCustomController().getMacAddress();
            }

            public String getO() {
                return (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null) ? "" : WindMillAd.sharedAds().getAdConfig().getCustomController().getDevOaid();
            }

            public boolean isA() {
                if (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null) {
                    return true;
                }
                return WindMillAd.sharedAds().getAdConfig().getCustomController().isCanUseAndroidId();
            }

            public boolean isCanUseLocation() {
                if (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null) {
                    return true;
                }
                return WindMillAd.sharedAds().getAdConfig().getCustomController().isCanUseLocation();
            }

            public boolean isCanUseMacAddress() {
                return super.isCanUseMacAddress();
            }

            public boolean isCanUsePhoneState() {
                if (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null) {
                    return true;
                }
                return WindMillAd.sharedAds().getAdConfig().getCustomController().isCanUsePhoneState();
            }

            public boolean isCanUseWriteExternal() {
                if (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null) {
                    return true;
                }
                return WindMillAd.sharedAds().getAdConfig().getCustomController().isCanUseWriteExternal();
            }

            public boolean isLimitPersonalAds() {
                if (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null) {
                    return false;
                }
                return !WindMillAd.sharedAds().isPersonalizedAdvertisingOn();
            }

            public boolean isO() {
                return super.isO();
            }

            public boolean isProgrammaticRecommend() {
                return super.isProgrammaticRecommend();
            }

            public boolean isW() {
                if (WindMillAd.sharedAds().getAdConfig() == null || WindMillAd.sharedAds().getAdConfig().getCustomController() == null) {
                    return true;
                }
                return WindMillAd.sharedAds().getAdConfig().getCustomController().isCanUseWifiState();
            }
        };
        this.privacyConfig = uMNPrivacyConfig;
        return uMNPrivacyConfig;
    }

    public void initializeADN(Context context, Map<String, Object> map) {
        try {
            getPrivacyConfig();
            String str = (String) map.get("custom_info");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String strOptString = new JSONObject(str).optString("appId");
            Log.d(this.TAG, "initializeADN:" + strOptString);
            UMNAdManager.getInstance().asyncInit(context, new UMNAdConfig.Builder().setAppId(strOptString).setPrivacyConfig(this.privacyConfig).setDebug(false).build());
            UMNAdManager.getInstance().start(new UMNInitCallBack() { // from class: com.huachenjie.ad.custom.ubix.UMNCustomToBidInitAdapter.2
                public void onFail(int i, String str2) {
                    Log.e(UMNCustomToBidInitAdapter.this.TAG, "onFail: " + i + u15.f19942b + str2);
                    UMNCustomToBidInitAdapter.this.callInitFail(i, str2);
                }

                public void onSucc() {
                    Log.e(UMNCustomToBidInitAdapter.this.TAG, "onSucc: ");
                    UMNCustomToBidInitAdapter.this.callInitSuccess();
                }
            });
        } catch (Exception e) {
            callInitFail(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e.getMessage());
            Log.e(this.TAG, "initializeADN: " + e);
        }
    }

    public void notifyPrivacyStatusChange() {
        UMNAdManager.updatePrivacyConfig(getPrivacyConfig());
    }
}
