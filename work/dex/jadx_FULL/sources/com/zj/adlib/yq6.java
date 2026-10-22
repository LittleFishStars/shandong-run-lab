package com.zj.adlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.blankj.utilcode.util.ImageUtils;
import com.huachenjie.common.util.media_picker.MediaPickerConstants;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.zibin.luban.OnNewCompressListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J4\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002J \u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tJ\"\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002¨\u0006\u0018"}, d2 = {"Lcom/zj/adlib/yq6;", "", "", "fileName", "e", "Landroid/content/Context;", "context", "Ljava/io/File;", "sourceFile", "", "maxWidth", "maxSizeKb", "outputFileName", "c", "a", "Landroid/graphics/Bitmap;", "bitmap", y6b.g, "b", "f", "filePath", y6b.f, "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class yq6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final yq6 f46098a = new yq6();

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"com/zj/adlib/yq6$a", "Ltop/zibin/luban/OnNewCompressListener;", "", "onStart", "", "source", "Ljava/io/File;", "compressFile", "a", "", "e", "b", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements OnNewCompressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f46099a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Ref.ObjectRef<File> f20920a;

        public a(Ref.ObjectRef<File> objectRef, CountDownLatch countDownLatch) {
            this.f20920a = objectRef;
            this.f46099a = countDownLatch;
        }

        public void a(@NotNull String source, @NotNull File compressFile) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(compressFile, "compressFile");
            this.f20920a.element = compressFile;
            this.f46099a.countDown();
        }

        public void b(@NotNull String source, @NotNull Throwable e) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(e, "e");
            e.printStackTrace();
            this.f46099a.countDown();
        }

        public void onStart() {
        }
    }

    public static /* synthetic */ String d(yq6 yq6Var, Context context, File file, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str = null;
        }
        return yq6Var.c(context, file, i, i2, str);
    }

    @Nullable
    public final File a(@NotNull Context context, @NotNull File sourceFile, int maxSizeKb) throws InterruptedException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        g55.o(context).u(sourceFile).p(maxSizeKb).C(new a(objectRef, countDownLatch)).r();
        countDownLatch.await(30L, TimeUnit.SECONDS);
        return (File) objectRef.element;
    }

    public final String b(File sourceFile, int maxWidth, String outputFileName) {
        try {
            Bitmap bitmapZ = ImageUtils.Z(sourceFile.getAbsolutePath(), maxWidth, maxWidth);
            if (bitmapZ == null) {
                return null;
            }
            String absolutePath = sourceFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "sourceFile.absolutePath");
            Bitmap bitmapG = g(bitmapZ, absolutePath);
            File file = new File(MediaPickerConstants.f8905a.b(), outputFileName);
            if (!ImageUtils.w0(bitmapG, file, Bitmap.CompressFormat.JPEG, 85, true)) {
                return null;
            }
            if (!Intrinsics.areEqual(file.getAbsolutePath(), sourceFile.getAbsolutePath())) {
                sourceFile.delete();
            }
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final String c(@NotNull Context context, @NotNull File sourceFile, int maxWidth, int maxSizeKb, @Nullable String outputFileName) throws InterruptedException {
        String absolutePath;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        if (outputFileName == null) {
            String name = sourceFile.getName();
            Intrinsics.checkNotNullExpressionValue(name, "sourceFile.name");
            outputFileName = f(name);
        }
        if (maxWidth > 0 && maxSizeKb <= 0) {
            return b(sourceFile, maxWidth, outputFileName);
        }
        if (maxWidth <= 0 && maxSizeKb > 0) {
            File fileA = a(context, sourceFile, maxSizeKb);
            return (fileA == null || (absolutePath = fileA.getAbsolutePath()) == null) ? sourceFile.getAbsolutePath() : absolutePath;
        }
        String strB = b(sourceFile, maxWidth, outputFileName);
        if (strB == null) {
            return null;
        }
        File fileA2 = a(context, new File(strB), maxSizeKb);
        if (fileA2 == null || Intrinsics.areEqual(fileA2.getAbsolutePath(), strB)) {
            return strB;
        }
        new File(strB).delete();
        return fileA2.getAbsolutePath();
    }

    @NotNull
    public final String e(@NotNull String fileName) {
        String str;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        File file = new File(MediaPickerConstants.f8905a.b(), fileName);
        if (!file.exists()) {
            return fileName;
        }
        String strSubstringAfterLast = StringsKt.substringAfterLast(fileName, '.', "");
        String strSubstringBeforeLast = StringsKt.substringBeforeLast(fileName, '.', fileName);
        int i = 1;
        while (file.exists()) {
            if (StringsKt.isBlank(strSubstringAfterLast)) {
                str = strSubstringBeforeLast + LoginConstants.UNDER_LINE + i;
            } else {
                str = strSubstringBeforeLast + LoginConstants.UNDER_LINE + i + Consts.DOT + strSubstringAfterLast;
            }
            i++;
            file = new File(MediaPickerConstants.f8905a.b(), str);
        }
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "targetFile.name");
        return name;
    }

    public final String f(String fileName) {
        return e(StringsKt.substringBeforeLast(fileName, '.', fileName) + "_compressed.jpg");
    }

    public final Bitmap g(Bitmap bitmap, String filePath) {
        try {
            int attributeInt = new ExifInterface(filePath).getAttributeInt("Orientation", 1);
            Matrix matrix = new Matrix();
            if (attributeInt == 2) {
                matrix.postScale(-1.0f, 1.0f);
            } else if (attributeInt == 3) {
                matrix.postRotate(180.0f);
            } else if (attributeInt == 4) {
                matrix.postScale(1.0f, -1.0f);
            } else if (attributeInt == 6) {
                matrix.postRotate(90.0f);
            } else {
                if (attributeInt != 8) {
                    return bitmap;
                }
                matrix.postRotate(270.0f);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(bitmap, 0, …map.height, matrix, true)");
            if (!Intrinsics.areEqual(bitmapCreateBitmap, bitmap) && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    @NotNull
    public final Bitmap h(@NotNull Bitmap bitmap, int maxWidth) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return bitmap;
        }
        if (width <= maxWidth && height <= maxWidth) {
            return bitmap;
        }
        float f = maxWidth;
        float f2 = width;
        float f3 = height;
        float fMin = Math.min(f / f2, f / f3);
        Bitmap bitmapN0 = ImageUtils.N0(bitmap, RangesKt.coerceAtLeast((int) (f2 * fMin), 1), RangesKt.coerceAtLeast((int) (f3 * fMin), 1), false);
        return bitmapN0 == null ? bitmap : bitmapN0;
    }
}
