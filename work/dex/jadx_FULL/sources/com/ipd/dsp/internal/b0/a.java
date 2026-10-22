package com.ipd.dsp.internal.b0;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a<R> implements g<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g<Drawable> f38194a;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.b0.a$a, reason: collision with other inner class name */
    public final class C0860a implements f<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f<Drawable> f38195a;

        public C0860a(f<Drawable> fVar) {
            this.f38195a = fVar;
        }

        @Override // com.ipd.dsp.internal.b0.f
        public boolean a(R r, f.a aVar) {
            return this.f38195a.a(new BitmapDrawable(aVar.getView().getResources(), a.this.a(r)), aVar);
        }
    }

    public a(g<Drawable> gVar) {
        this.f38194a = gVar;
    }

    public abstract Bitmap a(R r);

    @Override // com.ipd.dsp.internal.b0.g
    public f<R> a(com.ipd.dsp.internal.f.a aVar, boolean z) {
        return new C0860a(this.f38194a.a(aVar, z));
    }
}
