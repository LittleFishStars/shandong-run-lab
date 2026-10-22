package com.byazt.but;

import android.os.Looper;
import android.os.Message;
import com.byazt.dna.qp;
import com.byazt.nr.d;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 672, 13})
public class tt implements qp.c {
    public c tt;
    public AtomicBoolean ve = new AtomicBoolean(true);
    public final d c = new d(Looper.getMainLooper(), this);
    public int uj = 5;
    public int n = 1;

    public interface c {
        void c();

        void c(int i);
    }

    private void a() {
        try {
            int i = this.n;
            if (i >= this.uj + 1) {
                c cVar = this.tt;
                if (cVar != null) {
                    cVar.c();
                    return;
                }
                return;
            }
            int i2 = i + 1;
            this.n = i2;
            c cVar2 = this.tt;
            if (cVar2 != null) {
                cVar2.c(i2);
            }
            this.c.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception unused) {
        }
    }

    private void n() {
        try {
            this.c.sendEmptyMessage(1);
        } catch (Throwable unused) {
        }
    }

    private void uj() {
        try {
            this.c.removeMessages(1);
        } catch (Throwable unused) {
        }
    }

    private void ve() {
        this.c.removeMessages(1);
        this.n = 1;
    }

    public void c() {
        ve();
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message.what == 1) {
            a();
        }
    }

    public void tt() {
        ve();
        this.c.sendEmptyMessage(1);
    }

    public void c(boolean z) {
        this.ve.set(z);
        if (this.ve.get()) {
            n();
        } else {
            uj();
        }
    }

    public void c(c cVar) {
        this.tt = cVar;
    }

    public void c(int i) {
        this.uj = i;
        ve();
    }
}
