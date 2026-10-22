package com.alibaba.ariver.resource.api.appxng;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.runtime.RuntimeCheckResult;
import com.alibaba.ariver.resource.runtime.RuntimeVersionChecker;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class AppxNgRuntimeChecker extends RuntimeVersionChecker {
    private static final String TAG = "AriverRes:AppxNgRuntimeChecker";

    public AppxNgRuntimeChecker(String str) {
        super(str);
    }

    @Override // com.alibaba.ariver.resource.runtime.RuntimeVersionChecker
    public RuntimeCheckResult checkRuntimeVersion(AppModel appModel, Bundle bundle) {
        String runtimeAppId = getRuntimeAppId();
        String string = BundleUtils.contains(bundle, getRuntimeRequired()) ? BundleUtils.getString(bundle, getRuntimeRequired()) : null;
        if (TextUtils.isEmpty(string) && appModel.getContainerInfo() != null) {
            string = JSONUtils.getString(appModel.getContainerInfo().getLaunchParams(), getRuntimeRequired());
        }
        String runtimeVersion = getRuntimeVersion();
        if (!TextUtils.isEmpty(runtimeVersion)) {
            RuntimeCheckResult runtimeCheckResultCheckRuntimeMatched = checkRuntimeMatched(runtimeAppId, runtimeVersion, string);
            if (!runtimeCheckResultCheckRuntimeMatched.isEnabled()) {
                RVLogger.d(getTag(), String.format("%s not match,update", runtimeAppId));
            }
            return runtimeCheckResultCheckRuntimeMatched;
        }
        RVLogger.d(TAG, runtimeAppId + "version is empty,appx-ng");
        return new RuntimeCheckResult(false, true, "1");
    }

    @Override // com.alibaba.ariver.resource.runtime.RuntimeVersionChecker
    public String getRuntimeRequired() {
        return "appxRuntimeRequired";
    }

    @Override // com.alibaba.ariver.resource.runtime.RuntimeVersionChecker
    public String getRuntimeSupportMax() {
        return "webRuntimeSupportMax";
    }

    @Override // com.alibaba.ariver.resource.runtime.RuntimeVersionChecker
    public String getRuntimeSupportMin() {
        return "webRuntimeSupportMin";
    }

    @Override // com.alibaba.ariver.resource.runtime.RuntimeVersionChecker
    public String getRuntimeVersion() {
        ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage(getRuntimeAppId());
        if (resourcePackage != null) {
            return resourcePackage.version();
        }
        return null;
    }

    @Override // com.alibaba.ariver.resource.runtime.RuntimeVersionChecker
    public String getTag() {
        return TAG;
    }
}
