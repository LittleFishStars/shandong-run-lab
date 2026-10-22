package com.ipd.dsp.internal.r0;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f0.f;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements d, e.b<b> {
    public final e<b> f;
    public InterfaceC0914a g;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.r0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0914a {
        void connected(@NonNull f fVar, @IntRange(from = 0) int i, @IntRange(from = 0) long j, @IntRange(from = 0) long j2);

        void progress(@NonNull f fVar, @IntRange(from = 0) long j, @IntRange(from = 0) long j2);

        void retry(@NonNull f fVar, @NonNull com.ipd.dsp.internal.i0.b bVar);

        void taskEnd(@NonNull f fVar, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc, @NonNull b bVar);

        void taskStart(@NonNull f fVar, @NonNull b bVar);
    }

    public static class b implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38525a;
        public Boolean b;
        public Boolean c;
        public volatile Boolean d;
        public int e;
        public long f;
        public final AtomicLong g = new AtomicLong();

        public b(int i) {
            this.f38525a = i;
        }

        public long a() {
            return this.f;
        }

        @Override // com.ipd.dsp.internal.r0.e.a
        public int getId() {
            return this.f38525a;
        }

        @Override // com.ipd.dsp.internal.r0.e.a
        public void a(@NonNull com.ipd.dsp.internal.h0.b bVar) {
            this.e = bVar.b();
            this.f = bVar.h();
            this.g.set(bVar.i());
            if (this.b == null) {
                this.b = Boolean.FALSE;
            }
            if (this.c == null) {
                this.c = Boolean.valueOf(this.g.get() > 0);
            }
            if (this.d == null) {
                this.d = Boolean.TRUE;
            }
        }
    }

    public a() {
        this.f = new e<>(this);
    }

    public void b(f fVar) {
        b bVar = (b) this.f.a(fVar, null);
        InterfaceC0914a interfaceC0914a = this.g;
        if (interfaceC0914a != null) {
            interfaceC0914a.taskStart(fVar, bVar);
        }
    }

    @Override // com.ipd.dsp.internal.r0.d
    public boolean isAlwaysRecoverAssistModel() {
        return this.f.isAlwaysRecoverAssistModel();
    }

    @Override // com.ipd.dsp.internal.r0.d
    public void setAlwaysRecoverAssistModel(boolean z) {
        this.f.setAlwaysRecoverAssistModel(z);
    }

    @Override // com.ipd.dsp.internal.r0.d
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        this.f.setAlwaysRecoverAssistModelIfNotSet(z);
    }

    public void a(@NonNull InterfaceC0914a interfaceC0914a) {
        this.g = interfaceC0914a;
    }

    public a(e<b> eVar) {
        this.f = eVar;
    }

    public void a(f fVar, com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc) {
        b bVar = (b) this.f.c(fVar, fVar.l());
        InterfaceC0914a interfaceC0914a = this.g;
        if (interfaceC0914a != null) {
            interfaceC0914a.taskEnd(fVar, aVar, exc, bVar);
        }
    }

    @Override // com.ipd.dsp.internal.r0.e.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(int i) {
        return new b(i);
    }

    public void a(f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, com.ipd.dsp.internal.i0.b bVar2) {
        InterfaceC0914a interfaceC0914a;
        b bVar3 = (b) this.f.b(fVar, bVar);
        if (bVar3 == null) {
            return;
        }
        bVar3.a(bVar);
        if (bVar3.b.booleanValue() && (interfaceC0914a = this.g) != null) {
            interfaceC0914a.retry(fVar, bVar2);
        }
        Boolean bool = Boolean.TRUE;
        bVar3.b = bool;
        bVar3.c = Boolean.FALSE;
        bVar3.d = bool;
    }

    public void a(f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar) {
        b bVar2 = (b) this.f.b(fVar, bVar);
        if (bVar2 == null) {
            return;
        }
        bVar2.a(bVar);
        Boolean bool = Boolean.TRUE;
        bVar2.b = bool;
        bVar2.c = bool;
        bVar2.d = bool;
    }

    public void a(f fVar) {
        b bVar = (b) this.f.b(fVar, fVar.l());
        if (bVar == null) {
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (bool.equals(bVar.c) && bool.equals(bVar.d)) {
            bVar.d = Boolean.FALSE;
        }
        InterfaceC0914a interfaceC0914a = this.g;
        if (interfaceC0914a != null) {
            interfaceC0914a.connected(fVar, bVar.e, bVar.g.get(), bVar.f);
        }
    }

    public void a(f fVar, long j) {
        b bVar = (b) this.f.b(fVar, fVar.l());
        if (bVar == null) {
            return;
        }
        bVar.g.addAndGet(j);
        InterfaceC0914a interfaceC0914a = this.g;
        if (interfaceC0914a != null) {
            interfaceC0914a.progress(fVar, bVar.g.get(), bVar.f);
        }
    }
}
