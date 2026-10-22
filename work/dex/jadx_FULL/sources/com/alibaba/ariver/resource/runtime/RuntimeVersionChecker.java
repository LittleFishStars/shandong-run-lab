package com.alibaba.ariver.resource.runtime;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.content.BaseResourcePackage;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public abstract class RuntimeVersionChecker {
    private String mRuntimeAppId;

    public RuntimeVersionChecker(String str) {
        this.mRuntimeAppId = str;
    }

    public RuntimeCheckResult checkRuntimeMatched(String str, String str2, String str3) {
        RVLogger.d(getTag(), "checkRuntimeByAppInfo runtimeRequired: " + str3 + " runtimeVersion: " + str2);
        if (TextUtils.isEmpty(str3)) {
            return new RuntimeCheckResult(true);
        }
        if (TextUtils.isEmpty(str2) || "*".equals(str2)) {
            RVLogger.w(getTag(), "checkRuntimeByAppInfo runtimeVersion null!");
            return new RuntimeCheckResult(false, true, "1");
        }
        AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(str).version(str2));
        if (appModel == null) {
            RVLogger.w(getTag(), "checkRuntimeByAppInfo cannot find installedInfo!");
            if (((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ta_runtimecheck_from_loaded", true)) {
                ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage(str);
                if (resourcePackage instanceof BaseResourcePackage) {
                    AppModel appModel2 = ((BaseResourcePackage) resourcePackage).getAppModel();
                    RVLogger.w(getTag(), "loaded info is\t " + appModel2);
                    if (appModel2 != null && TextUtils.equals(str2, appModel2.getAppVersion())) {
                        appModel = appModel2;
                    }
                }
                if (appModel == null) {
                    return new RuntimeCheckResult(false, true, "7");
                }
            }
        }
        JSONObject jSONObject = JSONUtils.getJSONObject(appModel.getExtendInfos(), RVConstants.EXTRA_RES_LAUNCH_PARAMS, null);
        String string = JSONUtils.getString(jSONObject, getRuntimeSupportMin());
        String string2 = JSONUtils.getString(jSONObject, getRuntimeSupportMax());
        RVLogger.w(getTag(), "checkDegrade with runtimeSupportMin= " + string + ", runtimeSupportMax = " + string2);
        if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string)) {
            return new RuntimeCheckResult(false, true, "5");
        }
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            int i = TypeUtils.parseInt(str3);
            int i2 = TypeUtils.parseInt(string);
            int i3 = TypeUtils.parseInt(string2);
            if (i < i2 || i > i3) {
                RVLogger.w(getTag(), "checkRuntimeDegrade disable  by minsdk fail");
                return new RuntimeCheckResult(false, true, "5");
            }
        }
        return new RuntimeCheckResult(true);
    }

    public RuntimeCheckResult checkRuntimeVersion(AppModel appModel, Bundle bundle) {
        String runtimeVersion = getRuntimeVersion();
        if (TextUtils.isEmpty(runtimeVersion)) {
            RVLogger.d(getTag(), "checkRuntimeVersion ,but runtimeVersion is empty\t " + getRuntimeAppId());
            return new RuntimeCheckResult(false, true, "1");
        }
        String string = BundleUtils.contains(bundle, getRuntimeRequired()) ? BundleUtils.getString(bundle, getRuntimeRequired()) : null;
        if (TextUtils.isEmpty(string) && appModel.getContainerInfo() != null) {
            string = JSONUtils.getString(appModel.getContainerInfo().getLaunchParams(), getRuntimeRequired());
        }
        RuntimeCheckResult runtimeCheckResultCheckRuntimeMatched = checkRuntimeMatched(this.mRuntimeAppId, runtimeVersion, string);
        if (!runtimeCheckResultCheckRuntimeMatched.isEnabled()) {
            RVLogger.d(getTag(), String.format("%s not match,update", this.mRuntimeAppId));
        }
        return runtimeCheckResultCheckRuntimeMatched;
    }

    public String getRuntimeAppId() {
        return this.mRuntimeAppId;
    }

    public abstract String getRuntimeRequired();

    public abstract String getRuntimeSupportMax();

    public abstract String getRuntimeSupportMin();

    public abstract String getRuntimeVersion();

    public abstract String getTag();
}
