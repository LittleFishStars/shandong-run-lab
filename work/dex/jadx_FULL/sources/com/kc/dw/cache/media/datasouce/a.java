package com.kc.dw.cache.media.datasouce;

import com.kc.dw.cache.media.download.f;
import com.kc.dw.cache.media.download.h;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39222a;
    public RandomAccessFile c;
    public RandomAccessFile d;
    public File e;
    public File f;
    public File g;
    public volatile long h;
    public com.kc.dw.cache.media.download.b j;
    public f l;
    public final Object b = new Object();
    public boolean i = false;
    public final String k = String.valueOf(hashCode());

    /* JADX INFO: renamed from: com.kc.dw.cache.media.datasouce.a$a, reason: collision with other inner class name */
    @Keep
    public class C1021a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f39223a;
        public final a b;

        public C1021a(a aVar, c cVar) {
            this.b = aVar;
            this.f39223a = cVar;
        }

        @Override // com.kc.dw.cache.media.download.f
        public void a() {
            a aVar = this.b;
            aVar.getClass();
            try {
                synchronized (aVar.b) {
                    try {
                        if (!aVar.e.exists() || aVar.e.length() <= 0) {
                            LogUtil.e("a", "changeSource error");
                        } else {
                            RandomAccessFile randomAccessFile = aVar.c;
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            aVar.c = new RandomAccessFile(aVar.e, "r");
                            RandomAccessFile randomAccessFile2 = aVar.d;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                                aVar.d = null;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // com.kc.dw.cache.media.download.f
        public void a(int i, String str) {
            a aVar = this.b;
            if (aVar.i) {
                return;
            }
            aVar.i = true;
            c cVar = this.f39223a;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // com.kc.dw.cache.media.download.f
        public void a(long j) {
            this.b.h = j;
            c cVar = this.f39223a;
            if (cVar != null) {
                cVar.a(false);
            }
        }

        @Override // com.kc.dw.cache.media.download.f
        public void a(long j, int i) {
            c cVar = this.f39223a;
            if (cVar != null) {
                cVar.a(i, false);
            }
        }
    }

    public a(String str, c cVar) {
        this.h = -2147483648L;
        this.f39222a = str;
        try {
            this.e = com.kc.dw.core.bquery.c.a(str, (String) null);
            this.f = com.kc.dw.core.bquery.c.a(str, "temp");
            this.g = com.kc.dw.core.bquery.c.a(str, "last_meta_temp");
            if (!b()) {
                LogUtil.dev("a", "file not exist. url:" + str);
                a();
                this.c = new RandomAccessFile(this.f, "r");
                this.d = new RandomAccessFile(this.g, "r");
                a(cVar);
                return;
            }
            this.c = new RandomAccessFile(this.e, "r");
            this.h = this.e.length();
            if (cVar != null) {
                cVar.a(true);
                cVar.a(100, true);
            }
            LogUtil.dev("a", "file exist. " + this.h);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            if (!this.f.exists()) {
                this.f.createNewFile();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (this.g.exists()) {
                return;
            }
            this.g.createNewFile();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void a(c cVar) {
        C1021a c1021a = new C1021a(this, cVar);
        this.l = c1021a;
        this.j = h.a(this.f39222a, c1021a);
    }

    public final boolean b() {
        File file = this.e;
        return file != null && file.exists();
    }
}
