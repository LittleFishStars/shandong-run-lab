package com.fl.saas.config;

import android.text.TextUtils;
import com.fl.saas.base.bean.KsConfigBean;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ConfigLib {
    private static ConfigLib sInstance;
    private Map<String, KsConfigBean> ksAppConfig;
    private Map<String, KsConfigBean> ksSensorConfig;

    public static synchronized ConfigLib getInstance() {
        if (sInstance == null) {
            synchronized (ConfigLib.class) {
                sInstance = new ConfigLib();
            }
        }
        return sInstance;
    }

    public KsConfigBean getKsAppConfig(String str) {
        if (this.ksAppConfig == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.ksAppConfig.get(str);
    }

    public KsConfigBean getKsSensorConfig(String str) {
        if (this.ksSensorConfig == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.ksSensorConfig.get(str);
    }

    public void setKsAppConfig(JSONObject jSONObject) {
        if (this.ksAppConfig == null) {
            this.ksAppConfig = new HashMap();
        }
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString("app_id");
                String strOptString2 = jSONObject.optString("kuaishou_package_name");
                String strOptString3 = jSONObject.optString("kuaishou_version");
                String strOptString4 = jSONObject.optString("kuaishou_sha1");
                if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString4)) {
                    return;
                }
                this.ksAppConfig.put(strOptString, new KsConfigBean(strOptString2, strOptString3, strOptString4));
            } catch (Exception unused) {
            }
        }
    }

    public void setKsSensorConfig(JSONObject jSONObject) {
        if (this.ksSensorConfig == null) {
            this.ksSensorConfig = new HashMap();
        }
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString("tagid");
                int iOptInt = jSONObject.optInt("kuaishou_shake_sensitivity", 0);
                int iOptInt2 = jSONObject.optInt("kuaishou_twist_sensitivity", 0);
                if (TextUtils.isEmpty(strOptString) || iOptInt <= 0 || iOptInt2 <= 0) {
                    return;
                }
                this.ksSensorConfig.put(strOptString, new KsConfigBean(iOptInt, iOptInt2));
            } catch (Exception unused) {
            }
        }
    }
}
