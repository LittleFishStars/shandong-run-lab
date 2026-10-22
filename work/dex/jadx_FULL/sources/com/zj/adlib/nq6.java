package com.zj.adlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.fl.saas.common.util.FileTypeUtils;
import com.google.android.exoplayer2.source.rtsp.j;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b2\u00103J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0015J\u001e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010J&\u0010!\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010J\u0018\u0010\"\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J(\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010J(\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010J\u0016\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\t2\u0006\u0010$\u001a\u00020#J\u0018\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J\u0016\u0010+\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u0018\u0010,\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J \u0010/\u001a\u00020\u00102\u0006\u0010.\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002J\u0010\u00101\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0006H\u0002¨\u00064"}, d2 = {"Lcom/zj/adlib/nq6;", "", "Landroid/content/Context;", "context", "Ljava/io/File;", "k", "", "picPath", "fileName", "Landroid/graphics/Bitmap;", "bitmap", "p", FileTypeUtils.FILE_TYPE_BMP, "", "a", "filePath", "", "cameraId", "degree", "", "q", "Landroid/net/Uri;", "uri", "r", "m", "selectedImage", "f", "bm", "newWidth", "newHeight", "d", "reqWidth", "reqHeight", "e", j.b, "", "maxSize", "j", y6b.f, "oriBitmap", y6b.g, "", t.d, "i", "c", "Landroid/graphics/BitmapFactory$Options;", "options", "b", "path", "n", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class nq6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final nq6 f43588a = new nq6();

    @Nullable
    public final byte[] a(@Nullable Bitmap bmp) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byteArray = null;
        try {
            try {
                Intrinsics.checkNotNull(bmp);
                bmp.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                bmp.recycle();
                return byteArray;
            } catch (Exception e) {
                e.printStackTrace();
                if (bmp != null) {
                    bmp.recycle();
                }
                return byteArray;
            }
        } catch (Throwable unused) {
            if (bmp != null) {
                bmp.recycle();
            }
            return byteArray;
        }
    }

    public final int b(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        if (i <= reqHeight && i2 <= reqWidth) {
            return 1;
        }
        int iRound = Math.round(i / reqHeight);
        int iRound2 = Math.round(i2 / reqWidth);
        return iRound < iRound2 ? iRound : iRound2;
    }

    @Nullable
    public final Uri c(@NotNull Context context, @NotNull Uri uri) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            File file = new File(f43588a.k(context).getAbsolutePath(), new Random().nextInt() + "_temp.jpg");
            jg3.f42579a.n(inputStreamOpenInputStream, file);
            return sh9.i(context, file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @NotNull
    public final Bitmap d(@NotNull Bitmap bm, int newWidth, int newHeight) {
        Intrinsics.checkNotNullParameter(bm, "bm");
        int width = bm.getWidth();
        int height = bm.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(newWidth / width, newHeight / height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …           true\n        )");
        return bitmapCreateBitmap;
    }

    @NotNull
    public final Bitmap e(@NotNull Context context, @NotNull Uri uri, int reqWidth, int reqHeight) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        jg3 jg3Var = jg3.f42579a;
        BitmapFactory.decodeFile(jg3Var.i(context, uri), options);
        options.inSampleSize = b(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(jg3Var.i(context, uri), options);
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeFile, "decodeFile(FileUtil.getF…i(context, uri), options)");
        return bitmapDecodeFile;
    }

    @Nullable
    public final Bitmap f(@NotNull Context context, @NotNull Uri selectedImage) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectedImage, "selectedImage");
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(context.getContentResolver().openInputStream(selectedImage), null, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        while (true) {
            i2 /= 2;
            if (i2 < 140 || (i3 = i3 / 2) < 140) {
                break;
            }
            i *= 2;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = i;
        return BitmapFactory.decodeStream(context.getContentResolver().openInputStream(selectedImage), null, options2);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0088 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x008a A[Catch: IOException -> 0x0086, TRY_LEAVE, TryCatch #5 {IOException -> 0x0086, blocks: (B:37:0x0082, B:41:0x008a), top: B:60:0x0082 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0095  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a2 A[Catch: IOException -> 0x009e, TRY_LEAVE, TryCatch #9 {IOException -> 0x009e, blocks: (B:49:0x009a, B:53:0x00a2), top: B:62:0x009a }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v7, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v9, types: [android.graphics.Bitmap, java.lang.Object] */
    @Nullable
    public final Bitmap g(@NotNull String filePath, long maxSize, int reqWidth, int reqHeight) {
        ?? DecodeFile;
        ByteArrayInputStream byteArrayInputStream;
        ?? r7;
        ByteArrayInputStream byteArrayInputStream2;
        ?? byteArrayOutputStream;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(filePath, options);
            options.inSampleSize = b(options, reqWidth, reqHeight);
            options.inJustDecodeBounds = false;
            DecodeFile = BitmapFactory.decodeFile(filePath, options);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    Intrinsics.checkNotNull((Object) DecodeFile);
                    int i = 100;
                    DecodeFile.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    while (byteArrayOutputStream.toByteArray().length > maxSize) {
                        i -= 16;
                        byteArrayOutputStream.reset();
                        if (i <= 0) {
                            break;
                        }
                        DecodeFile.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                    }
                    byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(byteArrayInputStream);
                        DecodeFile.recycle();
                        try {
                            byteArrayOutputStream.close();
                            byteArrayInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return bitmapDecodeStream;
                    } catch (OutOfMemoryError e2) {
                        byteArrayInputStream2 = byteArrayInputStream;
                        e = e2;
                        DecodeFile = DecodeFile;
                        byteArrayOutputStream = byteArrayOutputStream;
                        try {
                            e.printStackTrace();
                            if (DecodeFile != 0) {
                                DecodeFile.recycle();
                            }
                            if (byteArrayOutputStream != 0) {
                                try {
                                    byteArrayOutputStream.close();
                                    if (byteArrayInputStream2 != null) {
                                        byteArrayInputStream2.close();
                                    }
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return null;
                                }
                            } else if (byteArrayInputStream2 != null) {
                                byteArrayInputStream2.close();
                            }
                            return null;
                        } catch (Throwable unused) {
                            byteArrayInputStream = byteArrayInputStream2;
                            if (DecodeFile != 0) {
                                DecodeFile.recycle();
                            }
                            if (byteArrayOutputStream != 0) {
                                try {
                                    byteArrayOutputStream.close();
                                    if (byteArrayInputStream != null) {
                                        byteArrayInputStream.close();
                                    }
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    return null;
                                }
                            } else if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                            return null;
                        }
                    } catch (Throwable unused2) {
                        if (DecodeFile != 0) {
                            DecodeFile.recycle();
                        }
                        if (byteArrayOutputStream != 0) {
                            byteArrayOutputStream.close();
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                        } else if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        return null;
                    }
                } catch (OutOfMemoryError e5) {
                    e = e5;
                    byteArrayInputStream2 = null;
                    DecodeFile = DecodeFile;
                    byteArrayOutputStream = byteArrayOutputStream;
                } catch (Throwable unused3) {
                    byteArrayInputStream = null;
                }
            } catch (OutOfMemoryError e6) {
                e = e6;
                byteArrayInputStream2 = null;
                r7 = DecodeFile;
                byteArrayOutputStream = byteArrayInputStream2;
                DecodeFile = r7;
                e.printStackTrace();
                if (DecodeFile != 0) {
                    DecodeFile.recycle();
                }
                if (byteArrayOutputStream != 0) {
                    byteArrayOutputStream.close();
                    if (byteArrayInputStream2 != null) {
                        byteArrayInputStream2.close();
                    }
                } else if (byteArrayInputStream2 != null) {
                    byteArrayInputStream2.close();
                }
                return null;
            } catch (Throwable unused4) {
                byteArrayInputStream = null;
                DecodeFile = DecodeFile;
                byteArrayOutputStream = byteArrayInputStream;
                if (DecodeFile != 0) {
                    DecodeFile.recycle();
                }
                if (byteArrayOutputStream != 0) {
                    byteArrayOutputStream.close();
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                } else if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            }
        } catch (OutOfMemoryError e7) {
            e = e7;
            r7 = 0;
            byteArrayInputStream2 = null;
        } catch (Throwable unused5) {
            DecodeFile = 0;
            byteArrayInputStream = null;
        }
    }

    @NotNull
    public final byte[] h(@NotNull Bitmap oriBitmap, long maxSize) {
        Intrinsics.checkNotNullParameter(oriBitmap, "oriBitmap");
        byte[] bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                int i = 100;
                oriBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
                while (byteArrayOutputStream2.toByteArray().length > maxSize) {
                    i -= 16;
                    byteArrayOutputStream2.reset();
                    if (i <= 0) {
                        break;
                    }
                    oriBitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream2);
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "outputStream.toByteArray()");
                oriBitmap.recycle();
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return byteArray;
            } catch (OutOfMemoryError unused) {
                byteArrayOutputStream = byteArrayOutputStream2;
                oriBitmap.recycle();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return bArr;
            } catch (Throwable unused2) {
                byteArrayOutputStream = byteArrayOutputStream2;
                oriBitmap.recycle();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return bArr;
            }
        } catch (OutOfMemoryError unused3) {
        } catch (Throwable unused4) {
        }
    }

    @NotNull
    public final Bitmap i(@NotNull Context context, @NotNull Uri uri) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor != null ? parcelFileDescriptorOpenFileDescriptor.getFileDescriptor() : null);
        if (parcelFileDescriptorOpenFileDescriptor != null) {
            parcelFileDescriptorOpenFileDescriptor.close();
        }
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeFileDescriptor, "image");
        return bitmapDecodeFileDescriptor;
    }

    @Nullable
    public final Bitmap j(@NotNull String filePath, long maxSize, int reqWidth, int reqHeight) {
        Bitmap bitmapG;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Bitmap bitmapCreateBitmap = null;
        if (TextUtils.isEmpty(filePath) || (bitmapG = g(filePath, maxSize, reqWidth, reqHeight)) == null) {
            return null;
        }
        int iN = n(filePath);
        Matrix matrix = new Matrix();
        matrix.postRotate(iN);
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapG, 0, 0, bitmapG.getWidth(), bitmapG.getHeight(), matrix, true);
        } catch (Exception unused) {
        }
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = bitmapG;
        }
        if (!Intrinsics.areEqual(bitmapG, bitmapCreateBitmap)) {
            bitmapG.recycle();
        }
        return bitmapCreateBitmap;
    }

    @NotNull
    public final File k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File fileF = jg3.f42579a.f(context);
        if (fileF != null && !fileF.exists()) {
            fileF.mkdirs();
        }
        Intrinsics.checkNotNull(fileF);
        return fileF;
    }

    public final boolean l(@NotNull Context context, @Nullable String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (filePath == null) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        return options.outWidth != -1;
    }

    @Nullable
    public final Bitmap m(@NotNull Context context, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Uri uriI = sh9.i(context, new File(filePath));
        if (uriI != null) {
            return MediaStore.Images.Media.getBitmap(context.getContentResolver(), uriI);
        }
        return null;
    }

    public final int n(String path) {
        try {
            int attributeInt = new ExifInterface(path).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Nullable
    public final Bitmap o(@NotNull String filePath, int cameraId) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(filePath);
        int iN = n(filePath);
        Matrix matrix = new Matrix();
        matrix.postRotate(iN);
        if (cameraId == 0) {
            matrix.postScale(-1.0f, 1.0f);
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
            if (bitmapCreateBitmap == null) {
                bitmapCreateBitmap = bitmapDecodeFile;
            }
            if (!Intrinsics.areEqual(bitmapDecodeFile, bitmapCreateBitmap)) {
                bitmapDecodeFile.recycle();
            }
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final File p(@NotNull String picPath, @NotNull String fileName, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(picPath, "picPath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (!TextUtils.isEmpty(picPath) && bitmap != null) {
            try {
                File file = new File(picPath, fileName);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (NullPointerException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0028  */
    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    /* JADX WARN: Code duplicated, block: B:16:0x002c  */
    public final void q(@NotNull String filePath, int cameraId, int degree) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            ExifInterface exifInterface = new ExifInterface(filePath);
            int i = 8;
            if (cameraId == 0) {
                if (degree == 0) {
                    i = 3;
                } else if (degree != 90) {
                    if (degree == 180 || degree != 270) {
                        i = 1;
                    } else {
                        i = 6;
                    }
                }
            } else if (degree == 0) {
                i = 1;
            } else if (degree == 90) {
                i = 6;
            } else if (degree == 180) {
                i = 3;
            } else if (degree != 270) {
                i = 1;
            }
            exifInterface.setAttribute("Orientation", String.valueOf(i));
            exifInterface.saveAttributes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public final Bitmap r(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String strI = jg3.f42579a.i(context, uri);
        Intrinsics.checkNotNull(strI);
        return m(context, strI);
    }
}
