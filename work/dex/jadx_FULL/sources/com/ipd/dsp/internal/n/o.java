package com.ipd.dsp.internal.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface o<Model, Data> {

    public static class a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ipd.dsp.internal.f.f f38436a;
        public final List<com.ipd.dsp.internal.f.f> b;
        public final com.ipd.dsp.internal.g.d<Data> c;

        public a(@NonNull com.ipd.dsp.internal.f.f fVar, @NonNull com.ipd.dsp.internal.g.d<Data> dVar) {
            this(fVar, Collections.EMPTY_LIST, dVar);
        }

        public a(@NonNull com.ipd.dsp.internal.f.f fVar, @NonNull List<com.ipd.dsp.internal.f.f> list, @NonNull com.ipd.dsp.internal.g.d<Data> dVar) {
            this.f38436a = (com.ipd.dsp.internal.f.f) com.ipd.dsp.internal.d0.m.a(fVar);
            this.b = (List) com.ipd.dsp.internal.d0.m.a(list);
            this.c = (com.ipd.dsp.internal.g.d) com.ipd.dsp.internal.d0.m.a(dVar);
        }
    }

    @Nullable
    a<Data> a(@NonNull Model model, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar);

    boolean a(@NonNull Model model);
}
