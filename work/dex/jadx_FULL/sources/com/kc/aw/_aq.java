package com.kc.aw;

import android.widget.ImageView;
import com.kc.aw.component.base.AdvertRatioLayout;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.component.widgets.PtgShakeView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _aq implements AdvertRatioLayout._a {
    public final _h _a;
    public final ImageView _b;
    public final String _c;
    public final AdvertRatioLayout _d;
    public final _d3._d _e;
    public final _am _f;

    public _aq(_am _amVar, _h _hVar, ImageView imageView, String str, AdvertRatioLayout advertRatioLayout, _d3._d _dVar) {
        this._f = _amVar;
        this._a = _hVar;
        this._b = imageView;
        this._c = str;
        this._d = advertRatioLayout;
        this._e = _dVar;
    }

    @Override // com.kc.aw.component.base.AdvertRatioLayout._a
    public final void _a(int i, int i2) throws Throwable {
        ImageView imageView;
        _am _amVar;
        PtgVideoView ptgVideoView;
        this._f._n = _l5._a(this._a, i, i2);
        _hy _hyVar = this._f._n;
        if (_hyVar != null) {
            ImageView imageView2 = this._b;
            if (imageView2 != null) {
                imageView2.setLayoutParams(_hyVar._a);
            }
            _am _amVar2 = this._f;
            if (_amVar2._n._b) {
                _aw._a(_amVar2.getContext(), this._c, this._d);
            }
            if (this._a._s() && (ptgVideoView = (_amVar = this._f)._j) != null) {
                ptgVideoView.setVideoLayoutParams(_amVar._n._a);
                this._f._j.setVisibility(0);
            }
            PtgShakeView ptgShakeView = this._f._l;
            if (ptgShakeView == null || this._e == null || (imageView = ptgShakeView._a) == null) {
                return;
            }
            imageView.post(new _jy(ptgShakeView, i, i2));
        }
    }
}
