package com.aliyun.svideosdk.common.struct.recorder;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class CameraParam {
    public static final int FOCUS_MODE_AUTO = 1;
    public static final int FOCUS_MODE_CONTINUE = 0;
    private String flashType;
    private float zoomRatio;
    private int focusMode = 0;
    private float exposureCompensation = 0.5f;

    public float getExposureCompensationRatio() {
        return this.exposureCompensation;
    }

    public String getFlashType() {
        return this.flashType;
    }

    public int getFocusMode() {
        return this.focusMode;
    }

    public float getZoomRatio() {
        return this.zoomRatio;
    }

    public void setExposureCompensationRatio(float f) {
        this.exposureCompensation = f;
    }

    public void setFlashType(String str) {
        this.flashType = str;
    }

    public void setFocusMode(int i) {
        this.focusMode = i;
    }

    public void setZoomRatio(float f) {
        this.zoomRatio = f;
    }
}
