package com.google.mlkit.vision.interfaces;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.p002lifecycle.LifecycleObserver;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface Detector<DetectionResultT> extends Closeable, LifecycleObserver {

    @KeepForSdk
    public static final int Z2 = 1;

    @KeepForSdk
    public static final int a3 = 2;

    @KeepForSdk
    public static final int b3 = 3;

    @KeepForSdk
    public static final int c3 = 4;

    @KeepForSdk
    public static final int d3 = 5;

    @KeepForSdk
    public static final int e3 = 6;

    @KeepForSdk
    public static final int f3 = 7;

    @KeepForSdk
    public static final int g3 = 8;

    @KeepForSdk
    public static final int h3 = 9;

    @KeepForSdk
    public static final int i3 = 10;

    @KeepForSdk
    @Retention(RetentionPolicy.CLASS)
    public @interface DetectorType {
    }

    @NonNull
    @KeepForSdk
    Task<DetectionResultT> P(@NonNull ByteBuffer byteBuffer, int i, int i2, int i4, int i5);

    @NonNull
    @KeepForSdk
    Task<DetectionResultT> Q(@NonNull Bitmap bitmap, int i);

    @NonNull
    @KeepForSdk
    Task<DetectionResultT> U(@NonNull Image image, int i, @NonNull Matrix matrix);

    @NonNull
    @KeepForSdk
    Task<DetectionResultT> g0(@NonNull Image image, int i);

    @DetectorType
    @KeepForSdk
    int t0();
}
