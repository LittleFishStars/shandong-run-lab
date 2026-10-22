package com.aliyun.svideosdk.preview.camera;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.aliyun.common.utils.Size;
import com.aliyun.common.utils.o;
import com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback;
import com.aliyun.svideosdk.common.struct.recorder.CameraParam;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.zj.adlib.c49;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements f, Camera.PreviewCallback, SurfaceTexture.OnFrameAvailableListener {
    public static final String Q = "a";
    private com.aliyun.svideosdk.a.e.a H;
    private com.aliyun.common.c.b.e K;
    private float c;
    private int d;
    private int e;
    private String f;
    private Integer g;
    private Float h;
    private Camera.Parameters i;
    private boolean j;
    private int m;
    private CameraParam o;
    private OnFrameCallback p;
    private com.aliyun.svideosdk.a.a q;
    private int s;
    private int t;
    private int v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f25816a = 0;
    private int b = 0;
    private Camera.CameraInfo k = new Camera.CameraInfo();
    private Camera l = null;
    private Camera.Size n = null;
    private OnChoosePictureSizeCallback r = null;
    private com.aliyun.common.utils.b u = null;
    private int w = 0;
    private boolean x = true;
    private boolean y = true;
    private boolean z = false;
    private Matrix A = new Matrix();
    private volatile int B = 3;
    private Object C = new Object();
    private int D = 3;
    private List<byte[]> E = new ArrayList();
    private volatile boolean F = true;
    private int G = 0;
    private float I = 0.0f;
    private final o J = new o();
    private boolean L = false;
    private Object M = new Object();
    private long N = 0;
    private Handler O = new Handler(Looper.myLooper());
    private Runnable P = new RunnableC0237a();

    /* JADX INFO: renamed from: com.aliyun.svideosdk.preview.camera.a$a, reason: collision with other inner class name */
    public class RunnableC0237a implements Runnable {
        public RunnableC0237a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (a.this.C) {
                if (a.this.j) {
                    Log.d(a.Q, "force cancel focus trigger");
                    a.this.j = false;
                    a.this.b("force cancel focus");
                } else {
                    Log.d(a.Q, "force cancel focus skip");
                }
            }
        }
    }

    public class b implements Camera.ShutterCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.aliyun.svideosdk.a.c f25818a;

        public b(a aVar, com.aliyun.svideosdk.a.c cVar) {
            this.f25818a = cVar;
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            com.aliyun.svideosdk.a.c cVar = this.f25818a;
            if (cVar != null) {
                cVar.onShutter();
            }
        }
    }

    public class c implements Camera.PictureCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f25819a;
        final /* synthetic */ com.aliyun.svideosdk.a.c b;

        public c(long j, com.aliyun.svideosdk.a.c cVar) {
            this.f25819a = j;
            this.b = cVar;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            com.aliyun.common.c.a.a.a("AliYunLog", "takePicture callback: costTime=" + (System.currentTimeMillis() - this.f25819a));
            a.this.z = false;
            synchronized (a.this.C) {
                if (a.this.B != 3) {
                    com.aliyun.svideosdk.a.c cVar = this.b;
                    if (cVar != null) {
                        cVar.a(bArr);
                    }
                    if (a.this.y) {
                        try {
                            camera.startPreview();
                        } catch (Exception e) {
                            Log.e("AliYunLog", "Start Preview failed after takePicture " + e.getMessage());
                        }
                    }
                }
            }
        }
    }

    public class d implements com.aliyun.svideosdk.a.e.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.aliyun.svideosdk.a.b f25820a;

        public d(com.aliyun.svideosdk.a.b bVar) {
            this.f25820a = bVar;
        }

        @Override // com.aliyun.svideosdk.a.e.a.d
        public void a(int i, int i2, ByteBuffer byteBuffer) {
            com.aliyun.svideosdk.a.b bVar = this.f25820a;
            if (bVar != null) {
                bVar.a(i, i2, a.this.c(), byteBuffer);
            }
        }
    }

    public class e implements Camera.AutoFocusCallback {
        public e() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            synchronized (a.this.C) {
                if (a.this.O != null) {
                    a.this.O.removeCallbacks(a.this.P, null);
                }
                a.this.j = false;
                String str = a.Q;
                Log.d(str, "onAutoFocus, current mCamera status " + a.this.B + ", succ = " + z);
                if (a.this.B == 3) {
                    Log.w(str, "Camera is released");
                    return;
                }
                try {
                    camera.cancelAutoFocus();
                } catch (RuntimeException e) {
                    Log.e(a.Q, "onAutoFocus exception " + e.toString());
                }
                Camera.Parameters parametersH = a.this.h();
                if (parametersH == null) {
                    return;
                }
                if (parametersH.isAutoExposureLockSupported()) {
                    parametersH.setAutoExposureLock(false);
                }
                if (parametersH.isAutoWhiteBalanceLockSupported()) {
                    parametersH.setAutoWhiteBalanceLock(false);
                }
                try {
                    a.this.l.setParameters(parametersH);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public a(com.aliyun.svideosdk.a.e.a aVar, com.aliyun.common.c.b.e eVar) {
        this.H = aVar;
        this.K = eVar;
    }

    private List<Camera.Size> a(SortedSet<Size> sortedSet, List<Camera.Size> list) {
        if (sortedSet == null || list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : sortedSet) {
            for (Camera.Size size2 : list) {
                if (size.getWidth() == size2.width && size.getHeight() == size2.height) {
                    arrayList.add(size2);
                    break;
                }
            }
        }
        return arrayList;
    }

    private void a(Camera.Parameters parameters, int i) {
        int i2;
        int[] iArr = {800000, 800000};
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        int i3 = i * 1000;
        Iterator<int[]> it = parameters.getSupportedPreviewFpsRange().iterator();
        String string = "Supported Preview Framerate: ";
        while (it.hasNext()) {
            int[] next = it.next();
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(next[0] / 1000);
            sb.append(c49.f40900a);
            sb.append(next[1] / 1000);
            sb.append(AliyunLogKey.KEY_FPS);
            sb.append(it.hasNext() ? ", " : "");
            string = sb.toString();
            int iAbs = Math.abs(next[0] - i3);
            int iAbs2 = Math.abs(next[1] - i3);
            if (iAbs2 <= iArr[1] && iAbs <= iArr[0]) {
                iArr[0] = iAbs;
                iArr[1] = iAbs2;
                int i4 = next[0];
                iArr2[0] = i4;
                int i5 = next[1];
                iArr2[1] = i5;
                if (i4 != i5) {
                    iArr3[0] = i4;
                    iArr3[1] = i5;
                }
            }
        }
        Log.d("AliYunLog", string);
        int i6 = iArr3[0];
        if (i6 != 0 && (i2 = iArr3[1]) != 0) {
            parameters.setPreviewFpsRange(i6, i2);
        }
        parameters.setPreviewFrameRate(30);
        parameters.getPreviewFpsRange(iArr2);
        this.m = (iArr2[0] + iArr2[1]) / 2000;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0069  */
    private void a(Camera.Parameters parameters, int i, int i2) {
        int i3;
        Log.d("AliYunLog", "Preview size: expected size is " + i2 + " " + i);
        Camera.Size preferredPreviewSizeForVideo = parameters.getPreferredPreviewSizeForVideo();
        if (preferredPreviewSizeForVideo != null) {
            Log.d("AliYunLog", "Camera preferred preview size for video is " + preferredPreviewSizeForVideo.width + "x" + preferredPreviewSizeForVideo.height);
        }
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        Camera.Size size = null;
        Camera.Size sizeOnChoosePreviewSize = this.p != null ? this.p.onChoosePreviewSize(new ArrayList(supportedPreviewSizes), preferredPreviewSizeForVideo) : null;
        boolean z = true;
        if (sizeOnChoosePreviewSize != null) {
            if (supportedPreviewSizes.contains(sizeOnChoosePreviewSize)) {
                preferredPreviewSizeForVideo = sizeOnChoosePreviewSize;
            } else {
                z = false;
            }
        } else if (preferredPreviewSizeForVideo == null) {
            z = false;
        }
        if (!z) {
            ArrayList<Camera.Size> arrayList = new ArrayList();
            for (Camera.Size size2 : supportedPreviewSizes) {
                if (size == null || (size.width < size2.width && size.height < size2.height)) {
                    size = size2;
                }
                int i4 = size2.width;
                if (i4 >= i2 && (i3 = size2.height) >= i && Math.min(i4 / i2, i3 / i) >= 1.0f) {
                    arrayList.add(size2);
                }
            }
            float f = Float.MAX_VALUE;
            for (Camera.Size size3 : arrayList) {
                float f2 = size3.width * size3.height;
                if (f2 < f) {
                    preferredPreviewSizeForVideo = size3;
                    f = f2;
                }
            }
            if (preferredPreviewSizeForVideo == null) {
                Log.w(Q, "use maxSize: " + size.width + " x " + size.height);
                preferredPreviewSizeForVideo = size;
            }
        }
        Log.d("AliYunLog", "choosePreviewSize, setPreviewSize, width = " + preferredPreviewSizeForVideo.width + ", height = " + preferredPreviewSizeForVideo.height);
        parameters.setPreviewSize(preferredPreviewSizeForVideo.width, preferredPreviewSizeForVideo.height);
        int i5 = preferredPreviewSizeForVideo.width;
        this.d = i5;
        int i6 = preferredPreviewSizeForVideo.height;
        this.e = i6;
        this.u = com.aliyun.common.utils.b.b(i5, i6);
        this.n = preferredPreviewSizeForVideo;
        this.I = preferredPreviewSizeForVideo.width / preferredPreviewSizeForVideo.height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Camera camera = this.l;
        if (camera != null) {
            try {
                camera.cancelAutoFocus();
            } catch (RuntimeException e2) {
                Log.d(Q, str + " cancelAutoFocus exception " + e2.toString());
            }
        }
    }

    private void e() {
        List<Camera.Size> supportedPictureSizes = this.i.getSupportedPictureSizes();
        this.J.a();
        for (Camera.Size size : supportedPictureSizes) {
            this.J.a(new Size(size.width, size.height));
        }
        SortedSet<Size> sortedSetB = this.J.b(this.u);
        Camera.Size previewSize = this.i.getPreviewSize();
        if (sortedSetB == null) {
            Log.d("AliYunLog", "choosePictureSize, previewSize " + previewSize.width + "x" + previewSize.height + " is not in pictureSize");
            return;
        }
        List<Camera.Size> listA = a(sortedSetB, supportedPictureSizes);
        OnChoosePictureSizeCallback onChoosePictureSizeCallback = this.r;
        Camera.Size size2 = null;
        Camera.Size sizeOnChoosePictureSize = onChoosePictureSizeCallback != null ? onChoosePictureSizeCallback.onChoosePictureSize(listA) : null;
        if (sizeOnChoosePictureSize != null) {
            for (Size size3 : sortedSetB) {
                if (size3.getWidth() == sizeOnChoosePictureSize.width && size3.getHeight() == sizeOnChoosePictureSize.height) {
                    size2 = sizeOnChoosePictureSize;
                    break;
                }
            }
        }
        if (size2 == null) {
            for (Size size4 : sortedSetB) {
                if (size4.getWidth() == previewSize.width && size4.getHeight() == previewSize.height) {
                    size2 = previewSize;
                    break;
                }
            }
        }
        if (size2 == null) {
            Log.e("AliYunLog", "choosePictureSize, previewSize " + previewSize.width + "x" + previewSize.height + " is not in pictureSize");
            return;
        }
        this.i.setPictureSize(size2.width, size2.height);
        Log.d(Q, "setPictureSize, width =  " + size2.width + ", height = " + size2.height);
    }

    private int f() {
        int i;
        String str;
        StringBuilder sb;
        synchronized (this.C) {
            if (this.B == 1) {
                try {
                    Camera.Parameters parametersH = h();
                    this.i = parametersH;
                    if (parametersH == null) {
                        Log.e("AliYunLog", "Get camera parameters null!");
                        return -20005002;
                    }
                    a(parametersH, this.s, this.t);
                    e();
                    Matrix matrix = new Matrix();
                    matrix.postScale(this.d / 2000.0f, this.e / 2000.0f);
                    matrix.postTranslate(this.d / 2, this.e / 2);
                    matrix.invert(this.A);
                    a(this.i, this.m);
                    int maxZoom = this.i.getMaxZoom();
                    String str2 = this.f;
                    if (str2 != null) {
                        a(str2);
                    }
                    Integer num = this.g;
                    if (num != null) {
                        setFocusMode(num.intValue());
                    }
                    Float f = this.h;
                    if (f != null) {
                        setExposureCompensationRatio(f.floatValue());
                    }
                    this.i.setZoom((int) (maxZoom * this.c));
                    Camera.getCameraInfo(this.v, this.k);
                    int i2 = this.f25816a;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            i = 90;
                        } else if (i2 != 2) {
                            i = i2 != 3 ? 0 : 270;
                        } else {
                            i = 180;
                        }
                    }
                    Camera.CameraInfo cameraInfo = this.k;
                    if (cameraInfo.facing == 1) {
                        int i3 = cameraInfo.orientation;
                        this.w = ((270 - i3) + 360) % 360;
                        int i4 = (i3 + i) % 360;
                        this.b = i4;
                        this.b = (360 - i4) % 360;
                        str = Q;
                        sb = new StringBuilder();
                        sb.append("facing front info.orientation is ");
                        sb.append(this.k.orientation);
                    } else {
                        int i5 = cameraInfo.orientation;
                        this.w = ((i5 + 270) + 360) % 360;
                        this.b = ((i5 - i) + 360) % 360;
                        str = Q;
                        sb = new StringBuilder();
                        sb.append("facing back info.orientation is ");
                        sb.append(this.k.orientation);
                    }
                    Log.d(str, sb.toString());
                    this.l.setDisplayOrientation(this.b);
                    com.aliyun.svideosdk.a.e.a aVar = this.H;
                    Camera.Size size = this.n;
                    aVar.a(size.width, size.height, this.b);
                    setCameraParam(this.o);
                    SurfaceTexture surfaceTextureJ = this.H.j();
                    surfaceTextureJ.setOnFrameAvailableListener(this);
                    this.l.setPreviewTexture(surfaceTextureJ);
                    this.l.setPreviewCallbackWithBuffer(null);
                    Camera.Size size2 = this.n;
                    int i6 = ((size2.width * size2.height) * 3) / 2;
                    for (int i7 = 0; i7 < this.D; i7++) {
                        byte[] bArr = new byte[i6];
                        this.E.add(bArr);
                        this.l.addCallbackBuffer(bArr);
                    }
                    this.l.setPreviewCallbackWithBuffer(this);
                    Log.d(Q, "doStartPreview, setPreviewCallbackWithBuffer, mCameraBufferNum = " + this.D);
                    this.l.setParameters(this.i);
                    try {
                        this.l.startPreview();
                        this.B = 2;
                    } catch (RuntimeException e2) {
                        Log.e("AliYunLog", "Start Preview failed " + e2.getMessage());
                        OnFrameCallback onFrameCallback = this.p;
                        if (onFrameCallback != null) {
                            onFrameCallback.openFailed();
                        }
                        return -20005001;
                    }
                } catch (Exception e3) {
                    OnFrameCallback onFrameCallback2 = this.p;
                    if (onFrameCallback2 != null) {
                        onFrameCallback2.openFailed();
                    }
                    Log.e("AliYunLog", "Open Camera failed " + e3.getMessage());
                    return -20005002;
                }
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Camera.Parameters h() {
        synchronized (this.C) {
            Camera.Parameters parameters = null;
            if (this.l == null) {
                return null;
            }
            if (this.B == 3) {
                Log.e("AliYunLog", "Camera already released!getCameraParameters null");
                return null;
            }
            try {
                parameters = this.l.getParameters();
            } catch (RuntimeException e2) {
                Log.e("AliYunLog", "Camera getParameters Exception ,msg : " + e2.getMessage());
            }
            return parameters;
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int a() {
        return this.w;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int a(int i, int i2, int i3) {
        synchronized (this.C) {
            if (this.B != 3) {
                Log.e("AliYunLog", "Camera is already opened");
                return -4;
            }
            this.s = i;
            this.t = i2;
            this.v = i3;
            try {
                this.l = Camera.open(i3);
                Log.d("AliYunLog", "Open camera success!, Camera is " + this.l);
                this.B = 1;
                int iF = f();
                if (this.K != null) {
                    this.H.m();
                    com.aliyun.common.c.b.e eVar = this.K;
                    OnTextureIdCallback onTextureIdCallbackH = this.H.h();
                    int i4 = this.d;
                    int i5 = this.e;
                    eVar.a(onTextureIdCallbackH, i4, i5, i4, i5, 0, this.H.c(), 1);
                }
                if (iF == 0) {
                    this.j = false;
                    return 0;
                }
                Log.e("AliYunLog", "do start preview failed, return error " + iF);
                return iF;
            } catch (RuntimeException e2) {
                Log.e(Q, "Camera open exception " + e2.toString());
                return 1073754176;
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(float f, float f2) {
        String str = Q;
        Log.d(str, "manualFocus camera = " + this.l + ", focusing = " + this.j);
        synchronized (this.C) {
            if (this.l != null && !this.j) {
                Log.d(str, "manualFocus called");
                if (this.B == 3) {
                    Log.e("AliYunLog", "Camera has already been released!");
                    return;
                }
                b("manualFocus");
                float[] fArr = {f * this.d, f2 * this.e};
                this.A.mapPoints(fArr);
                float f3 = fArr[0];
                int i = (int) (f3 - 100.0f);
                int i2 = (int) (f3 + 100.0f);
                float f4 = fArr[1];
                int i3 = (int) (f4 - 100.0f);
                int i4 = (int) (f4 + 100.0f);
                if (i < -1000) {
                    i2 = -800;
                    i = -1000;
                } else if (i2 > 1000) {
                    i = 800;
                    i2 = 1000;
                }
                if (i3 < -1000) {
                    i4 = -800;
                    i3 = -1000;
                } else if (i4 > 1000) {
                    i3 = 800;
                    i4 = 1000;
                }
                Rect rect = new Rect(i, i3, i2, i4);
                Rect rect2 = new Rect(i, i3, i2, i4);
                Log.d("CAMERA_FOCUS", "focus area : left" + rect.left + " top " + rect.top + " right " + rect.right + " bottom " + rect.bottom);
                Camera.Parameters parametersH = h();
                if (parametersH == null || parametersH.getFocusMode() == null || (!(parametersH.getFocusMode().contains("auto") || parametersH.getFocusMode().contains("continuous-video") || parametersH.getFocusMode().contains("continuous-picture") || parametersH.getFocusMode().contains("fixed")) || (parametersH.getMaxNumFocusAreas() < 1 && parametersH.getMaxNumMeteringAreas() < 1))) {
                    Log.d("CAMERA_FOCUS", "focus mode not support");
                } else {
                    if (parametersH.getMaxNumFocusAreas() > 0) {
                        parametersH.setFocusAreas((rect.width() <= 0 || rect.height() <= 0) ? null : Arrays.asList(new Camera.Area(rect, 1000)));
                    }
                    if (parametersH.getMaxNumMeteringAreas() > 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new Camera.Area(rect2, 1000));
                        parametersH.setMeteringAreas(arrayList);
                    } else {
                        Log.i(str, "metering areas not supported");
                    }
                    if (parametersH.isAutoExposureLockSupported()) {
                        parametersH.setAutoExposureLock(true);
                    }
                    if (parametersH.isAutoWhiteBalanceLockSupported()) {
                        parametersH.setAutoWhiteBalanceLock(true);
                    }
                    try {
                        this.l.setParameters(parametersH);
                        this.j = true;
                        this.l.autoFocus(new e());
                        Handler handler = this.O;
                        if (handler != null) {
                            handler.removeCallbacks(this.P, null);
                            this.O.postDelayed(this.P, com.igexin.push.config.c.j);
                        }
                    } catch (Exception e2) {
                        this.j = false;
                        b("try exception");
                        Log.e("AliYunLog", "Auto focus failed! " + e2.toString());
                    }
                }
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(int i) {
        this.m = i;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(Point point) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.a.a aVar) {
        this.q = aVar;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.a.b bVar) {
        this.H.a(new d(bVar));
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.a.c cVar) {
        synchronized (this.C) {
            if (this.B == 2 && this.l != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = jCurrentTimeMillis - this.N;
                com.aliyun.common.c.a.a.a("AliYunLog", "takePhoto: isTakingPicture=" + this.z + ", interval=" + j);
                if (!this.z || j >= 2000) {
                    this.N = jCurrentTimeMillis;
                    this.z = true;
                    try {
                        this.l.setParameters(this.i);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.l.takePicture(this.x ? new b(this, cVar) : null, null, new c(System.currentTimeMillis(), cVar));
                }
                return;
            }
            Log.e("AliYunLog", "Camera has been already released!");
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(OnChoosePictureSizeCallback onChoosePictureSizeCallback) {
        this.r = onChoosePictureSizeCallback;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public synchronized void a(boolean z) {
        if (this.G == 0) {
            this.F = z;
            this.H.a(this.I, this.d, this.e);
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public boolean a(String str) {
        synchronized (this.C) {
            boolean z = true;
            if (this.l == null) {
                this.f = str;
                return true;
            }
            Camera.Parameters parameters = this.i;
            if (parameters == null) {
                return false;
            }
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            if (supportedFlashModes == null) {
                return false;
            }
            if (supportedFlashModes.contains(str)) {
                this.i.setFlashMode(str);
                try {
                    this.l.setParameters(this.i);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    z = false;
                }
            } else {
                z = false;
            }
            return z;
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public boolean b() {
        return this.B == 2;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public Camera.CameraInfo c() {
        return this.k;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0027 A[Catch: all -> 0x008a, Exception -> 0x008c, TryCatch #0 {Exception -> 0x008c, blocks: (B:17:0x0023, B:19:0x0027, B:21:0x0040), top: B:37:0x0023, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0040 A[Catch: all -> 0x008a, Exception -> 0x008c, TRY_LEAVE, TryCatch #0 {Exception -> 0x008c, blocks: (B:17:0x0023, B:19:0x0027, B:21:0x0040), top: B:37:0x0023, outer: #2 }] */
    @Override // com.aliyun.svideosdk.preview.camera.f
    public void d() {
        Camera camera;
        synchronized (this.C) {
            try {
                Handler handler = this.O;
                if (handler != null) {
                    handler.removeCallbacks(this.P, null);
                }
                Camera camera2 = this.l;
                if (camera2 != null) {
                    camera2.cancelAutoFocus();
                    try {
                        try {
                            camera = this.l;
                            if (camera != null) {
                                camera.setPreviewCallbackWithBuffer(null);
                                this.l.setZoomChangeListener(null);
                                g();
                                this.l.lock();
                                this.l.release();
                                if (this.K != null) {
                                    this.H.l();
                                    com.aliyun.svideosdk.a.d.a aVarI = this.H.i();
                                    this.H.f();
                                    com.aliyun.svideosdk.a.d.a aVarG = this.H.g();
                                    com.aliyun.svideosdk.a.d.a aVarK = this.H.k();
                                    this.K.a(aVarI.g(), aVarI.e(), aVarI.d(), aVarI.h(), aVarG.d(), aVarG.h(), aVarK.d(), aVarK.h(), aVarI.i());
                                }
                            }
                            this.l = null;
                        } catch (Exception e2) {
                            Log.e("AliYunLog", "close mCamera failed !", e2);
                            this.l = null;
                        }
                        this.B = 3;
                        this.i = null;
                        this.E.clear();
                    } catch (Throwable th) {
                        this.l = null;
                        this.B = 3;
                        this.i = null;
                        throw th;
                    }
                } else {
                    camera = this.l;
                    if (camera != null) {
                        camera.setPreviewCallbackWithBuffer(null);
                        this.l.setZoomChangeListener(null);
                        g();
                        this.l.lock();
                        this.l.release();
                        if (this.K != null) {
                            this.H.l();
                            com.aliyun.svideosdk.a.d.a aVarI2 = this.H.i();
                            this.H.f();
                            com.aliyun.svideosdk.a.d.a aVarG2 = this.H.g();
                            com.aliyun.svideosdk.a.d.a aVarK2 = this.H.k();
                            this.K.a(aVarI2.g(), aVarI2.e(), aVarI2.d(), aVarI2.h(), aVarG2.d(), aVarG2.h(), aVarK2.d(), aVarK2.h(), aVarI2.i());
                        }
                    }
                    this.l = null;
                    this.B = 3;
                    this.i = null;
                    this.E.clear();
                }
            } catch (Exception e3) {
                Log.e("AliYunLog", "close mCamera failed !", e3);
            }
            throw th;
        }
    }

    public void g() {
        synchronized (this.C) {
            Handler handler = this.O;
            if (handler != null) {
                handler.removeCallbacks(this.P, null);
            }
            if (this.B == 2) {
                Camera camera = this.l;
                if (camera != null) {
                    camera.stopPreview();
                }
                this.B = 1;
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public synchronized int getCameraCount() {
        return Camera.getNumberOfCameras();
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public float getCurrentExposureCompensationRatio() {
        synchronized (this.C) {
            Camera.Parameters parameters = this.i;
            if (parameters == null) {
                return 0.0f;
            }
            return (parameters.getExposureCompensation() - this.i.getMinExposureCompensation()) / (this.i.getMaxExposureCompensation() - this.i.getMinExposureCompensation());
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public List<Camera.Size> getSupportedPictureSize() {
        synchronized (this.C) {
            if (this.B != 3) {
                Camera.Parameters parametersH = h();
                if (this.l != null && parametersH != null) {
                    return parametersH.getSupportedPictureSizes();
                }
            }
            return null;
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public SortedSet<Size> getSupportedPictureSizes() {
        synchronized (this.C) {
            if (this.B == 3 || !this.J.b().contains(this.u)) {
                return null;
            }
            return this.J.b(this.u);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.F) {
            this.H.a(true, this.I, this.d, this.e);
            return;
        }
        synchronized (this.M) {
            this.L = true;
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        OnFrameCallback onFrameCallback = this.p;
        if (onFrameCallback != null) {
            onFrameCallback.onFrameBack(bArr, this.d, this.e, this.k);
        }
        com.aliyun.svideosdk.a.a aVar = this.q;
        if (aVar != null) {
            aVar.onFrameBack(bArr, this.d, this.e, this.k);
        }
        if (camera != null) {
            camera.addCallbackBuffer(bArr);
        }
        if (this.F || this.B != 2) {
            return;
        }
        synchronized (this.M) {
            if (this.L) {
                this.L = false;
                this.H.a(this.I, this.d, this.e);
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int release() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setCameraCaptureDataMode(int i) {
        this.G = i;
        if (1 == i) {
            this.F = false;
        } else if (2 == i) {
            this.F = true;
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setCameraParam(CameraParam cameraParam) {
        if (cameraParam == null) {
            return;
        }
        synchronized (this.C) {
            if (this.l == null) {
                this.o = cameraParam;
            } else {
                if (this.i == null) {
                    this.i = h();
                }
                if (this.i != null) {
                    setExposureCompensationRatio(cameraParam.getExposureCompensationRatio());
                    this.i.setZoom((int) (this.i.getMaxZoom() * cameraParam.getZoomRatio()));
                    int focusMode = cameraParam.getFocusMode();
                    String str = "";
                    if (focusMode == 1) {
                        str = "auto";
                    } else if (focusMode == 0) {
                        str = "continuous-video";
                    }
                    if (this.i.getSupportedFocusModes().contains(str)) {
                        this.i.setFocusMode(str);
                    }
                    String flashType = cameraParam.getFlashType();
                    List<String> supportedFlashModes = this.i.getSupportedFlashModes();
                    if (supportedFlashModes != null && supportedFlashModes.contains(flashType)) {
                        this.i.setFlashMode(flashType);
                    }
                    try {
                        this.l.setParameters(this.i);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public synchronized int setExposureCompensationRatio(float f) {
        synchronized (this.C) {
            try {
                if (this.l == null) {
                    this.h = Float.valueOf(f);
                    Log.e("AliYunLog", "mCamera is null");
                    return -20005007;
                }
                int maxExposureCompensation = this.i.getMaxExposureCompensation();
                int minExposureCompensation = this.i.getMinExposureCompensation();
                if (maxExposureCompensation == 0 && minExposureCompensation == 0) {
                    Log.e("AliYunLog", "exposure compensation is not supported");
                    return -20003002;
                }
                this.i.setExposureCompensation((int) (minExposureCompensation + ((maxExposureCompensation - minExposureCompensation) * f)));
                this.l.setParameters(this.i);
                return 0;
            } catch (Exception e2) {
                Log.e("AliYunLog", "setExposureCompensationRatio failed !", e2);
                return -20005006;
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setFocusMode(int i) {
        synchronized (this.C) {
            if (this.l == null) {
                this.g = Integer.valueOf(i);
                return;
            }
            if (this.B == 3) {
                Log.e("AliYunLog", "Camera has already been released!");
                return;
            }
            String str = "";
            if (i == 1) {
                str = "auto";
            } else if (i == 0) {
                str = "continuous-video";
            }
            List<String> supportedFocusModes = this.i.getSupportedFocusModes();
            if (!str.isEmpty() && supportedFocusModes.contains(str)) {
                this.i.setFocusMode(str);
                try {
                    this.l.setParameters(this.i);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return;
            }
            Log.e("AliYunLog", "focus mode is invalid " + i);
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setOnFrameCallback(OnFrameCallback onFrameCallback) {
        this.p = onFrameCallback;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int setPictureSize(int i, int i2) {
        boolean z;
        Log.d("AliYunLog", "setPictureSize: width = " + i + ", height = " + i2);
        List<Camera.Size> supportedPictureSize = getSupportedPictureSize();
        if (supportedPictureSize == null) {
            Log.e("AliYunLog", "supportedSizeList is null");
            return -1;
        }
        com.aliyun.common.c.b.e eVar = this.K;
        if (eVar != null) {
            eVar.a(i, i2, supportedPictureSize);
        }
        Iterator<Camera.Size> it = supportedPictureSize.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            Camera.Size next = it.next();
            if (next.width == i && next.height == i2) {
                z = false;
                break;
            }
        }
        if (z) {
            Log.e("AliYunLog", "pictureSize is invalid");
            return -20003015;
        }
        synchronized (this.C) {
            Camera.Parameters parameters = this.i;
            if (parameters != null) {
                parameters.setPictureSize(i, i2);
            }
            try {
                this.l.setParameters(this.i);
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setRotation(int i) {
        this.f25816a = i;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setShutterSound(boolean z) {
        this.x = z;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setTakePicturePreview(boolean z) {
        this.y = z;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public synchronized int setZoom(float f) {
        synchronized (this.C) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < 0.0f) {
                f = 0.0f;
            }
            this.c = f;
            if (this.l == null) {
                return -20005007;
            }
            try {
                this.i.setZoom((int) (this.i.getMaxZoom() * f));
                this.l.setParameters(this.i);
                return 0;
            } catch (Exception e2) {
                Log.e("AliYunLog", "setZoom failed !", e2);
                return -20005006;
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int startPreviewAfterTakePicture() {
        int i;
        synchronized (this.C) {
            if (this.B != 3) {
                try {
                    Camera camera = this.l;
                    if (camera != null) {
                        camera.startPreview();
                        i = 0;
                    } else {
                        Log.e("AliYunLog", "startPreviewAfterTakePicture, mCamera is null");
                        i = -20003002;
                    }
                } catch (RuntimeException e2) {
                    Log.e("AliYunLog", "Start Preview failed " + e2.getMessage());
                    OnFrameCallback onFrameCallback = this.p;
                    if (onFrameCallback != null) {
                        onFrameCallback.openFailed();
                    }
                    return -20005001;
                }
            } else {
                i = 0;
            }
        }
        return i;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public synchronized int switchCamera() {
        if (this.v == 0) {
            this.v = 1;
        } else {
            this.v = 0;
        }
        d();
        if (a(this.s, this.t, this.v) != 0) {
            Log.e("AliYunLog", "switchCamera failed, mCameraId = " + this.v);
        }
        return this.v;
    }
}
