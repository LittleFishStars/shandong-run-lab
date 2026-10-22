package com.kwad.framework.filedownloader.b;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b implements com.kwad.framework.filedownloader.b.a {
    final SparseArray<com.kwad.framework.filedownloader.d.c> aAv = new SparseArray<>();
    final SparseArray<List<com.kwad.framework.filedownloader.d.a>> aAw = new SparseArray<>();

    public class a implements com.kwad.framework.filedownloader.b.a.InterfaceC1253a {
        public a() {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC1253a
        public final void BS() {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC1253a
        public final void a(int i, com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC1253a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            return b.this.new C1254b();
        }
    }

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.b.b$b, reason: collision with other inner class name */
    public class C1254b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        public C1254b() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwad.framework.filedownloader.d.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        synchronized (this.aAv) {
            this.aAv.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.b.a.InterfaceC1253a BR() {
        return new a();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        List<com.kwad.framework.filedownloader.d.a> arrayList;
        try {
            int id = aVar.getId();
            synchronized (this.aAw) {
                arrayList = this.aAw.get(id);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.aAw.put(id, arrayList);
                }
            }
            arrayList.add(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (cC(cVar.getId()) == null) {
            d(cVar);
            return;
        }
        synchronized (this.aAv) {
            this.aAv.remove(cVar.getId());
            this.aAv.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
        cF(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void cB(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c cC(int i) {
        com.kwad.framework.filedownloader.d.c cVar;
        synchronized (this.aAv) {
            cVar = this.aAv.get(i);
        }
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> cD(int i) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.aAw) {
                list = this.aAw.get(i);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void cE(int i) {
        try {
            synchronized (this.aAw) {
                this.aAw.remove(i);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean cF(int i) {
        synchronized (this.aAv) {
            this.aAv.remove(i);
        }
        return true;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void cG(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        synchronized (this.aAv) {
            this.aAv.clear();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void w(int i, int i2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        List<com.kwad.framework.filedownloader.d.a> list;
        synchronized (this.aAw) {
            list = this.aAw.get(i);
        }
        if (list == null) {
            return;
        }
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.getIndex() == i2) {
                aVar.ad(j);
                return;
            }
        }
    }
}
