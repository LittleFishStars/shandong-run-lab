package com.zj.adlib;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.o;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class yn5 {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f46073a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HandlerThread f20894a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaSource.Factory f20895a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HandlerWrapper f20896a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final o<ga9> f20897a;

        public final class a implements Handler.Callback {
            public static final int K = 100;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public MediaPeriod f46074a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public MediaSource f20898a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final C1337a f20899a = new C1337a();

            /* JADX INFO: renamed from: com.zj.adlib.yn5$b$a$a, reason: collision with other inner class name */
            public final class C1337a implements MediaSource.MediaSourceCaller {

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public boolean f20903a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final C1338a f20901a = new C1338a();

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final Allocator f46075a = new com.google.android.exoplayer2.upstream.a(true, 65536);

                /* JADX INFO: renamed from: com.zj.adlib.yn5$b$a$a$a, reason: collision with other inner class name */
                public final class C1338a implements MediaPeriod.Callback {
                    public C1338a() {
                    }

                    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void d(MediaPeriod mediaPeriod) {
                        b.this.f20896a.a(2).sendToTarget();
                    }

                    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
                    public void h(MediaPeriod mediaPeriod) {
                        b.this.f20897a.set(mediaPeriod.e());
                        b.this.f20896a.a(3).sendToTarget();
                    }
                }

                public C1337a() {
                }

                @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
                public void r(MediaSource mediaSource, Timeline timeline) {
                    if (this.f20903a) {
                        return;
                    }
                    this.f20903a = true;
                    a.this.f46074a = mediaSource.F(new MediaSource.a(timeline.s(0)), this.f46075a, 0L);
                    a.this.f46074a.c(this.f20901a, 0L);
                }
            }

            public a() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    MediaSource mediaSourceC = b.this.f20895a.c((g) message.obj);
                    this.f20898a = mediaSourceC;
                    mediaSourceC.x(this.f20899a, null, at6.f40608a);
                    b.this.f20896a.sendEmptyMessage(1);
                    return true;
                }
                if (i == 1) {
                    try {
                        MediaPeriod mediaPeriod = this.f46074a;
                        if (mediaPeriod == null) {
                            ((MediaSource) sb0.g(this.f20898a)).maybeThrowSourceInfoRefreshError();
                        } else {
                            mediaPeriod.maybeThrowPrepareError();
                        }
                        b.this.f20896a.sendEmptyMessageDelayed(1, 100);
                    } catch (Exception e) {
                        b.this.f20897a.setException(e);
                        b.this.f20896a.a(3).sendToTarget();
                    }
                    return true;
                }
                if (i == 2) {
                    ((MediaPeriod) sb0.g(this.f46074a)).continueLoading(0L);
                    return true;
                }
                if (i != 3) {
                    return false;
                }
                if (this.f46074a != null) {
                    ((MediaSource) sb0.g(this.f20898a)).j(this.f46074a);
                }
                ((MediaSource) sb0.g(this.f20898a)).L(this.f20899a);
                b.this.f20896a.removeCallbacksAndMessages(null);
                b.this.f20894a.quit();
                return true;
            }
        }

        public b(MediaSource.Factory factory, Clock clock) {
            this.f20895a = factory;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:MetadataRetriever");
            this.f20894a = handlerThread;
            handlerThread.start();
            this.f20896a = clock.a(handlerThread.getLooper(), new a());
            this.f20897a = o.A();
        }

        public ListenableFuture<ga9> e(g gVar) {
            this.f20896a.b(0, gVar).sendToTarget();
            return this.f20897a;
        }
    }

    public static ListenableFuture<ga9> a(Context context, g gVar) {
        return b(context, gVar, Clock.f31152a);
    }

    @VisibleForTesting
    public static ListenableFuture<ga9> b(Context context, g gVar, Clock clock) {
        return d(new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory().r(6)), gVar, clock);
    }

    public static ListenableFuture<ga9> c(MediaSource.Factory factory, g gVar) {
        return d(factory, gVar, Clock.f31152a);
    }

    public static ListenableFuture<ga9> d(MediaSource.Factory factory, g gVar, Clock clock) {
        return new b(factory, clock).e(gVar);
    }
}
