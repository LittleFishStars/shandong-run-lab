package com.bumptech.glide.integration.webp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.Keep;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Keep
public class WebpBitmapFactory {
    private static final int IN_TEMP_BUFFER_SIZE = 8192;
    private static final int MAX_WEBP_HEADER_SIZE = 21;

    static {
        System.loadLibrary("glide-webp");
    }

    @Keep
    private static Bitmap createBitmap(int i, int i2, BitmapFactory.Options options) {
        Bitmap bitmap;
        if (options != null && (bitmap = options.inBitmap) != null && bitmap.isMutable()) {
            return options.inBitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setHasAlpha(true);
        bitmapCreateBitmap.eraseColor(0);
        return bitmapCreateBitmap;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        return decodeByteArray(bArr, i, i2, null);
    }

    public static Bitmap decodeFile(String str) {
        return decodeFile(str, null);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        return decodeFileDescriptor(fileDescriptor, null, null);
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        return decodeResource(resources, i, null);
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i = typedValue.density;
            if (i == 0) {
                options.inDensity = 160;
            } else if (i != 65535) {
                options.inDensity = i;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return decodeStream(inputStream, rect, options);
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        return decodeStream(inputStream, null, null);
    }

    private static byte[] getImageHeader(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, 21);
        }
        inputStream.mark(21);
        byte[] bArr = new byte[21];
        try {
            inputStream.read(bArr, 0, 21);
            inputStream.reset();
            return bArr;
        } catch (IOException unused) {
            return null;
        }
    }

    private static byte[] getInTempStorageFromOptions(BitmapFactory.Options options) {
        byte[] bArr;
        return (options == null || (bArr = options.inTempStorage) == null) ? new byte[8192] : bArr;
    }

