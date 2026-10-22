package com.alibaba.triver.inside.impl.commonability;

import android.text.TextUtils;
import com.alibaba.ariver.commonability.device.jsapi.clipboard.a;
import com.alibaba.ariver.commonability.device.jsapi.contact.b;
import com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRCommonAbilityProxyImpl implements RVCommonAbilityProxy {
    @Override // com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy
    public b getAddPhoneContactDialog() {
        return null;
    }

    @Override // com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy
    public String getAppAlias() {
        String appName = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getAppName();
        return TextUtils.isEmpty(appName) ? "" : appName;
    }

    @Override // com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy
    public a getClipboardTextHandler() {
        return null;
    }

    @Override // com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy
    public String getDevicePerformance() {
        return RVCommonAbilityProxy.MIDDLE;
    }

    @Override // com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy
    public float getFontSizeSetting() {
        return 16.0f;
    }

    @Override // com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy
    public String getLocalLanguage() {
        return "cn";
    }

    @Override // com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy
    public boolean hasRootStatusPermission(String str) {
        return true;
    }
}
