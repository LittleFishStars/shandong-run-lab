package com.ipd.dsp.internal.r0;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f0.f;
import com.ipd.dsp.internal.f0.j;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c implements com.ipd.dsp.internal.r0.b.a, e.b<b> {
    public a f;

    public interface a {
        void a(@NonNull f fVar, int i, long j, @NonNull j jVar);

        void a(@NonNull f fVar, int i, com.ipd.dsp.internal.h0.a aVar, @NonNull j jVar);

        void a(@NonNull f fVar, long j, @NonNull j jVar);

        void a(@NonNull f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, boolean z, @NonNull b bVar2);

        void a(@NonNull f fVar, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc, @NonNull j jVar);
    }

    public static class b extends com.ipd.dsp.internal.r0.b.c {
        public j e;
        public SparseArray<j> f;

        public b(int i) {
            super(i);
        }

        @Override // com.ipd.dsp.internal.r0.b.c, com.ipd.dsp.internal.r0.e.a
        public void a(@NonNull com.ipd.dsp.internal.h0.b bVar) {
            super.a(bVar);
            this.e = new j();
            this.f = new SparseArray<>();
            int iB = bVar.b();
            for (int i = 0; i < iB; i++) {
                this.f.put(i, new j());
            }
        }

        public j b(int i) {
            return this.f.get(i);
        }

        public j e() {
            return this.e;
        }
    }

    @Override // com.ipd.dsp.internal.r0.e.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(int i) {
        return new b(i);
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    @Override // com.ipd.dsp.internal.r0.b.a
    public boolean a(f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, boolean z, @NonNull com.ipd.dsp.internal.r0.b.c cVar) {
        a aVar = this.f;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, bVar, z, (b) cVar);
        return true;
    }

    @Override // com.ipd.dsp.internal.r0.b.a
    public boolean a(@NonNull f fVar, int i, long j, @NonNull com.ipd.dsp.internal.r0.b.c cVar) {
        b bVar = (b) cVar;
        bVar.f.get(i).a(j);
        bVar.e.a(j);
        a aVar = this.f;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, i, cVar.d.get(i).longValue(), bVar.b(i));
        this.f.a(fVar, cVar.c, bVar.e);
        return true;
    }

    @Override // com.ipd.dsp.internal.r0.b.a
    public boolean a(f fVar, int i, com.ipd.dsp.internal.r0.b.c cVar) {
        b bVar = (b) cVar;
        bVar.f.get(i).b();
        a aVar = this.f;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, i, cVar.b.b(i), bVar.b(i));
        return true;
    }

    @Override // com.ipd.dsp.internal.r0.b.a
    public boolean a(f fVar, com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc, @NonNull com.ipd.dsp.internal.r0.b.c cVar) {
        j jVar = ((b) cVar).e;
        if (jVar != null) {
            jVar.b();
        } else {
            jVar = new j();
        }
        a aVar2 = this.f;
        if (aVar2 == null) {
            return true;
        }
        aVar2.a(fVar, aVar, exc, jVar);
        return true;
    }
}
