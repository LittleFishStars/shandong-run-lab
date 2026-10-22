package com.aliyun.svideosdk.multirecorder.impl.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.aliyun.common.utils.Size;
import com.aliyun.svideo.BuildConfig;
import com.aliyun.svideosdk.common.AliyunErrorCode;
import com.aliyun.svideosdk.common.AliyunRecordVideoSource;
import com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback;
import com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam;
import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.effect.EffectFilter;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.recorder.CameraParam;
import com.aliyun.svideosdk.common.struct.recorder.CameraType;
import com.aliyun.svideosdk.common.struct.recorder.FaceDetectInfo;
import com.aliyun.svideosdk.common.struct.recorder.FlashType;
import com.aliyun.svideosdk.facearengine.FaceAREngine;
import com.aliyun.svideosdk.facearengine.FaceARFaceResult;
import com.aliyun.svideosdk.facearengine.FaceAROrganLocation;
import com.aliyun.svideosdk.facearengine.FaceARPoint2D;
import com.aliyun.svideosdk.license.NativeLicense;
import com.aliyun.svideosdk.multirecorder.AliyunICameraCapture;
import com.aliyun.svideosdk.multirecorder.OnPictureCallback;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.aliyun.svideosdk.recorder.NativeRecorder;
import com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends com.aliyun.svideosdk.multirecorder.impl.c.a implements AliyunICameraCapture, SurfaceHolder.Callback, com.aliyun.svideosdk.a.e.a.c {
    private FaceAREngine B;
    private byte[] D;
    private boolean E;
    private WindowManager G;
    private volatile SurfaceView I;
    private com.aliyun.svideosdk.preview.camera.g J;
    private com.aliyun.svideosdk.a.e.a K;
    private ViewTreeObserver.OnDrawListener L;
    private e N;
    private int O;
    private final com.aliyun.svideosdk.a.f.a m;
    private int q;
    private int s;
    private OnFaceDetectInfoListener y;
    private int z;
    private String l = null;
    private boolean n = false;
    private int o = 0;
    private boolean p = true;
    private int r = 3;
    private boolean t = false;
    private final Object u = new Object();
    private final Object v = new Object();
    private CopyOnWriteArrayList<EffectBase> w = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<EffectBase> x = new CopyOnWriteArrayList<>();
    private int A = -1;
    private String C = null;
    private boolean F = false;
    private List<SurfaceView> H = new ArrayList();
    private Object M = new Object();
    private com.aliyun.svideosdk.a.a P = new a();

    public class a implements com.aliyun.svideosdk.a.a {
        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:49:0x00ff A[Catch: all -> 0x025a, TryCatch #0 {, blocks: (B:31:0x00aa, B:33:0x00b2, B:35:0x00b4, B:37:0x00ba, B:47:0x00f7, B:49:0x00ff, B:50:0x0108, B:52:0x0116, B:53:0x0125, B:55:0x014e, B:57:0x0175, B:59:0x0181, B:61:0x0187, B:62:0x0228, B:63:0x0230, B:65:0x023d, B:67:0x0245, B:68:0x0258, B:40:0x00d6, B:42:0x00de, B:44:0x00e6, B:46:0x00f5, B:45:0x00e9), top: B:74:0x00aa }] */
        /* JADX WARN: Code duplicated, block: B:52:0x0116 A[Catch: all -> 0x025a, TryCatch #0 {, blocks: (B:31:0x00aa, B:33:0x00b2, B:35:0x00b4, B:37:0x00ba, B:47:0x00f7, B:49:0x00ff, B:50:0x0108, B:52:0x0116, B:53:0x0125, B:55:0x014e, B:57:0x0175, B:59:0x0181, B:61:0x0187, B:62:0x0228, B:63:0x0230, B:65:0x023d, B:67:0x0245, B:68:0x0258, B:40:0x00d6, B:42:0x00de, B:44:0x00e6, B:46:0x00f5, B:45:0x00e9), top: B:74:0x00aa }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0175 A[Catch: all -> 0x025a, TryCatch #0 {, blocks: (B:31:0x00aa, B:33:0x00b2, B:35:0x00b4, B:37:0x00ba, B:47:0x00f7, B:49:0x00ff, B:50:0x0108, B:52:0x0116, B:53:0x0125, B:55:0x014e, B:57:0x0175, B:59:0x0181, B:61:0x0187, B:62:0x0228, B:63:0x0230, B:65:0x023d, B:67:0x0245, B:68:0x0258, B:40:0x00d6, B:42:0x00de, B:44:0x00e6, B:46:0x00f5, B:45:0x00e9), top: B:74:0x00aa }] */
        @Override // com.aliyun.svideosdk.a.a
        public void onFrameBack(byte[] bArr, int i, int i2, Camera.CameraInfo cameraInfo) {
            int i3;
            int i4;
            FaceAROrganLocation faceOrganLocation;
            int faceCount;
            int i5;
            int i6;
            ArrayList<FaceARPoint2D> arrayList;
            if (!b.this.E || !b.this.F || b.this.n || b.this.t) {
                return;
            }
            char c = 0;
            if (b.this.w.size() == 0) {
                b.this.q = 0;
                return;
            }
            if (BuildConfig.LIB_ALI_FACE_AR_ENGINE_SUPPORTED.booleanValue()) {
                char c2 = 1;
                if (!NativeLicense.checkServiceLicense(NativeLicense.SERVICE_TYPE.STICKER)) {
                    com.aliyun.common.c.a.a.b("AliYunLog", "OnFrameInternalCallback: sticker service license check failed");
                    b.this.t = true;
                    return;
                }
                if (b.this.B == null) {
                    b.this.B = new FaceAREngine();
                    int iInit = b.this.B.init(b.this.D, i, i2, 0);
                    b.this.D = null;
                    if (iInit != 0) {
                        b.this.B.release();
                        b.this.B = null;
                        b.this.t = true;
                        return;
                    }
                    b.this.B.switchFaceDetect(true);
                }
                synchronized (b.this.u) {
                    if (b.this.B == null) {
                        return;
                    }
                    if (1 == cameraInfo.facing) {
                        int iAbs = Math.abs(270 - cameraInfo.orientation);
                        i4 = ((cameraInfo.orientation + (b.this.z - 270)) + 360) % 360;
                        if ((iAbs == 90 || iAbs == 270) && (b.this.z == 90 || b.this.z == 270)) {
                            i3 = i4 + 180;
                        }
                        if (b.this.A != i4) {
                            b.this.B.setRenderRotationAndSize(i4, i, i2);
                        }
                        if (b.this.s != b.this.r) {
                            b.this.B.setMaxFaceCount(b.this.r);
                        }
                        b.this.A = i4;
                        b bVar = b.this;
                        bVar.s = bVar.r;
                        b.this.B.renderVideoData(bArr, i, i2);
                        faceOrganLocation = b.this.B.getFaceOrganLocation();
                        faceCount = faceOrganLocation.getFaceCount();
                        com.aliyun.common.c.a.a.a("AliYunLog", "face detect result " + faceCount);
                        i5 = 6;
                        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, faceCount, 6);
                        i6 = 0;
                        while (i6 < faceCount) {
                            FaceARFaceResult faceARFaceResult = faceOrganLocation.mFacePonits.get(i6);
                            arrayList = faceARFaceResult.mFace2D;
                            if (arrayList == null && arrayList.size() != 0) {
                                float f = i;
                                fArr[i6][c] = ((faceARFaceResult.mFace2D.get(i5).x + faceARFaceResult.mFace2D.get(7).x) / 2.0f) / f;
                                float f2 = i2;
                                fArr[i6][c2] = ((faceARFaceResult.mFace2D.get(8).y + faceARFaceResult.mFace2D.get(9).y) / 2.0f) / f2;
                                fArr[i6][2] = ((faceARFaceResult.mFace2D.get(14).x + faceARFaceResult.mFace2D.get(15).x) / 2.0f) / f;
                                fArr[i6][3] = ((faceARFaceResult.mFace2D.get(16).y + faceARFaceResult.mFace2D.get(17).y) / 2.0f) / f2;
                                fArr[i6][4] = faceARFaceResult.mFace2D.get(37).x / f;
                                fArr[i6][5] = faceARFaceResult.mFace2D.get(37).y / f2;
                            }
                            i6++;
                            c = 0;
                            c2 = 1;
                            i5 = 6;
                        }
                        b.this.setFaces(fArr);
                        if (b.this.q != faceCount && b.this.y != null) {
                            b.this.q = faceCount;
                            b.this.y.onFaceInfoChange(new FaceDetectInfo(faceCount));
                        }
                    }
                    i3 = cameraInfo.orientation + (b.this.z - 90) + 360;
                    i4 = i3 % 360;
                    if (b.this.A != i4) {
                        b.this.B.setRenderRotationAndSize(i4, i, i2);
                    }
                    if (b.this.s != b.this.r) {
                        b.this.B.setMaxFaceCount(b.this.r);
                    }
                    b.this.A = i4;
                    b bVar2 = b.this;
                    bVar2.s = bVar2.r;
                    b.this.B.renderVideoData(bArr, i, i2);
                    faceOrganLocation = b.this.B.getFaceOrganLocation();
                    faceCount = faceOrganLocation.getFaceCount();
                    com.aliyun.common.c.a.a.a("AliYunLog", "face detect result " + faceCount);
                    i5 = 6;
                    float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, faceCount, 6);
                    i6 = 0;
                    while (i6 < faceCount) {
                        FaceARFaceResult faceARFaceResult2 = faceOrganLocation.mFacePonits.get(i6);
                        arrayList = faceARFaceResult2.mFace2D;
                        if (arrayList == null) {
                        }
                        i6++;
                        c = 0;
                        c2 = 1;
                        i5 = 6;
                    }
                    b.this.setFaces(fArr2);
                    if (b.this.q != faceCount) {
                        b.this.q = faceCount;
                        b.this.y.onFaceInfoChange(new FaceDetectInfo(faceCount));
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.aliyun.svideosdk.multirecorder.impl.c.b$b, reason: collision with other inner class name */
    public class C0234b implements com.aliyun.svideosdk.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPictureCallback f25790a;
        final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: com.aliyun.svideosdk.multirecorder.impl.c.b$b$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ byte[] f25791a;

            public a(byte[] bArr) {
                this.f25791a = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr;
                synchronized (b.this) {
                    C0234b.this.f25790a.onPicture(this.f25791a);
                    if (C0234b.this.b && (bArr = this.f25791a) != null && bArr.length > 0) {
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        Camera.CameraInfo cameraInfoC = b.this.J.c();
                        Matrix matrix = new Matrix();
                        int i = cameraInfoC.facing;
                        if (i == 1) {
                            matrix.postRotate(cameraInfoC.orientation);
                            matrix.postScale(-1.0f, 1.0f);
                        } else if (i == 0) {
                            matrix.postRotate(cameraInfoC.orientation);
                        }
                        try {
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, true);
                            if (bitmapCreateBitmap != bitmapDecodeByteArray) {
                                bitmapDecodeByteArray.recycle();
                            }
                            bitmapDecodeByteArray = bitmapCreateBitmap;
                        } catch (OutOfMemoryError e) {
                            com.aliyun.common.c.a.a.b("AliYunLog", "Create bitmap failed!" + e.getMessage());
                        }
                        C0234b.this.f25790a.onPicture(bitmapDecodeByteArray);
                    }
                }
            }
        }

        public C0234b(OnPictureCallback onPictureCallback, boolean z) {
            this.f25790a = onPictureCallback;
            this.b = z;
        }

        @Override // com.aliyun.svideosdk.a.c
        public void a(byte[] bArr) {
            Executors.newSingleThreadExecutor().submit(new a(bArr));
        }

        @Override // com.aliyun.svideosdk.a.c
        public void onShutter() {
        }
    }

    public class c implements com.aliyun.svideosdk.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f25792a;
        final /* synthetic */ OnPictureCallback b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f25793a;
            final /* synthetic */ int b;
            final /* synthetic */ ByteBuffer c;
            final /* synthetic */ Camera.CameraInfo d;

            public a(int i, int i2, ByteBuffer byteBuffer, Camera.CameraInfo cameraInfo) {
                this.f25793a = i;
                this.b = i2;
                this.c = byteBuffer;
                this.d = cameraInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmapA;
                int i;
                int i2;
                if (!c.this.f25792a || (i = this.f25793a) == 0 || (i2 = this.b) == 0) {
                    bitmapA = null;
                } else {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    this.c.rewind();
                    bitmapCreateBitmap.copyPixelsFromBuffer(this.c);
                    b bVar = b.this;
                    bitmapA = bVar.a(bitmapCreateBitmap, bVar.a(this.d));
                }
                OnPictureCallback onPictureCallback = c.this.b;
                if (onPictureCallback != null) {
                    onPictureCallback.onPicture(this.c.array());
                    if (bitmapA != null) {
                        c.this.b.onPicture(bitmapA);
                    }
                }
            }
        }

        public c(boolean z, OnPictureCallback onPictureCallback) {
            this.f25792a = z;
            this.b = onPictureCallback;
        }

        @Override // com.aliyun.svideosdk.a.b
        public void a(int i, int i2, Camera.CameraInfo cameraInfo, ByteBuffer byteBuffer) {
            Executors.newSingleThreadExecutor().submit(new a(i, i2, byteBuffer, cameraInfo));
        }
    }

    public class d implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f25794a;
        final /* synthetic */ int b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SurfaceView surfaceView = b.this.I;
                if (surfaceView != null) {
                    surfaceView.getViewTreeObserver().removeOnDrawListener(b.this.L);
                }
            }
        }

        /* JADX INFO: renamed from: com.aliyun.svideosdk.multirecorder.impl.c.b$d$b, reason: collision with other inner class name */
        public class RunnableC0235b implements Runnable {
            public RunnableC0235b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SurfaceView surfaceView = b.this.I;
                if (surfaceView != null) {
                    SurfaceHolder holder = surfaceView.getHolder();
                    d dVar = d.this;
                    holder.setFixedSize(dVar.f25794a, dVar.b);
                }
            }
        }

        public d(int i, int i2) {
            this.f25794a = i;
            this.b = i2;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            if (b.this.L != null) {
                b.this.I.post(new a());
                b.this.I.postDelayed(new RunnableC0235b(), 100L);
            }
        }
    }

    public interface e {
        void a(int i);

        void a(int i, float f, float f2, float f3, float f4);

        void onInitReady();
    }

    public b(Context context, com.aliyun.svideosdk.a.f.a aVar, NativeRecorder nativeRecorder, com.aliyun.common.c.b.e eVar) {
        com.aliyun.svideosdk.a.e.a aVar2 = new com.aliyun.svideosdk.a.e.a(eVar, nativeRecorder);
        this.K = aVar2;
        aVar2.a(this);
        this.m = aVar;
        this.J = com.aliyun.svideosdk.preview.camera.e.a(context, this.K, eVar, aVar);
        this.G = (WindowManager) context.getApplicationContext().getSystemService("window");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0022  */
    /* JADX WARN: Code duplicated, block: B:17:0x0024  */
    /* JADX WARN: Code duplicated, block: B:18:0x0026  */
    public int a(Camera.CameraInfo cameraInfo) {
        int i = cameraInfo.facing;
        int i2 = 270;
        if (i == 1) {
            int i3 = cameraInfo.orientation;
            if (i3 != 0) {
                if (i3 != 90) {
                    if (i3 == 180) {
                        i2 = 90;
                    } else if (i3 == 270) {
                        i2 = 180;
                    }
                }
                i2 = 0;
            }
        } else if (i != 0) {
            i2 = 0;
        } else {
            int i4 = cameraInfo.orientation;
            if (i4 != 0) {
                if (i4 == 90) {
                    i2 = 180;
                } else if (i4 != 180) {
                    i2 = 0;
                } else {
                    i2 = 90;
                }
            }
        }
        return i2 + this.J.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        matrix.postScale(-1.0f, 1.0f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e2) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Create bitmap failed!" + e2.getMessage());
            return bitmap;
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(int i) {
        super.a(i);
        this.J.a(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.e
    public void a(AliyunRecordVideoSource aliyunRecordVideoSource, AliyunLayoutParam aliyunLayoutParam, com.aliyun.svideosdk.multirecorder.impl.b bVar) {
        super.a(aliyunRecordVideoSource, aliyunLayoutParam, bVar);
        this.K.a(aliyunRecordVideoSource);
    }

    public void a(e eVar) {
        this.N = eVar;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public void a(com.aliyun.svideosdk.multirecorder.impl.c.e.b bVar) {
        bVar.a(Integer.valueOf(this.O));
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(boolean z) {
        if (this.l == null) {
            return;
        }
        this.K.l();
        com.aliyun.svideosdk.a.d.a aVarI = this.K.i();
        com.aliyun.svideosdk.a.d.a aVarG = this.K.g();
        com.aliyun.svideosdk.a.d.a aVarK = this.K.k();
        com.aliyun.svideosdk.a.d.a aVarE = this.K.e();
        if (aVarI.i() == 0 && aVarG.i() == 0 && aVarK.i() == 0 && aVarE.i() == 0) {
            return;
        }
        com.aliyun.svideosdk.multirecorder.impl.b bVar = this.i;
        if (z) {
            bVar.b(this.l, aVarI.d(), aVarI.h(), aVarG.d(), aVarG.h(), aVarK.d(), aVarK.h(), aVarE.d(), aVarE.h(), aVarI.i(), aVarI.g(), aVarI.e());
        } else {
            bVar.a(this.l, aVarI.d(), aVarI.h(), aVarG.d(), aVarG.h(), aVarK.d(), aVarK.h(), aVarE.d(), aVarE.h(), aVarI.i(), aVarI.g(), aVarI.e());
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int addImage(EffectImage effectImage) {
        int iA;
        if (effectImage == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        Bitmap bitmap = effectImage.getBitmap();
        if (bitmap != null) {
            iA = this.K.a(effectImage.getResId(), bitmap, effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), 0.0f);
        } else {
            if (effectImage.getPath() == null || !new File(effectImage.getPath()).exists()) {
                return -20003013;
            }
            iA = this.K.a(effectImage.getResId(), effectImage.getPath(), effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), 0.0f);
        }
        this.i.a(effectImage, effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), 0);
        return com.aliyun.svideosdk.common.a.a(iA);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int addPaster(EffectPaster effectPaster) {
        EffectPaster effectPaster2;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z;
        if (effectPaster != null) {
            f = effectPaster.x;
            f2 = effectPaster.y;
            f3 = effectPaster.width;
            f4 = effectPaster.height;
            f5 = effectPaster.rotation;
            z = effectPaster.mirror;
            effectPaster2 = effectPaster;
        } else {
            effectPaster2 = null;
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            f4 = 0.0f;
            f5 = 0.0f;
            z = false;
        }
        return addPaster(effectPaster2, f, f2, f3, f4, f5, z);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int addPaster(EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z) {
        if (!NativeLicense.checkServiceLicense(NativeLicense.SERVICE_TYPE.STICKER)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "addPaster: sticker service license check failed");
            return AliyunErrorCode.ALIVC_FRAMEWORK_LICENSE_CHECK_PASTER_FAILED;
        }
        if (effectPaster == null || effectPaster.getPath() == null || !new File(effectPaster.getPath()).exists()) {
            return -20001003;
        }
        int iA = com.aliyun.svideosdk.common.a.a(this.K.a(effectPaster.getPath(), effectPaster.getResId(), f, f2, f3, f4, f5, z, effectPaster.duration, effectPaster.isTrack ? 1 : 0));
        if (iA == 0 && effectPaster.isTrack) {
            this.w.add(effectPaster);
            this.J.a(false);
        }
        com.aliyun.svideosdk.multirecorder.impl.b bVar = this.i;
        boolean z2 = this.E;
        String str = this.C;
        if (str == null) {
            str = "";
        }
        bVar.a(effectPaster, f, f2, f3, f4, f5, z, z2, str, f5);
        return iA;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int applyAnimationFilter(EffectFilter effectFilter) {
        String str;
        if (effectFilter == null) {
            str = "Invalid EffectFilter!";
        } else {
            if (new File(effectFilter.getPath()).exists()) {
                String jsonString = effectFilter.toJsonString();
                com.aliyun.common.c.a.a.a("AliYunLog", "applyAnimationFilter params : " + jsonString);
                int iA = com.aliyun.svideosdk.common.a.a(this.K.b(effectFilter.getPath(), jsonString));
                effectFilter.setViewId(iA);
                this.i.b(effectFilter.getPath(), effectFilter.getViewId());
                if (iA > 0) {
                    return 0;
                }
                return iA;
            }
            str = "EffectFilter resource not exist!";
        }
        com.aliyun.common.c.a.a.b("AliYunLog", str);
        return -20003002;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int applyFilter(EffectFilter effectFilter) {
        if (effectFilter == null || TextUtils.isEmpty(effectFilter.getPath()) || !new File(effectFilter.getPath()).exists()) {
            com.aliyun.common.c.a.a.b("AliYunLog", "applyFilter error, invalid params");
            return -20003014;
        }
        com.aliyun.common.c.a.a.a("AliYunLog", "applyFilter ");
        this.i.b(effectFilter.getPath());
        return com.aliyun.svideosdk.common.a.a(this.K.a(effectFilter.getPath()));
    }

    @Override // com.aliyun.svideosdk.a.e.a.c
    public void b(int i) {
        this.O = i;
        m();
        l();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void destroy() {
        this.K.o();
        this.n = true;
        this.J.setOnFrameCallback(null);
        this.J.a((com.aliyun.svideosdk.a.a) null);
        this.J.release();
        synchronized (this.u) {
            FaceAREngine faceAREngine = this.B;
            if (faceAREngine != null) {
                faceAREngine.release();
                this.B = null;
            }
        }
        this.K.n();
        Iterator<SurfaceView> it = this.H.iterator();
        while (it.hasNext()) {
            it.next().getHolder().removeCallback(this);
        }
        this.D = null;
        this.H.clear();
        this.I = null;
        this.K.a((OnTextureIdCallback) null);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public com.aliyun.svideosdk.multirecorder.impl.c.e.a e() {
        return com.aliyun.svideosdk.multirecorder.impl.c.e.a.TEXTURE_OES_ID;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.e
    public boolean f() {
        return true;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int getBeautyLevel() {
        return this.o;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int getCameraCount() {
        return this.J.getCameraCount();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public float getCurrentExposureCompensationRatio() {
        return this.J.getCurrentExposureCompensationRatio();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public List<Camera.Size> getSupportedPictureSize() {
        return this.J.getSupportedPictureSize();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public SortedSet<Size> getSupportedPictureSizes() {
        return this.J.getSupportedPictureSizes();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.e
    public boolean h() {
        return true;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void needFaceTrackInternal(boolean z) {
        this.E = z;
        this.i.b(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void removeAnimationFilter(EffectFilter effectFilter) {
        if (effectFilter != null) {
            com.aliyun.common.c.a.a.a("AliYunLog", "removeAnimationFilter ");
            this.i.d(effectFilter.getResId());
            this.K.p();
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void removeFilter() {
        com.aliyun.common.c.a.a.a("AliYunLog", "removeFilter ");
        this.K.q();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void removeImage(EffectImage effectImage) {
        if (effectImage != null) {
            this.i.e(effectImage.getResId());
            this.K.a(effectImage.getResId());
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void removePaster(EffectPaster effectPaster) {
        if (effectPaster == null) {
            return;
        }
        if (effectPaster.isTrack) {
            synchronized (this.v) {
                Iterator<EffectBase> it = this.x.iterator();
                while (it.hasNext()) {
                    this.K.a(it.next().getResId());
                }
                this.x.clear();
                this.w.remove(effectPaster);
                if (this.w.size() == 0) {
                    this.J.a(true);
                }
                com.aliyun.common.c.a.a.a("AliYunLog", "size = " + this.w.size());
            }
        }
        this.i.g(effectPaster.getResId());
        this.K.a(effectPaster.getResId());
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int resizePreviewSize(int i, int i2) {
        com.aliyun.common.c.a.a.a("AliYunLog", "resizePreviewSize " + i + " " + i2);
        if (this.I == null) {
            return -4;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iA = this.K.a(i, i2);
        if (iA != 0) {
            return iA;
        }
        int iB = this.K.b();
        if (Build.VERSION.SDK_INT < 29) {
            this.L = new d(i, i2);
            this.I.getViewTreeObserver().addOnDrawListener(this.L);
        } else {
            this.I.getHolder().setFixedSize(i, i2);
        }
        this.i.a(System.currentTimeMillis() - jCurrentTimeMillis);
        return iB;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setAutoPreviewAfterTakePhoto(boolean z) {
        this.J.setTakePicturePreview(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized void setBeautyLevel(int i) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setBeautyLevel " + i);
        this.i.a(i);
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.o = i;
        if (this.p) {
            this.K.b(i);
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setBeautyStatus(boolean z) {
        com.aliyun.svideosdk.a.e.a aVar;
        int i;
        this.i.a(z);
        this.p = z;
        if (z) {
            aVar = this.K;
            i = this.o;
            if (i == 0) {
                i = 50;
            }
        } else {
            aVar = this.K;
            i = 0;
        }
        aVar.b(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setCamera(CameraType cameraType) {
        if (cameraType == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Camera Type!");
        } else {
            this.i.a(cameraType);
            this.J.b(cameraType.getType());
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setCameraCaptureDataMode(int i) {
        this.J.setCameraCaptureDataMode(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized void setCameraParam(CameraParam cameraParam) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setCameraParam ");
        this.i.a(cameraParam);
        this.J.setCameraParam(cameraParam);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setDisplayView(SurfaceView surfaceView) {
        if (surfaceView == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid DisplayView!");
            return;
        }
        com.aliyun.common.c.a.a.a("AliYunLog", "setDisplayView ");
        this.i.a(surfaceView);
        this.I = surfaceView;
        this.H.add(surfaceView);
        Surface surface = surfaceView.getHolder().getSurface();
        if (surface != null && surface.isValid()) {
            this.K.a(surface);
            e eVar = this.N;
            if (eVar != null) {
                eVar.onInitReady();
            }
        }
        surfaceView.getHolder().addCallback(this);
        WindowManager windowManager = (WindowManager) surfaceView.getContext().getSystemService("window");
        if (windowManager != null) {
            this.J.setRotation(windowManager.getDefaultDisplay().getRotation());
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int setEffectView(float f, float f2, float f3, float f4, EffectBase effectBase) {
        if (effectBase == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Effect Item!");
            return -20003002;
        }
        this.i.a(f, f2, f3, f4, effectBase);
        e eVar = this.N;
        if (eVar == null) {
            return 0;
        }
        eVar.a(effectBase.getResId(), f, f2, f3, f4);
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized int setExposureCompensationRatio(float f) {
        this.i.a(f);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return this.J.setExposureCompensationRatio(f);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setFaceDetectRotation(int i) {
        this.i.b(i);
        this.z = i;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setFaceTrackInternalMaxFaceCount(int i) {
        this.i.c(i);
        this.r = i;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int setFaceTrackInternalModelPath(String str) throws Throwable {
        int length;
        this.i.a(str);
        this.C = str;
        File file = new File(str + "/face_all_data_130.dat");
        com.aliyun.common.g.a aVar = new com.aliyun.common.g.a();
        byte[] bArr = new byte[1024];
        if (!file.exists()) {
            com.aliyun.common.c.a.a.b("AliYunLog", "model file is not exists");
            return -20003002;
        }
        DataInputStream dataInputStream = null;
        try {
            try {
                DataInputStream dataInputStream2 = new DataInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        int i = dataInputStream2.read(bArr);
                        length = 0;
                        if (i <= 0) {
                            break;
                        }
                        aVar.write(bArr, 0, i);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        dataInputStream = dataInputStream2;
                        com.aliyun.common.c.a.a.b("AliYunLog", "FaceTrack model path[" + str + "] not exist!" + e.getMessage());
                        try {
                            aVar.close();
                        } catch (IOException e3) {
                            com.aliyun.common.c.a.a.b("AliYunLog", "Close file stream failed!" + e3.getMessage());
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e4) {
                                com.aliyun.common.c.a.a.b("AliYunLog", "Close file stream failed!" + e4.getMessage());
                            }
                        }
                        return -20003002;
                    } catch (IOException e5) {
                        e = e5;
                        dataInputStream = dataInputStream2;
                        com.aliyun.common.c.a.a.b("AliYunLog", "FaceTrack model file[" + str + "] error!" + e.getMessage());
                        try {
                            aVar.close();
                        } catch (IOException e6) {
                            com.aliyun.common.c.a.a.b("AliYunLog", "Close file stream failed!" + e6.getMessage());
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e7) {
                                com.aliyun.common.c.a.a.b("AliYunLog", "Close file stream failed!" + e7.getMessage());
                            }
                        }
                        return -20003002;
                    } catch (Throwable th) {
                        th = th;
                        dataInputStream = dataInputStream2;
                        try {
                            aVar.close();
                        } catch (IOException e8) {
                            com.aliyun.common.c.a.a.b("AliYunLog", "Close file stream failed!" + e8.getMessage());
                        }
                        if (dataInputStream == null) {
                            throw th;
                        }
                        try {
                            dataInputStream.close();
                            throw th;
                        } catch (IOException e9) {
                            com.aliyun.common.c.a.a.b("AliYunLog", "Close file stream failed!" + e9.getMessage());
                            throw th;
                        }
                    }
                }
                byte[] bArrA = aVar.a();
                this.D = bArrA;
                int iA = com.aliyun.common.utils.e.a(bArrA, 0, false);
                byte[] bArr2 = this.D;
                if (bArr2 != null && iA == bArr2.length) {
                    this.F = true;
                    try {
                        aVar.close();
                    } catch (IOException e10) {
                        com.aliyun.common.c.a.a.b("AliYunLog", "Close file stream failed!" + e10.getMessage());
                    }
                    try {
                        dataInputStream2.close();
                    } catch (IOException e11) {
                        com.aliyun.common.c.a.a.b("AliYunLog", "Close file stream failed!" + e11.getMessage());
                    }
                    return 0;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Face model file is damaged!expectLength ");
                sb.append(iA);
                sb.append(", file size ");
                byte[] bArr3 = this.D;
                if (bArr3 != null) {
                    length = bArr3.length;
                }
                sb.append(length);
                com.aliyun.common.c.a.a.b("AliYunLog", sb.toString());
                this.D = null;
                try {
                    aVar.close();
                } catch (IOException e12) {
                    com.aliyun.common.c.a.a.b("AliYunLog", "Close file stream failed!" + e12.getMessage());
                }
                try {
                    dataInputStream2.close();
                } catch (IOException e13) {
                    com.aliyun.common.c.a.a.b("AliYunLog", "Close file stream failed!" + e13.getMessage());
                }
                return -20003002;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e14) {
            e = e14;
        } catch (IOException e15) {
            e = e15;
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int setFaces(float[][] fArr) {
        int i;
        float[][] fArr2 = fArr;
        if (!BuildConfig.LIB_ALI_FACE_AR_ENGINE_SUPPORTED.booleanValue()) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Has no privilege to use setFaces interface");
            return -20001001;
        }
        if (!NativeLicense.checkServiceLicense(NativeLicense.SERVICE_TYPE.STICKER)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "setFaces: sticker service license check failed");
            return AliyunErrorCode.ALIVC_FRAMEWORK_LICENSE_CHECK_PASTER_FAILED;
        }
        synchronized (this.v) {
            if (fArr2 != null) {
                try {
                    if (this.x != null && this.w.size() != 0) {
                        EffectBase effectBase = this.w.get(0);
                        int size = this.x.size();
                        if (fArr2.length == 0) {
                            fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 1, 6);
                        }
                        if (this.x.size() >= fArr2.length) {
                            for (int length = fArr2.length; length < size; length++) {
                                CopyOnWriteArrayList<EffectBase> copyOnWriteArrayList = this.x;
                                this.K.a(copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1).getResId());
                            }
                            for (int i2 = 0; i2 < fArr2.length; i2++) {
                                this.K.a(this.x.get(i2).getResId(), fArr2[i2]);
                            }
                        } else {
                            int length2 = fArr2.length - this.x.size();
                            int i3 = 0;
                            while (i3 < length2) {
                                if (!(effectBase instanceof EffectPaster)) {
                                    i = length2;
                                } else if (this.x.isEmpty()) {
                                    this.x.add(effectBase);
                                    i = length2;
                                } else {
                                    EffectPaster effectPaster = new EffectPaster(effectBase.getPath());
                                    i = length2;
                                    if (this.K.a(effectPaster.getPath(), effectPaster.getResId(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, effectPaster.duration, 1) == 0) {
                                        this.x.add(effectPaster);
                                    }
                                }
                                i3++;
                                length2 = i;
                            }
                            for (int i4 = 0; i4 < fArr2.length; i4++) {
                                this.K.a(this.x.get(i4).getResId(), fArr2[i4]);
                            }
                        }
                        return 0;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return -3;
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized void setFocus(float f, float f2) {
        if (this.I == null) {
            return;
        }
        this.i.a(f, f2);
        if (com.aliyun.svideosdk.a.f.a.CAMERA1 == this.m) {
            this.J.setFocus(f, f2);
        } else {
            this.J.setFocus(new Point(((int) f) * this.I.getWidth(), ((int) f2) * this.I.getHeight()));
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized void setFocus(Point point) {
        float f;
        float f2;
        if (point != null) {
            if (this.I != null) {
                int width = this.I.getWidth();
                int height = this.I.getHeight();
                if (width <= 0 || height <= 0) {
                    f = 0.0f;
                    f2 = 0.0f;
                } else {
                    f = (point.x * 1.0f) / width;
                    f2 = (point.y * 1.0f) / height;
                }
                this.i.a(f, f2);
                if (com.aliyun.svideosdk.a.f.a.CAMERA1 == this.m) {
                    this.J.setFocus(f, f2);
                } else {
                    this.J.setFocus(point);
                }
            }
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized void setFocusMode(int i) {
        this.i.f(i);
        this.J.setFocusMode(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized boolean setLight(FlashType flashType) {
        try {
            if (flashType == null) {
                com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Light!");
                return false;
            }
            com.aliyun.common.c.a.a.a("AliYunLog", "setLight ");
            boolean zA = this.J.a(flashType);
            this.i.a(flashType, zA);
            return zA;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setOnChoosePictureSizeCallBack(OnChoosePictureSizeCallback onChoosePictureSizeCallback) {
        this.J.setOnChoosePictureSizeCallBack(onChoosePictureSizeCallback);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setOnFaceDetectInfoListener(OnFaceDetectInfoListener onFaceDetectInfoListener) {
        this.y = onFaceDetectInfoListener;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setOnFrameCallback(OnFrameCallback onFrameCallback) {
        this.i.a(onFrameCallback);
        this.J.setOnFrameCallback(onFrameCallback);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setOnTextureIdCallback(OnTextureIdCallback onTextureIdCallback) {
        this.K.a(onTextureIdCallback);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setOutputFlip(boolean z) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setOutputFlip " + z);
        b(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int setPictureSize(int i, int i2) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setPictureSize " + i + " " + i2);
        return this.J.setPictureSize(i, i2);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.AliyunIBaseCapture
    public int setProperty(String str, String str2) {
        if (AliyunRecorderProperty.SURFACE_ROTATION_MODE.equals(str)) {
            return this.K.a(str, str2);
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setRecordRotation(int i) {
        this.i.h(i);
        e eVar = this.N;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setRotation(int i) {
        int i2;
        StringBuilder sb;
        String str;
        com.aliyun.common.c.a.a.a("AliYunLog", "setRotation " + i);
        this.z = i;
        if (i == 90 || i == 270) {
            i = (i + 90) % 360;
            if (this.J.c().facing == 0) {
                i2 = i + 180;
                i = i2 % 360;
            }
        } else if (i == 0 || i == 180) {
            i2 = i + 270;
            i = i2 % 360;
        }
        if (this.J.c().facing == 1) {
            int iAbs = Math.abs(270 - this.J.c().orientation);
            if (iAbs == 180 || ((iAbs == 90 || iAbs == 270) && (i == 0 || i == 360 || i == 180))) {
                i = (i + 180) % 360;
            }
            e eVar = this.N;
            if (eVar != null) {
                eVar.a(((iAbs + i) % 360) + this.G.getDefaultDisplay().getRotation());
            }
            sb = new StringBuilder();
            str = "front rotation is ";
        } else {
            e eVar2 = this.N;
            if (eVar2 != null) {
                eVar2.a(this.G.getDefaultDisplay().getRotation() + i);
            }
            sb = new StringBuilder();
            str = "back rotation is ";
        }
        sb.append(str);
        sb.append(i);
        sb.append("camera orientation is ");
        sb.append(this.J.c().orientation);
        sb.append("wm rotation is ");
        sb.append(this.G.getDefaultDisplay().getRotation());
        com.aliyun.common.c.a.a.a("AliyunRecorder", sb.toString());
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setShutterSound(boolean z) {
        this.J.setShutterSound(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized int setZoom(float f) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setZoom " + f);
        this.i.b(f);
        return this.J.setZoom(f);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void snapshot(boolean z, OnPictureCallback onPictureCallback) {
        if (onPictureCallback == null) {
            return;
        }
        synchronized (this.M) {
            this.J.a(new c(z, onPictureCallback));
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startPreview() {
        int[] iArrJ = (this.I == null || this.I.getMeasuredWidth() <= 0 || this.I.getMeasuredHeight() <= 0) ? j() : new int[]{this.I.getMeasuredWidth(), this.I.getMeasuredHeight()};
        this.J.a(iArrJ[0], iArrJ[1]);
        int iA = this.K.a(iArrJ[0], iArrJ[1]);
        if (iA != 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "changeFboSize failed, res = " + iA);
            return iA;
        }
        int iStartPreview = this.J.startPreview();
        if (iStartPreview >= 0) {
            this.J.a(this.P);
            return iStartPreview;
        }
        com.aliyun.common.c.a.a.b("AliYunLog", "startPreview failed, res = " + iStartPreview);
        return iStartPreview;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int startPreviewAfterTakePicture() {
        return this.J.startPreviewAfterTakePicture();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startRecording() {
        if (!this.J.b()) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Not start preview,so can not record video!");
            return -4;
        }
        this.K.l();
        com.aliyun.svideosdk.a.d.a aVarI = this.K.i();
        com.aliyun.svideosdk.a.d.a aVarG = this.K.g();
        com.aliyun.svideosdk.a.d.a aVarK = this.K.k();
        if (aVarI.i() == 0 && aVarG.i() == 0 && aVarK.i() == 0) {
            return 0;
        }
        this.l = com.aliyun.common.c.c.a.a();
        this.i.a(aVarI.g(), aVarI.e(), aVarI.d(), aVarI.h(), aVarG.d(), aVarG.h(), aVarK.d(), aVarK.h(), aVarI.i(), this.l);
        this.K.m();
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public void stopPreview() {
        this.J.a((com.aliyun.svideosdk.a.a) null);
        this.J.stopPreview();
        this.A = -1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        com.aliyun.svideosdk.a.e.a aVar = this.K;
        if (aVar != null) {
            aVar.a(surfaceHolder.getSurface());
        }
        this.K.a(this.I.getMeasuredWidth(), this.I.getMeasuredHeight());
        e eVar = this.N;
        if (eVar != null) {
            eVar.onInitReady();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        com.aliyun.svideosdk.a.e.a aVar = this.K;
        if (aVar != null) {
            aVar.b(surfaceHolder.getSurface());
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized int switchCamera() {
        int iSwitchCamera;
        com.aliyun.common.c.a.a.a("AliYunLog", "switchCamera ");
        long jCurrentTimeMillis = System.currentTimeMillis();
        iSwitchCamera = this.J.switchCamera();
        this.i.a(iSwitchCamera, System.currentTimeMillis() - jCurrentTimeMillis);
        return iSwitchCamera;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized FlashType switchLight() {
        FlashType flashTypeSwitchLight;
        flashTypeSwitchLight = this.J.switchLight();
        this.i.a(flashTypeSwitchLight);
        return flashTypeSwitchLight;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void takePhoto(boolean z, OnPictureCallback onPictureCallback) {
        if (onPictureCallback == null) {
            return;
        }
        this.J.a(new C0234b(onPictureCallback, z));
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int updateAnimationFilter(EffectFilter effectFilter) {
        if (effectFilter == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid EffectFilter!");
            return -20003002;
        }
        if (!new File(effectFilter.getPath()).exists()) {
            com.aliyun.common.c.a.a.b("AliYunLog", "EffectFilter resource not exist!");
            return -20003002;
        }
        String jsonString = effectFilter.toJsonString();
        com.aliyun.common.c.a.a.a("AliYunLog", "updateAnimationFilter params : " + jsonString);
        int iA = com.aliyun.svideosdk.common.a.a(this.K.b(effectFilter.getPath(), jsonString));
        this.i.a(effectFilter.getPath(), effectFilter.getResId());
        return iA;
    }
}
