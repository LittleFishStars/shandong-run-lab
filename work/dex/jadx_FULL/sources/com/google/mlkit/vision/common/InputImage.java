package com.google.mlkit.vision.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.sdkinternal.MLTaskInput;
import com.zj.adlib.cgd;
import com.zj.adlib.fbc;
import com.zj.adlib.g84;
import com.zj.adlib.igd;
import com.zj.adlib.w64;
import com.zj.adlib.yw6;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable
public class InputImage implements MLTaskInput {
    public static final int e = 17;
    public static final int f = 842094169;

    @KeepForSdk
    public static final int g = -1;
    public static final int h = 35;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public volatile Bitmap f6705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Matrix f6706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public volatile fbc f6707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public volatile ByteBuffer f6708a;
    public final int b;
    public final int c;

    @ImageFormat
    public final int d;

    @Retention(RetentionPolicy.CLASS)
    public @interface ImageFormat {
    }

    public InputImage(@NonNull Bitmap bitmap, int i) {
        this.f6705a = (Bitmap) yw6.l(bitmap);
        this.f32486a = bitmap.getWidth();
        this.b = bitmap.getHeight();
        p(i);
        this.c = i;
        this.d = -1;
        this.f6706a = null;
    }

    @NonNull
    public static InputImage a(@NonNull Bitmap bitmap, int i) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(bitmap, i);
        r(-1, 1, jElapsedRealtime, bitmap.getHeight(), bitmap.getWidth(), bitmap.getAllocationByteCount(), i);
        return inputImage;
    }

    @NonNull
    public static InputImage b(@NonNull byte[] bArr, int i, int i2, int i3, @ImageFormat int i4) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(ByteBuffer.wrap((byte[]) yw6.l(bArr)), i, i2, i3, i4);
        r(i4, 2, jElapsedRealtime, i2, i, bArr.length, i3);
        return inputImage;
    }

    @NonNull
    public static InputImage c(@NonNull ByteBuffer byteBuffer, int i, int i2, int i3, @ImageFormat int i4) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(byteBuffer, i, i2, i3, i4);
        r(i4, 3, jElapsedRealtime, i2, i, byteBuffer.limit(), i3);
        return inputImage;
    }

    @NonNull
    public static InputImage d(@NonNull Context context, @NonNull Uri uri) throws IOException {
        yw6.m(context, "Please provide a valid Context");
        yw6.m(uri, "Please provide a valid imageUri");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Bitmap bitmapF = g84.b().f(context.getContentResolver(), uri);
        InputImage inputImage = new InputImage(bitmapF, 0);
        r(-1, 4, jElapsedRealtime, bitmapF.getHeight(), bitmapF.getWidth(), bitmapF.getAllocationByteCount(), 0);
        return inputImage;
    }

    @NonNull
    public static InputImage e(@NonNull Image image, int i) {
        return q(image, i, null);
    }

    @NonNull
    @KeepForSdk
    public static InputImage f(@NonNull Image image, int i, @NonNull Matrix matrix) {
        yw6.b(image.getFormat() == 35, "Only YUV_420_888 is supported now");
        return q(image, i, matrix);
    }

    public static int p(int i) {
        boolean z = true;
        if (i != 0 && i != 90 && i != 180) {
            if (i == 270) {
                i = 270;
            } else {
                z = false;
            }
        }
        yw6.b(z, "Invalid rotation. Only 0, 90, 180, 270 are supported currently.");
        return i;
    }

    public static InputImage q(@NonNull Image image, int i, @Nullable Matrix matrix) {
        InputImage inputImage;
        int iLimit;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        yw6.m(image, "Please provide a valid image");
        p(i);
        boolean z = true;
        if (image.getFormat() != 256 && image.getFormat() != 35) {
            z = false;
        }
        yw6.b(z, "Only JPEG and YUV_420_888 are supported now");
        Image.Plane[] planes = image.getPlanes();
        if (image.getFormat() == 256) {
            iLimit = image.getPlanes()[0].getBuffer().limit();
            inputImage = new InputImage(w64.g().d(image, i), 0);
        } else {
            for (Image.Plane plane : planes) {
                if (plane.getBuffer() != null) {
                    plane.getBuffer().rewind();
                }
            }
            inputImage = new InputImage(image, image.getWidth(), image.getHeight(), i, matrix);
            iLimit = (image.getPlanes()[0].getBuffer().limit() * 3) / 2;
        }
        int i2 = iLimit;
        InputImage inputImage2 = inputImage;
        r(image.getFormat(), 5, jElapsedRealtime, image.getHeight(), image.getWidth(), i2, i);
        return inputImage2;
    }

    public static void r(int i, int i2, long j, int i3, int i4, int i5, int i6) {
        igd.a(cgd.b("vision-common"), i, i2, j, i3, i4, i5, i6);
    }

    @Nullable
    @KeepForSdk
    public Bitmap g() {
        return this.f6705a;
    }

    @Nullable
    @KeepForSdk
    public ByteBuffer h() {
        return this.f6708a;
    }

    @Nullable
    @KeepForSdk
    public Matrix i() {
        return this.f6706a;
    }

    @KeepForSdk
    @ImageFormat
    public int j() {
        return this.d;
    }

    @KeepForSdk
    public int k() {
        return this.b;
    }

    @Nullable
    @KeepForSdk
    public Image l() {
        if (this.f6707a == null) {
            return null;
        }
        return this.f6707a.a();
    }

    @Nullable
    @KeepForSdk
    public Image.Plane[] m() {
        if (this.f6707a == null) {
            return null;
        }
        return this.f6707a.b();
    }

    @KeepForSdk
    public int n() {
        return this.c;
    }

    @KeepForSdk
    public int o() {
        return this.f32486a;
    }

    public InputImage(@NonNull Image image, int i, int i2, int i3, @Nullable Matrix matrix) {
        yw6.l(image);
        this.f6707a = new fbc(image);
        this.f32486a = i;
        this.b = i2;
        p(i3);
        this.c = i3;
        this.d = 35;
        this.f6706a = matrix;
    }

    public InputImage(@NonNull ByteBuffer byteBuffer, int i, int i2, int i3, @ImageFormat int i4) {
        boolean z;
        if (i4 == 842094169) {
            z = true;
        } else if (i4 == 17) {
            i4 = 17;
            z = true;
        } else {
            z = false;
        }
        yw6.a(z);
        this.f6708a = (ByteBuffer) yw6.l(byteBuffer);
        yw6.b(byteBuffer.limit() > i * i2, "Image dimension, ByteBuffer size and format don't match. Please check if the ByteBuffer is in the decalred format.");
        byteBuffer.rewind();
        this.f32486a = i;
        this.b = i2;
        p(i3);
        this.c = i3;
        this.d = i4;
        this.f6706a = null;
    }
}
