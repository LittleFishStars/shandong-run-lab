package com.king.zxing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.king.zxing.camera.CameraManager;
import com.zj.adlib.es6;
import com.zj.adlib.ft5;
import com.zj.adlib.j82;
import com.zj.adlib.jv0;
import com.zj.adlib.nu3;
import com.zj.adlib.r34;
import com.zj.adlib.u15;
import com.zj.adlib.ug7;
import com.zj.adlib.xg7;
import java.io.ByteArrayOutputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class d extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f40022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f15063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CaptureHandler f15064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CameraManager f15065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ft5 f15066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15067a = true;

    public d(Context context, CameraManager cameraManager, CaptureHandler captureHandler, Map<DecodeHintType, Object> map) {
        ft5 ft5Var = new ft5();
        this.f15066a = ft5Var;
        ft5Var.e(map);
        this.f15063a = context;
        this.f15065a = cameraManager;
        this.f15064a = captureHandler;
    }

    public static void b(es6 es6Var, Bundle bundle) {
        int[] iArrM = es6Var.m();
        int iL = es6Var.l();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArrM, 0, iL, iL, es6Var.k(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray(j82.f, byteArrayOutputStream.toByteArray());
        bundle.putFloat(j82.g, iL / es6Var.e());
    }

    public final es6 a(byte[] bArr, int i, int i2, boolean z) {
        if (!z) {
            return this.f15065a.a(bArr, i, i2);
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        return this.f15065a.a(bArr2, i2, i);
    }

    public final void c(byte[] bArr, int i, int i2, boolean z, boolean z2) throws NotFoundException {
        boolean z3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        es6 es6VarA = a(bArr, i, i2, z);
        ug7 ug7VarC = null;
        if (es6VarA != null) {
            try {
                ug7VarC = this.f15066a.c(new jv0(new r34(es6VarA)));
                z3 = false;
            } catch (Exception unused) {
                z3 = true;
            }
            if (z3 && this.f15064a.e()) {
                try {
                    ug7VarC = this.f15066a.c(new jv0(new r34(es6VarA.f())));
                    z3 = false;
                } catch (Exception unused2) {
                    z3 = true;
                }
            }
            if (z3) {
                try {
                    ug7VarC = this.f15066a.c(new jv0(new nu3(es6VarA)));
                    z3 = false;
                } catch (Exception unused3) {
                    z3 = true;
                }
            }
            if (z3 && z2) {
                es6 es6VarA2 = a(bArr, i, i2, !z);
                if (es6VarA2 != null) {
                    try {
                        es6VarA = es6VarA2;
                        ug7VarC = this.f15066a.c(new jv0(new r34(es6VarA2)));
                    } catch (Exception unused4) {
                        es6VarA = es6VarA2;
                    }
                } else {
                    es6VarA = es6VarA2;
                }
            }
            this.f15066a.reset();
        }
        if (ug7VarC == null) {
            CaptureHandler captureHandler = this.f15064a;
            if (captureHandler != null) {
                Message.obtain(captureHandler, R.id.decode_failed).sendToTarget();
                return;
            }
            return;
        }
        u15.a("Found barcode in " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        BarcodeFormat barcodeFormatB = ug7VarC.b();
        CaptureHandler captureHandler2 = this.f15064a;
        if (captureHandler2 != null && captureHandler2.d() && barcodeFormatB == BarcodeFormat.QR_CODE) {
            xg7[] xg7VarArrF = ug7VarC.f();
            if (xg7VarArrF.length >= 3) {
                if (d((int) Math.max(Math.max(xg7.b(xg7VarArrF[0], xg7VarArrF[1]), xg7.b(xg7VarArrF[1], xg7VarArrF[2])), xg7.b(xg7VarArrF[0], xg7VarArrF[2])), i)) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = R.id.decode_succeeded;
                    messageObtain.obj = ug7VarC;
                    if (this.f15064a.b()) {
                        Bundle bundle = new Bundle();
                        b(es6VarA, bundle);
                        messageObtain.setData(bundle);
                    }
                    this.f15064a.sendMessageDelayed(messageObtain, 300L);
                    return;
                }
            }
        }
        CaptureHandler captureHandler3 = this.f15064a;
        if (captureHandler3 != null) {
            Message messageObtain2 = Message.obtain(captureHandler3, R.id.decode_succeeded, ug7VarC);
            if (this.f15064a.b()) {
                Bundle bundle2 = new Bundle();
                b(es6VarA, bundle2);
                messageObtain2.setData(bundle2);
            }
            messageObtain2.sendToTarget();
        }
    }

    public final boolean d(int i, int i2) {
        Camera cameraA;
        if (this.f40022a > System.currentTimeMillis() - 1000) {
            return true;
        }
        if (i >= i2 / 5 || (cameraA = this.f15065a.f().a()) == null) {
            return false;
        }
        Camera.Parameters parameters = cameraA.getParameters();
        if (!parameters.isZoomSupported()) {
            u15.l("Zoom not supported");
            return false;
        }
        int maxZoom = parameters.getMaxZoom();
        parameters.setZoom(Math.min(parameters.getZoom() + (maxZoom / 5), maxZoom));
        cameraA.setParameters(parameters);
        this.f40022a = System.currentTimeMillis();
        return true;
    }

    public final boolean e() {
        Display defaultDisplay = ((WindowManager) this.f15063a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x < point.y;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NotFoundException {
        if (message == null || !this.f15067a) {
            return;
        }
        int i = message.what;
        if (i == R.id.decode) {
            c((byte[]) message.obj, message.arg1, message.arg2, e(), this.f15064a.f());
        } else if (i == R.id.quit) {
            this.f15067a = false;
            Looper.myLooper().quit();
        }
    }
}
