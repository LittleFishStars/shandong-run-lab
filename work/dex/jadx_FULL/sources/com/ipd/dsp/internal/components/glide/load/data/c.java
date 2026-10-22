package com.ipd.dsp.internal.components.glide.load.data;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.q.e0;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c implements com.ipd.dsp.internal.components.glide.load.data.a<InputStream> {
    public static final int b = 5242880;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f38261a;

    public static final class a implements com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ipd.dsp.internal.j.b f38262a;

        public a(com.ipd.dsp.internal.j.b bVar) {
            this.f38262a = bVar;
        }

        @Override // com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a
        @NonNull
        public com.ipd.dsp.internal.components.glide.load.data.a<InputStream> a(InputStream inputStream) {
            return new c(inputStream, this.f38262a);
        }

        @Override // com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public c(InputStream inputStream, com.ipd.dsp.internal.j.b bVar) {
        e0 e0Var = new e0(inputStream, bVar);
        this.f38261a = e0Var;
        e0Var.mark(5242880);
    }

    public void a() {
        this.f38261a.a();
    }

    @Override // com.ipd.dsp.internal.components.glide.load.data.a
    public void b() {
        this.f38261a.b();
    }

    @Override // com.ipd.dsp.internal.components.glide.load.data.a
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream c() throws IOException {
        this.f38261a.reset();
        return this.f38261a;
    }
}
