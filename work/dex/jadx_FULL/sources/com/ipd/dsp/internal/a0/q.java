package com.ipd.dsp.internal.a0;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class q<T> extends j<T> {
    public q(ImageView imageView) {
        super(imageView);
    }

    @Override // com.ipd.dsp.internal.a0.j
    public void c(@Nullable T t) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.g).getLayoutParams();
        Drawable drawableE = e(t);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            drawableE = new i(drawableE, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.g).setImageDrawable(drawableE);
    }

    public abstract Drawable e(T t);

    @Deprecated
    public q(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
