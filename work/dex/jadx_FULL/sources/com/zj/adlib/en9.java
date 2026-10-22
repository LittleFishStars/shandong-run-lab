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
public class en9 extends Thread implements IVideoEncodeThread {
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaCodec f41476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaExtractor f16357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaMuxer f16358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile Surface f16359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ko9 f16360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Exception f16361a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CountDownLatch f16362a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AtomicBoolean f16363a;
    public volatile CountDownLatch b;

    public en9(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i, int i2, int i3, int i4, int i5, int i6, AtomicBoolean atomicBoolean, CountDownLatch countDownLatch) {
        super("VideoProcessEncodeThread");
        this.f16358a = mediaMuxer;
        this.f16363a = atomicBoolean;
        this.f16362a = countDownLatch;
        this.f16357a = mediaExtractor;
        this.K = i;
        this.M = i3;
        this.L = i2;
        this.N = i4;
        this.P = i6;
        this.O = i5;
        this.b = new CountDownLatch(1);
    }

    @Override // com.hw.videoprocessor.IVideoEncodeThread
    public CountDownLatch b() {
        return this.b;
    }

    public final void c() throws IOException {
        MediaFormat trackFormat = this.f16357a.getTrackFormat(this.P);
        int integer = this.O;
        if (integer <= 0) {
            integer = trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : jo9.f42631a;
        }
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", this.L, this.M);
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("frame-rate", integer);
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", this.N);
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f41476a = mediaCodecCreateEncoderByType;
        if (np9.o(mediaCodecCreateEncoderByType, "video/avc", mediaFormatCreateVideoFormat, 8, 512)) {
            v61.k("supportProfileHigh,enable ProfileHigh", new Object[0]);
        }
        int iG = np9.g(this.f41476a, "video/avc");
        if (iG > 0 && this.K > iG) {
            v61.f(this.K + " bitrate too large,set to:" + iG, new Object[0]);
            this.K = (int) (((float) iG) * 0.8f);
        }
        mediaFormatCreateVideoFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, this.K);
        int i = 1;
        this.f41476a.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f16359a = this.f41476a.createInputSurface();
        this.f41476a.start();
        this.b.countDown();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int i2 = (int) (1000000.0f / integer);
        int i3 = -5;
        int iAddTrack = -5;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        long j = -1;
        while (true) {
            if (this.f16363a.get() && i4 == 0) {
                this.f41476a.signalEndOfInputStream();
                i4 = i;
            }
            int iDequeueOutputBuffer = this.f41476a.dequeueOutputBuffer(bufferInfo, b.C0923b.f);
            v61.k("encode outputBufferIndex = " + iDequeueOutputBuffer, new Object[0]);
            if (i4 != 0 && iDequeueOutputBuffer == -1) {
                i5 += i;
                if (i5 > 10) {
                    v61.f("INFO_TRY_AGAIN_LATER 10 times,force End!", new Object[0]);
                    break;
                }
            } else {
                i5 = 0;
            }
            if (iDequeueOutputBuffer != -1) {
                if (iDequeueOutputBuffer != -2) {
                    if (iDequeueOutputBuffer >= 0) {
                        ByteBuffer outputBuffer = this.f41476a.getOutputBuffer(iDequeueOutputBuffer);
                        if (bufferInfo.flags == 4 && bufferInfo.presentationTimeUs < 0) {
                            bufferInfo.presentationTimeUs = 0L;
                        }
                        if (!z && j != -1 && bufferInfo.presentationTimeUs < ((long) (i2 / 2)) + j) {
                            v61.f("video 时间戳错误，lastVideoFrameTimeUs:" + j + " info.presentationTimeUs:" + bufferInfo.presentationTimeUs + " VIDEO_FRAME_TIME_US:" + i2, new Object[0]);
                            z = true;
                        }
                        if (z) {
                            bufferInfo.presentationTimeUs = ((long) i2) + j;
                            v61.f("video 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                            z = false;
                        }
                        if (bufferInfo.flags != 2) {
                            j = bufferInfo.presentationTimeUs;
                        }
                        v61.k("writeSampleData,size:" + bufferInfo.size + " time:" + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                        this.f16358a.writeSampleData(iAddTrack, outputBuffer, bufferInfo);
                        e(bufferInfo);
                        this.f41476a.releaseOutputBuffer(iDequeueOutputBuffer, false);
                        if (bufferInfo.flags == 4) {
                            v61.k("encoderDone", new Object[0]);
                            break;
                        }
                    } else {
                        v61.f("unexpected result from decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer, new Object[0]);
                    }
                } else {
                    MediaFormat outputFormat = this.f41476a.getOutputFormat();
                    if (iAddTrack == i3) {
                        iAddTrack = this.f16358a.addTrack(outputFormat);
                        this.f16358a.start();
                        this.f16362a.countDown();
                    }
                    v61.k("encode newFormat = " + outputFormat, new Object[0]);
                }
                i3 = -5;
                i = 1;
            }
        }
        v61.k("Video Encode Done!", new Object[0]);
    }

    public Exception d() {
        return this.f16361a;
    }

    public final void e(MediaCodec.BufferInfo bufferInfo) {
        ko9 ko9Var = this.f16360a;
        if (ko9Var == null) {
            return;
        }
        ko9Var.b((bufferInfo.flags & 4) > 0 ? Long.MAX_VALUE : bufferInfo.presentationTimeUs);
    }

    public void f(ko9 ko9Var) {
        this.f16360a = ko9Var;
    }

    @Override // com.hw.videoprocessor.IVideoEncodeThread
    public Surface getSurface() {
        return this.f16359a;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0018 A[PHI: r0
      0x0018: PHI (r0v7 'e' java.lang.Exception) = (r0v2 'e' java.lang.Exception), (r0v8 'e' java.lang.Exception) binds: [B:23:0x0039, B:10:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        MediaCodec mediaCodec;
        Exception exc;
        super.run();
        try {
            c();
            try {
                if (this.f41476a != null) {
                }
            } catch (Exception e) {
                e = e;
                exc = this.f16361a;
                if (exc == null) {
                    exc = e;
                }
                this.f16361a = exc;
                v61.g(e);
            }
        } catch (Exception e2) {
            v61.g(e2);
            this.f16361a = e2;
            try {
                if (this.f41476a != null) {
                    mediaCodec = this.f41476a;
                }
            } catch (Exception e3) {
                e = e3;
                exc = this.f16361a;
                if (exc == null) {
                    exc = e;
                }
                this.f16361a = exc;
                v61.g(e);
            }
        } finally {
            try {
                mediaCodec = this.f41476a;
                if (mediaCodec != null) {
                    mediaCodec.stop();
                    this.f41476a.release();
                }
            } catch (Exception e4) {
                Exception exc2 = this.f16361a;
                if (exc2 == null) {
                    exc2 = e4;
                }
                this.f16361a = exc2;
                v61.g(e4);
            }
        }
    }
}
