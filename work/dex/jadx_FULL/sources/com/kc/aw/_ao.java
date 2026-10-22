package com.kc.aw;

import android.widget.ImageView;
import com.kc.aw.component.base.AdvertRatioLayout;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.component.widgets.PtgShakeView;
import com.kc.aw.lib.doodle.Doodle;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ao implements AdvertRatioLayout._a {
    public final _h _a;
    public final ImageView _b;
    public final String _c;
    public final int _d;
    public final int _e;
    public final AdvertRatioLayout _f;
    public final _d3._d _g;
    public final _am _h;

    public _ao(_am _amVar, _h _hVar, ImageView imageView, String str, int i, int i2, AdvertRatioLayout advertRatioLayout, _d3._d _dVar) {
        this._h = _amVar;
        this._a = _hVar;
        this._b = imageView;
        this._c = str;
        this._d = i;
        this._e = i2;
        this._f = advertRatioLayout;
        this._g = _dVar;
    }

    @Override // com.kc.aw.component.base.AdvertRatioLayout._a
    public final void _a(int i, int i2) {
        ImageView imageView;
        _am _amVar;
        PtgVideoView ptgVideoView;
        this._h._n = _l5._a(this._a, i, i2);
        _hy _hyVar = this._h._n;
        if (_hyVar != null) {
            ImageView imageView2 = this._b;
            if (imageView2 != null) {
                imageView2.setLayoutParams(_hyVar._a);
            }
            if (this._a._s() && (ptgVideoView = (_amVar = this._h)._j) != null) {
                ptgVideoView.setVideoLayoutParams(_amVar._n._a);
                this._h._j.setVisibility(0);
            }
            if (this._h._n._b) {
                _l2 _l2VarLoad = Doodle.load(this._c);
                int i3 = this._d;
                int i4 = this._e;
                _l2VarLoad._d = i3;
                _l2VarLoad._e = i4;
                _l2VarLoad._i = true;
                _l2VarLoad._h = false;
                _aw._a(this._h.getContext(), _l2VarLoad._a(3000L), this._f);
            }
            PtgShakeView ptgShakeView = this._h._l;
            if (ptgShakeView == null || this._g == null || (imageView = ptgShakeView._a) == null) {
                return;
            }
            imageView.post(new _jy(ptgShakeView, i, i2));
        }
    }
}