    private static float getScaleFromOptions(BitmapFactory.Options options) {
        if (options == null) {
            return 1.0f;
        }
        int i = options.inSampleSize;
        float f = i > 1 ? 1.0f / i : 1.0f;
        if (!options.inScaled) {
            return f;
        }
        int i2 = options.inDensity;
        int i3 = options.inTargetDensity;
        return (i2 == 0 || i3 == 0 || i2 == options.inScreenDensity) ? f : i3 / i2;
    }

    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options, float f, byte[] bArr2);

    private static native Bitmap nativeDecodeStream(InputStream inputStream, BitmapFactory.Options options, float f, byte[] bArr);

    private static void setDefaultPadding(Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    private static void setDensityFromOptions(Bitmap bitmap, BitmapFactory.Options options) {
        if (bitmap == null || options == null) {
            return;
        }
        int i = options.inDensity;
        if (i == 0) {
            if (options.inBitmap != null) {
                bitmap.setDensity(160);
                return;
            }
            return;
        }
        bitmap.setDensity(i);
        int i2 = options.inTargetDensity;
        if (i2 == 0 || i == i2 || i == options.inScreenDensity || !options.inScaled) {
            return;
        }
        bitmap.setDensity(i2);
    }

    @Keep
    private static boolean setOutDimensions(BitmapFactory.Options options, int i, int i2) {
        if (options == null) {
            return false;
        }
        options.outWidth = i;
        options.outHeight = i2;
        return options.inJustDecodeBounds;
    }

    private static void setWebpBitmapOptions(Bitmap bitmap, BitmapFactory.Options options) {
        setDensityFromOptions(bitmap, options);
        if (options != null) {
            options.outMimeType = "image/webp";
        }
    }

    public static boolean webpSupportRequired(byte[] bArr, int i, int i2) {
        try {
            WebpHeaderParser.getType(bArr, i, i2);
            return false;
        } catch (IOException unused) {
            WebpHeaderParser.WebpImageType webpImageType = WebpHeaderParser.WebpImageType.NONE_WEBP;
            return false;
        }
    }

    private static InputStream wrapToMarkSupportedStream(InputStream inputStream) {
        return !inputStream.markSupported() ? new BufferedInputStream(inputStream, 8192) : inputStream;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        if ((i | i2) < 0 || bArr.length < i + i2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (!webpSupportRequired(bArr, i, i2)) {
            return BitmapFactory.decodeByteArray(bArr, i, i2, options);
        }
        Bitmap bitmapNativeDecodeByteArray = nativeDecodeByteArray(bArr, i, i2, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
        setWebpBitmapOptions(bitmapNativeDecodeByteArray, options);
        return bitmapNativeDecodeByteArray;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Bitmap decodeFile(String str, BitmapFactory.Options options) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        bitmapDecodeStream = null;
        Bitmap bitmapDecodeStream = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                try {
                    bitmapDecodeStream = decodeStream(fileInputStream, null, options);
                } catch (Exception e) {
                    e = e;
                    Log.e("WebpBitmapFactory", "Unable to decode stream: " + e);
                    if (fileInputStream != null) {
                    }
                    return bitmapDecodeStream;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
        try {
            fileInputStream.close();
        } catch (IOException unused2) {
        }
        return bitmapDecodeStream;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        Bitmap bitmapDecodeFileDescriptor;
        InputStream inputStreamWrapToMarkSupportedStream = wrapToMarkSupportedStream(new FileInputStream(fileDescriptor));
        try {
            if (webpSupportRequired(getImageHeader(inputStreamWrapToMarkSupportedStream), 0, 21)) {
                bitmapDecodeFileDescriptor = nativeDecodeStream(inputStreamWrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                setWebpBitmapOptions(bitmapDecodeFileDescriptor, options);
                setDefaultPadding(rect);
            } else {
                bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
            }
            return bitmapDecodeFileDescriptor;
        } finally {
            try {
                inputStreamWrapToMarkSupportedStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0010 A[EXC_TOP_SPLITTER, PHI: r0 r3
      0x0010: PHI (r0v3 android.graphics.Bitmap) = (r0v9 android.graphics.Bitmap), (r0v7 android.graphics.Bitmap) binds: [B:15:0x001f, B:5:0x000e] A[DONT_GENERATE, DONT_INLINE]
      0x0010: PHI (r3v3 java.io.InputStream) = (r3v2 java.io.InputStream), (r3v5 java.io.InputStream) binds: [B:15:0x001f, B:5:0x000e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static Bitmap decodeResource(Resources resources, int i, BitmapFactory.Options options) throws Throwable {
        InputStream inputStreamOpenRawResource;
        InputStream inputStream = null;
        bitmapDecodeResourceStream = null;
        Bitmap bitmapDecodeResourceStream = null;
        try {
            TypedValue typedValue = new TypedValue();
            inputStreamOpenRawResource = resources.openRawResource(i, typedValue);
            try {
                bitmapDecodeResourceStream = decodeResourceStream(resources, typedValue, inputStreamOpenRawResource, null, options);
                if (inputStreamOpenRawResource != null) {
                    try {
                        inputStreamOpenRawResource.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (Exception unused2) {
                if (inputStreamOpenRawResource != null) {
                    inputStreamOpenRawResource.close();
                }
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenRawResource;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
            inputStreamOpenRawResource = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (bitmapDecodeResourceStream != null || options == null || options.inBitmap == null) {
            return bitmapDecodeResourceStream;
        }
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (inputStream == null) {
            return null;
        }
        InputStream inputStreamWrapToMarkSupportedStream = wrapToMarkSupportedStream(inputStream);
        if (!webpSupportRequired(getImageHeader(inputStreamWrapToMarkSupportedStream), 0, 21)) {
            return BitmapFactory.decodeStream(inputStreamWrapToMarkSupportedStream, rect, options);
        }
        Bitmap bitmapNativeDecodeStream = nativeDecodeStream(inputStreamWrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
        setWebpBitmapOptions(bitmapNativeDecodeStream, options);
        setDefaultPadding(rect);
        return bitmapNativeDecodeStream;
    }
}
