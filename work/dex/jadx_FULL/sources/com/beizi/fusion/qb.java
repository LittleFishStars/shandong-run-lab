package com.beizi.fusion;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f27686a = new a();
    protected final long b;

    public qb(long j) {
        this.b = j;
    }

    public void a() {
        a aVar = this.f27686a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public abstract void b();

    public void c() {
        a aVar = this.f27686a;
        if (aVar != null) {
            aVar.a(this.b);
        }
    }

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Timer f27687a;
        private TimerTask b;

        /* JADX INFO: renamed from: com.beizi.fusion.qb$a$a, reason: collision with other inner class name */
        public class C0319a extends TimerTask {
            public C0319a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                qb.this.b();
            }
        }

        private a() {
        }

        private void b() {
            a();
            this.f27687a = new Timer();
            this.b = new C0319a();
        }

        public synchronized void a() {
            TimerTask timerTask = this.b;
            if (timerTask != null) {
                timerTask.cancel();
            }
            Timer timer = this.f27687a;
            if (timer != null) {
                timer.cancel();
                this.f27687a.purge();
            }
            this.f27687a = null;
            this.b = null;
        }

        public void a(long j) {
            b();
            Timer timer = this.f27687a;
            if (timer != null) {
                timer.schedule(this.b, j);
            }
        }
    }
}
