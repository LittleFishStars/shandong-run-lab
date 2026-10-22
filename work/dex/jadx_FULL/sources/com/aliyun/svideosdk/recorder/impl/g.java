package com.aliyun.svideosdk.recorder.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.aliyun.common.log.struct.AliyunLogInfo;
import com.aliyun.common.utils.Size;
import com.aliyun.svideo.BuildConfig;
import com.aliyun.svideosdk.common.AliyunErrorCode;
import com.aliyun.svideosdk.common.AliyunRecordAVSource;
import com.aliyun.svideosdk.common.AliyunRecordVideoSource;
import com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack;
import com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnEncoderInfoCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnPictureCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;
import com.aliyun.svideosdk.common.struct.common.VideoQuality;
import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.effect.EffectFilter;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.effect.EffectSticker;
import com.aliyun.svideosdk.common.struct.effect.EffectStream;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.common.struct.recorder.CameraParam;
import com.aliyun.svideosdk.common.struct.recorder.CameraType;
import com.aliyun.svideosdk.common.struct.recorder.FaceDetectInfo;
import com.aliyun.svideosdk.common.struct.recorder.FlashType;
import com.aliyun.svideosdk.common.struct.recorder.MediaInfo;
import com.aliyun.svideosdk.facearengine.FaceAREngine;
import com.aliyun.svideosdk.facearengine.FaceARFaceResult;
import com.aliyun.svideosdk.facearengine.FaceAROrganLocation;
import com.aliyun.svideosdk.facearengine.FaceARPoint2D;
import com.aliyun.svideosdk.license.NativeLicense;
import com.aliyun.svideosdk.recorder.AliyunIClipManager;
import com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager;
import com.aliyun.svideosdk.recorder.AliyunIRecorder;
import com.aliyun.svideosdk.recorder.NativeRecorder;
import com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener;
import com.aliyun.svideosdk.recorder.RecordCallback;
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
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g extends com.aliyun.svideosdk.nativeload.a implements AliyunIRecorder, SurfaceHolder.Callback, com.aliyun.svideosdk.recorder.impl.d {
    private volatile SurfaceView A;
    private byte[] D;
    private com.aliyun.common.c.b.e F;
    private ViewTreeObserver.OnDrawListener G;
    private f H;
    private AliyunRecordVideoSource K;
    private AliyunRecordAVSource L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.aliyun.svideosdk.a.f.a f25846a;
    private final com.aliyun.svideosdk.preview.camera.g b;
    private com.aliyun.svideosdk.a.e.a c;
    private NativeRecorder d;
    private com.aliyun.svideosdk.recorder.impl.e e;
    private OnRecordCallback h;
    private boolean i;
    private int k;
    private FaceAREngine m;
    private AliyunLogInfo n;
    private WindowManager o;
    private int p;
    private OnFaceDetectInfoListener q;
    private MediaInfo r;
    private int t;
    private CopyOnWriteArrayList<EffectBase> f = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<EffectBase> g = new CopyOnWriteArrayList<>();
    private boolean j = false;
    private int l = -1;
    private int s = 3;
    private boolean u = false;
    private int v = 50;
    private final Object w = new Object();
    private final Object x = new Object();
    private boolean y = false;
    private List<SurfaceView> z = new ArrayList();
    private float B = 1.0f;
    private String C = null;
    private String E = null;
    private boolean I = false;
    private boolean J = false;
    private com.aliyun.svideosdk.a.a M = new a();

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
            if (!g.this.i || !g.this.j || g.this.u || g.this.y) {
                return;
            }
            char c = 0;
            if (g.this.f.size() == 0) {
                g.this.p = 0;
                return;
            }
            if (BuildConfig.LIB_ALI_FACE_AR_ENGINE_SUPPORTED.booleanValue()) {
                char c2 = 1;
                if (!NativeLicense.checkServiceLicense(NativeLicense.SERVICE_TYPE.STICKER)) {
                    com.aliyun.common.c.a.a.b("AliYunLog", "OnFrameInternalCallback: sticker service license check failed");
                    g.this.y = true;
                    return;
                }
                if (g.this.m == null) {
                    g.this.m = new FaceAREngine();
                    int iInit = g.this.m.init(g.this.D, i, i2, 0);
                    g.this.D = null;
                    if (iInit != 0) {
                        g.this.m.release();
                        g.this.m = null;
                        g.this.y = true;
                        return;
                    }
                    g.this.m.switchFaceDetect(true);
                }
                synchronized (g.this.w) {
                    if (g.this.m == null) {
                        return;
                    }
                    if (1 == cameraInfo.facing) {
                        int iAbs = Math.abs(270 - cameraInfo.orientation);
                        i4 = ((cameraInfo.orientation + (g.this.k - 270)) + 360) % 360;
                        if ((iAbs == 90 || iAbs == 270) && (g.this.k == 90 || g.this.k == 270)) {
                            i3 = i4 + 180;
                        }
                        if (g.this.l != i4) {
                            g.this.m.setRenderRotationAndSize(i4, i, i2);
                        }
                        if (g.this.t != g.this.s) {
                            g.this.m.setMaxFaceCount(g.this.s);
                        }
                        g.this.l = i4;
                        g gVar = g.this;
                        gVar.t = gVar.s;
                        g.this.m.renderVideoData(bArr, i, i2);
                        faceOrganLocation = g.this.m.getFaceOrganLocation();
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
                        g.this.setFaces(fArr);
                        if (g.this.p != faceCount && g.this.q != null) {
                            g.this.p = faceCount;
                            g.this.q.onFaceInfoChange(new FaceDetectInfo(faceCount));
                        }
                    }
                    i3 = cameraInfo.orientation + (g.this.k - 90) + 360;
                    i4 = i3 % 360;
                    if (g.this.l != i4) {
                        g.this.m.setRenderRotationAndSize(i4, i, i2);
                    }
                    if (g.this.t != g.this.s) {
                        g.this.m.setMaxFaceCount(g.this.s);
                    }
                    g.this.l = i4;
                    g gVar2 = g.this;
                    gVar2.t = gVar2.s;
                    g.this.m.renderVideoData(bArr, i, i2);
                    faceOrganLocation = g.this.m.getFaceOrganLocation();
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
                    g.this.setFaces(fArr2);
                    if (g.this.p != faceCount) {
                        g.this.p = faceCount;
                        g.this.q.onFaceInfoChange(new FaceDetectInfo(faceCount));
                    }
                }
            }
        }
    }

    public class b implements com.aliyun.svideosdk.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f25848a;
        final /* synthetic */ OnPictureCallback b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ byte[] f25849a;

            public a(byte[] bArr) {
                this.f25849a = bArr;
            }

            /* JADX WARN: Code duplicated, block: B:27:0x007e A[Catch: all -> 0x00ae, TryCatch #1 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0012, B:12:0x002e, B:16:0x0046, B:18:0x0056, B:25:0x0078, B:27:0x007e, B:33:0x00ac, B:28:0x0084, B:30:0x008e, B:32:0x009f, B:22:0x005d, B:14:0x003e), top: B:40:0x0005, inners: #0 }] */
            /* JADX WARN: Code duplicated, block: B:28:0x0084 A[Catch: all -> 0x00ae, TryCatch #1 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0012, B:12:0x002e, B:16:0x0046, B:18:0x0056, B:25:0x0078, B:27:0x007e, B:33:0x00ac, B:28:0x0084, B:30:0x008e, B:32:0x009f, B:22:0x005d, B:14:0x003e), top: B:40:0x0005, inners: #0 }] */
            /* JADX WARN: Code duplicated, block: B:30:0x008e A[Catch: all -> 0x00ae, TryCatch #1 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0012, B:12:0x002e, B:16:0x0046, B:18:0x0056, B:25:0x0078, B:27:0x007e, B:33:0x00ac, B:28:0x0084, B:30:0x008e, B:32:0x009f, B:22:0x005d, B:14:0x003e), top: B:40:0x0005, inners: #0 }] */
            /* JADX WARN: Code duplicated, block: B:32:0x009f A[Catch: all -> 0x00ae, TryCatch #1 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0012, B:12:0x002e, B:16:0x0046, B:18:0x0056, B:25:0x0078, B:27:0x007e, B:33:0x00ac, B:28:0x0084, B:30:0x008e, B:32:0x009f, B:22:0x005d, B:14:0x003e), top: B:40:0x0005, inners: #0 }] */
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmapDecodeByteArray;
                Bitmap bitmapCreateBitmap;
                b bVar;
                OnPictureCallback onPictureCallback;
                byte[] bArr;
                synchronized (g.this) {
                    if (!b.this.f25848a || (bArr = this.f25849a) == null || bArr.length <= 0) {
                        bitmapDecodeByteArray = null;
                    } else {
                        bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        Camera.CameraInfo cameraInfoC = g.this.b.c();
                        Matrix matrix = new Matrix();
                        int i = cameraInfoC.facing;
                        if (i == 1) {
                            matrix.postRotate(cameraInfoC.orientation);
                            matrix.postScale(-1.0f, 1.0f);
                        } else if (i == 0) {
                            matrix.postRotate(cameraInfoC.orientation);
                        }
                        try {
                            bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, true);
                            if (bitmapCreateBitmap != bitmapDecodeByteArray) {
                                bitmapDecodeByteArray.recycle();
                            }
                        } catch (OutOfMemoryError e) {
                            com.aliyun.common.c.a.a.b("AliYunLog", "Create bitmap failed!" + e.getMessage());
                            bitmapCreateBitmap = bitmapDecodeByteArray;
                        }
                        bVar = b.this;
                        onPictureCallback = bVar.b;
                        if (onPictureCallback != null) {
                            onPictureCallback.onPicture(bitmapCreateBitmap, this.f25849a);
                        } else if (g.this.h instanceof RecordCallback) {
                            ((RecordCallback) g.this.h).onPictureDataBack(this.f25849a);
                            if (bitmapCreateBitmap != null) {
                                ((RecordCallback) g.this.h).onPictureBack(bitmapCreateBitmap);
                            }
                        }
                    }
                    bitmapCreateBitmap = bitmapDecodeByteArray;
                    bVar = b.this;
                    onPictureCallback = bVar.b;
                    if (onPictureCallback != null) {
                        onPictureCallback.onPicture(bitmapCreateBitmap, this.f25849a);
                    } else if (g.this.h instanceof RecordCallback) {
                        ((RecordCallback) g.this.h).onPictureDataBack(this.f25849a);
                        if (bitmapCreateBitmap != null) {
                            ((RecordCallback) g.this.h).onPictureBack(bitmapCreateBitmap);
                        }
                    }
                }
            }
        }

        public b(boolean z, OnPictureCallback onPictureCallback) {
            this.f25848a = z;
            this.b = onPictureCallback;
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
        final /* synthetic */ boolean f25850a;
        final /* synthetic */ OnPictureCallback b;

        public c(boolean z, OnPictureCallback onPictureCallback) {
            this.f25850a = z;
            this.b = onPictureCallback;
        }

        @Override // com.aliyun.svideosdk.a.b
        public void a(int i, int i2, Camera.CameraInfo cameraInfo, ByteBuffer byteBuffer) {
            Bitmap bitmapA;
            if (!this.f25850a || i == 0 || i2 == 0) {
                bitmapA = null;
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                byteBuffer.rewind();
                bitmapCreateBitmap.copyPixelsFromBuffer(byteBuffer);
                g gVar = g.this;
                bitmapA = gVar.a(bitmapCreateBitmap, gVar.a(cameraInfo));
            }
            OnPictureCallback onPictureCallback = this.b;
            if (onPictureCallback != null) {
                onPictureCallback.onPicture(bitmapA, byteBuffer.array());
            } else if (g.this.h instanceof RecordCallback) {
                ((RecordCallback) g.this.h).onPictureDataBack(byteBuffer.array());
                if (bitmapA != null) {
                    ((RecordCallback) g.this.h).onPictureBack(bitmapA);
                }
            }
        }
    }

    public class d implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f25851a;
        final /* synthetic */ int b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SurfaceView surfaceView = g.this.A;
                if (surfaceView != null) {
                    surfaceView.getViewTreeObserver().removeOnDrawListener(g.this.G);
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SurfaceView surfaceView = g.this.A;
                if (surfaceView != null) {
                    SurfaceHolder holder = surfaceView.getHolder();
                    d dVar = d.this;
                    holder.setFixedSize(dVar.f25851a, dVar.b);
                }
            }
        }

        public d(int i, int i2) {
            this.f25851a = i;
            this.b = i2;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            if (g.this.G != null) {
                g.this.A.post(new a());
                g.this.A.postDelayed(new b(), 100L);
            }
        }
    }

    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25854a;

        static {
            int[] iArr = new int[AliyunRecordStickerType.values().length];
            f25854a = iArr;
            try {
                iArr[AliyunRecordStickerType.STICKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25854a[AliyunRecordStickerType.FACE_STICKER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25854a[AliyunRecordStickerType.WATERMARK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(Context context, com.aliyun.svideosdk.a.f.a aVar) {
        this.F = new com.aliyun.common.c.b.e(context.getApplicationContext());
        NativeRecorder nativeRecorder = new NativeRecorder(this.F.a());
        this.d = nativeRecorder;
        this.c = new com.aliyun.svideosdk.a.e.a(this.F, nativeRecorder);
        AliyunRecordVideoSource aliyunRecordVideoSourceCreateVideoWithInfo = AliyunRecordVideoSource.createVideoWithInfo(1, 1);
        aliyunRecordVideoSourceCreateVideoWithInfo.setVideoNeedRender(true);
        aliyunRecordVideoSourceCreateVideoWithInfo.setVideoNeedOutput(true);
        a(aliyunRecordVideoSourceCreateVideoWithInfo);
        this.d.addSource(aliyunRecordVideoSourceCreateVideoWithInfo);
        this.c.a(aliyunRecordVideoSourceCreateVideoWithInfo);
        this.f25846a = aVar;
        this.b = com.aliyun.svideosdk.preview.camera.e.a(context, this.c, this.F, aVar);
        this.o = (WindowManager) context.getApplicationContext().getSystemService("window");
        this.n = new AliyunLogInfo(g.class.getName());
        this.e = new com.aliyun.svideosdk.recorder.impl.e(context.getApplicationContext(), this.F, this.d);
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
        return i2 + this.b.a();
    }

    private int a(EffectSticker effectSticker, boolean z) {
        if (!NativeLicense.checkServiceLicense(NativeLicense.SERVICE_TYPE.STICKER)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "addSticker: sticker service license check failed");
            return AliyunErrorCode.ALIVC_FRAMEWORK_LICENSE_CHECK_PASTER_FAILED;
        }
        if (effectSticker == null || effectSticker.getPath() == null || !new File(effectSticker.getPath()).exists()) {
            return -20001003;
        }
        int iA = com.aliyun.svideosdk.common.a.a(this.c.a(effectSticker.getPath(), effectSticker.getResId(), effectSticker.getXRadio(), effectSticker.getYRadio(), effectSticker.getWidthRatio(), effectSticker.getHeightRatio(), effectSticker.getRotation(), effectSticker.isFlipH(), 0L, z ? 1 : 0));
        if (iA == 0 && z) {
            this.f.add(effectSticker);
            this.b.a(false);
        }
        this.F.a(effectSticker, this.i, this.C, this.k);
        return iA;
    }

    private int a(EffectStream effectStream) {
        return (effectStream == null || effectStream.getSource() == null || TextUtils.isEmpty(effectStream.getSource().getPath())) ? this.e.a(null, 0L, 0L, true) : this.e.a(effectStream.getSource().getPath(), effectStream.getStreamStartTime() * 1000, 1000 * effectStream.getStreamDuration(), true);
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

    private void a(MediaInfo mediaInfo, float f) {
        if (Float.compare((mediaInfo.getVideoWidth() * 1.0f) / mediaInfo.getVideoHeight(), f) == 0) {
            return;
        }
        int iRound = Math.round(mediaInfo.getVideoWidth() / f);
        if (iRound % 2 != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("The preview height must be even, so auto correct preview height from ");
            sb.append(iRound);
            sb.append(" to ");
            iRound--;
            sb.append(iRound);
            com.aliyun.common.c.a.a.d("AliYunLog", sb.toString());
        }
        mediaInfo.setVideoHeight(iRound);
    }

    private void b(EffectSticker effectSticker, boolean z) {
        if (effectSticker == null) {
            return;
        }
        if (z) {
            synchronized (this.x) {
                Iterator<EffectBase> it = this.g.iterator();
                while (it.hasNext()) {
                    this.c.a(it.next().getResId());
                }
                this.g.clear();
                this.f.remove(effectSticker);
                if (this.f.size() == 0) {
                    this.b.a(true);
                }
                com.aliyun.common.c.a.a.a("AliYunLog", "size = " + this.f.size());
            }
        }
        this.F.c(effectSticker.getResId());
        this.c.a(effectSticker.getResId());
    }

    public AliyunRecordVideoSource a() {
        return this.L;
    }

    public void a(int i) {
        this.e.b(i);
    }

    public void a(AliyunRecordAVSource aliyunRecordAVSource) {
        this.L = aliyunRecordAVSource;
        this.e.a(aliyunRecordAVSource);
    }

    public void a(AliyunRecordVideoSource aliyunRecordVideoSource) {
        this.K = aliyunRecordVideoSource;
    }

    @Override // com.aliyun.svideosdk.recorder.impl.d
    public void a(com.aliyun.svideosdk.recorder.impl.a aVar) {
        int i = e.f25854a[aVar.getType().ordinal()];
        if (i == 1) {
            a(((AliyunRecordPasterController) aVar).getModel(), false);
        } else if (i == 2) {
            a(((AliyunRecordPasterController) aVar).getModel(), true);
        } else {
            if (i != 3) {
                return;
            }
            addImage(((AliyunRecordWaterMarkController) aVar).getModel());
        }
    }

    public void a(boolean z) {
        this.J = z;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int addImage(EffectImage effectImage) {
        int iA;
        if (effectImage == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        Bitmap bitmap = effectImage.getBitmap();
        if (bitmap != null) {
            iA = this.c.a(effectImage.getResId(), bitmap, effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getRotation());
        } else {
            if (effectImage.getPath() == null || !new File(effectImage.getPath()).exists()) {
                return -20003013;
            }
            iA = this.c.a(effectImage.getResId(), effectImage.getPath(), effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getRotation());
        }
        this.F.a(effectImage, effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getRotation());
        return com.aliyun.svideosdk.common.a.a(iA);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int addPaster(EffectPaster effectPaster) {
        if (effectPaster != null) {
            return a(effectPaster.toEffectSticker(), effectPaster.isTrack);
        }
        return -20001003;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int addPaster(EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z) {
        if (effectPaster == null || effectPaster.getPath() == null || !new File(effectPaster.getPath()).exists()) {
            return -20001003;
        }
        return a(effectPaster.toEffectSticker(), effectPaster.isTrack);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int applyAnimationFilter(EffectFilter effectFilter) {
        if (effectFilter == null || !(effectFilter.getSource() == null || effectFilter.getSource().getPath() == null || new File(effectFilter.getSource().getPath()).exists())) {
            com.aliyun.common.c.a.a.b("AliYunLog", "EffectFilter resource not exist!");
            return -20003002;
        }
        String jsonString = effectFilter.toJsonString();
        com.aliyun.common.c.a.a.a("AliYunLog", "applyAnimationFilter params : " + jsonString);
        String path = effectFilter.getSource() == null ? null : effectFilter.getSource().getPath();
        int iA = com.aliyun.svideosdk.common.a.a(this.c.b(path, jsonString));
        effectFilter.setViewId(iA);
        this.F.a(path, effectFilter.getViewId());
        return Math.min(iA, 0);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int applyBackgroundMusic(EffectStream effectStream) {
        String path = effectStream.getSource().getPath();
        long streamStartTime = effectStream.getStreamStartTime();
        long streamDuration = effectStream.getStreamDuration();
        this.F.a(path, effectStream.getStreamStartTime(), effectStream.getStreamDuration());
        if (path != null) {
            if (!new File(path).exists()) {
                com.aliyun.common.c.a.a.b("AliYunLog", "setMusic  error, music filepath = " + path + " is not exit.");
                return -20001003;
            }
            if (0 == streamDuration || streamStartTime < 0) {
                com.aliyun.common.c.a.a.b("AliYunLog", "setMusic error, music duration  = " + streamDuration + ",  startTime = " + streamStartTime);
                return -20001007;
            }
            if (effectStream.getDuration() == 0) {
                Log.e("AliYunLog", "applyMusic error, music unknown codec ");
                return -20001008;
            }
        }
        com.aliyun.common.c.a.a.a("AliYunLog", "apply music startTime " + streamStartTime + ", duration " + streamDuration);
        return a(effectStream);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int applyFilter(EffectFilter effectFilter) {
        if (effectFilter == null || !(effectFilter.getSource() == null || effectFilter.getSource().getPath() == null || new File(effectFilter.getSource().getPath()).exists())) {
            com.aliyun.common.c.a.a.b("AliYunLog", "applyFilter, ALIVC_SVIDEO_ERROR_PARAM_FILTER_FILE_PATH_INVALID = -20003014");
            return -20003014;
        }
        com.aliyun.common.c.a.a.a("AliYunLog", "applyFilter ");
        String path = effectFilter.getSource() == null ? null : effectFilter.getSource().getPath();
        this.F.a(path);
        return com.aliyun.svideosdk.common.a.a(this.c.a(path));
    }

    public NativeRecorder b() {
        return this.d;
    }

    @Override // com.aliyun.svideosdk.recorder.impl.d
    public void b(com.aliyun.svideosdk.recorder.impl.a aVar) {
        int i = e.f25854a[aVar.getType().ordinal()];
        if (i == 1) {
            b(((AliyunRecordPasterController) aVar).getModel(), false);
        } else if (i == 2) {
            b(((AliyunRecordPasterController) aVar).getModel(), true);
        } else {
            if (i != 3) {
                return;
            }
            removeImage(((AliyunRecordWaterMarkController) aVar).getModel());
        }
    }

    public AliyunRecordVideoSource c() {
        return this.K;
    }

    @Override // com.aliyun.svideosdk.recorder.impl.d
    public void c(com.aliyun.svideosdk.recorder.impl.a aVar) {
        AliyunRecordPasterController aliyunRecordPasterController;
        EffectSticker model;
        int i = e.f25854a[aVar.getType().ordinal()];
        boolean z = true;
        if (i == 1) {
            aliyunRecordPasterController = (AliyunRecordPasterController) aVar;
            model = aliyunRecordPasterController.getModel();
            z = false;
        } else {
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                AliyunRecordWaterMarkController aliyunRecordWaterMarkController = (AliyunRecordWaterMarkController) aVar;
                removeImage(aliyunRecordWaterMarkController.getModel());
                addImage(aliyunRecordWaterMarkController.getModel());
                return;
            }
            aliyunRecordPasterController = (AliyunRecordPasterController) aVar;
            model = aliyunRecordPasterController.getModel();
        }
        b(model, z);
        a(aliyunRecordPasterController.getModel(), z);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void cancelRecording() {
        com.aliyun.common.c.a.a.a("AliYunLog", "cancelRecording ");
        this.e.a();
        this.c.l();
        com.aliyun.svideosdk.a.d.a aVarI = this.c.i();
        this.c.f();
        com.aliyun.svideosdk.a.d.a aVarG = this.c.g();
        com.aliyun.svideosdk.a.d.a aVarK = this.c.k();
        com.aliyun.svideosdk.a.d.a aVarE = this.c.e();
        this.F.a(this.E, aVarI.d(), aVarI.h(), aVarG.d(), aVarG.h(), aVarK.d(), aVarK.h(), aVarE.d(), aVarE.h(), aVarI.i(), aVarI.g(), aVarI.e());
    }

    public com.aliyun.common.c.b.e d() {
        return this.F;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void destroy() {
        release();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int finishRecording() {
        int iA;
        com.aliyun.common.c.a.a.a("AliYunLog", "finishRecording ");
        long jCurrentTimeMillis = System.currentTimeMillis();
        iA = com.aliyun.svideosdk.common.a.a(this.e.b());
        this.F.b(System.currentTimeMillis() - jCurrentTimeMillis);
        return iA;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public Uri finishRecordingForEdit() {
        if (this.F != null) {
            this.e.c().a(this.F.c());
        }
        return this.e.c().c();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public AliyunLogInfo getAliyunLogInfo() {
        return this.n;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int getBeautyLevel() {
        return this.v;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int getCameraCount() {
        return this.b.getCameraCount();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public AliyunIClipManager getClipManager() {
        return this.e.c();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public float getCurrentExposureCompensationRatio() {
        return this.b.getCurrentExposureCompensationRatio();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public AliyunIRecordPasterManager getPasterManager() {
        if (this.H == null) {
            this.H = new f(this);
        }
        return this.H;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public List<Camera.Size> getSupportedPictureSize() {
        return this.b.getSupportedPictureSize();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public SortedSet<Size> getSupportedPictureSizes() {
        return this.b.getSupportedPictureSizes();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void needFaceTrackInternal(boolean z) {
        this.i = z;
        this.F.a(z);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void release() {
        this.F.d();
        this.c.o();
        stopRecording();
        stopPreview();
        com.aliyun.common.c.a.a.a("AliYunLog", "Recorder destroy");
        this.u = true;
        this.b.setOnFrameCallback(null);
        this.b.a((com.aliyun.svideosdk.a.a) null);
        this.e.a((com.aliyun.svideosdk.recorder.impl.e.d) null);
        this.e.a((OnRecordCallback) null);
        this.h = null;
        if (this.I) {
            getClipManager().deleteAllPart();
        }
        this.c.n();
        this.d.removeSource(this.K);
        this.K.release();
        this.e.i();
        this.b.release();
        synchronized (this.w) {
            FaceAREngine faceAREngine = this.m;
            if (faceAREngine != null) {
                faceAREngine.release();
                this.m = null;
            }
        }
        Iterator<SurfaceView> it = this.z.iterator();
        while (it.hasNext()) {
            it.next().getHolder().removeCallback(this);
        }
        this.D = null;
        this.z.clear();
        this.A = null;
        this.c.a((OnTextureIdCallback) null);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void removeAnimationFilter(EffectFilter effectFilter) {
        if (effectFilter != null) {
            com.aliyun.common.c.a.a.a("AliYunLog", "removeAnimationFilter ");
            this.F.a(effectFilter.getResId());
            this.c.p();
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int removeBackgroundMusic() {
        this.F.f();
        com.aliyun.common.c.a.a.a("AliYunLog", "remove music startTime ");
        return a((EffectStream) null);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int removeFilter() {
        com.aliyun.common.c.a.a.a("AliYunLog", "removeFilter ");
        this.F.e();
        return com.aliyun.svideosdk.common.a.a(this.c.a((String) null));
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void removeImage(EffectImage effectImage) {
        if (effectImage != null) {
            this.F.b(effectImage.getResId());
            this.c.a(effectImage.getResId());
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void removePaster(EffectPaster effectPaster) {
        if (effectPaster == null) {
            return;
        }
        b(effectPaster.toEffectSticker(), effectPaster.isTrack);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int resizePreviewSize(int i, int i2) {
        com.aliyun.common.c.a.a.a("AliYunLog", "resizePreviewSize " + i + " " + i2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iB = this.c.b();
        if (Build.VERSION.SDK_INT < 29) {
            this.G = new d(i, i2);
            this.A.getViewTreeObserver().addOnDrawListener(this.G);
        } else {
            this.A.getHolder().setFixedSize(i, i2);
        }
        this.F.c(System.currentTimeMillis() - jCurrentTimeMillis);
        return iB;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void setBeautyLevel(int i) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setBeautyLevel " + i);
        this.F.d(i);
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.v = i;
        this.c.b(i);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setBeautyStatus(boolean z) {
        com.aliyun.svideosdk.a.e.a aVar;
        int i;
        this.F.b(z);
        if (z) {
            aVar = this.c;
            i = this.v;
            if (i == 0) {
                i = 50;
            }
        } else {
            aVar = this.c;
            i = 0;
        }
        aVar.b(i);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setCamera(CameraType cameraType) {
        if (cameraType == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Camera Type!");
        } else {
            this.F.a(cameraType);
            this.b.b(cameraType.getType());
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setCameraCaptureDataMode(int i) {
        this.b.setCameraCaptureDataMode(i);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void setCameraParam(CameraParam cameraParam) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setCameraParam ");
        this.F.a(cameraParam);
        this.b.setCameraParam(cameraParam);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setDisplayView(SurfaceView surfaceView) {
        if (surfaceView == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid DisplayView!");
            return;
        }
        com.aliyun.common.c.a.a.a("AliYunLog", "setDisplayView ");
        this.F.a(surfaceView);
        this.A = surfaceView;
        this.z.add(surfaceView);
        Surface surface = surfaceView.getHolder().getSurface();
        if (surface != null && surface.isValid()) {
            this.c.a(surface);
            this.B = (surfaceView.getMeasuredWidth() * 1.0f) / surfaceView.getMeasuredHeight();
            OnRecordCallback onRecordCallback = this.h;
            if (onRecordCallback != null) {
                onRecordCallback.onInitReady();
            }
        }
        surfaceView.getHolder().addCallback(this);
        WindowManager windowManager = (WindowManager) surfaceView.getContext().getSystemService("window");
        if (windowManager != null) {
            this.b.setRotation(windowManager.getDefaultDisplay().getRotation());
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setEffectView(float f, float f2, float f3, float f4, EffectBase effectBase) {
        if (effectBase == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Effect Item!");
            return -20003002;
        }
        this.F.a(f, f2, f3, f4, effectBase);
        this.c.d().getStickerManager().updateStickerPosition(effectBase.getResId(), f, f2, f3, f4);
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int setExposureCompensationRatio(float f) {
        this.F.a(f);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return this.b.setExposureCompensationRatio(f);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setFaceDetectRotation(int i) {
        this.F.e(i);
        this.k = i;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setFaceTrackInternalMaxFaceCount(int i) {
        this.F.f(i);
        this.s = i;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setFaceTrackInternalModelPath(String str) throws Throwable {
        this.F.b(str);
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
                    this.j = true;
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
                com.aliyun.common.c.a.a.b("AliYunLog", "Face model file is damaged!expectLength " + iA + ", file size " + this.D.length);
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

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setFaces(float[][] fArr) {
        float[][] fArr2 = fArr;
        if (!BuildConfig.LIB_ALI_FACE_AR_ENGINE_SUPPORTED.booleanValue()) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Has no privilege to use setFaces interface");
            return -20001001;
        }
        if (!NativeLicense.checkServiceLicense(NativeLicense.SERVICE_TYPE.STICKER)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "setFaces: sticker service license check failed");
            return AliyunErrorCode.ALIVC_FRAMEWORK_LICENSE_CHECK_PASTER_FAILED;
        }
        synchronized (this.x) {
            if (fArr2 != null) {
                try {
                    if (this.g != null && this.f.size() != 0) {
                        EffectBase effectBase = this.f.get(0);
                        int size = this.g.size();
                        if (fArr2.length == 0) {
                            fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 1, 6);
                        }
                        if (this.g.size() >= fArr2.length) {
                            for (int length = fArr2.length; length < size; length++) {
                                CopyOnWriteArrayList<EffectBase> copyOnWriteArrayList = this.g;
                                this.c.a(copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1).getResId());
                            }
                            for (int i = 0; i < fArr2.length; i++) {
                                this.c.a(this.g.get(i).getResId(), fArr2[i]);
                            }
                        } else {
                            int length2 = fArr2.length - this.g.size();
                            for (int i2 = 0; i2 < length2; i2++) {
                                if (effectBase instanceof EffectSticker) {
                                    if (this.g.isEmpty()) {
                                        this.g.add(effectBase);
                                    } else {
                                        EffectSticker effectSticker = new EffectSticker(effectBase.getSource());
                                        if (this.c.a(effectSticker.getSource().getPath(), effectSticker.getResId(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0L, 1) == 0) {
                                            this.g.add(effectSticker);
                                        }
                                    }
                                }
                            }
                            for (int i3 = 0; i3 < fArr2.length; i3++) {
                                this.c.a(this.g.get(i3).getResId(), fArr2[i3]);
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

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void setFocus(float f, float f2) {
        com.aliyun.common.c.b.e eVar = this.F;
        if (eVar != null) {
            eVar.a(f, f2);
        }
        if (com.aliyun.svideosdk.a.f.a.CAMERA1 == this.f25846a) {
            this.b.setFocus(f, f2);
        } else {
            this.b.setFocus(new Point(((int) f) * this.A.getWidth(), ((int) f2) * this.A.getHeight()));
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void setFocus(Point point) {
        float f;
        float f2;
        if (point == null) {
            return;
        }
        int width = this.A.getWidth();
        int height = this.A.getHeight();
        if (width <= 0 || height <= 0) {
            f = 0.0f;
            f2 = 0.0f;
        } else {
            f = (point.x * 1.0f) / width;
            f2 = (point.y * 1.0f) / height;
        }
        com.aliyun.common.c.b.e eVar = this.F;
        if (eVar != null) {
            eVar.a(f, f2);
        }
        if (com.aliyun.svideosdk.a.f.a.CAMERA1 == this.f25846a) {
            this.b.setFocus(f, f2);
        } else {
            this.b.setFocus(point);
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void setFocusMode(int i) {
        this.F.g(i);
        this.b.setFocusMode(i);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setGop(int i) {
        if (this.r == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "setGop() failed: mMediaInfo is null, do you call setMediaInfo() before setGop()");
            return -2;
        }
        this.F.h(i);
        if (i >= 0 && i <= 9000) {
            this.r.setGop(i);
            this.e.a(this.r);
            com.aliyun.common.c.a.a.a("AliYunLog", "set gop " + i);
            return 0;
        }
        com.aliyun.common.c.a.a.b("AliYunLog", "Invalid gop value " + i + ", gop value has must be between 0 and 9000");
        return -20003002;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setIsAutoClearClipVideos(boolean z) {
        this.I = z;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized boolean setLight(FlashType flashType) {
        try {
            if (flashType == null) {
                com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Light!");
                return false;
            }
            com.aliyun.common.c.a.a.a("AliYunLog", "setLight ");
            boolean zA = this.b.a(flashType);
            this.F.a(flashType, zA);
            return zA;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setMediaInfo(MediaInfo mediaInfo) {
        if (this.u) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Recorder has been destroyed!");
            return;
        }
        this.F.a(mediaInfo);
        this.r = mediaInfo;
        this.b.a(mediaInfo.getFps());
        if (mediaInfo.getVideoWidth() == 0 || mediaInfo.getVideoHeight() == 0) {
            throw new IllegalArgumentException("The width or height must > 0");
        }
        int videoWidth = this.r.getVideoWidth();
        int videoHeight = this.r.getVideoHeight();
        if (videoWidth % 2 != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("The preview width must be even, so auto correct preview width from ");
            sb.append(videoWidth);
            sb.append(" to ");
            int i = videoWidth - 1;
            sb.append(i);
            com.aliyun.common.c.a.a.d("AliYunLog", sb.toString());
            this.r.setVideoWidth(i);
        }
        if (videoHeight % 2 != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The preview height must be even, so auto correct preview height from ");
            sb2.append(videoHeight);
            sb2.append(" to ");
            int i2 = videoHeight - 1;
            sb2.append(i2);
            com.aliyun.common.c.a.a.d("AliYunLog", sb2.toString());
            this.r.setVideoHeight(i2);
        }
        this.b.a(mediaInfo.getVideoWidth(), mediaInfo.getVideoHeight());
        this.e.a(mediaInfo);
        if (!this.J) {
            this.c.d().setLayoutInfo(new AliyunRecordVideoSource.LayoutInfo(1.0f, 1.0f, 0.5f, 0.5f, 0, VideoDisplayMode.SCALE.ordinal(), mediaInfo.getVideoWidth(), mediaInfo.getVideoHeight()));
            this.d.updateSource(this.c.d());
        }
        com.aliyun.common.c.a.a.a("AliYunLog", "set mediainfo " + mediaInfo.toString());
    }

    public void setMixAudioWeight(int i, int i2) {
        this.e.a(i, i2);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setMusic(String str, long j, long j2) {
        if (str == null || str.isEmpty()) {
            removeBackgroundMusic();
            return;
        }
        EffectStream.Builder builderSource = new EffectStream.Builder().source(new Source(str));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        applyBackgroundMusic(builderSource.streamStartTime(j, timeUnit).streamDuration(j2, timeUnit).build());
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setMute(boolean z) {
        this.F.c(z);
        this.e.a(z);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnAudioCallback(OnAudioCallBack onAudioCallBack) {
        this.e.a(onAudioCallBack);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnChoosePictureSizeCallBack(OnChoosePictureSizeCallback onChoosePictureSizeCallback) {
        this.b.setOnChoosePictureSizeCallBack(onChoosePictureSizeCallback);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnEncoderInfoCallback(OnEncoderInfoCallback onEncoderInfoCallback) {
        this.e.a(onEncoderInfoCallback);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnFaceDetectInfoListener(OnFaceDetectInfoListener onFaceDetectInfoListener) {
        this.q = onFaceDetectInfoListener;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnFrameCallback(OnFrameCallback onFrameCallback) {
        this.F.a(onFrameCallback);
        this.b.setOnFrameCallback(onFrameCallback);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnRecordCallback(OnRecordCallback onRecordCallback) {
        this.F.b(onRecordCallback);
        this.h = onRecordCallback;
        this.e.a(onRecordCallback);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnTextureIdCallback(OnTextureIdCallback onTextureIdCallback) {
        this.c.a(onTextureIdCallback);
    }

    public void setOpenMicAEC(boolean z) {
        this.e.b(z);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setOutputPath(String str) {
        if (TextUtils.isEmpty(str)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        this.F.c(str);
        this.e.a(str);
        com.aliyun.common.c.a.a.a("AliYunLog", "set outputPath " + str);
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setPictureSize(Camera.Size size) {
        if (size == null) {
            return -2;
        }
        com.aliyun.common.c.a.a.a("AliYunLog", "setPictureSize " + size.width + " " + size.height);
        return this.b.setPictureSize(size.width, size.height);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setPictureSize(Size size) {
        if (size == null) {
            return -2;
        }
        com.aliyun.common.c.a.a.a("AliYunLog", "setPictureSize " + size.getWidth() + " " + size.getHeight());
        return this.b.setPictureSize(size.getWidth(), size.getHeight());
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setRate(float f) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setRate " + f);
        this.F.b(f);
        if (f > 2.0d) {
            f = 2.0f;
        }
        if (f < 0.5d) {
            f = 0.5f;
        }
        this.e.a(f);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setRecordRotation(int i) {
        this.F.i(i);
        this.e.c(i);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setRotation(int i) {
        int i2;
        StringBuilder sb;
        String str;
        com.aliyun.common.c.a.a.a("AliYunLog", "setRotation " + i);
        this.k = i;
        if (i == 90 || i == 270) {
            i = (i + 90) % 360;
            if (this.b.c().facing == 0) {
                i2 = i + 180;
                i = i2 % 360;
            }
        } else if (i == 0 || i == 180) {
            i2 = i + 270;
            i = i2 % 360;
        }
        if (this.b.c().facing == 1) {
            int iAbs = Math.abs(270 - this.b.c().orientation);
            if (iAbs == 180 || ((iAbs == 90 || iAbs == 270) && (i == 0 || i == 360 || i == 180))) {
                i = (i + 180) % 360;
            }
            this.e.c(((iAbs + i) % 360) + this.o.getDefaultDisplay().getRotation());
            sb = new StringBuilder();
            str = "front rotation is ";
        } else {
            this.e.c(this.o.getDefaultDisplay().getRotation() + i);
            sb = new StringBuilder();
            str = "back rotation is ";
        }
        sb.append(str);
        sb.append(i);
        sb.append("camera orientation is ");
        sb.append(this.b.c().orientation);
        sb.append("wm rotation is ");
        sb.append(this.o.getDefaultDisplay().getRotation());
        com.aliyun.common.c.a.a.a("AliyunRecorder", sb.toString());
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setShutterSound(boolean z) {
        this.b.setShutterSound(z);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setTakePicturePreview(boolean z) {
        this.b.setTakePicturePreview(z);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setVideoBitrate(int i) {
        if (this.r == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "setVideoBitrate() failed: mMediaInfo is null, do you call setMediaInfo() before setVideoBitrate()");
            return -2;
        }
        this.F.j(i);
        if (i >= 200 && i <= 20000) {
            com.aliyun.common.c.a.a.a("AliYunLog", "setVideoBitrate, bitrate = " + i);
            this.r.setVideoBitrate(i);
            this.e.a(this.r);
            return 0;
        }
        com.aliyun.common.c.a.a.b("AliYunLog", "Invalid video bitrate value " + i + ", video bitrate has must be between 200 and 20000");
        return -20003002;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setVideoFlipH(boolean z) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setVideoFlipH " + z);
        this.c.d().setMirrorInfo(z ? 1 : 0);
        this.d.updateSource(this.c.d());
        return -1;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setVideoQuality(VideoQuality videoQuality) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setVideoQuality " + videoQuality);
        if (videoQuality != null) {
            if (this.r == null) {
                com.aliyun.common.c.a.a.b("AliYunLog", "setVideoQuality() failed: mMediaInfo is null, do you call setMediaInfo() before setVideoQuality()");
                return;
            }
            this.F.a(videoQuality);
            this.r.setVideoQuality(videoQuality);
            this.e.a(this.r);
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int setZoom(float f) {
        com.aliyun.common.c.a.a.a("AliYunLog", "setZoom " + f);
        this.F.c(f);
        return this.b.setZoom(f);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int startPreview() {
        com.aliyun.svideosdk.a.e.a aVar;
        int videoWidth;
        int videoHeight;
        com.aliyun.common.c.a.a.a("AliYunLog", "AliyunRecorder call startPreview");
        if (this.r == null) {
            OnRecordCallback onRecordCallback = this.h;
            if (onRecordCallback != null) {
                onRecordCallback.onError(-2);
            }
            com.aliyun.common.c.a.a.b("AliYunLog", "startPreview failed: mMediaInfo is null, do you call setMediaInfo() before startPreview()");
            return -2;
        }
        if (this.A == null || this.A.getMeasuredWidth() <= 0 || this.A.getMeasuredHeight() <= 0) {
            aVar = this.c;
            videoWidth = this.r.getVideoWidth();
            videoHeight = this.r.getVideoHeight();
        } else {
            aVar = this.c;
            videoWidth = this.A.getMeasuredWidth();
            videoHeight = this.A.getMeasuredHeight();
        }
        int iA = aVar.a(videoWidth, videoHeight);
        if (iA != 0) {
            OnRecordCallback onRecordCallback2 = this.h;
            if (onRecordCallback2 != null) {
                onRecordCallback2.onError(iA);
            }
            com.aliyun.common.c.a.a.b("AliYunLog", "startPreview, changeFboSize failed, res = " + iA);
            return iA;
        }
        this.e.a(this.r);
        int iStartPreview = this.b.startPreview();
        if (iStartPreview >= 0) {
            this.b.a(this.M);
            this.e.h();
            return iStartPreview;
        }
        OnRecordCallback onRecordCallback3 = this.h;
        if (onRecordCallback3 != null) {
            onRecordCallback3.onError(iStartPreview);
        }
        com.aliyun.common.c.a.a.b("AliYunLog", "startPreview, mAliyunCameraProxy.startPreview failed, res = " + iStartPreview);
        return iStartPreview;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int startPreviewAfterTakePicture() {
        return this.b.startPreviewAfterTakePicture();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int startRecording() {
        com.aliyun.common.c.a.a.a("AliYunLog", "startRecording");
        com.aliyun.svideosdk.recorder.impl.e eVar = this.e;
        if (eVar == null) {
            return -4;
        }
        if (eVar.g()) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Current recording duration is over max duration!");
            OnRecordCallback onRecordCallback = this.h;
            if (onRecordCallback != null) {
                onRecordCallback.onError(-20008008);
            }
            return -20008008;
        }
        if (!this.b.b()) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Not start preview,so can not record video!");
            return -4;
        }
        int iK = this.e.k();
        this.c.l();
        com.aliyun.svideosdk.a.d.a aVarI = this.c.i();
        this.c.f();
        com.aliyun.svideosdk.a.d.a aVarG = this.c.g();
        com.aliyun.svideosdk.a.d.a aVarK = this.c.k();
        this.E = com.aliyun.common.c.c.a.a();
        this.F.a(aVarI.g(), aVarI.e(), aVarI.d(), aVarI.h(), aVarG.d(), aVarG.h(), aVarK.d(), aVarK.h(), aVarI.i(), this.r.getVideoBitrate(), this.r.getCrf(), this.r.getEncoderFps(), this.r.getGop(), this.r.getVideoCodec(), this.r.getVideoQuality(), this.r.getVideoWidth(), this.r.getVideoHeight(), this.E);
        this.c.m();
        return iK;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void stopPreview() {
        com.aliyun.common.c.a.a.a("AliYunLog", "AliyunRecorder call stopPreview");
        stopRecording();
        this.b.a((com.aliyun.svideosdk.a.a) null);
        this.b.stopPreview();
        this.e.j();
        this.l = -1;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int stopRecording() {
        com.aliyun.common.c.a.a.a("AliYunLog", "stopRecording");
        if (this.e == null) {
            return -4;
        }
        com.aliyun.common.c.a.a.a("AliYunLog", "AliyunRecorder stopRecording");
        int iM = this.e.m();
        if (iM == 0) {
            this.c.l();
            com.aliyun.svideosdk.a.d.a aVarI = this.c.i();
            this.c.f();
            com.aliyun.svideosdk.a.d.a aVarG = this.c.g();
            com.aliyun.svideosdk.a.d.a aVarK = this.c.k();
            com.aliyun.svideosdk.a.d.a aVarE = this.c.e();
            this.F.b(this.E, aVarI.d(), aVarI.h(), aVarG.d(), aVarG.h(), aVarK.d(), aVarK.h(), aVarE.d(), aVarE.h(), aVarI.i(), aVarI.g(), aVarI.e());
        }
        return iM;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        MediaInfo mediaInfo;
        com.aliyun.svideosdk.a.e.a aVar = this.c;
        if (aVar != null) {
            aVar.a(surfaceHolder.getSurface());
        }
        int measuredWidth = this.A.getMeasuredWidth();
        int measuredHeight = this.A.getMeasuredHeight();
        this.B = (measuredWidth * 1.0f) / measuredHeight;
        this.c.a(measuredWidth, measuredHeight);
        if (!this.J && (mediaInfo = this.r) != null) {
            a(mediaInfo, this.B);
            this.e.a(this.r);
            AliyunRecordVideoSource.LayoutInfo layoutInfo = this.c.d().getLayoutInfo();
            layoutInfo.outputWidth = this.r.getVideoWidth();
            layoutInfo.outputHeight = this.r.getVideoHeight();
            this.c.d().setLayoutInfo(layoutInfo);
            this.d.updateSource(this.c.d());
        }
        OnRecordCallback onRecordCallback = this.h;
        if (onRecordCallback != null) {
            onRecordCallback.onInitReady();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        com.aliyun.svideosdk.a.e.a aVar = this.c;
        if (aVar != null) {
            aVar.b(surfaceHolder.getSurface());
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int switchCamera() {
        int iSwitchCamera;
        com.aliyun.common.c.a.a.a("AliYunLog", "switchCamera ");
        long jCurrentTimeMillis = System.currentTimeMillis();
        iSwitchCamera = this.b.switchCamera();
        this.F.a(iSwitchCamera, System.currentTimeMillis() - jCurrentTimeMillis);
        return iSwitchCamera;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized FlashType switchLight() {
        FlashType flashTypeSwitchLight;
        flashTypeSwitchLight = this.b.switchLight();
        this.F.a(flashTypeSwitchLight);
        return flashTypeSwitchLight;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void takePhoto(boolean z) {
        takeSnapshot(z, null);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void takePicture(boolean z) {
        takePicture(z, null);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void takePicture(boolean z, OnPictureCallback onPictureCallback) {
        this.F.h();
        this.b.a(new b(z, onPictureCallback));
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void takeSnapshot(boolean z, OnPictureCallback onPictureCallback) {
        this.F.g();
        this.b.a(new c(z, onPictureCallback));
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int updateAnimationFilter(EffectFilter effectFilter) {
        if (effectFilter == null || !(effectFilter.getSource() == null || effectFilter.getSource().getPath() == null || new File(effectFilter.getSource().getPath()).exists())) {
            com.aliyun.common.c.a.a.b("AliYunLog", "EffectFilter resource not exist!");
            return -20003002;
        }
        String jsonString = effectFilter.toJsonString();
        com.aliyun.common.c.a.a.a("AliYunLog", "updateAnimationFilter params : " + jsonString);
        int iA = com.aliyun.svideosdk.common.a.a(this.c.b(effectFilter.getPath(), jsonString));
        this.F.b(effectFilter.getSource() == null ? null : effectFilter.getSource().getPath(), effectFilter.getResId());
        return iA;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public String version() {
        return "6.7.0";
    }
}
