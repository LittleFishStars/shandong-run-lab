package com.byazt.ymw;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.omf.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 462, 13})
public class tt extends t.c {
    public Handler c = new Handler(Looper.getMainLooper());
    public com.byazt.aas.a.c tt;

    public tt(com.byazt.aas.a.c cVar) {
        this.tt = cVar;
    }

    @Override // com.byazt.omf.t
    public void c() throws RemoteException {
        c(new Runnable() { // from class: com.byazt.ymw.tt.1
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.tt != null) {
                    tt.this.tt.c();
                }
            }
        });
    }

    @Override // com.byazt.omf.t
    public void c(final String str) throws RemoteException {
        c(new Runnable() { // from class: com.byazt.ymw.tt.2
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.tt != null) {
                    tt.this.tt.c(str);
                }
            }
        });
    }

    private void c(Runnable runnable) {
        if (this.c == null) {
            this.c = new Handler(Looper.getMainLooper());
        }
        this.c.post(runnable);
    }
}
