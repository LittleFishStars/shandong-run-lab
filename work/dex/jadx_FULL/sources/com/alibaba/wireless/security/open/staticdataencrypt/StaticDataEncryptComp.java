package com.alibaba.wireless.security.open.staticdataencrypt;

import com.alibaba.wireless.security.open.SecException;
import com.hzchengdun.securityguard.open.SecurityGuardManager;
import com.hzchengdun.securityguard.open.staticdataencrypt.StaticDataEncryptComponent;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StaticDataEncryptComp implements IStaticDataEncryptComponent {
    Charset charset = Charset.forName("UTF-8");
    private final SecurityGuardManager guardManager;

    public StaticDataEncryptComp(SecurityGuardManager securityGuardManager) {
        this.guardManager = securityGuardManager;
    }

    @Override // com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent
    public String staticSafeDecrypt(int i, String str, String str2, String str3) throws SecException {
        try {
            return new String(((StaticDataEncryptComponent) this.guardManager.getComponent(StaticDataEncryptComponent.class)).staticDecrypt(i, str, str2.getBytes(this.charset), str3), this.charset);
        } catch (com.hzchengdun.securityguard.open.SecException e) {
            throw new SecException(e.getErrorCode());
        }
    }

    @Override // com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent
    public String staticSafeEncrypt(int i, String str, String str2, String str3) throws SecException {
        try {
            return new String(((StaticDataEncryptComponent) this.guardManager.getComponent(StaticDataEncryptComponent.class)).staticEncrypt(i, str, str2.getBytes("UTF-8"), str3), this.charset);
        } catch (com.hzchengdun.securityguard.open.SecException e) {
            throw new SecException(e.getErrorCode());
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }
}
