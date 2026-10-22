package com.aliyun.svideosdk.common.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.aliyun.common.utils.k;
import com.aliyun.svideosdk.AlivcSdkCore;
import com.aliyun.svideosdk.common.AliyunIThumbnailFetcher;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends com.aliyun.svideosdk.common.impl.a {
    private static final String k = "com.aliyun.svideosdk.common.impl.f";
    static final /* synthetic */ boolean l = true;
    private Rect g = new Rect();
    private ThreadPoolExecutor h = null;
    private g i = null;
    private Looper j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Long f25642a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;
        final /* synthetic */ AliyunIThumbnailFetcher.OnThumbnailCompletion d;
        final /* synthetic */ Bitmap e;

        public a(Long l, long j, long j2, AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion, Bitmap bitmap) {
            this.f25642a = l;
            this.b = j;
            this.c = j2;
            this.d = onThumbnailCompletion;
            this.e = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d(f.k, "return thumbnail by cache,time " + this.f25642a);
            long jLongValue = ((this.b + this.f25642a.longValue()) - this.c) / 1000;
            this.d.onThumbnailReady(this.e, jLongValue, f.this.a(jLongValue));
        }
    }

    public class b implements Runnable {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map.Entry f25644a;
            final /* synthetic */ com.aliyun.svideosdk.common.impl.a.C0219a b;
            final /* synthetic */ Bitmap c;

            public a(Map.Entry entry, com.aliyun.svideosdk.common.impl.a.C0219a c0219a, Bitmap bitmap) {
                this.f25644a = entry;
                this.b = c0219a;
                this.c = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(f.k, "OnThumbnailReady " + this.f25644a.getKey());
                long jLongValue = ((Long) this.f25644a.getKey()).longValue() / 1000;
                this.b.b.onThumbnailReady(this.c, jLongValue, f.this.a(jLongValue));
            }
        }

        /* JADX INFO: renamed from: com.aliyun.svideosdk.common.impl.f$b$b, reason: collision with other inner class name */
        public class RunnableC0221b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.aliyun.svideosdk.common.impl.a.C0219a f25645a;

            public RunnableC0221b(b bVar, com.aliyun.svideosdk.common.impl.a.C0219a c0219a) {
                this.f25645a = c0219a;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f25645a.b.onError(-20004007);
            }
        }

        public b() {
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0083  */
        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmapA;
            com.aliyun.svideosdk.common.b.c.a aVar = new com.aliyun.svideosdk.common.b.c.a();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(f.this.f25632a.e(), options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            Log.d(f.k, "Image width = " + i + ", Image height= " + i2);
            float f = (((float) i) * 1.0f) / ((float) i2);
            float fWidth = (((float) f.this.g.width()) * 1.0f) / ((float) f.this.g.height());
            Bitmap.Config config = Bitmap.Config.RGB_565;
            if (com.aliyun.svideosdk.common.b.b.a.a(Build.MODEL)) {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap.Config config2 = config;
            if (f != fWidth) {
                int i3 = c.f25646a[f.this.f25632a.j().ordinal()];
                if (i3 == 1) {
                    bitmapA = aVar.a(f.this.f25632a.e(), f.this.f25632a.d(), f.this.f25632a.c(), i, i2, 0, -16777216, config2);
                } else if (i3 != 2) {
                    bitmapA = null;
                } else {
                    bitmapA = aVar.a(f.this.f25632a.e(), f.this.g, f.this.f25632a.d(), f.this.f25632a.c(), 0, config2);
                }
            } else {
                bitmapA = aVar.a(f.this.f25632a.e(), f.this.g, f.this.f25632a.d(), f.this.f25632a.c(), 0, config2);
            }
            ConcurrentHashMap<Long, List<com.aliyun.svideosdk.common.impl.a.C0219a>> concurrentHashMap = f.this.c;
            if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            synchronized (f.this.c) {
                for (Map.Entry<Long, List<com.aliyun.svideosdk.common.impl.a.C0219a>> entry : f.this.c.entrySet()) {
                    if (entry != null && entry.getValue() != null) {
                        for (com.aliyun.svideosdk.common.impl.a.C0219a c0219a : entry.getValue()) {
                            if (bitmapA != null) {
                                Bitmap bitmapCopy = bitmapA.copy(Bitmap.Config.RGB_565, false);
                                f.this.d.add(bitmapCopy);
                                arrayList.add(entry.getKey());
                                f.this.f.post(new a(entry, c0219a, bitmapCopy));
                            } else {
                                f.this.f.post(new RunnableC0221b(this, c0219a));
                            }
                        }
                    }
                }
                f.this.c.clear();
                g gVar = f.this.i;
                f fVar = f.this;
                gVar.a(bitmapA, fVar.a(0L, fVar.f25632a.d(), f.this.f25632a.c()));
            }
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25646a;

        static {
            int[] iArr = new int[VideoDisplayMode.values().length];
            f25646a = iArr;
            try {
                iArr[VideoDisplayMode.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25646a[VideoDisplayMode.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public class d implements ThreadFactory {
        public d(f fVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ImageThumbnailWrapper Thread");
            return thread;
        }
    }

    public f(Looper looper) {
        this.j = looper;
        g();
    }

    public int a(int i, int i2) {
        if (!l && this.b != 1) {
            throw new AssertionError();
        }
        this.f25632a.b(i);
        this.f25632a.a(i2);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int a(int i, int i2, int i3, int i4, int i5) {
        if (!l && this.b != 1) {
            throw new AssertionError();
        }
        Rect rect = this.g;
        rect.left = i2;
        rect.right = i2 + i4;
        rect.top = i3;
        rect.bottom = i3 + i5;
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int a(long j, List<Long> list, AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion, long j2) {
        list.iterator();
        if (list.size() <= 0) {
            return 0;
        }
        Long lValueOf = Long.valueOf(j);
        for (Long l2 : list) {
            Log.d(k, "addPicTime " + l2);
            Bitmap bitmapA = this.i.a(a(0L, this.f25632a.d(), this.f25632a.c()));
            if (bitmapA != null) {
                this.d.add(bitmapA);
                this.f.post(new a(l2, j, j2, onThumbnailCompletion, bitmapA));
            } else {
                a(Long.valueOf(lValueOf.longValue() + l2.longValue()), new com.aliyun.svideosdk.common.impl.a.C0219a(this, j, onThumbnailCompletion, 0L));
                this.h.execute(new b());
            }
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int a(String str) {
        this.b = 2;
        StringBuilder sb = new StringBuilder(AlivcSdkCore.APP_PUBLIC_DIR);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(".aliyun_svideo_files/thumbnails");
        sb.append(str2);
        sb.append(k.a(str));
        this.i = new g(sb.toString(), this.j);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int d() {
        ThreadPoolExecutor threadPoolExecutor = this.h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.h.shutdownNow();
            this.h = null;
        }
        g gVar = this.i;
        if (gVar != null) {
            gVar.b();
        }
        super.d();
        this.b = 0;
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int e() {
        this.b = 3;
        return 0;
    }

    public int g() {
        this.h = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(this), new ThreadPoolExecutor.AbortPolicy());
        this.b = 1;
        return 0;
    }
}
