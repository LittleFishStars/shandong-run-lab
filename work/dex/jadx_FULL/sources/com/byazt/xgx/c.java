package com.byazt.xgx;

import com.byazt.omf.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1109, 20})
public class c {
    public Boolean c = null;
    public Boolean tt = null;
    public Boolean ve = null;

    public boolean c() {
        if (this.c == null) {
            com.byazt.dj.uj ujVarNu = x.m().nu();
            this.c = Boolean.valueOf(ujVarNu == null || ujVarNu.isCanUsePhoneState());
        }
        return this.c.booleanValue();
    }

    public boolean tt() {
        if (this.tt == null) {
            com.byazt.dj.uj ujVarNu = x.m().nu();
            this.tt = Boolean.valueOf(ujVarNu == null || ujVarNu.isCanUseWifiState());
        }
        return this.tt.booleanValue();
    }

    public boolean ve() {
        if (this.ve == null) {
            com.byazt.dj.uj ujVarNu = x.m().nu();
            this.ve = Boolean.valueOf(ujVarNu == null || ujVarNu.isCanUseLocation());
        }
        return this.ve.booleanValue();
    }
}
