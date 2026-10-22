package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.zj.adlib.jy1;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface MediaCodecAdapter {

    public interface Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Factory f30761a = new b();

        MediaCodecAdapter a(a aVar) throws IOException;
    }

    public interface OnFrameRenderedListener {
        void a(MediaCodecAdapter mediaCodecAdapter, long j, long j2);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30762a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final MediaCrypto f3405a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaFormat f3406a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final Surface f3407a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.android.exoplayer2.d f3408a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final c f3409a;

        public a(c cVar, MediaFormat mediaFormat, com.google.android.exoplayer2.d dVar, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i) {
            this.f3409a = cVar;
            this.f3406a = mediaFormat;
            this.f3408a = dVar;
            this.f3407a = surface;
            this.f3405a = mediaCrypto;
            this.f30762a = i;
        }

        public static a a(c cVar, MediaFormat mediaFormat, com.google.android.exoplayer2.d dVar, @Nullable MediaCrypto mediaCrypto) {
            return new a(cVar, mediaFormat, dVar, null, mediaCrypto, 0);
        }

        public static a b(c cVar, MediaFormat mediaFormat, com.google.android.exoplayer2.d dVar, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto) {
            return new a(cVar, mediaFormat, dVar, surface, mediaCrypto, 0);
        }
    }

    @RequiresApi(23)
    void a(OnFrameRenderedListener onFrameRenderedListener, Handler handler);

    void b(int i, int i2, jy1 jy1Var, long j, int i3);

    int dequeueInputBufferIndex();

    int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo);

    void flush();

    @Nullable
    ByteBuffer getInputBuffer(int i);

    @RequiresApi(26)
    PersistableBundle getMetrics();

    @Nullable
    ByteBuffer getOutputBuffer(int i);

    MediaFormat getOutputFormat();

    boolean needsReconfiguration();

    void queueInputBuffer(int i, int i2, int i3, long j, int i4);

    void release();

    @RequiresApi(21)
    void releaseOutputBuffer(int i, long j);

    void releaseOutputBuffer(int i, boolean z);

    @RequiresApi(23)
    void setOutputSurface(Surface surface);

    @RequiresApi(19)
    void setParameters(Bundle bundle);

    void setVideoScalingMode(int i);
}
