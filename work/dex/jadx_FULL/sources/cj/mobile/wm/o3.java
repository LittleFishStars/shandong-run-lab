package cj.mobile.wm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o3 {
    public boolean dexa;
    public final Handler dexb = new Handler(Looper.getMainLooper(), new dexb());

    public static class dexb implements Handler.Callback {
        public dexb() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((n3) message.obj).b();
            return true;
        }
    }

    public void dexa(n3<?> n3Var) {
        e9.dexa();
        if (this.dexa) {
            this.dexb.obtainMessage(1, n3Var).sendToTarget();
            return;
        }
        this.dexa = true;
        n3Var.b();
        this.dexa = false;
    }
}
