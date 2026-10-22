package com.ipd.dsp.internal.f0;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.SparseArray;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f extends com.ipd.dsp.internal.g0.a implements Comparable<f> {
    public final AtomicLong A = new AtomicLong();
    public final boolean B;

    @NonNull
    public final com.ipd.dsp.internal.l0.g.a C;

    @NonNull
    public final File D;

    @NonNull
    public final File E;

    @Nullable
    public File F;

    @Nullable
    public String G;
    public final int h;

    @NonNull
    public final String i;
    public final Uri j;
    public final Map<String, List<String>> k;

    @Nullable
    public com.ipd.dsp.internal.h0.b l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;

    @Nullable
    public final Integer r;

    @Nullable
    public final Boolean s;
    public final boolean t;
    public final boolean u;
    public final int v;
    public volatile com.ipd.dsp.internal.f0.c w;
    public volatile SparseArray<Object> x;
    public Object y;
    public final boolean z;

    public static class a {
        public static final int q = 4096;
        public static final int r = 16384;
        public static final int s = 65536;
        public static final int t = 2000;
        public static final boolean u = true;
        public static final int v = 3000;
        public static final boolean w = true;
        public static final boolean x = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final String f38300a;

        @NonNull
        public final Uri b;
        public volatile Map<String, List<String>> c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public boolean i;
        public int j;
        public String k;
        public boolean l;
        public boolean m;
        public Boolean n;
        public Integer o;
        public Boolean p;

        public a(@NonNull String str, @NonNull String str2, @Nullable String str3) {
            this(str, Uri.fromFile(new File(str2)));
            if (com.ipd.dsp.internal.g0.c.a((CharSequence) str3)) {
                this.n = Boolean.TRUE;
            } else {
                this.k = str3;
            }
        }

        public a a(@IntRange(from = 1) int i) {
            this.o = Integer.valueOf(i);
            return this;
        }

        public a b(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.f = i;
            return this;
        }

        public a c(boolean z) {
            this.p = Boolean.valueOf(z);
            return this;
        }

        public a d(int i) {
            this.d = i;
            return this;
        }

        public a e(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.e = i;
            return this;
        }

        public a f(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.h = i;
            return this;
        }

        public a g(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.g = i;
            return this;
        }

        public a a(@Nullable Boolean bool) {
            if (!com.ipd.dsp.internal.g0.c.d(this.b)) {
                throw new IllegalArgumentException("Uri isn't file scheme we can't let filename from response");
            }
            this.n = bool;
            return this;
        }

        public a c(int i) {
            this.j = i;
            return this;
        }

        public a d(boolean z) {
            this.m = z;
            return this;
        }

        public a b(boolean z) {
            this.l = z;
            return this;
        }

        public a(@NonNull String str, @NonNull File file) {
            this.e = 4096;
            this.f = 16384;
            this.g = 65536;
            this.h = 2000;
            this.i = true;
            this.j = 3000;
            this.l = true;
            this.m = false;
            this.f38300a = str;
            this.b = Uri.fromFile(file);
        }

        public a a(boolean z) {
            this.i = z;
            return this;
        }

        public a a(Map<String, List<String>> map) {
            this.c = map;
            return this;
        }

        public synchronized void a(String str, String str2) {
            if (this.c == null) {
                this.c = new HashMap();
            }
            List<String> arrayList = this.c.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.c.put(str, arrayList);
            }
            arrayList.add(str2);
        }

        public a a(String str) {
            this.k = str;
            return this;
        }

        public f a() {
            return new f(this.f38300a, this.b, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.c, this.k, this.l, this.m, this.n, this.o, this.p);
        }

        public a(@NonNull String str, @NonNull Uri uri) {
            this.e = 4096;
            this.f = 16384;
            this.g = 65536;
            this.h = 2000;
            this.i = true;
            this.j = 3000;
            this.l = true;
            this.m = false;
            this.f38300a = str;
            this.b = uri;
            if (com.ipd.dsp.internal.g0.c.c(uri)) {
                this.k = com.ipd.dsp.internal.g0.c.a(uri);
            }
        }
    }

    public static class c {
        public static long a(f fVar) {
            return fVar.m();
        }

        public static void a(f fVar, long j) {
            fVar.a(j);
        }

        public static void a(@NonNull f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar) {
            fVar.a(bVar);
        }
    }

    public f(String str, Uri uri, int i, int i2, int i3, int i4, int i5, boolean z, int i6, Map<String, List<String>> map, @Nullable String str2, boolean z2, boolean z3, Boolean bool, @Nullable Integer num, @Nullable Boolean bool2) {
        Boolean bool3;
        String name = str2;
        this.i = str;
        this.j = uri;
        this.m = i;
        this.n = i2;
        this.o = i3;
        this.p = i4;
        this.q = i5;
        this.u = z;
        this.v = i6;
        this.k = map;
        this.t = z2;
        this.z = z3;
        this.r = num;
        this.s = bool2;
        if (com.ipd.dsp.internal.g0.c.d(uri)) {
            File file = new File(uri.getPath());
            if (bool != null) {
                if (bool.booleanValue()) {
                    if (file.exists() && file.isFile()) {
                        throw new IllegalArgumentException("If you want filename from response please make sure you provide path is directory " + file.getPath());
                    }
                    if (!com.ipd.dsp.internal.g0.c.a((CharSequence) str2)) {
                        com.ipd.dsp.internal.g0.c.c("DownloadTask", "Discard filename[" + name + "] because you set filenameFromResponse=true");
                        name = null;
                    }
                    this.E = file;
                } else {
                    if (file.exists() && file.isDirectory() && com.ipd.dsp.internal.g0.c.a((CharSequence) str2)) {
                        throw new IllegalArgumentException("If you don't want filename from response please make sure you have already provided valid filename or not directory path " + file.getPath());
                    }
                    if (com.ipd.dsp.internal.g0.c.a((CharSequence) str2)) {
                        name = file.getName();
                        this.E = com.ipd.dsp.internal.g0.c.a(file);
                    } else {
                        this.E = file;
                    }
                }
                bool3 = bool;
            } else if (file.exists() && file.isDirectory()) {
                bool3 = Boolean.TRUE;
                this.E = file;
            } else {
                bool3 = Boolean.FALSE;
                if (file.exists()) {
                    if (!com.ipd.dsp.internal.g0.c.a((CharSequence) str2) && !file.getName().equals(name)) {
                        throw new IllegalArgumentException("Uri already provided filename!");
                    }
                    name = file.getName();
                    this.E = com.ipd.dsp.internal.g0.c.a(file);
                } else if (com.ipd.dsp.internal.g0.c.a((CharSequence) str2)) {
                    name = file.getName();
                    this.E = com.ipd.dsp.internal.g0.c.a(file);
                } else {
                    this.E = file;
                }
            }
            this.B = bool3.booleanValue();
        } else {
            this.B = false;
            this.E = new File(uri.getPath());
        }
        if (com.ipd.dsp.internal.g0.c.a((CharSequence) name)) {
            this.C = new com.ipd.dsp.internal.l0.g.a();
            this.D = this.E;
        } else {
            this.C = new com.ipd.dsp.internal.l0.g.a(name);
            File file2 = new File(this.E, name);
            this.F = file2;
            this.D = file2;
        }
        this.h = h.j().a().a(this);
    }

    public boolean A() {
        return this.t;
    }

    public boolean B() {
        return this.z;
    }

    public synchronized void C() {
        this.y = null;
    }

    public a D() {
        return a(this.i, this.j);
    }

    @Override // com.ipd.dsp.internal.g0.a
    @NonNull
    public File c() {
        return this.E;
    }

    @Override // com.ipd.dsp.internal.g0.a
    @NonNull
    public File d() {
        return this.D;
    }

    @Override // com.ipd.dsp.internal.g0.a
    @NonNull
    public String e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (fVar.h == this.h) {
            return true;
        }
        return a((com.ipd.dsp.internal.g0.a) fVar);
    }

    public void f() {
        h.j().e().a((com.ipd.dsp.internal.g0.a) this);
    }

    public int g() {
        com.ipd.dsp.internal.h0.b bVar = this.l;
        if (bVar == null) {
            return 0;
        }
        return bVar.b();
    }

    @Nullable
    public File h() {
        String strA = this.C.a();
        if (strA == null) {
            return null;
        }
        if (this.F == null) {
            this.F = new File(this.E, strA);
        }
        return this.F;
    }

    public int hashCode() {
        return (this.i + this.D.toString() + this.C.a()).hashCode();
    }

    public com.ipd.dsp.internal.l0.g.a i() {
        return this.C;
    }

    public int j() {
        return this.o;
    }

    @Nullable
    public Map<String, List<String>> k() {
        return this.k;
    }

    @Nullable
    public com.ipd.dsp.internal.h0.b l() {
        if (this.l == null) {
            this.l = h.j().a().get(this.h);
        }
        return this.l;
    }

    public long m() {
        return this.A.get();
    }

    public com.ipd.dsp.internal.f0.c n() {
        return this.w;
    }

    public int o() {
        return this.v;
    }

    public int p() {
        return this.m;
    }

    public int q() {
        return this.n;
    }

    @Nullable
    public String r() {
        return this.G;
    }

    @Nullable
    public Integer s() {
        return this.r;
    }

    @Nullable
    public Boolean t() {
        return this.s;
    }

    public String toString() {
        return super.toString() + "@" + this.h + "@" + this.i + "@" + this.E.toString() + WVNativeCallbackUtil.SEPERATER + this.C.a();
    }

    public int u() {
        return this.q;
    }

    public int v() {
        return this.p;
    }

    public Object w() {
        return this.y;
    }

    public Uri x() {
        return this.j;
    }

    public boolean y() {
        return this.u;
    }

    public boolean z() {
        return this.B;
    }

    @Override // com.ipd.dsp.internal.g0.a
    @Nullable
    public String a() {
        return this.C.a();
    }

    @Override // com.ipd.dsp.internal.g0.a
    public int b() {
        return this.h;
    }

    public void c(@NonNull com.ipd.dsp.internal.f0.c cVar) {
        this.w = cVar;
    }

    public synchronized void d(int i) {
        if (this.x != null) {
            this.x.remove(i);
        }
    }

    public void a(@Nullable String str) {
        this.G = str;
    }

    public void b(com.ipd.dsp.internal.f0.c cVar) {
        this.w = cVar;
        h.j().e().d(this);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull f fVar) {
        return fVar.p() - p();
    }

    public void d(f fVar) {
        this.y = fVar.y;
        this.x = fVar.x;
    }

    public static b c(int i) {
        return new b(i);
    }

    public Object a(int i) {
        if (this.x == null) {
            return null;
        }
        return this.x.get(i);
    }

    public void a(long j) {
        this.A.set(j);
    }

    @NonNull
    public b b(int i) {
        return new b(i, this);
    }

    public static class b extends com.ipd.dsp.internal.g0.a {
        public final int h;

        @NonNull
        public final String i;

        @NonNull
        public final File j;

        @Nullable
        public final String k;

        @NonNull
        public final File l;

        public b(int i) {
            this.h = i;
            this.i = "";
            File file = com.ipd.dsp.internal.g0.a.g;
            this.j = file;
            this.k = null;
            this.l = file;
        }

        @Override // com.ipd.dsp.internal.g0.a
        @Nullable
        public String a() {
            return this.k;
        }

        @Override // com.ipd.dsp.internal.g0.a
        public int b() {
            return this.h;
        }

        @Override // com.ipd.dsp.internal.g0.a
        @NonNull
        public File c() {
            return this.l;
        }

        @Override // com.ipd.dsp.internal.g0.a
        @NonNull
        public File d() {
            return this.j;
        }

        @Override // com.ipd.dsp.internal.g0.a
        @NonNull
        public String e() {
            return this.i;
        }

        public b(int i, @NonNull f fVar) {
            this.h = i;
            this.i = fVar.i;
            this.l = fVar.c();
            this.j = fVar.D;
            this.k = fVar.a();
        }
    }

    public void a(@NonNull com.ipd.dsp.internal.h0.b bVar) {
        this.l = bVar;
    }

    public synchronized f a(int i, Object obj) {
        if (this.x == null) {
            synchronized (this) {
                if (this.x == null) {
                    this.x = new SparseArray<>();
                }
            }
        }
        this.x.put(i, obj);
        return this;
    }

    public void a(Object obj) {
        this.y = obj;
    }

    public static void a(f[] fVarArr, com.ipd.dsp.internal.f0.c cVar) {
        for (f fVar : fVarArr) {
            fVar.w = cVar;
        }
        h.j().e().a(fVarArr);
    }

    public void a(com.ipd.dsp.internal.f0.c cVar) {
        this.w = cVar;
        h.j().e().a(this);
    }

    public static void a(f[] fVarArr) {
        h.j().e().a((com.ipd.dsp.internal.g0.a[]) fVarArr);
    }

    public a a(String str, Uri uri) {
        a aVarB = new a(str, uri).d(this.m).e(this.n).b(this.o).g(this.p).f(this.q).a(this.u).c(this.v).a(this.k).b(this.t);
        if (com.ipd.dsp.internal.g0.c.d(uri) && !new File(uri.getPath()).isFile() && com.ipd.dsp.internal.g0.c.d(this.j) && this.C.a() != null && !new File(this.j.getPath()).getName().equals(this.C.a())) {
            aVarB.a(this.C.a());
        }
        return aVarB;
    }
}
