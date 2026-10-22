package com.kc.dw.cache.media.download;

import com.kc.dw.ad.w;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.z;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.io.InputStream;
import java.io.RandomAccessFile;
import okhttp3.Request;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c implements com.kc.dw.cache.media.download.a {
    public static final int l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39225a;
    public final Object b;
    public final g c;
    public final b e;
    public b f;
    public long g;
    public volatile long h;
    public volatile boolean i;
    public f k;
    public final Object d = new Object();
    public volatile boolean j = false;

    @Keep
    public class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f39226a;

        public a(c cVar) {
            this.f39226a = cVar;
        }

        public void a(int i, String str) {
            this.f39226a.close();
            f fVar = this.f39226a.k;
            if (fVar != null) {
                fVar.a(i, str);
            }
        }
    }

    @Keep
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputStream f39227a = null;
        public final long b;

        @Keep
        public interface a {
        }

        public b(String str, RandomAccessFile randomAccessFile, long j, Object obj, a aVar) {
            String str2 = "unknown1.";
            this.b = j;
            try {
                Request.Builder builderUrl = new Request.Builder().url(str);
                builderUrl.addHeader("Range", "bytes=" + j + c49.f40900a);
                z.a().newCall(builderUrl.build()).enqueue(new d(this, aVar, j, str, obj, randomAccessFile));
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    str2 = "unknown1." + th.toString();
                } catch (Exception unused) {
                }
                if (aVar != null) {
                    ((a) aVar).a(9, w.a(str2, str));
                }
            }
        }

        public void a() {
            try {
                InputStream inputStream = this.f39227a;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public c(String str, RandomAccessFile randomAccessFile, long j, Object obj, g gVar, f fVar) {
        this.f39225a = str;
        this.b = obj;
        this.c = gVar;
        this.k = fVar;
        this.e = new b(str, randomAccessFile, j, obj, new a(this));
    }

    @Override // com.kc.dw.cache.media.download.a
    public void a(String str, long j, int i, RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null && this.c.a(str, j, this.h, i)) {
            if (this.g == 0) {
                this.g = j;
            }
            if (this.h <= 0 || !this.i || this.j || a(randomAccessFile)) {
                return;
            }
            synchronized (this.d) {
                this.j = true;
                if (this.f == null) {
                    LogUtil.dev("c", "start download last meta data. position:" + j + " threadId:" + Thread.currentThread().getId());
                    this.f = new b(this.f39225a, randomAccessFile, j, this.b, null);
                }
            }
        }
    }

    public final boolean a(RandomAccessFile randomAccessFile) {
        try {
            return this.h > 0 && randomAccessFile != null && randomAccessFile.length() == this.h;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.kc.dw.cache.media.download.a
    public boolean a(RandomAccessFile randomAccessFile, long j) {
        try {
            if (a(randomAccessFile) && j >= this.g) {
                return true;
            }
            b bVar = this.f;
            return bVar != null && j >= bVar.b && j < randomAccessFile.length();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.kc.dw.cache.media.download.a
    public void close() {
        b bVar = this.e;
        if (bVar != null) {
            bVar.a();
        }
        b bVar2 = this.f;
        if (bVar2 != null) {
            bVar2.a();
        }
    }
}
