package com.czhj.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.ParseError;
import com.czhj.volley.Request;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ImageRequest extends Request<Bitmap> {
    public static final float DEFAULT_IMAGE_BACKOFF_MULT = 2.0f;
    public static final int DEFAULT_IMAGE_MAX_RETRIES = 2;
    public static final int DEFAULT_IMAGE_TIMEOUT_MS = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f29495a = new Object();
    private final Object b;
    private final Bitmap.Config c;
    private final int d;
    private final int e;
    private final ImageView.ScaleType f;
    private Response.Listener<Bitmap> g;

    @Deprecated
    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i, int i2, Bitmap.Config config, Response.ErrorListener errorListener) {
        this(str, listener, i, i2, ImageView.ScaleType.CENTER_INSIDE, config, errorListener);
    }

    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, Response.ErrorListener errorListener) {
        super(0, str, errorListener);
        this.b = new Object();
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.g = listener;
        this.c = config;
        this.d = i;
        this.e = i2;
        this.f = scaleType;
    }

    public static int a(int i, int i2, int i3, int i4) {
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

    private static int a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
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

    private Response<Bitmap> a(NetworkResponse networkResponse) {
        Bitmap bitmapDecodeByteArray;
        byte[] bArr = networkResponse.data;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.d == 0 && this.e == 0) {
            options.inPreferredConfig = this.c;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int iA = a(this.d, this.e, i, i2, this.f);
            int iA2 = a(this.e, this.d, i2, i, this.f);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i, i2, iA, iA2);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iA || bitmapDecodeByteArray.getHeight() > iA2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iA, iA2, true);
                bitmapDecodeByteArray.recycle();
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        return bitmapDecodeByteArray == null ? Response.error(new ParseError(networkResponse)) : Response.success(bitmapDecodeByteArray, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    @Override // com.czhj.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.b) {
            this.g = null;
        }
    }

    @Override // com.czhj.volley.Request
    public void deliverResponse(Bitmap bitmap) {
        Response.Listener<Bitmap> listener;
        synchronized (this.b) {
            listener = this.g;
        }
        if (listener != null) {
            listener.onResponse(bitmap);
        }
    }

    @Override // com.czhj.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    @Override // com.czhj.volley.Request
    public Response<Bitmap> parseNetworkResponse(NetworkResponse networkResponse) {
        Response<Bitmap> responseA;
        synchronized (f29495a) {
            try {
                try {
                    responseA = a(networkResponse);
                } catch (OutOfMemoryError e) {
                    VolleyLog.e("Caught OOM for %d byte image, url=%s", Integer.valueOf(networkResponse.data.length), getUrl());
                    return Response.error(new ParseError(e));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return responseA;
    }
}
