package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.zj.adlib.az4;
import com.zj.adlib.gj9;
import com.zj.adlib.oh5;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface MediaSourceEventListener {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30822a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f3674a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final MediaSource.a f3675a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final CopyOnWriteArrayList<C0685a> f3676a;

        /* JADX INFO: renamed from: com.google.android.exoplayer2.source.MediaSourceEventListener$a$a, reason: collision with other inner class name */
        public static final class C0685a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f30823a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public MediaSourceEventListener f3677a;

            public C0685a(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
                this.f30823a = handler;
                this.f3677a = mediaSourceEventListener;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(MediaSourceEventListener mediaSourceEventListener, oh5 oh5Var) {
            mediaSourceEventListener.J(this.f30822a, this.f3675a, oh5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(MediaSourceEventListener mediaSourceEventListener, az4 az4Var, oh5 oh5Var) {
            mediaSourceEventListener.w(this.f30822a, this.f3675a, az4Var, oh5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(MediaSourceEventListener mediaSourceEventListener, az4 az4Var, oh5 oh5Var) {
            mediaSourceEventListener.e(this.f30822a, this.f3675a, az4Var, oh5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(MediaSourceEventListener mediaSourceEventListener, az4 az4Var, oh5 oh5Var, IOException iOException, boolean z) {
            mediaSourceEventListener.y(this.f30822a, this.f3675a, az4Var, oh5Var, iOException, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(MediaSourceEventListener mediaSourceEventListener, az4 az4Var, oh5 oh5Var) {
            mediaSourceEventListener.m(this.f30822a, this.f3675a, az4Var, oh5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(MediaSourceEventListener mediaSourceEventListener, MediaSource.a aVar, oh5 oh5Var) {
            mediaSourceEventListener.l(this.f30822a, aVar, oh5Var);
        }

        public void A(az4 az4Var, int i, int i2, @Nullable com.google.android.exoplayer2.d dVar, int i3, @Nullable Object obj, long j, long j2) {
            B(az4Var, new oh5(i, i2, dVar, i3, obj, h(j), h(j2)));
        }

        public void B(final az4 az4Var, final oh5 oh5Var) {
            for (C0685a c0685a : this.f3676a) {
                final MediaSourceEventListener mediaSourceEventListener = c0685a.f3677a;
                gj9.j1(c0685a.f30823a, new Runnable() { // from class: com.zj.adlib.fl5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f41704a.o(mediaSourceEventListener, az4Var, oh5Var);
                    }
                });
            }
        }

        public void C(MediaSourceEventListener mediaSourceEventListener) {
            for (C0685a c0685a : this.f3676a) {
                if (c0685a.f3677a == mediaSourceEventListener) {
                    this.f3676a.remove(c0685a);
                }
            }
        }

        public void D(int i, long j, long j2) {
            E(new oh5(1, i, null, 3, null, h(j), h(j2)));
        }

        public void E(final oh5 oh5Var) {
            final MediaSource.a aVar = (MediaSource.a) sb0.g(this.f3675a);
            for (C0685a c0685a : this.f3676a) {
                final MediaSourceEventListener mediaSourceEventListener = c0685a.f3677a;
                gj9.j1(c0685a.f30823a, new Runnable() { // from class: com.zj.adlib.pl5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18885a.p(mediaSourceEventListener, aVar, oh5Var);
                    }
                });
            }
        }

        @CheckResult
        public a F(int i, @Nullable MediaSource.a aVar, long j) {
            return new a(this.f3676a, i, aVar, j);
        }

        public void g(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            sb0.g(handler);
            sb0.g(mediaSourceEventListener);
            this.f3676a.add(new C0685a(handler, mediaSourceEventListener));
        }

        public final long h(long j) {
            long jH1 = gj9.H1(j);
            if (jH1 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f3674a + jH1;
        }

        public void i(int i, @Nullable com.google.android.exoplayer2.d dVar, int i2, @Nullable Object obj, long j) {
            j(new oh5(1, i, dVar, i2, obj, h(j), -9223372036854775807L));
        }

        public void j(final oh5 oh5Var) {
            for (C0685a c0685a : this.f3676a) {
                final MediaSourceEventListener mediaSourceEventListener = c0685a.f3677a;
                gj9.j1(c0685a.f30823a, new Runnable() { // from class: com.zj.adlib.hl5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f42153a.k(mediaSourceEventListener, oh5Var);
                    }
                });
            }
        }

        public void q(az4 az4Var, int i) {
            r(az4Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void r(az4 az4Var, int i, int i2, @Nullable com.google.android.exoplayer2.d dVar, int i3, @Nullable Object obj, long j, long j2) {
            s(az4Var, new oh5(i, i2, dVar, i3, obj, h(j), h(j2)));
        }

        public void s(final az4 az4Var, final oh5 oh5Var) {
            for (C0685a c0685a : this.f3676a) {
                final MediaSourceEventListener mediaSourceEventListener = c0685a.f3677a;
                gj9.j1(c0685a.f30823a, new Runnable() { // from class: com.zj.adlib.nl5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f43549a.l(mediaSourceEventListener, az4Var, oh5Var);
                    }
                });
            }
        }

        public void t(az4 az4Var, int i) {
            u(az4Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void u(az4 az4Var, int i, int i2, @Nullable com.google.android.exoplayer2.d dVar, int i3, @Nullable Object obj, long j, long j2) {
            v(az4Var, new oh5(i, i2, dVar, i3, obj, h(j), h(j2)));
        }

        public void v(final az4 az4Var, final oh5 oh5Var) {
            for (C0685a c0685a : this.f3676a) {
                final MediaSourceEventListener mediaSourceEventListener = c0685a.f3677a;
                gj9.j1(c0685a.f30823a, new Runnable() { // from class: com.zj.adlib.ll5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f43094a.m(mediaSourceEventListener, az4Var, oh5Var);
                    }
                });
            }
        }

        public void w(az4 az4Var, int i, int i2, @Nullable com.google.android.exoplayer2.d dVar, int i3, @Nullable Object obj, long j, long j2, IOException iOException, boolean z) {
            y(az4Var, new oh5(i, i2, dVar, i3, obj, h(j), h(j2)), iOException, z);
        }

        public void x(az4 az4Var, int i, IOException iOException, boolean z) {
            w(az4Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z);
        }

        public void y(final az4 az4Var, final oh5 oh5Var, final IOException iOException, final boolean z) {
            for (C0685a c0685a : this.f3676a) {
                final MediaSourceEventListener mediaSourceEventListener = c0685a.f3677a;
                gj9.j1(c0685a.f30823a, new Runnable() { // from class: com.zj.adlib.jl5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f42614a.n(mediaSourceEventListener, az4Var, oh5Var, iOException, z);
                    }
                });
            }
        }

        public void z(az4 az4Var, int i) {
            A(az4Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public a(CopyOnWriteArrayList<C0685a> copyOnWriteArrayList, int i, @Nullable MediaSource.a aVar, long j) {
            this.f3676a = copyOnWriteArrayList;
            this.f30822a = i;
            this.f3675a = aVar;
            this.f3674a = j;
        }
    }

    default void J(int i, @Nullable MediaSource.a aVar, oh5 oh5Var) {
    }

    default void e(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var) {
    }

    default void l(int i, MediaSource.a aVar, oh5 oh5Var) {
    }

    default void m(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var) {
    }

    default void w(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var) {
    }

    default void y(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var, IOException iOException, boolean z) {
    }
}
