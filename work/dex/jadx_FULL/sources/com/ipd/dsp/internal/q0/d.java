package com.ipd.dsp.internal.q0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class d implements com.ipd.dsp.internal.f0.c, com.ipd.dsp.internal.r0.b.InterfaceC0915b, com.ipd.dsp.internal.r0.d {
    public final com.ipd.dsp.internal.r0.b f;

    public static class a implements com.ipd.dsp.internal.r0.e.b<com.ipd.dsp.internal.r0.b.c> {
        @Override // com.ipd.dsp.internal.r0.e.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.ipd.dsp.internal.r0.b.c a(int i) {
            return new com.ipd.dsp.internal.r0.b.c(i);
        }
    }

    public d(com.ipd.dsp.internal.r0.b bVar) {
        this.f = bVar;
        bVar.a(this);
    }

    public void a(@NonNull com.ipd.dsp.internal.r0.b.a aVar) {
        this.f.a(aVar);
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void connectTrialEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, @NonNull Map<String, List<String>> map) {
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void connectTrialStart(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull Map<String, List<String>> map) {
    }

    @Override // com.ipd.dsp.internal.f0.c
    public final void downloadFromBeginning(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull com.ipd.dsp.internal.i0.b bVar2) {
        this.f.a(fVar, bVar, false);
    }

    @Override // com.ipd.dsp.internal.f0.c
    public final void downloadFromBreakpoint(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar) {
        this.f.a(fVar, bVar, true);
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void fetchEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, long j) {
        this.f.a(fVar, i);
    }

    @Override // com.ipd.dsp.internal.f0.c
    public final void fetchProgress(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, long j) {
        this.f.a(fVar, i, j);
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void fetchStart(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, long j) {
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

    @Override // com.ipd.dsp.internal.f0.c
    public final void taskEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc) {
        this.f.a(fVar, aVar, exc);
    }

    public d() {
        this(new com.ipd.dsp.internal.r0.b(new a()));
    }
}
