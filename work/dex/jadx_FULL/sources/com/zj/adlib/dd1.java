package com.zj.adlib;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.huachenjie.base.aliyun.detect_face.util.TakePhotoCallback;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class dd1 {

    public class a extends ImageCapture.OnImageCapturedCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f41153a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Context f15970a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ TakePhotoCallback f15971a;

        public a(final long val$startTime, final Context val$context, final TakePhotoCallback val$callback) {
            this.f41153a = val$startTime;
            this.f15970a = val$context;
            this.f15971a = val$callback;
        }

        @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
        public void onCaptureSuccess(@NonNull ImageProxy image) {
            i4a.a("CameraX 拍照耗时：" + (System.currentTimeMillis() - this.f41153a) + "ms");
            dd1.b(this.f15970a, null, image, this.f15971a);
        }

        @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
        public void onError(@NonNull ImageCaptureException exception) {
            this.f15971a.onError(exception.getMessage());
        }
    }

    public class b implements ImageCapture.OnImageSavedCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f41154a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Context f15972a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ TakePhotoCallback f15973a;

        public b(final long val$startTime, final TakePhotoCallback val$callback, final Context val$context) {
            this.f41154a = val$startTime;
            this.f15973a = val$callback;
            this.f15972a = val$context;
        }

        @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
        public void onError(@NonNull ImageCaptureException exception) {
            this.f15973a.onError(exception.getMessage());
        }

        @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
        public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
            i4a.a("CameraX 拍照耗时：" + (System.currentTimeMillis() - this.f41154a) + "ms");
            if (outputFileResults.getSavedUri() == null) {
                this.f15973a.onError("takePicture saved image fail");
            } else {
                dd1.b(this.f15972a, outputFileResults.getSavedUri(), null, this.f15973a);
            }
        }
    }

    public static void b(final Context context, final Uri uri, final ImageProxy image, final TakePhotoCallback callback) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.cd1
            @Override // java.lang.Runnable
            public final void run() {
                dd1.h(uri, context, image, callback, jCurrentTimeMillis);
            }
        });
    }

    public static int c(Context context, Uri uri) {
        if (uri == null) {
            return 0;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream == null) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    return 0;
                }
                int attributeInt = new ExifInterface(inputStreamOpenInputStream).getAttributeInt("Orientation", 1);
                try {
                    inputStreamOpenInputStream.close();
                } catch (Exception unused2) {
                }
                return attributeInt;
            } catch (Exception e) {
                e.printStackTrace();
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return 0;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    public static int d(Context context, Uri uri) {
        switch (c(context, uri)) {
            case 0:
            case 1:
            case 2:
            default:
                return 0;
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
        }
    }

    @Nullable
    public static Bitmap e(ImageProxy imageProxy) {
        if (imageProxy == null) {
            return null;
        }
        int format = imageProxy.getFormat();
        if (format == 35) {
            return n(imageProxy);
        }
        if (format != 256) {
            return null;
        }
        return g(imageProxy);
    }

    public static boolean f(Bitmap src) {
        return src == null || src.getWidth() == 0 || src.getHeight() == 0;
    }

    @Nullable
    public static Bitmap g(ImageProxy imageProxy) {
        if (imageProxy != null && imageProxy.getFormat() == 256) {
            try {
                ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
                int iRemaining = buffer.remaining();
                byte[] bArr = new byte[iRemaining];
                buffer.get(bArr, 0, iRemaining);
                return BitmapFactory.decodeByteArray(bArr, 0, iRemaining, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static /* synthetic */ void h(Uri uri, Context context, ImageProxy imageProxy, TakePhotoCallback takePhotoCallback, long j) {
        int rotationDegrees;
        Bitmap bitmapE;
        try {
            try {
                try {
                    if (uri != null) {
                        rotationDegrees = d(context, uri);
                        bitmapE = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
                    } else if (imageProxy != null) {
                        rotationDegrees = imageProxy.getImageInfo().getRotationDegrees();
                        bitmapE = e(imageProxy);
                    } else {
                        rotationDegrees = 0;
                        bitmapE = null;
                    }
                    i4a.a("rotation:" + rotationDegrees);
                    if (bitmapE == null) {
                        takePhotoCallback.onError("convert to bitmap fail");
                        if (imageProxy != null) {
                            try {
                                imageProxy.close();
                            } catch (Exception unused) {
                                return;
                            }
                        }
                        context.getContentResolver().delete(uri, null, null);
                        return;
                    }
                    if (rotationDegrees == 90 || rotationDegrees == 270) {
                        bitmapE = k(bitmapE, -90);
                    }
                    if (bitmapE == null) {
                        takePhotoCallback.onError("rotate bitmap fail");
                        if (imageProxy != null) {
                            try {
                                imageProxy.close();
                            } catch (Exception unused2) {
                                return;
                            }
                        }
                        context.getContentResolver().delete(uri, null, null);
                        return;
                    }
                    Bitmap bitmapI = i(bitmapE, true, true);
                    if (bitmapI == null) {
                        takePhotoCallback.onError("reverse bitmap fail");
                        if (imageProxy != null) {
                            try {
                                imageProxy.close();
                            } catch (Exception unused3) {
                                return;
                            }
                        }
                        context.getContentResolver().delete(uri, null, null);
                        return;
                    }
                    i4a.a("bitmap处理耗时：" + (System.currentTimeMillis() - j) + "ms");
                    takePhotoCallback.a(bitmapI);
                    if (imageProxy != null) {
                        imageProxy.close();
                    }
                    context.getContentResolver().delete(uri, null, null);
                } catch (Throwable th) {
                    if (imageProxy != null) {
                        try {
                            imageProxy.close();
                        } catch (Exception unused4) {
                            throw th;
                        }
                    }
                    context.getContentResolver().delete(uri, null, null);
                    throw th;
                }
            } catch (Exception unused5) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            takePhotoCallback.onError("takePicture saved image fail");
            if (imageProxy != null) {
                imageProxy.close();
            }
        }
    }

    @Nullable
    public static Bitmap i(Bitmap src, boolean isReversedHorizontal, boolean recycle) {
        if (f(src)) {
            return null;
        }
        try {
            Matrix matrix = new Matrix();
            if (isReversedHorizontal) {
                matrix.setScale(-1.0f, 1.0f);
            } else {
                matrix.setScale(1.0f, -1.0f);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
            if (recycle && !src.isRecycled() && bitmapCreateBitmap != src) {
                src.recycle();
            }
            return bitmapCreateBitmap;
        } catch (Exception unused) {
            return src;
        }
    }

    @Nullable
    public static Bitmap j(Bitmap src, int degrees, float px, float py, boolean recycle) {
        if (f(src)) {
            return null;
        }
        if (degrees == 0) {
            return src;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate(degrees, px, py);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
            if (recycle && !src.isRecycled() && bitmapCreateBitmap != src) {
                src.recycle();
            }
            return bitmapCreateBitmap;
        } catch (Exception unused) {
            return src;
        }
    }

    @Nullable
    public static Bitmap k(Bitmap src, int degrees) {
        if (f(src)) {
            return null;
        }
        return j(src, degrees, src.getWidth() / 2.0f, src.getHeight() / 2.0f, true);
    }

    public static void l(@NonNull ImageCapture imageCapture, Context context, @NonNull TakePhotoCallback callback) {
        imageCapture.lambda$takePicture$1(ContextCompat.getMainExecutor(context), new a(System.currentTimeMillis(), context, callback));
    }

    public static void m(@NonNull ImageCapture imageCapture, Context context, @NonNull TakePhotoCallback callback) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = String.format("picture_%s.jpg", Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put(com.google.android.exoplayer2.offline.a.f3586e, "image/jpeg");
        if (Build.VERSION.SDK_INT > 28) {
            contentValues.put("relative_path", "Pictures/CameraX-Image");
        }
        imageCapture.lambda$takePicture$2(new ImageCapture.OutputFileOptions.Builder(context.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues).setMetadata(new ImageCapture.Metadata()).build(), ContextCompat.getMainExecutor(context), new b(jCurrentTimeMillis, callback, context));
    }

    @Nullable
    public static Bitmap n(ImageProxy imageProxy) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (imageProxy != null && imageProxy.getFormat() == 35) {
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
                    while (i3 < height) {
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
                    } catch (Exception unused) {
                    }
                    return bitmapDecodeByteArray;
                } catch (Exception unused2) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }
}
