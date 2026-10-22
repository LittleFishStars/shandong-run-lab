package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class k0 implements com.ipd.dsp.internal.f.k<Bitmap, Bitmap> {

    public static final class a implements com.ipd.dsp.internal.i.v<Bitmap> {
        public final Bitmap f;

        public a(@NonNull Bitmap bitmap) {
            this.f = bitmap;
        }

        @Override // com.ipd.dsp.internal.i.v
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f;
        }

        @Override // com.ipd.dsp.internal.i.v
        public int c() {
            return com.ipd.dsp.internal.d0.o.a(this.f);
        }

        @Override // com.ipd.dsp.internal.i.v
        @NonNull
        public Class<Bitmap> d() {
            return Bitmap.class;
        }

        @Override // com.ipd.dsp.internal.i.v
        public void e() {
        }
    }

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull Bitmap bitmap, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return true;
    }

    @Override // com.ipd.dsp.internal.f.k
    public com.ipd.dsp.internal.i.v<Bitmap> a(@NonNull Bitmap bitmap, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return new a(bitmap);
    }
}
