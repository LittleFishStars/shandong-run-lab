package com.aliyun.svideosdk.preview.camera;

import android.graphics.Point;
import android.hardware.Camera;
import com.aliyun.common.utils.Size;
import com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback;
import com.aliyun.svideosdk.common.struct.recorder.CameraParam;
import com.aliyun.svideosdk.common.struct.recorder.FlashType;
import java.util.List;
import java.util.SortedSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface g {
    int a();

    int a(int i, int i2);

    void a(int i);

    void a(com.aliyun.svideosdk.a.a aVar);

    void a(com.aliyun.svideosdk.a.b bVar);

    void a(com.aliyun.svideosdk.a.c cVar);

    void a(boolean z);

    boolean a(FlashType flashType);

    void b(int i);

    boolean b();

    Camera.CameraInfo c();

    int getCameraCount();

    float getCurrentExposureCompensationRatio();

    List<Camera.Size> getSupportedPictureSize();

    SortedSet<Size> getSupportedPictureSizes();

    void release();

    void setCameraCaptureDataMode(int i);

    void setCameraParam(CameraParam cameraParam);

    int setExposureCompensationRatio(float f);

    void setFocus(float f, float f2);

    void setFocus(Point point);

    void setFocusMode(int i);

    void setOnChoosePictureSizeCallBack(OnChoosePictureSizeCallback onChoosePictureSizeCallback);

    void setOnFrameCallback(OnFrameCallback onFrameCallback);

    int setPictureSize(int i, int i2);

    void setRotation(int i);

    void setShutterSound(boolean z);

    void setTakePicturePreview(boolean z);

    int setZoom(float f);

    int startPreview();

    int startPreviewAfterTakePicture();

    void stopPreview();

    int switchCamera();

    FlashType switchLight();
}
