package com.fl.saas.s2s.tobid;

import android.content.Context;
import android.util.Log;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.ydsdk.manager.YdConfig;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.custom.WMCustomAdapterProxy;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLToBidCustomerProxy extends WMCustomAdapterProxy {
    private static final String TAG = CommConstant.getClassTag("FLToBid", FLToBidCustomerProxy.class);

    public int baseOnToBidCustomAdapterVersion() {
        return 2;
    }

    public String getNetworkSdkVersion() {
        return "2.9.0";
    }

    public void initializeADN(Context context, Map<String, Object> map) {
        try {
            String strOptString = new JSONObject((String) map.get("custom_info")).optString("appId");
            Log.d(TAG, "initializeADN:" + strOptString);
            YdConfig.getInstance().init(context, strOptString, "", true);
            callInitSuccess();
        } catch (Throwable th) {
            th.printStackTrace();
            callInitFail(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), th.getMessage());
        }
    }

    public void notifyPrivacyStatusChange() {
        Log.d(TAG, "notifyPrivacyStatusChange");
    }
}
