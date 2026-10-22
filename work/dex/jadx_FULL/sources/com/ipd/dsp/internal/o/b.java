package com.ipd.dsp.internal.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.n.h;
import com.ipd.dsp.internal.n.n;
import com.ipd.dsp.internal.n.o;
import com.ipd.dsp.internal.n.p;
import com.ipd.dsp.internal.n.s;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements o<h, InputStream> {
    public static final com.ipd.dsp.internal.f.h<Integer> b = com.ipd.dsp.internal.f.h.a("com.ipd.dsp.internal.components.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final n<h, h> f38468a;

    public static class a implements p<h, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n<h, h> f38469a = new n<>(500);

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<h, InputStream> a(s sVar) {
            return new b(this.f38469a);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public b() {
        this(null);
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull h hVar) {
        return true;
    }

    public b(@Nullable n<h, h> nVar) {
        this.f38468a = nVar;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<InputStream> a(@NonNull h hVar, int i, int i2, @NonNull i iVar) {
        n<h, h> nVar = this.f38468a;
        if (nVar != null) {
            h hVarA = nVar.a(hVar, 0, 0);
            if (hVarA == null) {
                this.f38468a.a(hVar, 0, 0, hVar);
            } else {
                hVar = hVarA;
            }
        }
        return new o.a<>(hVar, new com.ipd.dsp.internal.g.h(hVar, ((Integer) iVar.a(b)).intValue()));
    }
}
