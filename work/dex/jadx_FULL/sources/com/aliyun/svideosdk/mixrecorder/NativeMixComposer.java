package com.aliyun.svideosdk.mixrecorder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.aliyun.svideosdk.conan.DoNotProguard;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@DoNotProguard
public class NativeMixComposer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f25779a;

    public NativeMixComposer(boolean z, long j) {
        this.f25779a = 0L;
        this.f25779a = nativeCreate(z, j);
    }

    @DoNotProguard
    private native int nativeAddStream(long j, String str, int i, long j2, long j3, int i2);

    @DoNotProguard
    private native int nativeCancelMix(long j);

    @DoNotProguard
    private native int nativeConfigOutputParam(long j, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int[] iArr, int i10, int[] iArr2, int i11);

    @DoNotProguard
    private native int nativeConfigTrackBorder(long j, int i, float f, int i2, float f2);

    @DoNotProguard
    private native long nativeCreate(boolean z, long j);

    @DoNotProguard
    private native int nativeCreateTrack(long j, float f, float f2, float f3, float f4, boolean z);

    @DoNotProguard
    private native int nativePauseMix(long j);

    @DoNotProguard
    private native int nativeRelease(long j);

    @DoNotProguard
    private native int nativeResumeMix(long j);

    @DoNotProguard
    private native int nativeSetFillBackgroundBitmap(long j, Bitmap bitmap);

    @DoNotProguard
    private native int nativeSetFillBackgroundColor(long j, long j2);

    @DoNotProguard
    private native int nativeSetFillBackgroundDisplayMode(long j, int i);

    @DoNotProguard
    private native int nativeStartMix(long j, Object obj);

    public int a() {
        long j = this.f25779a;
        if (j != 0) {
            return nativeCancelMix(j);
        }
        Log.e("AliYunLog", "Invalid status for NativeMixComposer");
        return -4;
    }

    public int a(float f, float f2, float f3, float f4, boolean z) {
        long j = this.f25779a;
        if (j != 0) {
            return nativeCreateTrack(j, f, f2, f3, f4, z);
        }
        Log.e("AliYunLog", "Invalid status for NativeMixComposer");
        return -4;
    }

    public int a(int i) {
        long j = this.f25779a;
        if (j != 0) {
            return nativeSetFillBackgroundColor(j, i);
        }
        Log.e("AliYunLog", "Invalid status for NativeMixComposer");
        return -4;
    }

    public int a(int i, float f, int i2, float f2) {
        long j = this.f25779a;
        if (j != 0) {
            return nativeConfigTrackBorder(j, i, f, i2, f2);
        }
        Log.e("AliYunLog", "Invalid status for NativeMixComposer");
        return -4;
    }

    public int a(Bitmap bitmap) {
        long j = this.f25779a;
        if (j != 0) {
            return nativeSetFillBackgroundBitmap(j, bitmap);
        }
        Log.e("AliYunLog", "Invalid status for NativeMixComposer");
        return -4;
    }

    public int a(AliyunMixCallback aliyunMixCallback) {
        long j = this.f25779a;
        if (j != 0) {
            return nativeStartMix(j, aliyunMixCallback);
        }
        Log.e("AliYunLog", "Invalid status for NativeMixComposer");
        return -4;
    }

    public int a(String str) {
        if (this.f25779a == 0) {
            Log.e("AliYunLog", "Invalid status for NativeMixComposer");
            return -4;
        }
        if (new File(str).exists()) {
            return nativeSetFillBackgroundBitmap(this.f25779a, BitmapFactory.decodeFile(str));
        }
        Log.e("AliYunLog", "Video file[" + str + "] not exist!");
        return -20003002;
    }

    public int a(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int[] iArr, int i10, int[] iArr2, int i11) {
        long j = this.f25779a;
        if (j != 0) {
            return nativeConfigOutputParam(j, str, i, i2, i3, i4, i5, i6, i7, i8, i9, iArr, i10, iArr2, i11);
        }
        Log.e("AliYunLog", "Invalid status for NativeMixComposer");
        return -4;
    }

    public int a(String str, int i, long j, long j2, int i2) {
        if (this.f25779a == 0) {
            Log.e("AliYunLog", "Invalid status for NativeMixComposer");
            return -4;
        }
        if (new File(str).exists()) {
            return nativeAddStream(this.f25779a, str, i, j, j2, i2);
        }
        Log.e("AliYunLog", "Video file[" + str + "] not exist!");
        return -20003002;
    }

    public int b() {
        long j = this.f25779a;
        if (j != 0) {
            return nativePauseMix(j);
        }
        Log.e("AliYunLog", "Invalid status for NativeMixComposer");
        return -4;
    }

    public int b(int i) {
        long j = this.f25779a;
        if (j != 0) {
            return nativeSetFillBackgroundDisplayMode(j, i);
        }
        Log.e("AliYunLog", "Invalid status for NativeMixComposer");
        return -4;
    }

    public int c() {
        long j = this.f25779a;
        if (j == 0) {
            Log.e("AliYunLog", "Invalid status for NativeMixComposer");
            return -4;
        }
        int iNativeRelease = nativeRelease(j);
        this.f25779a = 0L;
        return iNativeRelease;
    }

    public int d() {
        long j = this.f25779a;
        if (j != 0) {
            return nativeResumeMix(j);
        }
        Log.e("AliYunLog", "Invalid status for NativeMixComposer");
        return -4;
    }
}
