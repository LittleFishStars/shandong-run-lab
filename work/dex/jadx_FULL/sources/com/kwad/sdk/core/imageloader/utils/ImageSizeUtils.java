package com.kwad.sdk.core.imageloader.utils;

import android.opengl.GLES10;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ImageSizeUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    /* JADX INFO: renamed from: com.kwad.sdk.core.imageloader.utils.ImageSizeUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType;

        static {
            int[] iArr = new int[ViewScaleType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType = iArr;
            try {
                iArr[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[ViewScaleType.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int iMax = Math.max(iArr[0], 2048);
        maxBitmapSize = new ImageSize(iMax, iMax);
    }

    private ImageSizeUtils() {
    }

    public static int computeImageSampleSize(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        int iMax;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        int i = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[viewScaleType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                iMax = 1;
            } else if (z) {
                int i2 = width / 2;
                int i3 = height / 2;
                iMax = 1;
                while (i2 / iMax > width2 && i3 / iMax > height2) {
                    iMax *= 2;
                }
            } else {
                iMax = Math.min(width / width2, height / height2);
            }
        } else if (z) {
            int i4 = width / 2;
            int i5 = height / 2;
            iMax = 1;
            while (true) {
                if (i4 / iMax <= width2 && i5 / iMax <= height2) {
                    break;
                }
                iMax *= 2;
            }
        } else {
            iMax = Math.max(width / width2, height / height2);
        }
        return considerMaxTextureSize(width, height, iMax > 0 ? iMax : 1, z);
    }

    public static float computeImageScale(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        float f = width;
        float f2 = f / width2;
        float f3 = height;
        float f4 = f3 / height2;
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f2 < f4) && (viewScaleType != ViewScaleType.CROP || f2 >= f4)) {
            width2 = (int) (f / f4);
        } else {
            height2 = (int) (f3 / f2);
        }
        if ((z || width2 >= width || height2 >= height) && (!z || width2 == width || height2 == height)) {
            return 1.0f;
        }
        return width2 / f;
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        return Math.max((int) Math.ceil(imageSize.getWidth() / maxBitmapSize.getWidth()), (int) Math.ceil(imageSize.getHeight() / maxBitmapSize.getHeight()));
    }

    private static int considerMaxTextureSize(int i, int i2, int i3, boolean z) {
        int width = maxBitmapSize.getWidth();
        int height = maxBitmapSize.getHeight();
        while (true) {
            if (i / i3 <= width && i2 / i3 <= height) {
                return i3;
            }
            i3 = z ? i3 * 2 : i3 + 1;
        }
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize imageSize) {
        int width = imageAware.getWidth();
        if (width <= 0) {
            width = imageSize.getWidth();
        }
        int height = imageAware.getHeight();
        if (height <= 0) {
            height = imageSize.getHeight();
        }
        return new ImageSize(width, height);
    }
}
