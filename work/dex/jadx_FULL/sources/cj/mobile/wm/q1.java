package cj.mobile.wm;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class q1 extends Handler {
    public final WeakReference<dexa> dexa;

    public interface dexa {
        void handleMessage(Message message);
    }

    public q1(dexa dexaVar) {
        this.dexa = new WeakReference<>(dexaVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        dexa dexaVar = this.dexa.get();
        if (dexaVar != null) {
            dexaVar.handleMessage(message);
        }
    }
}
