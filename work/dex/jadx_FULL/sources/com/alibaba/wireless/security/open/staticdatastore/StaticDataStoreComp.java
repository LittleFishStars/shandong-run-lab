package com.alibaba.wireless.security.open.staticdatastore;

import com.alibaba.wireless.security.open.SecException;
import com.hzchengdun.securityguard.open.SecurityGuardManager;
import com.hzchengdun.securityguard.open.staticdatastore.StaticDataStoreComponent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StaticDataStoreComp implements IStaticDataStoreComponent {
    private final SecurityGuardManager guardManager;

    public StaticDataStoreComp(SecurityGuardManager securityGuardManager) {
        this.guardManager = securityGuardManager;
    }

    @Override // com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent
    public String getAppKeyByIndex(int i, String str) throws SecException {
        try {
            return ((StaticDataStoreComponent) this.guardManager.getComponent(StaticDataStoreComponent.class)).getAppKeyByIndex(i, str);
        } catch (com.hzchengdun.securityguard.open.SecException e) {
            throw new SecException(e.getErrorCode());
        }
    }
}
