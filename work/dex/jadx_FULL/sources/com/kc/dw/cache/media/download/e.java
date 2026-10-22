package com.kc.dw.cache.media.download;

import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.t;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e implements b {
    public static final int o = 0;
    public RandomAccessFile d;
    public RandomAccessFile e;
    public File f;
    public File g;
    public File h;
    public c k;
    public long l;
    public final String m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f39229a = new Object();
    public final Object b = new Object();
    public final Object c = new Object();
    public volatile long j = -2147483648L;
    public final List<SoftReference<f>> n = new ArrayList();
    public final g i = new g();

    @Keep
    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f39230a;

        public a(e eVar) {
            this.f39230a = eVar;
        }

        @Override // com.kc.dw.cache.media.download.f
        public void a() {
            e eVar = this.f39230a;
            eVar.getClass();
            try {
                synchronized (eVar.f39229a) {
                    try {
                        if (!eVar.f.exists() && !eVar.g.renameTo(eVar.f)) {
                            LogUtil.e("e", "rename error");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    eVar.a();
                    if (!t.c(eVar.g)) {
                        LogUtil.e("e", "delete fileTemp error");
                    }
                    if (!t.c(eVar.h)) {
                        LogUtil.e("e", "delete fileLastMetaTemp error." + eVar.h.getAbsolutePath());
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            e eVar2 = this.f39230a;
            synchronized (eVar2.b) {
                Iterator<SoftReference<f>> it = eVar2.n.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().get().a();
                    } catch (Exception unused) {
                    }
                }
            }
            this.f39230a.b();
        }

        @Override // com.kc.dw.cache.media.download.f
        public void a(int i, String str) {
            this.f39230a.a(i, str);
            this.f39230a.b();
        }

        @Override // com.kc.dw.cache.media.download.f
        public void a(long j) {
            this.f39230a.j = j;
            e eVar = this.f39230a;
            synchronized (eVar.b) {
                Iterator<SoftReference<f>> it = eVar.n.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().get().a(j);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        @Override // com.kc.dw.cache.media.download.f
        public void a(long j, int i) {
            e eVar = this.f39230a;
            synchronized (eVar.b) {
                Iterator<SoftReference<f>> it = eVar.n.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().get().a(j, i);
                    } catch (Exception unused) {
                    }
                }
            }
            long j2 = this.f39230a.l;
            if (j2 <= 0 || j < j2) {
                return;
            }
            StringBuilder sbA = com.kc.dw.activity.a.a("download limit. maxFileSize:");
            sbA.append(this.f39230a.l);
            LogUtil.i("e", sbA.toString());
            e eVar2 = this.f39230a;
            c cVar = eVar2.k;
            if (cVar != null) {
                cVar.k = null;
            }
            synchronized (eVar2.c) {
                this.f39230a.b();
            }
        }
    }

    public e(String str, f fVar) {
        this.m = str;
        try {
            a(fVar);
            this.f = com.kc.dw.core.bquery.c.a(str, (String) null);
            this.g = com.kc.dw.core.bquery.c.a(str, "temp");
            this.h = com.kc.dw.core.bquery.c.a(str, "last_meta_temp");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.cache.media.download.b
    public b a(f fVar) {
        boolean z;
        if (fVar == null) {
            return this;
        }
        if (this.j != -2147483648L) {
            fVar.a(this.j);
        }
        synchronized (this.b) {
            Iterator<SoftReference<f>> it = this.n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (it.next().get() == fVar) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.n.add(new SoftReference<>(fVar));
            }
        }
        return this;
    }

    public final void a() {
        RandomAccessFile randomAccessFile = this.d;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.d = null;
        }
        RandomAccessFile randomAccessFile2 = this.e;
        if (randomAccessFile2 != null) {
            try {
                randomAccessFile2.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            this.e = null;
        }
    }

    public final void a(int i, String str) {
        synchronized (this.b) {
            Iterator<SoftReference<f>> it = this.n.iterator();
            while (it.hasNext()) {
                try {
                    it.next().get().a(i, str);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.kc.dw.cache.media.download.a
    public void a(long j) {
        if (j > 0) {
            this.l = Math.max(this.l, j);
        }
    }

    @Override // com.kc.dw.cache.media.download.a
    public void a(String str, long j, int i, RandomAccessFile randomAccessFile) {
        c cVar = this.k;
        if (cVar != null) {
            cVar.a(str, j, i, this.e);
            return;
        }
        try {
            if (!this.g.exists() || j < this.g.length()) {
                return;
            }
            this.l = 0L;
            synchronized (this.c) {
                try {
                    if (this.k == null) {
                        LogUtil.d("e", "re download");
                        c();
                    }
                    c cVar2 = this.k;
                    if (cVar2 != null) {
                        cVar2.a(str, j, i, this.e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.kc.dw.cache.media.download.a
    public boolean a(RandomAccessFile randomAccessFile, long j) {
        c cVar = this.k;
        return cVar != null && cVar.a(randomAccessFile, j);
    }

    public final void b() {
        c cVar = this.k;
        if (cVar != null) {
            cVar.close();
            this.k = null;
        }
        a();
    }

    @Override // com.kc.dw.cache.media.download.b
    public void b(f fVar) {
        if (fVar == null) {
            return;
        }
        synchronized (this.b) {
            for (SoftReference<f> softReference : this.n) {
                if (softReference.get() == fVar) {
                    this.n.remove(softReference);
                    try {
                        if (this.n.size() == 1 && (this.n.get(0).get() instanceof h.a)) {
                            this.n.get(0).get().a();
                            this.n.clear();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
        }
    }

    public void c() {
        String str = "unknown2.";
        try {
            if (this.f.exists() && this.f.length() > 0) {
                LogUtil.d("e", "file exists");
                return;
            }
            if (this.k != null) {
                LogUtil.d("e", "downloader is`not null");
                return;
            }
            this.d = new RandomAccessFile(this.g, "rw");
            this.e = new RandomAccessFile(this.h, "rw");
            long length = this.g.exists() ? this.g.length() : 0L;
            LogUtil.dev("e", "start download");
            this.k = new c(this.m, this.d, length, this.f39229a, this.i, new a(this));
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                str = "unknown2." + th.toString();
            } catch (Exception unused) {
            }
            a(9, str);
            b();
        }
    }

    @Override // com.kc.dw.cache.media.download.a
    public void close() {
        if (this.n.isEmpty()) {
            b();
        } else {
            LogUtil.d("e", "listeners is`not empty");
        }
    }
}
