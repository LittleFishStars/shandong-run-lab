package com.huachenjie.common.util;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CountDownTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f33903a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f8888a;
    public long b;
    public long c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f8890a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f8891b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f8889a = new a();

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            long j;
            synchronized (CountDownTask.this) {
                if (!CountDownTask.this.f8890a && !CountDownTask.this.f8891b) {
                    CountDownTask countDownTask = CountDownTask.this;
                    countDownTask.b = countDownTask.c - SystemClock.elapsedRealtime();
                    long j2 = 0;
                    if (CountDownTask.this.b <= 0) {
                        CountDownTask.this.h();
                    } else {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        CountDownTask countDownTask2 = CountDownTask.this;
                        countDownTask2.i(countDownTask2.b);
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        if (CountDownTask.this.b < CountDownTask.this.f8888a) {
                            j = CountDownTask.this.b - jElapsedRealtime2;
                            if (j < 0) {
                            }
                            sendMessageDelayed(obtainMessage(1), j2);
                        } else {
                            j = CountDownTask.this.f8888a - jElapsedRealtime2;
                            while (j < 0) {
                                j += CountDownTask.this.f8888a;
                            }
                        }
                        j2 = j;
                        sendMessageDelayed(obtainMessage(1), j2);
                    }
                }
            }
        }
    }

    public CountDownTask(long millisInFuture, long countDownInterval) {
        this.f8888a = countDownInterval;
        this.b = millisInFuture;
    }

    public final synchronized void g() {
        this.f8890a = true;
        this.b = 0L;
        this.f8889a.removeMessages(1);
    }

    public abstract void h();

    public abstract void i(long millisUntilFinished);

    public final synchronized void j() {
        this.f8891b = true;
        this.f8889a.removeMessages(1);
    }

    public final synchronized CountDownTask k() {
        this.f8890a = false;
        if (this.b <= 0) {
            h();
            return this;
        }
        if (this.f8891b) {
            this.f8891b = false;
        }
        this.c = SystemClock.elapsedRealtime() + this.b;
        Handler handler = this.f8889a;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
