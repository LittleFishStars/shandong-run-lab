package com.zj.adlib;

import cn.hzjizhun.admin.base.ad.RcSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class lha implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        if (RcSdk.f281a) {
            return;
        }
        RcSdk.f281a = true;
        rzb.a().f();
    }
}
