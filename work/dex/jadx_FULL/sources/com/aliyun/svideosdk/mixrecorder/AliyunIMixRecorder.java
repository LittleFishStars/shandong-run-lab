package com.aliyun.svideosdk.mixrecorder;

import android.graphics.Bitmap;
import android.view.SurfaceView;
import com.aliyun.Visible;
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
import com.aliyun.svideosdk.recorder.AliyunIClipManager;
import com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager;
import com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIMixRecorder {
    @Deprecated
    int addImage(EffectImage effectImage);

    @Deprecated
    int addPaster(EffectPaster effectPaster);

    @Deprecated
    int addPaster(EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z);

    int applyAnimationFilter(EffectFilter effectFilter);

    int applyFilter(EffectFilter effectFilter);

    int cancelFinishing();

    int deleteLastPart();

    int finishRecording();

    int getBeautyLevel();

    int getCameraCount();

    AliyunIClipManager getClipManager();

    float getCurrentExposureCompensationRatio();

    AliyunIRecordPasterManager getPasterManager();

    void needFaceTrackInternal(boolean z);

    void release();

    void removeAnimationFilter(EffectFilter effectFilter);

    int removeFilter();

    @Deprecated
    void removeImage(EffectImage effectImage);

    @Deprecated
    void removePaster(EffectPaster effectPaster);

    void setBackgroundColor(int i);

    void setBackgroundImage(Bitmap bitmap, int i);

    void setBackgroundImage(String str, int i);

    void setBeautyLevel(int i);

    @Deprecated
    void setBeautyStatus(boolean z);

    void setCamera(CameraType cameraType);

    void setCameraCaptureDataMode(int i);

    void setCameraParam(CameraParam cameraParam);

    int setDisplayView(SurfaceView surfaceView, SurfaceView surfaceView2);

    @Deprecated
    int setEffectView(float f, float f2, float f3, float f4, EffectBase effectBase);

    int setExposureCompensationRatio(float f);

    void setFaceDetectRotation(int i);

    void setFaceTrackInternalMaxFaceCount(int i);

    int setFaceTrackInternalModelPath(String str);

    int setFaces(float[][] fArr);

    void setFocus(float f, float f2);

    void setFocusMode(int i);

    @Deprecated
    int setGop(int i);

    void setIsAutoClearClipVideos(boolean z);

    boolean setLight(FlashType flashType);

    void setMixAudioAecType(MixAudioAecType mixAudioAecType);

    void setMixAudioSource(MixAudioSourceType mixAudioSourceType);

    void setMixAudioWeight(int i, int i2);

    int setMixMediaInfo(AliyunMixMediaInfoParam aliyunMixMediaInfoParam, MediaInfo mediaInfo);

    void setMixedBorderParam(AliyunMixBorderParam aliyunMixBorderParam);

    void setOnAudioCallback(OnAudioCallBack onAudioCallBack);

    void setOnChoosePictureSizeCallBack(OnChoosePictureSizeCallback onChoosePictureSizeCallback);

    void setOnFaceDetectInfoListener(OnFaceDetectInfoListener onFaceDetectInfoListener);

    void setOnFrameCallback(OnFrameCallback onFrameCallback);

    void setOnRecordCallback(OnRecordCallback onRecordCallback);

    void setOnTextureIdCallback(OnTextureIdCallback onTextureIdCallback);

    int setOutputPath(String str);

    int setRate(float f);

    void setRecordBorderParam(AliyunMixBorderParam aliyunMixBorderParam);

    void setRecordRotation(int i);

    void setRotation(int i);

    @Deprecated
    int setVideoBitrate(int i);

    @Deprecated
    void setVideoQuality(VideoQuality videoQuality);

    int setZoom(float f);

    int startPreview();

    int startRecording();

    void stopPreview();

    int stopRecording();

    int switchCamera();

    FlashType switchLight();

    int updateAnimationFilter(EffectFilter effectFilter);

    int updateVideoSourceLayout(AliyunMixRecorderDisplayParam aliyunMixRecorderDisplayParam, MixVideoSourceType mixVideoSourceType);
}
