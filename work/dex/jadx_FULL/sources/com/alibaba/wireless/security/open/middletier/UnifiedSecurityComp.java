package com.alibaba.wireless.security.open.middletier;

import com.alibaba.wireless.security.open.SecException;
import com.hzchengdun.securityguard.open.SecurityGuardManager;
import com.hzchengdun.securityguard.open.unifiedsecurity.UnifiedSecurityComponent;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UnifiedSecurityComp implements IUnifiedSecurityComponent {
    private final SecurityGuardManager guardManager;

    public UnifiedSecurityComp(SecurityGuardManager securityGuardManager) {
        this.guardManager = securityGuardManager;
    }

    @Override // com.alibaba.wireless.security.open.middletier.IUnifiedSecurityComponent
    public HashMap<String, String> getSecurityFactors(HashMap<String, Object> map) throws SecException {
        try {
            return ((UnifiedSecurityComponent) this.guardManager.getComponent(UnifiedSecurityComponent.class)).getSecurityFactors(map);
        } catch (com.hzchengdun.securityguard.open.SecException e) {
            throw new SecException(e.getErrorCode());
        }
    }

    @Override // com.alibaba.wireless.security.open.middletier.IUnifiedSecurityComponent
    public void init(HashMap<String, Object> map) throws SecException {
        try {
            ((UnifiedSecurityComponent) this.guardManager.getComponent(UnifiedSecurityComponent.class)).init(map);
        } catch (com.hzchengdun.securityguard.open.SecException e) {
            throw new SecException(e.getErrorCode());
        }
    }
}
