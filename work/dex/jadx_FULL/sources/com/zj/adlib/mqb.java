package com.zj.adlib;

import cn.hzjizhun.admin.cn_oaid.OAIDException;
import cn.hzjizhun.admin.ddakd;
import cn.hzjizhun.admin.sdkdda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class mqb implements sdkdda {
    @Override // cn.hzjizhun.admin.sdkdda
    public boolean a() {
        return false;
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public void b(ddakd ddakdVar) {
        if (ddakdVar == null) {
            return;
        }
        ddakdVar.b(new OAIDException("Unsupported"));
    }
}
