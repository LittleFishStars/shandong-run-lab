package com.huachenjie.ad.custom.ly;

import android.content.Context;
import android.util.Log;
import cj.mobile.CJMobileAd;
import cj.mobile.listener.CJInitListener;
import com.blankj.utilcode.util.Utils;
import com.huachenjie.ad.interfaces.AdLoader;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.custom.WMCustomAdapterProxy;
import com.zj.adlib.ai9;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class LYCustomerProxy extends WMCustomAdapterProxy {
    private static final String TAG = "LYCustomerProxy";

    public int baseOnToBidCustomAdapterVersion() {
        return 2;
    }

    public String getNetworkSdkVersion() {
        return CJMobileAd.getSdkVersion();
    }

    public void initializeADN(Context context, Map<String, Object> map) {
        try {
            String strOptString = new JSONObject((String) map.get("custom_info")).optString("appId");
            Log.i(TAG, "初始化领页Sdk -- appId：" + strOptString);
            AdLoader.b(ai9.k());
            boolean z = true;
            CJMobileAd.privacyCompliance(Utils.a(), true);
            CJMobileAd.isCanUseAppList(false);
            if (ai9.k()) {
                z = false;
            }
            CJMobileAd.offPersonal(z);
            CJMobileAd.init(context, strOptString, new CJInitListener() { // from class: com.huachenjie.ad.custom.ly.LYCustomerProxy.1
                @Override // cj.mobile.listener.CJInitListener
                public void initFailed(String str) {
                    LYCustomerProxy.this.callInitFail(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), str);
                }

                @Override // cj.mobile.listener.CJInitListener
                public void initSuccess() {
                    LYCustomerProxy.this.callInitSuccess();
                }
            });
        } catch (Exception e) {
            callInitFail(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e.getMessage());
        }
    }

    public void notifyPrivacyStatusChange() {
    }
}
