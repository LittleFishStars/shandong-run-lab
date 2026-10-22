package com.aliyun.svideosdk.mixrecorder.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.aliyun.common.c.b.e;
import com.aliyun.common.utils.q;
import com.aliyun.svideosdk.common.AliyunErrorCode;
import com.aliyun.svideosdk.common.AliyunRecordAVSource;
import com.aliyun.svideosdk.common.AliyunRecordVideoSource;
import com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack;
import com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback;
import com.aliyun.svideosdk.common.struct.common.VideoQuality;
import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.effect.EffectFilter;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.recorder.CameraParam;
import com.aliyun.svideosdk.common.struct.recorder.CameraType;
import com.aliyun.svideosdk.common.struct.recorder.FlashType;
import com.aliyun.svideosdk.common.struct.recorder.MediaInfo;
import com.aliyun.svideosdk.license.NativeLicense;
import com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder;
import com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam;
import com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam;
import com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam;
import com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam;
import com.aliyun.svideosdk.mixrecorder.MixAudioAecType;
import com.aliyun.svideosdk.mixrecorder.MixAudioSourceType;
import com.aliyun.svideosdk.mixrecorder.MixVideoSourceType;
import com.aliyun.svideosdk.recorder.AliyunIClipManager;
import com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager;
import com.aliyun.svideosdk.recorder.NativeRecorder;
import com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener;
import com.aliyun.svideosdk.recorder.impl.AliyunRecorderCreator;
import com.aliyun.svideosdk.recorder.impl.g;
import java.io.File;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class b implements AliyunIMixRecorder, SurfaceHolder.Callback {
    private static String w = "mix";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f25781a;
    private AliyunIClipManager b;
    private AliyunMixMediaInfoParam e;
    private MediaInfo f;
    private MediaInfo g;
    private Context h;
    private com.aliyun.svideosdk.common.b.d.a i;
    private OnRecordCallback l;
    private String n;
    private SurfaceView o;
    private Bitmap p;
    private int q;
    private int r;
    AliyunMixBorderParam s;
    private Stack<Float> c = new Stack<>();
    private boolean d = false;
    private AliyunMixRecorderDisplayParam j = new AliyunMixRecorderDisplayParam.Builder().build();
    private AliyunMixRecorderDisplayParam k = new AliyunMixRecorderDisplayParam.Builder().build();
    private float m = 1.0f;
    private MixAudioSourceType t = MixAudioSourceType.Original;
    private MixAudioAecType u = MixAudioAecType.TYPE_NONE;
    private OnRecordCallback v = new a();

    public class a implements OnRecordCallback {
        public a() {
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onClipComplete(boolean z, long j) {
            synchronized (b.this) {
                try {
                    if (z) {
                        b.this.c.push(Float.valueOf(b.this.m));
                    } else if (b.this.f25781a.b().seek(b.this.b.getDuration(TimeUnit.MICROSECONDS)) != 0) {
                        com.aliyun.common.c.a.a.b("AliYunLog", "Delete last part failed！");
                    }
                    if (b.this.l != null) {
                        b.this.l.onClipComplete(z, j);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onError(int i) {
            if (b.this.l != null) {
                b.this.l.onError(i);
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onFinish(String str) {
            if (b.this.l != null) {
                b.this.l.onFinish(str);
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onInitReady() {
            if (b.this.l != null) {
                b.this.l.onInitReady();
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onMaxDuration() {
            if (b.this.l != null) {
                b.this.l.onMaxDuration();
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onProgress(long j) {
            if (b.this.l != null) {
                b.this.l.onProgress(j);
            }
        }
    }

    public b(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.h = applicationContext;
        g gVar = (g) AliyunRecorderCreator.getRecorderInstance(applicationContext);
        this.f25781a = gVar;
        gVar.a(true);
        e eVarD = this.f25781a.d();
        if (eVarD != null) {
            eVarD.d(w);
            eVarD.a();
        }
        this.b = this.f25781a.getClipManager();
        this.i = new com.aliyun.svideosdk.common.b.d.a();
    }

    private void a() {
        if (this.f25781a.a() == null) {
            AliyunRecordAVSource aliyunRecordAVSourceCreateAVWithFile = AliyunRecordAVSource.createAVWithFile(this.e.getMixVideoFilePath(), this.e.getStreamStartTimeMills(), this.e.getStreamEndTimeMills() - this.e.getStreamStartTimeMills());
            MixAudioSourceType mixAudioSourceType = this.t;
            boolean z = mixAudioSourceType == MixAudioSourceType.Original || mixAudioSourceType == MixAudioSourceType.MIX;
            aliyunRecordAVSourceCreateAVWithFile.setVideoNeedRender(true);
            aliyunRecordAVSourceCreateAVWithFile.setAudioNeedRender(true);
            aliyunRecordAVSourceCreateAVWithFile.setVideoNeedOutput(true);
            aliyunRecordAVSourceCreateAVWithFile.setAudioNeedOutput(z);
            AliyunMixTrackLayoutParam layoutParam = this.k.getLayoutParam();
            aliyunRecordAVSourceCreateAVWithFile.setLayoutInfo(new AliyunRecordVideoSource.LayoutInfo(layoutParam.getWidthRatio(), layoutParam.getHeightRatio(), layoutParam.getCenterX(), layoutParam.getCenterY(), 0, this.k.getDisplayMode().ordinal(), this.f.getVideoWidth(), this.f.getVideoHeight()));
            AliyunMixBorderParam aliyunMixBorderParam = this.s;
            if (aliyunMixBorderParam != null) {
                aliyunRecordAVSourceCreateAVWithFile.setPureColorBorder((aliyunMixBorderParam.getBorderWidth() * 1.0f) / this.i.b(), this.s.getBorderColor(), this.s.getCornerRadius() / this.i.b());
            }
            this.f25781a.a(aliyunRecordAVSourceCreateAVWithFile);
            this.f25781a.b().addSource(aliyunRecordAVSourceCreateAVWithFile);
        }
    }

    private int b() {
        AliyunMixTrackLayoutParam layoutParam = this.j.getLayoutParam();
        AliyunMixTrackLayoutParam layoutParam2 = this.k.getLayoutParam();
        if (layoutParam == null || layoutParam2 == null || this.e == null || this.g == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "AliyunMixTrackLayoutParam can't be null!");
            return -20003002;
        }
        AliyunMixTrackLayoutParam layoutParam3 = this.k.getLayoutParam();
        this.f25781a.a().setLayoutInfo(new AliyunRecordVideoSource.LayoutInfo(layoutParam3.getWidthRatio(), layoutParam3.getHeightRatio(), layoutParam3.getCenterX(), layoutParam3.getCenterY(), this.k.getLayoutLevel(), this.k.getDisplayMode().ordinal(), this.f.getVideoWidth(), this.f.getVideoHeight()));
        this.f25781a.b().updateSource(this.f25781a.a());
        AliyunMixTrackLayoutParam layoutParam4 = this.j.getLayoutParam();
        this.f25781a.c().setLayoutInfo(new AliyunRecordVideoSource.LayoutInfo(layoutParam4.getWidthRatio(), layoutParam4.getHeightRatio(), layoutParam4.getCenterX(), layoutParam4.getCenterY(), this.j.getLayoutLevel(), this.j.getDisplayMode().ordinal(), this.f.getVideoWidth(), this.f.getVideoHeight()));
        this.f25781a.b().updateSource(this.f25781a.c());
        this.d = true;
        return 0;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int addImage(EffectImage effectImage) {
        return this.f25781a.addImage(effectImage);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int addPaster(EffectPaster effectPaster) {
        return this.f25781a.addPaster(effectPaster);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int addPaster(EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z) {
        return this.f25781a.addPaster(effectPaster, f, f2, f3, f4, f5, z);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int applyAnimationFilter(EffectFilter effectFilter) {
        return this.f25781a.applyAnimationFilter(effectFilter);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int applyFilter(EffectFilter effectFilter) {
        return this.f25781a.applyFilter(effectFilter);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int cancelFinishing() {
        return -4;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int deleteLastPart() {
        if (this.b.getDuration() <= 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "There's no last part!");
            return -4;
        }
        this.b.deleteLastPart();
        int iSeek = this.f25781a.b().seek(this.b.getDuration(TimeUnit.MICROSECONDS));
        if (iSeek != 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Delete last part failed！");
            return iSeek;
        }
        if (this.c.empty()) {
            return 0;
        }
        this.c.pop().floatValue();
        return 0;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int finishRecording() {
        if (this.b.getDuration() <= 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Can't not finish recording!!!");
            return -4;
        }
        stopPreview();
        List<String> videoPathList = this.b.getVideoPathList();
        String[] strArr = new String[videoPathList.size()];
        for (int i = 0; i < videoPathList.size(); i++) {
            strArr[i] = videoPathList.get(i);
        }
        int iStitchPart = this.f25781a.b().stitchPart(strArr, videoPathList.size(), this.i.a());
        OnRecordCallback onRecordCallback = this.l;
        if (onRecordCallback != null) {
            if (iStitchPart == 0) {
                onRecordCallback.onFinish(this.n);
            } else {
                onRecordCallback.onError(iStitchPart);
            }
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int getBeautyLevel() {
        return this.f25781a.getBeautyLevel();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int getCameraCount() {
        return this.f25781a.getCameraCount();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public AliyunIClipManager getClipManager() {
        return this.f25781a.getClipManager();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public float getCurrentExposureCompensationRatio() {
        return this.f25781a.getCurrentExposureCompensationRatio();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public AliyunIRecordPasterManager getPasterManager() {
        return this.f25781a.getPasterManager();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void needFaceTrackInternal(boolean z) {
        this.f25781a.needFaceTrackInternal(z);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void release() {
        Bitmap bitmap = this.p;
        if (bitmap != null) {
            bitmap.recycle();
            this.p = null;
        }
        this.c.clear();
        this.f25781a.release();
        this.o = null;
        this.h = null;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void removeAnimationFilter(EffectFilter effectFilter) {
        this.f25781a.removeAnimationFilter(effectFilter);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int removeFilter() {
        return this.f25781a.removeFilter();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void removeImage(EffectImage effectImage) {
        this.f25781a.removeImage(effectImage);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void removePaster(EffectPaster effectPaster) {
        this.f25781a.removePaster(effectPaster);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setBackgroundColor(int i) {
        this.q = i;
        this.f25781a.b().setBackground(this.q, this.p, this.r);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setBackgroundImage(Bitmap bitmap, int i) {
        Bitmap bitmap2 = this.p;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.p = null;
        }
        this.p = bitmap;
        this.r = i;
        this.f25781a.b().setBackground(this.q, this.p, this.r);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setBackgroundImage(String str, int i) {
        Bitmap bitmap = this.p;
        if (bitmap != null) {
            bitmap.recycle();
            this.p = null;
        }
        if (!q.b(str) && new File(str).exists()) {
            this.p = BitmapFactory.decodeFile(str);
        }
        this.r = i;
        this.f25781a.b().setBackground(this.q, this.p, this.r);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setBeautyLevel(int i) {
        this.f25781a.setBeautyLevel(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setBeautyStatus(boolean z) {
        this.f25781a.setBeautyStatus(z);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setCamera(CameraType cameraType) {
        this.f25781a.setCamera(cameraType);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setCameraCaptureDataMode(int i) {
        this.f25781a.setCameraCaptureDataMode(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setCameraParam(CameraParam cameraParam) {
        this.f25781a.setCameraParam(cameraParam);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setDisplayView(SurfaceView surfaceView, SurfaceView surfaceView2) {
        if (surfaceView == null || surfaceView2 == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid DisplayView!");
            return -20003002;
        }
        this.f25781a.setDisplayView(surfaceView);
        this.o = surfaceView2;
        a();
        SurfaceView surfaceView3 = this.o;
        if (surfaceView3 == null) {
            return 0;
        }
        surfaceView3.getHolder().addCallback(this);
        return 0;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setEffectView(float f, float f2, float f3, float f4, EffectBase effectBase) {
        return this.f25781a.setEffectView(f, f2, f3, f4, effectBase);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setExposureCompensationRatio(float f) {
        return this.f25781a.setExposureCompensationRatio(f);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setFaceDetectRotation(int i) {
        this.f25781a.setFaceDetectRotation(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setFaceTrackInternalMaxFaceCount(int i) {
        this.f25781a.setFaceTrackInternalMaxFaceCount(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setFaceTrackInternalModelPath(String str) {
        return this.f25781a.setFaceTrackInternalModelPath(str);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setFaces(float[][] fArr) {
        return this.f25781a.setFaces(fArr);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setFocus(float f, float f2) {
        this.f25781a.setFocus(f, f2);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setFocusMode(int i) {
        this.f25781a.setFocusMode(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setGop(int i) {
        this.i.d(i);
        return this.f25781a.setGop(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setIsAutoClearClipVideos(boolean z) {
        this.f25781a.setIsAutoClearClipVideos(z);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public boolean setLight(FlashType flashType) {
        return this.f25781a.setLight(flashType);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setMixAudioAecType(MixAudioAecType mixAudioAecType) {
        this.u = mixAudioAecType;
        this.f25781a.setOpenMicAEC(mixAudioAecType == MixAudioAecType.TYPE_AEC_SOFT);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setMixAudioSource(MixAudioSourceType mixAudioSourceType) {
        this.t = mixAudioSourceType;
        this.f25781a.a(mixAudioSourceType.ordinal());
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setMixAudioWeight(int i, int i2) {
        this.f25781a.setMixAudioWeight(i, i2);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setMixMediaInfo(AliyunMixMediaInfoParam aliyunMixMediaInfoParam, MediaInfo mediaInfo) {
        if (aliyunMixMediaInfoParam == null || mediaInfo == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid parameters!");
            return -20003002;
        }
        this.e = aliyunMixMediaInfoParam;
        if (aliyunMixMediaInfoParam.getRecordDisplayParam() != null) {
            this.j = aliyunMixMediaInfoParam.getRecordDisplayParam();
        }
        if (aliyunMixMediaInfoParam.getMixDisplayParam() != null) {
            this.k = aliyunMixMediaInfoParam.getMixDisplayParam();
        }
        this.f = mediaInfo;
        this.i.b(mediaInfo.getCrf());
        this.i.c(mediaInfo.getEncoderFps());
        this.i.f(mediaInfo.getVideoWidth());
        this.i.e(mediaInfo.getVideoHeight());
        MediaInfo mediaInfo2 = new MediaInfo();
        this.g = mediaInfo2;
        mediaInfo2.setCrf(this.f.getCrf());
        this.g.setEncoderFps(this.f.getEncoderFps());
        this.g.setFps(this.f.getFps());
        this.g.setVideoCodec(this.f.getVideoCodec());
        this.g.setVideoWidth(mediaInfo.getVideoWidth());
        this.g.setVideoHeight(mediaInfo.getVideoHeight());
        this.f25781a.setMediaInfo(this.g);
        return 0;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setMixedBorderParam(AliyunMixBorderParam aliyunMixBorderParam) {
        this.s = aliyunMixBorderParam;
        if (this.f25781a.a() != null) {
            if (aliyunMixBorderParam != null) {
                this.f25781a.a().setPureColorBorder((aliyunMixBorderParam.getBorderWidth() * 1.0f) / this.i.b(), aliyunMixBorderParam.getBorderColor(), aliyunMixBorderParam.getCornerRadius() / this.i.b());
            } else {
                this.f25781a.a().setPureColorBorder(0.0f, 0, 0.0f);
            }
            this.f25781a.b().updateSource(this.f25781a.a());
        }
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setOnAudioCallback(OnAudioCallBack onAudioCallBack) {
        this.f25781a.setOnAudioCallback(onAudioCallBack);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setOnChoosePictureSizeCallBack(OnChoosePictureSizeCallback onChoosePictureSizeCallback) {
        this.f25781a.setOnChoosePictureSizeCallBack(onChoosePictureSizeCallback);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setOnFaceDetectInfoListener(OnFaceDetectInfoListener onFaceDetectInfoListener) {
        this.f25781a.setOnFaceDetectInfoListener(onFaceDetectInfoListener);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setOnFrameCallback(OnFrameCallback onFrameCallback) {
        this.f25781a.setOnFrameCallback(onFrameCallback);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setOnRecordCallback(OnRecordCallback onRecordCallback) {
        g gVar;
        OnRecordCallback onRecordCallback2;
        this.l = onRecordCallback;
        if (onRecordCallback == null) {
            gVar = this.f25781a;
            onRecordCallback2 = null;
        } else {
            gVar = this.f25781a;
            onRecordCallback2 = this.v;
        }
        gVar.setOnRecordCallback(onRecordCallback2);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setOnTextureIdCallback(OnTextureIdCallback onTextureIdCallback) {
        this.f25781a.setOnTextureIdCallback(onTextureIdCallback);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setOutputPath(String str) {
        if (TextUtils.isEmpty(str)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        this.n = str;
        this.i.a(str);
        return this.f25781a.setOutputPath(str);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setRate(float f) {
        double d = f;
        if (d >= 0.5d && d <= 2.0d) {
            this.f25781a.setRate(f);
            return 0;
        }
        com.aliyun.common.c.a.a.b("AliYunLog", "Invalid rate " + f);
        return -20003002;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setRecordBorderParam(AliyunMixBorderParam aliyunMixBorderParam) {
        if (aliyunMixBorderParam != null) {
            this.f25781a.c().setPureColorBorder((aliyunMixBorderParam.getBorderWidth() * 1.0f) / this.i.b(), aliyunMixBorderParam.getBorderColor(), aliyunMixBorderParam.getCornerRadius() / this.i.b());
        } else {
            this.f25781a.c().setPureColorBorder(0.0f, 0, 0.0f);
        }
        this.f25781a.b().updateSource(this.f25781a.c());
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setRecordRotation(int i) {
        this.f25781a.setRecordRotation(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setRotation(int i) {
        this.f25781a.setRotation(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setVideoBitrate(int i) {
        this.i.a(i);
        return this.f25781a.setVideoBitrate(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setVideoQuality(VideoQuality videoQuality) {
        this.f25781a.setVideoQuality(videoQuality);
        this.i.a(videoQuality);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setZoom(float f) {
        return this.f25781a.setZoom(f);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int startPreview() {
        int iB;
        if (!NativeLicense.checkVersionLimit(NativeLicense.VERSION_TYPE.CUSTOM)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Version license check failed");
            return AliyunErrorCode.ALIVC_FRAMEWORK_LICENSE_FAILED;
        }
        if (!this.d && (iB = b()) != 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Prepare failed!");
            return iB;
        }
        int iStartPreview = this.f25781a.startPreview();
        if (iStartPreview != 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Start preview failed!ErrorCode[" + iStartPreview + "]");
            return iStartPreview;
        }
        int iSeek = this.f25781a.b().seek(this.b.getDuration(TimeUnit.MICROSECONDS));
        if (iSeek == 0) {
            return 0;
        }
        com.aliyun.common.c.a.a.b("AliYunLog", "Start preview failed!ErrorCode[" + iSeek + "]");
        return iSeek;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int startRecording() {
        if (NativeLicense.checkVersionLimit(NativeLicense.VERSION_TYPE.CUSTOM)) {
            this.f25781a.setVideoBitrate(10000);
            return this.f25781a.startRecording();
        }
        com.aliyun.common.c.a.a.b("AliYunLog", "Version license check failed");
        return AliyunErrorCode.ALIVC_FRAMEWORK_LICENSE_FAILED;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void stopPreview() {
        this.f25781a.stopPreview();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int stopRecording() {
        return this.f25781a.stopRecording();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.f25781a.a().getStickerManager() != null) {
            this.f25781a.a().getStickerManager().setDisplaySize(this.f25781a.a().getNativeHandle(), i2, i3);
            this.f25781a.b().updateSource(this.f25781a.a());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f25781a.a().setDisplay(surfaceHolder.getSurface());
        int measuredWidth = this.o.getMeasuredWidth();
        int measuredHeight = this.o.getMeasuredHeight();
        if (this.f25781a.a().getStickerManager() != null) {
            this.f25781a.a().getStickerManager().setDisplaySize(this.f25781a.a().getNativeHandle(), measuredWidth, measuredHeight);
        }
        this.f25781a.b().updateSource(this.f25781a.a());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f25781a.a().setDisplay(null);
        this.f25781a.b().updateSource(this.f25781a.a());
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int switchCamera() {
        return this.f25781a.switchCamera();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public FlashType switchLight() {
        return this.f25781a.switchLight();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int updateAnimationFilter(EffectFilter effectFilter) {
        return this.f25781a.updateAnimationFilter(effectFilter);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int updateVideoSourceLayout(AliyunMixRecorderDisplayParam aliyunMixRecorderDisplayParam, MixVideoSourceType mixVideoSourceType) {
        NativeRecorder nativeRecorderB;
        AliyunRecordVideoSource aliyunRecordVideoSourceA;
        if (this.f == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "output info should be init");
            return -4;
        }
        if (mixVideoSourceType == MixVideoSourceType.RECORD) {
            this.j = aliyunMixRecorderDisplayParam;
            AliyunMixTrackLayoutParam layoutParam = aliyunMixRecorderDisplayParam.getLayoutParam();
            this.f25781a.c().setLayoutInfo(new AliyunRecordVideoSource.LayoutInfo(layoutParam.getWidthRatio(), layoutParam.getHeightRatio(), layoutParam.getCenterX(), layoutParam.getCenterY(), this.j.getLayoutLevel(), this.j.getDisplayMode().ordinal(), this.f.getVideoWidth(), this.f.getVideoHeight()));
            nativeRecorderB = this.f25781a.b();
            aliyunRecordVideoSourceA = this.f25781a.c();
        } else {
            if (mixVideoSourceType != MixVideoSourceType.PLAY) {
                return 0;
            }
            this.k = aliyunMixRecorderDisplayParam;
            AliyunMixTrackLayoutParam layoutParam2 = aliyunMixRecorderDisplayParam.getLayoutParam();
            this.f25781a.a().setLayoutInfo(new AliyunRecordVideoSource.LayoutInfo(layoutParam2.getWidthRatio(), layoutParam2.getHeightRatio(), layoutParam2.getCenterX(), layoutParam2.getCenterY(), this.k.getLayoutLevel(), this.k.getDisplayMode().ordinal(), this.f.getVideoWidth(), this.f.getVideoHeight()));
            nativeRecorderB = this.f25781a.b();
            aliyunRecordVideoSourceA = this.f25781a.a();
        }
        nativeRecorderB.updateSource(aliyunRecordVideoSourceA);
        return 0;
    }
}
