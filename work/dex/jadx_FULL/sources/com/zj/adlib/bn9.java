package com.zj.adlib;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.hw.videoprocessor.IVideoEncodeThread;
import com.ipd.dsp.internal.v1.b;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class bn9 extends Thread {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaCodec f40786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaExtractor f15576a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IVideoEncodeThread f15577a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ab4 f15578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public cm3 f15579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wg6 f15580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Exception f15581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Float f15582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer f15583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AtomicBoolean f15584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15585a;
    public Integer b;
    public Integer c;
    public Integer d;

    public bn9(IVideoEncodeThread iVideoEncodeThread, MediaExtractor mediaExtractor, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Float f, boolean z, int i, AtomicBoolean atomicBoolean) {
        super("VideoProcessDecodeThread");
        this.f15576a = mediaExtractor;
        this.f15583a = num;
        this.b = num2;
        this.f15582a = f;
        this.K = i;
        this.f15584a = atomicBoolean;
        this.f15577a = iVideoEncodeThread;
        this.c = num4;
        this.d = num3;
        this.f15585a = z;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0124  */
    /* JADX WARN: Code duplicated, block: B:37:0x0133  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v6 */
    public final void b() throws IOException {
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        long j;
        boolean z4;
        int i2;
        int iDequeueInputBuffer;
        Integer num;
        try {
            if (!this.f15577a.b().await(5L, TimeUnit.SECONDS)) {
                this.f15581a = new TimeoutException("wait eglContext timeout!");
                return;
            }
            ab4 ab4Var = new ab4(this.f15577a.getSurface());
            this.f15578a = ab4Var;
            ab4Var.d();
            MediaFormat trackFormat = this.f15576a.getTrackFormat(this.K);
            this.f40786a = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
            wg6 wg6Var = new wg6();
            this.f15580a = wg6Var;
            int i3 = 0;
            this.f40786a.configure(trackFormat, wg6Var.g(), (MediaCrypto) null, 0);
            this.f40786a.start();
            if (this.f15585a && (num = this.d) != null && this.c != null) {
                if (this.f15582a != null) {
                    this.d = Integer.valueOf((int) (num.intValue() * this.f15582a.floatValue()));
                }
                if (this.d.intValue() > this.c.intValue()) {
                    this.f15579a = new cm3(this.d.intValue(), this.c.intValue());
                    v61.t("帧率过高，需要丢帧:" + this.d + c25.j + this.c, new Object[0]);
                }
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            boolean z5 = false;
            boolean z6 = false;
            int i4 = 0;
            int i5 = 0;
            long j2 = -1;
            while (!z5) {
                long j3 = b.C0923b.f;
                int i6 = -1;
                if (!z6) {
                    int sampleTrackIndex = this.f15576a.getSampleTrackIndex();
                    if (sampleTrackIndex == this.K) {
                        int iDequeueInputBuffer2 = this.f40786a.dequeueInputBuffer(b.C0923b.f);
                        if (iDequeueInputBuffer2 >= 0) {
                            int sampleData = this.f15576a.readSampleData(this.f40786a.getInputBuffer(iDequeueInputBuffer2), i3);
                            if (sampleData < 0) {
                                this.f40786a.queueInputBuffer(iDequeueInputBuffer2, 0, 0, 0L, 4);
                                z5 = true;
                            } else {
                                this.f40786a.queueInputBuffer(iDequeueInputBuffer2, 0, sampleData, this.f15576a.getSampleTime(), 0);
                                this.f15576a.advance();
                            }
                        }
                    } else {
                        if (sampleTrackIndex == -1) {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            v61.k("inputDone", new Object[i3]);
                            iDequeueInputBuffer = this.f40786a.dequeueInputBuffer(b.C0923b.f);
                            if (iDequeueInputBuffer >= 0) {
                                this.f40786a.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                                z6 = true;
                            }
                        }
                    }
                    i2 = i3;
                    if (i2 != 0) {
                        v61.k("inputDone", new Object[i3]);
                        iDequeueInputBuffer = this.f40786a.dequeueInputBuffer(b.C0923b.f);
                        if (iDequeueInputBuffer >= 0) {
                            this.f40786a.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                            z6 = true;
                        }
                    }
                }
                boolean z7 = !z5;
                if (z5) {
                    v61.k("decoderOutputAvailable:" + z7, new Object[i3]);
                }
                while (true) {
                    if (z7) {
                        int iDequeueOutputBuffer = this.f40786a.dequeueOutputBuffer(bufferInfo, j3);
                        v61.k("outputBufferIndex = " + iDequeueOutputBuffer, new Object[i3]);
                        if (z6 && iDequeueOutputBuffer == i6) {
                            i4++;
                            if (i4 > 10) {
                                v61.f("INFO_TRY_AGAIN_LATER 10 times,force End!", new Object[i3]);
                            }
                            z5 = true;
                        } else {
                            i4 = i3;
                        }
                        if (iDequeueOutputBuffer != i6) {
                            if (iDequeueOutputBuffer == -2) {
                                v61.k("decode newFormat = " + this.f40786a.getOutputFormat(), new Object[i3]);
                            } else {
                                if (iDequeueOutputBuffer < 0) {
                                    v61.f("unexpected result from decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer, new Object[i3]);
                                } else {
                                    Integer num2 = this.b;
                                    if (num2 == null || bufferInfo.presentationTimeUs < num2.intValue() * 1000) {
                                        z = z5;
                                        z6 = z6;
                                        z2 = true;
                                    } else {
                                        bufferInfo.flags |= 4;
                                        z2 = false;
                                        z = true;
                                        z6 = true;
                                    }
                                    Integer num3 = this.f15583a;
                                    if (num3 == null || bufferInfo.presentationTimeUs >= num3.intValue() * 1000) {
                                        i = 0;
                                    } else {
                                        i = 0;
                                        v61.f("drop frame startTime = " + this.f15583a + " present time = " + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                                        z2 = false;
                                    }
                                    if (bufferInfo.flags == 4) {
                                        this.f40786a.releaseOutputBuffer(iDequeueOutputBuffer, (boolean) i);
                                        v61.k("decoderDone", new Object[i]);
                                        z5 = true;
                                    } else {
                                        cm3 cm3Var = this.f15579a;
                                        if (cm3Var != null && cm3Var.a(i5)) {
                                            v61.t("帧率过高，丢帧:" + i5, new Object[0]);
                                            z2 = false;
                                        }
                                        i5++;
                                        this.f40786a.releaseOutputBuffer(iDequeueOutputBuffer, z2);
                                        if (z2) {
                                            try {
                                                this.f15580a.a();
                                                z3 = false;
                                            } catch (Exception e) {
                                                v61.f(e.getMessage(), new Object[0]);
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                if (j2 == -1) {
                                                    j2 = bufferInfo.presentationTimeUs;
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("videoStartTime:");
                                                    j = 1000;
                                                    sb.append(j2 / 1000);
                                                    z4 = false;
                                                    v61.k(sb.toString(), new Object[0]);
                                                } else {
                                                    j = 1000;
                                                    z4 = false;
                                                }
                                                this.f15580a.d(z4);
                                                long jFloatValue = (bufferInfo.presentationTimeUs - j2) * j;
                                                Float f = this.f15582a;
                                                if (f != null) {
                                                    jFloatValue = (long) (jFloatValue / f.floatValue());
                                                }
                                                v61.k("drawImage,setPresentationTimeMs:" + ((jFloatValue / 1000) / 1000), new Object[0]);
                                                this.f15578a.f(jFloatValue);
                                                this.f15578a.g();
                                                z5 = z;
                                            }
                                        }
                                        z5 = z;
                                    }
                                }
                                i3 = 0;
                                j3 = b.C0923b.f;
                                i6 = -1;
                            }
                            i3 = 0;
                            j3 = b.C0923b.f;
                            i6 = -1;
                        }
                        i3 = 0;
                    }
                    i3 = 0;
                }
            }
            v61.k("Video Decode Done!", new Object[0]);
            this.f15584a.set(true);
        } catch (InterruptedException e2) {
            v61.g(e2);
            this.f15581a = e2;
        }
    }

    public Exception c() {
        return this.f15581a;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0026 A[PHI: r0
      0x0026: PHI (r0v9 'e' java.lang.Exception) = (r0v4 'e' java.lang.Exception), (r0v12 'e' java.lang.Exception) binds: [B:35:0x0055, B:16:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Exception exc;
        super.run();
        try {
            b();
            ab4 ab4Var = this.f15578a;
            if (ab4Var != null) {
                ab4Var.e();
            }
            wg6 wg6Var = this.f15580a;
            if (wg6Var != null) {
                wg6Var.i();
            }
            try {
                if (this.f40786a != null) {
                }
            } catch (Exception e) {
                e = e;
                exc = this.f15581a;
                if (exc == null) {
                    exc = e;
                }
                this.f15581a = exc;
                v61.g(e);
            }
        } catch (Exception e2) {
            this.f15581a = e2;
            v61.g(e2);
            if (this.f15578a != null) {
                this.f15578a.e();
            }
            wg6 wg6Var2 = this.f15580a;
            if (wg6Var2 != null) {
                wg6Var2.i();
            }
            try {
                if (this.f40786a != null) {
                }
            } catch (Exception e3) {
                e = e3;
                exc = this.f15581a;
                if (exc == null) {
                    exc = e;
                }
                this.f15581a = exc;
                v61.g(e);
            }
        } finally {
            ab4 ab4Var2 = this.f15578a;
            if (ab4Var2 != null) {
                ab4Var2.e();
            }
            wg6 wg6Var3 = this.f15580a;
            if (wg6Var3 != null) {
                wg6Var3.i();
            }
            try {
                MediaCodec mediaCodec = this.f40786a;
                if (mediaCodec != null) {
                    mediaCodec.stop();
                    this.f40786a.release();
                }
            } catch (Exception e4) {
                Exception exc2 = this.f15581a;
                if (exc2 == null) {
                    exc2 = e4;
                }
                this.f15581a = exc2;
                v61.g(e4);
            }
        }
    }
}
