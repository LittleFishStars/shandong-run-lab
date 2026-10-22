package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _mr implements _d3._d {
    public final _h _a;
    public final _mt _b;

    public _mr(_mt _mtVar, _h _hVar) {
        this._b = _mtVar;
        this._a = _hVar;
    }

    @Override // com.kc.aw._d3._g
    public final void _a(Bitmap bitmap) throws Throwable {
        _h _hVar = this._a;
        if (_hVar == null) {
            _mt _mtVar = this._b;
            _t _tVar = _mtVar._c;
            if (_tVar != null) {
                _tVar._a(_mtVar, PtgErrorCode.SDK_RESOURCE_ERROR, new Exception("广告数据为空"));
                return;
            }
            return;
        }
        _mt _mtVar2 = this._b;
        ImageView imageView = _mtVar2._g;
        if (imageView != null) {
            imageView.setLayoutParams(_mt._a(_mtVar2, _hVar));
            this._b._g.setImageBitmap(bitmap);
            this._b._g.setVisibility(0);
            if (this._b._k) {
                _aw._a(this._b.getContext(), this._a._f() != null ? this._a._f()._a : "", this._b._f);
            }
        }
        _t _tVar2 = this._b._c;
        if (_tVar2 != null) {
            _tVar2._a();
        }
        Context context = this._b.getContext();
        _mt _mtVar3 = this._b;
        _b2._a(context, _mtVar3, this._a, _mtVar3._f, _mtVar3._j, _mtVar3._h, _mtVar3._b);
    }

    @Override // com.kc.aw._d3._d
    public final void _a(Exception exc) {
        _mt _mtVar = this._b;
        _t _tVar = _mtVar._c;
        if (_tVar != null) {
            _tVar._a(_mtVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
        }
    }
}
