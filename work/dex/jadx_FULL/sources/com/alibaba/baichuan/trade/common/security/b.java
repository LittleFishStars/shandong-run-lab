package com.alibaba.baichuan.trade.common.security;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24563a;
    private SecurityGuardManager b;

    @Override // com.alibaba.baichuan.trade.common.security.a
    public final AlibcSecurityGuard.a a() {
        try {
            int iInitialize = SecurityGuardManager.getInitializer("baichuan").initialize(AlibcBaseTradeCommon.context);
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(AlibcBaseTradeCommon.context);
            this.b = securityGuardManager;
            String appKeyByIndex = securityGuardManager.getStaticDataStoreComp().getAppKeyByIndex(0, "baichuan");
            this.f24563a = appKeyByIndex;
            if (1 != iInitialize || TextUtils.isEmpty(appKeyByIndex)) {
                return new AlibcSecurityGuard.a(AlibcCommonConstant.SECURITY_INIT_FAIL_ERROR_MSG);
            }
            AlibcLogger.i("AlibcStandardSecurityGuard", "security sdk init success");
            return new AlibcSecurityGuard.a(0);
        } catch (SecException e) {
            AlibcLogger.e("AlibcStandardSecurityGuard", "security sdk int exception: code = " + e.getErrorCode() + ", msg = " + e.getMessage());
            return new AlibcSecurityGuard.a(e.getErrorCode(), AlibcCommonConstant.SECURITY_INIT_FAIL_ERROR_MSG);
        }
    }

    @Override // com.alibaba.baichuan.trade.common.security.a
    public final String b() {
        return this.f24563a;
    }

    @Override // com.alibaba.baichuan.trade.common.security.a
    @Deprecated
    public final Long c(String str) {
        return Long.valueOf(Long.parseLong(str));
    }

    @Override // com.alibaba.baichuan.trade.common.security.a
    public final String b(String str) {
        SecurityGuardManager securityGuardManager = this.b;
        if (securityGuardManager == null) {
            return str;
        }
        try {
            IDynamicDataEncryptComponent dynamicDataEncryptComp = securityGuardManager.getDynamicDataEncryptComp();
            return dynamicDataEncryptComp == null ? str : dynamicDataEncryptComp.dynamicDecryptDDp(str);
        } catch (SecException e) {
            AlibcLogger.e("AlibcStandardSecurityGuard", "decrypt data exception: code = " + e.getErrorCode() + ", msg = " + e.getMessage());
            return str;
        }
    }

    @Override // com.alibaba.baichuan.trade.common.security.a
    public final String a(String str) {
        SecurityGuardManager securityGuardManager = this.b;
        if (securityGuardManager == null) {
            return str;
        }
        try {
            IDynamicDataEncryptComponent dynamicDataEncryptComp = securityGuardManager.getDynamicDataEncryptComp();
            return dynamicDataEncryptComp == null ? str : dynamicDataEncryptComp.dynamicEncryptDDp(str);
        } catch (SecException e) {
            AlibcLogger.e("AlibcStandardSecurityGuard", "encrypt data exception: " + e.getMessage());
            return str;
        }
    }
}
