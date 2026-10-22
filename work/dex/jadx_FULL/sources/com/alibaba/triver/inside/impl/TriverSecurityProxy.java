package com.alibaba.triver.inside.impl;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.proxy.ISecurityProxy;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverSecurityProxy implements ISecurityProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24999a = "Triver:SecurityProxy";

    @Override // com.alibaba.triver.kit.api.proxy.ISecurityProxy
    public String decryptString(String str) {
        IStaticDataEncryptComponent staticDataEncryptComp;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
            if (securityGuardManager == null || (staticDataEncryptComp = securityGuardManager.getStaticDataEncryptComp()) == null) {
                return null;
            }
            return staticDataEncryptComp.staticSafeDecrypt(16, "rap_code_key", str, null);
        } catch (Exception e) {
            RVLogger.e(f24999a, "decryptString error", e);
            return null;
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ISecurityProxy
    public String encryptString(String str) {
        IStaticDataEncryptComponent staticDataEncryptComp;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
            if (securityGuardManager == null || (staticDataEncryptComp = securityGuardManager.getStaticDataEncryptComp()) == null) {
                return null;
            }
            return staticDataEncryptComp.staticSafeEncrypt(16, "rap_code_key", str, null);
        } catch (Exception e) {
            RVLogger.e(f24999a, "encryptString error", e);
            return null;
        }
    }
}
