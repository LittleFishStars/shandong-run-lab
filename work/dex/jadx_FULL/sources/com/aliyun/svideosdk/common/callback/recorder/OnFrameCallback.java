package com.aliyun.svideosdk.common.callback.recorder;

import android.hardware.Camera;
import com.aliyun.Visible;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface OnFrameCallback {
    Camera.Size onChoosePreviewSize(List<Camera.Size> list, Camera.Size size);

    void onFrameBack(byte[] bArr, int i, int i2, Camera.CameraInfo cameraInfo);

    void openFailed();
}
