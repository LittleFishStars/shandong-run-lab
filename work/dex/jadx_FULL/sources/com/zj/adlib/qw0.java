package com.zj.adlib;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Pair;
import androidx.core.util.Pools;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f44313a = 2048.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f19189a = 16384;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pools.SynchronizedPool<ByteBuffer> f19190a = new Pools.SynchronizedPool<>(12);
    public static final int b = 12;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 4;
    public static final int f = 2;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44314a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f44314a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44314a[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44314a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44314a[Bitmap.Config.RGB_565.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Nullable
    public static Pair<Integer, Integer> a(InputStream inputStream) {
        ax6.i(inputStream);
        ByteBuffer byteBufferAcquire = f19190a.acquire();
        if (byteBufferAcquire == null) {
            byteBufferAcquire = ByteBuffer.allocate(16384);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            options.inTempStorage = byteBufferAcquire.array();
            Pair<Integer, Integer> pair = null;
            BitmapFactory.decodeStream(inputStream, null, options);
            if (options.outWidth != -1 && options.outHeight != -1) {
                pair = new Pair<>(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
            }
            return pair;
        } finally {
            f19190a.release(byteBufferAcquire);
        }
    }

    @Nullable
    public static Pair<Integer, Integer> b(byte[] bArr) {
        return a(new ByteArrayInputStream(bArr));
    }

    public static int c(Bitmap.Config config) {
        int i = a.f44314a[config.ordinal()];
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3 || i == 4) {
            return 2;
        }
        throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
    }

    public static int d(int i, int i2, Bitmap.Config config) {
        return i * i2 * c(config);
    }

    @SuppressLint({"NewApi"})
    public static int e(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return bitmap.getByteCount();
        }
    }
}
