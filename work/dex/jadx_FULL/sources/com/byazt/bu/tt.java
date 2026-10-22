package com.byazt.bu;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byazt.dna.qp;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 68, 13})
public class tt extends Handler implements ve {
    public WeakReference<qp.c> c;
    public Looper tt;

    public tt(Looper looper, qp.c cVar) {
        super(looper);
        this.tt = looper;
        if (cVar != null) {
            this.c = new WeakReference<>(cVar);
        }
    }

    @Override // com.byazt.bu.ve
    public void c() {
        removeCallbacksAndMessages(null);
        WeakReference<qp.c> weakReference = this.c;
        if (weakReference != null) {
            weakReference.clear();
            this.c = null;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        qp.c cVar;
        WeakReference<qp.c> weakReference = this.c;
        if (weakReference == null || (cVar = weakReference.get()) == null || message == null) {
            return;
        }
        cVar.handleMsg(message);
    }

    public void tt() {
        Looper looper = this.tt;
        if (looper != null) {
            looper.quit();
            this.tt = null;
        }
    }

    public void c(qp.c cVar) {
        this.c = new WeakReference<>(cVar);
    }
}
