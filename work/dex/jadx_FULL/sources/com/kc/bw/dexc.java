package com.kc.bw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class dexc implements dexb {
    public dexb dexa;

    public dexc(String str) {
        try {
            this.dexa = (dexb) Class.forName(str).newInstance();
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("Stringfog implementation class not found: " + str);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Stringfog implementation class access failed: " + e.getMessage());
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException("Stringfog implementation class new instance failed: " + e2.getMessage());
        }
    }

    @Override // com.kc.bw.dexb
    public String decrypt(String str, String str2) {
        dexb dexbVar = this.dexa;
        return dexbVar == null ? str : dexbVar.decrypt(str, str2);
    }

    @Override // com.kc.bw.dexb
    public String encrypt(String str, String str2) {
        dexb dexbVar = this.dexa;
        return dexbVar == null ? str : dexbVar.encrypt(str, str2);
    }

    @Override // com.kc.bw.dexb
    public boolean overflow(String str, String str2) {
        dexb dexbVar = this.dexa;
        return dexbVar != null && dexbVar.overflow(str, str2);
    }
}
