package com.facebook.imagepipeline.nativecode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.soloader.SoLoaderShim;
import com.zj.adlib.ax6;
import com.zj.adlib.qw0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@DoNotStrip
public class Bitmaps {
    static {
        SoLoaderShim.a("bitmaps");
    }

    public static void a(Bitmap bitmap, Bitmap bitmap2) {
        ax6.d(bitmap2.getConfig() == bitmap.getConfig());
        ax6.d(bitmap.isMutable());
        ax6.d(bitmap.getWidth() == bitmap2.getWidth());
        ax6.d(bitmap.getHeight() == bitmap2.getHeight());
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    public static ByteBuffer b(Bitmap bitmap, long j, long j2) {
        ax6.i(bitmap);
        return nativeGetByteBuffer(bitmap, j, j2);
    }

    public static void c(Bitmap bitmap) {
        ax6.i(bitmap);
        nativePinBitmap(bitmap);
    }

    @TargetApi(19)
    public static void d(Bitmap bitmap, int i, int i2, Bitmap.Config config) {
        ax6.d(bitmap.getAllocationByteCount() >= (i * i2) * qw0.c(config));
        bitmap.reconfigure(i, i2, config);
    }

    public static void e(Bitmap bitmap) {
        ax6.i(bitmap);
        nativeReleaseByteBuffer(bitmap);
    }

    @DoNotStrip
    private static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap2, int i2, int i3);

    @DoNotStrip
    private static native ByteBuffer nativeGetByteBuffer(Bitmap bitmap, long j, long j2);

    @DoNotStrip
    private static native void nativePinBitmap(Bitmap bitmap);

    @DoNotStrip
    private static native void nativeReleaseByteBuffer(Bitmap bitmap);
}
