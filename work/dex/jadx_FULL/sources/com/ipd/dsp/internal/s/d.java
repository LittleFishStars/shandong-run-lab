package com.ipd.dsp.internal.s;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.d0.m;
import com.ipd.dsp.internal.i.r;
import com.ipd.dsp.internal.i.v;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class d<T extends Drawable> implements v<T>, r {
    public final T f;

    public d(T t) {
        this.f = (T) m.a(t);
    }

    public void a() {
        T t = this.f;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof com.ipd.dsp.internal.u.c) {
            ((com.ipd.dsp.internal.u.c) t).e().prepareToDraw();
        }
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.f.getConstantState();
        return constantState == null ? this.f : (T) constantState.newDrawable();
    }
}
