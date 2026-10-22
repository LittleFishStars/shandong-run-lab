package com.google.android.libraries.barhopper;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.zj.adlib.dm0;
import com.zj.adlib.em0;
import com.zj.adlib.qjc;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class BarhopperV3 implements Closeable {
    public static final long b = 0;
    public static final String f = "BarhopperV3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f31507a;

    public BarhopperV3() {
        System.loadLibrary("barhopper_v3");
    }

    private native void closeNative(long j);

    private native long createNative();

    private native long createNativeWithClientOptions(byte[] bArr);

    public static dm0 q(byte[] bArr) {
        bArr.getClass();
        try {
            return dm0.u(bArr, qjc.a());
        } catch (zzeo e) {
            throw new IllegalStateException("Received unexpected BarhopperResponse buffer: {0}", e);
        }
    }

    private native byte[] recognizeBitmapNative(long j, Bitmap bitmap, RecognitionOptions recognitionOptions);

    private native byte[] recognizeBufferNative(long j, int i, int i2, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions);

    private native byte[] recognizeNative(long j, int i, int i2, byte[] bArr, RecognitionOptions recognitionOptions);

    private native byte[] recognizeStridedBufferNative(long j, int i, int i2, int i3, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions);

    private native byte[] recognizeStridedNative(long j, int i, int i2, int i3, byte[] bArr, RecognitionOptions recognitionOptions);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.f31507a;
        if (j != 0) {
            closeNative(j);
            this.f31507a = 0L;
        }
    }

    public void g() {
        if (this.f31507a != 0) {
            Log.w(f, "Native context already exists.");
            return;
        }
        long jCreateNative = createNative();
        this.f31507a = jCreateNative;
        if (jCreateNative == 0) {
            throw new IllegalStateException("Failed to create native context.");
        }
    }

    public void h(@NonNull em0 em0Var) {
        if (this.f31507a != 0) {
            Log.w(f, "Native context already exists.");
            return;
        }
        try {
            int iL = em0Var.l();
            byte[] bArr = new byte[iL];
            zzdj zzdjVarA = zzdj.a(bArr, 0, iL);
            em0Var.k(zzdjVarA);
            zzdjVarA.b();
            long jCreateNativeWithClientOptions = createNativeWithClientOptions(bArr);
            this.f31507a = jCreateNativeWithClientOptions;
            if (jCreateNativeWithClientOptions == 0) {
                throw new IllegalArgumentException("Failed to create native context with client options.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + em0Var.getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }

    @NonNull
    public dm0 j(int i, int i2, int i3, @NonNull ByteBuffer byteBuffer, @NonNull RecognitionOptions recognitionOptions) {
        long j = this.f31507a;
        if (j != 0) {
            return q(recognizeStridedBufferNative(j, i, i2, i3, byteBuffer, recognitionOptions));
        }
        throw new IllegalStateException("Native context does not exist.");
    }

    @NonNull
    public dm0 k(int i, int i2, int i3, @NonNull byte[] bArr, @NonNull RecognitionOptions recognitionOptions) {
        long j = this.f31507a;
        if (j != 0) {
            return q(recognizeStridedNative(j, i, i2, i3, bArr, recognitionOptions));
        }
        throw new IllegalStateException("Native context does not exist.");
    }

    @NonNull
    public dm0 l(int i, int i2, @NonNull ByteBuffer byteBuffer, @NonNull RecognitionOptions recognitionOptions) {
        long j = this.f31507a;
        if (j != 0) {
            return q(recognizeBufferNative(j, i, i2, byteBuffer, recognitionOptions));
        }
        throw new IllegalStateException("Native context does not exist.");
    }

    @NonNull
    public dm0 m(int i, int i2, @NonNull byte[] bArr, @NonNull RecognitionOptions recognitionOptions) {
        long j = this.f31507a;
        if (j != 0) {
            return q(recognizeNative(j, i, i2, bArr, recognitionOptions));
        }
        throw new IllegalStateException("Native context does not exist.");
    }

    @NonNull
    public dm0 p(@NonNull Bitmap bitmap, @NonNull RecognitionOptions recognitionOptions) {
        if (this.f31507a == 0) {
            throw new IllegalStateException("Native context does not exist.");
        }
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            Log.d(f, "Input bitmap config is not ARGB_8888. Converting it to ARGB_8888 from ".concat(String.valueOf(bitmap.getConfig())));
            bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, bitmap.isMutable());
        }
        return q(recognizeBitmapNative(this.f31507a, bitmap, recognitionOptions));
    }
}
