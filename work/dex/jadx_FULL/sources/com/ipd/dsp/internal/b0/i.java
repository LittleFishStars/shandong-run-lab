package com.ipd.dsp.internal.b0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class i<R> implements g<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j.a f38203a;
    public j<R> b;

    public i(j.a aVar) {
        this.f38203a = aVar;
    }

    @Override // com.ipd.dsp.internal.b0.g
    public f<R> a(com.ipd.dsp.internal.f.a aVar, boolean z) {
        if (aVar == com.ipd.dsp.internal.f.a.MEMORY_CACHE || !z) {
            return e.a();
        }
        if (this.b == null) {
            this.b = new j<>(this.f38203a);
        }
        return this.b;
    }
}
