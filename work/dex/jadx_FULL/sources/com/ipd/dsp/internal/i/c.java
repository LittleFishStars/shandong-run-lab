package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c implements f, com.ipd.dsp.internal.g.d.a<Object> {
    public final List<com.ipd.dsp.internal.f.f> f;
    public final g<?> g;
    public final f.a h;
    public int i;
    public com.ipd.dsp.internal.f.f j;
    public List<com.ipd.dsp.internal.n.o<File, ?>> k;
    public int l;
    public volatile com.ipd.dsp.internal.n.o.a<?> m;
    public File n;

    public c(g<?> gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean a() {
        return this.l < this.k.size();
    }

    @Override // com.ipd.dsp.internal.i.f
    public boolean b() {
        com.ipd.dsp.internal.e0.b.a("DataCacheGenerator.startNext");
        while (true) {
            try {
                boolean z = false;
                if (this.k != null && a()) {
                    this.m = null;
                    while (!z && a()) {
                        List<com.ipd.dsp.internal.n.o<File, ?>> list = this.k;
                        int i = this.l;
                        this.l = i + 1;
                        this.m = list.get(i).a(this.n, this.g.n(), this.g.f(), this.g.i());
                        if (this.m != null && this.g.c(this.m.c.a())) {
                            this.m.c.a(this.g.j(), this);
                            z = true;
                        }
                    }
                    com.ipd.dsp.internal.e0.b.a();
                    return z;
                }
                int i2 = this.i + 1;
                this.i = i2;
                if (i2 >= this.f.size()) {
                    com.ipd.dsp.internal.e0.b.a();
                    return false;
                }
                com.ipd.dsp.internal.f.f fVar = this.f.get(this.i);
                File fileB = this.g.d().b(new d(fVar, this.g.l()));
                this.n = fileB;
                if (fileB != null) {
                    this.j = fVar;
                    this.k = this.g.a(fileB);
                    this.l = 0;
                }
            } catch (Throwable th) {
                com.ipd.dsp.internal.e0.b.a();
                throw th;
            }
        }
    }

    @Override // com.ipd.dsp.internal.i.f
    public void cancel() {
        com.ipd.dsp.internal.n.o.a<?> aVar = this.m;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // com.ipd.dsp.internal.g.d.a
    public void onLoadFailed(@NonNull Exception exc) {
        this.h.a(this.j, exc, this.m.c, com.ipd.dsp.internal.f.a.DATA_DISK_CACHE);
    }

    public c(List<com.ipd.dsp.internal.f.f> list, g<?> gVar, f.a aVar) {
        this.i = -1;
        this.f = list;
        this.g = gVar;
        this.h = aVar;
    }

    @Override // com.ipd.dsp.internal.g.d.a
    public void a(Object obj) {
        this.h.a(this.j, obj, this.m.c, com.ipd.dsp.internal.f.a.DATA_DISK_CACHE, this.j);
    }
}
