package com.ipd.dsp.internal.h0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.l0.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38316a;
    public final String b;
    public String c;

    @NonNull
    public final File d;

    @Nullable
    public File e;
    public final g.a f;
    public final List<a> g = new ArrayList();
    public final boolean h;
    public boolean i;

    public b(int i, @NonNull String str, @NonNull File file, @Nullable String str2) {
        this.f38316a = i;
        this.b = str;
        this.d = file;
        if (com.ipd.dsp.internal.g0.c.a((CharSequence) str2)) {
            this.f = new g.a();
            this.h = true;
        } else {
            this.f = new g.a(str2);
            this.h = false;
            this.e = new File(file, str2);
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    public a b(int i) {
        return this.g.get(i);
    }

    public boolean c(int i) {
        return i == this.g.size() - 1;
    }

    @Nullable
    public File d() {
        String strA = this.f.a();
        if (strA == null) {
            return null;
        }
        if (this.e == null) {
            this.e = new File(this.d, strA);
        }
        return this.e;
    }

    @Nullable
    public String e() {
        return this.f.a();
    }

    public g.a f() {
        return this.f;
    }

    public int g() {
        return this.f38316a;
    }

    public long h() {
        if (k()) {
            return i();
        }
        Object[] array = this.g.toArray();
        long jB = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof a) {
                    jB += ((a) obj).b();
                }
            }
        }
        return jB;
    }

    public long i() {
        Object[] array = this.g.toArray();
        long jC = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof a) {
                    jC += ((a) obj).c();
                }
            }
        }
        return jC;
    }

    public String j() {
        return this.b;
    }

    public boolean k() {
        return this.i;
    }

    public boolean l() {
        return this.g.size() == 1;
    }

    public boolean m() {
        return this.h;
    }

    public void n() {
        this.g.clear();
    }

    public void o() {
        this.g.clear();
        this.c = null;
    }

    public String toString() {
        return "id[" + this.f38316a + "] url[" + this.b + "] etag[" + this.c + "] taskOnlyProvidedParentPath[" + this.h + "] parent path[" + this.d + "] filename[" + this.f.a() + "] block(s):" + this.g.toString();
    }

    public void a(a aVar) {
        this.g.add(aVar);
    }

    public int b() {
        return this.g.size();
    }

    @Nullable
    public String c() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public b a() {
        b bVar = new b(this.f38316a, this.b, this.d, this.f.a(), this.h);
        bVar.i = this.i;
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            bVar.g.add(it.next().a());
        }
        return bVar;
    }

    public b a(int i) {
        b bVar = new b(i, this.b, this.d, this.f.a(), this.h);
        bVar.i = this.i;
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            bVar.g.add(it.next().a());
        }
        return bVar;
    }

    public b(int i, @NonNull String str, @NonNull File file, @Nullable String str2, boolean z) {
        this.f38316a = i;
        this.b = str;
        this.d = file;
        if (com.ipd.dsp.internal.g0.c.a((CharSequence) str2)) {
            this.f = new g.a();
        } else {
            this.f = new g.a(str2);
        }
        this.h = z;
    }

    public void a(b bVar) {
        this.g.clear();
        this.g.addAll(bVar.g);
    }

    public b a(int i, String str) {
        b bVar = new b(i, str, this.d, this.f.a(), this.h);
        bVar.i = this.i;
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            bVar.g.add(it.next().a());
        }
        return bVar;
    }

    public boolean a(com.ipd.dsp.internal.f0.f fVar) {
        if (!this.d.equals(fVar.c()) || !this.b.equals(fVar.e())) {
            return false;
        }
        String strA = fVar.a();
        if (strA != null && strA.equals(this.f.a())) {
            return true;
        }
        if (this.h && fVar.z()) {
            return strA == null || strA.equals(this.f.a());
        }
        return false;
    }
}
