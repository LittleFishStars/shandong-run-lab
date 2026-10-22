package com.ipd.dsp.internal.r0;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f0.f;
import com.ipd.dsp.internal.r0.b.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b<T extends c> implements d {
    public InterfaceC0915b f;
    public a g;
    public final e<T> h;

    public interface a {
        boolean a(@NonNull f fVar, int i, long j, @NonNull c cVar);

        boolean a(f fVar, int i, c cVar);

        boolean a(f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, boolean z, @NonNull c cVar);

        boolean a(f fVar, com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc, @NonNull c cVar);
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.r0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0915b {
        void a(f fVar, int i, long j);

        void a(f fVar, int i, com.ipd.dsp.internal.h0.a aVar);

        void a(f fVar, long j);

        void a(f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, boolean z, @NonNull c cVar);

        void a(f fVar, com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc, @NonNull c cVar);
    }

    public static class c implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38526a;
        public com.ipd.dsp.internal.h0.b b;
        public long c;
        public SparseArray<Long> d;

        public c(int i) {
            this.f38526a = i;
        }

        public long a(int i) {
            return this.d.get(i).longValue();
        }

        public SparseArray<Long> b() {
            return this.d;
        }

        public long c() {
            return this.c;
        }

        public com.ipd.dsp.internal.h0.b d() {
            return this.b;
        }

        @Override // com.ipd.dsp.internal.r0.e.a
        public int getId() {
            return this.f38526a;
        }

        public SparseArray<Long> a() {
            return this.d.clone();
        }

        @Override // com.ipd.dsp.internal.r0.e.a
        public void a(@NonNull com.ipd.dsp.internal.h0.b bVar) {
            this.b = bVar;
            this.c = bVar.i();
            SparseArray<Long> sparseArray = new SparseArray<>();
            int iB = bVar.b();
            for (int i = 0; i < iB; i++) {
                sparseArray.put(i, Long.valueOf(bVar.b(i).c()));
            }
            this.d = sparseArray;
        }
    }

    public b(e<T> eVar) {
        this.h = eVar;
    }

    public void a(@NonNull InterfaceC0915b interfaceC0915b) {
        this.f = interfaceC0915b;
    }

    @Override // com.ipd.dsp.internal.r0.d
    public boolean isAlwaysRecoverAssistModel() {
        return this.h.isAlwaysRecoverAssistModel();
    }

    @Override // com.ipd.dsp.internal.r0.d
    public void setAlwaysRecoverAssistModel(boolean z) {
        this.h.setAlwaysRecoverAssistModel(z);
    }

    @Override // com.ipd.dsp.internal.r0.d
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        this.h.setAlwaysRecoverAssistModelIfNotSet(z);
    }

    public void a(@NonNull a aVar) {
        this.g = aVar;
    }

    public b(e.b<T> bVar) {
        this.h = new e<>(bVar);
    }

    public a a() {
        return this.g;
    }

    public void a(f fVar, com.ipd.dsp.internal.h0.b bVar, boolean z) {
        InterfaceC0915b interfaceC0915b;
        c cVar = (c) this.h.a(fVar, bVar);
        a aVar = this.g;
        if ((aVar == null || !aVar.a(fVar, bVar, z, cVar)) && (interfaceC0915b = this.f) != null) {
            interfaceC0915b.a(fVar, bVar, z, cVar);
        }
    }

    public void a(f fVar, int i, long j) {
        InterfaceC0915b interfaceC0915b;
        c cVar = (c) this.h.b(fVar, fVar.l());
        if (cVar == null) {
            return;
        }
        long jLongValue = cVar.d.get(i).longValue() + j;
        cVar.d.put(i, Long.valueOf(jLongValue));
        cVar.c += j;
        a aVar = this.g;
        if ((aVar == null || !aVar.a(fVar, i, j, cVar)) && (interfaceC0915b = this.f) != null) {
            interfaceC0915b.a(fVar, i, jLongValue);
            this.f.a(fVar, cVar.c);
        }
    }

    public void a(f fVar, int i) {
        InterfaceC0915b interfaceC0915b;
        c cVar = (c) this.h.b(fVar, fVar.l());
        if (cVar == null) {
            return;
        }
        a aVar = this.g;
        if ((aVar == null || !aVar.a(fVar, i, cVar)) && (interfaceC0915b = this.f) != null) {
            interfaceC0915b.a(fVar, i, cVar.b.b(i));
        }
    }

    public synchronized void a(f fVar, com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc) {
        InterfaceC0915b interfaceC0915b;
        c cVar = (c) this.h.c(fVar, fVar.l());
        a aVar2 = this.g;
        if ((aVar2 == null || !aVar2.a(fVar, aVar, exc, cVar)) && (interfaceC0915b = this.f) != null) {
            interfaceC0915b.a(fVar, aVar, exc, cVar);
        }
    }
}
