package com.aliyun.svideosdk.common.impl;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Looper;
import android.util.Log;
import com.aliyun.common.utils.k;
import com.aliyun.svideosdk.AlivcSdkCore;
import com.aliyun.svideosdk.common.AliyunIThumbnailFetcher;
import com.aliyun.svideosdk.thumbnail.FileThumbnailsCallback;
import com.aliyun.svideosdk.thumbnail.NativeFileThumbnails;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h extends com.aliyun.svideosdk.common.impl.a {
    private static final String j = "com.aliyun.svideosdk.common.impl.h";
    static final /* synthetic */ boolean k = true;
    private Looper h;
    protected g g = null;
    private FileThumbnailsCallback i = new b();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f25649a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;
        final /* synthetic */ AliyunIThumbnailFetcher.OnThumbnailCompletion d;
        final /* synthetic */ Bitmap e;

        public a(long j, long j2, long j3, AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion, Bitmap bitmap) {
            this.f25649a = j;
            this.b = j2;
            this.c = j3;
            this.d = onThumbnailCompletion;
            this.e = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d(h.j, "return bitmap by cache, time " + this.f25649a);
            long j = ((this.b + this.f25649a) - this.c) / 1000;
            this.d.onThumbnailReady(this.e, j, h.this.a(j));
        }
    }

    public class b implements FileThumbnailsCallback {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.aliyun.svideosdk.common.impl.a.C0219a f25651a;
            final /* synthetic */ int b;

            public a(b bVar, com.aliyun.svideosdk.common.impl.a.C0219a c0219a, int i) {
                this.f25651a = c0219a;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f25651a.b.onError(this.b);
            }
        }

        /* JADX INFO: renamed from: com.aliyun.svideosdk.common.impl.h$b$b, reason: collision with other inner class name */
        public class RunnableC0222b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.aliyun.svideosdk.common.impl.a.C0219a f25652a;
            final /* synthetic */ long b;
            final /* synthetic */ Bitmap c;

            public RunnableC0222b(com.aliyun.svideosdk.common.impl.a.C0219a c0219a, long j, Bitmap bitmap) {
                this.f25652a = c0219a;
                this.b = j;
                this.c = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.common.impl.a.C0219a c0219a = this.f25652a;
                long j = ((c0219a.f25633a + this.b) - c0219a.c) / 1000;
                c0219a.b.onThumbnailReady(this.c, j, h.this.a(j));
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.aliyun.svideosdk.common.impl.a.C0219a f25653a;
            final /* synthetic */ int b;

            public c(b bVar, com.aliyun.svideosdk.common.impl.a.C0219a c0219a, int i) {
                this.f25653a = c0219a;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f25653a.b.onError(this.b);
            }
        }

        public b() {
        }

        @Override // com.aliyun.svideosdk.thumbnail.FileThumbnailsCallback
        public void onError(int i) {
            Log.e(h.j, "get thumbnail failed, errorCode:" + i);
            synchronized (h.this.c) {
                Iterator<Map.Entry<Long, List<com.aliyun.svideosdk.common.impl.a.C0219a>>> it = h.this.c.entrySet().iterator();
                while (it.hasNext()) {
                    for (com.aliyun.svideosdk.common.impl.a.C0219a c0219a : it.next().getValue()) {
                        if (c0219a != null && c0219a.b != null) {
                            h.this.f.post(new a(this, c0219a, i));
                        }
                    }
                }
                h.this.c.clear();
            }
        }

        @Override // com.aliyun.svideosdk.thumbnail.FileThumbnailsCallback
        public void onExit() {
        }

        @Override // com.aliyun.svideosdk.thumbnail.FileThumbnailsCallback
        public void onPicAvailable(ByteBuffer byteBuffer, long j, int i, int i2) {
            List<com.aliyun.svideosdk.common.impl.a.C0219a> listA = h.this.a(Long.valueOf(j));
            if (listA == null || listA.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            byteBuffer.rewind();
            bitmapCreateBitmap.copyPixelsFromBuffer(byteBuffer);
            for (com.aliyun.svideosdk.common.impl.a.C0219a c0219a : listA) {
                if (c0219a != null && c0219a.b != null) {
                    arrayList.add(Long.valueOf((c0219a.f25633a - c0219a.c) + j));
                    Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.RGB_565, false);
                    List<Bitmap> list = h.this.d;
                    if (list != null) {
                        list.add(bitmapCopy);
                    }
                    h.this.f.post(new RunnableC0222b(c0219a, j, bitmapCopy));
                }
            }
            Bitmap bitmapCopy2 = bitmapCreateBitmap.copy(Bitmap.Config.RGB_565, false);
            bitmapCreateBitmap.recycle();
            h hVar = h.this;
            hVar.g.a(bitmapCopy2, hVar.a(j, hVar.f25632a.d(), h.this.f25632a.c()));
        }

        @Override // com.aliyun.svideosdk.thumbnail.FileThumbnailsCallback
        public void onPicError(int i, long j, boolean z) {
            List<com.aliyun.svideosdk.common.impl.a.C0219a> listA = h.this.a(Long.valueOf(j));
            if (listA == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.aliyun.svideosdk.common.impl.a.C0219a c0219a : listA) {
                if (c0219a != null && c0219a.b != null) {
                    arrayList.add(Long.valueOf((c0219a.f25633a - c0219a.c) + j));
                    h.this.f.post(new c(this, c0219a, i));
                }
            }
        }
    }

    public h(Looper looper) {
        this.h = null;
        this.h = looper;
        h();
    }

    public int a(int i, int i2) {
        if (!k && this.b != 1) {
            throw new AssertionError();
        }
        long jH = this.f25632a.h();
        if (jH == 0) {
            Log.e("AliYunLog", "Native thumbnail is null!");
            return -4;
        }
        NativeFileThumbnails.nativeSetDstSize(i, i2, jH);
        this.f25632a.b(i);
        this.f25632a.a(i2);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int a(int i, int i2, int i3, int i4, int i5) {
        if (!k && this.b != 1) {
            throw new AssertionError();
        }
        long jH = this.f25632a.h();
        if (jH == 0) {
            Log.e("AliYunLog", "Native thumbnail is null!");
            return -4;
        }
        this.f25632a.e(i);
        Rect rect = new Rect();
        rect.left = i2;
        rect.top = i3;
        rect.right = i2 + i4;
        rect.bottom = i3 + i5;
        this.f25632a.a(rect);
        NativeFileThumbnails.nativeSetCutSize(i, i2, i3, i4, i5, jH);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int a(long j2, List<Long> list, AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion, long j3) {
        if (!k && this.b != 3) {
            throw new AssertionError();
        }
        if (list == null || list.size() <= 0) {
            return -20003002;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            Log.d(j, "addPicTime " + jLongValue);
            Bitmap bitmapA = this.g.a(a(jLongValue, this.f25632a.d(), this.f25632a.c()));
            if (bitmapA != null) {
                this.d.add(bitmapA);
                this.f.post(new a(jLongValue, j2, j3, onThumbnailCompletion, bitmapA));
            } else {
                arrayList.add(Long.valueOf(jLongValue));
                a(Long.valueOf(jLongValue), new com.aliyun.svideosdk.common.impl.a.C0219a(this, j2, onThumbnailCompletion, j3));
            }
        }
        if (arrayList.isEmpty()) {
            return -20003002;
        }
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = ((Long) arrayList.get(i)).longValue();
        }
        long jH = this.f25632a.h();
        if (jH != 0) {
            NativeFileThumbnails.nativeAddPicTime(jArr, size, jH);
            return 0;
        }
        Log.e("AliYunLog", "Native thumbnail is null!");
        return -4;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int a(String str) {
        if (!k && this.b != 1) {
            throw new AssertionError();
        }
        Log.d(j, "Call nativePrepare");
        long jH = this.f25632a.h();
        if (jH == 0) {
            this.i.onError(-4);
            Log.e("AliYunLog", "Native thumbnail is null!");
            return -4;
        }
        StringBuilder sb = new StringBuilder(AlivcSdkCore.APP_PUBLIC_DIR);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(".aliyun_svideo_files/thumbnails");
        sb.append(str2);
        sb.append(k.a(str));
        sb.append(str2);
        this.g = new g(sb.toString(), this.h);
        long jNativePrepare = NativeFileThumbnails.nativePrepare(str, this.i, jH);
        if (jNativePrepare == 0) {
            Log.e("AliYunLog", "Native thumbnail prepare failed");
            return -20003002;
        }
        this.f25632a.a(jNativePrepare);
        this.b = 2;
        return 0;
    }

    public int a(boolean z) {
        long jH = this.f25632a.h();
        if (jH != 0) {
            return NativeFileThumbnails.nativeSetFastMode(z, jH);
        }
        Log.e("AliYunLog", "Native thumbnail is null!");
        return -4;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int d() {
        NativeFileThumbnails.nativeRelease(this.f25632a.h(), this.f25632a.a());
        this.f25632a.c(0L);
        this.f25632a.a(0L);
        g gVar = this.g;
        if (gVar != null) {
            gVar.b();
        }
        this.b = 0;
        super.d();
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int e() {
        String str;
        if (!k && this.b != 2) {
            throw new AssertionError();
        }
        if (this.b == 2) {
            long jH = this.f25632a.h();
            if (jH != 0) {
                NativeFileThumbnails.nativeStart(jH);
                this.b = 3;
                return 0;
            }
            str = "Native thumbnail is null!";
        } else {
            str = " thumbnail error state";
        }
        Log.e("AliYunLog", str);
        return -4;
    }

    public int g() {
        String str;
        if (!k && this.b != 3) {
            throw new AssertionError();
        }
        if (this.b == 3) {
            long jH = this.f25632a.h();
            if (jH != 0) {
                NativeFileThumbnails.nativeCancel(jH);
                this.b = 2;
                return 0;
            }
            str = "Native thumbnail is null!";
        } else {
            str = " thumbnail error state";
        }
        Log.e("AliYunLog", str);
        return -4;
    }

    public int h() {
        this.f25632a.c(NativeFileThumbnails.nativeInit());
        this.b = 1;
        return 0;
    }
}
