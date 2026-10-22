package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class p extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f26317a;
    private Object b;
    private boolean c;

    public p() {
        this.f26317a = null;
        this.b = new Object();
        this.c = false;
    }

    public p(String str) {
        super(str);
        this.f26317a = null;
        this.b = new Object();
        this.c = false;
    }

    public void a() {
        if (b.f26304a) {
            b.a("Looper thread quit()");
        }
        Handler handler = this.f26317a;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        this.f26317a.getLooper().quit();
    }

    public void b() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    this.b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.b) {
            this.c = true;
            this.b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f26317a = new Handler();
        if (b.f26304a) {
            b.a("new Handler() finish!!");
        }
        Looper.loop();
        if (b.f26304a) {
            b.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
