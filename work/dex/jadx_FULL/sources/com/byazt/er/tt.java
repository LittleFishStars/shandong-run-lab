package com.byazt.er;

import android.os.RemoteException;
import com.byazt.uk.uj;
import com.byazt.uk.yp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 964, 13})
public class tt extends uj.c {
    public final yp c;

    public tt(yp ypVar) {
        this.c = ypVar;
    }

    @Override // com.byazt.uk.uj
    public void c(String str, int i, String str2) throws RemoteException {
        yp ypVar = this.c;
        if (ypVar != null) {
            ypVar.c(str, i, str2);
        }
    }
}
