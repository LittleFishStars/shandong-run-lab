package com.kc.aw;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _f0 implements _mk {
    public final ImageView _a;
    public final int _b;

    public _f0(ImageView imageView, int i) {
        this._a = imageView;
        this._b = i;
    }

    @Override // com.kc.aw._mk
    public final void _a(Object obj) {
        if (obj instanceof Bitmap) {
            this._a.setImageBitmap((Bitmap) obj);
        } else {
            this._a.setImageResource(this._b);
        }
    }
}
