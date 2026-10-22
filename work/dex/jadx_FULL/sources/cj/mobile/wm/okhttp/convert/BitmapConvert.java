package cj.mobile.wm.okhttp.convert;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.OkHttp;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class BitmapConvert implements Converter<Bitmap> {
    public final String TAG;
    public Bitmap.Config decodeConfig;
    public boolean enableScale;
    public int maxHeight;
    public int maxWidth;
    public ImageView.ScaleType scaleType;

    public BitmapConvert() {
        this(1000, 1000, Bitmap.Config.RGB_565, ImageView.ScaleType.CENTER_INSIDE);
    }

    public BitmapConvert(int i, int i2) {
        this(i, i2, Bitmap.Config.ARGB_8888, ImageView.ScaleType.CENTER_INSIDE);
    }

    public BitmapConvert(int i, int i2, Bitmap.Config config, ImageView.ScaleType scaleType) {
        this.TAG = dexc.dexa("XN`") + BitmapConvert.class.getSimpleName();
        this.enableScale = false;
        this.maxWidth = i;
        this.maxHeight = i2;
        this.decodeConfig = config;
        this.scaleType = scaleType;
    }

    public static int findBestSampleSize(int i, int i2, int i3, int i4) {
        double dMin = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > dMin) {
                return (int) f;
            }
            f = f2;
        }
    }

    public static int getResizedDimension(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d2 = i2;
            return ((double) i) * d < d2 ? (int) (d2 / d) : i;
        }
        double d3 = i2;
        return ((double) i) * d > d3 ? (int) (d3 / d) : i;
    }

    private Bitmap parse(byte[] bArr) {
        int resizedDimension;
        int resizedDimension2;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (this.maxWidth == 0 && this.maxHeight == 0) {
                options.inPreferredConfig = this.decodeConfig;
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            if (OkHttp.enableHttpLog) {
                Log.w(this.TAG, dexc.dexa("nbufsjbm!bduvbm!tj{f!") + i + dexc.dexa("y") + i2);
            }
            if (this.enableScale) {
                resizedDimension = getResizedDimension(this.maxWidth, this.maxHeight, i, i2, this.scaleType);
                resizedDimension2 = getResizedDimension(this.maxHeight, this.maxWidth, i2, i, this.scaleType);
            } else {
                resizedDimension = i;
                resizedDimension2 = i2;
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = findBestSampleSize(i, i2, resizedDimension, resizedDimension2);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray == null) {
                return bitmapDecodeByteArray;
            }
            if (bitmapDecodeByteArray.getWidth() <= resizedDimension && bitmapDecodeByteArray.getHeight() <= resizedDimension2) {
                return bitmapDecodeByteArray;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, resizedDimension, resizedDimension2, true);
            bitmapDecodeByteArray.recycle();
            return bitmapCreateScaledBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            Log.w(this.TAG, dexc.dexa("qbstf!cjunbq!fssps;") + th);
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cj.mobile.wm.okhttp.convert.Converter
    public Bitmap convertResponse(Response response) {
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            return null;
        }
        return parse(responseBodyBody.bytes());
    }
}
