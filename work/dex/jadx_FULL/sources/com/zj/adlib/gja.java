package com.zj.adlib;

import com.bwt.top.cn_oaid.OAIDException;
import com.bwt.top.cn_oaid.ddksa;
import com.bwt.top.cn_oaid.dkkd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class gja implements dkkd {
    @Override // com.bwt.top.cn_oaid.dkkd
    public boolean a() {
        return false;
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public void b(ddksa ddksaVar) {
        if (ddksaVar == null) {
            return;
        }
        ddksaVar.b(new OAIDException("Unsupported"));
    }
}
