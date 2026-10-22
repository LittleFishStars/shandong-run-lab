package com.igexin.push.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.crypt.CryptTools;
import com.getui.gtc.base.http.Call;
import com.getui.gtc.base.http.GtHttpClient;
import com.getui.gtc.base.http.Interceptor;
import com.getui.gtc.base.http.MediaType;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.http.ResponseBody;
import com.getui.gtc.base.util.NetworkUtil;
import com.getui.gtc.base.util.io.IOUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37856a = "GT-ImageLoader";
    private static final GtHttpClient b = new GtHttpClient.Builder().addInterceptor(new Interceptor() { // from class: com.igexin.push.a.e.2
        @Override // com.getui.gtc.base.http.Interceptor
        public final Response intercept(Interceptor.Chain chain) throws IOException {
            byte[] file;
            Request request = chain.request();
            if (!e.f37856a.equals(request.tag())) {
                return chain.proceed(request);
            }
            try {
                File file2 = new File(GtcProvider.context().getCacheDir(), CryptTools.digestToHexString("MD5", request.url().toString().getBytes()));
                if (file2.exists() && (file = IOUtils.readFile(file2)) != null && file.length > 0) {
                    return new Response.Builder().request(request).code(200).body(ResponseBody.create(MediaType.parse("image/cache"), file)).message("cache success").build();
                }
            } catch (Throwable unused) {
            }
            Response responseProceed = chain.proceed(request);
            ResponseBody responseBodyBody = responseProceed.body();
            byte[] bArrBytes = responseBodyBody.bytes();
            try {
                IOUtils.saveToFile(bArrBytes, new File(GtcProvider.context().getCacheDir(), CryptTools.digestToHexString("MD5", request.url().toString().getBytes())));
            } catch (Throwable unused2) {
            }
            return responseProceed.newBuilder().body(ResponseBody.create(responseBodyBody.contentType(), bArrBytes)).build();
        }
    }).addInterceptor(new Interceptor() { // from class: com.igexin.push.a.e.1
        @Override // com.getui.gtc.base.http.Interceptor
        public final Response intercept(Interceptor.Chain chain) throws IOException {
            if (NetworkUtil.isNetWorkAvailable(GtcProvider.context())) {
                return chain.proceed(chain.request());
            }
            throw new IllegalStateException("network is not available");
        }
    }).build();

    public interface a<T> {
        void a(T t);

        void a(Throwable th);
    }

    public static class b<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Handler f37861a = new Handler(Looper.getMainLooper());
        private final a<T> b;

        public b(a<T> aVar) {
            this.b = aVar;
        }

        @Override // com.igexin.push.a.e.a
        public final void a(final T t) {
            if (this.b != null) {
                f37861a.post(new Runnable() { // from class: com.igexin.push.a.e.b.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.b.a(t);
                    }
                });
            }
        }

        @Override // com.igexin.push.a.e.a
        public final void a(final Throwable th) {
            if (this.b != null) {
                f37861a.post(new Runnable() { // from class: com.igexin.push.a.e.b.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.b.a(th);
                    }
                });
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37864a = 20;
        public boolean b = true;
        public boolean c = true;
        public boolean d = true;
        public boolean e = true;
    }

    private static Bitmap a(Resources resources, int i, int i2, int i3, boolean z) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        if (i2 > 0 || i3 > 0) {
            a(i2, i3, options, z);
        }
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, i, options);
        if (bitmapDecodeResource != null) {
            return bitmapDecodeResource;
        }
        throw new IOException("Failed to decode data.");
    }

    public static Bitmap a(Bitmap bitmap, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setFlags(1);
        float f = i;
        canvas.drawRoundRect(new RectF(new Rect(0, 0, width, height)), f, f, paint);
        if (!z) {
            canvas.drawRect(new RectF(0.0f, 0.0f, f, f), paint);
        }
        if (!z2) {
            canvas.drawRect(new RectF(width - i, 0.0f, width, f), paint);
        }
        if (!z3) {
            canvas.drawRect(new RectF(width - i, height - i, width, height), paint);
        }
        if (!z4) {
            canvas.drawRect(new RectF(0.0f, height - i, f, height), paint);
        }
        Paint paint2 = new Paint();
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint2);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    public static Bitmap a(byte[] bArr, int i, int i2, boolean z) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (i > 0 || i2 > 0) {
            a(i, i2, options, z);
        }
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (bitmapDecodeByteArray != null) {
            return bitmapDecodeByteArray;
        }
        throw new IOException("Failed to decode data.");
    }

    private static Movie a(Resources resources, int i) {
        return Movie.decodeStream(resources.openRawResource(i));
    }

    public static Movie a(byte[] bArr) {
        return Movie.decodeByteArray(bArr, 0, bArr.length);
    }

    private static void a(int i, int i2, BitmapFactory.Options options, boolean z) {
        int iMax;
        double d;
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                d = i3 / i;
            } else if (i == 0) {
                d = i4 / i2;
            } else {
                int iFloor = (int) Math.floor(i4 / i2);
                int iFloor2 = (int) Math.floor(i3 / i);
                iMax = z ? Math.max(iFloor, iFloor2) : Math.min(iFloor, iFloor2);
            }
            iMax = (int) Math.floor(d);
        } else {
            iMax = 1;
        }
        options.inSampleSize = iMax;
    }

    public static void a(String str, final int i, a<Bitmap> aVar) {
        final b bVar = new b(aVar);
        b(str, 2, new Call.Callback() { // from class: com.igexin.push.a.e.3
            final /* synthetic */ int c = 0;
            final /* synthetic */ boolean d = true;
            final /* synthetic */ c e = null;

            @Override // com.getui.gtc.base.http.Call.Callback
            public final void onFailure(Call call, Exception exc) {
                bVar.a((Throwable) exc);
            }

            @Override // com.getui.gtc.base.http.Call.Callback
            public final void onResponse(Call call, Response response) {
                int i2;
                try {
                    Bitmap bitmapA = e.a(response.getBody(), i, this.c, this.d);
                    c cVar = this.e;
                    if (cVar != null && (i2 = cVar.f37864a) > 0) {
                        bitmapA = e.a(bitmapA, i2, cVar.b, cVar.c, cVar.d, cVar.e);
                    }
                    if (bitmapA != null) {
                        bVar.a(bitmapA);
                        return;
                    }
                    bVar.a((Throwable) new IllegalStateException("decode bitmap failed:" + call.request()));
                } catch (Throwable th) {
                    bVar.a(th);
                }
            }
        });
    }

    public static void a(String str, a<byte[]> aVar) {
        final b bVar = new b(aVar);
        b(str, 2, new Call.Callback() { // from class: com.igexin.push.a.e.4
            @Override // com.getui.gtc.base.http.Call.Callback
            public final void onFailure(Call call, Exception exc) {
                bVar.a((Throwable) exc);
            }

            @Override // com.getui.gtc.base.http.Call.Callback
            public final void onResponse(Call call, Response response) {
                try {
                    byte[] body = response.getBody();
                    if (body != null) {
                        bVar.a(body);
                        return;
                    }
                    bVar.a((Throwable) new IllegalStateException("decode gif failed:" + call.request()));
                } catch (Throwable th) {
                    bVar.a(th);
                }
            }
        });
    }

    public static boolean a(String str) {
        try {
            return new File(GtcProvider.context().getCacheDir(), CryptTools.digestToHexString("MD5", str.toString().getBytes())).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final String str, final int i, final Call.Callback callback) {
        b.newCall(new Request.Builder().url(str).tag(f37856a).method("GET").build()).enqueue(new Call.Callback() { // from class: com.igexin.push.a.e.6
            @Override // com.getui.gtc.base.http.Call.Callback
            public final void onFailure(Call call, Exception exc) {
                try {
                    if (i <= 0) {
                        callback.onFailure(call, exc);
                    } else {
                        Thread.sleep(500L);
                        e.b(str, i - 1, callback);
                    }
                } catch (Throwable th) {
                    callback.onFailure(call, new RuntimeException(th));
                }
            }

            @Override // com.getui.gtc.base.http.Call.Callback
            public final void onResponse(Call call, Response response) {
                callback.onResponse(call, response);
            }
        });
    }

    public static void b(String str, a<Movie> aVar) {
        final b bVar = new b(aVar);
        b(str, 2, new Call.Callback() { // from class: com.igexin.push.a.e.5
            @Override // com.getui.gtc.base.http.Call.Callback
            public final void onFailure(Call call, Exception exc) {
                bVar.a((Throwable) exc);
            }

            @Override // com.getui.gtc.base.http.Call.Callback
            public final void onResponse(Call call, Response response) {
                try {
                    Movie movieA = e.a(response.getBody());
                    if (movieA != null) {
                        bVar.a(movieA);
                        return;
                    }
                    bVar.a((Throwable) new IllegalStateException("decode gif failed:" + call.request()));
                } catch (Throwable th) {
                    bVar.a(th);
                }
            }
        });
    }
}
