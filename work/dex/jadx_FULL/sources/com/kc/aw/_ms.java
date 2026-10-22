package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ms implements _kq {
    public final _h _a;
    public final _mt _b;

    public _ms(_mt _mtVar, _h _hVar) {
        this._b = _mtVar;
        this._a = _hVar;
    }

    @Override // com.kc.aw._kq
    public final void _a(Bitmap bitmap) {
        _mt _mtVar;
        _t _tVar;
        Exception exc;
        if (bitmap != null) {
            _h _hVar = this._a;
            if (_hVar != null) {
                _mt _mtVar2 = this._b;
                ImageView imageView = _mtVar2._g;
                if (imageView != null) {
                    imageView.setLayoutParams(_mt._a(_mtVar2, _hVar));
                    this._b._g.setImageBitmap(bitmap);
                    this._b._g.setVisibility(0);
                    _mt _mtVar3 = this._b;
                    if (_mtVar3._k) {
                        _aw._a(_mtVar3.getContext(), bitmap, this._b._f);
                    }
                }
                _t _tVar2 = this._b._c;
                if (_tVar2 != null) {
                    _tVar2._a();
                }
                Context context = this._b.getContext();
                _mt _mtVar4 = this._b;
                _b2._a(context, _mtVar4, this._a, _mtVar4._f, _mtVar4._j, _mtVar4._h, _mtVar4._b);
                return;
            }
            _mtVar = this._b;
            _tVar = _mtVar._c;
            if (_tVar == null) {
                return;
            } else {
                exc = new Exception("广告数据为空");
            }
        } else {
            _mtVar = this._b;
            _tVar = _mtVar._c;
            if (_tVar == null) {
                return;
            } else {
                exc = new Exception("图片加载失败");
            }
        }
        _tVar._a(_mtVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
    }
}
