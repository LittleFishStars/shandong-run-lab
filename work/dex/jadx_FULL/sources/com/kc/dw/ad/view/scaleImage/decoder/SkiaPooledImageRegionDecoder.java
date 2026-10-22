package com.kc.dw.ad.view.scaleImage.decoder;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.kc.dw.ad.view.scaleImage.SubsamplingScaleImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SkiaPooledImageRegionDecoder implements d {
    public static boolean i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f39209a;
    public final ReadWriteLock b;
    public final Bitmap.Config c;
    public Context d;
    public Uri e;
    public long f;
    public final Point g;
    public final AtomicBoolean h;

    @Keep
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Semaphore f39210a;
        public final Map<BitmapRegionDecoder, Boolean> b;

        public a() {
            this.f39210a = new Semaphore(0, true);
            this.b = new ConcurrentHashMap();
        }

        public /* synthetic */ a(e eVar) {
            this();
        }

        public static void a(a aVar, BitmapRegionDecoder bitmapRegionDecoder) {
            boolean z;
            synchronized (aVar) {
                Iterator<Map.Entry<BitmapRegionDecoder, Boolean>> it = aVar.b.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<BitmapRegionDecoder, Boolean> next = it.next();
                        if (bitmapRegionDecoder == next.getKey()) {
                            if (next.getValue().booleanValue()) {
                                next.setValue(Boolean.FALSE);
                                z = true;
                            }
                        }
                    }
                    z = false;
                }
            }
            if (z) {
                aVar.f39210a.release();
            }
        }

        public final BitmapRegionDecoder a() {
            this.f39210a.acquireUninterruptibly();
            synchronized (this) {
                for (Map.Entry<BitmapRegionDecoder, Boolean> entry : this.b.entrySet()) {
                    if (!entry.getValue().booleanValue()) {
                        entry.setValue(Boolean.TRUE);
                        return entry.getKey();
                    }
                }
                return null;
            }
        }
    }

    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config config) {
        this.f39209a = new a(null);
        this.b = new ReentrantReadWriteLock(true);
        this.f = Long.MAX_VALUE;
        this.g = new Point(0, 0);
        this.h = new AtomicBoolean(false);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        this.c = preferredBitmapConfig == null ? Bitmap.Config.RGB_565 : preferredBitmapConfig;
    }

    public static void setDebug(boolean z) {
        i = z;
    }

    @Override // com.kc.dw.ad.view.scaleImage.decoder.d
    public Bitmap a(Rect rect, int i2) {
        a("Decode region " + rect + " on thread " + Thread.currentThread().getName());
        if ((rect.width() < this.g.x || rect.height() < this.g.y) && this.h.compareAndSet(false, true) && this.f < Long.MAX_VALUE) {
            a("Starting lazy init of additional decoders");
            new e(this).start();
        }
        this.b.readLock().lock();
        try {
            a aVar = this.f39209a;
            if (aVar != null) {
                BitmapRegionDecoder bitmapRegionDecoderA = aVar.a();
                if (bitmapRegionDecoderA != null) {
                    try {
                        if (!bitmapRegionDecoderA.isRecycled()) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inSampleSize = i2;
                            options.inPreferredConfig = this.c;
                            Bitmap bitmapDecodeRegion = bitmapRegionDecoderA.decodeRegion(rect, options);
                            if (bitmapDecodeRegion == null) {
                                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                            }
                            a.a(this.f39209a, bitmapRegionDecoderA);
                            this.b.readLock().unlock();
                            return bitmapDecodeRegion;
                        }
                    } catch (Throwable th) {
                        a.a(this.f39209a, bitmapRegionDecoderA);
                        throw th;
                    }
                }
                if (bitmapRegionDecoderA != null) {
                    a.a(this.f39209a, bitmapRegionDecoderA);
                }
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } catch (Throwable th2) {
            this.b.readLock().unlock();
            throw th2;
        }
    }

    @Override // com.kc.dw.ad.view.scaleImage.decoder.d
    public Point a(Context context, Uri uri) throws Exception {
        this.d = context;
        this.e = uri;
        d();
        return this.g;
    }

    public final void a(String str) {
        if (i) {
            Log.d("SkiaPooledImageRegionDecoder", str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0014  */
    @Override // com.kc.dw.ad.view.scaleImage.decoder.d
    public boolean a() {
        boolean z;
        boolean zIsEmpty;
        synchronized (this) {
            a aVar = this.f39209a;
            if (aVar != null) {
                synchronized (aVar) {
                    zIsEmpty = aVar.b.isEmpty();
                }
                if (zIsEmpty) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // com.kc.dw.ad.view.scaleImage.decoder.d
    public void b() {
        synchronized (this) {
            this.b.writeLock().lock();
            try {
                a aVar = this.f39209a;
                if (aVar != null) {
                    synchronized (aVar) {
                        while (!aVar.b.isEmpty()) {
                            BitmapRegionDecoder bitmapRegionDecoderA = aVar.a();
                            bitmapRegionDecoderA.recycle();
                            aVar.b.remove(bitmapRegionDecoderA);
                        }
                    }
                    this.f39209a = null;
                    this.d = null;
                    this.e = null;
                }
                this.b.writeLock().unlock();
            } catch (Throwable th) {
                this.b.writeLock().unlock();
                throw th;
            }
        }
    }

    public final int c() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0125 A[Catch: all -> 0x0141, TRY_LEAVE, TryCatch #1 {all -> 0x0141, blocks: (B:45:0x0121, B:47:0x0125, B:49:0x0132, B:52:0x0135, B:53:0x0136, B:48:0x0126), top: B:72:0x0121, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void d() throws Exception {
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        InputStream inputStreamOpen;
        a aVar;
        int identifier;
        String string = this.e.toString();
        long length = Long.MAX_VALUE;
        try {
            if (!string.startsWith("android.resource://")) {
                if (string.startsWith(com.ipd.dsp.internal.n.a.d)) {
                    String strSubstring = string.substring(22);
                    try {
                        length = this.d.getAssets().openFd(strSubstring).getLength();
                    } catch (Exception unused) {
                    }
                    inputStreamOpen = this.d.getAssets().open(strSubstring, 1);
                } else if (string.startsWith("file://")) {
                    BitmapRegionDecoder bitmapRegionDecoderNewInstance2 = BitmapRegionDecoder.newInstance(string.substring(7), false);
                    try {
                        File file = new File(string);
                        if (file.exists()) {
                            bitmapRegionDecoderNewInstance = bitmapRegionDecoderNewInstance2;
                            length = file.length();
                        } else {
                            bitmapRegionDecoderNewInstance = bitmapRegionDecoderNewInstance2;
                        }
                    } catch (Exception unused2) {
                    }
                } else {
                    InputStream inputStreamOpenInputStream = null;
                    try {
                        ContentResolver contentResolver = this.d.getContentResolver();
                        inputStreamOpenInputStream = contentResolver.openInputStream(this.e);
                        BitmapRegionDecoder bitmapRegionDecoderNewInstance3 = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                        try {
                            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.e, "r");
                            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                                length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                            }
                        } catch (Exception unused3) {
                        }
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        bitmapRegionDecoderNewInstance = bitmapRegionDecoderNewInstance3;
                    } catch (Throwable th) {
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Exception unused5) {
                            }
                        }
                        throw th;
                    }
                }
                this.f = length;
                this.g.set(bitmapRegionDecoderNewInstance.getWidth(), bitmapRegionDecoderNewInstance.getHeight());
                this.b.writeLock().lock();
                aVar = this.f39209a;
                if (aVar != null) {
                    synchronized (aVar) {
                        aVar.b.put(bitmapRegionDecoderNewInstance, Boolean.FALSE);
                        aVar.f39210a.release();
                    }
                }
                this.b.writeLock().unlock();
                return;
            }
            String authority = this.e.getAuthority();
            Resources resources = this.d.getPackageName().equals(authority) ? this.d.getResources() : this.d.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = this.e.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                identifier = resources.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused6) {
                    identifier = 0;
                }
            } else {
                identifier = 0;
            }
            try {
                length = this.d.getResources().openRawResourceFd(identifier).getLength();
            } catch (Exception unused7) {
            }
            inputStreamOpen = this.d.getResources().openRawResource(identifier);
            aVar = this.f39209a;
            if (aVar != null) {
                synchronized (aVar) {
                    aVar.b.put(bitmapRegionDecoderNewInstance, Boolean.FALSE);
                    aVar.f39210a.release();
                }
            }
            this.b.writeLock().unlock();
            return;
        } catch (Throwable th2) {
            this.b.writeLock().unlock();
            throw th2;
        }
        bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStreamOpen, false);
        this.f = length;
        this.g.set(bitmapRegionDecoderNewInstance.getWidth(), bitmapRegionDecoderNewInstance.getHeight());
        this.b.writeLock().lock();
    }
}
