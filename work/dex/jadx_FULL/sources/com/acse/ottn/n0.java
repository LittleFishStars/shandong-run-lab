package com.acse.ottn;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static n0 f23092a;

    public class a extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f23093a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, long j2, d dVar) {
            super(j, j2);
            this.f23093a = dVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f23093a.a();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            this.f23093a.a(j);
        }
    }

    public class b extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f23094a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ d d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.d.a();
            }
        }

        /* JADX INFO: renamed from: com.acse.ottn.n0$b$b, reason: collision with other inner class name */
        public class RunnableC0110b implements Runnable {
            public RunnableC0110b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.d.a(bVar.c - bVar.f23094a[0]);
            }
        }

        public b(int[] iArr, int i, int i2, d dVar) {
            this.f23094a = iArr;
            this.b = i;
            this.c = i2;
            this.d = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (l0.j) {
                cancel();
            } else {
                l0.j = false;
            }
            int[] iArr = this.f23094a;
            int i = iArr[0] + this.b;
            iArr[0] = i;
            if (i < this.c) {
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0110b(), 0L);
            } else {
                cancel();
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
            }
        }
    }

    public class c extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f23097a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ d d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.d.a();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.d.a(cVar.c - cVar.f23097a[0]);
            }
        }

        public c(int[] iArr, int i, int i2, d dVar) {
            this.f23097a = iArr;
            this.b = i;
            this.c = i2;
            this.d = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int[] iArr = this.f23097a;
            int i = iArr[0] + this.b;
            iArr[0] = i;
            if (i < this.c) {
                new Handler(Looper.getMainLooper()).postDelayed(new b(), 0L);
            } else {
                cancel();
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
            }
        }
    }

    public interface d {
        void a();

        void a(long j);
    }

    public static n0 a() {
        if (f23092a == null) {
            synchronized (n0.class) {
                if (f23092a == null) {
                    f23092a = new n0();
                }
            }
        }
        return f23092a;
    }

    public TimerTask b(int i, int i2, d dVar) {
        l0.j = false;
        b bVar = new b(new int[]{0}, i2, i, dVar);
        new Timer().scheduleAtFixedRate(bVar, 0L, i2);
        return bVar;
    }

    public Timer c(int i, int i2, d dVar) {
        c cVar = new c(new int[]{0}, i2, i, dVar);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(cVar, 0L, i2);
        return timer;
    }

    public CountDownTimer a(int i, int i2, d dVar) {
        return new a(i, i2, dVar);
    }
}
