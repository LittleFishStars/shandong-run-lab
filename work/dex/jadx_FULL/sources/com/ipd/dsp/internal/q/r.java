package com.ipd.dsp.internal.q;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.components.glide.load.ImageHeaderParser;
import com.ipd.dsp.internal.components.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class r {
    public static final String f = "Downsampler";
    public static final com.ipd.dsp.internal.f.h<com.ipd.dsp.internal.f.b> g = com.ipd.dsp.internal.f.h.a("com.ipd.dsp.internal.components.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.ipd.dsp.internal.f.b.h);
    public static final com.ipd.dsp.internal.f.h<com.ipd.dsp.internal.f.j> h = com.ipd.dsp.internal.f.h.a("com.ipd.dsp.internal.components.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    @Deprecated
    public static final com.ipd.dsp.internal.f.h<q> i = q.h;
    public static final com.ipd.dsp.internal.f.h<Boolean> j;
    public static final com.ipd.dsp.internal.f.h<Boolean> k;
    public static final String l = "image/vnd.wap.wbmp";
    public static final String m = "image/x-ico";
    public static final Set<String> n;
    public static final b o;
    public static final Set<ImageHeaderParser.ImageType> p;
    public static final Queue<BitmapFactory.Options> q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.j.e f38513a;
    public final DisplayMetrics b;
    public final com.ipd.dsp.internal.j.b c;
    public final List<ImageHeaderParser> d;
    public final z e = z.c();

    public class a implements b {
        @Override // com.ipd.dsp.internal.q.r.b
        public void a() {
        }

        @Override // com.ipd.dsp.internal.q.r.b
        public void a(com.ipd.dsp.internal.j.e eVar, Bitmap bitmap) {
        }
    }

    public interface b {
        void a();

        void a(com.ipd.dsp.internal.j.e eVar, Bitmap bitmap) throws IOException;
    }

    static {
        Boolean bool = Boolean.FALSE;
        j = com.ipd.dsp.internal.f.h.a("com.ipd.dsp.internal.components.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        k = com.ipd.dsp.internal.f.h.a("com.ipd.dsp.internal.components.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        n = Collections.unmodifiableSet(new HashSet(Arrays.asList(l, m)));
        o = new a();
        p = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        q = com.ipd.dsp.internal.d0.o.a(0);
    }

    public r(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.ipd.dsp.internal.j.e eVar, com.ipd.dsp.internal.j.b bVar) {
        this.d = list;
        this.b = (DisplayMetrics) com.ipd.dsp.internal.d0.m.a(displayMetrics);
        this.f38513a = (com.ipd.dsp.internal.j.e) com.ipd.dsp.internal.d0.m.a(eVar);
        this.c = (com.ipd.dsp.internal.j.b) com.ipd.dsp.internal.d0.m.a(bVar);
    }

    public static boolean a(int i2) {
        return i2 == 90 || i2 == 270;
    }

    public static int b(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    public static int c(double d) {
        return (int) (d + 0.5d);
    }

    public static void c(BitmapFactory.Options options) {
        d(options);
        Queue<BitmapFactory.Options> queue = q;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    public static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.a();
    }

    public final boolean a(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }

    public static int[] b(a0 a0Var, BitmapFactory.Options options, b bVar, com.ipd.dsp.internal.j.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        a(a0Var, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public com.ipd.dsp.internal.i.v<Bitmap> a(InputStream inputStream, int i2, int i3, com.ipd.dsp.internal.f.i iVar) throws IOException {
        return a(inputStream, i2, i3, iVar, o);
    }

    public com.ipd.dsp.internal.i.v<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, com.ipd.dsp.internal.f.i iVar) throws IOException {
        return a(new a0.b(byteBuffer, this.d, this.c), i2, i3, iVar, o);
    }

    public com.ipd.dsp.internal.i.v<Bitmap> a(InputStream inputStream, int i2, int i3, com.ipd.dsp.internal.f.i iVar, b bVar) throws IOException {
        return a(new a0.d(inputStream, this.d, this.c), i2, i3, iVar, bVar);
    }

    @VisibleForTesting
    public void a(byte[] bArr, int i2, int i3, com.ipd.dsp.internal.f.i iVar) throws IOException {
        a(new a0.a(bArr, this.d, this.c), i2, i3, iVar, o);
    }

    public static boolean b(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    @VisibleForTesting
    public void a(File file, int i2, int i3, com.ipd.dsp.internal.f.i iVar) throws IOException {
        a(new a0.c(file, this.d, this.c), i2, i3, iVar, o);
    }

    public com.ipd.dsp.internal.i.v<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, com.ipd.dsp.internal.f.i iVar) throws IOException {
        return a(new a0.e(parcelFileDescriptor, this.d, this.c), i2, i3, iVar, o);
    }

    public final com.ipd.dsp.internal.i.v<Bitmap> a(a0 a0Var, int i2, int i3, com.ipd.dsp.internal.f.i iVar, b bVar) throws IOException {
        byte[] bArr = (byte[]) this.c.b(65536, byte[].class);
        BitmapFactory.Options optionsA = a();
        optionsA.inTempStorage = bArr;
        com.ipd.dsp.internal.f.b bVar2 = (com.ipd.dsp.internal.f.b) iVar.a(g);
        com.ipd.dsp.internal.f.j jVar = (com.ipd.dsp.internal.f.j) iVar.a(h);
        q qVar = (q) iVar.a(q.h);
        Boolean bool = Boolean.TRUE;
        boolean zEquals = bool.equals(iVar.a(j));
        com.ipd.dsp.internal.f.h<Boolean> hVar = k;
        try {
            return g.a(a(a0Var, optionsA, qVar, bVar2, jVar, iVar.a(hVar) != null && bool.equals(iVar.a(hVar)), i2, i3, zEquals, bVar), this.f38513a);
        } finally {
            c(optionsA);
            this.c.put(bArr);
        }
    }

    public final Bitmap a(a0 a0Var, BitmapFactory.Options options, q qVar, com.ipd.dsp.internal.f.b bVar, com.ipd.dsp.internal.f.j jVar, boolean z, int i2, int i3, boolean z2, b bVar2) throws IOException {
        int i4;
        int i5;
        int i6;
        ColorSpace colorSpace;
        int iRound;
        int iRound2;
        long jA = com.ipd.dsp.internal.d0.i.a();
        int[] iArrB = b(a0Var, options, bVar2, this.f38513a);
        int i7 = iArrB[0];
        int i8 = iArrB[1];
        String str = options.outMimeType;
        boolean z3 = (i7 == -1 || i8 == -1) ? false : z;
        int iB = a0Var.b();
        int iA = j0.a(iB);
        boolean zB = j0.b(iB);
        if (i2 == Integer.MIN_VALUE) {
            i4 = i3;
            i5 = a(iA) ? i8 : i7;
        } else {
            i4 = i3;
            i5 = i2;
        }
        if (i4 == Integer.MIN_VALUE) {
            i6 = a(iA) ? i7 : i8;
        } else {
            i6 = i4;
        }
        ImageHeaderParser.ImageType imageTypeC = a0Var.c();
        a(imageTypeC, a0Var, bVar2, this.f38513a, qVar, iA, i7, i8, i5, i6, options);
        a(a0Var, bVar, z3, zB, options, i5, i6);
        if (a(imageTypeC)) {
            if (i7 < 0 || i8 < 0 || !z2) {
                float f2 = b(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i9 = options.inSampleSize;
                float f3 = i7;
                float f4 = i9;
                int iCeil = (int) Math.ceil(f3 / f4);
                int iCeil2 = (int) Math.ceil(i8 / f4);
                iRound = Math.round(iCeil * f2);
                iRound2 = Math.round(iCeil2 * f2);
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.e(f, "Calculated target [" + iRound + "x" + iRound2 + "] for source [" + i7 + "x" + i8 + "], sampleSize: " + i9 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                }
            } else {
                iRound = i5;
                iRound2 = i6;
            }
            if (iRound > 0 && iRound2 > 0) {
                a(options, this.f38513a, iRound, iRound2);
            }
        }
        if (jVar != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                options.inPreferredColorSpace = ColorSpace.get((jVar == com.ipd.dsp.internal.f.j.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
            } else {
                options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
        }
        Bitmap bitmapA = a(a0Var, options, bVar2, this.f38513a);
        bVar2.a(this.f38513a, bitmapA);
        if (Dsp.isDebugLogEnable()) {
            a(i7, i8, str, options, bitmapA, i2, i3, jA);
        }
        if (bitmapA == null) {
            return null;
        }
        bitmapA.setDensity(this.b.densityDpi);
        Bitmap bitmapA2 = j0.a(this.f38513a, bitmapA, iB);
        if (!bitmapA.equals(bitmapA2)) {
            this.f38513a.a(bitmapA);
        }
        return bitmapA2;
    }

    public static void a(ImageHeaderParser.ImageType imageType, a0 a0Var, b bVar, com.ipd.dsp.internal.j.e eVar, q qVar, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int iMin;
        int iFloor;
        int iFloor2;
        if (i3 > 0 && i4 > 0) {
            if (a(i2)) {
                i8 = i3;
                i7 = i4;
            } else {
                i7 = i3;
                i8 = i4;
            }
            float fB = qVar.b(i7, i8, i5, i6);
            if (fB > 0.0f) {
                q.g gVarA = qVar.a(i7, i8, i5, i6);
                if (gVarA != null) {
                    float f2 = i7;
                    float f3 = i8;
                    int iC = i7 / c(fB * f2);
                    int iC2 = i8 / c(fB * f3);
                    q.g gVar = q.g.MEMORY;
                    if (gVarA == gVar) {
                        iMin = Math.max(iC, iC2);
                    } else {
                        iMin = Math.min(iC, iC2);
                    }
                    int iMax = Math.max(1, Integer.highestOneBit(iMin));
                    if (gVarA == gVar && iMax < 1.0f / fB) {
                        iMax <<= 1;
                    }
                    options.inSampleSize = iMax;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float fMin = Math.min(iMax, 8);
                        iFloor = (int) Math.ceil(f2 / fMin);
                        iFloor2 = (int) Math.ceil(f3 / fMin);
                        int i9 = iMax / 8;
                        if (i9 > 0) {
                            iFloor /= i9;
                            iFloor2 /= i9;
                        }
                    } else if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                        if (imageType.isWebp()) {
                            float f4 = iMax;
                            iFloor = Math.round(f2 / f4);
                            iFloor2 = Math.round(f3 / f4);
                        } else if (i7 % iMax == 0 && i8 % iMax == 0) {
                            iFloor = i7 / iMax;
                            iFloor2 = i8 / iMax;
                        } else {
                            int[] iArrB = b(a0Var, options, bVar, eVar);
                            iFloor = iArrB[0];
                            iFloor2 = iArrB[1];
                        }
                    } else {
                        float f5 = iMax;
                        iFloor = (int) Math.floor(f2 / f5);
                        iFloor2 = (int) Math.floor(f3 / f5);
                    }
                    double dB = qVar.b(iFloor, iFloor2, i5, i6);
                    options.inTargetDensity = a(dB);
                    options.inDensity = b(dB);
                    if (b(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.e(f, "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + iFloor + "x" + iFloor2 + "], exact scale factor: " + fB + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + qVar + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(f, "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
        }
    }

    public static int a(double d) {
        int iB = b(d);
        int iC = c(((double) iB) * d);
        return c((d / ((double) (iC / iB))) * ((double) iC));
    }

    public final void a(a0 a0Var, com.ipd.dsp.internal.f.b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        boolean zHasAlpha;
        if (this.e.a(i2, i3, options, z, z2)) {
            return;
        }
        if (bVar == com.ipd.dsp.internal.f.b.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = a0Var.c().hasAlpha();
        } catch (IOException e) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(f, "Cannot determine whether the image has alpha or not from header, format " + bVar, e);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(a0 a0Var, BitmapFactory.Options options, b bVar, com.ipd.dsp.internal.j.e eVar) throws IOException {
        if (!options.inJustDecodeBounds) {
            bVar.a();
            a0Var.a();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        j0.a().lock();
        try {
            try {
                Bitmap bitmapA = a0Var.a(options);
                j0.a().unlock();
                return bitmapA;
            } catch (IllegalArgumentException e) {
                IOException iOExceptionA = a(e, i2, i3, str, options);
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(f, "Failed to decode with inBitmap, trying again without Bitmap re-use", iOExceptionA);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap != null) {
                    try {
                        eVar.a(bitmap);
                        options.inBitmap = null;
                        Bitmap bitmapA2 = a(a0Var, options, bVar, eVar);
                        j0.a().unlock();
                        return bitmapA2;
                    } catch (IOException unused) {
                        throw iOExceptionA;
                    }
                }
                throw iOExceptionA;
            }
        } catch (Throwable th) {
            j0.a().unlock();
            throw th;
        }
    }

    public static void a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        com.ipd.dsp.internal.c2.k.e(f, "Decoded " + a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + a(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.ipd.dsp.internal.d0.i.a(j2));
    }

    public static String a(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    @Nullable
    public static String a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + " (" + bitmap.getAllocationByteCount() + ")";
    }

    public static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + a(options), illegalArgumentException);
    }

    @TargetApi(26)
    public static void a(BitmapFactory.Options options, com.ipd.dsp.internal.j.e eVar, int i2, int i3) {
        Bitmap.Config config = options.inPreferredConfig;
        if (config == Bitmap.Config.HARDWARE) {
            return;
        }
        Bitmap.Config config2 = options.outConfig;
        if (config2 != null) {
            config = config2;
        }
        options.inBitmap = eVar.b(i2, i3, config);
    }

    public static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = q;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll != null) {
            return optionsPoll;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        d(options);
        return options;
    }
}
