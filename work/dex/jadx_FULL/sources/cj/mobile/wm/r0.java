package cj.mobile.wm;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r0 {
    public String dexa;
    public String dexb;
    public String dexc;
    public String dexd;
    public int dexf;
    public String dexh;
    public float dexi;
    public String dexj;
    public String dexk;
    public long dexl;
    public long dexg = -1;
    public int dexe = -1;

    public String dexa() {
        return this.dexh;
    }

    public void dexa(float f) {
        this.dexi = f;
    }

    public void dexa(int i) {
        this.dexf = this.dexe;
        this.dexe = i;
    }

    public void dexa(long j) {
        this.dexg = j;
    }

    public void dexa(String str) {
        this.dexd = str;
    }

    public long dexb() {
        return this.dexg;
    }

    public void dexb(long j) {
        this.dexl = j;
    }

    public void dexb(String str) {
        this.dexh = str;
    }

    public float dexc() {
        return this.dexi;
    }

    public void dexc(String str) {
        this.dexj = str;
    }

    public r0 dexd(String str) {
        this.dexa = str;
        this.dexb = ke.dexa(str);
        return this;
    }

    public String dexd() {
        return this.dexj;
    }

    public String dexe() {
        return this.dexa;
    }

    public void dexe(String str) {
        this.dexc = str;
    }

    public String dexf() {
        return this.dexb;
    }

    public String dexg() {
        if (TextUtils.isEmpty(this.dexk)) {
            this.dexk = ge.dexa(this.dexa);
        }
        return this.dexk + ".apk";
    }

    public String dexh() {
        return this.dexc;
    }

    public long dexi() {
        return this.dexl;
    }

    public int dexj() {
        return this.dexe;
    }

    public String toString() {
        return "{DownloadAppInfo: packageName = " + this.dexc + ",url = " + this.dexa + ", state = " + this.dexe + "}";
    }
}
