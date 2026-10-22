package com.kc.bw.okhttp.convert;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.OkHttp;
import com.kc.bw.okhttp.utils.HttpUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BitmapConvertV2 implements Converter<Bitmap> {
    public static final int MAX_POOL_SIZE = 20;
    public static volatile BitmapConvertV2 sLargeInst;
    public static volatile BitmapPoolMonitor sMonitor;
    public static volatile BitmapConvertV2 sSmallInst;
    public final Bitmap.Config decodeConfig;
    public final int maxHeight;
    public final int maxWidth;
    public final ScaleType scaleType;
    public static final String TAG = dexg.dexa("XN`CjunbqDpowfsuW3");
    public static final long MAX_POOL_BYTES = Runtime.getRuntime().maxMemory() / 8;
    public static final BlockingQueue<Bitmap> POOL = new ArrayBlockingQueue(20);
    public static final AtomicLong POOL_BYTES = new AtomicLong();
    public static int sLargeW = -1;
    public static int sLargeH = -1;
    public static int sSmallW = -1;
    public static int sSmallH = -1;

    /* JADX INFO: renamed from: com.kc.bw.okhttp.convert.BitmapConvertV2$1, reason: invalid class name */
    @Keep
    public static /* synthetic */ class AnonymousClass1 {
        public static final int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Keep
    public interface BitmapPoolMonitor {
        void onHit(Bitmap bitmap);

        void onMiss(int i, int i2, Bitmap.Config config);
    }

    @Keep
    public enum ScaleType {
        CENTER_CROP,
        FIT_XY,
        CENTER_INSIDE
    }

    public BitmapConvertV2(int i, int i2, Bitmap.Config config, ScaleType scaleType) {
        this.maxWidth = i;
        this.maxHeight = i2;
        this.decodeConfig = config;
        this.scaleType = scaleType;
    }

    public static int bytesPerPixel(Bitmap.Config config) {
        int i = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i == 1 || i == 2) {
            return 2;
        }
        return i != 3 ? 4 : 1;
    }

    public static int calculateInSampleSize(int i, int i2, int i3, int i4) {
        return Math.max(1, (int) Math.ceil(Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4))));
    }

    public static boolean canUseForInBitmap(Bitmap bitmap, int i, int i2, Bitmap.Config config) {
        return bitmap.getAllocationByteCount() >= (i * i2) * bytesPerPixel(config) && bitmap.getConfig() == config;
    }

    private Bitmap decode(byte[] bArr) {
        return decodeInternal(bArr, 1);
    }

    private Bitmap decodeInternal(byte[] bArr, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (i2 <= 0 || i3 <= 0) {
            return null;
        }
        int[] desiredSize = getDesiredSize(i2, i3);
        int i4 = desiredSize[0];
        int i5 = desiredSize[1];
        options.inSampleSize = calculateInSampleSize(i2, i3, i4, i5) * i;
        Bitmap.Config config = this.decodeConfig;
        if (config == null) {
            config = hasAlpha(bArr) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        }
        options.inPreferredConfig = config;
        options.inJustDecodeBounds = false;
        options.inMutable = true;
        options.inBitmap = takeFromPool(i4, i5, config);
        try {
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray == null) {
                return bitmapDecodeByteArray;
            }
            if (bitmapDecodeByteArray.getWidth() <= i4 && bitmapDecodeByteArray.getHeight() <= i5) {
                return bitmapDecodeByteArray;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, i4, i5, true);
            if (bitmapCreateScaledBitmap != bitmapDecodeByteArray) {
                offerToPool(bitmapDecodeByteArray);
            }
            return bitmapCreateScaledBitmap;
        } catch (IllegalArgumentException unused) {
            Bitmap bitmap = options.inBitmap;
            if (bitmap != null) {
                POOL.offer(bitmap);
            }
            options.inBitmap = null;
            return decodeInternal(bArr, i);
        } catch (OutOfMemoryError unused2) {
            releasePool();
            i *= 2;
            return decodeInternal(bArr, i);
        }
    }

    public static long getAllocationByteCount(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    public static BitmapConvertV2 getDefaultLarge() {
        if (OkHttp.enableHttpLog) {
            Log.w(TAG, dexg.dexa("hfuEfgbvmuMbshf"));
        }
        int windowWidth = HttpUtils.getWindowWidth();
        int windowHeight = HttpUtils.getWindowHeight();
        if (sLargeInst == null || windowWidth != sLargeW || windowHeight != sLargeH) {
            synchronized (BitmapConvertV2.class) {
                try {
                    if (sLargeInst == null || windowWidth != sLargeW || windowHeight != sLargeH) {
                        sLargeW = windowWidth;
                        sLargeH = windowHeight;
                        sLargeInst = new BitmapConvertV2(Math.min(windowWidth, 720), Math.min(windowHeight, 1280), null, ScaleType.CENTER_CROP);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sLargeInst;
    }

    public static BitmapConvertV2 getDefaultSmall() {
        if (OkHttp.enableHttpLog) {
            Log.w(TAG, dexg.dexa("hfuEfgbvmuTnbmm"));
        }
        int windowWidth = HttpUtils.getWindowWidth();
        int windowHeight = HttpUtils.getWindowHeight();
        if (sSmallInst == null || windowWidth != sSmallW || windowHeight != sSmallH) {
            synchronized (BitmapConvertV2.class) {
                try {
                    if (sSmallInst == null || windowWidth != sSmallW || windowHeight != sSmallH) {
                        sSmallW = windowWidth;
                        sSmallH = windowHeight;
                        sSmallInst = new BitmapConvertV2(Math.min(windowWidth, 200), Math.min(windowHeight, 200), null, ScaleType.CENTER_INSIDE);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sSmallInst;
    }

    private int[] getDesiredSize(int i, int i2) {
        int i3;
        int i4 = this.maxWidth;
        if (i4 == 0 && this.maxHeight == 0) {
            return new int[]{i, i2};
        }
        double d = ((double) i2) / ((double) i);
        int i5 = (int) (((double) i4) * d);
        int i6 = this.maxHeight;
        if (i5 > i6) {
            i3 = (int) (((double) i6) / d);
            i5 = i6;
        } else {
            i3 = i4;
        }
        ScaleType scaleType = this.scaleType;
        if (scaleType == ScaleType.CENTER_CROP) {
            double d2 = i6;
            double d3 = i4;
            if (d > d2 / d3) {
                i4 = (int) (d2 / d);
                i6 = i5;
            } else {
                i6 = (int) (d3 * d);
                i4 = i3;
            }
        } else if (scaleType != ScaleType.FIT_XY) {
            i6 = i5;
            i4 = i3;
        }
        return new int[]{Math.max(1, i4), Math.max(1, i6)};
    }

    public static int getPoolSize() {
        return POOL.size();
    }

    public static boolean hasAlpha(byte[] bArr) {
        if (bArr.length > 25 && bArr[0] == -119 && bArr[1] == 80) {
            return (bArr[25] & 255) >= 4;
        }
        return bArr.length > 12 && bArr[0] == 82 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 70 && bArr[12] == 86 && bArr[13] == 80 && bArr[14] == 56 && bArr[15] == 88;
    }

    public static void offerToPool(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        long allocationByteCount = getAllocationByteCount(bitmap);
        AtomicLong atomicLong = POOL_BYTES;
        if (atomicLong.get() + allocationByteCount > MAX_POOL_BYTES) {
            bitmap.recycle();
        } else if (POOL.offer(bitmap)) {
            atomicLong.addAndGet(allocationByteCount);
        }
    }

    public static void releasePool() {
        for (Bitmap bitmap : POOL) {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        POOL.clear();
        POOL_BYTES.set(0L);
        System.gc();
    }

    public static void setMonitor(BitmapPoolMonitor bitmapPoolMonitor) {
        sMonitor = bitmapPoolMonitor;
    }

    public static Bitmap takeFromPool(int i, int i2, Bitmap.Config config) {
        for (Bitmap bitmap : POOL) {
            if (canUseForInBitmap(bitmap, i, i2, config) && POOL.remove(bitmap)) {
                POOL_BYTES.addAndGet(-getAllocationByteCount(bitmap));
                bitmap.eraseColor(0);
                if (OkHttp.enableHttpLog && sMonitor != null) {
                    sMonitor.onHit(bitmap);
                }
                return bitmap;
            }
        }
        if (!OkHttp.enableHttpLog || sMonitor == null) {
            return null;
        }
        sMonitor.onMiss(i, i2, config);
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kc.bw.okhttp.convert.Converter
    public Bitmap convertResponse(Response response) {
        if (response.body() == null) {
            return null;
        }
        return decode(response.body().bytes());
    }
}
