package com.aliyun.svideosdk.multirecorder;

import android.graphics.Point;
import android.hardware.Camera;
import android.view.SurfaceView;
import com.aliyun.Visible;
import com.aliyun.common.utils.Size;
import com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback;
import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.effect.EffectFilter;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.recorder.CameraParam;
import com.aliyun.svideosdk.common.struct.recorder.CameraType;
import com.aliyun.svideosdk.common.struct.recorder.FlashType;
import com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener;
import java.util.List;
import java.util.SortedSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface AliyunICameraCapture extends AliyunIBaseCapture {
    int addImage(EffectImage effectImage);

    int addPaster(EffectPaster effectPaster);

    int addPaster(EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z);

    int applyAnimationFilter(EffectFilter effectFilter);

    int applyFilter(EffectFilter effectFilter);

    int getBeautyLevel();

    int getCameraCount();

    float getCurrentExposureCompensationRatio();

    List<Camera.Size> getSupportedPictureSize();

    SortedSet<Size> getSupportedPictureSizes();

    void needFaceTrackInternal(boolean z);

    void removeAnimationFilter(EffectFilter effectFilter);

    void removeFilter();

    void removeImage(EffectImage effectImage);

    void removePaster(EffectPaster effectPaster);

    int resizePreviewSize(int i, int i2);

    void setAutoPreviewAfterTakePhoto(boolean z);

    void setBeautyLevel(int i);

    void setBeautyStatus(boolean z);

    void setCamera(CameraType cameraType);

    void setCameraCaptureDataMode(int i);

    void setCameraParam(CameraParam cameraParam);

    void setDisplayView(SurfaceView surfaceView);

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

    boolean setLight(FlashType flashType);

    void setOnChoosePictureSizeCallBack(OnChoosePictureSizeCallback onChoosePictureSizeCallback);

    void setOnFaceDetectInfoListener(OnFaceDetectInfoListener onFaceDetectInfoListener);

    void setOnFrameCallback(OnFrameCallback onFrameCallback);

    void setOnTextureIdCallback(OnTextureIdCallback onTextureIdCallback);

    void setOutputFlip(boolean z);

    int setPictureSize(int i, int i2);

    void setRecordRotation(int i);

    void setRotation(int i);

    void setShutterSound(boolean z);

    int setZoom(float f);

    void snapshot(boolean z, OnPictureCallback onPictureCallback);

    int startPreviewAfterTakePicture();

    int switchCamera();

    FlashType switchLight();

    void takePhoto(boolean z, OnPictureCallback onPictureCallback);

    int updateAnimationFilter(EffectFilter effectFilter);
}
