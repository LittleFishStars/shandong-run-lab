package com.kc.dw.ad.view.scaleImage.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.kc.dw.ad.view.scaleImage.SubsamplingScaleImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SkiaImageRegionDecoder implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BitmapRegionDecoder f39208a;
    public final ReadWriteLock b;
    public final Bitmap.Config c;

    public SkiaImageRegionDecoder() {
        this(null);
    }

    public SkiaImageRegionDecoder(Bitmap.Config config) {
        this.b = new ReentrantReadWriteLock(true);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        this.c = preferredBitmapConfig == null ? Bitmap.Config.RGB_565 : preferredBitmapConfig;
    }

    @Override // com.kc.dw.ad.view.scaleImage.decoder.d
    public Bitmap a(Rect rect, int i) {
        c().lock();
        try {
            BitmapRegionDecoder bitmapRegionDecoder = this.f39208a;
            if (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) {
                throw new IllegalStateException("Cannot decode region after decoder has been recycled");
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i;
            options.inPreferredConfig = this.c;
            Bitmap bitmapDecodeRegion = this.f39208a.decodeRegion(rect, options);
            if (bitmapDecodeRegion == null) {
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
            c().unlock();
            return bitmapDecodeRegion;
        } catch (Throwable th) {
            c().unlock();
            throw th;
        }
    }

    @Override // com.kc.dw.ad.view.scaleImage.decoder.d
    public Point a(Context context, Uri uri) throws Exception {
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        InputStream inputStreamOpen;
        int identifier;
        String string = uri.toString();
        if (!string.startsWith("android.resource://")) {
            if (string.startsWith(com.ipd.dsp.internal.n.a.d)) {
                inputStreamOpen = context.getAssets().open(string.substring(22), 1);
            } else if (string.startsWith("file://")) {
                bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(string.substring(7), false);
                this.f39208a = bitmapRegionDecoderNewInstance;
            } else {
                InputStream inputStream = null;
                try {
                    InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    if (inputStreamOpenInputStream == null) {
                        throw new Exception("Content resolver returned null stream. Unable to initialise with uri.");
                    }
                    this.f39208a = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
            return new Point(this.f39208a.getWidth(), this.f39208a.getHeight());
        }
        String authority = uri.getAuthority();
        Resources resources = context.getPackageName().equals(authority) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
        List<String> pathSegments = uri.getPathSegments();
        int size = pathSegments.size();
        if (size == 2 && pathSegments.get(0).equals("drawable")) {
            identifier = resources.getIdentifier(pathSegments.get(1), "drawable", authority);
        } else if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
            try {
                identifier = Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused3) {
                identifier = 0;
            }
        } else {
            identifier = 0;
        }
        inputStreamOpen = context.getResources().openRawResource(identifier);
        bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStreamOpen, false);
        this.f39208a = bitmapRegionDecoderNewInstance;
        return new Point(this.f39208a.getWidth(), this.f39208a.getHeight());
    }

    @Override // com.kc.dw.ad.view.scaleImage.decoder.d
    public boolean a() {
        boolean z;
        synchronized (this) {
            BitmapRegionDecoder bitmapRegionDecoder = this.f39208a;
            z = (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) ? false : true;
        }
        return z;
    }

    @Override // com.kc.dw.ad.view.scaleImage.decoder.d
    public void b() {
        synchronized (this) {
            this.b.writeLock().lock();
            try {
                this.f39208a.recycle();
                this.f39208a = null;
                this.b.writeLock().unlock();
            } catch (Throwable th) {
                this.b.writeLock().unlock();
                throw th;
            }
        }
    }

    public final Lock c() {
        return this.b.readLock();
    }
}
