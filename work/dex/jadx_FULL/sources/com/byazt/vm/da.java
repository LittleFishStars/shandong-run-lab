package com.byazt.vm;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 72})
public class da extends com.byazt.kbg.c.AbstractBinderC0447c {
    public volatile String c = "";

    @Override // com.byazt.kbg.c
    public void c(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
    }

    @Override // com.byazt.kbg.c
    public void c(int i, Bundle bundle) throws RemoteException {
        if (i != 0 || bundle == null) {
            return;
        }
        this.c = bundle.getString("oa_id_flag");
    }

    public String c() {
        return this.c;
    }
}
