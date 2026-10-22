package com.google.android.exoplayer2.drm;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.MediaSource;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface DrmSessionEventListener {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30595a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final MediaSource.a f2667a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final CopyOnWriteArrayList<C0677a> f2668a;

        /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DrmSessionEventListener$a$a, reason: collision with other inner class name */
        public static final class C0677a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f30596a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public DrmSessionEventListener f2669a;

            public C0677a(Handler handler, DrmSessionEventListener drmSessionEventListener) {
                this.f30596a = handler;
                this.f2669a = drmSessionEventListener;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.o(this.f30595a, this.f2667a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.O(this.f30595a, this.f2667a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.I(this.f30595a, this.f2667a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(DrmSessionEventListener drmSessionEventListener, int i) {
            drmSessionEventListener.D(this.f30595a, this.f2667a);
            drmSessionEventListener.v(this.f30595a, this.f2667a, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(DrmSessionEventListener drmSessionEventListener, Exception exc) {
            drmSessionEventListener.n(this.f30595a, this.f2667a, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.k(this.f30595a, this.f2667a);
        }

        public void g(Handler handler, DrmSessionEventListener drmSessionEventListener) {
            sb0.g(handler);
            sb0.g(drmSessionEventListener);
            this.f2668a.add(new C0677a(handler, drmSessionEventListener));
        }

        public void h() {
            for (C0677a c0677a : this.f2668a) {
                final DrmSessionEventListener drmSessionEventListener = c0677a.f2669a;
                gj9.j1(c0677a.f30596a, new Runnable() { // from class: com.zj.adlib.bs2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f40829a.n(drmSessionEventListener);
                    }
                });
            }
        }

        public void i() {
            for (C0677a c0677a : this.f2668a) {
                final DrmSessionEventListener drmSessionEventListener = c0677a.f2669a;
                gj9.j1(c0677a.f30596a, new Runnable() { // from class: com.zj.adlib.zr2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f46327a.o(drmSessionEventListener);
                    }
                });
            }
        }

        public void j() {
            for (C0677a c0677a : this.f2668a) {
                final DrmSessionEventListener drmSessionEventListener = c0677a.f2669a;
                gj9.j1(c0677a.f30596a, new Runnable() { // from class: com.zj.adlib.ds2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f41267a.p(drmSessionEventListener);
                    }
                });
            }
        }

        public void k(final int i) {
            for (C0677a c0677a : this.f2668a) {
                final DrmSessionEventListener drmSessionEventListener = c0677a.f2669a;
                gj9.j1(c0677a.f30596a, new Runnable() { // from class: com.zj.adlib.xr2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f45883a.q(drmSessionEventListener, i);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            for (C0677a c0677a : this.f2668a) {
                final DrmSessionEventListener drmSessionEventListener = c0677a.f2669a;
                gj9.j1(c0677a.f30596a, new Runnable() { // from class: com.zj.adlib.vr2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f45426a.r(drmSessionEventListener, exc);
                    }
                });
            }
        }

        public void m() {
            for (C0677a c0677a : this.f2668a) {
                final DrmSessionEventListener drmSessionEventListener = c0677a.f2669a;
                gj9.j1(c0677a.f30596a, new Runnable() { // from class: com.zj.adlib.tr2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f44991a.s(drmSessionEventListener);
                    }
                });
            }
        }

        public void t(DrmSessionEventListener drmSessionEventListener) {
            for (C0677a c0677a : this.f2668a) {
                if (c0677a.f2669a == drmSessionEventListener) {
                    this.f2668a.remove(c0677a);
                }
            }
        }

        @CheckResult
        public a u(int i, @Nullable MediaSource.a aVar) {
            return new a(this.f2668a, i, aVar);
        }

        public a(CopyOnWriteArrayList<C0677a> copyOnWriteArrayList, int i, @Nullable MediaSource.a aVar) {
            this.f2668a = copyOnWriteArrayList;
            this.f30595a = i;
            this.f2667a = aVar;
        }
    }

    @Deprecated
    default void D(int i, @Nullable MediaSource.a aVar) {
    }

    default void I(int i, @Nullable MediaSource.a aVar) {
    }

    default void O(int i, @Nullable MediaSource.a aVar) {
    }

    default void k(int i, @Nullable MediaSource.a aVar) {
    }

    default void n(int i, @Nullable MediaSource.a aVar, Exception exc) {
    }

    default void o(int i, @Nullable MediaSource.a aVar) {
    }

    default void v(int i, @Nullable MediaSource.a aVar, int i2) {
    }
}
