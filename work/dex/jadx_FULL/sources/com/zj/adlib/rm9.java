package com.zj.adlib;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.hw.videoprocessor.IVideoEncodeThread;
import com.ipd.dsp.internal.v1.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class rm9 extends Thread implements IVideoEncodeThread {
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f44486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaCodec f19374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaExtractor f19375a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaMuxer f19376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile Surface f19377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Exception f19378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile CountDownLatch f19379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AtomicBoolean f19380a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19381a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f19382b;

    public rm9(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i, int i2, int i3, int i4, int i5, AtomicBoolean atomicBoolean, long j, boolean z, boolean z2, int i6) {
        super("VideoProcessEncodeThread");
        this.f19376a = mediaMuxer;
        this.f19380a = atomicBoolean;
        this.f19375a = mediaExtractor;
        this.K = i;
        this.M = i3;
        this.L = i2;
        this.N = i4;
        this.O = i5;
        this.f19379a = new CountDownLatch(1);
        this.f44486a = j;
        this.b = j;
        this.f19381a = z;
        this.f19382b = z2;
        this.P = i6;
    }

    @Override // com.hw.videoprocessor.IVideoEncodeThread
    public CountDownLatch b() {
        return this.f19379a;
    }

    public final void c() throws IOException {
        MediaFormat trackFormat = this.f19375a.getTrackFormat(this.O);
        int integer = trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : jo9.f42631a;
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", this.L, this.M);
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, this.K);
        mediaFormatCreateVideoFormat.setInteger("frame-rate", integer);
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", this.N);
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f19374a = mediaCodecCreateEncoderByType;
        mediaCodecCreateEncoderByType.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f19377a = this.f19374a.createInputSurface();
        this.f19374a.start();
        this.f19379a.countDown();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        boolean z = false;
        int i = 0;
        while (true) {
            if (this.f19380a.get() && !z) {
                this.f19374a.signalEndOfInputStream();
                z = true;
            }
            int iDequeueOutputBuffer = this.f19374a.dequeueOutputBuffer(bufferInfo, b.C0923b.f);
            v61.k("encode outputBufferIndex = " + iDequeueOutputBuffer, new Object[0]);
            if (z && iDequeueOutputBuffer == -1) {
                i++;
                if (i > 10) {
                    v61.f("INFO_TRY_AGAIN_LATER 10 times,force End!", new Object[0]);
                    return;
                }
            } else {
                i = 0;
            }
            if (iDequeueOutputBuffer != -1) {
                if (iDequeueOutputBuffer == -2) {
                    v61.k("encode newFormat = " + this.f19374a.getOutputFormat(), new Object[0]);
                } else if (iDequeueOutputBuffer < 0) {
                    v61.f("unexpected result from decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer, new Object[0]);
                } else {
                    ByteBuffer outputBuffer = this.f19374a.getOutputBuffer(iDequeueOutputBuffer);
                    long j = bufferInfo.presentationTimeUs + this.f44486a;
                    bufferInfo.presentationTimeUs = j;
                    if (this.f19381a || bufferInfo.flags != 2) {
                        if (!this.f19382b && bufferInfo.flags == 4) {
                            v61.k("encoderDone", new Object[0]);
                            this.f19374a.releaseOutputBuffer(iDequeueOutputBuffer, false);
                            return;
                        }
                        if (bufferInfo.flags == 4 && j < 0) {
                            bufferInfo.presentationTimeUs = 0L;
                        }
                        v61.k("writeSampleData,size:" + bufferInfo.size + " time:" + (bufferInfo.presentationTimeUs / 1000) + " flag:" + bufferInfo.flags, new Object[0]);
                        this.f19376a.writeSampleData(this.P, outputBuffer, bufferInfo);
                        long j2 = this.b;
                        long j3 = bufferInfo.presentationTimeUs;
                        if (j2 < j3) {
                            this.b = j3;
                        }
                        this.f19374a.releaseOutputBuffer(iDequeueOutputBuffer, false);
                        if (bufferInfo.flags == 4) {
                            v61.k("encoderDone", new Object[0]);
                            return;
                        }
                    }
                }
            }
        }
    }

    public Exception d() {
        return this.f19378a;
    }

    public long e() {
        return this.b;
    }

    @Override // com.hw.videoprocessor.IVideoEncodeThread
    public Surface getSurface() {
        return this.f19377a;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        MediaCodec mediaCodec;
        super.run();
        try {
            c();
            mediaCodec = this.f19374a;
            if (mediaCodec != null) {
                mediaCodec.stop();
            }
        } catch (Exception e) {
            v61.g(e);
            this.f19378a = e;
            if (this.f19374a != null) {
                mediaCodec = this.f19374a;
            }
        } finally {
            MediaCodec mediaCodec2 = this.f19374a;
            if (mediaCodec2 != null) {
                mediaCodec2.stop();
                this.f19374a.release();
            }
        }
    }
}
