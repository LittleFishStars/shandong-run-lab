package com.king.zxing;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.king.zxing.camera.CameraManager;
import com.zj.adlib.j82;
import com.zj.adlib.ug7;
import com.zj.adlib.xg7;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class CaptureHandler extends Handler implements ResultPointCallback {
    public static final String f = "CaptureHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f40012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final OnCaptureListener f15007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ViewfinderView f15008a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CameraManager f15009a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final j82 f15010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15011a;
    public boolean b;
    public boolean c;
    public boolean d;

    public enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public CaptureHandler(Activity activity, ViewfinderView viewfinderView, OnCaptureListener onCaptureListener, Collection<BarcodeFormat> collection, Map<DecodeHintType, Object> map, String str, CameraManager cameraManager) {
        this.f15008a = viewfinderView;
        this.f15007a = onCaptureListener;
        j82 j82Var = new j82(activity, cameraManager, this, collection, map, str, this);
        this.f15010a = j82Var;
        j82Var.start();
        this.f40012a = State.SUCCESS;
        this.f15009a = cameraManager;
        cameraManager.s();
        h();
    }

    @Override // com.google.zxing.ResultPointCallback
    public void a(xg7 xg7Var) {
        if (this.f15008a != null) {
            this.f15008a.addPossibleResultPoint(m(xg7Var));
        }
    }

    public boolean b() {
        return this.b;
    }

    public final boolean c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x < point.y;
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        return this.d;
    }

    public boolean f() {
        return this.f15011a;
    }

    public void g() {
        this.f40012a = State.DONE;
        this.f15009a.t();
        Message.obtain(this.f15010a.b(), R.id.quit).sendToTarget();
        try {
            this.f15010a.join(100L);
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }

    public void h() {
        if (this.f40012a == State.SUCCESS) {
            this.f40012a = State.PREVIEW;
            this.f15009a.j(this.f15010a.b(), R.id.decode);
            ViewfinderView viewfinderView = this.f15008a;
            if (viewfinderView != null) {
                viewfinderView.drawViewfinder();
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        float f2;
        int i = message.what;
        if (i == R.id.restart_preview) {
            h();
            return;
        }
        if (i != R.id.decode_succeeded) {
            if (i == R.id.decode_failed) {
                this.f40012a = State.PREVIEW;
                this.f15009a.j(this.f15010a.b(), R.id.decode);
                return;
            }
            return;
        }
        this.f40012a = State.SUCCESS;
        Bundle data = message.getData();
        Bitmap bitmapCopy = null;
        if (data != null) {
            byte[] byteArray = data.getByteArray(j82.f);
            bitmapCopy = byteArray != null ? BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, null).copy(Bitmap.Config.ARGB_8888, true) : null;
            f2 = data.getFloat(j82.g);
        } else {
            f2 = 1.0f;
        }
        this.f15007a.a((ug7) message.obj, bitmapCopy, f2);
    }

    public void i(boolean z) {
        this.b = z;
    }

    public void j(boolean z) {
        this.c = z;
    }

    public void k(boolean z) {
        this.d = z;
    }

    public void l(boolean z) {
        this.f15011a = z;
    }

    public final xg7 m(xg7 xg7Var) {
        float fC;
        float fD;
        int iMax;
        Point pointG = this.f15009a.g();
        Point pointC = this.f15009a.c();
        int i = pointG.x;
        int i2 = pointG.y;
        if (i < i2) {
            float f2 = (i * 1.0f) / pointC.y;
            float f3 = (i2 * 1.0f) / pointC.x;
            fC = (xg7Var.c() * f2) - (Math.max(pointG.x, pointC.y) / 2);
            fD = xg7Var.d() * f3;
            iMax = Math.min(pointG.y, pointC.x) / 2;
        } else {
            float f4 = (i * 1.0f) / pointC.x;
            float f5 = (i2 * 1.0f) / pointC.y;
            fC = (xg7Var.c() * f4) - (Math.min(pointG.y, pointC.y) / 2);
            fD = xg7Var.d() * f5;
            iMax = Math.max(pointG.x, pointC.x) / 2;
        }
        return new xg7(fC, fD - iMax);
    }
}
