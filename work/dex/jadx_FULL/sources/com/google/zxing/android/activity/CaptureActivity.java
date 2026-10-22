package com.google.zxing.android.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.barcode.ZoomSuggestionOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.google.zxing.android.activity.CaptureActivity;
import com.zj.adlib.am0;
import com.zj.adlib.bm0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CaptureActivity extends AppCompatActivity {
    public static final String t = "CaptureActivity";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PreviewView f6718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6720a = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f32493a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageAnalysis f6717a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public am0 f6719a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageAnalysis.Analyzer f6716a = new ImageAnalysis.Analyzer() { // from class: com.zj.adlib.he1
        @Override // androidx.camera.core.ImageAnalysis.Analyzer
        public final void analyze(ImageProxy imageProxy) {
            this.f42109a.c0(imageProxy);
        }
    };

    public class a implements OnFailureListener {
        public a() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            CaptureActivity.this.f0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(List list) {
        if (list == null || list.isEmpty()) {
            f0();
        } else {
            Z(((Barcode) list.get(0)).l());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(ImageProxy imageProxy) {
        if (this.f6720a && this.f32493a == null) {
            Bitmap bitmapY = Y(imageProxy);
            this.f32493a = bitmapY;
            X(bitmapY);
        }
        imageProxy.close();
    }

    public static /* synthetic */ boolean d0(Camera camera, float f) {
        if (camera == null) {
            return false;
        }
        camera.getCameraControl().setZoomRatio(f);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void e0(ListenableFuture listenableFuture) {
        try {
            ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) listenableFuture.get();
            Preview previewBuild = new Preview.Builder().build();
            previewBuild.setSurfaceProvider(this.f6718a.getSurfaceProvider());
            ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setOutputImageFormat(1).setTargetRotation(0).build();
            this.f6717a = imageAnalysisBuild;
            imageAnalysisBuild.setAnalyzer(ContextCompat.getMainExecutor(this), this.f6716a);
            processCameraProvider.unbindAll();
            final Camera cameraBindToLifecycle = processCameraProvider.bindToLifecycle(this, CameraSelector.DEFAULT_BACK_CAMERA, this.f6717a, previewBuild);
            this.f6719a = new am0.a().c(256, new int[0]).e(new ZoomSuggestionOptions.a(new ZoomSuggestionOptions.ZoomCallback() { // from class: com.zj.adlib.ge1
                @Override // com.google.mlkit.vision.barcode.ZoomSuggestionOptions.ZoomCallback
                public final boolean a(float f) {
                    return CaptureActivity.d0(cameraBindToLifecycle, f);
                }
            }).b(cameraBindToLifecycle.getCameraInfo().getZoomState().getValue().getMaxZoomRatio()).a()).a();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public final void X(Bitmap bitmap) {
        if (bitmap == null) {
            f0();
            return;
        }
        InputImage inputImageA = InputImage.a(bitmap, 0);
        if (inputImageA == null) {
            f0();
        } else {
            am0 am0Var = this.f6719a;
            (am0Var != null ? bm0.b(am0Var) : bm0.a()).x(inputImageA).k(new OnSuccessListener() { // from class: com.zj.adlib.je1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f42567a.b0((List) obj);
                }
            }).h(new a());
        }
    }

    public final Bitmap Y(ImageProxy imageProxy) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (imageProxy == null) {
            return null;
        }
        try {
            try {
                if (imageProxy.getFormat() != 35) {
                    Log.e(t, "format is not YUV_420_888");
                    return null;
                }
                try {
                    int width = imageProxy.getWidth();
                    int height = imageProxy.getHeight();
                    ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
                    ByteBuffer buffer2 = imageProxy.getPlanes()[1].getBuffer();
                    ByteBuffer buffer3 = imageProxy.getPlanes()[2].getBuffer();
                    byte[] bArr = new byte[(int) (width * height * 1.5f)];
                    int rowStride = imageProxy.getPlanes()[0].getRowStride();
                    int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
                    int i = 0;
                    for (int i2 = 0; i2 < height; i2++) {
                        int i3 = 0;
                        while (i3 < width) {
                            bArr[i] = buffer.get((i2 * rowStride) + (i3 * pixelStride));
                            i3++;
                            i++;
                        }
                    }
                    int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
                    int pixelStride2 = imageProxy.getPlanes()[1].getPixelStride();
                    int i4 = width / 2;
                    int i5 = height / 2;
                    for (int i6 = 0; i6 < i5; i6++) {
                        for (int i7 = 0; i7 < i4; i7++) {
                            int i8 = (i6 * rowStride2) + (i7 * pixelStride2);
                            int i9 = i + 1;
                            bArr[i] = buffer3.get(i8);
                            i = i9 + 1;
                            bArr[i9] = buffer2.get(i8);
                        }
                    }
                    YuvImage yuvImage = new YuvImage(bArr, 17, width, height, null);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        yuvImage.compressToJpeg(new Rect(0, 0, width, height), 100, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, null);
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return bitmapDecodeByteArray;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (Throwable th3) {
            if (byteArrayOutputStream == null) {
                throw th3;
            }
            try {
                byteArrayOutputStream.close();
                throw th3;
            } catch (IOException e5) {
                e5.printStackTrace();
                throw th3;
            }
        }
        return null;
    }

    public void Z(String str) {
    }

    public final View a0(View view, ViewGroup.LayoutParams layoutParams) {
        this.f6718a = new PreviewView(this);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(this.f6718a, new FrameLayout.LayoutParams(-1, -1));
        this.f6718a.setScaleType(PreviewView.ScaleType.FILL_CENTER);
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            frameLayout.addView(view, layoutParams);
        }
        return frameLayout;
    }

    public final void f0() {
        Bitmap bitmap = this.f32493a;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f32493a = null;
    }

    public void g0() {
        this.f6720a = true;
        f0();
        ImageAnalysis imageAnalysis = this.f6717a;
        if (imageAnalysis != null) {
            imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(this), this.f6716a);
        }
    }

    public void h0() {
        final ListenableFuture<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(this);
        processCameraProvider.addListener(new Runnable() { // from class: com.zj.adlib.ie1
            @Override // java.lang.Runnable
            public final void run() {
                this.f17202a.e0(processCameraProvider);
            }
        }, ContextCompat.getMainExecutor(this));
    }

    public void i0() {
        this.f6720a = false;
        ImageAnalysis imageAnalysis = this.f6717a;
        if (imageAnalysis != null) {
            imageAnalysis.clearAnalyzer();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.addFlags(128);
        window.addFlags(TTAdConstant.KEY_CLICK_AREA);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        i0();
        f0();
        ImageAnalysis imageAnalysis = this.f6717a;
        if (imageAnalysis != null) {
            imageAnalysis.clearAnalyzer();
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        super.setContentView(a0(LayoutInflater.from(this).inflate(i, (ViewGroup) null, false), null));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        super.setContentView(a0(view, null));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a0(view, layoutParams));
    }
}
