package com.fl.saas.s2s.topon;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.MediationInitCallback;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.manager.YdConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLTopOnInitManager extends ATInitMediation {
    private static final String TAG = CommConstant.getClassTag("FL", FLTopOnInitManager.class);
    private static FLTopOnInitManager sInstance;
    private boolean isInit;
    private HashMap<String, Object> mMultiAdObjects = new HashMap<>();

    public interface InitCallback {
        void onFinish();
    }

    private FLTopOnInitManager() {
    }

    public static synchronized FLTopOnInitManager getInstance() {
        if (sInstance == null) {
            sInstance = new FLTopOnInitManager();
        }
        return sInstance;
    }

    public int getAdapterBridgeVersion() {
        return 0;
    }

    public String getNetworkName() {
        return "FL Custom";
    }

    public String getNetworkVersion() {
        return "2.9.0";
    }

    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
    }

    public synchronized void initSDK(Context context, Map<String, Object> map, InitCallback initCallback) {
        if (this.isInit) {
            if (initCallback != null) {
                initCallback.onFinish();
            }
            return;
        }
        String str = (String) map.get("app_id");
        LogcatUtil.d(TAG, "initSDK，app_id：" + str);
        if (!TextUtils.isEmpty(str)) {
            YdConfig.getInstance().init(context, str, "", true);
            this.isInit = true;
            if (initCallback != null) {
                initCallback.onFinish();
            }
        }
    }

    public synchronized Object popBidAdObject(String str) {
        HashMap<String, Object> map;
        map = this.mMultiAdObjects;
        return (map == null || !map.containsKey(str)) ? null : this.mMultiAdObjects.remove(str);
    }

    public void putBidAdObject(String str, Object obj) {
        HashMap<String, Object> map = this.mMultiAdObjects;
        if (map != null) {
            map.put(str, obj);
        }
    }
}
