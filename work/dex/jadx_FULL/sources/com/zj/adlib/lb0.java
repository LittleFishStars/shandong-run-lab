package com.zj.adlib;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.ipd.dsp.internal.q.u;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
@TargetApi(21)
public class lb0 implements PlatformDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43029a = 16384;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f17913a = {-1, u.D7};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final Pools.SynchronizedPool<ByteBuffer> f17914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nw0 f17915a;

    public lb0(nw0 nw0Var, int i) {
        this.f17915a = nw0Var;
        this.f17914a = new Pools.SynchronizedPool<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.f17914a.release(ByteBuffer.allocate(16384));
        }
    }

    public static BitmapFactory.Options d(q13 q13Var, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = q13Var.s();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(q13Var.q(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public rm1<Bitmap> a(q13 q13Var, Bitmap.Config config, int i) {
        boolean zY = q13Var.y(i);
        BitmapFactory.Options optionsD = d(q13Var, config);
        InputStream inputStreamQ = q13Var.q();
        ax6.i(inputStreamQ);
        if (q13Var.v() > i) {
            inputStreamQ = new ux4(inputStreamQ, i);
        }
        if (!zY) {
            inputStreamQ = new f09(inputStreamQ, f17913a);
        }
        boolean z = optionsD.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return c(inputStreamQ, optionsD);
        } catch (RuntimeException e) {
            if (z) {
                return b(q13Var, Bitmap.Config.ARGB_8888);
            }
            throw e;
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public rm1<Bitmap> b(q13 q13Var, Bitmap.Config config) {
        BitmapFactory.Options optionsD = d(q13Var, config);
        boolean z = optionsD.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return c(q13Var.q(), optionsD);
        } catch (RuntimeException e) {
            if (z) {
                return b(q13Var, Bitmap.Config.ARGB_8888);
            }
            throw e;
        }
    }

    public final rm1<Bitmap> c(InputStream inputStream, BitmapFactory.Options options) throws Throwable {
        ax6.i(inputStream);
        Bitmap bitmap = this.f17915a.get(qw0.d(options.outWidth, options.outHeight, options.inPreferredConfig));
        if (bitmap == null) {
            throw new NullPointerException("BitmapPool.get returned null");
        }
        options.inBitmap = bitmap;
        ByteBuffer byteBufferAcquire = this.f17914a.acquire();
        if (byteBufferAcquire == null) {
            byteBufferAcquire = ByteBuffer.allocate(16384);
        }
        try {
            try {
                options.inTempStorage = byteBufferAcquire.array();
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                this.f17914a.release(byteBufferAcquire);
                if (bitmap == bitmapDecodeStream) {
                    return rm1.J(bitmapDecodeStream, this.f17915a);
                }
                this.f17915a.a(bitmap);
                bitmapDecodeStream.recycle();
                throw new IllegalStateException();
            } catch (RuntimeException e) {
                this.f17915a.a(bitmap);
                throw e;
            }
        } catch (Throwable th) {
            this.f17914a.release(byteBufferAcquire);
            throw th;
        }
    }
}
