package com.ipd.dsp.internal.a0;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class j<Z> extends r<ImageView, Z> implements com.ipd.dsp.internal.b0.f.a {

    @Nullable
    public Animatable o;

    public j(ImageView imageView) {
        super(imageView);
    }

    @Override // com.ipd.dsp.internal.b0.f.a
    @Nullable
    public Drawable a() {
        return ((ImageView) this.g).getDrawable();
    }

    public final void b(@Nullable Z z) {
        if (!(z instanceof Animatable)) {
            this.o = null;
            return;
        }
        Animatable animatable = (Animatable) z;
        this.o = animatable;
        animatable.start();
    }

    public abstract void c(@Nullable Z z);

    public final void d(@Nullable Z z) {
        c(z);
        b(z);
    }

    @Override // com.ipd.dsp.internal.a0.r, com.ipd.dsp.internal.a0.b, com.ipd.dsp.internal.a0.p
    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.o;
        if (animatable != null) {
            animatable.stop();
        }
        d(null);
        a(drawable);
    }

    @Override // com.ipd.dsp.internal.a0.b, com.ipd.dsp.internal.a0.p
    public void onLoadFailed(@Nullable Drawable drawable) {
        super.onLoadFailed(drawable);
        d(null);
        a(drawable);
    }

    @Override // com.ipd.dsp.internal.a0.r, com.ipd.dsp.internal.a0.b, com.ipd.dsp.internal.a0.p
    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        d(null);
        a(drawable);
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void onResourceReady(@NonNull Z z, @Nullable com.ipd.dsp.internal.b0.f<? super Z> fVar) {
        if (fVar == null || !fVar.a(z, this)) {
            d(z);
        } else {
            b(z);
        }
    }

    @Override // com.ipd.dsp.internal.a0.b, com.ipd.dsp.internal.w.k
    public void onStart() {
        Animatable animatable = this.o;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.ipd.dsp.internal.a0.b, com.ipd.dsp.internal.w.k
    public void onStop() {
        Animatable animatable = this.o;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Deprecated
    public j(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    @Override // com.ipd.dsp.internal.b0.f.a
    public void a(Drawable drawable) {
        ((ImageView) this.g).setImageDrawable(drawable);
    }
}
