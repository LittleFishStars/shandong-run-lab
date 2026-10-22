package com.kc.cw.ad.b;

import com.kc.cw.ad.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Timer f38715a;
    private long b;
    private long c;
    private long d;
    private b e;
    private c f = c.FINISH;

    /* JADX INFO: renamed from: com.kc.cw.ad.b.a$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f38717a;
        private long b = -1;

        public AnonymousClass2(a aVar) {
            this.f38717a = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.b < 0) {
                this.b = scheduledExecutionTime() - (this.f38717a.b - this.f38717a.d);
                ThreadUtils.runOnUIThread(new Runnable(this) { // from class: com.kc.cw.ad.b.a.2.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final AnonymousClass2 f38718a;

                    {
                        this.f38718a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (this.f38718a.f38717a.e != null) {
                            this.f38718a.f38717a.e.a(this.f38718a.f38717a.d);
                        }
                    }
                });
                return;
            }
            a aVar = this.f38717a;
            aVar.d = aVar.b - (scheduledExecutionTime() - this.b);
            ThreadUtils.runOnUIThread(new Runnable(this) { // from class: com.kc.cw.ad.b.a.2.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final AnonymousClass2 f38719a;

                {
                    this.f38719a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f38719a.f38717a.e != null) {
                        this.f38719a.f38717a.e.a(this.f38719a.f38717a.d);
                    }
                }
            });
            if (this.f38717a.d <= 0) {
                this.f38717a.a(false);
            }
        }
    }

    public a(long j, long j2) {
        a(j);
        b(j2);
    }

    private void a(long j) {
        this.b = j;
        this.d = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f38715a != null) {
            h();
            this.f = c.FINISH;
            ThreadUtils.runOnUIThread(new Runnable(this, z) { // from class: com.kc.cw.ad.b.a.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final boolean f38716a;
                final a b;

                {
                    this.b = this;
                    this.f38716a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.b.e != null) {
                        if (this.f38716a) {
                            this.b.e.b();
                        } else {
                            this.b.e.a();
                        }
                    }
                }
            });
        }
    }

    private void b(long j) {
        this.c = j;
    }

    private void h() {
        Timer timer = this.f38715a;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = this.f38715a;
        if (timer2 != null) {
            timer2.purge();
        }
        this.f38715a = null;
    }

    public void a() {
        if (this.f38715a == null) {
            c cVar = this.f;
            c cVar2 = c.START;
            if (cVar != cVar2) {
                Timer timer = new Timer();
                this.f38715a = timer;
                timer.schedule(g(), 0L, this.c);
                this.f = cVar2;
            }
        }
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void b() {
        if (this.f38715a == null || this.f != c.START) {
            return;
        }
        h();
        this.f = c.PAUSE;
    }

    public void c() {
        if (this.f == c.PAUSE) {
            a();
        }
    }

    public void d() {
        a(true);
    }

    public void e() {
        if (this.f38715a != null) {
            h();
        }
        this.d = this.b;
        this.f = c.FINISH;
    }

    public boolean f() {
        return this.f == c.START;
    }

    public TimerTask g() {
        return new AnonymousClass2(this);
    }
}
