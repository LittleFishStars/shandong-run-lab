package com.byazt.sw;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.byazt.nr.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 868, 54})
public class ve implements Handler.Callback {
    public Handler c;

    @com.byazt.zqa.c(c = {0, 1, 868, 24})
    public static class c {
        public static final ve c = new ve();
    }

    public static ve c() {
        return c.c;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        ((Runnable) message.obj).run();
        return false;
    }

    private ve() {
        this.c = new Handler(da.c().getLooper(), this);
    }

    public void c(Runnable runnable) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = runnable;
        this.c.sendMessage(messageObtain);
    }

    public void c(Runnable runnable, long j) {
        this.c.postDelayed(runnable, j);
    }
}
