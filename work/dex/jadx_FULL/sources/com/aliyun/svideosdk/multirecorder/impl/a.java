package com.aliyun.svideosdk.multirecorder.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.SurfaceView;
import com.aliyun.common.c.b.e;
import com.aliyun.common.utils.q;
import com.aliyun.svideosdk.common.AliyunErrorCode;
import com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack;
import com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback;
import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.encoder.VideoCodecs;
import com.aliyun.svideosdk.common.struct.recorder.CameraParam;
import com.aliyun.svideosdk.common.struct.recorder.CameraType;
import com.aliyun.svideosdk.common.struct.recorder.FlashType;
import com.aliyun.svideosdk.common.struct.recorder.MediaInfo;
import com.aliyun.svideosdk.license.NativeLicense;
import com.aliyun.svideosdk.multirecorder.AliyunIVideoCapture;
import com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder;
import com.aliyun.svideosdk.multirecorder.OnVideoRecordListener;
import com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig;
import com.aliyun.svideosdk.multirecorder.impl.c.g;
import com.aliyun.svideosdk.recorder.AliyunIClipManager;
import com.aliyun.svideosdk.recorder.EncoderInfoCallback;
import com.aliyun.svideosdk.recorder.NativeRecorder;
import com.aliyun.svideosdk.transcode.NativeParser;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends com.aliyun.svideosdk.nativeload.a implements AliyunIVideoRecorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f25783a;
    private com.aliyun.svideosdk.recorder.impl.e b;
    private g c;
    private NativeRecorder d;
    private Bitmap e;
    private int f;
    private int g;
    private OnVideoRecordListener h;
    private MediaInfo i;
    private boolean j;
    private volatile boolean k;
    private Handler l;
    private boolean m;
    private OnRecordCallback n;
    private com.aliyun.svideosdk.multirecorder.impl.b o;
    private Runnable p;

    /* JADX INFO: renamed from: com.aliyun.svideosdk.multirecorder.impl.a$a, reason: collision with other inner class name */
    public class C0233a implements g.c {
        public C0233a() {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.g.c
        public void a() {
            if (a.this.k) {
                a.this.k = false;
                a.this.l.post(a.this.p);
            }
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.g.c
        public void a(int i) {
            a.this.b.c(i);
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.g.c
        public void onInitReady() {
            a.this.n.onInitReady();
        }
    }

    public class b implements OnRecordCallback {
        public b() {
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onClipComplete(boolean z, long j) {
            if (a.this.h != null) {
                a.this.h.onClipComplete(z, j);
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onError(int i) {
            if (a.this.h != null) {
                a.this.h.onError(i);
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onFinish(String str) {
            if (a.this.h != null) {
                a.this.h.onFinish(str);
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onInitReady() {
            if (a.this.h != null) {
                a.this.h.onInitReady();
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onMaxDuration() {
            if (a.this.h != null) {
                a.this.h.onMaxDuration();
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onProgress(long j) {
            if (a.this.h != null) {
                a.this.h.onProgress(j);
            }
        }
    }

    public class c implements com.aliyun.svideosdk.multirecorder.impl.b {
        public c() {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(float f) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(float f, float f2) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(float f, float f2, float f3, float f4, EffectBase effectBase) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(float f, int i, long j, long j2, long j3, long j4, long j5, long j6, int i2, String str) {
            a.this.f25783a.a(f, i, j, j2, j3, j4, j5, j6, i2, a.this.i.getVideoBitrate(), a.this.i.getCrf(), a.this.i.getEncoderFps(), a.this.i.getGop(), a.this.i.getVideoCodec(), a.this.i.getVideoQuality(), a.this.i.getVideoWidth(), a.this.i.getVideoHeight(), str);
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(int i, long j) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(long j) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(SurfaceView surfaceView) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(EffectImage effectImage, float f, float f2, float f3, float f4, int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, String str, float f6) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(CameraParam cameraParam) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(CameraType cameraType) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(FlashType flashType) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(FlashType flashType, boolean z) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(Object obj) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(String str) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(String str, int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, float f, int i2) {
            a.this.f25783a.b(str, j, j2, j3, j4, j5, j6, j7, j8, i, f, i2);
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(boolean z) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void b(float f) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void b(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void b(String str) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void b(String str, int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void b(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, float f, int i2) {
            a.this.f25783a.a(str, j, j2, j3, j4, j5, j6, j7, j8, i, f, i2);
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void b(boolean z) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void c(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void d(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void e(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void f(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void g(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void h(int i) {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    static {
        com.aliyun.svideosdk.c.a.OUTPUT_LAYER.a();
    }

    public a(Context context) {
        this.i = new MediaInfo();
        this.j = false;
        this.k = false;
        this.m = false;
        this.n = new b();
        this.o = new c();
        this.p = new d();
        if (context == null) {
            throw new IllegalArgumentException("Context is null");
        }
        e eVar = new e(context.getApplicationContext());
        this.f25783a = eVar;
        eVar.d("multi_record");
        NativeRecorder nativeRecorder = new NativeRecorder(this.f25783a.a(), true);
        this.d = nativeRecorder;
        nativeRecorder.setVideoSize(1, 1);
        com.aliyun.svideosdk.recorder.impl.e eVar2 = new com.aliyun.svideosdk.recorder.impl.e(context.getApplicationContext(), this.f25783a, this.d, true);
        this.b = eVar2;
        eVar2.a(this.n);
        this.l = new Handler(Looper.getMainLooper());
        g gVar = new g(context.getApplicationContext(), this.d, this.o, this.f25783a);
        this.c = gVar;
        gVar.a(new C0233a());
    }

    public a(Context context, AliyunVideoRecorderConfig aliyunVideoRecorderConfig) {
        this(context);
        a(aliyunVideoRecorderConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        com.aliyun.common.c.a.a.a("AliYunLog", "startMediaRecorder");
        return this.b.k();
    }

    private void a(MediaInfo mediaInfo) {
        StringBuilder sb;
        int i;
        int videoWidth = mediaInfo.getVideoWidth();
        int videoHeight = mediaInfo.getVideoHeight();
        if (mediaInfo.getVideoCodec() == VideoCodecs.H264_HARDWARE) {
            if (videoWidth % 16 != 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Correct preview width from ");
                sb2.append(videoWidth);
                sb2.append(" to ");
                int i2 = ((videoWidth / 16) + 1) * 16;
                sb2.append(i2);
                com.aliyun.common.c.a.a.d("AliYunLog", sb2.toString());
                mediaInfo.setVideoWidth(i2);
            }
            if (videoHeight % 16 == 0) {
                return;
            }
            sb = new StringBuilder();
            sb.append("Correct preview height from ");
            sb.append(videoHeight);
            sb.append(" to ");
            i = ((videoHeight / 16) + 1) * 16;
        } else {
            if (videoWidth % 2 != 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Correct preview width from ");
                sb3.append(videoWidth);
                sb3.append(" to ");
                int i3 = videoWidth - 1;
                sb3.append(i3);
                com.aliyun.common.c.a.a.d("AliYunLog", sb3.toString());
                mediaInfo.setVideoWidth(i3);
            }
            if (videoHeight % 2 == 0) {
                return;
            }
            sb = new StringBuilder();
            sb.append("Correct preview height from ");
            sb.append(videoHeight);
            sb.append(" to ");
            i = videoHeight - 1;
        }
        sb.append(i);
        com.aliyun.common.c.a.a.d("AliYunLog", sb.toString());
        mediaInfo.setVideoHeight(i);
    }

    private void a(AliyunVideoRecorderConfig aliyunVideoRecorderConfig) {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.setVideoWidth(aliyunVideoRecorderConfig.getVideoWidth());
        mediaInfo.setVideoHeight(aliyunVideoRecorderConfig.getVideoHeight());
        mediaInfo.setFps(aliyunVideoRecorderConfig.getFps());
        mediaInfo.setVideoCodec(aliyunVideoRecorderConfig.getVideoCodecs());
        mediaInfo.setCrf(aliyunVideoRecorderConfig.getCrf());
        mediaInfo.setEncoderFps(aliyunVideoRecorderConfig.getEncoderFps());
        mediaInfo.setVideoQuality(aliyunVideoRecorderConfig.getVideoQuality());
        mediaInfo.setGop(aliyunVideoRecorderConfig.getGop());
        mediaInfo.setVideoBitrate(aliyunVideoRecorderConfig.getVideoBitrate());
        setMediaInfo(mediaInfo);
        setOutputPath(aliyunVideoRecorderConfig.getOutputPath());
    }

    private void b() {
        this.k = false;
        this.l.removeCallbacks(this.p);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int addWaterMark(EffectImage effectImage) {
        if (effectImage == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        Bitmap bitmap = effectImage.getBitmap();
        if (bitmap != null) {
            this.d.getGlobalStickerManager().addBitmapSticker(effectImage.getResId(), bitmap, bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth(), effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), 0.0f);
        } else {
            if (effectImage.getPath() == null || !new File(effectImage.getPath()).exists()) {
                return -20003013;
            }
            this.d.getGlobalStickerManager().addSticker(effectImage.getResId(), effectImage.getPath(), effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), 0.0f);
        }
        this.d.updateGlobalStickers();
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized void cancelRecording() {
        com.aliyun.common.c.a.a.a("AliYunLog", "cancelRecording ");
        b();
        this.b.a();
        this.c.a(true);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int clearBackground() {
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            bitmap.recycle();
            this.e = null;
        }
        this.f = 0;
        return this.d.clearBackground();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized void destroy() {
        this.f25783a.d();
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            bitmap.recycle();
            this.e = null;
        }
        stopRecording();
        stopPreview();
        com.aliyun.common.c.a.a.a("AliYunLog", "Recorder destroy");
        this.j = true;
        this.b.a((com.aliyun.svideosdk.recorder.impl.e.d) null);
        this.b.a((OnRecordCallback) null);
        this.h = null;
        if (this.m) {
            getClipManager().deleteAllPart();
        }
        this.c.destroy();
        this.b.i();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized int finishRecording() {
        int iA;
        com.aliyun.common.c.a.a.a("AliYunLog", "finishRecording ");
        long jCurrentTimeMillis = System.currentTimeMillis();
        iA = com.aliyun.svideosdk.common.a.a(this.b.b());
        this.f25783a.b(System.currentTimeMillis() - jCurrentTimeMillis);
        return iA;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public Uri finishRecordingForEdit() {
        if (this.f25783a != null) {
            this.b.c().a(this.f25783a.c());
        }
        return this.b.c().c();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public AliyunIClipManager getClipManager() {
        return this.b.c();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public AliyunIVideoCapture getVideoCapture() {
        return this.c;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void prepare() {
        this.c.prepare();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void removeMusic() {
        com.aliyun.common.c.a.a.a("AliYunLog", "Remove background music");
        this.b.a(null, 0L, 0L, true);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int removeWaterMark(EffectImage effectImage) {
        if (effectImage == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        this.d.getGlobalStickerManager().removeSticker(effectImage.getResId());
        this.d.updateGlobalStickers();
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int setBackgroundColor(int i) {
        this.f = i;
        return this.d.setBackground(i, this.e, this.g);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int setBackgroundDisplayMode(int i) {
        this.g = i;
        return this.d.setBackground(this.f, this.e, i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int setBackgroundImage(Bitmap bitmap) {
        Bitmap bitmap2 = this.e;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.e = null;
        }
        this.e = bitmap;
        return this.d.setBackground(this.f, bitmap, this.g);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int setBackgroundImage(String str) {
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            bitmap.recycle();
            this.e = null;
        }
        if (!q.b(str) && new File(str).exists()) {
            this.e = BitmapFactory.decodeFile(str);
        }
        return this.d.setBackground(this.f, this.e, this.g);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setEncoderInfoCallback(EncoderInfoCallback encoderInfoCallback) {
        this.b.a(encoderInfoCallback);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setIsAutoClearClipVideos(boolean z) {
        this.m = z;
    }

    public void setMediaInfo(MediaInfo mediaInfo) {
        if (this.j) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Recorder has been destroyed!");
            return;
        }
        if (mediaInfo.getVideoWidth() <= 0 || mediaInfo.getVideoHeight() <= 0) {
            throw new IllegalArgumentException("The width or height must > 0");
        }
        this.i = mediaInfo;
        this.c.a(mediaInfo.getFps());
        a(mediaInfo);
        this.b.a(mediaInfo);
        this.c.a(mediaInfo.getVideoWidth(), mediaInfo.getVideoHeight());
        com.aliyun.common.c.a.a.a("AliYunLog", "set mediainfo " + mediaInfo.toString());
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int setMicDenoiseWeight(int i) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setMicDenoiseWeight: " + i);
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        return this.b.a(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setMixAudioWeight(int i, int i2) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setMixAudioWeight: bgmWeight=" + i + ", micWeight=" + i2);
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 100) {
            i2 = 100;
        }
        this.b.a(i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00a0 A[PHI: r3
      0x00a0: PHI (r3v3 long) = (r3v0 long), (r3v5 long) binds: [B:19:0x0085, B:25:0x009d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int setMusic(String str, long j, long j2) {
        long duration;
        long j3 = j;
        if (TextUtils.isEmpty(str) || j2 <= 0 || j3 < 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "setMusic error, path = " + str + " , duration  = " + j2 + " , startTime = " + j3);
            return -20001007;
        }
        if (!new File(str).exists()) {
            com.aliyun.common.c.a.a.b("AliYunLog", "setMusic  error, music filepath = " + str + " is not exit.");
            return -20001003;
        }
        NativeParser nativeParser = new NativeParser();
        nativeParser.init(str);
        String value = nativeParser.getValue(16);
        if ("unknow".equals(value)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "setMusic error, music codec not support : " + value);
            return -20001008;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            try {
                mediaPlayer.setDataSource(str);
                mediaPlayer.prepare();
                duration = mediaPlayer.getDuration();
                if (duration > 0) {
                    String value2 = nativeParser.getValue(18);
                    if (!TextUtils.isEmpty(value2)) {
                        j3 = ((Long.parseLong(value2) / 1000) * j3) / duration;
                    }
                    if (j2 <= duration) {
                        duration = j2;
                    }
                } else {
                    duration = j2;
                }
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
                mediaPlayer.release();
                duration = j2;
            }
            nativeParser.release();
            nativeParser.dispose();
            com.aliyun.common.c.a.a.a("AliYunLog", "Set background music: startTime " + j3 + ", duration " + duration);
            this.b.a(str, j3 * 1000, duration * 1000, true);
            return 0;
        } catch (Throwable th) {
            mediaPlayer.release();
            throw th;
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setMute(boolean z) {
        this.b.a(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setOnAudioCallback(OnAudioCallBack onAudioCallBack) {
        this.b.a(onAudioCallBack);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setOnRecordListener(OnVideoRecordListener onVideoRecordListener) {
        this.h = onVideoRecordListener;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setOpenMicAEC(boolean z) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setOpenMicAEC: " + z);
        this.b.b(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setOpenMixAudioMode(boolean z) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setOpenMixAudioMode: " + z);
        this.b.c(z);
    }

    public int setOutputPath(String str) {
        if (TextUtils.isEmpty(str)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        this.b.a(str);
        com.aliyun.common.c.a.a.a("AliYunLog", "set outputPath " + str);
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setRate(float f) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setRate " + f);
        if (f > 2.0d) {
            f = 2.0f;
        }
        if (f < 0.5d) {
            f = 0.5f;
        }
        this.b.a(f);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized int startPreview() {
        com.aliyun.common.c.a.a.a("AliYunLog", "VideoRecorder call startPreview");
        if (!NativeLicense.checkVersionLimit(NativeLicense.VERSION_TYPE.CUSTOM)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Version license check failed");
            OnVideoRecordListener onVideoRecordListener = this.h;
            if (onVideoRecordListener != null) {
                onVideoRecordListener.onError(AliyunErrorCode.ALIVC_FRAMEWORK_LICENSE_FAILED);
            }
            return AliyunErrorCode.ALIVC_FRAMEWORK_LICENSE_FAILED;
        }
        this.d.startPreview();
        int iStartPreview = this.c.startPreview();
        if (iStartPreview == 0) {
            this.b.h();
            return iStartPreview;
        }
        OnVideoRecordListener onVideoRecordListener2 = this.h;
        if (onVideoRecordListener2 != null) {
            onVideoRecordListener2.onError(iStartPreview);
        }
        com.aliyun.common.c.a.a.b("AliYunLog", "VideoCapture startPreview failed " + iStartPreview);
        return iStartPreview;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized int startRecording() {
        com.aliyun.common.c.a.a.a("AliYunLog", "startRecording");
        if (!NativeLicense.checkVersionLimit(NativeLicense.VERSION_TYPE.CUSTOM)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Version license check failed");
            OnVideoRecordListener onVideoRecordListener = this.h;
            if (onVideoRecordListener != null) {
                onVideoRecordListener.onError(AliyunErrorCode.ALIVC_FRAMEWORK_LICENSE_FAILED);
            }
            return AliyunErrorCode.ALIVC_FRAMEWORK_LICENSE_FAILED;
        }
        if (this.b.g()) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Current recording duration is over max duration!");
            OnVideoRecordListener onVideoRecordListener2 = this.h;
            if (onVideoRecordListener2 != null) {
                onVideoRecordListener2.onError(-20008008);
            }
            return -20008008;
        }
        int iStartRecording = this.c.startRecording();
        if (iStartRecording != 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "VideoCapture startRecording failed " + iStartRecording);
            return iStartRecording;
        }
        if (this.c.a()) {
            return a();
        }
        this.k = true;
        com.aliyun.common.c.a.a.a("AliYunLog", "RecordWaiting");
        return iStartRecording;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized void stopPreview() {
        com.aliyun.common.c.a.a.a("AliYunLog", "VideoRecorder call stopPreview");
        stopRecording();
        this.c.stopPreview();
        this.b.j();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized int stopRecording() {
        com.aliyun.common.c.a.a.a("AliYunLog", "VideoRecorder stopRecording");
        b();
        this.c.a(false);
        return this.b.m();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int updateVideoSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Update video size failed: width and height must be greater than 0");
            return -2;
        }
        com.aliyun.common.c.a.a.a("AliYunLog", "Update video size: w = " + i + " , h = " + i2);
        this.i.setVideoWidth(i);
        this.i.setVideoHeight(i2);
        a(this.i);
        this.b.a(this.i);
        this.c.a(this.i.getVideoWidth(), this.i.getVideoHeight());
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public String version() {
        return "6.7.0";
    }
}
