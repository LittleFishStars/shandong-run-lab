package com.zj.adlib;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.net.Uri;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.util.FileTypes;
import com.hw.videoprocessor.util.VideoProgressListener;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@TargetApi(21)
public class jo9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f42631a = 20;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f17442a = "VideoProcessor";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f17443a = true;
    public static final int b = 1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f17444b = "video/avc";
    public static final int c = 192000;
    public static final int d = 2500;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f42632a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ File f17445a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Integer f17446a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CountDownLatch f17447a;
        public final /* synthetic */ Integer b;

        public a(c cVar, File file, Integer num, Integer num2, CountDownLatch countDownLatch) {
            this.f42632a = cVar;
            this.f17445a = file;
            this.f17446a = num;
            this.b = num2;
            this.f17447a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    gg0.h(this.f42632a, this.f17445a.getAbsolutePath(), this.f17446a, this.b);
                    this.f17447a.countDown();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                this.f17447a.countDown();
                throw th;
            }
        }
    }

    public static class b implements Runnable {
        public final /* synthetic */ int K;
        public final /* synthetic */ int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f42633a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ File f17448a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CountDownLatch f17449a;

        public b(c cVar, File file, int i, int i2, CountDownLatch countDownLatch) {
            this.f42633a = cVar;
            this.f17448a = file;
            this.K = i;
            this.L = i2;
            this.f17449a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    c cVar = this.f42633a;
                    String absolutePath = this.f17448a.getAbsolutePath();
                    int i = this.K;
                    int i2 = this.L;
                    gg0.h(cVar, absolutePath, 0, Integer.valueOf(i > i2 ? i2 * 1000 : i * 1000));
                    this.f17449a.countDown();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                this.f17449a.countDown();
                throw th;
            }
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f42635a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public VideoProgressListener f17452a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public c f17453a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Boolean f17454a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Float f17455a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Integer f17456a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f17457a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f17458a = true;

        @Nullable
        public Integer b;

        @Nullable
        public Integer c;

        @Nullable
        public Integer d;

        @Nullable
        public Integer e;

        @Nullable
        public Integer f;

        @Nullable
        public Integer g;

        public d(Context context) {
            this.f42635a = context;
        }

        public d A(String str) {
            this.f17457a = str;
            return this;
        }

        public void B() throws Exception {
            jo9.e(this.f42635a, this);
        }

        public d C(VideoProgressListener videoProgressListener) {
            this.f17452a = videoProgressListener;
            return this;
        }

        public d D(float f) {
            this.f17455a = Float.valueOf(f);
            return this;
        }

        public d E(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public d p(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        public d q(boolean z) {
            this.f17454a = Boolean.valueOf(z);
            return this;
        }

        public d r(boolean z) {
            this.f17458a = z;
            return this;
        }

        public d s(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        public d t(int i) {
            this.f = Integer.valueOf(i);
            return this;
        }

        public d u(int i) {
            this.g = Integer.valueOf(i);
            return this;
        }

        public d v(Uri uri) {
            this.f17453a = new c(this.f42635a, uri);
            return this;
        }

        public d w(c cVar) {
            this.f17453a = cVar;
            return this;
        }

        public d x(String str) {
            this.f17453a = new c(str);
            return this;
        }

        public d y(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public d z(int i) {
            this.f17456a = Integer.valueOf(i);
            return this;
        }
    }

    /* JADX WARN: Code duplicated, block: B:154:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x021e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x026e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0221  */
    /* JADX WARN: Code duplicated, block: B:58:0x0249 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x024b A[Catch: all -> 0x0240, TRY_LEAVE, TryCatch #0 {all -> 0x0240, blocks: (B:55:0x0224, B:59:0x024b, B:43:0x01df), top: B:154:0x0224 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0269 A[Catch: all -> 0x0338, TRY_ENTER, TryCatch #11 {all -> 0x0338, blocks: (B:49:0x0217, B:61:0x0269, B:65:0x0281), top: B:176:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0281 A[Catch: all -> 0x0338, TRY_LEAVE, TryCatch #11 {all -> 0x0338, blocks: (B:49:0x0217, B:61:0x0269, B:65:0x0281), top: B:176:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:78:0x02eb A[Catch: all -> 0x030b, TRY_LEAVE, TryCatch #4 {all -> 0x030b, blocks: (B:73:0x02bb, B:75:0x02c5, B:78:0x02eb, B:85:0x0317), top: B:162:0x02bb }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0317 A[Catch: all -> 0x030b, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x030b, blocks: (B:73:0x02bb, B:75:0x02c5, B:78:0x02eb, B:85:0x0317), top: B:162:0x02bb }] */
    /* JADX WARN: Instruction removed from duplicated block: B:59:0x024b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:78:0x02eb, please report this as an issue */
    public static void a(Context context, c cVar, String str, int i, float f, float f2) throws Throwable {
        int i2;
        MediaExtractor mediaExtractor;
        MediaExtractor mediaExtractor2;
        MediaMuxer mediaMuxer;
        MediaExtractor mediaExtractor3;
        Throwable th;
        boolean z;
        long j;
        int iDequeueOutputBuffer;
        boolean z2;
        MediaFormat mediaFormat;
        MediaMuxer mediaMuxer2;
        String str2 = "frame-rate";
        if (i == 100 && f == 0.0f && f2 == 0.0f) {
            gg0.f(cVar, str);
            return;
        }
        File file = new File(context.getCacheDir(), "pcm");
        file.mkdir();
        MediaExtractor mediaExtractor4 = new MediaExtractor();
        cVar.a(mediaExtractor4);
        int iM = np9.m(mediaExtractor4, true);
        if (iM < 0) {
            v61.f("no audio stream!", new Object[0]);
            gg0.f(cVar, str);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file2 = new File(file, "video_" + jCurrentTimeMillis + ".pcm");
        File file3 = new File(file, "video_" + jCurrentTimeMillis + "_adjust.pcm");
        File file4 = new File(file, "video_" + jCurrentTimeMillis + FileTypes.B);
        gg0.h(cVar, file2.getAbsolutePath(), null, null);
        gg0.b(file2.getAbsolutePath(), file3.getAbsolutePath(), i);
        MediaFormat trackFormat = mediaExtractor4.getTrackFormat(iM);
        int integer = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
        int integer2 = trackFormat.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) ? trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) : 1;
        int i3 = integer2 == 2 ? 12 : 16;
        if (f > 0.0f || f2 > 0.0f) {
            te0.a(file3.getAbsolutePath(), integer, integer2, f, f2);
        }
        new nn6(integer, i3, integer2, 2).a(file3.getAbsolutePath(), file4.getAbsolutePath());
        int iJ = gg0.j(trackFormat);
        int iM2 = np9.m(mediaExtractor4, false);
        MediaFormat trackFormat2 = mediaExtractor4.getTrackFormat(iM2);
        int integer3 = trackFormat2.containsKey("rotation-degrees") ? trackFormat2.getInteger("rotation-degrees") : 0;
        MediaMuxer mediaMuxer3 = new MediaMuxer(str, 0);
        mediaMuxer3.setOrientationHint(integer3);
        int iAddTrack = mediaMuxer3.addTrack(trackFormat2);
        int iAddTrack2 = mediaMuxer3.addTrack(trackFormat);
        mediaMuxer3.start();
        MediaExtractor mediaExtractor5 = new MediaExtractor();
        mediaExtractor5.setDataSource(file4.getAbsolutePath());
        int i4 = iAddTrack;
        int iM3 = np9.m(mediaExtractor5, true);
        mediaExtractor5.selectTrack(iM3);
        int iK = gg0.k(mediaExtractor5.getTrackFormat(iM3));
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iK);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", integer, integer2);
        mediaFormatCreateAudioFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, iJ);
        mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
        String str3 = "max-input-size";
        mediaFormatCreateAudioFormat.setInteger("max-input-size", iK);
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
        mediaCodecCreateEncoderByType.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        mediaCodecCreateEncoderByType.start();
        int i5 = 1024000000 / integer;
        long j2 = -1;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            i2 = iM2;
            mediaExtractor = mediaExtractor4;
            if (z3) {
                break;
            }
            String str4 = str2;
            boolean z6 = z3;
            String str5 = str3;
            try {
                int iDequeueInputBuffer = mediaCodecCreateEncoderByType.dequeueInputBuffer(com.ipd.dsp.internal.v1.b.C0923b.f);
                if (!z4 && iDequeueInputBuffer >= 0) {
                    try {
                        long sampleTime = mediaExtractor5.getSampleTime();
                        if (sampleTime < 0) {
                            mediaCodecCreateEncoderByType.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                            byteBufferAllocateDirect = byteBufferAllocateDirect;
                            mediaMuxer3 = mediaMuxer3;
                            z = true;
                            j = 2500;
                        } else {
                            int sampleFlags = mediaExtractor5.getSampleFlags();
                            byteBufferAllocateDirect.clear();
                            int sampleData = mediaExtractor5.readSampleData(byteBufferAllocateDirect, 0);
                            ByteBuffer inputBuffer = mediaCodecCreateEncoderByType.getInputBuffer(iDequeueInputBuffer);
                            inputBuffer.clear();
                            inputBuffer.put(byteBufferAllocateDirect);
                            inputBuffer.position(0);
                            StringBuilder sb = new StringBuilder();
                            sb.append("audio queuePcmBuffer ");
                            sb.append(sampleTime / 1000);
                            sb.append(" size:");
                            sb.append(sampleData);
                            v61.n("VideoProcessor", sb.toString(), new Object[0]);
                            mediaCodecCreateEncoderByType.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, sampleTime, sampleFlags);
                            mediaExtractor5.advance();
                        }
                        while (true) {
                            try {
                                iDequeueOutputBuffer = mediaCodecCreateEncoderByType.dequeueOutputBuffer(bufferInfo, j);
                                if (iDequeueOutputBuffer == -1) {
                                    z2 = z6;
                                    break;
                                }
                                if (iDequeueOutputBuffer == -2) {
                                    try {
                                        v61.n("VideoProcessor", "audio decode newFormat = " + mediaCodecCreateEncoderByType.getOutputFormat(), new Object[0]);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        mediaCodecCreateEncoderByType = mediaCodecCreateEncoderByType;
                                        mediaMuxer = mediaMuxer3;
                                        mediaExtractor3 = mediaExtractor;
                                        mediaExtractor2 = mediaExtractor5;
                                        th = th;
                                        file2.delete();
                                        file3.delete();
                                        file4.delete();
                                        mediaExtractor2.release();
                                        mediaExtractor3.release();
                                        mediaMuxer.release();
                                        mediaCodecCreateEncoderByType.stop();
                                        mediaCodecCreateEncoderByType.release();
                                        throw th;
                                    }
                                } else {
                                    if (iDequeueOutputBuffer < 0) {
                                        v61.h("VideoProcessor", "unexpected result from audio decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer, new Object[0]);
                                    } else {
                                        if (bufferInfo.flags == 4) {
                                            z2 = true;
                                            break;
                                        }
                                        ByteBuffer outputBuffer = mediaCodecCreateEncoderByType.getOutputBuffer(iDequeueOutputBuffer);
                                        StringBuilder sb2 = new StringBuilder();
                                        mediaMuxer2 = mediaMuxer3;
                                        try {
                                            sb2.append("audio writeSampleData ");
                                            mediaExtractor2 = mediaExtractor5;
                                            try {
                                                sb2.append(bufferInfo.presentationTimeUs);
                                                sb2.append(" size:");
                                                sb2.append(bufferInfo.size);
                                                sb2.append(" flags:");
                                                sb2.append(bufferInfo.flags);
                                                v61.n("VideoProcessor", sb2.toString(), new Object[0]);
                                                if (!z5 || j2 == -1) {
                                                    mediaFormat = trackFormat2;
                                                } else {
                                                    try {
                                                        mediaFormat = trackFormat2;
                                                        if (bufferInfo.presentationTimeUs < ((long) i5) + j2) {
                                                            v61.h("VideoProcessor", "audio 时间戳错误，lastAudioFrameTimeUs:" + j2 + " info.presentationTimeUs:" + bufferInfo.presentationTimeUs, new Object[0]);
                                                            z5 = true;
                                                        }
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        mediaMuxer = mediaMuxer2;
                                                    }
                                                }
                                                if (z5) {
                                                    bufferInfo.presentationTimeUs = ((long) i5) + j2;
                                                    v61.h("VideoProcessor", "audio 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                                                    z5 = false;
                                                }
                                                if (bufferInfo.flags != 2) {
                                                    j2 = bufferInfo.presentationTimeUs;
                                                }
                                                mediaMuxer = mediaMuxer2;
                                                try {
                                                    mediaMuxer.writeSampleData(iAddTrack2, outputBuffer, bufferInfo);
                                                    outputBuffer.clear();
                                                    mediaCodecCreateEncoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                mediaMuxer = mediaMuxer2;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            mediaExtractor2 = mediaExtractor5;
                                        }
                                        th = th;
                                        mediaExtractor3 = mediaExtractor;
                                    }
                                    mediaExtractor5 = mediaExtractor2;
                                    trackFormat2 = mediaFormat;
                                    j = com.ipd.dsp.internal.v1.b.C0923b.f;
                                    mediaMuxer3 = mediaMuxer;
                                }
                                mediaMuxer = mediaMuxer3;
                                mediaFormat = trackFormat2;
                                mediaExtractor2 = mediaExtractor5;
                                mediaExtractor5 = mediaExtractor2;
                                trackFormat2 = mediaFormat;
                                j = com.ipd.dsp.internal.v1.b.C0923b.f;
                                mediaMuxer3 = mediaMuxer;
                            } catch (Throwable th7) {
                                th = th7;
                                mediaMuxer = mediaMuxer3;
                                mediaExtractor2 = mediaExtractor5;
                            }
                        }
                        iM2 = i2;
                        j2 = j2;
                        mediaMuxer3 = mediaMuxer3;
                        z4 = z;
                        mediaExtractor4 = mediaExtractor;
                        str2 = str4;
                        str3 = str5;
                        byteBufferAllocateDirect = byteBufferAllocateDirect;
                        z3 = z2;
                    } catch (Throwable th8) {
                        th = th8;
                        mediaExtractor2 = mediaExtractor5;
                        mediaCodecCreateEncoderByType = mediaCodecCreateEncoderByType;
                        mediaMuxer = mediaMuxer3;
                        mediaExtractor3 = mediaExtractor;
                        th = th;
                        file2.delete();
                        file3.delete();
                        file4.delete();
                        mediaExtractor2.release();
                        mediaExtractor3.release();
                        mediaMuxer.release();
                        mediaCodecCreateEncoderByType.stop();
                        mediaCodecCreateEncoderByType.release();
                        throw th;
                    }
                }
                z = z4;
                j = com.ipd.dsp.internal.v1.b.C0923b.f;
                while (true) {
                    iDequeueOutputBuffer = mediaCodecCreateEncoderByType.dequeueOutputBuffer(bufferInfo, j);
                    if (iDequeueOutputBuffer == -1) {
                        z2 = z6;
                        break;
                        break;
                    }
                    if (iDequeueOutputBuffer == -2) {
                        v61.n("VideoProcessor", "audio decode newFormat = " + mediaCodecCreateEncoderByType.getOutputFormat(), new Object[0]);
                    } else {
                        if (iDequeueOutputBuffer < 0) {
                            v61.h("VideoProcessor", "unexpected result from audio decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer, new Object[0]);
                        } else {
                            if (bufferInfo.flags == 4) {
                                z2 = true;
                                break;
                                break;
                            }
                            ByteBuffer outputBuffer2 = mediaCodecCreateEncoderByType.getOutputBuffer(iDequeueOutputBuffer);
                            StringBuilder sb3 = new StringBuilder();
                            mediaMuxer2 = mediaMuxer3;
                            sb3.append("audio writeSampleData ");
                            mediaExtractor2 = mediaExtractor5;
                            sb3.append(bufferInfo.presentationTimeUs);
                            sb3.append(" size:");
                            sb3.append(bufferInfo.size);
                            sb3.append(" flags:");
                            sb3.append(bufferInfo.flags);
                            v61.n("VideoProcessor", sb3.toString(), new Object[0]);
                            if (z5) {
                                mediaFormat = trackFormat2;
                            } else {
                                mediaFormat = trackFormat2;
                            }
                            if (z5) {
                                bufferInfo.presentationTimeUs = ((long) i5) + j2;
                                v61.h("VideoProcessor", "audio 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                                z5 = false;
                            }
                            if (bufferInfo.flags != 2) {
                                j2 = bufferInfo.presentationTimeUs;
                            }
                            mediaMuxer = mediaMuxer2;
                            mediaMuxer.writeSampleData(iAddTrack2, outputBuffer2, bufferInfo);
                            outputBuffer2.clear();
                            mediaCodecCreateEncoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
                            th = th;
                            mediaExtractor3 = mediaExtractor;
                        }
                        mediaExtractor5 = mediaExtractor2;
                        trackFormat2 = mediaFormat;
                        j = com.ipd.dsp.internal.v1.b.C0923b.f;
                        mediaMuxer3 = mediaMuxer;
                    }
                    mediaMuxer = mediaMuxer3;
                    mediaFormat = trackFormat2;
                    mediaExtractor2 = mediaExtractor5;
                    mediaExtractor5 = mediaExtractor2;
                    trackFormat2 = mediaFormat;
                    j = com.ipd.dsp.internal.v1.b.C0923b.f;
                    mediaMuxer3 = mediaMuxer;
                }
                iM2 = i2;
                j2 = j2;
                mediaMuxer3 = mediaMuxer3;
                z4 = z;
                mediaExtractor4 = mediaExtractor;
                str2 = str4;
                str3 = str5;
                byteBufferAllocateDirect = byteBufferAllocateDirect;
                z3 = z2;
            } catch (Throwable th9) {
                th = th9;
                mediaExtractor2 = mediaExtractor5;
                mediaMuxer = mediaMuxer3;
            }
            file2.delete();
            file3.delete();
            file4.delete();
            try {
                mediaExtractor2.release();
                mediaExtractor3.release();
                mediaMuxer.release();
                mediaCodecCreateEncoderByType.stop();
                mediaCodecCreateEncoderByType.release();
                throw th;
            } catch (Exception e) {
                v61.g(e);
                throw th;
            }
        }
        String str6 = str3;
        mediaExtractor2 = mediaExtractor5;
        String str7 = str2;
        mediaMuxer = mediaMuxer3;
        MediaFormat mediaFormat2 = trackFormat2;
        if (iM >= 0) {
            mediaExtractor3 = mediaExtractor;
            try {
                mediaExtractor3.unselectTrack(iM);
            } catch (Throwable th10) {
                th = th10;
                mediaCodecCreateEncoderByType = mediaCodecCreateEncoderByType;
            }
        } else {
            mediaExtractor3 = mediaExtractor;
        }
        try {
            mediaExtractor3.selectTrack(i2);
            mediaExtractor3.seekTo(0L, 0);
            int integer4 = mediaFormat2.getInteger(str6);
            int integer5 = mediaFormat2.containsKey(str7) ? mediaFormat2.getInteger(str7) : (int) Math.ceil(np9.c(cVar));
            ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(integer4);
            int i6 = (int) (1000000.0f / integer5);
            long j3 = -1;
            boolean z7 = false;
            while (true) {
                long sampleTime2 = mediaExtractor3.getSampleTime();
                if (sampleTime2 == -1) {
                    break;
                }
                bufferInfo.presentationTimeUs = sampleTime2;
                bufferInfo.flags = mediaExtractor3.getSampleFlags();
                int sampleData2 = mediaExtractor3.readSampleData(byteBufferAllocateDirect2, 0);
                bufferInfo.size = sampleData2;
                if (sampleData2 < 0) {
                    break;
                }
                if (z7 || j3 == -1) {
                    mediaCodecCreateEncoderByType = mediaCodecCreateEncoderByType;
                } else {
                    mediaCodecCreateEncoderByType = mediaCodecCreateEncoderByType;
                    if (bufferInfo.presentationTimeUs < ((long) i6) + j3) {
                        try {
                            v61.h("VideoProcessor", "video 时间戳错误，lastVideoFrameTimeUs:" + j3 + " info.presentationTimeUs:" + bufferInfo.presentationTimeUs + " VIDEO_FRAME_TIME_US:" + i6, new Object[0]);
                            z7 = true;
                        } catch (Throwable th11) {
                            th = th11;
                            th = th;
                            file2.delete();
                            file3.delete();
                            file4.delete();
                            mediaExtractor2.release();
                            mediaExtractor3.release();
                            mediaMuxer.release();
                            mediaCodecCreateEncoderByType.stop();
                            mediaCodecCreateEncoderByType.release();
                            throw th;
                        }
                    }
                }
                if (z7) {
                    bufferInfo.presentationTimeUs = ((long) i6) + j3;
                    v61.h("VideoProcessor", "video 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                    z7 = false;
                }
                if (bufferInfo.flags != 2) {
                    j3 = bufferInfo.presentationTimeUs;
                }
                v61.v("VideoProcessor", "video writeSampleData:" + bufferInfo.presentationTimeUs + " type:" + bufferInfo.flags + " size:" + bufferInfo.size, new Object[0]);
                int i7 = i4;
                mediaMuxer.writeSampleData(i7, byteBufferAllocateDirect2, bufferInfo);
                mediaExtractor3.advance();
                i4 = i7;
                mediaCodecCreateEncoderByType = mediaCodecCreateEncoderByType;
            }
            file2.delete();
            file3.delete();
            file4.delete();
            try {
                mediaExtractor2.release();
                mediaExtractor3.release();
                mediaMuxer.release();
                mediaCodecCreateEncoderByType.stop();
                mediaCodecCreateEncoderByType.release();
            } catch (Exception e2) {
                v61.g(e2);
            }
        } catch (Throwable th12) {
            th = th12;
            mediaCodecCreateEncoderByType = mediaCodecCreateEncoderByType;
        }
    }

    public static void b(Context context, Uri uri, String str, float f) throws Exception {
        f(context).v(uri).A(str).D(f).B();
    }

    public static void c(Context context, Uri uri, String str, int i, int i2) throws Exception {
        f(context).v(uri).A(str).E(i).s(i2).B();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x04b5 A[Catch: all -> 0x05a6, TryCatch #2 {all -> 0x05a6, blocks: (B:95:0x04a7, B:100:0x04b5, B:102:0x04d3, B:104:0x04ef, B:108:0x0504, B:112:0x053d, B:114:0x0547, B:118:0x0570, B:119:0x058e, B:121:0x0593, B:122:0x0595), top: B:184:0x04a7 }] */
    /* JADX WARN: Code duplicated, block: B:101:0x04d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x04d3 A[Catch: all -> 0x05a6, TryCatch #2 {all -> 0x05a6, blocks: (B:95:0x04a7, B:100:0x04b5, B:102:0x04d3, B:104:0x04ef, B:108:0x0504, B:112:0x053d, B:114:0x0547, B:118:0x0570, B:119:0x058e, B:121:0x0593, B:122:0x0595), top: B:184:0x04a7 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x04ef A[Catch: all -> 0x05a6, TryCatch #2 {all -> 0x05a6, blocks: (B:95:0x04a7, B:100:0x04b5, B:102:0x04d3, B:104:0x04ef, B:108:0x0504, B:112:0x053d, B:114:0x0547, B:118:0x0570, B:119:0x058e, B:121:0x0593, B:122:0x0595), top: B:184:0x04a7 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x0504 A[Catch: all -> 0x05a6, TryCatch #2 {all -> 0x05a6, blocks: (B:95:0x04a7, B:100:0x04b5, B:102:0x04d3, B:104:0x04ef, B:108:0x0504, B:112:0x053d, B:114:0x0547, B:118:0x0570, B:119:0x058e, B:121:0x0593, B:122:0x0595), top: B:184:0x04a7 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x056a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0570 A[Catch: all -> 0x05a6, TryCatch #2 {all -> 0x05a6, blocks: (B:95:0x04a7, B:100:0x04b5, B:102:0x04d3, B:104:0x04ef, B:108:0x0504, B:112:0x053d, B:114:0x0547, B:118:0x0570, B:119:0x058e, B:121:0x0593, B:122:0x0595), top: B:184:0x04a7 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0593 A[Catch: all -> 0x05a6, TryCatch #2 {all -> 0x05a6, blocks: (B:95:0x04a7, B:100:0x04b5, B:102:0x04d3, B:104:0x04ef, B:108:0x0504, B:112:0x053d, B:114:0x0547, B:118:0x0570, B:119:0x058e, B:121:0x0593, B:122:0x0595), top: B:184:0x04a7 }] */
    /* JADX WARN: Code duplicated, block: B:199:0x04ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:0x04f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x04b2  */
    /* JADX WARN: Instruction removed from duplicated block: B:100:0x04b5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:102:0x04d3, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:108:0x0504, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:118:0x0570, please report this as an issue */
    public static void d(Context context, c cVar, c cVar2, String str, Integer num, Integer num2, int i, int i2, float f, float f2) throws Throwable {
        int iIntValue;
        File file;
        int i3;
        MediaMuxer mediaMuxer;
        File file2;
        File file3;
        float f3;
        String str2;
        int iIntValue2;
        File file4;
        int iIntValue3;
        int iAddTrack;
        int i4;
        File file5;
        File file6;
        File file7;
        MediaExtractor mediaExtractor;
        Throwable th;
        File file8;
        boolean z;
        int iDequeueOutputBuffer;
        boolean z2;
        float f4;
        File file9;
        File file10 = new File(context.getCacheDir(), "pcm");
        file10.mkdir();
        File file11 = new File(file10, "video_" + System.currentTimeMillis() + ".pcm");
        File file12 = new File(file10, "aac_" + System.currentTimeMillis() + ".pcm");
        Integer numValueOf = Integer.valueOf(num == null ? 0 : num.intValue() * 1000);
        Integer numValueOf2 = num2 == null ? null : Integer.valueOf(num2.intValue() * 1000);
        if (numValueOf2 == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            cVar.b(mediaMetadataRetriever);
            iIntValue = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        } else {
            iIntValue = (numValueOf2.intValue() - numValueOf.intValue()) / 1000;
        }
        int i5 = iIntValue;
        MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
        cVar2.b(mediaMetadataRetriever2);
        int i6 = Integer.parseInt(mediaMetadataRetriever2.extractMetadata(9));
        mediaMetadataRetriever2.release();
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        cVar.a(mediaExtractor2);
        int iM = np9.m(mediaExtractor2, true);
        MediaExtractor mediaExtractor3 = new MediaExtractor();
        cVar2.a(mediaExtractor3);
        int iM2 = np9.m(mediaExtractor3, true);
        int iM3 = np9.m(mediaExtractor2, false);
        MediaFormat trackFormat = mediaExtractor2.getTrackFormat(iM3);
        int integer = trackFormat.containsKey("rotation-degrees") ? trackFormat.getInteger("rotation-degrees") : 0;
        MediaExtractor mediaExtractor4 = mediaExtractor2;
        MediaMuxer mediaMuxer2 = new MediaMuxer(str, 0);
        mediaMuxer2.setOrientationHint(integer);
        int iAddTrack2 = mediaMuxer2.addTrack(trackFormat);
        if (iM >= 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            CountDownLatch countDownLatch = new CountDownLatch(2);
            new Thread(new a(cVar, file11, numValueOf, numValueOf2, countDownLatch)).start();
            new Thread(new b(cVar2, file12, i6, i5, countDownLatch)).start();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Pair<Integer, Integer> pairC = gg0.c(file11.getAbsolutePath(), file12.getAbsolutePath(), mediaExtractor4.getTrackFormat(iM), mediaExtractor3.getTrackFormat(iM2));
            iIntValue3 = ((Integer) pairC.first).intValue();
            iIntValue2 = ((Integer) pairC.second).intValue();
            mediaExtractor3.release();
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            if (f17443a) {
                file12 = gg0.d(file12, i6, i5);
            }
            file4 = new File(file10, "adjusted_" + System.currentTimeMillis() + ".pcm");
            gg0.m(file11.getAbsolutePath(), file12.getAbsolutePath(), file4.getAbsolutePath(), i, i2);
            file3 = new File(context.getCacheDir(), file4.getName() + FileTypes.B);
            long jCurrentTimeMillis4 = System.currentTimeMillis();
            int i7 = iIntValue3 == 2 ? 12 : 16;
            if (f == 0.0f) {
                file = file11;
                f4 = f2;
                file9 = file12;
                if (f4 != 0.0f) {
                }
                new nn6(iIntValue2, i7, iIntValue3, 2).a(file4.getAbsolutePath(), file3.getAbsolutePath());
                v61.h("hwLog", String.format("decode:%dms,resample:%dms,mix:%dms,fade:%dms", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis2), Long.valueOf(jCurrentTimeMillis4 - jCurrentTimeMillis3), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis4)), new Object[0]);
                MediaFormat trackFormat2 = mediaExtractor4.getTrackFormat(iM);
                int iJ = gg0.j(trackFormat2);
                trackFormat2.setString("mime", "audio/mp4a-latm");
                gg0.e(trackFormat2, 2, iIntValue2, iIntValue3);
                iAddTrack = mediaMuxer2.addTrack(trackFormat2);
                file12 = file9;
                i4 = iJ;
                mediaMuxer = mediaMuxer2;
                str2 = "audio/mp4a-latm";
                i3 = iM;
                mediaExtractor4 = mediaExtractor4;
            } else {
                file = file11;
                f4 = f2;
                file9 = file12;
            }
            te0.a(file4.getAbsolutePath(), iIntValue2, iIntValue3, f, f4);
            new nn6(iIntValue2, i7, iIntValue3, 2).a(file4.getAbsolutePath(), file3.getAbsolutePath());
            v61.h("hwLog", String.format("decode:%dms,resample:%dms,mix:%dms,fade:%dms", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis2), Long.valueOf(jCurrentTimeMillis4 - jCurrentTimeMillis3), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis4)), new Object[0]);
            MediaFormat trackFormat3 = mediaExtractor4.getTrackFormat(iM);
            int iJ2 = gg0.j(trackFormat3);
            trackFormat3.setString("mime", "audio/mp4a-latm");
            gg0.e(trackFormat3, 2, iIntValue2, iIntValue3);
            iAddTrack = mediaMuxer2.addTrack(trackFormat3);
            file12 = file9;
            i4 = iJ2;
            mediaMuxer = mediaMuxer2;
            str2 = "audio/mp4a-latm";
            i3 = iM;
            mediaExtractor4 = mediaExtractor4;
        } else {
            file = file11;
            i3 = iM;
            mediaMuxer = mediaMuxer2;
            gg0.h(cVar2, file12.getAbsolutePath(), 0, Integer.valueOf(i6 > i5 ? i5 * 1000 : i6 * 1000));
            MediaFormat trackFormat4 = mediaExtractor3.getTrackFormat(iM2);
            int iJ3 = gg0.j(trackFormat4);
            gg0.e(trackFormat4, 2, trackFormat4.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE) ? trackFormat4.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE) : i.K, trackFormat4.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) ? trackFormat4.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) : 1);
            trackFormat4.setString("mime", "audio/mp4a-latm");
            int iAddTrack3 = mediaMuxer.addTrack(trackFormat4);
            int integer2 = trackFormat4.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
            int integer3 = trackFormat4.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) ? trackFormat4.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) : 1;
            if (integer3 > 2) {
                File file13 = new File(file12 + ".channel");
                gg0.t(file12.getAbsolutePath(), file13.getAbsolutePath(), integer3);
                file12.delete();
                file12 = file13;
                integer3 = 1;
            }
            if (i2 != 50) {
                file2 = new File(file10, "adjusted_" + System.currentTimeMillis() + ".pcm");
                gg0.b(file12.getAbsolutePath(), file2.getAbsolutePath(), i2);
            } else {
                file2 = file12;
            }
            int i8 = integer3 == 2 ? 12 : 16;
            file3 = new File(context.getCacheDir(), file2.getName() + FileTypes.B);
            if (f == 0.0f) {
                f3 = f2;
                str2 = "audio/mp4a-latm";
                if (f3 != 0.0f) {
                }
                new nn6(integer2, i8, integer3, 2).a(file2.getAbsolutePath(), file3.getAbsolutePath());
                iIntValue2 = integer2;
                file4 = file2;
                iIntValue3 = integer3;
                iAddTrack = iAddTrack3;
                i4 = iJ3;
            } else {
                f3 = f2;
                str2 = r12;
            }
            te0.a(file2.getAbsolutePath(), integer2, integer3, f, f3);
            new nn6(integer2, i8, integer3, 2).a(file2.getAbsolutePath(), file3.getAbsolutePath());
            iIntValue2 = integer2;
            file4 = file2;
            iIntValue3 = integer3;
            iAddTrack = iAddTrack3;
            i4 = iJ3;
        }
        mediaMuxer.start();
        MediaExtractor mediaExtractor5 = new MediaExtractor();
        mediaExtractor5.setDataSource(file3.getAbsolutePath());
        int iM4 = np9.m(mediaExtractor5, true);
        mediaExtractor5.selectTrack(iM4);
        int iK = gg0.k(mediaExtractor5.getTrackFormat(iM4));
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iK);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(str2, iIntValue2, iIntValue3);
        mediaFormatCreateAudioFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, i4);
        mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
        String str3 = "max-input-size";
        mediaFormatCreateAudioFormat.setInteger("max-input-size", iK);
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(str2);
        mediaCodecCreateEncoderByType.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        mediaCodecCreateEncoderByType.start();
        int i9 = 1024000000 / iIntValue2;
        long j = -1;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (!z3) {
            file5 = file4;
            file6 = file3;
            try {
                int iDequeueInputBuffer = mediaCodecCreateEncoderByType.dequeueInputBuffer(com.ipd.dsp.internal.v1.b.C0923b.f);
                if (z4 || iDequeueInputBuffer < 0) {
                    file8 = file12;
                } else {
                    try {
                        long sampleTime = mediaExtractor5.getSampleTime();
                        if (sampleTime < 0) {
                            mediaCodecCreateEncoderByType.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                            z3 = z3;
                            byteBufferAllocateDirect = byteBufferAllocateDirect;
                            file7 = file12;
                            z = true;
                        } else {
                            int sampleFlags = mediaExtractor5.getSampleFlags();
                            byteBufferAllocateDirect.clear();
                            int sampleData = mediaExtractor5.readSampleData(byteBufferAllocateDirect, 0);
                            ByteBuffer inputBuffer = mediaCodecCreateEncoderByType.getInputBuffer(iDequeueInputBuffer);
                            inputBuffer.clear();
                            inputBuffer.put(byteBufferAllocateDirect);
                            inputBuffer.position(0);
                            StringBuilder sb = new StringBuilder();
                            sb.append("audio queuePcmBuffer ");
                            file8 = file12;
                            try {
                                sb.append(sampleTime / 1000);
                                sb.append(" size:");
                                sb.append(sampleData);
                                v61.n("VideoProcessor", sb.toString(), new Object[0]);
                                mediaCodecCreateEncoderByType.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, sampleTime, sampleFlags);
                                mediaExtractor5.advance();
                            } catch (Throwable th2) {
                                th = th2;
                                file7 = file8;
                                mediaExtractor = mediaExtractor4;
                                file7.delete();
                                file.delete();
                                file5.delete();
                                file6.delete();
                                try {
                                    mediaExtractor5.release();
                                    mediaExtractor.release();
                                    mediaCodecCreateEncoderByType.stop();
                                    mediaCodecCreateEncoderByType.release();
                                    mediaMuxer.release();
                                    throw th;
                                } catch (Exception e2) {
                                    v61.g(e2);
                                    throw th;
                                }
                            }
                        }
                        while (true) {
                            try {
                                iDequeueOutputBuffer = mediaCodecCreateEncoderByType.dequeueOutputBuffer(bufferInfo, com.ipd.dsp.internal.v1.b.C0923b.f);
                                if (iDequeueOutputBuffer == -1) {
                                    z3 = z3;
                                    break;
                                }
                                if (iDequeueOutputBuffer == -2) {
                                    v61.n("VideoProcessor", "audio decode newFormat = " + mediaCodecCreateEncoderByType.getOutputFormat(), new Object[0]);
                                } else {
                                    if (iDequeueOutputBuffer < 0) {
                                        v61.h("VideoProcessor", "unexpected result from audio decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer, new Object[0]);
                                    } else {
                                        if (bufferInfo.flags == 4) {
                                            z3 = true;
                                            break;
                                        }
                                        ByteBuffer outputBuffer = mediaCodecCreateEncoderByType.getOutputBuffer(iDequeueOutputBuffer);
                                        v61.n("VideoProcessor", "audio writeSampleData " + bufferInfo.presentationTimeUs + " size:" + bufferInfo.size + " flags:" + bufferInfo.flags, new Object[0]);
                                        if (z5 && j != -1) {
                                            if (bufferInfo.presentationTimeUs < ((long) i9) + j) {
                                                v61.h("VideoProcessor", "audio 时间戳错误，lastAudioFrameTimeUs:" + j + " info.presentationTimeUs:" + bufferInfo.presentationTimeUs, new Object[0]);
                                                z2 = true;
                                            }
                                            if (z2) {
                                                bufferInfo.presentationTimeUs = ((long) i9) + j;
                                                v61.h("VideoProcessor", "audio 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                                                z2 = false;
                                            }
                                            if (bufferInfo.flags != 2) {
                                                j = bufferInfo.presentationTimeUs;
                                            }
                                            mediaMuxer.writeSampleData(iAddTrack, outputBuffer, bufferInfo);
                                            outputBuffer.clear();
                                            mediaCodecCreateEncoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
                                            z5 = z2;
                                        }
                                        if (z2) {
                                            bufferInfo.presentationTimeUs = ((long) i9) + j;
                                            v61.h("VideoProcessor", "audio 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                                            z2 = false;
                                        }
                                        if (bufferInfo.flags != 2) {
                                            j = bufferInfo.presentationTimeUs;
                                        }
                                        mediaMuxer.writeSampleData(iAddTrack, outputBuffer, bufferInfo);
                                        outputBuffer.clear();
                                        mediaCodecCreateEncoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
                                        z5 = z2;
                                    }
                                    str3 = str3;
                                }
                                str3 = str3;
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                                mediaExtractor = mediaExtractor4;
                                file7.delete();
                                file.delete();
                                file5.delete();
                                file6.delete();
                                mediaExtractor5.release();
                                mediaExtractor.release();
                                mediaCodecCreateEncoderByType.stop();
                                mediaCodecCreateEncoderByType.release();
                                mediaMuxer.release();
                                throw th;
                            }
                        }
                        file12 = file7;
                        z4 = z;
                        j = j;
                        byteBufferAllocateDirect = byteBufferAllocateDirect;
                        file4 = file5;
                        file3 = file6;
                    } catch (Throwable th4) {
                        th = th4;
                        file7 = file12;
                    }
                }
                file7 = file8;
                z = z4;
                z5 = z5;
                while (true) {
                    iDequeueOutputBuffer = mediaCodecCreateEncoderByType.dequeueOutputBuffer(bufferInfo, com.ipd.dsp.internal.v1.b.C0923b.f);
                    if (iDequeueOutputBuffer == -1) {
                        z3 = z3;
                        break;
                        break;
                    }
                    if (iDequeueOutputBuffer == -2) {
                        v61.n("VideoProcessor", "audio decode newFormat = " + mediaCodecCreateEncoderByType.getOutputFormat(), new Object[0]);
                    } else {
                        if (iDequeueOutputBuffer < 0) {
                            v61.h("VideoProcessor", "unexpected result from audio decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer, new Object[0]);
                        } else {
                            if (bufferInfo.flags == 4) {
                                z3 = true;
                                break;
                                break;
                            }
                            ByteBuffer outputBuffer2 = mediaCodecCreateEncoderByType.getOutputBuffer(iDequeueOutputBuffer);
                            v61.n("VideoProcessor", "audio writeSampleData " + bufferInfo.presentationTimeUs + " size:" + bufferInfo.size + " flags:" + bufferInfo.flags, new Object[0]);
                            z2 = z5 ? z5 : z5;
                            if (z2) {
                                bufferInfo.presentationTimeUs = ((long) i9) + j;
                                v61.h("VideoProcessor", "audio 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                                z2 = false;
                            }
                            if (bufferInfo.flags != 2) {
                                j = bufferInfo.presentationTimeUs;
                            }
                            mediaMuxer.writeSampleData(iAddTrack, outputBuffer2, bufferInfo);
                            outputBuffer2.clear();
                            mediaCodecCreateEncoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
                            z5 = z2;
                        }
                        str3 = str3;
                    }
                    str3 = str3;
                }
                file12 = file7;
                z4 = z;
                j = j;
                byteBufferAllocateDirect = byteBufferAllocateDirect;
                file4 = file5;
                file3 = file6;
            } catch (Throwable th5) {
                th = th5;
                file7 = file12;
            }
        }
        String str4 = str3;
        file5 = file4;
        file6 = file3;
        file7 = file12;
        if (i3 >= 0) {
            mediaExtractor = mediaExtractor4;
            try {
                mediaExtractor.unselectTrack(i3);
            } catch (Throwable th6) {
                th = th6;
                file7.delete();
                file.delete();
                file5.delete();
                file6.delete();
                mediaExtractor5.release();
                mediaExtractor.release();
                mediaCodecCreateEncoderByType.stop();
                mediaCodecCreateEncoderByType.release();
                mediaMuxer.release();
                throw th;
            }
        } else {
            mediaExtractor = mediaExtractor4;
        }
        mediaExtractor.selectTrack(iM3);
        mediaExtractor.seekTo(numValueOf.intValue(), 0);
        int integer4 = trackFormat.getInteger(str4);
        int integer5 = trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : (int) Math.ceil(np9.c(cVar));
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(integer4);
        int i10 = (int) (1000000.0f / integer5);
        long j2 = -1;
        boolean z6 = false;
        while (true) {
            long sampleTime2 = mediaExtractor.getSampleTime();
            if (sampleTime2 == -1) {
                break;
            }
            if (sampleTime2 >= numValueOf.intValue()) {
                if (numValueOf2 != null && sampleTime2 > numValueOf2.intValue()) {
                    break;
                }
                bufferInfo.presentationTimeUs = sampleTime2 - ((long) numValueOf.intValue());
                bufferInfo.flags = mediaExtractor.getSampleFlags();
                int sampleData2 = mediaExtractor.readSampleData(byteBufferAllocateDirect2, 0);
                bufferInfo.size = sampleData2;
                if (sampleData2 < 0) {
                    break;
                }
                if (!z6 && j2 != -1 && bufferInfo.presentationTimeUs < ((long) i10) + j2) {
                    v61.h("VideoProcessor", "video 时间戳错误，lastVideoFrameTimeUs:" + j2 + " info.presentationTimeUs:" + bufferInfo.presentationTimeUs + " VIDEO_FRAME_TIME_US:" + i10, new Object[0]);
                    z6 = true;
                }
                if (z6) {
                    bufferInfo.presentationTimeUs = ((long) i10) + j2;
                    v61.h("VideoProcessor", "video 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                    z6 = false;
                }
                if (bufferInfo.flags != 2) {
                    j2 = bufferInfo.presentationTimeUs;
                }
                v61.v("VideoProcessor", "video writeSampleData:" + bufferInfo.presentationTimeUs + " type:" + bufferInfo.flags + " size:" + bufferInfo.size, new Object[0]);
                int i11 = iAddTrack2;
                mediaMuxer.writeSampleData(i11, byteBufferAllocateDirect2, bufferInfo);
                mediaExtractor.advance();
                iAddTrack2 = i11;
            } else {
                mediaExtractor.advance();
            }
        }
        file7.delete();
        file.delete();
        file5.delete();
        file6.delete();
        try {
            mediaExtractor5.release();
            mediaExtractor.release();
            mediaCodecCreateEncoderByType.stop();
            mediaCodecCreateEncoderByType.release();
            mediaMuxer.release();
        } catch (Exception e3) {
            v61.g(e3);
        }
    }

    public static void e(@NotNull Context context, @NotNull d dVar) throws Exception {
        int i;
        int i2;
        char c2;
        MediaMuxer mediaMuxer;
        Integer num;
        int iAddTrack;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        dVar.f17453a.b(mediaMetadataRetriever);
        int iIntValue = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        int iIntValue2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        int i3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
        int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        int iIntValue3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        mediaMetadataRetriever.release();
        if (dVar.e == null) {
            dVar.e = Integer.valueOf(i4);
        }
        if (dVar.g == null) {
            dVar.g = 1;
        }
        if (dVar.f17456a != null) {
            iIntValue = dVar.f17456a.intValue();
        }
        if (dVar.b != null) {
            iIntValue2 = dVar.b.intValue();
        }
        if (iIntValue % 2 != 0) {
            iIntValue++;
        }
        if (iIntValue2 % 2 != 0) {
            iIntValue2++;
        }
        if (i3 == 90 || i3 == 270) {
            i = iIntValue;
            i2 = iIntValue2;
        } else {
            i2 = iIntValue;
            i = iIntValue2;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        dVar.f17453a.a(mediaExtractor);
        int iM = np9.m(mediaExtractor, false);
        int iM2 = np9.m(mediaExtractor, true);
        MediaMuxer mediaMuxer2 = new MediaMuxer(dVar.f17457a, 0);
        boolean zBooleanValue = dVar.f17454a == null ? true : dVar.f17454a.booleanValue();
        Integer numValueOf = dVar.d;
        if (iM2 >= 0) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(iM2);
            int iJ = gg0.j(trackFormat);
            int integer = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
            int integer2 = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
            int iK = gg0.k(trackFormat);
            MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", integer2, integer);
            mediaFormatCreateAudioFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, iJ);
            mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
            mediaFormatCreateAudioFormat.setInteger("max-input-size", iK);
            if (!zBooleanValue) {
                mediaMuxer2 = mediaMuxer2;
                long jFloatValue = iIntValue3 * 1000;
                long j = trackFormat.getLong("durationUs");
                if (dVar.c != null || dVar.d != null || dVar.f17455a != null) {
                    if (dVar.c != null && dVar.d != null) {
                        jFloatValue = (dVar.d.intValue() - dVar.c.intValue()) * 1000;
                    }
                    if (dVar.f17455a != null) {
                        jFloatValue = (long) (jFloatValue / dVar.f17455a.floatValue());
                    }
                    if (jFloatValue >= j) {
                        jFloatValue = j;
                    }
                    mediaFormatCreateAudioFormat.setLong("durationUs", jFloatValue);
                    numValueOf = Integer.valueOf((dVar.c == null ? 0 : dVar.c.intValue()) + ((int) (jFloatValue / 1000)));
                }
            } else if (dVar.c == null && dVar.d == null && dVar.f17455a == null) {
                mediaMuxer2 = mediaMuxer2;
            } else {
                long jFloatValue2 = (dVar.c == null || dVar.d == null) ? trackFormat.getLong("durationUs") : (dVar.d.intValue() - dVar.c.intValue()) * 1000;
                if (dVar.f17455a != null) {
                    jFloatValue2 = (long) (jFloatValue2 / dVar.f17455a.floatValue());
                }
                mediaFormatCreateAudioFormat.setLong("durationUs", jFloatValue2);
            }
            c2 = 2;
            gg0.e(mediaFormatCreateAudioFormat, 2, integer2, integer);
            mediaMuxer = mediaMuxer2;
            iAddTrack = mediaMuxer.addTrack(mediaFormatCreateAudioFormat);
            num = numValueOf;
        } else {
            c2 = 2;
            mediaMuxer = mediaMuxer2;
            num = numValueOf;
            iAddTrack = 0;
        }
        mediaExtractor.selectTrack(iM);
        if (dVar.c != null) {
            mediaExtractor.seekTo(dVar.c.intValue() * 1000, 0);
        } else {
            mediaExtractor.seekTo(0L, 0);
        }
        ko9 ko9Var = new ko9(dVar.f17452a);
        ko9Var.d(dVar.f17455a);
        ko9Var.e(dVar.c == null ? 0 : dVar.c.intValue());
        if (dVar.d != null) {
            iIntValue3 = dVar.d.intValue();
        }
        ko9Var.c(iIntValue3);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        en9 en9Var = new en9(mediaExtractor, mediaMuxer, dVar.e.intValue(), i2, i, dVar.g.intValue(), dVar.f == null ? f42631a : dVar.f.intValue(), iM, atomicBoolean, countDownLatch);
        int iE = np9.e(dVar.f17453a);
        if (iE <= 0) {
            iE = (int) Math.ceil(np9.c(dVar.f17453a));
        }
        bn9 bn9Var = new bn9(en9Var, mediaExtractor, dVar.c, dVar.d, Integer.valueOf(iE), Integer.valueOf(dVar.f == null ? f42631a : dVar.f.intValue()), dVar.f17455a, dVar.f17458a, iM, atomicBoolean);
        xe0 xe0Var = new xe0(context, dVar.f17453a, mediaMuxer, dVar.c, num, zBooleanValue ? dVar.f17455a : null, iAddTrack, countDownLatch);
        en9Var.f(ko9Var);
        xe0Var.d(ko9Var);
        bn9Var.start();
        en9Var.start();
        xe0Var.start();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            bn9Var.join();
            en9Var.join();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            xe0Var.join();
            v61.t(String.format("编解码:%dms,音频:%dms", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)), new Object[0]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mediaMuxer.release();
            mediaExtractor.release();
        } catch (Exception e2) {
            v61.g(e2);
        }
        if (en9Var.d() != null) {
            throw en9Var.d();
        }
        if (bn9Var.c() != null) {
            throw bn9Var.c();
        }
        if (xe0Var.c() != null) {
            throw xe0Var.c();
        }
    }

    public static d f(Context context) {
        return new d(context);
    }

    public static void g(Context context, c cVar, String str, boolean z, @Nullable VideoProgressListener videoProgressListener) throws Exception {
        File file = new File(context.getCacheDir(), System.currentTimeMillis() + ".temp");
        File file2 = new File(context.getCacheDir(), System.currentTimeMillis() + ".temp2");
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            cVar.a(mediaExtractor);
            mediaExtractor.selectTrack(np9.m(mediaExtractor, false));
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int i2 = 0;
            while (true) {
                int sampleFlags = mediaExtractor.getSampleFlags();
                if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                    i++;
                }
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime < 0) {
                    break;
                }
                arrayList.add(Long.valueOf(sampleTime));
                i2++;
                mediaExtractor.advance();
            }
            mediaExtractor.release();
            if (i2 == i || i2 == i + 1) {
                i(cVar, str, z, arrayList, videoProgressListener);
            } else {
                int i3 = 1;
                wn9 wn9Var = new wn9(new float[]{0.45f, 0.1f, 0.45f}, videoProgressListener);
                wn9Var.a(0);
                float f = i;
                float f2 = ((i2 - i) / f) + 1.0f;
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                cVar.b(mediaMetadataRetriever);
                int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
                int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                try {
                    f(context).w(cVar).A(file.getAbsolutePath()).p((int) (i4 * f2)).u(0).C(wn9Var).B();
                } catch (MediaCodec.CodecException e) {
                    v61.g(e);
                    f(context).w(cVar).A(file.getAbsolutePath()).p((int) (i4 * f2)).u(-1).C(wn9Var).B();
                }
                wn9Var.a(1);
                i(new c(file.getAbsolutePath()), file2.getAbsolutePath(), z, null, wn9Var);
                int i6 = (int) (f / (i5 / 1000.0f));
                if (i6 != 0) {
                    i3 = i6;
                }
                wn9Var.a(2);
                f(context).x(file2.getAbsolutePath()).A(str).p(i4).u(i3).C(wn9Var).B();
            }
            file.delete();
            file2.delete();
        } catch (Throwable th) {
            file.delete();
            file2.delete();
            throw th;
        }
    }

    public static void h(c cVar, String str, boolean z) throws IOException {
        i(cVar, str, z, null, null);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x01ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:39:0x0109 A[Catch: all -> 0x01f3, Exception -> 0x01f5, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x010e A[Catch: all -> 0x01f3, Exception -> 0x01f5, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0119  */
    /* JADX WARN: Code duplicated, block: B:48:0x012e A[Catch: all -> 0x01f3, Exception -> 0x01f5, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0139 A[Catch: all -> 0x01f3, Exception -> 0x01f5, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0149 A[Catch: all -> 0x01f3, Exception -> 0x01f5, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x015f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0176 A[Catch: all -> 0x01f3, Exception -> 0x01f5, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x017b A[Catch: all -> 0x01f3, Exception -> 0x01f5, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0188  */
    /* JADX WARN: Code duplicated, block: B:64:0x0191  */
    /* JADX WARN: Code duplicated, block: B:66:0x0198 A[Catch: all -> 0x01f3, Exception -> 0x01f5, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01a7 A[Catch: all -> 0x01f3, Exception -> 0x01f5, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01bb A[Catch: all -> 0x01f3, Exception -> 0x01f5, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01c0 A[Catch: all -> 0x01f3, Exception -> 0x01f5, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:81:0x01da A[Catch: all -> 0x01f3, Exception -> 0x01f5, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01e0 A[Catch: all -> 0x01f3, Exception -> 0x01f5, TRY_LEAVE, TryCatch #1 {Exception -> 0x01f5, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0193, B:66:0x0198, B:67:0x019e, B:70:0x01a7, B:73:0x01bb, B:75:0x01c0, B:78:0x01ce, B:79:0x01d4, B:81:0x01da, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e0), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x012c A[EDGE_INSN: B:96:0x012c->B:47:0x012c BREAK  A[LOOP:0: B:33:0x00e8->B:83:0x01ec], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x0175 A[SYNTHETIC] */
    public static void i(c cVar, String str, boolean z, List<Long> list, @Nullable VideoProgressListener videoProgressListener) throws IOException {
        long j;
        int iAddTrack;
        long j2;
        int i;
        long j3;
        long j4;
        long sampleTime;
        float f;
        List<Long> listF;
        int size;
        long j5;
        long sampleTime2;
        long j6;
        float f2;
        long j7;
        long sampleTime3;
        long j8;
        long j9;
        float f3;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        cVar.b(mediaMetadataRetriever);
        int i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        mediaMetadataRetriever.release();
        MediaExtractor mediaExtractor = new MediaExtractor();
        cVar.a(mediaExtractor);
        int iM = np9.m(mediaExtractor, false);
        int iM2 = np9.m(mediaExtractor, true);
        boolean z2 = iM2 >= 0;
        MediaMuxer mediaMuxer = new MediaMuxer(str, 0);
        mediaExtractor.selectTrack(iM);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(iM);
        long j10 = trackFormat.getLong("durationUs");
        int iAddTrack2 = mediaMuxer.addTrack(trackFormat);
        if (z2) {
            MediaFormat trackFormat2 = mediaExtractor.getTrackFormat(iM2);
            iAddTrack = mediaMuxer.addTrack(trackFormat2);
            j = trackFormat2.getLong("durationUs");
        } else {
            j = 0;
            iAddTrack = 0;
        }
        mediaMuxer.start();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
        np9.l(mediaExtractor, iM, i2);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        List<Long> list2 = list;
        try {
            if (list2 != null) {
                try {
                    if (list.size() > 0) {
                        int size2 = list.size() - 1;
                        long j11 = -1;
                        while (true) {
                            if (size2 < 0) {
                                j2 = j;
                                break;
                            }
                            j2 = j;
                            mediaExtractor.seekTo(list2.get(size2).longValue(), 2);
                            long sampleTime4 = mediaExtractor.getSampleTime();
                            if (j11 == -1) {
                                j11 = sampleTime4;
                            }
                            bufferInfo.presentationTimeUs = j11 - sampleTime4;
                            bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                            bufferInfo.flags = mediaExtractor.getSampleFlags();
                            if (bufferInfo.size < 0) {
                                break;
                            }
                            mediaMuxer.writeSampleData(iAddTrack2, byteBufferAllocateDirect, bufferInfo);
                            if (videoProgressListener != null) {
                                float f4 = bufferInfo.presentationTimeUs / j10;
                                if (f4 > 1.0f) {
                                    f4 = 1.0f;
                                }
                                videoProgressListener.onProgress(f4 * 0.7f);
                            }
                            size2--;
                            list2 = list;
                            j = j2;
                        }
                        i = iM2;
                    } else {
                        j2 = j;
                        j7 = -1;
                        while (true) {
                            sampleTime3 = mediaExtractor.getSampleTime();
                            i = iM2;
                            if (j7 == -1) {
                                j7 = sampleTime3;
                            }
                            bufferInfo.presentationTimeUs = j7 - sampleTime3;
                            bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                            bufferInfo.flags = mediaExtractor.getSampleFlags();
                            if (bufferInfo.size >= 0) {
                                mediaMuxer.writeSampleData(iAddTrack2, byteBufferAllocateDirect, bufferInfo);
                                if (videoProgressListener != null) {
                                    f3 = bufferInfo.presentationTimeUs / j10;
                                    if (f3 > 1.0f) {
                                        f3 = 1.0f;
                                    }
                                    videoProgressListener.onProgress(f3 * 0.7f);
                                }
                                j8 = sampleTime3 - 10000;
                                j9 = j7;
                                j3 = 0;
                                if (j8 <= 0) {
                                    break;
                                }
                                long j12 = j2;
                                mediaExtractor.seekTo(j8, 0);
                                iM2 = i;
                                j2 = j12;
                                j7 = j9;
                            }
                        }
                        if (z2) {
                            mediaExtractor.unselectTrack(iM);
                            mediaExtractor.selectTrack(i);
                            if (z) {
                                listF = np9.f(mediaExtractor);
                                size = listF.size() - 1;
                                j5 = -1;
                                while (size >= 0) {
                                    mediaExtractor.seekTo(listF.get(size).longValue(), 2);
                                    sampleTime2 = mediaExtractor.getSampleTime();
                                    if (j5 == -1) {
                                        j5 = sampleTime2;
                                    }
                                    bufferInfo.presentationTimeUs = j5 - sampleTime2;
                                    bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                                    bufferInfo.flags = mediaExtractor.getSampleFlags();
                                    if (bufferInfo.size < 0) {
                                        break;
                                    }
                                    mediaMuxer.writeSampleData(iAddTrack, byteBufferAllocateDirect, bufferInfo);
                                    if (videoProgressListener != null) {
                                        j6 = j2;
                                        f2 = bufferInfo.presentationTimeUs / j6;
                                        if (f2 > 1.0f) {
                                            f2 = 1.0f;
                                        }
                                        videoProgressListener.onProgress((f2 * 0.3f) + 0.7f);
                                    } else {
                                        j6 = j2;
                                    }
                                    size--;
                                    j2 = j6;
                                }
                            } else {
                                j4 = j2;
                                mediaExtractor.seekTo(j3, 2);
                                while (true) {
                                    sampleTime = mediaExtractor.getSampleTime();
                                    if (sampleTime == -1) {
                                        break;
                                    }
                                    bufferInfo.presentationTimeUs = sampleTime;
                                    bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                                    bufferInfo.flags = mediaExtractor.getSampleFlags();
                                    if (bufferInfo.size < 0) {
                                        break;
                                    }
                                    mediaMuxer.writeSampleData(iAddTrack, byteBufferAllocateDirect, bufferInfo);
                                    if (videoProgressListener != null) {
                                        f = bufferInfo.presentationTimeUs / j4;
                                        if (f > 1.0f) {
                                            f = 1.0f;
                                        }
                                        videoProgressListener.onProgress((f * 0.3f) + 0.7f);
                                    }
                                    mediaExtractor.advance();
                                }
                            }
                        }
                        if (videoProgressListener != null) {
                            videoProgressListener.onProgress(1.0f);
                        }
                    }
                    j3 = 0;
                    if (z2) {
                        mediaExtractor.unselectTrack(iM);
                        mediaExtractor.selectTrack(i);
                        if (z) {
                            listF = np9.f(mediaExtractor);
                            size = listF.size() - 1;
                            j5 = -1;
                            while (size >= 0) {
                                mediaExtractor.seekTo(listF.get(size).longValue(), 2);
                                sampleTime2 = mediaExtractor.getSampleTime();
                                if (j5 == -1) {
                                    j5 = sampleTime2;
                                }
                                bufferInfo.presentationTimeUs = j5 - sampleTime2;
                                bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                                bufferInfo.flags = mediaExtractor.getSampleFlags();
                                if (bufferInfo.size < 0) {
                                    break;
                                    break;
                                }
                                mediaMuxer.writeSampleData(iAddTrack, byteBufferAllocateDirect, bufferInfo);
                                if (videoProgressListener != null) {
                                    j6 = j2;
                                    f2 = bufferInfo.presentationTimeUs / j6;
                                    if (f2 > 1.0f) {
                                        f2 = 1.0f;
                                    }
                                    videoProgressListener.onProgress((f2 * 0.3f) + 0.7f);
                                } else {
                                    j6 = j2;
                                }
                                size--;
                                j2 = j6;
                            }
                        } else {
                            j4 = j2;
                            mediaExtractor.seekTo(j3, 2);
                            while (true) {
                                sampleTime = mediaExtractor.getSampleTime();
                                if (sampleTime == -1) {
                                    break;
                                    break;
                                }
                                bufferInfo.presentationTimeUs = sampleTime;
                                bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                                bufferInfo.flags = mediaExtractor.getSampleFlags();
                                if (bufferInfo.size < 0) {
                                    break;
                                    break;
                                }
                                mediaMuxer.writeSampleData(iAddTrack, byteBufferAllocateDirect, bufferInfo);
                                if (videoProgressListener != null) {
                                    f = bufferInfo.presentationTimeUs / j4;
                                    if (f > 1.0f) {
                                        f = 1.0f;
                                    }
                                    videoProgressListener.onProgress((f * 0.3f) + 0.7f);
                                }
                                mediaExtractor.advance();
                            }
                        }
                    }
                    if (videoProgressListener != null) {
                        videoProgressListener.onProgress(1.0f);
                    }
                } catch (Exception e) {
                    v61.g(e);
                }
            } else {
                j2 = j;
                j7 = -1;
                while (true) {
                    sampleTime3 = mediaExtractor.getSampleTime();
                    i = iM2;
                    if (j7 == -1) {
                        j7 = sampleTime3;
                    }
                    bufferInfo.presentationTimeUs = j7 - sampleTime3;
                    bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                    bufferInfo.flags = mediaExtractor.getSampleFlags();
                    if (bufferInfo.size >= 0) {
                        j3 = 0;
                        break;
                    }
                    mediaMuxer.writeSampleData(iAddTrack2, byteBufferAllocateDirect, bufferInfo);
                    if (videoProgressListener != null) {
                        f3 = bufferInfo.presentationTimeUs / j10;
                        if (f3 > 1.0f) {
                            f3 = 1.0f;
                        }
                        videoProgressListener.onProgress(f3 * 0.7f);
                    }
                    j8 = sampleTime3 - 10000;
                    j9 = j7;
                    j3 = 0;
                    if (j8 <= 0) {
                        break;
                        break;
                    }
                    long j13 = j2;
                    mediaExtractor.seekTo(j8, 0);
                    iM2 = i;
                    j2 = j13;
                    j7 = j9;
                }
                if (z2) {
                    mediaExtractor.unselectTrack(iM);
                    mediaExtractor.selectTrack(i);
                    if (z) {
                        listF = np9.f(mediaExtractor);
                        size = listF.size() - 1;
                        j5 = -1;
                        while (size >= 0) {
                            mediaExtractor.seekTo(listF.get(size).longValue(), 2);
                            sampleTime2 = mediaExtractor.getSampleTime();
                            if (j5 == -1) {
                                j5 = sampleTime2;
                            }
                            bufferInfo.presentationTimeUs = j5 - sampleTime2;
                            bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                            bufferInfo.flags = mediaExtractor.getSampleFlags();
                            if (bufferInfo.size < 0) {
                                break;
                                break;
                            }
                            mediaMuxer.writeSampleData(iAddTrack, byteBufferAllocateDirect, bufferInfo);
                            if (videoProgressListener != null) {
                                j6 = j2;
                                f2 = bufferInfo.presentationTimeUs / j6;
                                if (f2 > 1.0f) {
                                    f2 = 1.0f;
                                }
                                videoProgressListener.onProgress((f2 * 0.3f) + 0.7f);
                            } else {
                                j6 = j2;
                            }
                            size--;
                            j2 = j6;
                        }
                    } else {
                        j4 = j2;
                        mediaExtractor.seekTo(j3, 2);
                        while (true) {
                            sampleTime = mediaExtractor.getSampleTime();
                            if (sampleTime == -1) {
                                break;
                                break;
                            }
                            bufferInfo.presentationTimeUs = sampleTime;
                            bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                            bufferInfo.flags = mediaExtractor.getSampleFlags();
                            if (bufferInfo.size < 0) {
                                break;
                                break;
                            }
                            mediaMuxer.writeSampleData(iAddTrack, byteBufferAllocateDirect, bufferInfo);
                            if (videoProgressListener != null) {
                                f = bufferInfo.presentationTimeUs / j4;
                                if (f > 1.0f) {
                                    f = 1.0f;
                                }
                                videoProgressListener.onProgress((f * 0.3f) + 0.7f);
                            }
                            mediaExtractor.advance();
                        }
                    }
                }
                if (videoProgressListener != null) {
                    videoProgressListener.onProgress(1.0f);
                }
            }
        } finally {
            mediaExtractor.release();
            mediaMuxer.release();
        }
    }

    public static void j(Context context, Uri uri, String str, int i, int i2) throws Exception {
        f(context).v(uri).A(str).z(i).y(i2).B();
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f42634a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Uri f17450a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f17451a;

        public c(String str) {
            this.f17451a = str;
        }

        public void a(MediaExtractor mediaExtractor) throws IOException {
            String str = this.f17451a;
            if (str != null) {
                mediaExtractor.setDataSource(str);
            } else {
                mediaExtractor.setDataSource(this.f42634a, this.f17450a, (Map<String, String>) null);
            }
        }

        public void b(MediaMetadataRetriever mediaMetadataRetriever) {
            String str = this.f17451a;
            if (str != null) {
                mediaMetadataRetriever.setDataSource(str);
            } else {
                mediaMetadataRetriever.setDataSource(this.f42634a, this.f17450a);
            }
        }

        public c(Context context, Uri uri) {
            this.f42634a = context;
            this.f17450a = uri;
        }
    }
}
