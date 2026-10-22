package com.autonavi.base.ae.gmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GLEngineIDController {
    private static final String TAG = "GLEngineIDController";
    private static GLEngineIDController sController = new GLEngineIDController();
    private int engineIDIndex = 10000;

    private GLEngineIDController() {
    }

    public static GLEngineIDController getController() {
        return sController;
    }

    public synchronized int generate() {
        int i;
        i = this.engineIDIndex + 1;
        this.engineIDIndex = i;
        return i;
    }
}
