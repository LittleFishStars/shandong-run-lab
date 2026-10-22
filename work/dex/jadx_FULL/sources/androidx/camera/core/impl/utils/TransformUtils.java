package androidx.camera.core.impl.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class TransformUtils {
    public static final RectF NORMALIZED_RECT = new RectF(-1.0f, -1.0f, 1.0f, 1.0f);

    private TransformUtils() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public static Matrix getExifTransform(int i, int i2, int i3) {
        Matrix matrix = new Matrix();
        float f = i2;
        float f2 = i3;
        RectF rectF = new RectF(0.0f, 0.0f, f, f2);
        RectF rectF2 = NORMALIZED_RECT;
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
        boolean z = true;
        switch (i) {
            case 2:
                matrix.postScale(-1.0f, 1.0f);
                z = false;
                break;
            case 3:
                matrix.postRotate(180.0f);
                z = false;
                break;
            case 4:
                matrix.postScale(1.0f, -1.0f);
                z = false;
                break;
            case 5:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(270.0f);
                break;
            case 6:
                matrix.postRotate(90.0f);
                break;
            case 7:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(90.0f);
                break;
            case 8:
                matrix.postRotate(270.0f);
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            rectF = new RectF(0.0f, 0.0f, f2, f);
        }
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.FILL);
        matrix.postConcat(matrix2);
        return matrix;
    }

    @NonNull
    public static Matrix getNormalizedToBuffer(@NonNull Rect rect) {
        return getNormalizedToBuffer(new RectF(rect));
    }

    @NonNull
    public static Matrix getRectToRect(@NonNull RectF rectF, @NonNull RectF rectF2, int i) {
        return getRectToRect(rectF, rectF2, i, false);
    }

    @NonNull
    public static Size getRotatedSize(@NonNull Rect rect, int i) {
        return rotateSize(rectToSize(rect), i);
    }

    public static boolean hasCropping(@NonNull Rect rect, @NonNull Size size) {
        return (rect.left == 0 && rect.top == 0 && rect.width() == size.getWidth() && rect.height() == size.getHeight()) ? false : true;
    }

    public static boolean is90or270(int i) {
        if (i == 90 || i == 270) {
            return true;
        }
        if (i == 0 || i == 180) {
            return false;
        }
        throw new IllegalArgumentException("Invalid rotation degrees: " + i);
    }

    public static boolean isAspectRatioMatchingWithRoundingError(@NonNull Size size, @NonNull Size size2) {
        return isAspectRatioMatchingWithRoundingError(size, false, size2, false);
    }

    public static float max(float f, float f2, float f3, float f4) {
        return Math.max(Math.max(f, f2), Math.max(f3, f4));
    }

    public static float min(float f, float f2, float f3, float f4) {
        return Math.min(Math.min(f, f2), Math.min(f3, f4));
    }

    @NonNull
    public static Size rectToSize(@NonNull Rect rect) {
        return new Size(rect.width(), rect.height());
    }

    @NonNull
    public static String rectToString(@NonNull Rect rect) {
        return String.format(Locale.US, "%s(%dx%d)", rect, Integer.valueOf(rect.width()), Integer.valueOf(rect.height()));
    }

    @NonNull
    public static float[] rectToVertices(@NonNull RectF rectF) {
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        return new float[]{f, f2, f3, f2, f3, f4, f, f4};
    }

    @NonNull
    public static Size reverseSize(@NonNull Size size) {
        return new Size(size.getHeight(), size.getWidth());
    }

    @NonNull
    public static SizeF reverseSizeF(@NonNull SizeF sizeF) {
        return new SizeF(sizeF.getHeight(), sizeF.getWidth());
    }

    @NonNull
    public static RectF rotateRect(@NonNull RectF rectF, int i) {
        Preconditions.checkArgument(i % 90 == 0, "Invalid rotation degrees: " + i);
        return is90or270(within360(i)) ? new RectF(0.0f, 0.0f, rectF.height(), rectF.width()) : rectF;
    }

    @NonNull
    public static Size rotateSize(@NonNull Size size, int i) {
        Preconditions.checkArgument(i % 90 == 0, "Invalid rotation degrees: " + i);
        return is90or270(within360(i)) ? reverseSize(size) : size;
    }

    @NonNull
    public static Rect sizeToRect(@NonNull Size size) {
        return sizeToRect(size, 0, 0);
    }

    @NonNull
    public static RectF sizeToRectF(@NonNull Size size) {
        return sizeToRectF(size, 0, 0);
    }

    @NonNull
    public static float[] sizeToVertices(@NonNull Size size) {
        return new float[]{0.0f, 0.0f, size.getWidth(), 0.0f, size.getWidth(), size.getHeight(), 0.0f, size.getHeight()};
    }

    @NonNull
    public static Matrix updateSensorToBufferTransform(@NonNull Matrix matrix, @NonNull Rect rect) {
        Matrix matrix2 = new Matrix(matrix);
        matrix2.postTranslate(-rect.left, -rect.top);
        return matrix2;
    }

    @NonNull
    public static RectF verticesToRect(@NonNull float[] fArr) {
        return new RectF(min(fArr[0], fArr[2], fArr[4], fArr[6]), min(fArr[1], fArr[3], fArr[5], fArr[7]), max(fArr[0], fArr[2], fArr[4], fArr[6]), max(fArr[1], fArr[3], fArr[5], fArr[7]));
    }

    public static int within360(int i) {
        return ((i % 360) + 360) % 360;
    }

    @NonNull
    public static Matrix getNormalizedToBuffer(@NonNull RectF rectF) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(NORMALIZED_RECT, rectF, Matrix.ScaleToFit.FILL);
        return matrix;
    }

    @NonNull
    public static Matrix getRectToRect(@NonNull RectF rectF, @NonNull RectF rectF2, int i, boolean z) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
        matrix.postRotate(i);
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
        }
        matrix.postConcat(getNormalizedToBuffer(rectF2));
        return matrix;
    }

    public static boolean isAspectRatioMatchingWithRoundingError(@NonNull Size size, boolean z, @NonNull Size size2, boolean z2) {
        float width;
        float width2;
        float width3;
        float f;
        if (z) {
            width = size.getWidth() / size.getHeight();
            width2 = width;
        } else {
            width = (size.getWidth() + 1.0f) / (size.getHeight() - 1.0f);
            width2 = (size.getWidth() - 1.0f) / (size.getHeight() + 1.0f);
        }
        if (z2) {
            width3 = size2.getWidth() / size2.getHeight();
            f = width3;
        } else {
            float width4 = (size2.getWidth() + 1.0f) / (size2.getHeight() - 1.0f);
            width3 = (size2.getWidth() - 1.0f) / (size2.getHeight() + 1.0f);
            f = width4;
        }
        return width >= width3 && f >= width2;
    }

    @NonNull
    public static Rect sizeToRect(@NonNull Size size, int i, int i2) {
        return new Rect(i, i2, size.getWidth() + i, size.getHeight() + i2);
    }

    @NonNull
    public static RectF sizeToRectF(@NonNull Size size, int i, int i2) {
        return new RectF(i, i2, i + size.getWidth(), i2 + size.getHeight());
    }
}
