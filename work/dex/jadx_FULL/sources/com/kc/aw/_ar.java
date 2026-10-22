package com.kc.aw;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.kc.aw.component.base.AdvertRatioLayout;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ar implements _d3._d {
    public final _d3._d _a;
    public final String _b;
    public final AdvertRatioLayout _c;
    public final ImageView _d;
    public final _am _e;

    public _ar(_am _amVar, _d3._d _dVar, String str, AdvertRatioLayout advertRatioLayout, ImageView imageView) {
        this._e = _amVar;
        this._a = _dVar;
        this._b = str;
        this._c = advertRatioLayout;
        this._d = imageView;
    }

    @Override // com.kc.aw._d3._g
    public final void _a(Bitmap bitmap) throws Throwable {
        _am _amVar = this._e;
        _hy _hyVar = _amVar._n;
        if (_hyVar != null && _hyVar._b) {
            _aw._a(_amVar.getContext(), this._b, this._c);
        }
        ImageView imageView = this._d;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        _d3._d _dVar = this._a;
        if (_dVar != null) {
            _dVar._a(bitmap);
        }
    }

    @Override // com.kc.aw._d3._d
    public final void _a(Exception exc) {
        _d3._d _dVar = this._a;
        if (_dVar != null) {
            _dVar._a(exc);
        }
    }
}
