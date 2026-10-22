package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.WindowManager;
import com.king.zxing.camera.FrontLightMode;
import com.king.zxing.camera.open.CameraFacing;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class tb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f19765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Point f19766a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Point f19767b;
    public Point c;
    public Point d;

    public tb1(Context context) {
        this.f19765a = context;
    }

    public final void a(Camera.Parameters parameters, boolean z, boolean z2) {
        ub1.o(parameters, z);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f19765a);
        if (z2 || defaultSharedPreferences.getBoolean(mx6.u, true)) {
            return;
        }
        ub1.h(parameters, z);
    }

    public Point b() {
        return this.c;
    }

    public int c() {
        return this.f44883a;
    }

    public Point d() {
        return this.f19767b;
    }

    public Point e() {
        return this.d;
    }

    public Point f() {
        return this.f19766a;
    }

    public boolean g(Camera camera) {
        Camera.Parameters parameters;
        if (camera == null || (parameters = camera.getParameters()) == null) {
            return false;
        }
        String flashMode = parameters.getFlashMode();
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    public void h(z96 z96Var) {
        int i;
        Camera.Parameters parameters = z96Var.a().getParameters();
        Display defaultDisplay = ((WindowManager) this.f19765a.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        if (rotation == 0) {
            i = 0;
        } else if (rotation == 1) {
            i = 90;
        } else if (rotation == 2) {
            i = 180;
        } else if (rotation == 3) {
            i = 270;
        } else {
            if (rotation % 90 != 0) {
                throw new IllegalArgumentException("Bad rotation: " + rotation);
            }
            i = (rotation + 360) % 360;
        }
        u15.l("Display at: " + i);
        int iC = z96Var.c();
        u15.l("Camera at: " + iC);
        CameraFacing cameraFacingB = z96Var.b();
        CameraFacing cameraFacing = CameraFacing.FRONT;
        if (cameraFacingB == cameraFacing) {
            iC = (360 - iC) % 360;
            u15.l("Front camera overriden to: " + iC);
        }
        this.b = ((iC + 360) - i) % 360;
        u15.l("Final display orientation: " + this.b);
        if (z96Var.b() == cameraFacing) {
            u15.l("Compensating rotation for front camera");
            this.f44883a = (360 - this.b) % 360;
        } else {
            this.f44883a = this.b;
        }
        u15.l("Clockwise rotation from display to camera: " + this.f44883a);
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f19766a = point;
        u15.l("Screen resolution in current orientation: " + this.f19766a);
        this.f19767b = ub1.d(parameters, this.f19766a);
        u15.l("Camera resolution: " + this.f19767b);
        this.c = ub1.d(parameters, this.f19766a);
        u15.l("Best available preview size: " + this.c);
        Point point2 = this.f19766a;
        boolean z = point2.x < point2.y;
        Point point3 = this.c;
        if (z == (point3.x < point3.y)) {
            this.d = point3;
        } else {
            Point point4 = this.c;
            this.d = new Point(point4.y, point4.x);
        }
        u15.l("Preview size on screen: " + this.d);
    }

    public final void i(Camera.Parameters parameters, SharedPreferences sharedPreferences, boolean z) {
        a(parameters, FrontLightMode.readPref(sharedPreferences) == FrontLightMode.ON, z);
    }

    public void j(z96 z96Var, boolean z) {
        Camera cameraA = z96Var.a();
        Camera.Parameters parameters = cameraA.getParameters();
        if (parameters == null) {
            u15.z("Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        u15.l("Initial camera parameters: " + parameters.flatten());
        if (z) {
            u15.z("In camera config safe mode -- most settings will not be honored");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f19765a);
        if (parameters.isZoomSupported()) {
            parameters.setZoom(parameters.getMaxZoom() / 10);
        }
        i(parameters, defaultSharedPreferences, z);
        ub1.k(parameters, defaultSharedPreferences.getBoolean(mx6.p, true), defaultSharedPreferences.getBoolean(mx6.t, true), z);
        if (!z) {
            if (defaultSharedPreferences.getBoolean(mx6.q, false)) {
                ub1.m(parameters);
            }
            if (!defaultSharedPreferences.getBoolean(mx6.w, true)) {
                ub1.g(parameters);
            }
            if (!defaultSharedPreferences.getBoolean(mx6.v, true)) {
                ub1.p(parameters);
                ub1.l(parameters);
                ub1.n(parameters);
            }
            parameters.setRecordingHint(true);
        }
        Point point = this.c;
        parameters.setPreviewSize(point.x, point.y);
        cameraA.setParameters(parameters);
        cameraA.setDisplayOrientation(this.b);
        Camera.Size previewSize = cameraA.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.c;
            if (point2.x == previewSize.width && point2.y == previewSize.height) {
                return;
            }
            u15.z("Camera said it supported preview size " + this.c.x + 'x' + this.c.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            Point point3 = this.c;
            point3.x = previewSize.width;
            point3.y = previewSize.height;
        }
    }

    public void k(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        a(parameters, z, false);
        camera.setParameters(parameters);
    }
}
