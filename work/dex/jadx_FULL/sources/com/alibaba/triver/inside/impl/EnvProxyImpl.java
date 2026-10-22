package com.alibaba.triver.inside.impl;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.ut.device.UTDevice;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.mtop.intf.Mtop;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EnvProxyImpl implements IEnvProxy {
    Map<String, String> mOptions = new HashMap();

    public EnvProxyImpl() {
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        this.mOptions.put("utdId", UTDevice.getUtdid(applicationContext));
        this.mOptions.put("timeOffset", SDKUtils.getTimeOffset() + "");
        this.mOptions.put(TRiverConstants.KEY_ENVIRONMENT_APP_GROUP, getAppGroup());
        this.mOptions.put("appVersion", getVersionName(applicationContext));
        this.mOptions.put("appName", getAppName(applicationContext));
        this.mOptions.put(TRiverConstants.KEY_ENVIRONMENT_RPC_APP_NAME, getRpcAppName(applicationContext));
        this.mOptions.put(TRiverConstants.KEY_ENVIRONMENT_RPC_APP_KEY, getRpcAppKey(applicationContext));
        this.mOptions.put("version", com.alibaba.triver.inside.a.f);
        a(applicationContext);
    }

    private void a(Context context) {
        Mtop mtopInstance = "AliApp".equals(getAppGroup()) ? Mtop.instance("INNER", context) : Mtop.instance("OPEN", context);
        try {
            this.mOptions.put("ttid", mtopInstance.getMtopConfig().ttid);
            this.mOptions.put(TRiverConstants.KEY_ENVIRONMENT_INDEX, String.valueOf(mtopInstance.getMtopConfig().envMode.getEnvMode()));
            this.mOptions.put("appKey", mtopInstance.getMtopConfig().appKey);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.IEnvProxy
    public String getAppGroup() {
        return "AliApp";
    }

    public String getAppName(Application application) {
        try {
            return application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData.getString("com.duanqu.appname");
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return "";
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.IEnvProxy
    public String getEnvValue(String str) {
        Map<String, String> map = this.mOptions;
        if (map == null) {
            return null;
        }
        String str2 = map.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (!TextUtils.equals(str, "appKey") && (!TextUtils.equals(str, "ttid") || !TextUtils.isEmpty(this.mOptions.get("appKey")))) {
            return str2;
        }
        a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
        return this.mOptions.get(str);
    }

    public String getRpcAppKey(Application application) {
        try {
            Object obj = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData.get("com.duanqu.appkey");
            return obj != null ? obj.toString() : "";
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return "";
        }
    }

    public String getRpcAppName(Application application) {
        try {
            return application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData.getString("com.duanqu.appid");
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return "";
        }
    }

    public String getVersionName(Application application) {
        try {
            return application.getPackageManager().getPackageInfo(application.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return "5.0.0";
        }
    }
}
