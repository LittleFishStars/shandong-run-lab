package com.zj.adlib;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class g84 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final su3 f16719a = new su3("MLKitImageUtils", "");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g84 f41842a = new g84();

    @NonNull
    @KeepForSdk
    public static g84 b() {
        return f41842a;
    }

    @NonNull
    @KeepForSdk
    public IObjectWrapper a(@NonNull InputImage inputImage) throws MlKitException {
        int iJ = inputImage.j();
        if (iJ == -1) {
            return ObjectWrapper.wrap((Bitmap) yw6.l(inputImage.g()));
        }
        if (iJ != 17) {
            if (iJ == 35) {
                return ObjectWrapper.wrap(inputImage.l());
            }
            if (iJ != 842094169) {
                throw new MlKitException("Unsupported image format: " + inputImage.j(), 3);
            }
        }
        return ObjectWrapper.wrap((ByteBuffer) yw6.l(inputImage.h()));
    }

    @KeepForSdk
    public int c(@NonNull InputImage inputImage) {
        return inputImage.j();
    }

    @KeepForSdk
    public int d(@NonNull InputImage inputImage) {
        if (inputImage.j() == -1) {
            return ((Bitmap) yw6.l(inputImage.g())).getAllocationByteCount();
        }
        if (inputImage.j() == 17 || inputImage.j() == 842094169) {
            return ((ByteBuffer) yw6.l(inputImage.h())).limit();
        }
        if (inputImage.j() != 35) {
            return 0;
        }
        return (((Image.Plane[]) yw6.l(inputImage.m()))[0].getBuffer().limit() * 3) / 2;
    }

    @Nullable
    @KeepForSdk
    public Matrix e(int i, int i2, int i3) {
        if (i3 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-i) / 2.0f, (-i2) / 2.0f);
        matrix.postRotate(i3 * 90);
        int i4 = i3 % 2;
        int i5 = i4 != 0 ? i2 : i;
        if (i4 == 0) {
            i = i2;
        }
        matrix.postTranslate(i5 / 2.0f, i / 2.0f);
        return matrix;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0066  */
    /* JADX WARN: Code duplicated, block: B:32:0x0067 A[Catch: FileNotFoundException -> 0x00ca, TryCatch #5 {FileNotFoundException -> 0x00ca, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:33:0x006d, B:34:0x0082, B:45:0x00b3, B:47:0x00bd, B:36:0x0087, B:37:0x008b, B:38:0x0092, B:39:0x0096, B:40:0x009d, B:41:0x00a1, B:43:0x00a8, B:32:0x0067, B:29:0x0055, B:49:0x00c2, B:50:0x00c9), top: B:65:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0085  */
    /* JADX WARN: Code duplicated, block: B:36:0x0087 A[Catch: FileNotFoundException -> 0x00ca, TryCatch #5 {FileNotFoundException -> 0x00ca, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:33:0x006d, B:34:0x0082, B:45:0x00b3, B:47:0x00bd, B:36:0x0087, B:37:0x008b, B:38:0x0092, B:39:0x0096, B:40:0x009d, B:41:0x00a1, B:43:0x00a8, B:32:0x0067, B:29:0x0055, B:49:0x00c2, B:50:0x00c9), top: B:65:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x008b A[Catch: FileNotFoundException -> 0x00ca, TryCatch #5 {FileNotFoundException -> 0x00ca, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:33:0x006d, B:34:0x0082, B:45:0x00b3, B:47:0x00bd, B:36:0x0087, B:37:0x008b, B:38:0x0092, B:39:0x0096, B:40:0x009d, B:41:0x00a1, B:43:0x00a8, B:32:0x0067, B:29:0x0055, B:49:0x00c2, B:50:0x00c9), top: B:65:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0092 A[Catch: FileNotFoundException -> 0x00ca, TryCatch #5 {FileNotFoundException -> 0x00ca, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:33:0x006d, B:34:0x0082, B:45:0x00b3, B:47:0x00bd, B:36:0x0087, B:37:0x008b, B:38:0x0092, B:39:0x0096, B:40:0x009d, B:41:0x00a1, B:43:0x00a8, B:32:0x0067, B:29:0x0055, B:49:0x00c2, B:50:0x00c9), top: B:65:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0096 A[Catch: FileNotFoundException -> 0x00ca, TryCatch #5 {FileNotFoundException -> 0x00ca, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:33:0x006d, B:34:0x0082, B:45:0x00b3, B:47:0x00bd, B:36:0x0087, B:37:0x008b, B:38:0x0092, B:39:0x0096, B:40:0x009d, B:41:0x00a1, B:43:0x00a8, B:32:0x0067, B:29:0x0055, B:49:0x00c2, B:50:0x00c9), top: B:65:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x009d A[Catch: FileNotFoundException -> 0x00ca, TryCatch #5 {FileNotFoundException -> 0x00ca, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:33:0x006d, B:34:0x0082, B:45:0x00b3, B:47:0x00bd, B:36:0x0087, B:37:0x008b, B:38:0x0092, B:39:0x0096, B:40:0x009d, B:41:0x00a1, B:43:0x00a8, B:32:0x0067, B:29:0x0055, B:49:0x00c2, B:50:0x00c9), top: B:65:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a1 A[Catch: FileNotFoundException -> 0x00ca, TryCatch #5 {FileNotFoundException -> 0x00ca, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:33:0x006d, B:34:0x0082, B:45:0x00b3, B:47:0x00bd, B:36:0x0087, B:37:0x008b, B:38:0x0092, B:39:0x0096, B:40:0x009d, B:41:0x00a1, B:43:0x00a8, B:32:0x0067, B:29:0x0055, B:49:0x00c2, B:50:0x00c9), top: B:65:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a8 A[Catch: FileNotFoundException -> 0x00ca, TryCatch #5 {FileNotFoundException -> 0x00ca, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:33:0x006d, B:34:0x0082, B:45:0x00b3, B:47:0x00bd, B:36:0x0087, B:37:0x008b, B:38:0x0092, B:39:0x0096, B:40:0x009d, B:41:0x00a1, B:43:0x00a8, B:32:0x0067, B:29:0x0055, B:49:0x00c2, B:50:0x00c9), top: B:65:0x0004 }] */
    @NonNull
    public final Bitmap f(@NonNull ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        ExifInterface exifInterface;
        Matrix matrix;
        Matrix matrix2;
        Bitmap bitmapCreateBitmap;
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);
            if (bitmap == null) {
                throw new IOException("The image Uri could not be resolved.");
            }
            int attributeInt = 0;
            if ("content".equals(uri.getScheme()) || "file".equals(uri.getScheme())) {
                try {
                    InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            exifInterface = new ExifInterface(inputStreamOpenInputStream);
                        } catch (Throwable th) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Throwable th2) {
                                try {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        exifInterface = null;
                    }
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e) {
                            e = e;
                            f16719a.f("MLKitImageUtils", "failed to open file to read rotation meta data: ".concat(String.valueOf(uri)), e);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    exifInterface = null;
                    f16719a.f("MLKitImageUtils", "failed to open file to read rotation meta data: ".concat(String.valueOf(uri)), e);
                    if (exifInterface == null) {
                        attributeInt = exifInterface.getAttributeInt("Orientation", 1);
                    }
                    matrix = new Matrix();
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    switch (attributeInt) {
                        case 2:
                            matrix = new Matrix();
                            matrix.postScale(-1.0f, 1.0f);
                            matrix2 = matrix;
                            break;
                        case 3:
                            matrix.postRotate(180.0f);
                            matrix2 = matrix;
                            break;
                        case 4:
                            matrix.postScale(1.0f, -1.0f);
                            matrix2 = matrix;
                            break;
                        case 5:
                            matrix.postRotate(90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            matrix2 = matrix;
                            break;
                        case 6:
                            matrix.postRotate(90.0f);
                            matrix2 = matrix;
                            break;
                        case 7:
                            matrix.postRotate(-90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            matrix2 = matrix;
                            break;
                        case 8:
                            matrix.postRotate(-90.0f);
                            matrix2 = matrix;
                            break;
                        default:
                            matrix2 = null;
                            break;
                    }
                    return matrix2 == null ? bitmap : bitmap;
                }
                if (exifInterface == null) {
                    attributeInt = exifInterface.getAttributeInt("Orientation", 1);
                }
            }
            matrix = new Matrix();
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            switch (attributeInt) {
                case 2:
                    matrix = new Matrix();
                    matrix.postScale(-1.0f, 1.0f);
                    matrix2 = matrix;
                    break;
                case 3:
                    matrix.postRotate(180.0f);
                    matrix2 = matrix;
                    break;
                case 4:
                    matrix.postScale(1.0f, -1.0f);
                    matrix2 = matrix;
                    break;
                case 5:
                    matrix.postRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    matrix2 = matrix;
                    break;
                case 6:
                    matrix.postRotate(90.0f);
                    matrix2 = matrix;
                    break;
                case 7:
                    matrix.postRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    matrix2 = matrix;
                    break;
                case 8:
                    matrix.postRotate(-90.0f);
                    matrix2 = matrix;
                    break;
                default:
                    matrix2 = null;
                    break;
            }
            if (matrix2 == null && bitmap != (bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width2, height2, matrix2, true))) {
                bitmap.recycle();
                return bitmapCreateBitmap;
            }
        } catch (FileNotFoundException e3) {
            f16719a.f("MLKitImageUtils", "Could not open file: ".concat(String.valueOf(uri)), e3);
            throw e3;
        }
    }
}
