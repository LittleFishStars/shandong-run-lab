package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.zj.adlib.sb0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface BandwidthMeter {

    public interface EventListener {

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CopyOnWriteArrayList<C0700a> f31101a = new CopyOnWriteArrayList<>();

            /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.BandwidthMeter$EventListener$a$a, reason: collision with other inner class name */
            public static final class C0700a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final Handler f31102a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final EventListener f5016a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public boolean f5017a;

                public C0700a(Handler handler, EventListener eventListener) {
                    this.f31102a = handler;
                    this.f5016a = eventListener;
                }

                public void d() {
                    this.f5017a = true;
                }
            }

            public static /* synthetic */ void d(C0700a c0700a, int i, long j, long j2) {
                c0700a.f5016a.onBandwidthSample(i, j, j2);
            }

            public void b(Handler handler, EventListener eventListener) {
                sb0.g(handler);
                sb0.g(eventListener);
                e(eventListener);
                this.f31101a.add(new C0700a(handler, eventListener));
            }

            public void c(final int i, final long j, final long j2) {
                for (final C0700a c0700a : this.f31101a) {
                    if (!c0700a.f5017a) {
                        c0700a.f31102a.post(new Runnable() { // from class: com.zj.adlib.jl0
                            @Override // java.lang.Runnable
                            public final void run() {
                                BandwidthMeter.EventListener.a.d(c0700a, i, j, j2);
                            }
                        });
                    }
                }
            }

            public void e(EventListener eventListener) {
                for (C0700a c0700a : this.f31101a) {
                    if (c0700a.f5016a == eventListener) {
                        c0700a.d();
                        this.f31101a.remove(c0700a);
                    }
                }
            }
        }

        void onBandwidthSample(int i, long j, long j2);
    }

    @Nullable
    TransferListener b();

    void c(Handler handler, EventListener eventListener);

    void f(EventListener eventListener);

    long getBitrateEstimate();

    default long getTimeToFirstByteEstimateUs() {
        return -9223372036854775807L;
    }
}
