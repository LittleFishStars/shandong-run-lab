package com.fl.saas.config.utils;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.util.DeviceStateUtil;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LoadConfigUtil {
    private static LoadConfigUtil sInstance;

    /* JADX INFO: renamed from: com.fl.saas.config.utils.LoadConfigUtil$2, reason: invalid class name */
    public class AnonymousClass2 implements HttpCallbackStringListener {
        public AnonymousClass2() {
        }

        @Override // com.fl.saas.config.http.HttpCallbackStringListener
        public void onError(Exception exc) {
        }

        @Override // com.fl.saas.config.http.HttpCallbackStringListener
        public void onJump(String str) {
        }

        @Override // com.fl.saas.config.http.HttpCallbackStringListener
        public void onSuccess(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                final String strOptString = new JSONObject(str).optString("content");
                ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.fl.saas.config.utils.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConfigParseUtil.parseData(strOptString);
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private LoadConfigUtil() {
    }

    public static LoadConfigUtil getInstance() {
        if (sInstance == null) {
            synchronized (LoadConfigUtil.class) {
                sInstance = new LoadConfigUtil();
            }
        }
        return sInstance;
    }

    private JSONObject getRequestParams() {
        int iLoadExists = 0;
        int i = SPUtil.getInstance().getInt("key_z_number", 0);
        if (i > 0) {
            String string = SPUtil.getInstance().getString("key_z_value", "");
            if (!TextUtils.isEmpty(string)) {
                iLoadExists = ConfigParseUtil.loadExists(string);
            }
        } else {
            iLoadExists = i;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", DeviceUtil.getReqID(""));
            jSONObject.putOpt("version", "29004");
            jSONObject.putOpt("dpVersion", Integer.valueOf(iLoadExists));
            jSONObject.putOpt("sdkPackageName", "com.yd.saas");
            JSONObject deviceInfo = DeviceUtil.getDeviceInfo();
            deviceInfo.put("usbEnabled", DeviceStateUtil.isDeveloperOptionsEnabled(DeviceUtil.getContext()) ? 1 : 0);
            deviceInfo.put("proxyEnabled", DeviceStateUtil.isNetworkProxyEnabled(DeviceUtil.getContext()) ? 1 : 0);
            deviceInfo.put("rootEnabled", DeviceStateUtil.isDeviceRooted() ? 1 : 0);
            deviceInfo.put("isDebug", DeviceStateUtil.isDebug() ? 1 : 0);
            deviceInfo.put("hasSimCard", DeviceStateUtil.hasSimCard(DeviceUtil.getContext()) ? 1 : 0);
            jSONObject.putOpt("device", deviceInfo);
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void getData(String str) {
        AdHttpUtils.getInstance().doGet("http://39.107.124.86/api/dp/content?md5=" + str, new AnonymousClass2());
    }

    public void getRequestData() {
        if (DeviceUtil.isClassExist("com.fl.adx.api.AdParams")) {
            return;
        }
        AdHttpUtils.getInstance().doPost("http://39.107.124.86/api/dp/config", AesUtils.encrypt(getRequestParams().toString()), new HttpCallbackStringListener() { // from class: com.fl.saas.config.utils.LoadConfigUtil.1
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
                exc.printStackTrace();
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onSuccess(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("code", 1) == 0) {
                        String strOptString = jSONObject.optString("status");
                        if ("A".equals(strOptString)) {
                            String strOptString2 = jSONObject.optString("value");
                            if (!TextUtils.isEmpty(strOptString2) && !"null".equalsIgnoreCase(strOptString2)) {
                                LoadConfigUtil.this.getData(strOptString2);
                            }
                        } else if ("D".equals(strOptString)) {
                            ConfigParseUtil.delete();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
