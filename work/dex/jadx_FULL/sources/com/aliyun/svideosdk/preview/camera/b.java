package com.aliyun.svideosdk.preview.camera;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaActionSound;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Range;
import android.util.SparseIntArray;
import android.view.Surface;
import com.aliyun.common.utils.Size;
import com.aliyun.common.utils.o;
import com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback;
import com.aliyun.svideosdk.common.struct.recorder.CameraParam;
import com.aliyun.svideosdk.common.struct.recorder.FlashType;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@TargetApi(21)
public class b implements com.aliyun.svideosdk.preview.camera.f, SurfaceTexture.OnFrameAvailableListener {
    private static final String Z = "b";
    private static final SparseIntArray a0;
    private static final com.aliyun.common.utils.b b0;
    private CameraDevice A;
    private CameraCaptureSession B;
    private CaptureRequest.Builder C;
    private CaptureRequest.Builder D;
    private ImageReader E;
    private ImageReader F;
    private Surface H;
    private com.aliyun.svideosdk.a.f.d I;
    private com.aliyun.svideosdk.a.f.c J;
    private MediaActionSound K;
    private Rect N;
    private int O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CameraManager f25822a;
    private int c;
    private OnFrameCallback d;
    private OnChoosePictureSizeCallback e;
    private boolean f;
    private boolean g;
    private com.aliyun.svideosdk.a.a h;
    private com.aliyun.svideosdk.a.c i;
    private com.aliyun.svideosdk.a.e.a j;
    private com.aliyun.common.c.b.e k;
    private HandlerThread l;
    private Handler m;
    private int n;
    private CameraCharacteristics r;
    private int v;
    private int w;
    private String b = FlashType.OFF.toString();
    private Camera.CameraInfo o = new Camera.CameraInfo();
    private int p = 0;
    private String q = "0";
    private final List<Size> s = new ArrayList();
    private final o t = new o();
    private final o u = new o();
    private Size x = null;
    private Size y = null;
    private com.aliyun.common.utils.b z = b0;
    volatile Image G = null;
    private float L = 0.0f;
    private Rect M = new Rect();
    private int P = 0;
    Range<Integer> Q = null;
    private volatile long R = 0;
    private int S = 7;
    private final CameraDevice.StateCallback T = new a();
    private final CameraCaptureSession.StateCallback U = new C0238b();
    CameraCaptureSession.CaptureCallback V = new c();
    private final CameraCaptureSession.CaptureCallback W = new d();
    private final ImageReader.OnImageAvailableListener X = new e();
    private final ImageReader.OnImageAvailableListener Y = new f();

