package com.zj.adlib;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class wx6 implements Camera.PreviewCallback {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f45707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tb1 f20581a;

    public wx6(tb1 tb1Var) {
        this.f20581a = tb1Var;
    }

    public void a(Handler handler, int i) {
        this.f45707a = handler;
        this.K = i;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point pointD = this.f20581a.d();
        Handler handler = this.f45707a;
        if (pointD == null || handler == null) {
            u15.a("Got preview callback, but no handler or resolution available");
        } else {
            handler.obtainMessage(this.K, pointD.x, pointD.y, bArr).sendToTarget();
            this.f45707a = null;
        }
    }
}
