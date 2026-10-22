package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class z implements f, f.a {
    public static final String m = "SourceGenerator";
    public final g<?> f;
    public final f.a g;
    public volatile int h;
    public volatile c i;
    public volatile Object j;
    public volatile com.ipd.dsp.internal.n.o.a<?> k;
    public volatile d l;

    public class a implements com.ipd.dsp.internal.g.d.a<Object> {
        public final /* synthetic */ com.ipd.dsp.internal.n.o.a f;

        public a(com.ipd.dsp.internal.n.o.a aVar) {
            this.f = aVar;
        }

        @Override // com.ipd.dsp.internal.g.d.a
        public void a(@Nullable Object obj) {
            if (z.this.a(this.f)) {
                z.this.a(this.f, obj);
            }
        }

        @Override // com.ipd.dsp.internal.g.d.a
        public void onLoadFailed(@NonNull Exception exc) {
            if (z.this.a(this.f)) {
                z.this.a(this.f, exc);
            }
        }
    }

    public z(g<?> gVar, f.a aVar) {
        this.f = gVar;
        this.g = aVar;
    }

    public boolean a(com.ipd.dsp.internal.n.o.a<?> aVar) {
        com.ipd.dsp.internal.n.o.a<?> aVar2 = this.k;
        return aVar2 != null && aVar2 == aVar;
    }

    @Override // com.ipd.dsp.internal.i.f
    public boolean b() {
        if (this.j != null) {
            Object obj = this.j;
            this.j = null;
            try {
                if (!a(obj)) {
                    return true;
                }
            } catch (IOException e) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(m, "Failed to properly rewind or write data to cache", e);
                }
            }
        }
        if (this.i != null && this.i.b()) {
            return true;
        }
        this.i = null;
        this.k = null;
        boolean z = false;
        while (!z && c()) {
            List<com.ipd.dsp.internal.n.o.a<?>> listG = this.f.g();
            int i = this.h;
            this.h = i + 1;
            this.k = listG.get(i);
            if (this.k != null && (this.f.e().a(this.k.c.c()) || this.f.c(this.k.c.a()))) {
                b(this.k);
                z = true;
            }
        }
        return z;
    }

    public final boolean c() {
        return this.h < this.f.g().size();
    }

    @Override // com.ipd.dsp.internal.i.f
    public void cancel() {
        com.ipd.dsp.internal.n.o.a<?> aVar = this.k;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    public final boolean a(Object obj) throws Throwable {
        long jA = com.ipd.dsp.internal.d0.i.a();
        boolean z = false;
        try {
            com.ipd.dsp.internal.components.glide.load.data.a<T> aVarA = this.f.a(obj);
            Object objC = aVarA.c();
            com.ipd.dsp.internal.f.d<X> dVarB = this.f.b(objC);
            e eVar = new e(dVarB, objC, this.f.i());
            d dVar = new d(this.k.f38436a, this.f.l());
            com.ipd.dsp.internal.k.a aVarD = this.f.d();
            aVarD.a(dVar, eVar);
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(m, "Finished encoding source to cache, key: " + dVar + ", data: " + obj + ", encoder: " + dVarB + ", duration: " + com.ipd.dsp.internal.d0.i.a(jA));
            }
            if (aVarD.b(dVar) != null) {
                this.l = dVar;
                this.i = new c(Collections.singletonList(this.k.f38436a), this.f, this);
                this.k.c.b();
                return true;
            }
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(m, "Attempt to write: " + this.l + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.g.a(this.k.f38436a, aVarA.c(), this.k.c, this.k.c.c(), this.k.f38436a);
                return false;
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    this.k.c.b();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void b(com.ipd.dsp.internal.n.o.a<?> aVar) {
        this.k.c.a(this.f.j(), new a(aVar));
    }

    public void a(com.ipd.dsp.internal.n.o.a<?> aVar, Object obj) {
        j jVarE = this.f.e();
        if (obj != null && jVarE.a(aVar.c.c())) {
            this.j = obj;
            this.g.a();
        } else {
            f.a aVar2 = this.g;
            com.ipd.dsp.internal.f.f fVar = aVar.f38436a;
            com.ipd.dsp.internal.g.d<?> dVar = aVar.c;
            aVar2.a(fVar, obj, dVar, dVar.c(), this.l);
        }
    }

    public void a(com.ipd.dsp.internal.n.o.a<?> aVar, @NonNull Exception exc) {
        f.a aVar2 = this.g;
        d dVar = this.l;
        com.ipd.dsp.internal.g.d<?> dVar2 = aVar.c;
        aVar2.a(dVar, exc, dVar2, dVar2.c());
    }

    @Override // com.ipd.dsp.internal.i.f.a
    public void a() {
        throw new UnsupportedOperationException();
    }

    @Override // com.ipd.dsp.internal.i.f.a
    public void a(com.ipd.dsp.internal.f.f fVar, Object obj, com.ipd.dsp.internal.g.d<?> dVar, com.ipd.dsp.internal.f.a aVar, com.ipd.dsp.internal.f.f fVar2) {
        this.g.a(fVar, obj, dVar, this.k.c.c(), fVar);
    }

    @Override // com.ipd.dsp.internal.i.f.a
    public void a(com.ipd.dsp.internal.f.f fVar, Exception exc, com.ipd.dsp.internal.g.d<?> dVar, com.ipd.dsp.internal.f.a aVar) {
        this.g.a(fVar, exc, dVar, this.k.c.c());
    }
}
