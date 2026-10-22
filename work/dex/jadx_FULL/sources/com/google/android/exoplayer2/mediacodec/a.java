package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PersistableBundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.mediacodec.a;
import com.google.common.base.Supplier;
import com.zj.adlib.cc0;
import com.zj.adlib.ec0;
import com.zj.adlib.jy1;
import com.zj.adlib.y99;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(23)
public final class a implements MediaCodecAdapter {
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30768a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaCodec f3454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final cc0 f3455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ec0 f3456a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3457a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3458b;

    public static final class b implements MediaCodecAdapter.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Supplier<HandlerThread> f30769a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3459a;
        public final Supplier<HandlerThread> b;

        public b(final int i, boolean z) {
            this(new Supplier() { // from class: com.zj.adlib.zb0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return a.b.e(i);
                }
            }, new Supplier() { // from class: com.zj.adlib.bc0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return a.b.f(i);
                }
            }, z);
        }

        public static /* synthetic */ HandlerThread e(int i) {
            return new HandlerThread(a.g(i));
        }

        public static /* synthetic */ HandlerThread f(int i) {
            return new HandlerThread(a.h(i));
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Factory
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(MediaCodecAdapter.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            String str = aVar.f3409a.f3463a;
            a aVar2 = null;
            try {
                y99.a("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    a aVar3 = new a(mediaCodecCreateByCodecName, this.f30769a.get(), this.b.get(), this.f3459a);
                    try {
                        y99.c();
                        aVar3.j(aVar.f3406a, aVar.f3407a, aVar.f3405a, aVar.f30762a);
                        return aVar3;
                    } catch (Exception e) {
                        e = e;
                        aVar2 = aVar3;
                        if (aVar2 != null) {
                            aVar2.release();
                        } else if (mediaCodecCreateByCodecName != null) {
                            mediaCodecCreateByCodecName.release();
                        }
                        throw e;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                mediaCodecCreateByCodecName = null;
            }
        }

        @VisibleForTesting
        public b(Supplier<HandlerThread> supplier, Supplier<HandlerThread> supplier2, boolean z) {
            this.f30769a = supplier;
            this.b = supplier2;
            this.f3459a = z;
        }
    }

    public static String g(int i) {
        return i(i, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    public static String h(int i) {
        return i(i, "ExoPlayer:MediaCodecQueueingThread:");
    }

    public static String i(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j, long j2) {
        onFrameRenderedListener.a(this, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void a(final MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        l();
        this.f3454a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.zj.adlib.xb0
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                this.f20624a.k(onFrameRenderedListener, mediaCodec, j, j2);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void b(int i, int i2, jy1 jy1Var, long j, int i3) {
        this.f3455a.n(i, i2, jy1Var, j, i3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueInputBufferIndex() {
        return this.f3456a.c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        return this.f3456a.d(bufferInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void flush() {
        this.f3455a.i();
        this.f3454a.flush();
        this.f3456a.e();
        this.f3454a.start();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    @Nullable
    public ByteBuffer getInputBuffer(int i) {
        return this.f3454a.getInputBuffer(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    @RequiresApi(26)
    public PersistableBundle getMetrics() {
        l();
        return this.f3454a.getMetrics();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    @Nullable
    public ByteBuffer getOutputBuffer(int i) {
        return this.f3454a.getOutputBuffer(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public MediaFormat getOutputFormat() {
        return this.f3456a.g();
    }

    public final void j(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i) {
        this.f3456a.h(this.f3454a);
        y99.a("configureCodec");
        this.f3454a.configure(mediaFormat, surface, mediaCrypto, i);
        y99.c();
        this.f3455a.r();
        y99.a("startCodec");
        this.f3454a.start();
        y99.c();
        this.f30768a = 1;
    }

    public final void l() {
        if (this.f3457a) {
            try {
                this.f3455a.s();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @VisibleForTesting
    public void m(MediaCodec.CodecException codecException) {
        this.f3456a.onError(this.f3454a, codecException);
    }

    @VisibleForTesting
    public void n(MediaFormat mediaFormat) {
        this.f3456a.onOutputFormatChanged(this.f3454a, mediaFormat);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public boolean needsReconfiguration() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.f3455a.m(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void release() {
        try {
            if (this.f30768a == 1) {
                this.f3455a.q();
                this.f3456a.o();
            }
            this.f30768a = 2;
        } finally {
            if (!this.f3458b) {
                this.f3454a.release();
                this.f3458b = true;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void releaseOutputBuffer(int i, boolean z) {
        this.f3454a.releaseOutputBuffer(i, z);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void setOutputSurface(Surface surface) {
        l();
        this.f3454a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void setParameters(Bundle bundle) {
        l();
        this.f3454a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void setVideoScalingMode(int i) {
        l();
        this.f3454a.setVideoScalingMode(i);
    }

    public a(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z) {
        this.f3454a = mediaCodec;
        this.f3456a = new ec0(handlerThread);
        this.f3455a = new cc0(mediaCodec, handlerThread2);
        this.f3457a = z;
        this.f30768a = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void releaseOutputBuffer(int i, long j) {
        this.f3454a.releaseOutputBuffer(i, j);
    }
}
