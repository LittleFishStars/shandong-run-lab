package cj.mobile.wm;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j3 implements r2 {
    public static final String dexn = "";
    public final String dexa;
    public final int dexb;
    public final int dexc;
    public final t2 dexd;
    public final t2 dexe;
    public final v2 dexf;
    public final u2 dexg;
    public final h7 dexh;
    public final q2 dexi;
    public final r2 dexj;
    public String dexk;
    public int dexl;
    public r2 dexm;

    public j3(String str, r2 r2Var, int i, int i2, t2 t2Var, t2 t2Var2, v2 v2Var, u2 u2Var, h7 h7Var, q2 q2Var) {
        this.dexa = str;
        this.dexj = r2Var;
        this.dexb = i;
        this.dexc = i2;
        this.dexd = t2Var;
        this.dexe = t2Var2;
        this.dexf = v2Var;
        this.dexg = u2Var;
        this.dexh = h7Var;
        this.dexi = q2Var;
    }

    public r2 dexa() {
        if (this.dexm == null) {
            this.dexm = new m3(this.dexa, this.dexj);
        }
        return this.dexm;
    }

    @Override // cj.mobile.wm.r2
    public void dexa(MessageDigest messageDigest) {
        byte[] bArrArray = ByteBuffer.allocate(8).putInt(this.dexb).putInt(this.dexc).array();
        this.dexj.dexa(messageDigest);
        messageDigest.update(this.dexa.getBytes("UTF-8"));
        messageDigest.update(bArrArray);
        t2 t2Var = this.dexd;
        messageDigest.update((t2Var != null ? t2Var.getId() : "").getBytes("UTF-8"));
        t2 t2Var2 = this.dexe;
        messageDigest.update((t2Var2 != null ? t2Var2.getId() : "").getBytes("UTF-8"));
        v2 v2Var = this.dexf;
        messageDigest.update((v2Var != null ? v2Var.getId() : "").getBytes("UTF-8"));
        u2 u2Var = this.dexg;
        messageDigest.update((u2Var != null ? u2Var.getId() : "").getBytes("UTF-8"));
        q2 q2Var = this.dexi;
        messageDigest.update((q2Var != null ? q2Var.getId() : "").getBytes("UTF-8"));
    }

    @Override // cj.mobile.wm.r2
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j3.class != obj.getClass()) {
            return false;
        }
        j3 j3Var = (j3) obj;
        if (!this.dexa.equals(j3Var.dexa) || !this.dexj.equals(j3Var.dexj) || this.dexc != j3Var.dexc || this.dexb != j3Var.dexb) {
            return false;
        }
        v2 v2Var = this.dexf;
        if ((v2Var == null) ^ (j3Var.dexf == null)) {
            return false;
        }
        if (v2Var != null && !v2Var.getId().equals(j3Var.dexf.getId())) {
            return false;
        }
        t2 t2Var = this.dexe;
        if ((t2Var == null) ^ (j3Var.dexe == null)) {
            return false;
        }
        if (t2Var != null && !t2Var.getId().equals(j3Var.dexe.getId())) {
            return false;
        }
        t2 t2Var2 = this.dexd;
        if ((t2Var2 == null) ^ (j3Var.dexd == null)) {
            return false;
        }
        if (t2Var2 != null && !t2Var2.getId().equals(j3Var.dexd.getId())) {
            return false;
        }
        u2 u2Var = this.dexg;
        if ((u2Var == null) ^ (j3Var.dexg == null)) {
            return false;
        }
        if (u2Var != null && !u2Var.getId().equals(j3Var.dexg.getId())) {
            return false;
        }
        h7 h7Var = this.dexh;
        if ((h7Var == null) ^ (j3Var.dexh == null)) {
            return false;
        }
        if (h7Var != null && !h7Var.getId().equals(j3Var.dexh.getId())) {
            return false;
        }
        q2 q2Var = this.dexi;
        if ((q2Var == null) ^ (j3Var.dexi == null)) {
            return false;
        }
        return q2Var == null || q2Var.getId().equals(j3Var.dexi.getId());
    }

    @Override // cj.mobile.wm.r2
    public int hashCode() {
        if (this.dexl == 0) {
            int iHashCode = this.dexa.hashCode();
            this.dexl = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.dexj.hashCode()) * 31) + this.dexb) * 31) + this.dexc;
            this.dexl = iHashCode2;
            int i = iHashCode2 * 31;
            t2 t2Var = this.dexd;
            int iHashCode3 = i + (t2Var != null ? t2Var.getId().hashCode() : 0);
            this.dexl = iHashCode3;
            int i2 = iHashCode3 * 31;
            t2 t2Var2 = this.dexe;
            int iHashCode4 = i2 + (t2Var2 != null ? t2Var2.getId().hashCode() : 0);
            this.dexl = iHashCode4;
            int i3 = iHashCode4 * 31;
            v2 v2Var = this.dexf;
            int iHashCode5 = i3 + (v2Var != null ? v2Var.getId().hashCode() : 0);
            this.dexl = iHashCode5;
            int i4 = iHashCode5 * 31;
            u2 u2Var = this.dexg;
            int iHashCode6 = i4 + (u2Var != null ? u2Var.getId().hashCode() : 0);
            this.dexl = iHashCode6;
            int i5 = iHashCode6 * 31;
            h7 h7Var = this.dexh;
            int iHashCode7 = i5 + (h7Var != null ? h7Var.getId().hashCode() : 0);
            this.dexl = iHashCode7;
            int i6 = iHashCode7 * 31;
            q2 q2Var = this.dexi;
            this.dexl = i6 + (q2Var != null ? q2Var.getId().hashCode() : 0);
        }
        return this.dexl;
    }

    public String toString() {
        if (this.dexk == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EngineKey{");
            sb.append(this.dexa);
            sb.append('+');
            sb.append(this.dexj);
            sb.append("+[");
            sb.append(this.dexb);
            sb.append('x');
            sb.append(this.dexc);
            sb.append("]+");
            sb.append('\'');
            t2 t2Var = this.dexd;
            sb.append(t2Var != null ? t2Var.getId() : dexn);
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            t2 t2Var2 = this.dexe;
            sb.append(t2Var2 != null ? t2Var2.getId() : dexn);
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            v2 v2Var = this.dexf;
            sb.append(v2Var != null ? v2Var.getId() : dexn);
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            u2 u2Var = this.dexg;
            sb.append(u2Var != null ? u2Var.getId() : dexn);
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            h7 h7Var = this.dexh;
            sb.append(h7Var != null ? h7Var.getId() : dexn);
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            q2 q2Var = this.dexi;
            sb.append(q2Var != null ? q2Var.getId() : dexn);
            sb.append('\'');
            sb.append('}');
            this.dexk = sb.toString();
        }
        return this.dexk;
    }
}
