package com.alibaba.wireless.security.open.dynamicdataencrypt;

import com.alibaba.wireless.security.open.SecException;
import com.hzchengdun.securityguard.open.SecurityGuardManager;
import com.hzchengdun.securityguard.open.dynamicdataencrypt.DynamicDataEncryptComponent;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DynamicDataEncryptComp implements IDynamicDataEncryptComponent {
    private final SecurityGuardManager guardManager;

    public DynamicDataEncryptComp(SecurityGuardManager securityGuardManager) {
        this.guardManager = securityGuardManager;
    }

    @Override // com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent
    public String dynamicDecryptDDp(String str) throws SecException {
        try {
            return new String(((DynamicDataEncryptComponent) this.guardManager.getComponent(DynamicDataEncryptComponent.class)).dynamicDecrypt(str.getBytes("UTF-8")), "UTF-8");
        } catch (com.hzchengdun.securityguard.open.SecException e) {
            throw new SecException(e.getErrorCode());
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent
    public String dynamicEncryptDDp(String str) throws SecException {
        try {
            return new String(((DynamicDataEncryptComponent) this.guardManager.getComponent(DynamicDataEncryptComponent.class)).dynamicEncrypt(str.getBytes("UTF-8")), "UTF-8");
        } catch (com.hzchengdun.securityguard.open.SecException e) {
            throw new SecException(e.getErrorCode());
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }
}
