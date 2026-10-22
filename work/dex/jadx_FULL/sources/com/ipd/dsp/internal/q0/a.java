package com.ipd.dsp.internal.q0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a implements com.ipd.dsp.internal.f0.c, com.ipd.dsp.internal.r0.a.InterfaceC0914a, com.ipd.dsp.internal.r0.d {
    final com.ipd.dsp.internal.r0.a assist;

    public a(com.ipd.dsp.internal.r0.a aVar) {
        this.assist = aVar;
        aVar.a(this);
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void connectEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, int i2, @NonNull Map<String, List<String>> map) {
        this.assist.a(fVar);
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void connectStart(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, @NonNull Map<String, List<String>> map) {
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void connectTrialEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, @NonNull Map<String, List<String>> map) {
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void connectTrialStart(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull Map<String, List<String>> map) {
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void downloadFromBeginning(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull com.ipd.dsp.internal.i0.b bVar2) {
        this.assist.a(fVar, bVar, bVar2);
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void downloadFromBreakpoint(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar) {
        this.assist.a(fVar, bVar);
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void fetchEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, long j) {
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void fetchProgress(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, long j) {
        this.assist.a(fVar, j);
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void fetchStart(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, long j) {
    }

    @Override // com.ipd.dsp.internal.r0.d
    public boolean isAlwaysRecoverAssistModel() {
        return this.assist.isAlwaysRecoverAssistModel();
    }

    @Override // com.ipd.dsp.internal.r0.d
    public void setAlwaysRecoverAssistModel(boolean z) {
        this.assist.setAlwaysRecoverAssistModel(z);
    }

    @Override // com.ipd.dsp.internal.r0.d
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        this.assist.setAlwaysRecoverAssistModelIfNotSet(z);
    }

    @Override // com.ipd.dsp.internal.f0.c
    public final void taskEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc) {
        this.assist.a(fVar, aVar, exc);
    }

    @Override // com.ipd.dsp.internal.f0.c
    public final void taskStart(@NonNull com.ipd.dsp.internal.f0.f fVar) {
        this.assist.b(fVar);
    }

    public a() {
        this(new com.ipd.dsp.internal.r0.a());
    }
}
