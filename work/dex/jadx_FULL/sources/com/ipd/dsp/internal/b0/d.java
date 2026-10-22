package com.ipd.dsp.internal.b0;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d implements f<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38198a;
    public final boolean b;

    public d(int i, boolean z) {
        this.f38198a = i;
        this.b = z;
    }

    @Override // com.ipd.dsp.internal.b0.f
    public boolean a(Drawable drawable, f.a aVar) {
        Drawable drawableA = aVar.a();
        if (drawableA == null) {
            drawableA = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableA, drawable});
        transitionDrawable.setCrossFadeEnabled(this.b);
        transitionDrawable.startTransition(this.f38198a);
        aVar.a(transitionDrawable);
        return true;
    }
}
