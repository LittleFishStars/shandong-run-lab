package com.kc.aw;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _an implements _d3._d {
    public final ImageView _a;

    public _an(ImageView imageView) {
        this._a = imageView;
    }

    @Override // com.kc.aw._d3._g
    public final void _a(Bitmap bitmap) {
        ImageView imageView = this._a;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override // com.kc.aw._d3._d
    public final void _a(Exception exc) {
    }
}
