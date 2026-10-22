package cj.mobile.wm;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h9 {
    public int dexa = 0;
    public String dexb;
    public int dexc;
    public boolean dexd;
    public List<String> dexe;
    public String dexf;

    public h9(int i) {
        this.dexc = i;
    }

    public String dexa() {
        return this.dexf;
    }

    public void dexa(String str) {
        this.dexf = str;
    }

    public String toString() {
        return "AdNetResponse{mErrorCode=" + this.dexa + ", mErrorMsg='" + this.dexb + "', mResponseCode=" + this.dexc + ", mCallSucceed=" + this.dexd + ", mCookies=" + this.dexe + '}';
    }
}
