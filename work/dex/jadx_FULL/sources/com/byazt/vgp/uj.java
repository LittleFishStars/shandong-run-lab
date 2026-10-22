package com.byazt.vgp;

import com.byazt.omf.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1713, 15})
public class uj extends com.byazt.zb.c {
    private com.byazt.zb.uj n() {
        String strSp = com.byazt.fh.c.sp();
        strSp.hashCode();
        switch (strSp) {
            case "2g":
                return com.byazt.zb.uj.TYPE_2G;
            case "3g":
                return com.byazt.zb.uj.TYPE_3G;
            case "4g":
                return com.byazt.zb.uj.TYPE_4G;
            case "5g":
                return com.byazt.zb.uj.TYPE_5G;
            case "wifi":
                return com.byazt.zb.uj.TYPE_WIFI;
            default:
                return com.byazt.zb.uj.TYPE_UNKNOWN;
        }
    }

    @Override // com.byazt.zb.c
    public boolean tt() {
        return x.m().uj();
    }

    @Override // com.byazt.zb.c
    public com.byazt.zb.uj uj() {
        return n();
    }

    @Override // com.byazt.zb.c
    public boolean ve() {
        return super.ve();
    }
}
