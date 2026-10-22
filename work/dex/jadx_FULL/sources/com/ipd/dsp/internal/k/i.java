package com.ipd.dsp.internal.k;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.i.v;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class i extends com.ipd.dsp.internal.d0.j<com.ipd.dsp.internal.f.f, v<?>> implements j {
    public j.a e;

    public i(long j) {
        super(j);
    }

    @Override // com.ipd.dsp.internal.d0.j
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@NonNull com.ipd.dsp.internal.f.f fVar, @Nullable v<?> vVar) {
        j.a aVar = this.e;
        if (aVar == null || vVar == null) {
            return;
        }
        aVar.a(vVar);
    }

    @Override // com.ipd.dsp.internal.k.j
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (i >= 40) {
            a();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ipd.dsp.internal.k.j
    @Nullable
    public /* bridge */ /* synthetic */ v a(@NonNull com.ipd.dsp.internal.f.f fVar, @Nullable v vVar) {
        return (v) super.b(fVar, vVar);
    }

    @Override // com.ipd.dsp.internal.k.j
    @Nullable
    public /* bridge */ /* synthetic */ v a(@NonNull com.ipd.dsp.internal.f.f fVar) {
        return (v) super.d(fVar);
    }

    @Override // com.ipd.dsp.internal.k.j
    public void a(@NonNull j.a aVar) {
        this.e = aVar;
    }

    @Override // com.ipd.dsp.internal.d0.j
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int c(@Nullable v<?> vVar) {
        if (vVar == null) {
            return super.c(null);
        }
        return vVar.c();
    }
}
