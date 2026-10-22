package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class i0 implements com.ipd.dsp.internal.f.k<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f38499a;
    public final com.ipd.dsp.internal.j.b b;

    public static class a implements r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e0 f38500a;
        public final com.ipd.dsp.internal.d0.e b;

        public a(e0 e0Var, com.ipd.dsp.internal.d0.e eVar) {
            this.f38500a = e0Var;
            this.b = eVar;
        }

        @Override // com.ipd.dsp.internal.q.r.b
        public void a() {
            this.f38500a.a();
        }

        @Override // com.ipd.dsp.internal.q.r.b
        public void a(com.ipd.dsp.internal.j.e eVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionB = this.b.b();
            if (iOExceptionB != null) {
                if (bitmap == null) {
                    throw iOExceptionB;
                }
                eVar.a(bitmap);
                throw iOExceptionB;
            }
        }
    }

    public i0(r rVar, com.ipd.dsp.internal.j.b bVar) {
        this.f38499a = rVar;
        this.b = bVar;
    }

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull InputStream inputStream, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return this.f38499a.a(inputStream);
    }

    @Override // com.ipd.dsp.internal.f.k
    public com.ipd.dsp.internal.i.v<Bitmap> a(@NonNull InputStream inputStream, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        boolean z;
        e0 e0Var;
        if (inputStream instanceof e0) {
            e0Var = (e0) inputStream;
            z = false;
        } else {
            z = true;
            e0Var = new e0(inputStream, this.b);
        }
        com.ipd.dsp.internal.d0.e eVarA = com.ipd.dsp.internal.d0.e.a(e0Var);
        try {
            return this.f38499a.a(new com.ipd.dsp.internal.d0.k(eVarA), i, i2, iVar, new a(e0Var, eVarA));
        } finally {
            eVarA.c();
            if (z) {
                e0Var.b();
            }
        }
    }
}
