package cj.mobile.wm;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class w5 implements r5<InputStream> {
    public static final Set<com.wangmai.insightvision.openadsdk.image.b.n.k.e.l.a> dexa = EnumSet.of(com.wangmai.insightvision.openadsdk.image.b.n.k.e.l.a.b, com.wangmai.insightvision.openadsdk.image.b.n.k.e.l.a.c, com.wangmai.insightvision.openadsdk.image.b.n.k.e.l.a.d);
    public static final Queue<BitmapFactory.Options> dexb = e9.dexa(0);
    public static final w5 dexc = new dexa();
    public static final w5 dexd = new dexb();
    public static final w5 dexe = new dexc();

    public static class dexa extends w5 {
        @Override // cj.mobile.wm.w5
        public int dexa(int i, int i2, int i3, int i4) {
            return Math.min(i2 / i4, i / i3);
        }

        @Override // cj.mobile.wm.r5
        public String getId() {
            return "AT_LEAST.com.youku.insightvision.sdk.openadsdk.image.glide.load.data.bitmap";
        }
    }

    public static class dexb extends w5 {
        @Override // cj.mobile.wm.w5
        public int dexa(int i, int i2, int i3, int i4) {
            int iCeil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int iMax = Math.max(1, Integer.highestOneBit(iCeil));
            return iMax << (iMax >= iCeil ? 0 : 1);
        }

        @Override // cj.mobile.wm.r5
        public String getId() {
            return "AT_MOST.com.youku.insightvision.sdk.openadsdk.image.glide.load.data.bitmap";
        }
    }

    public static class dexc extends w5 {
        @Override // cj.mobile.wm.w5
        public int dexa(int i, int i2, int i3, int i4) {
            return 0;
        }

        @Override // cj.mobile.wm.r5
        public String getId() {
            return "NONE.com.youku.insightvision.sdk.openadsdk.image.glide.load.data.bitmap";
        }
    }

    private int dexa(int i, int i2, int i3, int i4, int i5) {
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = i2;
        }
        int iDexa = (i == 90 || i == 270) ? dexa(i3, i2, i4, i5) : dexa(i2, i3, i4, i5);
        return Math.max(1, iDexa == 0 ? 0 : Integer.highestOneBit(iDexa));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0050 A[PHI: r6 r7
      0x0050: PHI (r6v4 'e' java.io.IOException) = (r6v3 'e' java.io.IOException), (r6v7 'e' java.io.IOException) binds: [B:25:0x004e, B:12:0x0024] A[DONT_GENERATE, DONT_INLINE]
      0x0050: PHI (r7v5 boolean) = (r7v3 boolean), (r7v7 boolean) binds: [B:25:0x004e, B:12:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    public static Bitmap.Config dexa(InputStream inputStream, com.wangmai.insightvision.openadsdk.image.b.n.a aVar) {
        boolean zF;
        if (aVar == com.wangmai.insightvision.openadsdk.image.b.n.a.a || aVar == com.wangmai.insightvision.openadsdk.image.b.n.a.b) {
            return Bitmap.Config.ARGB_8888;
        }
        inputStream.mark(1024);
        try {
            try {
                zF = new com.wangmai.insightvision.openadsdk.image.b.n.k.e.l(inputStream).f();
                try {
                    inputStream.reset();
                } catch (IOException e) {
                    e = e;
                    if (Log.isLoggable(com.ipd.dsp.internal.q.r.f, 5)) {
                        Log.w(com.ipd.dsp.internal.q.r.f, "Cannot reset the input stream", e);
                    }
                }
            } catch (IOException e2) {
                if (Log.isLoggable(com.ipd.dsp.internal.q.r.f, 5)) {
                    Log.w(com.ipd.dsp.internal.q.r.f, "Cannot determine whether the image has alpha or not from header for format " + aVar, e2);
                }
                zF = false;
                try {
                    inputStream.reset();
                } catch (IOException e3) {
                    e = e3;
                    if (Log.isLoggable(com.ipd.dsp.internal.q.r.f, 5)) {
                        Log.w(com.ipd.dsp.internal.q.r.f, "Cannot reset the input stream", e);
                    }
                }
            }
            return zF ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        } catch (Throwable th) {
            try {
                inputStream.reset();
            } catch (IOException e4) {
                if (Log.isLoggable(com.ipd.dsp.internal.q.r.f, 5)) {
                    Log.w(com.ipd.dsp.internal.q.r.f, "Cannot reset the input stream", e4);
                }
            }
            throw th;
        }
    }

    private Bitmap dexa(c9 c9Var, com.wangmai.insightvision.openadsdk.image.b.n.k.e.o oVar, BitmapFactory.Options options, r3 r3Var, int i, int i2, int i3, com.wangmai.insightvision.openadsdk.image.b.n.a aVar) {
        Bitmap.Config configDexa = dexa(c9Var, aVar);
        options.inSampleSize = i3;
        options.inPreferredConfig = configDexa;
        if (dexa(c9Var)) {
            double d = i3;
            dexa(options, r3Var.dexb((int) Math.ceil(((double) i) / d), (int) Math.ceil(((double) i2) / d), configDexa));
        }
        return dexb(c9Var, oVar, options);
    }

    @TargetApi(11)
    public static synchronized BitmapFactory.Options dexa() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = dexb;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            dexb(optionsPoll);
        }
        return optionsPoll;
    }

    public static void dexa(BitmapFactory.Options options) {
        dexb(options);
        Queue<BitmapFactory.Options> queue = dexb;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    @TargetApi(11)
    public static void dexa(BitmapFactory.Options options, Bitmap bitmap) {
        options.inBitmap = bitmap;
    }

    public static boolean dexa(InputStream inputStream) {
        return true;
    }

    public static Bitmap dexb(c9 c9Var, com.wangmai.insightvision.openadsdk.image.b.n.k.e.o oVar, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            c9Var.mark(5242880);
        } else {
            oVar.g();
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(c9Var, null, options);
        try {
            if (options.inJustDecodeBounds) {
                c9Var.reset();
            }
        } catch (IOException e) {
            if (Log.isLoggable(com.ipd.dsp.internal.q.r.f, 6)) {
                Log.e(com.ipd.dsp.internal.q.r.f, "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e);
            }
        }
        return bitmapDecodeStream;
    }

    @TargetApi(11)
    public static void dexb(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public abstract int dexa(int i, int i2, int i3, int i4);

    /* JADX WARN: Code duplicated, block: B:29:0x0096 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0098 A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:3:0x0028, B:6:0x0036, B:27:0x0065, B:30:0x0098, B:32:0x00a2, B:34:0x00a8, B:39:0x00ba, B:40:0x00bf, B:9:0x003b, B:25:0x0060, B:41:0x00c0, B:48:0x00cf, B:45:0x00c6, B:47:0x00cc, B:19:0x0054, B:22:0x0059, B:5:0x002d, B:16:0x0049, B:18:0x004f), top: B:52:0x0028, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ba A[Catch: all -> 0x00d0, TRY_ENTER, TryCatch #0 {all -> 0x00d0, blocks: (B:3:0x0028, B:6:0x0036, B:27:0x0065, B:30:0x0098, B:32:0x00a2, B:34:0x00a8, B:39:0x00ba, B:40:0x00bf, B:9:0x003b, B:25:0x0060, B:41:0x00c0, B:48:0x00cf, B:45:0x00c6, B:47:0x00cc, B:19:0x0054, B:22:0x0059, B:5:0x002d, B:16:0x0049, B:18:0x004f), top: B:52:0x0028, inners: #1, #2, #3, #4, #5 }] */
    public Bitmap dexa(InputStream inputStream, r3 r3Var, int i, int i2, com.wangmai.insightvision.openadsdk.image.b.n.a aVar) {
        int iA;
        int i3;
        Bitmap bitmapDexa;
        IOException iOExceptionDexa;
        Bitmap bitmapDexa2;
        x8 x8VarDexb = x8.dexb();
        byte[] bArrDexa = x8VarDexb.dexa();
        byte[] bArrDexa2 = x8VarDexb.dexa();
        BitmapFactory.Options optionsDexa = dexa();
        com.wangmai.insightvision.openadsdk.image.b.n.k.e.o oVar = new com.wangmai.insightvision.openadsdk.image.b.n.k.e.o(inputStream, bArrDexa2);
        z8 z8VarDexb = z8.dexb(oVar);
        c9 c9Var = new c9(z8VarDexb);
        try {
            z8VarDexb.mark(5242880);
            try {
                try {
                    iA = new com.wangmai.insightvision.openadsdk.image.b.n.k.e.l(z8VarDexb).a();
                    try {
                        z8VarDexb.reset();
                    } catch (IOException e) {
                        e = e;
                        if (Log.isLoggable(com.ipd.dsp.internal.q.r.f, 5)) {
                            Log.w(com.ipd.dsp.internal.q.r.f, "Cannot reset the input stream", e);
                        }
                    }
                    i3 = iA;
                } catch (IOException e2) {
                    if (Log.isLoggable(com.ipd.dsp.internal.q.r.f, 5)) {
                        Log.w(com.ipd.dsp.internal.q.r.f, "Cannot determine the image orientation from header", e2);
                    }
                    try {
                        z8VarDexb.reset();
                    } catch (IOException e3) {
                        e = e3;
                        if (Log.isLoggable(com.ipd.dsp.internal.q.r.f, 5)) {
                            iA = 0;
                            Log.w(com.ipd.dsp.internal.q.r.f, "Cannot reset the input stream", e);
                            i3 = iA;
                        }
                        optionsDexa.inTempStorage = bArrDexa;
                        int[] iArrDexa = dexa(c9Var, oVar, optionsDexa);
                        int i4 = iArrDexa[0];
                        int i5 = iArrDexa[1];
                        bitmapDexa = dexa(c9Var, oVar, optionsDexa, r3Var, i4, i5, dexa(g6.dexa(i3), i4, i5, i, i2), aVar);
                        iOExceptionDexa = z8VarDexb.dexa();
                        if (iOExceptionDexa == null) {
                            throw new RuntimeException(iOExceptionDexa);
                        }
                        if (bitmapDexa != null) {
                            bitmapDexa2 = g6.dexa(bitmapDexa, r3Var, i3);
                            if (!bitmapDexa.equals(bitmapDexa2)) {
                                bitmapDexa.recycle();
                            }
                        } else {
                            bitmapDexa2 = null;
                        }
                        x8VarDexb.dexa(bArrDexa);
                        x8VarDexb.dexa(bArrDexa2);
                        z8VarDexb.dexb();
                        dexa(optionsDexa);
                        return bitmapDexa2;
                    }
                    i3 = 0;
                }
                optionsDexa.inTempStorage = bArrDexa;
                int[] iArrDexa2 = dexa(c9Var, oVar, optionsDexa);
                int i6 = iArrDexa2[0];
                int i7 = iArrDexa2[1];
                bitmapDexa = dexa(c9Var, oVar, optionsDexa, r3Var, i6, i7, dexa(g6.dexa(i3), i6, i7, i, i2), aVar);
                iOExceptionDexa = z8VarDexb.dexa();
                if (iOExceptionDexa == null) {
                    throw new RuntimeException(iOExceptionDexa);
                }
                if (bitmapDexa != null) {
                    bitmapDexa2 = g6.dexa(bitmapDexa, r3Var, i3);
                    if (!bitmapDexa.equals(bitmapDexa2) && !r3Var.a(bitmapDexa)) {
                        bitmapDexa.recycle();
                    }
                } else {
                    bitmapDexa2 = null;
                }
                x8VarDexb.dexa(bArrDexa);
                x8VarDexb.dexa(bArrDexa2);
                z8VarDexb.dexb();
                dexa(optionsDexa);
                return bitmapDexa2;
            } catch (Throwable th) {
                try {
                    z8VarDexb.reset();
                    throw th;
                } catch (IOException e4) {
                    if (!Log.isLoggable(com.ipd.dsp.internal.q.r.f, 5)) {
                        throw th;
                    }
                    Log.w(com.ipd.dsp.internal.q.r.f, "Cannot reset the input stream", e4);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            x8VarDexb.dexa(bArrDexa);
            x8VarDexb.dexa(bArrDexa2);
            z8VarDexb.dexb();
            dexa(optionsDexa);
            throw th2;
        }
    }

    public int[] dexa(c9 c9Var, com.wangmai.insightvision.openadsdk.image.b.n.k.e.o oVar, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        dexb(c9Var, oVar, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }
}
