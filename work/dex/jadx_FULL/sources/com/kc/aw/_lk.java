package com.kc.aw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lk implements _d3._d {
    public final Activity _a;
    public final _lg _b;

    public _lk(_lg _lgVar, Activity activity) {
        this._b = _lgVar;
        this._a = activity;
    }

    @Override // com.kc.aw._d3._g
    public final void _a(Bitmap bitmap) {
        _h _hVar = this._b._b;
        if (_hVar != null) {
            _hVar._I = System.currentTimeMillis();
        }
        ImageView imageView = this._b._H;
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
        ProgressBar progressBar = this._b._F;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        _lg _lgVar = this._b;
        Activity activity = this._a;
        if (_lgVar._a6.get()) {
            return;
        }
        _lgVar._a6.set(true);
        FrameLayout frameLayout = _lgVar._G;
        if (frameLayout != null) {
            frameLayout.post(new _lf(_lgVar, activity));
        }
    }

    @Override // com.kc.aw._d3._d
    public final void _a(Exception exc) {
        this._b._a6.set(false);
    }
}
