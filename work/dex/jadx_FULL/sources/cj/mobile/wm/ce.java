package cj.mobile.wm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class ce {
    public final long dexa;
    public final long dexb;
    public long dexc;
    public long dexe;
    public volatile int dexd = 0;

    @SuppressLint({"HandlerLeak"})
    public final Handler dexf = new dexa();

    public class dexa extends Handler {
        public dexa() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j;
            synchronized (ce.this) {
                if (ce.this.dexd == 3) {
                    return;
                }
                if (ce.this.dexd == 2) {
                    return;
                }
                long jElapsedRealtime = ce.this.dexc - SystemClock.elapsedRealtime();
                long j2 = 0;
                if (jElapsedRealtime <= 0) {
                    ce.this.dexg();
                } else {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    ce.this.dexa(jElapsedRealtime);
                    long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    if (jElapsedRealtime < ce.this.dexb) {
                        j = jElapsedRealtime - jElapsedRealtime3;
                        if (j < 0) {
                        }
                        sendMessageDelayed(obtainMessage(1), j2);
                    } else {
                        j = ce.this.dexb - jElapsedRealtime3;
                        while (j < 0) {
                            j += ce.this.dexb;
                        }
                    }
                    j2 = j;
                    sendMessageDelayed(obtainMessage(1), j2);
                }
            }
        }
    }

    public ce(long j, long j2) {
        this.dexa = j;
        this.dexb = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexg() {
        this.dexd = 4;
        dexc();
    }

    public final synchronized void dexa() {
        this.dexd = 3;
        this.dexf.removeMessages(1);
        f1.dexa("myTimer cancel:", this.dexe + "");
    }

    public abstract void dexa(long j);

    public boolean dexb() {
        return this.dexd == 2;
    }

    public abstract void dexc();

    public final synchronized void dexd() {
        if (this.dexd == 1) {
            this.dexd = 2;
            this.dexe = this.dexc - SystemClock.elapsedRealtime();
            this.dexf.removeMessages(1);
            f1.dexa("CountDownTimer", "myTimer pause:" + this.dexe);
        }
    }

    public final synchronized ce dexe() {
        if (this.dexd == 2) {
            this.dexd = 1;
            if (this.dexe <= 0) {
                dexg();
                return this;
            }
            this.dexc = SystemClock.elapsedRealtime() + this.dexe;
            Handler handler = this.dexf;
            handler.sendMessage(handler.obtainMessage(1));
            f1.dexa("myTimer resume:", this.dexc + "");
        }
        return this;
    }

    public final synchronized ce dexf() {
        if (this.dexd == 0) {
            this.dexd = 1;
            if (this.dexa <= 0) {
                dexg();
                return this;
            }
            this.dexc = SystemClock.elapsedRealtime() + this.dexa;
            Handler handler = this.dexf;
            handler.sendMessage(handler.obtainMessage(1));
            f1.dexa("myTimer start:", this.dexc + "");
        }
        return this;
    }
}
