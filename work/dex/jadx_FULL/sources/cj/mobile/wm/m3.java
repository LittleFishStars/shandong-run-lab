package cj.mobile.wm;

import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m3 implements r2 {
    public final String dexa;
    public final r2 dexb;

    public m3(String str, r2 r2Var) {
        this.dexa = str;
        this.dexb = r2Var;
    }

    @Override // cj.mobile.wm.r2
    public void dexa(MessageDigest messageDigest) {
        messageDigest.update(this.dexa.getBytes("UTF-8"));
        this.dexb.dexa(messageDigest);
    }

    @Override // cj.mobile.wm.r2
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m3.class != obj.getClass()) {
            return false;
        }
        m3 m3Var = (m3) obj;
        return this.dexa.equals(m3Var.dexa) && this.dexb.equals(m3Var.dexb);
    }

    @Override // cj.mobile.wm.r2
    public int hashCode() {
        return (this.dexa.hashCode() * 31) + this.dexb.hashCode();
    }
}
