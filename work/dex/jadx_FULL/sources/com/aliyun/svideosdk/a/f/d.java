package com.aliyun.svideosdk.a.f;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Log;
import android.util.Range;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@TargetApi(21)
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25614a = d.class.getSimpleName();
    private CameraCharacteristics b;
    private MeteringRectangle[] c;
    private MeteringRectangle[] d;

    public d() {
        new MeteringRectangle(0, 0, 0, 0, 0);
    }

    private int a(int i) {
        int[] iArr = (int[]) this.b.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        Log.d(this.f25614a, "getValidAntiBandingMode CONTROL_AF_AVAILABLE_MODES");
        for (int i2 : iArr) {
            if (i2 == i) {
                return i;
            }
        }
        Log.i(this.f25614a, "not support af mode:" + i + " use mode:" + iArr[0]);
        return iArr[0];
    }

    private boolean a() {
        Boolean bool = (Boolean) this.b.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        return bool != null && bool.booleanValue();
    }

    private boolean a(boolean z) {
        CameraCharacteristics cameraCharacteristics;
        CameraCharacteristics.Key key;
        if (z) {
            cameraCharacteristics = this.b;
            key = CameraCharacteristics.CONTROL_MAX_REGIONS_AF;
        } else {
            cameraCharacteristics = this.b;
            key = CameraCharacteristics.CONTROL_MAX_REGIONS_AE;
        }
        return ((Integer) cameraCharacteristics.get(key)).intValue() > 0;
    }

    private int b(int i) {
        int[] iArr = (int[]) this.b.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_ANTIBANDING_MODES);
        Log.d(this.f25614a, "getValidAntiBandingMode CONTROL_AE_AVAILABLE_ANTIBANDING_MODES");
        for (int i2 : iArr) {
            if (i2 == i) {
                return i;
            }
        }
        Log.i(this.f25614a, "not support anti banding mode:" + i + " use mode:" + iArr[0]);
        return iArr[0];
    }

    public int a(CaptureRequest.Builder builder, Range<Integer> range, float f) {
        if (builder == null) {
            return 0;
        }
        int iIntValue = ((Integer) range.getLower()).intValue();
        int iIntValue2 = ((int) ((((Integer) range.getUpper()).intValue() - iIntValue) * f)) + iIntValue;
        Log.d(this.f25614a, "setExposureCompensationRatio, compensatonFactor = " + f + ", exposureCompensation = " + iIntValue2);
        builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(iIntValue2));
        return iIntValue2;
    }

    public CaptureRequest a(CaptureRequest.Builder builder) {
        int iA = a(3);
        int iB = b(3);
        builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(iA));
        builder.set(CaptureRequest.CONTROL_AE_ANTIBANDING_MODE, Integer.valueOf(iB));
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        Log.d(this.f25614a, "getPreviewRequest, builder set CONTROL_AE_ANTIBANDING_MODE_AUTO,  CONTROL_AF_TRIGGER_IDLE, CONTROL_AF_MODE = CONTROL_AF_MODE_CONTINUOUS_VIDEO");
        return builder.build();
    }

    public CaptureRequest a(CaptureRequest.Builder builder, float f, Rect rect, Rect rect2) {
        if (builder == null) {
            Log.e(this.f25614a, "getZoomRequest, null == builder");
            return null;
        }
        int iFloor = ((int) Math.floor(rect.width() / f)) & 65532;
        int iFloor2 = ((int) Math.floor(rect.height() / f)) & 65532;
        int iWidth = (rect.width() - iFloor) >> 1;
        int iHeight = (rect.height() - iFloor2) >> 1;
        rect2.set(iWidth, iHeight, iWidth + iFloor, iHeight + iFloor2);
        builder.set(CaptureRequest.SCALER_CROP_REGION, rect2);
        Log.d(this.f25614a, "setZoom, cropX = " + iWidth + ", cropY =" + iHeight + ", cropWidth = " + iFloor + ", cropHeight = " + iFloor2);
        return builder.build();
    }

    public CaptureRequest a(CaptureRequest.Builder builder, MeteringRectangle meteringRectangle, MeteringRectangle meteringRectangle2) {
        builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(a(1)));
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        MeteringRectangle[] meteringRectangleArr = this.c;
        if (meteringRectangleArr == null) {
            this.c = new MeteringRectangle[]{meteringRectangle};
        } else {
            meteringRectangleArr[0] = meteringRectangle;
        }
        MeteringRectangle[] meteringRectangleArr2 = this.d;
        if (meteringRectangleArr2 == null) {
            this.d = new MeteringRectangle[]{meteringRectangle2};
        } else {
            meteringRectangleArr2[0] = meteringRectangle2;
        }
        if (a(true)) {
            Log.d(this.f25614a, "getTouch2FocusRequest, set CONTROL_AF_REGIONS");
            builder.set(CaptureRequest.CONTROL_AF_REGIONS, this.c);
        }
        if (a(false)) {
            builder.set(CaptureRequest.CONTROL_AE_REGIONS, this.d);
        }
        Log.d(this.f25614a, "getTouch2FocusRequest, set CONTROL_AE_REGIONS, CONTROL_AF_MODE_AUTO, CONTROL_MODE_AUTO, CONTROL_AF_REGIONS = {" + this.d[0].getRect().left + ", " + this.d[0].getRect().top + ", " + this.d[0].getRect().right + ", " + this.d[0].getRect().bottom + "}");
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        return builder.build();
    }

    public void a(CameraCharacteristics cameraCharacteristics) {
        this.b = cameraCharacteristics;
    }

    public void a(CaptureRequest.Builder builder, String str) {
        CaptureRequest.Key key;
        int i;
        CaptureRequest.Key key2;
        int i2;
        if (!a()) {
            Log.w(this.f25614a, " not support flash");
        }
        str.hashCode();
        switch (str) {
            case "on":
                key = CaptureRequest.CONTROL_AE_MODE;
                i = 3;
                builder.set(key, i);
                key2 = CaptureRequest.FLASH_MODE;
                i2 = 1;
                builder.set(key2, i2);
                break;
            case "off":
                builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                key2 = CaptureRequest.FLASH_MODE;
                i2 = 0;
                builder.set(key2, i2);
                break;
            case "auto":
                key = CaptureRequest.CONTROL_AE_MODE;
                i = 2;
                builder.set(key, i);
                key2 = CaptureRequest.FLASH_MODE;
                i2 = 1;
                builder.set(key2, i2);
                break;
            case "torch":
                builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                key2 = CaptureRequest.FLASH_MODE;
                i2 = 2;
                builder.set(key2, i2);
                break;
            default:
                Log.e(this.f25614a, "error value for flash mode");
                break;
        }
    }

    public CaptureRequest b(CaptureRequest.Builder builder, String str) {
        CaptureRequest.Key key;
        int i;
        CaptureRequest.Key key2;
        int i2;
        if (a()) {
            str.hashCode();
            switch (str) {
                case "on":
                    key = CaptureRequest.CONTROL_AE_MODE;
                    i = 3;
                    builder.set(key, i);
                    key2 = CaptureRequest.FLASH_MODE;
                    i2 = 1;
                    builder.set(key2, i2);
                    break;
                case "off":
                    builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                    key2 = CaptureRequest.FLASH_MODE;
                    i2 = 0;
                    builder.set(key2, i2);
                    break;
                case "auto":
                    key = CaptureRequest.CONTROL_AE_MODE;
                    i = 2;
                    builder.set(key, i);
                    key2 = CaptureRequest.FLASH_MODE;
                    i2 = 1;
                    builder.set(key2, i2);
                    break;
                case "torch":
                    builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                    key2 = CaptureRequest.FLASH_MODE;
                    i2 = 2;
                    builder.set(key2, i2);
                    break;
                default:
                    Log.e(this.f25614a, "error value for flash mode");
                    break;
            }
            Log.d(this.f25614a, "getFlashRequest, set FlashBuildRequest");
            builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        } else {
            Log.w(this.f25614a, " not support flash");
        }
        return builder.build();
    }
}
