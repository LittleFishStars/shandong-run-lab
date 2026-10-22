package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class w64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w64 f45529a = new w64();

    @NonNull
    @KeepForSdk
    public static ByteBuffer a(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return byteBuffer;
        }
        byteBuffer.rewind();
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        return ByteBuffer.wrap(bArr);
    }

    @NonNull
    @KeepForSdk
    public static w64 g() {
        return f45529a;
    }

    @NonNull
    @KeepForSdk
    public static Bitmap k(@NonNull ByteBuffer byteBuffer, int i, int i2, int i3) throws MlKitException {
        byte[] bArrN = n(l(byteBuffer, true).array(), i, i2);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrN, 0, bArrN.length);
        return m(bitmapDecodeByteArray, i3, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
    }

    @NonNull
    @KeepForSdk
    public static ByteBuffer l(@NonNull ByteBuffer byteBuffer, boolean z) {
        int i;
        byteBuffer.rewind();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit / 6;
        ByteBuffer byteBufferAllocate = z ? ByteBuffer.allocate(iLimit) : ByteBuffer.allocateDirect(iLimit);
        int i3 = 0;
        while (true) {
            i = i2 * 4;
            if (i3 >= i) {
                break;
            }
            byteBufferAllocate.put(i3, byteBuffer.get(i3));
            i3++;
        }
        for (int i4 = 0; i4 < i2 + i2; i4++) {
            byteBufferAllocate.put(i + i4, byteBuffer.get(((i4 % 2) * i2) + i + (i4 / 2)));
        }
        return byteBufferAllocate;
    }

    @NonNull
    public static Bitmap m(@NonNull Bitmap bitmap, int i, int i2, int i3) {
        if (i == 0) {
            return Bitmap.createBitmap(bitmap, 0, 0, i2, i3);
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, i2, i3, matrix, true);
    }

    public static byte[] n(@NonNull byte[] bArr, int i, int i2) throws MlKitException {
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            Log.w("ImageConvertUtils", "Error closing ByteArrayOutputStream");
            throw new MlKitException("Image conversion error from NV21 format", 13, e);
        }
    }

    public static final void o(Image.Plane plane, int i, int i2, byte[] bArr, int i3, int i4) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int iLimit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (iLimit == 0) {
            return;
        }
        int i5 = i / (i2 / iLimit);
        int rowStride = 0;
        for (int i6 = 0; i6 < iLimit; i6++) {
            int pixelStride = rowStride;
            for (int i7 = 0; i7 < i5; i7++) {
                bArr[i3] = buffer.get(pixelStride);
                i3 += i4;
                pixelStride += plane.getPixelStride();
            }
            rowStride += plane.getRowStride();
        }
    }

    @NonNull
    @KeepForSdk
    public byte[] b(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return byteBuffer.array();
        }
        byteBuffer.rewind();
        int iLimit = byteBuffer.limit();
        byte[] bArr = new byte[iLimit];
        byteBuffer.get(bArr, 0, iLimit);
        return bArr;
    }

    @NonNull
    @KeepForSdk
    public ByteBuffer c(@NonNull ByteBuffer byteBuffer) {
        yw6.l(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        ByteBuffer byteBufferAllocateDirect = byteBuffer.isDirect() ? ByteBuffer.allocateDirect(iCapacity) : ByteBuffer.allocate(iCapacity);
        byteBufferAllocateDirect.limit(byteBuffer.limit());
        byteBufferAllocateDirect.put((ByteBuffer) byteBuffer.rewind());
        byteBufferAllocateDirect.position(iPosition);
        byteBuffer.position(iPosition);
        return byteBufferAllocateDirect;
    }

    @NonNull
    @KeepForSdk
    public Bitmap d(@NonNull Image image, int i) {
        yw6.b(image.getFormat() == 256, "Only JPEG is supported now");
        Image.Plane[] planes = image.getPlanes();
        if (planes == null || planes.length != 1) {
            throw new IllegalArgumentException("Unexpected image format, JPEG should have exactly 1 image plane");
        }
        ByteBuffer buffer = planes[0].getBuffer();
        buffer.rewind();
        int iRemaining = buffer.remaining();
        byte[] bArr = new byte[iRemaining];
        buffer.get(bArr);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, iRemaining);
        return m(bitmapDecodeByteArray, i, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
    }

    @NonNull
    @KeepForSdk
    public ByteBuffer e(@NonNull InputImage inputImage, boolean z) throws MlKitException {
        int iJ = inputImage.j();
        if (iJ != -1) {
            if (iJ == 17) {
                return z ? a((ByteBuffer) yw6.l(inputImage.h())) : (ByteBuffer) yw6.l(inputImage.h());
            }
            if (iJ == 35) {
                return j((Image.Plane[]) yw6.l(inputImage.m()), inputImage.o(), inputImage.k());
            }
            if (iJ == 842094169) {
                return l((ByteBuffer) yw6.l(inputImage.h()), z);
            }
            throw new MlKitException("Unsupported image format", 13);
        }
        Bitmap bitmapCopy = (Bitmap) yw6.l(inputImage.g());
        if (bitmapCopy.getConfig() == Bitmap.Config.HARDWARE) {
            bitmapCopy = bitmapCopy.copy(Bitmap.Config.ARGB_8888, bitmapCopy.isMutable());
        }
        Bitmap bitmap = bitmapCopy;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iCeil = (int) Math.ceil(((double) height) / 2.0d);
        int iCeil2 = ((iCeil + iCeil) * ((int) Math.ceil(((double) width) / 2.0d))) + i;
        ByteBuffer byteBufferAllocate = z ? ByteBuffer.allocate(iCeil2) : ByteBuffer.allocateDirect(iCeil2);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < height; i4++) {
            int i5 = 0;
            while (i5 < width) {
                int i6 = iArr[i3];
                int i7 = i6 >> 16;
                int i8 = i6 >> 8;
                int i9 = i6 & 255;
                int i10 = i2 + 1;
                int i11 = i7 & 255;
                int i12 = i8 & 255;
                byteBufferAllocate.put(i2, (byte) Math.min(255, (((((i11 * 66) + (i12 * 129)) + (i9 * 25)) + 128) >> 8) + 16));
                if (i4 % 2 == 0 && i3 % 2 == 0) {
                    int i13 = ((((i11 * 112) - (i12 * 94)) - (i9 * 18)) + 128) >> 8;
                    int i14 = (((((i11 * (-38)) - (i12 * 74)) + (i9 * 112)) + 128) >> 8) + 128;
                    int i15 = i + 1;
                    byteBufferAllocate.put(i, (byte) Math.min(255, i13 + 128));
                    i = i15 + 1;
                    byteBufferAllocate.put(i15, (byte) Math.min(255, i14));
                }
                i3++;
                i5++;
                i2 = i10;
            }
        }
        return byteBufferAllocate;
    }

    @NonNull
    @KeepForSdk
    public Bitmap f(@NonNull InputImage inputImage) throws MlKitException {
        int iJ = inputImage.j();
        if (iJ == -1) {
            return m((Bitmap) yw6.l(inputImage.g()), inputImage.n(), inputImage.o(), inputImage.k());
        }
        if (iJ == 17) {
            return i((ByteBuffer) yw6.l(inputImage.h()), inputImage.o(), inputImage.k(), inputImage.n());
        }
        if (iJ == 35) {
            return i(j((Image.Plane[]) yw6.l(inputImage.m()), inputImage.o(), inputImage.k()), inputImage.o(), inputImage.k(), inputImage.n());
        }
        if (iJ == 842094169) {
            return k((ByteBuffer) yw6.l(inputImage.h()), inputImage.o(), inputImage.k(), inputImage.n());
        }
        throw new MlKitException("Unsupported image format", 13);
    }

    @NonNull
    @KeepForSdk
    public Bitmap h(@NonNull InputImage inputImage) throws MlKitException {
        Bitmap bitmapG = inputImage.g();
        return bitmapG != null ? m(bitmapG, inputImage.n(), inputImage.o(), inputImage.k()) : f(inputImage);
    }

    @NonNull
    @KeepForSdk
    public Bitmap i(@NonNull ByteBuffer byteBuffer, int i, int i2, int i3) throws MlKitException {
        byte[] bArrN = n(b(byteBuffer), i, i2);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrN, 0, bArrN.length);
        return m(bitmapDecodeByteArray, i3, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
    }

    @NonNull
    @KeepForSdk
    public ByteBuffer j(@NonNull Image.Plane[] planeArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 4;
        byte[] bArr = new byte[i4 + i4 + i3];
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int iPosition = buffer2.position();
        int iLimit = buffer.limit();
        buffer2.position(iPosition + 1);
        buffer.limit(iLimit - 1);
        int i5 = (i3 + i3) / 4;
        boolean z = buffer2.remaining() == i5 + (-2) && buffer2.compareTo(buffer) == 0;
        buffer2.position(iPosition);
        buffer.limit(iLimit);
        if (z) {
            planeArr[0].getBuffer().get(bArr, 0, i3);
            ByteBuffer buffer3 = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i3, 1);
            buffer3.get(bArr, i3 + 1, i5 - 1);
        } else {
            o(planeArr[0], i, i2, bArr, 0, 1);
            o(planeArr[1], i, i2, bArr, i3 + 1, 2);
            o(planeArr[2], i, i2, bArr, i3, 2);
        }
        return ByteBuffer.wrap(bArr);
    }
}
