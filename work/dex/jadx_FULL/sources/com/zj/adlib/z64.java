package com.zj.adlib;

import android.graphics.Bitmap;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class z64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap.Config f46194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AnimatedImageFactory f20990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PlatformDecoder f20991a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46195a;

        static {
            int[] iArr = new int[ImageFormat.values().length];
            f46195a = iArr;
            try {
                iArr[ImageFormat.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46195a[ImageFormat.JPEG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46195a[ImageFormat.GIF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46195a[ImageFormat.WEBP_ANIMATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public z64(AnimatedImageFactory animatedImageFactory, PlatformDecoder platformDecoder, Bitmap.Config config) {
        this.f20990a = animatedImageFactory;
        this.f46194a = config;
        this.f20991a = platformDecoder;
    }

    public CloseableImage a(q13 q13Var, x64 x64Var) {
        return this.f20990a.a(q13Var, x64Var, this.f46194a);
    }

    public CloseableImage b(q13 q13Var, x64 x64Var) {
        InputStream inputStreamQ = q13Var.q();
        if (inputStreamQ == null) {
            return null;
        }
        try {
            return yt3.b(inputStreamQ) ? this.f20990a.b(q13Var, x64Var, this.f46194a) : e(q13Var);
        } finally {
            tm1.b(inputStreamQ);
        }
    }

    public CloseableImage c(q13 q13Var, int i, QualityInfo qualityInfo, x64 x64Var) {
        ImageFormat imageFormatP = q13Var.p();
        if (imageFormatP == null || imageFormatP == ImageFormat.UNKNOWN) {
            imageFormatP = c74.e(q13Var.q());
        }
        int i2 = a.f46195a[imageFormatP.ordinal()];
        if (i2 == 1) {
            throw new IllegalArgumentException("unknown image format");
        }
        if (i2 == 2) {
            return d(q13Var, i, qualityInfo);
        }
        if (i2 != 3) {
            return i2 != 4 ? e(q13Var) : a(q13Var, x64Var);
        }
        return b(q13Var, x64Var);
    }

    public sm1 d(q13 q13Var, int i, QualityInfo qualityInfo) {
        rm1<Bitmap> rm1VarA = this.f20991a.a(q13Var, this.f46194a, i);
        try {
            return new sm1(rm1VarA, qualityInfo, q13Var.r());
        } finally {
            rm1VarA.close();
        }
    }

    public sm1 e(q13 q13Var) {
        rm1<Bitmap> rm1VarB = this.f20991a.b(q13Var, this.f46194a);
        try {
            return new sm1(rm1VarB, p84.f43926a, q13Var.r());
        } finally {
            rm1VarB.close();
        }
    }
}
