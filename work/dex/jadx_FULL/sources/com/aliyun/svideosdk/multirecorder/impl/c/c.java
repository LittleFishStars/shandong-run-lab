package com.aliyun.svideosdk.multirecorder.impl.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {
    private static int i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile EnumC0236c f25797a;
    private long b;
    private boolean c;
    private Object d;
    private HandlerThread e;
    private Handler f;
    private int g;
    private b h;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 101) {
                return;
            }
            c.this.b();
        }
    }

    public interface b {
        void g();
    }

    /* JADX INFO: renamed from: com.aliyun.svideosdk.multirecorder.impl.c.c$c, reason: collision with other inner class name */
    public enum EnumC0236c {
        START,
        STOP,
        DESTROY
    }

    public c(int i2, b bVar) {
        this.f25797a = EnumC0236c.STOP;
        this.b = 33L;
        this.c = false;
        this.d = new Object();
        this.g = i2;
        this.h = bVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(b bVar) {
        int i2 = i + 1;
        i = i2;
        this(i2, bVar);
    }

    private void a(EnumC0236c enumC0236c) {
        this.f25797a = enumC0236c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f25797a != EnumC0236c.START) {
            return;
        }
        b bVar = this.h;
        if (bVar != null) {
            bVar.g();
        }
        synchronized (this.d) {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeMessages(101);
                this.f.sendEmptyMessageDelayed(101, this.b);
            }
        }
    }

    private void c() {
        if (this.c) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("CaptureTimer_" + this.g);
        this.e = handlerThread;
        handlerThread.start();
        this.f = new a(this.e.getLooper());
    }

    public synchronized void a() {
        EnumC0236c enumC0236c = this.f25797a;
        EnumC0236c enumC0236c2 = EnumC0236c.DESTROY;
        if (enumC0236c == enumC0236c2) {
            return;
        }
        d();
        a(enumC0236c2);
        if (this.c) {
            synchronized (this.d) {
                try {
                    this.e.interrupt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.e = null;
                this.f = null;
            }
        }
    }

    public void a(int i2) {
        if (i2 <= 0) {
            throw new RuntimeException("Fps should be greater than 0");
        }
        this.b = (long) (1000.0f / i2);
    }

    public synchronized void a(boolean z) {
        c();
        if (this.f25797a != EnumC0236c.STOP) {
            return;
        }
        a(EnumC0236c.START);
        if (z) {
            this.f.sendEmptyMessage(101);
        } else {
            this.f.sendEmptyMessageDelayed(101, this.b);
        }
    }

    public synchronized void d() {
        if (this.f25797a != EnumC0236c.START) {
            return;
        }
        a(EnumC0236c.STOP);
        this.f.removeMessages(101);
    }
}
