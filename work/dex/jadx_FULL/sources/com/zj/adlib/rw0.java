package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import androidx.exifinterface.media.ExifInterface;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.blankj.utilcode.util.ImageUtils;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u000f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¨\u0006\u0015"}, d2 = {"Lcom/zj/adlib/rw0;", "", "", "filePath", "", "maxSize", "Landroid/graphics/Bitmap;", "a", "Lcom/zj/adlib/xa9;", AliyunLogCommon.LogLevel.INFO, "maxWidth", "maxHeight", "", "d", "orientation", "c", "b", "bitmap", "e", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBitmapUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BitmapUtil.kt\ncom/huachenjie/base/aliyun/detect_face/util/BitmapUtil\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,165:1\n77#2:166\n*S KotlinDebug\n*F\n+ 1 BitmapUtil.kt\ncom/huachenjie/base/aliyun/detect_face/util/BitmapUtil\n*L\n163#1:166\n*E\n"})
public final class rw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final rw0 f44555a = new rw0();

    @Nullable
    public final Bitmap a(@NotNull String filePath, int maxSize) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            Bitmap bitmapZ = ImageUtils.Z(filePath, maxSize, maxSize);
            if (bitmapZ == null) {
                return null;
            }
            return c(bitmapZ, new ExifInterface(filePath).getAttributeInt("Orientation", 1));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Bitmap b(TrackingInfo info) {
        try {
            YuvImage yuvImage = new YuvImage(info.h(), 17, info.l(), info.j(), null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((info.l() * info.j()) / 2);
            yuvImage.compressToJpeg(new Rect(0, 0, info.l(), info.j()), 92, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Bitmap c(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
            default:
                return bitmap;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(this, 0, 0,…th, height, matrix, true)");
            if (!Intrinsics.areEqual(bitmapCreateBitmap, bitmap)) {
                bitmap.recycle();
            }
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    public final void d(@NotNull TrackingInfo info, int maxWidth, int maxHeight, @NotNull String filePath) {
        boolean zAreEqual;
        Intrinsics.checkNotNullParameter(info, AliyunLogCommon.LogLevel.INFO);
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Bitmap bitmapB = b(info);
        if (bitmapB == null) {
            return;
        }
        Bitmap bitmapE = e(bitmapB, maxWidth, maxHeight);
        try {
            ImageUtils.z0(bitmapE, filePath, Bitmap.CompressFormat.JPEG, 80);
            if (zAreEqual) {
                return;
            }
        } finally {
            if (!bitmapB.isRecycled()) {
                bitmapB.recycle();
            }
            if (!Intrinsics.areEqual(bitmapE, bitmapB) && !bitmapE.isRecycled()) {
                bitmapE.recycle();
            }
        }
    }

    public final Bitmap e(Bitmap bitmap, int maxWidth, int maxHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= maxWidth && height <= maxHeight) {
            return bitmap;
        }
        float f = width;
        float f2 = height;
        float fMin = Math.min(maxWidth / f, maxHeight / f2);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (f * fMin), (int) (f2 * fMin), true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }
}
