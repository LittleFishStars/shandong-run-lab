package com.ipd.dsp.internal.a0;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g extends j<Drawable> {
    public g(ImageView imageView) {
        super(imageView);
    }

    @Override // com.ipd.dsp.internal.a0.j
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void c(@Nullable Drawable drawable) {
        ((ImageView) this.g).setImageDrawable(drawable);
    }

    @Deprecated
    public g(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
