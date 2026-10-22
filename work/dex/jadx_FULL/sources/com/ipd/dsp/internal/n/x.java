package com.ipd.dsp.internal.n;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class x<Model> implements o<Model, Model> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x<?> f38453a = new x<>();

    public static class a<Model> implements p<Model, Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<?> f38454a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> a() {
            return (a<T>) f38454a;
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Model, Model> a(s sVar) {
            return x.a();
        }
    }

    public static class b<Model> implements com.ipd.dsp.internal.g.d<Model> {
        public final Model f;

        public b(Model model) {
            this.f = model;
        }

        @Override // com.ipd.dsp.internal.g.d
        public void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull com.ipd.dsp.internal.g.d.a<? super Model> aVar) {
            aVar.a(this.f);
        }

        @Override // com.ipd.dsp.internal.g.d
        public void b() {
        }

        @Override // com.ipd.dsp.internal.g.d
        @NonNull
        public com.ipd.dsp.internal.f.a c() {
            return com.ipd.dsp.internal.f.a.LOCAL;
        }

        @Override // com.ipd.dsp.internal.g.d
        public void cancel() {
        }

        @Override // com.ipd.dsp.internal.g.d
        @NonNull
        public Class<Model> a() {
            return (Class<Model>) this.f.getClass();
        }
    }

    @Deprecated
    public x() {
    }

    public static <T> x<T> a() {
        return (x<T>) f38453a;
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull Model model) {
        return true;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<Model> a(@NonNull Model model, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return new o.a<>(new com.ipd.dsp.internal.c0.e(model), new b(model));
    }
}
