package com.byazt.u;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 67, 46})
public final class n implements Handler.Callback {
    public volatile Handler c = new Handler(c.c, this);

    @com.byazt.zqa.c(c = {0, 1, 67, 151})
    public static class c {
        public static final Looper c;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            c = handlerThread.getLooper();
        }
    }

    public interface tt {
        long c();
    }

    public static Looper c() {
        return c.c;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            tt ttVar = (tt) message.obj;
            long jC = ttVar.c();
            if (jC <= 0) {
                return true;
            }
            c(ttVar, jC);
            return true;
        } catch (Throwable th) {
            m.c(th);
            return true;
        }
    }

    public void tt() {
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        this.c = null;
        handler.removeCallbacksAndMessages(null);
    }

    public void c(tt ttVar, long j) {
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = ttVar;
        handler.sendMessageDelayed(messageObtain, j);
    }
}
