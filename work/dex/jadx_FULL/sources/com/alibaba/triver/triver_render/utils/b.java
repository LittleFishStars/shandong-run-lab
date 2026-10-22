package com.alibaba.triver.triver_render.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.google.android.exoplayer2.util.FileTypes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25225a = "RenderUtils";

    public static Bitmap a(Activity activity) {
        activity.getWindow().getDecorView().setDrawingCacheEnabled(true);
        return activity.getWindow().getDecorView().getDrawingCache();
    }

    public static Bitmap b(View view) {
        view.setDrawingCacheEnabled(true);
        view.destroyDrawingCache();
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    private static boolean b(Context context) {
        return false;
    }

    public static Bitmap a(View view) {
        return b(view);
    }

    public static String a(Bitmap bitmap, Context context, boolean z, int i, long j, long j2, String str, boolean z2) throws Throwable {
        if (bitmap == null) {
            throw new RuntimeException("bitmap is null");
        }
        if (z2) {
            bitmap = a(bitmap, j, j2);
        }
        if (!z) {
            String strA = a(context, bitmap, str, i);
            RVLogger.d(f25225a, "saveBitmapToCache to " + strA);
            return strA;
        }
        return a(bitmap, context);
    }

    public static Bitmap a(Bitmap bitmap, long j, long j2) {
        int i;
        int i2;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            i2 = width;
            i = height;
        } else {
            i = width;
            i2 = height;
        }
        if (i2 <= j && i <= j2) {
            return bitmap;
        }
        float f = j / i2;
        float f2 = j2 / i;
        if (f >= f2) {
            f = f2;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private static String a(Bitmap bitmap, Context context) {
        String strInsertImage = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, a(), "");
        RVLogger.d(f25225a, "writeToDefaultPathAndShowInAlbum: " + strInsertImage);
        return strInsertImage;
    }

    private static String a() {
        return "TRIVER_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US).format(new Date()) + FileTypes.F;
    }

    private static void a(Uri uri, Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(uri);
        context.sendBroadcast(intent);
    }

    private static void a(Context context, Bitmap bitmap, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        FileOutputStream fileOutputStream = null;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "w");
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        RVLogger.w(Log.getStackTraceString(th));
                    } finally {
                        if (fileOutputStream != null) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            parcelFileDescriptorOpenFileDescriptor = null;
        }
    }

    private static String a(Context context, Bitmap bitmap, String str, int i) throws Throwable {
        Bitmap.CompressFormat compressFormat;
        FileOutputStream fileOutputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = "triver_image_" + jCurrentTimeMillis;
        File file = new File(context.getCacheDir().getAbsolutePath() + File.separator + str2);
        if ("png".equals(str)) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(compressFormat, i, fileOutputStream);
                fileOutputStream.close();
                return file.getAbsolutePath();
            } catch (Exception unused) {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return false;
        }
    }

    public static boolean a(Page page) {
        if (TRiverUtils.canGoBack(page)) {
            return false;
        }
        if (TRiverUtils.isStartPage(page)) {
            return true;
        }
        return TRiverUtils.isFirstTab(page) && TRiverUtils.isHomePage(page);
    }
}
