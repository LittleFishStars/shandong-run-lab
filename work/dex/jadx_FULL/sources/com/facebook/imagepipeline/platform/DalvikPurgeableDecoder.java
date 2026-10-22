package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.ipd.dsp.internal.q.u;
import com.zj.adlib.ax6;
import com.zj.adlib.bw0;
import com.zj.adlib.cw0;
import com.zj.adlib.i69;
import com.zj.adlib.q13;
import com.zj.adlib.rm1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class DalvikPurgeableDecoder implements PlatformDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f30002a = {-1, u.D7};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final bw0 f1657a = cw0.a();

    public static BitmapFactory.Options c(int i, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i;
        options.inMutable = true;
        return options;
    }

    public static boolean endsWithEOI(rm1<PooledByteBuffer> rm1Var, int i) {
        PooledByteBuffer pooledByteBufferS = rm1Var.s();
        return i >= 2 && pooledByteBufferS.z(i + (-2)) == -1 && pooledByteBufferS.z(i - 1) == -39;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public rm1<Bitmap> a(q13 q13Var, Bitmap.Config config, int i) {
        BitmapFactory.Options optionsC = c(q13Var.s(), config);
        rm1<PooledByteBuffer> rm1VarL = q13Var.l();
        ax6.i(rm1VarL);
        try {
            return d(decodeJPEGByteArrayAsPurgeable(rm1VarL, i, optionsC));
        } finally {
            rm1.p(rm1VarL);
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public rm1<Bitmap> b(q13 q13Var, Bitmap.Config config) {
        BitmapFactory.Options optionsC = c(q13Var.s(), config);
        rm1<PooledByteBuffer> rm1VarL = q13Var.l();
        ax6.i(rm1VarL);
        try {
            return d(decodeByteArrayAsPurgeable(rm1VarL, optionsC));
        } finally {
            rm1.p(rm1VarL);
        }
    }

    public rm1<Bitmap> d(Bitmap bitmap) {
        try {
            Bitmaps.c(bitmap);
            if (this.f1657a.f(bitmap)) {
                return rm1.J(bitmap, this.f1657a.d());
            }
            bitmap.recycle();
            throw new TooManyBitmapsException();
        } catch (Exception e) {
            bitmap.recycle();
            throw i69.d(e);
        }
    }

    public abstract Bitmap decodeByteArrayAsPurgeable(rm1<PooledByteBuffer> rm1Var, BitmapFactory.Options options);

    public abstract Bitmap decodeJPEGByteArrayAsPurgeable(rm1<PooledByteBuffer> rm1Var, int i, BitmapFactory.Options options);
}
