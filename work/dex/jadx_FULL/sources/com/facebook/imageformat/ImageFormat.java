package com.facebook.imageformat;

import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.fl.saas.common.util.FileTypeUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public enum ImageFormat {
    WEBP_SIMPLE,
    WEBP_LOSSLESS,
    WEBP_EXTENDED,
    WEBP_EXTENDED_WITH_ALPHA,
    WEBP_ANIMATED,
    JPEG,
    PNG,
    GIF,
    BMP,
    UNKNOWN;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29981a;

        static {
            int[] iArr = new int[ImageFormat.values().length];
            f29981a = iArr;
            try {
                iArr[ImageFormat.WEBP_SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29981a[ImageFormat.WEBP_LOSSLESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29981a[ImageFormat.WEBP_EXTENDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29981a[ImageFormat.WEBP_EXTENDED_WITH_ALPHA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29981a[ImageFormat.WEBP_ANIMATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29981a[ImageFormat.JPEG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29981a[ImageFormat.PNG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f29981a[ImageFormat.GIF.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f29981a[ImageFormat.BMP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static String getFileExtension(ImageFormat imageFormat) throws UnsupportedOperationException {
        switch (a.f29981a[imageFormat.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return "webp";
            case 6:
                return AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG;
            case 7:
                return "png";
            case 8:
                return FileTypeUtils.FILE_TYPE_GIF;
            case 9:
                return FileTypeUtils.FILE_TYPE_BMP;
            default:
                throw new UnsupportedOperationException("Unknown image format " + imageFormat.name());
        }
    }

    public static boolean isWebpFormat(ImageFormat imageFormat) {
        return imageFormat == WEBP_SIMPLE || imageFormat == WEBP_LOSSLESS || imageFormat == WEBP_EXTENDED || imageFormat == WEBP_EXTENDED_WITH_ALPHA || imageFormat == WEBP_ANIMATED;
    }
}
