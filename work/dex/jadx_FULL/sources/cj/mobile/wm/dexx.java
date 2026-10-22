package cj.mobile.wm;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dexx {
    public String dexa;
    public String dexb;
    public String dexc;
    public String dexd;
    public String dexe;
    public String dexf;
    public int dexg;
    public int dexh;
    public int dexi;
    public int dexj;
    public String dexk;
    public String dexl;
    public String dexm;
    public String dexn;
    public String dexo;
    public String dexp;

    public String dexa() {
        return this.dexa;
    }

    public void dexa(int i) {
        this.dexh = i;
    }

    public void dexa(String str) {
        this.dexa = str;
    }

    public String dexb() {
        return this.dexl;
    }

    public void dexb(int i) {
        this.dexg = i;
    }

    public void dexb(String str) {
        this.dexl = str;
    }

    public String dexc() {
        return this.dexn;
    }

    public void dexc(int i) {
        this.dexj = i;
    }

    public void dexc(String str) {
        this.dexn = str;
    }

    public int dexd() {
        return this.dexh;
    }

    public void dexd(int i) {
        this.dexi = i;
    }

    public void dexd(String str) {
        this.dexk = str;
    }

    public int dexe() {
        return this.dexg;
    }

    public void dexe(String str) {
        this.dexm = str;
    }

    public int dexf() {
        return this.dexj;
    }

    public void dexf(String str) {
        this.dexf = str;
    }

    public String dexg() {
        return this.dexk;
    }

    public void dexg(String str) {
        this.dexb = str;
    }

    public String dexh() {
        return this.dexm;
    }

    public void dexh(String str) {
        this.dexc = str;
    }

    public String dexi() {
        return this.dexf;
    }

    public void dexi(String str) {
        this.dexd = str;
    }

    public String dexj() {
        return this.dexb;
    }

    public void dexj(String str) {
        this.dexe = str;
    }

    public String dexk() {
        return this.dexc;
    }

    public void dexk(String str) {
        this.dexp = str;
    }

    public String dexl() {
        return this.dexd;
    }

    public void dexl(String str) {
        this.dexo = str;
    }

    public String dexm() {
        if (!TextUtils.isEmpty(this.dexe)) {
            return this.dexe;
        }
        String strDexb = je.dexb("sp_user_agent", "Android");
        return TextUtils.isEmpty(strDexb) ? "Android" : strDexb;
    }

    public String dexn() {
        return this.dexp;
    }

    public String dexo() {
        return this.dexo;
    }

    public int dexp() {
        return this.dexi;
    }
}
