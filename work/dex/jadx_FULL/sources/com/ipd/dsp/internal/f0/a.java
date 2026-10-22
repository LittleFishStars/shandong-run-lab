package com.ipd.dsp.internal.f0;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {
    public static final String f = "DownloadContext";
    public static final Executor g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), com.ipd.dsp.internal.g0.c.a("OkDownload Serial", false));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.f0.f[] f38296a;
    public volatile boolean b;

    @Nullable
    public final com.ipd.dsp.internal.f0.b c;
    public final f d;
    public Handler e;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.f0.a$a, reason: collision with other inner class name */
    public class RunnableC0879a implements Runnable {
        public final /* synthetic */ List f;
        public final /* synthetic */ com.ipd.dsp.internal.f0.c g;

        public RunnableC0879a(List list, com.ipd.dsp.internal.f0.c cVar) {
            this.f = list;
            this.g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (com.ipd.dsp.internal.f0.f fVar : this.f) {
                if (!a.this.c()) {
                    a.this.a(fVar.y());
                    return;
                }
                fVar.b(this.g);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.c.a(aVar);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f38297a;

        public c(a aVar) {
            this.f38297a = aVar;
        }

        public c a(com.ipd.dsp.internal.f0.f fVar, com.ipd.dsp.internal.f0.f fVar2) {
            com.ipd.dsp.internal.f0.f[] fVarArr = this.f38297a.f38296a;
            for (int i = 0; i < fVarArr.length; i++) {
                if (fVarArr[i] == fVar) {
                    fVarArr[i] = fVar2;
                }
            }
            return this;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<com.ipd.dsp.internal.f0.f> f38298a;
        public final f b;
        public com.ipd.dsp.internal.f0.b c;

        public d() {
            this(new f());
        }

        public d a(com.ipd.dsp.internal.f0.b bVar) {
            this.c = bVar;
            return this;
        }

        public void b(@NonNull com.ipd.dsp.internal.f0.f fVar) {
            this.f38298a.remove(fVar);
        }

        public d(f fVar) {
            this(fVar, new ArrayList());
        }

        public d a(@NonNull com.ipd.dsp.internal.f0.f fVar) {
            int iIndexOf = this.f38298a.indexOf(fVar);
            if (iIndexOf >= 0) {
                this.f38298a.set(iIndexOf, fVar);
                return this;
            }
            this.f38298a.add(fVar);
            return this;
        }

        public d(f fVar, ArrayList<com.ipd.dsp.internal.f0.f> arrayList) {
            this.b = fVar;
            this.f38298a = arrayList;
        }

        public com.ipd.dsp.internal.f0.f a(@NonNull String str) {
            if (this.b.b != null) {
                return a(new com.ipd.dsp.internal.f0.f.a(str, this.b.b).a(Boolean.TRUE));
            }
            throw new IllegalArgumentException("If you want to bind only with url, you have to provide parentPath on QueueSet!");
        }

        public com.ipd.dsp.internal.f0.f a(@NonNull com.ipd.dsp.internal.f0.f.a aVar) {
            if (this.b.f38299a != null) {
                aVar.a(this.b.f38299a);
            }
            if (this.b.c != null) {
                aVar.e(this.b.c.intValue());
            }
            if (this.b.d != null) {
                aVar.b(this.b.d.intValue());
            }
            if (this.b.e != null) {
                aVar.g(this.b.e.intValue());
            }
            if (this.b.j != null) {
                aVar.d(this.b.j.booleanValue());
            }
            if (this.b.f != null) {
                aVar.f(this.b.f.intValue());
            }
            if (this.b.g != null) {
                aVar.a(this.b.g.booleanValue());
            }
            if (this.b.h != null) {
                aVar.c(this.b.h.intValue());
            }
            if (this.b.i != null) {
                aVar.b(this.b.i.booleanValue());
            }
            com.ipd.dsp.internal.f0.f fVarA = aVar.a();
            if (this.b.k != null) {
                fVarA.a(this.b.k);
            }
            this.f38298a.add(fVarA);
            return fVarA;
        }

        public void a(int i) {
            for (com.ipd.dsp.internal.f0.f fVar : (List) this.f38298a.clone()) {
                if (fVar.b() == i) {
                    this.f38298a.remove(fVar);
                }
            }
        }

        public a a() {
            return new a((com.ipd.dsp.internal.f0.f[]) this.f38298a.toArray(new com.ipd.dsp.internal.f0.f[this.f38298a.size()]), this.c, this.b);
        }
    }

    public static class e extends com.ipd.dsp.internal.q0.b {
        public final AtomicInteger f;

        @NonNull
        public final com.ipd.dsp.internal.f0.b g;

        @NonNull
        public final a h;

        public e(@NonNull a aVar, @NonNull com.ipd.dsp.internal.f0.b bVar, int i) {
            this.f = new AtomicInteger(i);
            this.g = bVar;
            this.h = aVar;
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void taskEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc) {
            int iDecrementAndGet = this.f.decrementAndGet();
            this.g.a(this.h, fVar, aVar, exc, iDecrementAndGet);
            if (iDecrementAndGet <= 0) {
                this.g.a(this.h);
                com.ipd.dsp.internal.g0.c.a(a.f, "taskEnd and remainCount " + iDecrementAndGet);
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void taskStart(@NonNull com.ipd.dsp.internal.f0.f fVar) {
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, List<String>> f38299a;
        public Uri b;
        public Integer c;
        public Integer d;
        public Integer e;
        public Integer f;
        public Boolean g;
        public Integer h;
        public Boolean i;
        public Boolean j;
        public Object k;

        public boolean l() {
            Boolean bool = this.j;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        public void a(Map<String, List<String>> map) {
            this.f38299a = map;
        }

        public Uri b() {
            return this.b;
        }

        public int c() {
            Integer num = this.d;
            if (num == null) {
                return 16384;
            }
            return num.intValue();
        }

        public Map<String, List<String>> d() {
            return this.f38299a;
        }

        public int e() {
            Integer num = this.h;
            if (num == null) {
                return 3000;
            }
            return num.intValue();
        }

        public int f() {
            Integer num = this.c;
            if (num == null) {
                return 4096;
            }
            return num.intValue();
        }

        public int g() {
            Integer num = this.f;
            if (num == null) {
                return 2000;
            }
            return num.intValue();
        }

        public int h() {
            Integer num = this.e;
            if (num == null) {
                return 65536;
            }
            return num.intValue();
        }

        public Object i() {
            return this.k;
        }

        public boolean j() {
            Boolean bool = this.g;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public boolean k() {
            Boolean bool = this.i;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public f a(@NonNull Uri uri) {
            this.b = uri;
            return this;
        }

        public f b(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public f d(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        public f a(@NonNull File file) {
            if (!file.isFile()) {
                this.b = Uri.fromFile(file);
                return this;
            }
            throw new IllegalArgumentException("parent path only accept directory path");
        }

        public f b(Boolean bool) {
            this.j = bool;
            return this;
        }

        public f c(int i) {
            this.f = Integer.valueOf(i);
            return this;
        }

        public f a(@NonNull String str) {
            return a(new File(str));
        }

        public f a(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        public f a(Boolean bool) {
            this.g = bool;
            return this;
        }

        public f a(Integer num) {
            this.h = num;
            return this;
        }

        public f a(Object obj) {
            this.k = obj;
            return this;
        }

        public f a(boolean z) {
            this.i = Boolean.valueOf(z);
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public a(@NonNull com.ipd.dsp.internal.f0.f[] fVarArr, @Nullable com.ipd.dsp.internal.f0.b bVar, @NonNull f fVar, @NonNull Handler handler) {
        this(fVarArr, bVar, fVar);
        this.e = handler;
    }

    public com.ipd.dsp.internal.f0.f[] b() {
        return this.f38296a;
    }

    public boolean c() {
        return this.b;
    }

    public void d() {
        if (this.b) {
            h.j().e().a((com.ipd.dsp.internal.g0.a[]) this.f38296a);
        }
        this.b = false;
    }

    public d e() {
        return new d(this.d, new ArrayList(Arrays.asList(this.f38296a))).a(this.c);
    }

    public void b(com.ipd.dsp.internal.f0.c cVar) {
        a(cVar, true);
    }

    public a(@NonNull com.ipd.dsp.internal.f0.f[] fVarArr, @Nullable com.ipd.dsp.internal.f0.b bVar, @NonNull f fVar) {
        this.b = false;
        this.f38296a = fVarArr;
        this.c = bVar;
        this.d = fVar;
    }

    public void a(com.ipd.dsp.internal.f0.c cVar) {
        a(cVar, false);
    }

    public void a(@Nullable com.ipd.dsp.internal.f0.c cVar, boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        com.ipd.dsp.internal.g0.c.a(f, "start " + z);
        this.b = true;
        if (this.c != null) {
            cVar = new com.ipd.dsp.internal.q0.f.a().a(cVar).a(new e(this, this.c, this.f38296a.length)).a();
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, this.f38296a);
            Collections.sort(arrayList);
            a(new RunnableC0879a(arrayList, cVar));
        } else {
            com.ipd.dsp.internal.f0.f.a(this.f38296a, cVar);
        }
        com.ipd.dsp.internal.g0.c.a(f, "start finish " + z + " " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
    }

    public c a() {
        return new c(this);
    }

    public final void a(boolean z) {
        com.ipd.dsp.internal.f0.b bVar = this.c;
        if (bVar == null) {
            return;
        }
        if (z) {
            if (this.e == null) {
                this.e = new Handler(Looper.getMainLooper());
            }
            this.e.post(new b());
            return;
        }
        bVar.a(this);
    }

    public void a(Runnable runnable) {
        g.execute(runnable);
    }
}
