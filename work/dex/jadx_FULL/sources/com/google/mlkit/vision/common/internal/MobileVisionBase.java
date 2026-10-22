package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleObserver;
import androidx.p002lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.zj.adlib.eq1;
import com.zj.adlib.ndd;
import com.zj.adlib.su3;
import com.zj.adlib.yd1;
import com.zj.adlib.yw6;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class MobileVisionBase<DetectionResultT> implements Closeable, LifecycleObserver {
    public static final /* synthetic */ int K = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su3 f32487a = new su3("MobileVisionBase", "");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Task f6709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MLTask f6710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final yd1 f6711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f6712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicBoolean f6713a = new AtomicBoolean(false);

    @KeepForSdk
    public MobileVisionBase(@NonNull MLTask<DetectionResultT, InputImage> mLTask, @NonNull Executor executor) {
        this.f6710a = mLTask;
        yd1 yd1Var = new yd1();
        this.f6711a = yd1Var;
        this.f6712a = executor;
        mLTask.d();
        this.f6709a = mLTask.a(executor, new Callable() { // from class: com.zj.adlib.gbc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int i = MobileVisionBase.K;
                return null;
            }
        }, yd1Var.b()).h(new OnFailureListener() { // from class: com.zj.adlib.lec
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                MobileVisionBase.f32487a.f("MobileVisionBase", "Error preloading model resource", exc);
            }
        });
    }

    @NonNull
    @KeepForSdk
    public Task<DetectionResultT> P(@NonNull ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        return l(InputImage.c(byteBuffer, i, i2, i3, i4));
    }

    @NonNull
    @KeepForSdk
    public Task<DetectionResultT> Q(@NonNull Bitmap bitmap, int i) {
        return l(InputImage.a(bitmap, i));
    }

    @NonNull
    @KeepForSdk
    public Task<DetectionResultT> U(@NonNull Image image, int i, @NonNull Matrix matrix) {
        return l(InputImage.f(image, i, matrix));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.google.mlkit.vision.barcode.BarcodeScanner
    @KeepForSdk
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (this.f6713a.getAndSet(true)) {
            return;
        }
        this.f6711a.a();
        this.f6710a.e(this.f6712a);
    }

    @NonNull
    @KeepForSdk
    public Task<DetectionResultT> g0(@NonNull Image image, int i) {
        return l(InputImage.e(image, i));
    }

    @NonNull
    @KeepForSdk
    public synchronized Task<Void> h() {
        if (this.f6713a.getAndSet(true)) {
            return a.e(null);
        }
        this.f6711a.a();
        return this.f6710a.f(this.f6712a);
    }

    @NonNull
    @KeepForSdk
    public synchronized Task<Void> j() {
        return this.f6709a;
    }

    @NonNull
    @KeepForSdk
    public synchronized Task<DetectionResultT> k(@NonNull final MlImage mlImage) {
        yw6.m(mlImage, "MlImage can not be null");
        if (this.f6713a.get()) {
            return a.d(new MlKitException("This detector is already closed!", 14));
        }
        if (mlImage.getWidth() < 32 || mlImage.getHeight() < 32) {
            return a.d(new MlKitException("MlImage width and height should be at least 32!", 3));
        }
        mlImage.h().a();
        return this.f6710a.a(this.f6712a, new Callable() { // from class: com.zj.adlib.qhc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f19108a.p(mlImage);
            }
        }, this.f6711a.b()).e(new OnCompleteListener() { // from class: com.zj.adlib.ukc
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                MlImage mlImage2 = mlImage;
                int i = MobileVisionBase.K;
                mlImage2.close();
            }
        });
    }

    @NonNull
    @KeepForSdk
    public synchronized Task<DetectionResultT> l(@NonNull final InputImage inputImage) {
        yw6.m(inputImage, "InputImage can not be null");
        if (this.f6713a.get()) {
            return a.d(new MlKitException("This detector is already closed!", 14));
        }
        if (inputImage.o() < 32 || inputImage.k() < 32) {
            return a.d(new MlKitException("InputImage width and height should be at least 32!", 3));
        }
        return this.f6710a.a(this.f6712a, new Callable() { // from class: com.zj.adlib.z6c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f20992a.m(inputImage);
            }
        }, this.f6711a.b());
    }

    public final /* synthetic */ Object m(InputImage inputImage) throws Exception {
        ndd nddVarL = ndd.l("detectorTaskWithResource#run");
        nddVarL.h();
        try {
            Object objI = this.f6710a.i(inputImage);
            nddVarL.close();
            return objI;
        } catch (Throwable th) {
            try {
                nddVarL.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }

    public final /* synthetic */ Object p(MlImage mlImage) throws Exception {
        InputImage inputImageA = eq1.a(mlImage);
        if (inputImageA != null) {
            return this.f6710a.i(inputImageA);
        }
        throw new MlKitException("Current type of MlImage is not supported.", 13);
    }
}
