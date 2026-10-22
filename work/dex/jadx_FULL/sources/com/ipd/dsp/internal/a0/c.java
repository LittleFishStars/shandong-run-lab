package com.ipd.dsp.internal.a0;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends j<Bitmap> {
    public c(ImageView imageView) {
        super(imageView);
    }

    @Override // com.ipd.dsp.internal.a0.j
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(Bitmap bitmap) {
        ((ImageView) this.g).setImageBitmap(bitmap);
    }

    @Deprecated
    public c(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
