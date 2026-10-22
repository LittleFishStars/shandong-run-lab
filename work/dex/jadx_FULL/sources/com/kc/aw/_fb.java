package com.kc.aw;

import android.graphics.Bitmap;
import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fb implements _d3._d {
    public final _fa _a;

    public _fb(_fa _faVar) {
        this._a = _faVar;
    }

    @Override // com.kc.aw._d3._g
    public final void _a(Bitmap bitmap) {
        try {
            this._a.setVisibility(0);
            _fa _faVar = this._a;
            _3 _3 = _faVar._a;
            if (_3 != null) {
                View view = _faVar._f;
                _fj _fjVar = (_fj) _3;
                _h _hVar = _fjVar._c._d;
                if (_hVar != null) {
                    _hVar._I = System.currentTimeMillis();
                }
                view.post(new _fi(_fjVar, view));
            }
        } catch (Exception e) {
            _3 _4 = this._a._a;
            if (_4 != null) {
                StringBuilder sb_a = _jf._a("渲染失败：");
                sb_a.append(e.getMessage());
                ((_fj) _4)._a(sb_a.toString());
            }
        }
    }

    @Override // com.kc.aw._d3._d
    public final void _a(Exception exc) {
        _fa _faVar = this._a;
        _3 _3 = _faVar._a;
        if (_3 != null) {
            View view = _faVar._f;
            _fj _fjVar = (_fj) _3;
            _h _hVar = _fjVar._c._d;
            if (_hVar != null) {
                _hVar._I = System.currentTimeMillis();
            }
            view.post(new _fi(_fjVar, view));
        }
    }
}
