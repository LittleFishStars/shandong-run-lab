package com.byazt.hu;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1381, 215})
public class yp extends Handler {
    public WeakReference<c> c;

    public interface c {
        void c(Message message);
    }

    public yp(Looper looper, c cVar) {
        super(looper);
        this.c = new WeakReference<>(cVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        c cVar = this.c.get();
        if (cVar == null || message == null) {
            return;
        }
        cVar.c(message);
    }
}
