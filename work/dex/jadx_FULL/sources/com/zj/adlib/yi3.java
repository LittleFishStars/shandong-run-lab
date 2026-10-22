package com.zj.adlib;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import com.alibaba.baichuan.log.TLogConstant;
import com.blankj.utilcode.util.Utils;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class yi3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SurfaceTexture f46035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Camera f20857a;

    public yi3() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a() {
        Camera camera = f20857a;
        if (camera == null) {
            return;
        }
        camera.release();
        f46035a = null;
        f20857a = null;
    }

    public static boolean b() {
        if (f20857a == null) {
            try {
                f20857a = Camera.open(0);
                f46035a = new SurfaceTexture(0);
            } catch (Throwable th) {
                Log.e("FlashlightUtils", "init failed: ", th);
                return false;
            }
        }
        if (f20857a != null) {
            return true;
        }
        Log.e("FlashlightUtils", "init failed.");
        return false;
    }

    public static boolean c() {
        return Utils.a().getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public static boolean d() {
        if (b()) {
            return "torch".equals(f20857a.getParameters().getFlashMode());
        }
        return false;
    }

    public static void e(boolean z) {
        if (b()) {
            Camera.Parameters parameters = f20857a.getParameters();
            if (!z) {
                if (TLogConstant.TLOG_MODULE_OFF.equals(parameters.getFlashMode())) {
                    return;
                }
                parameters.setFlashMode(TLogConstant.TLOG_MODULE_OFF);
                f20857a.setParameters(parameters);
                return;
            }
            if ("torch".equals(parameters.getFlashMode())) {
                return;
            }
            try {
                f20857a.setPreviewTexture(f46035a);
                f20857a.startPreview();
                parameters.setFlashMode("torch");
                f20857a.setParameters(parameters);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
