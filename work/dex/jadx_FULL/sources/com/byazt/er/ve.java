package com.byazt.er;

import android.os.RemoteException;
import com.byazt.uk.uj;
import com.bytedance.pangle.ZeusPluginStateListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 964, 54})
public class ve extends ZeusPluginStateListener {
    public final uj c;
    public final int tt;

    public ve(uj ujVar, int i) {
        this.c = ujVar;
        this.tt = i;
    }

    public int c() {
        return this.tt;
    }

    @Override // com.bytedance.pangle.ZeusPluginStateListener
    public void onStateChangeOnCurThread(String str, int i, Object... objArr) {
        if (i == 5 || i == 7 || i == 6) {
            String strValueOf = "";
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        strValueOf = String.valueOf(objArr[0]);
                    }
                } catch (RemoteException unused) {
                    return;
                }
            }
            this.c.c(str, i, strValueOf);
        }
    }
}
