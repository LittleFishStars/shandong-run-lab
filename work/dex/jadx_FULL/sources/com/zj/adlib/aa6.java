package com.zj.adlib;

import android.hardware.Camera;
import com.king.zxing.camera.open.CameraFacing;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class aa6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40495a = -1;

    public static z96 a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            u15.z("No cameras!");
            return null;
        }
        if (i >= numberOfCameras) {
            u15.z("Requested camera does not exist: " + i);
            return null;
        }
        if (i <= -1) {
            i = 0;
            int i2 = 0;
            while (i2 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (CameraFacing.values()[cameraInfo.facing] == CameraFacing.BACK) {
                    break;
                }
                i2++;
            }
            if (i2 == numberOfCameras) {
                u15.l("No camera facing " + CameraFacing.BACK + "; returning camera #0");
            } else {
                i = i2;
            }
        }
        u15.l("Opening camera #" + i);
        Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo2);
        Camera cameraOpen = Camera.open(i);
        if (cameraOpen == null) {
            return null;
        }
        return new z96(i, cameraOpen, CameraFacing.values()[cameraInfo2.facing], cameraInfo2.orientation);
    }
}
