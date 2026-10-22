package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class w implements f, com.ipd.dsp.internal.g.d.a<Object> {
    public final f.a f;
    public final g<?> g;
    public int h;
    public int i = -1;
    public com.ipd.dsp.internal.f.f j;
    public List<com.ipd.dsp.internal.n.o<File, ?>> k;
    public int l;
    public volatile com.ipd.dsp.internal.n.o.a<?> m;
    public File n;
    public x o;

    public w(g<?> gVar, f.a aVar) {
        this.g = gVar;
        this.f = aVar;
    }

    private boolean a() {
        return this.l < this.k.size();
    }

    @Override // com.ipd.dsp.internal.i.f
    public boolean b() {
        com.ipd.dsp.internal.e0.b.a("ResourceCacheGenerator.startNext");
        try {
            List<com.ipd.dsp.internal.f.f> listC = this.g.c();
            boolean z = false;
            if (listC.isEmpty()) {
                com.ipd.dsp.internal.e0.b.a();
                return false;
            }
            List<Class<?>> listK = this.g.k();
            if (listK.isEmpty()) {
                if (File.class.equals(this.g.m())) {
                    com.ipd.dsp.internal.e0.b.a();
                    return false;
                }
                throw new IllegalStateException("Failed to find any load path from " + this.g.h() + " to " + this.g.m());
            }
            while (true) {
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
                if (i2 >= listK.size()) {
                    int i3 = this.h + 1;
                    this.h = i3;
                    if (i3 >= listC.size()) {
                        com.ipd.dsp.internal.e0.b.a();
                        return false;
                    }
                    this.i = 0;
                }
                com.ipd.dsp.internal.f.f fVar = listC.get(this.h);
                Class<?> cls = listK.get(this.i);
                this.o = new x(this.g.b(), fVar, this.g.l(), this.g.n(), this.g.f(), this.g.b((Class) cls), cls, this.g.i());
                File fileB = this.g.d().b(this.o);
                this.n = fileB;
                if (fileB != null) {
                    this.j = fVar;
                    this.k = this.g.a(fileB);
                    this.l = 0;
                }
            }
        } catch (Throwable th) {
            com.ipd.dsp.internal.e0.b.a();
            throw th;
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
        this.f.a(this.o, exc, this.m.c, com.ipd.dsp.internal.f.a.RESOURCE_DISK_CACHE);
    }

    @Override // com.ipd.dsp.internal.g.d.a
    public void a(Object obj) {
        this.f.a(this.j, obj, this.m.c, com.ipd.dsp.internal.f.a.RESOURCE_DISK_CACHE, this.o);
    }
}
