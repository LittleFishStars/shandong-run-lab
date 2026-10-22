package com.ipd.dsp.internal.a0;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d extends q<Bitmap> {
    public d(ImageView imageView) {
        super(imageView);
    }

    @Override // com.ipd.dsp.internal.a0.q
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Drawable e(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.g).getResources(), bitmap);
    }

    @Deprecated
    public d(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
