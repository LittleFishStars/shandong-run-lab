package com.aliyun.svideosdk.recorder.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.aliyun.svideosdk.common.AliyunRecordAVSource;
import com.aliyun.svideosdk.common.AliyunRecordAudioSource;
import com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack;
import com.aliyun.svideosdk.common.callback.recorder.OnEncoderInfoCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback;
import com.aliyun.svideosdk.common.struct.common.VideoQuality;
import com.aliyun.svideosdk.common.struct.encoder.EncoderInfo;
import com.aliyun.svideosdk.common.struct.encoder.VideoCodecs;
import com.aliyun.svideosdk.common.struct.project.Config;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.common.struct.project.VideoTrackClip;
import com.aliyun.svideosdk.common.struct.recorder.MediaInfo;
import com.aliyun.svideosdk.recorder.NativeRecorder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e {
    private float A;
    private float B;
    private AliyunRecordAudioSource C;
    private AliyunRecordAudioSource D;
    private AliyunRecordAVSource E;
    private int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25840a;
    private NativeRecorder.CallBack b;
    private boolean c;
    private com.aliyun.svideosdk.recorder.impl.h.a d;
    private com.aliyun.svideosdk.recorder.impl.c e;
    private OnRecordCallback f;
    private OnEncoderInfoCallback g;
    private MediaInfo h;
    private int i;
    private int j;
    private String k;
    private d l;
    private Boolean m;
    private long n;
    private volatile int o;
    private float p;
    private long q;
    private int r;
    private int s;
    private Handler t;
    private boolean u;
    private com.aliyun.common.c.b.e v;
    private NativeRecorder w;
    private boolean x;
    private boolean y;
    private boolean z;

    public class a implements NativeRecorder.CallBack {

        /* JADX INFO: renamed from: com.aliyun.svideosdk.recorder.impl.e$a$a, reason: collision with other inner class name */
        public class RunnableC0240a implements Runnable {
            public RunnableC0240a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.m();
            }
        }

        public a() {
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.CallBack
        public void onDuration(long j) {
            e.this.q = j / 1000;
            long duration = ((long) e.this.e.getDuration()) + e.this.q;
            if (e.this.f != null) {
                e.this.f.onProgress(e.this.q);
            }
            if (duration < e.this.e.getMaxDuration() || !e.this.u) {
                return;
            }
            if (e.this.f != null) {
                e.this.f.onMaxDuration();
            }
            e.this.t.post(new RunnableC0240a());
            e.this.u = false;
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.CallBack
        public void onEncoderInfoBack(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
            com.aliyun.common.c.a.a.a("AliyunMediaRecorder", "recorder onEncoderInfoBack type = " + j + ", width = " + j2 + ", height = " + j3 + ", duration = " + j4 + ", fps = " + j5 + ", bitrateDiff = " + j6 + ", keyframeDelay = " + j7 + ", avgUseTime = " + j8 + ", maxCacheFrame = " + j9);
            EncoderInfo encoderInfo = new EncoderInfo();
            encoderInfo.encoderType = j;
            encoderInfo.width = j2;
            encoderInfo.height = j3;
            encoderInfo.duration = j4;
            encoderInfo.fps = j5;
            encoderInfo.bitrateDiff = j6;
            encoderInfo.avgUseTime = j8;
            encoderInfo.maxCacheFrame = j9;
            if (e.this.g != null) {
                e.this.g.onEncoderInfoBack(encoderInfo);
            }
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.CallBack
        public void onError(int i) {
            com.aliyun.common.c.a.a.a("AliyunMediaRecorder", " recorder onError " + i);
            if (e.this.f != null) {
                e.this.f.onError(i);
            }
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.CallBack
        public void onExit(int i, long j, long j2) {
            com.aliyun.common.c.a.a.a("AliyunMediaRecorder", "recorder onComplete, mTempPath = " + e.this.k + ", mCurrentClipDuration = " + e.this.q);
            com.aliyun.common.c.a.a.a("AliyunMediaRecorder", "recorder onComplete, aDuration " + j + ", vDuration " + j2);
            e.this.d.e();
            boolean z = (j2 == 0 || j == 0) ? false : true;
            if (j2 > j) {
                j = j2;
            }
            VideoTrackClip videoTrackClip = new VideoTrackClip();
            videoTrackClip.setSource(new Source(e.this.k));
            videoTrackClip.setIn(0.0f);
            float f = j / 1000000.0f;
            videoTrackClip.setOut(f);
            videoTrackClip.setDuration(f);
            videoTrackClip.setRotation(e.this.s);
            videoTrackClip.setType(0);
            if (z) {
                e.this.e.a(videoTrackClip);
                Config configB = e.this.e.b();
                configB.setOutputWidth(e.this.h.getVideoWidth());
                configB.setOutputHeight(e.this.h.getVideoHeight());
                configB.setGop(e.this.h.getGop());
                configB.setBitrate(e.this.h.getVideoBitrate());
                configB.setVideoQuality(e.this.h.getVideoQuality().ordinal());
                configB.setFps(e.this.h.getFps());
                if (e.this.s == 90 || e.this.s == 270) {
                    configB.setOutputWidth(e.this.h.getVideoHeight());
                    configB.setOutputHeight(e.this.h.getVideoWidth());
                }
            } else {
                com.aliyun.common.utils.g.a(e.this.k);
            }
            e.this.v.a(System.currentTimeMillis() - e.this.n);
            if (e.this.f != null) {
                e.this.f.onClipComplete(z, j / 1000);
            }
        }
    }

    public class b implements com.aliyun.svideosdk.recorder.impl.h.a.InterfaceC0241a {
        public b() {
        }

        @Override // com.aliyun.svideosdk.recorder.impl.h.a.InterfaceC0241a
        public void a(long j) {
            if (e.this.l != null) {
                e.this.l.a(j);
            }
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25844a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[VideoCodecs.values().length];
            b = iArr;
            try {
                iArr[VideoCodecs.H264_HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[VideoCodecs.H264_SOFT_OPENH264.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[VideoQuality.values().length];
            f25844a = iArr2;
            try {
                iArr2[VideoQuality.SSD.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25844a[VideoQuality.HD.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25844a[VideoQuality.SD.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25844a[VideoQuality.LD.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25844a[VideoQuality.PD.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25844a[VideoQuality.EPD.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public interface d {
        void a(long j);
    }

    public e(Context context, com.aliyun.common.c.b.e eVar, NativeRecorder nativeRecorder) {
        this(context, eVar, nativeRecorder, false);
    }

    public e(Context context, com.aliyun.common.c.b.e eVar, NativeRecorder nativeRecorder, boolean z) {
        this.f25840a = "";
        this.c = false;
        this.d = new com.aliyun.svideosdk.recorder.impl.h.a();
        this.h = new MediaInfo();
        this.m = Boolean.FALSE;
        this.n = 0L;
        this.o = 0;
        this.p = 1.0f;
        this.r = 0;
        this.s = 0;
        this.t = new Handler(Looper.getMainLooper());
        this.u = true;
        this.y = false;
        this.z = false;
        this.A = 0.5f;
        this.B = 1.0f;
        this.C = null;
        this.D = null;
        this.F = -1;
        this.w = nativeRecorder;
        this.x = z;
        e();
        this.e = new com.aliyun.svideosdk.recorder.impl.c(context);
        this.v = eVar;
        this.b = new a();
        f();
    }

    private com.aliyun.svideosdk.c.c d() {
        com.aliyun.svideosdk.c.c cVar = com.aliyun.svideosdk.c.c.High;
        int i = c.f25844a[this.h.getVideoQuality().ordinal()];
        if (i == 1) {
            return com.aliyun.svideosdk.c.c.Super;
        }
        if (i == 3) {
            return com.aliyun.svideosdk.c.c.Meidan;
        }
        if (i == 4) {
            return com.aliyun.svideosdk.c.c.Low;
        }
        if (i != 5) {
            return i != 6 ? cVar : com.aliyun.svideosdk.c.c.ExtraPoor;
        }
        return com.aliyun.svideosdk.c.c.Poor;
    }

    private void e() {
        AliyunRecordAudioSource aliyunRecordAudioSourceA = this.d.a();
        this.D = aliyunRecordAudioSourceA;
        aliyunRecordAudioSourceA.setAudioNeedRender(false);
        this.D.setAudioNeedOutput(true);
        this.w.addSource(this.D);
    }

    private void f() {
        this.w.setCallback(this.b);
        this.d.a(this.w);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0249  */
    /* JADX WARN: Code duplicated, block: B:103:0x024d  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e2 A[PHI: r0
      0x00e2: PHI (r0v37 com.aliyun.svideosdk.common.AliyunRecordAudioSource) = 
      (r0v36 com.aliyun.svideosdk.common.AliyunRecordAudioSource)
      (r0v67 com.aliyun.svideosdk.common.AliyunRecordAudioSource)
     binds: [B:65:0x00e0, B:58:0x00c8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x0223  */
    /* JADX WARN: Code duplicated, block: B:97:0x023d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0245  */
    private int l() {
        AliyunRecordAudioSource aliyunRecordAudioSource;
        NativeRecorder nativeRecorder;
        int iA;
        com.aliyun.svideosdk.c.e eVar;
        String str;
        int iStart;
        OnRecordCallback onRecordCallback;
        if (this.m.booleanValue() || !this.c) {
            this.D.setAudioNeedRender(false);
            this.D.setAudioNeedOutput(false);
            AliyunRecordAVSource aliyunRecordAVSource = this.E;
            if (aliyunRecordAVSource != null) {
                aliyunRecordAVSource.setVolume(1.0f);
            }
            AliyunRecordAudioSource aliyunRecordAudioSource2 = this.C;
            if (aliyunRecordAudioSource2 != null) {
                aliyunRecordAudioSource2.setVolume(1.0f);
            }
        } else {
            this.D.setVolume(1.0f);
            int i = this.F;
            boolean z = i == 1 || i == 3 || this.z;
            if (!z && i == -1 && this.C == null && this.E == null) {
                z = true;
            }
            AliyunRecordAVSource aliyunRecordAVSource2 = this.E;
            if (aliyunRecordAVSource2 != null || this.C != null) {
                if (this.y) {
                    if (aliyunRecordAVSource2 != null) {
                        this.D.setAECFarSource(aliyunRecordAVSource2);
                        this.E.setAudioNeedOutput(true);
                        this.E.setVolume(this.A);
                    }
                    AliyunRecordAudioSource aliyunRecordAudioSource3 = this.C;
                    if (aliyunRecordAudioSource3 != null) {
                        this.D.setAECFarSource(aliyunRecordAudioSource3);
                        this.C.setAudioNeedOutput(true);
                        this.C.setVolume(this.A);
                    }
                    this.D.setVolume(this.B);
                } else {
                    this.D.setAECFarSource(null);
                    AliyunRecordAVSource aliyunRecordAVSource3 = this.E;
                    if (aliyunRecordAVSource3 != null) {
                        aliyunRecordAVSource3.setAudioNeedOutput(false);
                        this.E.setVolume(0.5f);
                        z = true;
                    }
                    AliyunRecordAudioSource aliyunRecordAudioSource4 = this.C;
                    if (aliyunRecordAudioSource4 != null) {
                        aliyunRecordAudioSource4.setAudioNeedOutput(false);
                        this.C.setVolume(1.0f);
                        z = true;
                    }
                }
            }
            this.D.setAudioNeedOutput(z);
        }
        int i2 = this.F;
        if (i2 == 2) {
            this.D.setAudioNeedOutput(false);
            AliyunRecordAVSource aliyunRecordAVSource4 = this.E;
            if (aliyunRecordAVSource4 != null) {
                aliyunRecordAVSource4.setAudioNeedOutput(false);
            }
            aliyunRecordAudioSource = this.C;
            if (aliyunRecordAudioSource != null) {
                aliyunRecordAudioSource.setAudioNeedOutput(false);
            }
        } else if (i2 == 1) {
            this.D.setAudioNeedOutput(true);
            this.D.setVolume(1.0f);
            AliyunRecordAVSource aliyunRecordAVSource5 = this.E;
            if (aliyunRecordAVSource5 != null) {
                aliyunRecordAVSource5.setAudioNeedOutput(false);
            }
            aliyunRecordAudioSource = this.C;
            if (aliyunRecordAudioSource != null) {
                aliyunRecordAudioSource.setAudioNeedOutput(false);
            }
        } else if (i2 == 0) {
            this.D.setAudioNeedOutput(false);
            AliyunRecordAVSource aliyunRecordAVSource6 = this.E;
            if (aliyunRecordAVSource6 != null) {
                aliyunRecordAVSource6.setAudioNeedOutput(true);
                this.E.setVolume(1.0f);
            }
            AliyunRecordAudioSource aliyunRecordAudioSource5 = this.C;
            if (aliyunRecordAudioSource5 != null) {
                aliyunRecordAudioSource5.setAudioNeedOutput(true);
                this.C.setVolume(1.0f);
            }
        } else if (i2 == 3) {
            this.D.setAudioNeedOutput(true);
            this.D.setVolume(this.B);
            AliyunRecordAVSource aliyunRecordAVSource7 = this.E;
            if (aliyunRecordAVSource7 != null) {
                aliyunRecordAVSource7.setAudioNeedOutput(true);
                this.E.setVolume(this.A);
            }
            AliyunRecordAudioSource aliyunRecordAudioSource6 = this.C;
            if (aliyunRecordAudioSource6 != null) {
                aliyunRecordAudioSource6.setAudioNeedOutput(true);
                this.C.setVolume(this.A);
            }
        }
        this.w.updateSource(this.D);
        AliyunRecordAVSource aliyunRecordAVSource8 = this.E;
        if (aliyunRecordAVSource8 != null) {
            this.w.updateSource(aliyunRecordAVSource8);
        }
        AliyunRecordAudioSource aliyunRecordAudioSource7 = this.C;
        if (aliyunRecordAudioSource7 != null) {
            this.w.updateSource(aliyunRecordAudioSource7);
        }
        int i3 = c.b[this.h.getVideoCodec().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                nativeRecorder = this.w;
                iA = com.aliyun.svideosdk.c.d.VideoCodecIdKey.a();
                eVar = com.aliyun.svideosdk.c.e.ALIVC_CODEC_H264_OPENH264;
            }
            this.w.setParam(com.aliyun.svideosdk.c.d.VideoFpsKey.a(), this.h.getEncoderFps());
            this.w.setParam(com.aliyun.svideosdk.c.d.VideoCrfKey.a(), this.h.getCrf());
            this.w.setParam(com.aliyun.svideosdk.c.d.VideoGopSizeKey.a(), this.h.getGop());
            this.w.setParam(com.aliyun.svideosdk.c.d.VideoBpsKey.a(), this.h.getVideoBitrate());
            this.w.setParam(com.aliyun.svideosdk.c.d.VideoQualityKey.a(), d().a());
            this.w.setParam(com.aliyun.svideosdk.c.d.VideoRotateKey.a(), this.r);
            this.s = this.r;
            this.w.setVideoTempo(this.p);
            this.w.setVideoSize(this.h.getVideoWidth(), this.h.getVideoHeight());
            str = this.f25840a.replace(".mp4", "") + LoginConstants.UNDER_LINE + System.currentTimeMillis() + ".mp4";
            this.k = str;
            if (this.x) {
                iStart = this.w.start(this.k, ((long) (this.e.getMaxDuration() - this.e.getDuration())) * 1000);
            } else {
                iStart = this.w.start(str);
            }
            if (iStart != 0) {
                d(1001);
                this.u = true;
                return 0;
            }
            onRecordCallback = this.f;
            if (onRecordCallback != null) {
                onRecordCallback.onError(iStart);
            }
            return iStart;
        }
        nativeRecorder = this.w;
        iA = com.aliyun.svideosdk.c.d.VideoCodecIdKey.a();
        eVar = com.aliyun.svideosdk.c.e.ALIVC_CODEC_H264_HARDWARE;
        nativeRecorder.setParam(iA, eVar.a());
        this.w.setParam(com.aliyun.svideosdk.c.d.VideoFpsKey.a(), this.h.getEncoderFps());
        this.w.setParam(com.aliyun.svideosdk.c.d.VideoCrfKey.a(), this.h.getCrf());
        this.w.setParam(com.aliyun.svideosdk.c.d.VideoGopSizeKey.a(), this.h.getGop());
        this.w.setParam(com.aliyun.svideosdk.c.d.VideoBpsKey.a(), this.h.getVideoBitrate());
        this.w.setParam(com.aliyun.svideosdk.c.d.VideoQualityKey.a(), d().a());
        this.w.setParam(com.aliyun.svideosdk.c.d.VideoRotateKey.a(), this.r);
        this.s = this.r;
        this.w.setVideoTempo(this.p);
        this.w.setVideoSize(this.h.getVideoWidth(), this.h.getVideoHeight());
        str = this.f25840a.replace(".mp4", "") + LoginConstants.UNDER_LINE + System.currentTimeMillis() + ".mp4";
        this.k = str;
        if (this.x) {
            iStart = this.w.start(this.k, ((long) (this.e.getMaxDuration() - this.e.getDuration())) * 1000);
        } else {
            iStart = this.w.start(str);
        }
        if (iStart != 0) {
            d(1001);
            this.u = true;
            return 0;
        }
        onRecordCallback = this.f;
        if (onRecordCallback != null) {
            onRecordCallback.onError(iStart);
        }
        return iStart;
    }

    public int a(int i) {
        this.D.setDenoiseWeight(i / 100.0f);
        return 0;
    }

    public int a(String str, long j, long j2, boolean z) {
        if (this.o == 1001) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid state!");
            return -4;
        }
        AliyunRecordAudioSource aliyunRecordAudioSource = this.C;
        if (aliyunRecordAudioSource != null) {
            this.w.removeSource(aliyunRecordAudioSource);
            this.C.release();
            this.C = null;
        }
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        AliyunRecordAudioSource aliyunRecordAudioSourceCreateAudioWithFile = AliyunRecordAudioSource.createAudioWithFile(str, j, j2);
        this.C = aliyunRecordAudioSourceCreateAudioWithFile;
        aliyunRecordAudioSourceCreateAudioWithFile.setAudioNeedRender(true);
        this.C.setAudioNeedOutput(true);
        return this.w.addSource(this.C);
    }

    public int a(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            return 1073754177;
        }
        int iStitchPart = this.w.stitchPart(strArr, strArr.length, str);
        OnRecordCallback onRecordCallback = this.f;
        if (onRecordCallback == null) {
            return iStitchPart;
        }
        if (iStitchPart == 0) {
            onRecordCallback.onFinish(str);
        } else {
            onRecordCallback.onError(iStitchPart);
        }
        return iStitchPart;
    }

    public void a() {
        if (this.o == 1003 || this.o == 1001) {
            this.w.cancel();
            this.d.e();
            d(1002);
        }
    }

    public void a(float f) {
        this.p = f;
    }

    public void a(int i, int i2) {
        this.A = i / 100.0f;
        this.B = i2 / 100.0f;
    }

    public void a(AliyunRecordAVSource aliyunRecordAVSource) {
        this.E = aliyunRecordAVSource;
    }

    public void a(OnAudioCallBack onAudioCallBack) {
        this.d.a(onAudioCallBack);
    }

    public void a(OnEncoderInfoCallback onEncoderInfoCallback) {
        this.g = onEncoderInfoCallback;
    }

    public void a(OnRecordCallback onRecordCallback) {
        this.f = onRecordCallback;
    }

    public void a(MediaInfo mediaInfo) {
        if (mediaInfo != null) {
            this.h = mediaInfo;
        }
        if (mediaInfo.getVideoWidth() <= 0 || mediaInfo.getVideoHeight() <= 0) {
            return;
        }
        if (this.i == mediaInfo.getVideoWidth() && this.j == mediaInfo.getVideoHeight()) {
            return;
        }
        this.i = mediaInfo.getVideoWidth();
        this.j = mediaInfo.getVideoHeight();
        this.w.setVideoSize(mediaInfo.getVideoWidth(), mediaInfo.getVideoHeight());
    }

    public void a(d dVar) {
        this.l = dVar;
    }

    public void a(String str) {
        this.f25840a = str;
    }

    public void a(boolean z) {
        this.m = Boolean.valueOf(z);
    }

    public int b() {
        com.aliyun.common.c.a.a.a("AliYunLog", "AliyunMediaRecord finish ");
        String[] strArr = new String[this.e.a().size()];
        for (int i = 0; i < this.e.a().size(); i++) {
            strArr[i] = this.e.a().get(i).getSource().getPath();
            com.aliyun.common.c.a.a.a("AliYunLog", "AliyunMediaRecord finish part " + i + " file " + strArr[i]);
        }
        int iA = a(strArr, this.f25840a);
        com.aliyun.common.c.a.a.a("AliYunLog", "AliyunMediaRecord stitchVideo finish " + iA);
        return iA;
    }

    public void b(int i) {
        this.F = i;
    }

    public void b(boolean z) {
        this.y = z;
    }

    public com.aliyun.svideosdk.recorder.impl.c c() {
        return this.e;
    }

    public void c(int i) {
        this.r = i;
    }

    public void c(boolean z) {
        this.z = z;
    }

    public synchronized void d(int i) {
        this.o = i;
    }

    public boolean g() {
        return this.e.getDuration() >= this.e.getMaxDuration();
    }

    public void h() {
        com.aliyun.svideosdk.recorder.impl.h.a aVar = this.d;
        if (aVar != null) {
            this.c = aVar.b();
        }
    }

    public void i() {
        this.b = null;
        com.aliyun.common.c.a.a.a("AliYunLog", "AliyunMediaRecorder release");
        AliyunRecordAVSource aliyunRecordAVSource = this.E;
        if (aliyunRecordAVSource != null) {
            this.w.removeSource(aliyunRecordAVSource);
            this.E.release();
            this.E = null;
        }
        AliyunRecordAudioSource aliyunRecordAudioSource = this.C;
        if (aliyunRecordAudioSource != null) {
            this.w.removeSource(aliyunRecordAudioSource);
            this.C.release();
            this.C = null;
        }
        AliyunRecordAudioSource aliyunRecordAudioSource2 = this.D;
        if (aliyunRecordAudioSource2 != null) {
            this.w.removeSource(aliyunRecordAudioSource2);
            this.D.release();
            this.D = null;
        }
        com.aliyun.common.c.b.e eVar = this.v;
        if (eVar != null) {
            eVar.b();
        }
        this.w.release();
        this.g = null;
    }

    public void j() {
        com.aliyun.svideosdk.recorder.impl.h.a aVar = this.d;
        if (aVar != null) {
            aVar.c();
            this.c = false;
        }
    }

    public int k() {
        if (this.o != 0 && 1002 != this.o) {
            com.aliyun.common.c.a.a.b("AliYunLog", "AliyunMediaRecorder, the last recording is not complete, STATE_PENDING = " + this.o);
            OnRecordCallback onRecordCallback = this.f;
            if (onRecordCallback != null) {
                onRecordCallback.onError(-20008005);
            }
            return -20008005;
        }
        d(1003);
        int iL = l();
        if (iL != 0) {
            d(1002);
            return iL;
        }
        if (this.c) {
            this.d.a(new b());
            return 0;
        }
        d dVar = this.l;
        if (dVar == null) {
            return 0;
        }
        dVar.a(System.nanoTime());
        return 0;
    }

    public int m() {
        if (this.o != 1003 && this.o != 1001) {
            com.aliyun.common.c.a.a.b("AliYunLog", "AliyunMediaRecord stop invalid state!");
            return -4;
        }
        this.n = System.currentTimeMillis();
        this.w.stop();
        d(1002);
        return 0;
    }
}
