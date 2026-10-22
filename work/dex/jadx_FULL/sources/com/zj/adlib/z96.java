package com.zj.adlib;

import android.hardware.Camera;
import com.king.zxing.camera.open.CameraFacing;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class z96 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Camera f21007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CameraFacing f21008a;
    public final int b;

    public z96(int i, Camera camera, CameraFacing cameraFacing, int i2) {
        this.f46218a = i;
        this.f21007a = camera;
        this.f21008a = cameraFacing;
        this.b = i2;
    }

    public Camera a() {
        return this.f21007a;
    }

    public CameraFacing b() {
        return this.f21008a;
    }

    public int c() {
        return this.b;
    }

    public String toString() {
        return "Camera #" + this.f46218a + " : " + this.f21008a + ',' + this.b;
    }
}
