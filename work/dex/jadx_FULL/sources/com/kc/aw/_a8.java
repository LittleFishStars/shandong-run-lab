package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.kc.aw.component.base.AdvertRatioLayout;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a8 implements Runnable {
    public final Bitmap _a;
    public final View _b;
    public final Context _c;

    @Keep
    public final class _a implements Runnable {
        public final Bitmap _a;
        public final _a8 _b;

        public _a(_a8 _a8Var, Bitmap bitmap) {
            this._b = _a8Var;
            this._a = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view;
            if (this._a == null || (view = this._b._b) == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(this._b._c.getResources(), this._a));
        }
    }

    public _a8(Context context, Bitmap bitmap, AdvertRatioLayout advertRatioLayout) {
        this._a = bitmap;
        this._b = advertRatioLayout;
        this._c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap_a;
        try {
            bitmap_a = _a9._a(this._a);
        } catch (Exception unused) {
            bitmap_a = null;
        }
        if (bitmap_a == null) {
            return;
        }
        _fz._a.post(new _a(this, bitmap_a));
    }
}
