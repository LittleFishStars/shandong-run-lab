package com.kc.aw;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _o5 implements _d3._d {
    public final ImageView _a;

    public _o5(ImageView imageView) {
        this._a = imageView;
    }

    @Override // com.kc.aw._d3._g
    public final void _a(Bitmap bitmap) {
        try {
            ImageView imageView = this._a;
            if (imageView == null || bitmap == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
        } catch (Exception unused) {
        }
    }

    @Override // com.kc.aw._d3._d
    public final void _a(Exception exc) {
    }
}
