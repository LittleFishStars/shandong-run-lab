package com.kc.openset.third.custom.tobid;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.kc.openset.config.OSETSDK;
import com.kc.openset.listener.OSETInitListener;
import com.kc.openset.util.ErrorManager;
import com.windmill.sdk.custom.WMCustomAdapterProxy;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class OSETCustomToBidInitAdapter extends WMCustomAdapterProxy {
    private static final String TAG = "OSETInitAdapter";
    private boolean isInit = false;

    public int baseOnToBidCustomAdapterVersion() {
        return 2;
    }

    public String getNetworkSdkVersion() {
        return OSETSDK.getInstance().getVersionName();
    }

    public void initializeADN(Context context, Map<String, Object> map) {
        if (this.isInit) {
            Log.d(TAG, "initializeADN: 重复初始化");
            return;
        }
        try {
            Application application = (Application) context.getApplicationContext();
            String str = (String) map.get("custom_info");
            if (str == null) {
                str = "";
            }
            String strOptString = new JSONObject(str).optString("appId");
            Log.d(TAG, "initializeADN: appId=" + strOptString + ", serverExtra=" + map);
            OSETSDK.getInstance().init(application, strOptString, new OSETInitListener() { // from class: com.kc.openset.third.custom.tobid.OSETCustomToBidInitAdapter.1
                @Override // com.kc.openset.listener.OSETInitListener
                public void onError(String str2) {
                    Log.e(OSETCustomToBidInitAdapter.TAG, "initializeADN onError: " + str2);
                    OSETCustomToBidInitAdapter.this.callInitFail(ErrorManager.SS_ERROR_CODE_NO_INIT_OR_INIT_FAIL, str2);
                }

                @Override // com.kc.openset.listener.OSETInitListener
                public void onSuccess() {
                    Log.d(OSETCustomToBidInitAdapter.TAG, "initializeADN onSuccess");
                    OSETCustomToBidInitAdapter.this.isInit = true;
                    OSETCustomToBidInitAdapter.this.callInitSuccess();
                }
            });
        } catch (Exception e) {
            callInitFail(ErrorManager.SS_ERROR_CODE_NO_INIT_OR_INIT_FAIL, e.getMessage());
        }
    }

    public void notifyPrivacyStatusChange() {
    }
}
