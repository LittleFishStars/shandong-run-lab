package com.kc.aw;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _im implements View.OnClickListener {
    public final _in _a;

    public _im(_in _inVar) {
        this._a = _inVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        _in._b _bVar;
        int i_a = _o6._a(view);
        int i_a2 = 4;
        if (i_a == 6 || i_a == 4) {
            _bVar = this._a._n;
            if (_bVar == null) {
                return;
            } else {
                i_a2 = _o6._a(view);
            }
        } else {
            _in _inVar = this._a;
            if (!_inVar._g || (_bVar = _inVar._n) == null) {
                return;
            }
        }
        _bVar._a(view, i_a2, null);
    }
}