    public class a extends CameraDevice.StateCallback {
        public a() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            Log.d(b.Z, "StateCallback.onClosed.");
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            b.this.A = null;
            Log.d(b.Z, "StateCallback.onDisconnected.");
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            Log.e(b.Z, "StateCallback.onError., onError: " + cameraDevice.getId() + " (" + i + ")");
            b.this.A = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            b.this.A = cameraDevice;
            Log.d(b.Z, "StateCallback.onOpened, get CameraDevice");
            b.this.o();
        }
    }

    /* JADX INFO: renamed from: com.aliyun.svideosdk.preview.camera.b$b, reason: collision with other inner class name */
    public class C0238b extends CameraCaptureSession.StateCallback {
        public C0238b() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            if (b.this.B == null || !b.this.B.equals(cameraCaptureSession)) {
                return;
            }
            b.this.B = null;
            Log.d(b.Z, "StateCallback.onClosed, mCaptureSession = null");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Log.e(b.Z, "Failed to configure capture session.");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            if (b.this.A == null) {
                return;
            }
            Log.d(b.Z, "StateCallback.onConfigured, get mCaptureSession");
            b.this.B = cameraCaptureSession;
            b.this.q();
            b.this.I.a(b.this.j(), b.this.b);
            b.this.n();
        }
    }

    public class c extends CameraCaptureSession.CaptureCallback {
        public c() {
        }

        private void a(CaptureResult captureResult) {
            int i = b.this.S;
            if (i == 2) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num == null) {
                    return;
                }
                if (num.intValue() != 4 && num.intValue() != 5) {
                    return;
                }
                Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num2 != null && num2.intValue() != 2) {
                    b.this.S = 3;
                    b.this.l();
                    return;
                }
            } else {
                if (i == 4) {
                    Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num3 == null || num3.intValue() == 5 || num3.intValue() == 4 || num3.intValue() == 2) {
                        b.this.S = 5;
                        return;
                    }
                    return;
                }
                if (i != 5) {
                    return;
                }
                Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num4 != null && num4.intValue() == 5) {
                    return;
                }
            }
            b.this.S = 6;
            b.this.f();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            a(totalCaptureResult);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            a(captureResult);
        }
    }

    public class d extends CameraCaptureSession.CaptureCallback {
        public d() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            if (b.this.g) {
                b.this.p();
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            if (b.this.f) {
                b.this.K.play(0);
            }
        }
    }

    public class e implements ImageReader.OnImageAvailableListener {
        public e() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image imageAcquireNextImage = imageReader.acquireNextImage();
            try {
                Image.Plane[] planes = imageAcquireNextImage.getPlanes();
                if (planes.length > 0) {
                    Log.d(b.Z, "onImageAvailable, image width = " + imageAcquireNextImage.getWidth() + ", height = " + imageAcquireNextImage.getHeight());
                    ByteBuffer buffer = planes[0].getBuffer();
                    byte[] bArr = new byte[buffer.remaining()];
                    buffer.get(bArr);
                    if (b.this.i != null) {
                        b.this.i.a(bArr);
                    }
                }
                imageAcquireNextImage.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (imageAcquireNextImage != null) {
                        try {
                            imageAcquireNextImage.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    public class f implements ImageReader.OnImageAvailableListener {
        public f() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image image;
            try {
                b.this.G = imageReader.acquireNextImage();
                if (b.this.G.getTimestamp() < b.this.R) {
                    Log.d(b.Z, "onImageAvailable, mImage.getTimestamp() < mRequestRenderTimestamp, return");
                    if (image != null) {
                        return;
                    } else {
                        return;
                    }
                }
                Image.Plane[] planes = b.this.G.getPlanes();
                if (planes.length > 0) {
                    ByteBuffer buffer = planes[0].getBuffer();
                    byte[] bArr = new byte[buffer.remaining()];
                    buffer.get(bArr);
                    if (b.this.d != null) {
                        b.this.d.onFrameBack(bArr, b.this.G.getWidth(), b.this.G.getHeight(), b.this.o);
                    }
                    if (b.this.h != null) {
                        b.this.h.onFrameBack(bArr, b.this.G.getWidth(), b.this.G.getHeight(), b.this.o);
                    }
                    if (b.this.j != null) {
                        b.this.j.a(b.this.z.a(), b.this.x.getWidth(), b.this.x.getHeight());
                    }
                }
            } catch (Exception e) {
                Log.e(b.Z, "mPreviewReader, onImageAvailable failed", e);
            } finally {
                if (b.this.G != null) {
                    b.this.G.close();
                    b.this.G = null;
                }
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (7 != b.this.S) {
                b.this.p();
            }
        }
    }

    public class h implements com.aliyun.svideosdk.a.e.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.aliyun.svideosdk.a.b f25830a;

        public h(com.aliyun.svideosdk.a.b bVar) {
            this.f25830a = bVar;
        }

        @Override // com.aliyun.svideosdk.a.e.a.d
        public void a(int i, int i2, ByteBuffer byteBuffer) {
            com.aliyun.svideosdk.a.b bVar = this.f25830a;
            if (bVar != null) {
                bVar.a(i, i2, b.this.c(), byteBuffer);
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        a0 = sparseIntArray;
        sparseIntArray.put(0, 1);
        sparseIntArray.put(1, 0);
        b0 = com.aliyun.common.utils.b.b(16, 9);
    }

    public b(Context context, com.aliyun.svideosdk.a.e.a aVar, com.aliyun.common.c.b.e eVar) {
        this.j = aVar;
        this.k = eVar;
        this.f25822a = (CameraManager) context.getApplicationContext().getSystemService(com.alibaba.triver.embed.video.video.h.d);
        HandlerThread handlerThread = new HandlerThread("camera-background");
        this.l = handlerThread;
        handlerThread.start();
        this.m = new Handler(this.l.getLooper());
        this.I = new com.aliyun.svideosdk.a.f.d();
        this.J = new com.aliyun.svideosdk.a.f.c();
        this.K = new MediaActionSound();
    }

    private CaptureRequest.Builder a(boolean z, List<Surface> list) {
        if (z) {
            Log.d(Z, "getCaptureBuilder, createBuilder, TEMPLATE_STILL_CAPTURE type");
            return a(2, list);
        }
        if (this.D == null) {
            Log.d(Z, "getCaptureBuilder, createBuilder, TEMPLATE_STILL_CAPTURE type");
            this.D = a(2, list);
        }
        return this.D;
    }

    private Size a(int i, int i2) {
        Size size = new Size(i2, i);
        Size size2 = null;
        if (!this.s.contains(size)) {
            size = null;
        }
        if (this.d != null) {
            new ArrayList(this.s);
        }
        if (size == null) {
            ArrayList<Size> arrayList = new ArrayList();
            for (Size size3 : this.s) {
                if (size2 == null) {
                    size2 = size3;
                }
                if (size2.getWidth() < size3.getWidth() && size2.getHeight() < size3.getHeight()) {
                    size2 = size3;
                }
                if (size3.getWidth() >= i2 && size3.getHeight() >= i && Math.min(size3.getWidth() / i2, size3.getHeight() / i) >= 1.0f) {
                    arrayList.add(size3);
                }
            }
            float f2 = Float.MAX_VALUE;
            for (Size size4 : arrayList) {
                float width = size4.getWidth() * size4.getHeight();
                if (width < f2) {
                    size = size4;
                    f2 = width;
                }
            }
            if (size == null) {
                Log.w(Z, "use maxSize: " + size2.getWidth() + " x " + size2.getHeight());
                size = size2;
            }
        }
        Log.d(Z, "mAspectRatio = " + this.z.toString() + ", bestPreviewSize, width = " + size.getWidth() + ", height = " + size.getHeight());
        this.z = com.aliyun.common.utils.b.b(size.getWidth(), size.getHeight());
        return size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.E.getSurface());
            CaptureRequest.Builder builderA = a(false, (List<Surface>) arrayList);
            CaptureRequest.Key key = CaptureRequest.CONTROL_AF_MODE;
            builderA.set(key, this.C.get(key));
            builderA.set(CaptureRequest.SCALER_CROP_REGION, this.M);
            builderA.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.P));
            String str = Z;
            Log.d(str, "captureStillPicture, mExposureCompensation = " + this.P);
            this.I.a(builderA, this.b);
            int iIntValue = ((Integer) this.r.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
            CaptureRequest.Key key2 = CaptureRequest.JPEG_ORIENTATION;
            int i = this.n;
            int i2 = 1;
            if (this.p != 1) {
                i2 = -1;
            }
            builderA.set(key2, Integer.valueOf(((iIntValue + (i * i2)) + 360) % 360));
            this.B.stopRepeating();
            this.B.abortCaptures();
            Log.d(str, "captureStillPicture, mCaptureSession.capture");
            this.B.capture(builderA.build(), this.W, this.m);
        } catch (CameraAccessException e2) {
            Log.e(Z, "Cannot capture a still picture.", e2);
        }
    }

    private boolean g() {
        try {
            int i = a0.get(this.p);
            String[] cameraIdList = this.f25822a.getCameraIdList();
            if (cameraIdList.length == 0) {
                throw new RuntimeException("No camera available.");
            }
            for (String str : cameraIdList) {
                CameraCharacteristics cameraCharacteristics = this.f25822a.getCameraCharacteristics(str);
                if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)) != null) {
                    Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    if (num == null) {
                        throw new NullPointerException("Unexpected state: LENS_FACING null");
                    }
                    if (num.intValue() == i) {
                        this.q = str;
                        this.r = cameraCharacteristics;
                        return true;
                    }
                }
            }
            String str2 = cameraIdList[0];
            this.q = str2;
            CameraCharacteristics cameraCharacteristics2 = this.f25822a.getCameraCharacteristics(str2);
            this.r = cameraCharacteristics2;
            Integer num2 = (Integer) cameraCharacteristics2.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            if (num2 != null && num2.intValue() != 2) {
                Integer num3 = (Integer) this.r.get(CameraCharacteristics.LENS_FACING);
                if (num3 == null) {
                    throw new NullPointerException("Unexpected state: LENS_FACING null");
                }
                int size = a0.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SparseIntArray sparseIntArray = a0;
                    if (sparseIntArray.valueAt(i2) == num3.intValue()) {
                        this.p = sparseIntArray.keyAt(i2);
                        return true;
                    }
                }
                this.p = 0;
                return true;
            }
            return false;
        } catch (CameraAccessException e2) {
            throw new RuntimeException("Failed to get a list of camera devices", e2);
        }
    }

    private Size h() {
        Size sizeLast = this.x;
        SortedSet<Size> sortedSetUnmodifiableSortedSet = Collections.unmodifiableSortedSet(this.u.b(this.z));
        if (!sortedSetUnmodifiableSortedSet.contains(sizeLast)) {
            sizeLast = null;
        }
        OnChoosePictureSizeCallback onChoosePictureSizeCallback = this.e;
        Size sizeOnChoosePictureSize = onChoosePictureSizeCallback != null ? onChoosePictureSizeCallback.onChoosePictureSize(sortedSetUnmodifiableSortedSet) : null;
        if (sizeOnChoosePictureSize != null && sortedSetUnmodifiableSortedSet.contains(sizeOnChoosePictureSize)) {
            sizeLast = sizeOnChoosePictureSize;
        }
        if (sizeLast == null) {
            sizeLast = sortedSetUnmodifiableSortedSet.last();
        }
        Log.d(Z, "bestPictureSize, width = " + sizeLast.getWidth() + ", height = " + sizeLast.getHeight());
        return sizeLast;
    }

    private void i() {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.r.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            throw new IllegalStateException("Failed to get configuration map: " + this.p);
        }
        this.t.a();
        for (android.util.Size size : streamConfigurationMap.getOutputSizes(SurfaceTexture.class)) {
            this.t.a(new Size(size.getWidth(), size.getHeight()));
        }
        this.u.a();
        for (android.util.Size size2 : streamConfigurationMap.getOutputSizes(256)) {
            this.u.a(new Size(size2.getWidth(), size2.getHeight()));
        }
        ArrayList arrayList = new ArrayList();
        for (com.aliyun.common.utils.b bVar : this.t.b()) {
            if (!this.u.b().contains(bVar)) {
                arrayList.add(bVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.t.a((com.aliyun.common.utils.b) it.next());
        }
        this.s.clear();
        Iterator<com.aliyun.common.utils.b> it2 = this.t.b().iterator();
        while (it2.hasNext()) {
            Iterator<Size> it3 = this.t.b(it2.next()).iterator();
            while (it3.hasNext()) {
                this.s.add(it3.next());
            }
        }
        this.L = ((Float) this.r.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        this.N = (Rect) this.r.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        this.O = ((Integer) this.r.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        this.Q = (Range) this.r.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        Log.d(Z, "collectCameraInfo, mMaxZoom = " + this.L + ", mSensorInfoSize = " + this.N.width() + " x " + this.N.width());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CaptureRequest.Builder j() {
        if (this.C == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.H);
            arrayList.add(this.F.getSurface());
            CaptureRequest.Builder builderA = a(1, arrayList);
            this.C = builderA;
            builderA.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
            this.S = 0;
            Log.d(Z, "getPreviewBuilder, createCaptureRequest TEMPLATE_PREVIEW");
        }
        return this.C;
    }

    private void k() {
        ImageReader imageReader = this.E;
        if (imageReader != null) {
            imageReader.close();
            this.E = null;
        }
        ImageReader imageReaderNewInstance = ImageReader.newInstance(this.y.getWidth(), this.y.getHeight(), 256, 2);
        this.E = imageReaderNewInstance;
        imageReaderNewInstance.setOnImageAvailableListener(this.X, this.m);
        ImageReader imageReader2 = this.F;
        if (imageReader2 != null) {
            imageReader2.close();
            this.F = null;
            Log.d(Z, "prepareImageReader, mPreviewReader.close()");
        }
        ImageReader imageReaderNewInstance2 = ImageReader.newInstance(this.x.getWidth(), this.x.getHeight(), 35, 2);
        this.F = imageReaderNewInstance2;
        imageReaderNewInstance2.setOnImageAvailableListener(this.Y, this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        CaptureRequest captureRequestA = this.I.a(j());
        Log.d(Z, "sendPreviewRequest, call sendRepeatingRequest mPreviewCallback");
        b(captureRequestA, this.V, this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.A == null) {
            Log.e(Z, "camera is not open !!!");
            return;
        }
        this.J.a(this.x.getHeight(), this.x.getWidth(), this.O, this.N, this.p);
        SurfaceTexture surfaceTextureJ = this.j.j();
        surfaceTextureJ.setDefaultBufferSize(this.x.getWidth(), this.x.getHeight());
        surfaceTextureJ.setOnFrameAvailableListener(this);
        this.H = new Surface(surfaceTextureJ);
        try {
            Log.d(Z, "startCaptureSession, surfaceTexture size: " + this.x.getWidth() + " x " + this.x.getHeight());
            j();
            this.A.createCaptureSession(Arrays.asList(this.H, this.E.getSurface(), this.F.getSurface()), this.U, null);
        } catch (CameraAccessException unused) {
            throw new RuntimeException("Failed to start camera session");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            q();
            this.I.a(j(), this.b);
            this.C.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
            this.C.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            Log.d(Z, "unlockFocus, mCaptureSession.setRepeatingRequest()");
            this.B.setRepeatingRequest(this.C.build(), this.V, this.m);
            this.S = 1;
        } catch (CameraAccessException e2) {
            Log.e(Z, "Failed to restart camera preview.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        CameraCharacteristics cameraCharacteristics = this.r;
        if (cameraCharacteristics == null || this.C == null) {
            return;
        }
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr == null || iArr.length == 0 || (iArr.length == 1 && iArr[0] == 0)) {
            this.C.set(CaptureRequest.CONTROL_AF_MODE, 0);
        } else {
            this.C.set(CaptureRequest.CONTROL_AF_MODE, 3);
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int a() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    @SuppressLint({"MissingPermission"})
    public int a(int i, int i2, int i3) {
        this.v = i;
        this.w = i2;
        this.p = i3;
        String str = Z;
        Log.d(str, "cameraId = " + i3);
        if (g()) {
            i();
            this.I.a(this.r);
            this.x = a(i, i2);
            this.y = h();
            k();
            try {
                Log.d(str, "camera id : " + this.q);
                Camera.getCameraInfo(this.p, this.o);
                this.f25822a.openCamera(this.q, this.T, this.m);
            } catch (CameraAccessException e2) {
                throw new RuntimeException("Failed to open camera: " + this.p, e2);
            }
        }
        return this.p;
    }

    public CaptureRequest.Builder a(int i, List<Surface> list) {
        try {
            CaptureRequest.Builder builderCreateCaptureRequest = this.A.createCaptureRequest(i);
            Iterator<Surface> it = list.iterator();
            while (it.hasNext()) {
                builderCreateCaptureRequest.addTarget(it.next());
            }
            Log.d(Z, "createBuilder, cameraDevice.createCaptureRequest CaptureRequest.Builder, and addTarget, captureType = " + i);
            return builderCreateCaptureRequest;
        } catch (CameraAccessException | IllegalStateException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(float f2, float f3) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(int i) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(Point point) {
        MeteringRectangle meteringRectangleA = this.J.a(point.x, point.y, true);
        MeteringRectangle meteringRectangleA2 = this.J.a(point.x, point.y, false);
        Log.d(Z, "manualFocus, focusRect = {" + meteringRectangleA.getRect().left + ", " + meteringRectangleA.getRect().top + ", " + meteringRectangleA.getRect().bottom + ", " + meteringRectangleA.getRect().right + "}");
        a(meteringRectangleA, meteringRectangleA2);
    }

    public void a(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) {
        try {
            Log.d(Z, "sendCaptureRequest, cameraSession.capture");
            this.B.capture(captureRequest, captureCallback, handler);
        } catch (CameraAccessException | IllegalStateException e2) {
            Log.e(Z, "send capture request error:" + e2.getMessage());
        }
    }

    public void a(MeteringRectangle meteringRectangle, MeteringRectangle meteringRectangle2) {
        CaptureRequest.Builder builderJ = j();
        b(this.I.a(builderJ, meteringRectangle, meteringRectangle2), this.V, this.m);
        builderJ.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        Log.d(Z, "sendControlAfAeRequest, CONTROL_AF_TRIGGER_START");
        a(builderJ.build(), (CameraCaptureSession.CaptureCallback) null, this.m);
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.a.a aVar) {
        this.h = aVar;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.a.b bVar) {
        this.j.a(new h(bVar));
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.a.c cVar) {
        Log.d(Z, com.alibaba.ariver.jsapi.multimedia.camera.a.f24158a);
        this.i = cVar;
        if (FlashType.OFF.toString() != this.b) {
            m();
        } else {
            f();
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(OnChoosePictureSizeCallback onChoosePictureSizeCallback) {
        this.e = onChoosePictureSizeCallback;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(boolean z) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public boolean a(String str) {
        this.b = str;
        Log.d(Z, "flash : " + this.b);
        b(this.I.b(j(), this.b), this.V, this.m);
        return true;
    }

    public void b(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) {
        try {
            Log.d(Z, "cameraSession.setRepeatingRequest");
            CameraCaptureSession cameraCaptureSession = this.B;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.setRepeatingRequest(captureRequest, captureCallback, handler);
            }
        } catch (CameraAccessException | IllegalStateException e2) {
            Log.e(Z, "send repeating request error:" + e2.getMessage());
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public boolean b() {
        return true;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public Camera.CameraInfo c() {
        Camera.getCameraInfo(this.p, this.o);
        return this.o;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void d() {
        this.S = 7;
        if (this.B != null) {
            Log.d(Z, "closeCamera, mCaptureSession.close()");
            this.B.close();
            this.B = null;
        }
        CameraDevice cameraDevice = this.A;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.A = null;
        }
        ImageReader imageReader = this.E;
        if (imageReader != null) {
            imageReader.close();
            this.E = null;
        }
        ImageReader imageReader2 = this.F;
        if (imageReader2 != null) {
            imageReader2.close();
            this.F = null;
        }
        if (this.C != null) {
            this.C = null;
        }
        if (this.D != null) {
            this.D = null;
        }
        Surface surface = this.H;
        if (surface != null) {
            surface.release();
            this.H = null;
        }
        if (this.Q != null) {
            this.Q = null;
        }
        if (this.N != null) {
            this.N = null;
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int getCameraCount() {
        return Camera.getNumberOfCameras();
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public float getCurrentExposureCompensationRatio() {
        if (7 == this.S || this.Q == null) {
            return 0.5f;
        }
        return (((Integer) j().get(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION)).intValue() - ((Integer) this.Q.getLower()).intValue()) / (((Integer) this.Q.getUpper()).intValue() - ((Integer) this.Q.getLower()).intValue());
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public List<Camera.Size> getSupportedPictureSize() {
        return null;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public SortedSet<Size> getSupportedPictureSizes() {
        return this.u.b(this.z);
    }

    public void l() {
        this.C.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        this.S = 4;
        Log.d(Z, "sendAECaptureRequest, mCaptureSession.capture");
        a(this.C.build(), this.V, this.m);
        this.C.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
    }

    public void m() {
        this.S = 2;
        CaptureRequest.Builder builderJ = j();
        builderJ.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        Log.d(Z, "sendAFCapture, set CONTROL_AF_TRIGGER_START and sendCaptureRequest");
        a(builderJ.build(), this.V, this.m);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.R = surfaceTexture.getTimestamp();
        this.j.r();
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int release() {
        MediaActionSound mediaActionSound = this.K;
        if (mediaActionSound != null) {
            mediaActionSound.release();
        }
        HandlerThread handlerThread = this.l;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.l = null;
        }
        if (this.m == null) {
            return 0;
        }
        this.m = null;
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setCameraCaptureDataMode(int i) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setCameraParam(CameraParam cameraParam) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int setExposureCompensationRatio(float f2) {
        if (7 == this.S || this.Q == null) {
            return -20005007;
        }
        this.P = this.I.a(j(), this.Q, f2);
        b(this.C.build(), this.V, this.m);
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setFocusMode(int i) {
        this.c = i;
        q();
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setOnFrameCallback(OnFrameCallback onFrameCallback) {
        this.d = onFrameCallback;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int setPictureSize(int i, int i2) {
        Size size = new Size(i, i2);
        com.aliyun.common.c.b.e eVar = this.k;
        if (eVar != null) {
            eVar.a(size, this.u.b(this.z));
        }
        if (!this.u.b(this.z).contains(size)) {
            return -20003002;
        }
        this.y = size;
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setRotation(int i) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setShutterSound(boolean z) {
        this.f = z;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setTakePicturePreview(boolean z) {
        this.g = z;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int setZoom(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (7 == this.S || this.N == null) {
            return -20005007;
        }
        b(this.I.a(j(), ((this.L - 1.0f) * f2) + 1.0f, this.N, this.M), this.V, this.m);
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int startPreviewAfterTakePicture() {
        this.m.post(new g());
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int switchCamera() {
        this.p = this.p == 0 ? 1 : 0;
        if (this.A != null) {
            d();
        }
        return a(this.v, this.w, this.p);
    }
}
