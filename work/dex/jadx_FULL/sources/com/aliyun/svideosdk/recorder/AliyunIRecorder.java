package com.aliyun.svideosdk.recorder;

import android.graphics.Point;
import android.hardware.Camera;
import android.net.Uri;
import android.view.SurfaceView;
import com.aliyun.Visible;
import com.aliyun.common.log.struct.AliyunLogInfo;
import com.aliyun.common.utils.Size;
import com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack;
import com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnEncoderInfoCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnPictureCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback;
import com.aliyun.svideosdk.common.struct.common.VideoQuality;
import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.effect.EffectFilter;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.effect.EffectStream;
import com.aliyun.svideosdk.common.struct.recorder.CameraParam;
import com.aliyun.svideosdk.common.struct.recorder.CameraType;
import com.aliyun.svideosdk.common.struct.recorder.FlashType;
import com.aliyun.svideosdk.common.struct.recorder.MediaInfo;
import java.util.List;
import java.util.SortedSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Visible
public interface AliyunIRecorder {
    @Deprecated
    int addImage(EffectImage effectImage);

    @Deprecated
    int addPaster(EffectPaster effectPaster);

    @Deprecated
    int addPaster(EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z);

    int applyAnimationFilter(EffectFilter effectFilter);

    int applyBackgroundMusic(EffectStream effectStream);

    int applyFilter(EffectFilter effectFilter);

    void cancelRecording();

    @Deprecated
    void destroy();

    int finishRecording();

    Uri finishRecordingForEdit();

    AliyunLogInfo getAliyunLogInfo();

    int getBeautyLevel();

    int getCameraCount();

    AliyunIClipManager getClipManager();

    float getCurrentExposureCompensationRatio();

    AliyunIRecordPasterManager getPasterManager();

    List<Camera.Size> getSupportedPictureSize();

    SortedSet<Size> getSupportedPictureSizes();

    void needFaceTrackInternal(boolean z);

    void release();

    void removeAnimationFilter(EffectFilter effectFilter);

    int removeBackgroundMusic();

    int removeFilter();

    @Deprecated
    void removeImage(EffectImage effectImage);

    @Deprecated
    void removePaster(EffectPaster effectPaster);

    int resizePreviewSize(int i, int i2);

    void setBeautyLevel(int i);

    @Deprecated
    void setBeautyStatus(boolean z);

    void setCamera(CameraType cameraType);

    void setCameraCaptureDataMode(int i);

    void setCameraParam(CameraParam cameraParam);

    void setDisplayView(SurfaceView surfaceView);

    @Deprecated
    int setEffectView(float f, float f2, float f3, float f4, EffectBase effectBase);

    int setExposureCompensationRatio(float f);

    void setFaceDetectRotation(int i);

    void setFaceTrackInternalMaxFaceCount(int i);

    int setFaceTrackInternalModelPath(String str);

    int setFaces(float[][] fArr);

    void setFocus(float f, float f2);

    @Deprecated
    void setFocus(Point point);

    void setFocusMode(int i);

    @Deprecated
    int setGop(int i);

    void setIsAutoClearClipVideos(boolean z);

    boolean setLight(FlashType flashType);

    void setMediaInfo(MediaInfo mediaInfo);

    @Deprecated
    void setMusic(String str, long j, long j2);

    void setMute(boolean z);

    void setOnAudioCallback(OnAudioCallBack onAudioCallBack);

    void setOnChoosePictureSizeCallBack(OnChoosePictureSizeCallback onChoosePictureSizeCallback);

    void setOnEncoderInfoCallback(OnEncoderInfoCallback onEncoderInfoCallback);

    void setOnFaceDetectInfoListener(OnFaceDetectInfoListener onFaceDetectInfoListener);

    void setOnFrameCallback(OnFrameCallback onFrameCallback);

    void setOnRecordCallback(OnRecordCallback onRecordCallback);

    void setOnTextureIdCallback(OnTextureIdCallback onTextureIdCallback);

    int setOutputPath(String str);

    int setPictureSize(Camera.Size size);

    int setPictureSize(Size size);

    void setRate(float f);

    void setRecordRotation(int i);

    void setRotation(int i);

    void setShutterSound(boolean z);

    void setTakePicturePreview(boolean z);

    @Deprecated
    int setVideoBitrate(int i);

    int setVideoFlipH(boolean z);

    @Deprecated
    void setVideoQuality(VideoQuality videoQuality);

    int setZoom(float f);

    int startPreview();

    int startPreviewAfterTakePicture();

    int startRecording();

    void stopPreview();

    int stopRecording();

    int switchCamera();

    FlashType switchLight();

    @Deprecated
    void takePhoto(boolean z);

    @Deprecated
    void takePicture(boolean z);

    void takePicture(boolean z, OnPictureCallback onPictureCallback);

    void takeSnapshot(boolean z, OnPictureCallback onPictureCallback);

    int updateAnimationFilter(EffectFilter effectFilter);

    String version();
}
