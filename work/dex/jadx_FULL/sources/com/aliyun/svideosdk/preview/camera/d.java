package com.aliyun.svideosdk.preview.camera;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import com.aliyun.common.utils.Size;
import com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback;
import com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback;
import com.aliyun.svideosdk.common.struct.recorder.CameraParam;
import com.aliyun.svideosdk.common.struct.recorder.FlashType;
import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.aliyun.svideosdk.a.e.a f25831a;
    private f b;
    private int c;
    private int d;
    private int e;
    private int f;
    private HandlerThread g;
    private Handler h;
    private int i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f25832a;

        public a(CountDownLatch countDownLatch) {
            this.f25832a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.i = dVar.b.a(d.this.d, d.this.e, d.this.c);
            this.f25832a.countDown();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f25833a;

        public b(CountDownLatch countDownLatch) {
            this.f25833a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.c = dVar.b.switchCamera();
            this.f25833a.countDown();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f25834a;

        public c(CountDownLatch countDownLatch) {
            this.f25834a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b.d();
            this.f25834a.countDown();
        }
    }

    /* JADX INFO: renamed from: com.aliyun.svideosdk.preview.camera.d$d, reason: collision with other inner class name */
    public static /* synthetic */ class C0239d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25835a;

        static {
            int[] iArr = new int[FlashType.values().length];
            f25835a = iArr;
            try {
                iArr[FlashType.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25835a[FlashType.ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25835a[FlashType.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25835a[FlashType.TORCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public d(Context context, com.aliyun.svideosdk.a.e.a aVar, com.aliyun.common.c.b.e eVar, com.aliyun.svideosdk.a.f.a aVar2) {
        this.b = null;
        this.f25831a = aVar;
        this.b = com.aliyun.svideosdk.preview.camera.c.a(context, aVar, eVar, aVar2);
        HandlerThread handlerThread = new HandlerThread("camera-ctrl");
        this.g = handlerThread;
        handlerThread.start();
        this.h = new Handler(this.g.getLooper());
    }

    private FlashType d() {
        FlashType flashType = FlashType.OFF;
        int i = this.f;
        if (i == 0) {
            return flashType;
        }
        if (i == 1) {
            return FlashType.AUTO;
        }
        if (i == 2) {
            return FlashType.ON;
        }
        if (i == 3) {
            return FlashType.TORCH;
        }
        com.aliyun.common.c.a.a.b("AliYunLog", "Invalid flash type:" + flashType.toString());
        return null;
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int a() {
        return this.b.a();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int a(int i, int i2) {
        this.d = i;
        this.e = i2;
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void a(int i) {
        this.b.a(i);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void a(com.aliyun.svideosdk.a.a aVar) {
        this.b.a(aVar);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void a(com.aliyun.svideosdk.a.b bVar) {
        this.b.a(bVar);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void a(com.aliyun.svideosdk.a.c cVar) {
        this.b.a(cVar);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void a(boolean z) {
        this.b.a(z);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b A[PHI: r2
      0x001b: PHI (r2v1 int) = (r2v0 int), (r2v3 int), (r2v4 int) binds: [B:3:0x000b, B:5:0x000e, B:8:0x0013] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.aliyun.svideosdk.preview.camera.g
    public boolean a(FlashType flashType) {
        int i = C0239d.f25835a[flashType.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i == 3) {
                    this.f = 0;
                } else if (i != 4) {
                    this.f = 4;
                } else {
                    this.f = i2;
                }
            } else {
                this.f = i2;
            }
        } else {
            this.f = i2;
        }
        if (this.f != 4) {
            return this.b.a(flashType.toString());
        }
        com.aliyun.common.c.a.a.b("AliYunLog", "Invalid flash mode: " + flashType.toString());
        return false;
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void b(int i) {
        this.c = i;
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public boolean b() {
        return this.b.b();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public Camera.CameraInfo c() {
        return this.b.c();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int getCameraCount() {
        return this.b.getCameraCount();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public float getCurrentExposureCompensationRatio() {
        return this.b.getCurrentExposureCompensationRatio();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public List<Camera.Size> getSupportedPictureSize() {
        return this.b.getSupportedPictureSize();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public SortedSet<Size> getSupportedPictureSizes() {
        return this.b.getSupportedPictureSizes();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void release() {
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.h = null;
        }
        HandlerThread handlerThread = this.g;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.g = null;
        }
        f fVar = this.b;
        if (fVar != null) {
            fVar.release();
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setCameraCaptureDataMode(int i) {
        this.b.setCameraCaptureDataMode(i);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setCameraParam(CameraParam cameraParam) {
        this.b.setCameraParam(cameraParam);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int setExposureCompensationRatio(float f) {
        return this.b.setExposureCompensationRatio(f);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setFocus(float f, float f2) {
        float[] fArr = {f, f2};
        this.f25831a.a(fArr);
        this.b.a(fArr[0], fArr[1]);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setFocus(Point point) {
        this.b.a(point);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setFocusMode(int i) {
        this.b.setFocusMode(i);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setOnChoosePictureSizeCallBack(OnChoosePictureSizeCallback onChoosePictureSizeCallback) {
        this.b.a(onChoosePictureSizeCallback);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setOnFrameCallback(OnFrameCallback onFrameCallback) {
        this.b.setOnFrameCallback(onFrameCallback);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int setPictureSize(int i, int i2) {
        return this.b.setPictureSize(i, i2);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setRotation(int i) {
        this.b.setRotation(i);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setShutterSound(boolean z) {
        this.b.setShutterSound(z);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setTakePicturePreview(boolean z) {
        this.b.setTakePicturePreview(z);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int setZoom(float f) {
        return this.b.setZoom(f);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int startPreview() {
        com.aliyun.common.c.a.a.a("AliYunLog", "AliyunCamera call startPreview");
        if (this.h == null) {
            com.aliyun.common.c.a.a.a("AliYunLog", "AliyunCamera call startPreview hander is null");
            int iA = this.b.a(this.d, this.e, this.c);
            this.i = iA;
            return iA;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.h.post(new a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.i;
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int startPreviewAfterTakePicture() {
        return this.b.startPreviewAfterTakePicture();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void stopPreview() {
        com.aliyun.common.c.a.a.a("AliYunLog", "AliyunCamera call stopPreview");
        if (this.h == null) {
            com.aliyun.common.c.a.a.a("AliYunLog", "AliyunCamera call stopPreview handler is null");
            this.b.d();
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.h.post(new c(countDownLatch));
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int switchCamera() {
        if (this.h == null) {
            com.aliyun.common.c.a.a.a("AliYunLog", "AliyunCamera call switchCamera hander is null");
            int iSwitchCamera = this.b.switchCamera();
            this.c = iSwitchCamera;
            return iSwitchCamera;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.h.post(new b(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.c;
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public FlashType switchLight() {
        int i = this.f;
        this.f = i >= 3 ? 0 : i + 1;
        FlashType flashTypeD = d();
        if (a(flashTypeD)) {
            return flashTypeD;
        }
        this.f--;
        return d();
    }
}
