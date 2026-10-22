package com.kc.aw.activity;

import android.graphics.Bitmap;
import com.kc.aw._h;
import com.kc.aw._kq;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _b implements _kq {
    public final _h _a;
    public final PtgInteractionPortraitActivity._b _b;

    public _b(_h _hVar, _a _aVar) {
        this._a = _hVar;
        this._b = _aVar;
    }

    @Override // com.kc.aw._kq
    public final void _a(Bitmap bitmap) {
        PtgInteractionPortraitActivity._b _bVar;
        if (this._a._s()) {
            _bVar = this._b;
            if (_bVar == null) {
                return;
            }
        } else {
            if (bitmap == null) {
                PtgInteractionPortraitActivity._b _bVar2 = this._b;
                if (_bVar2 != null) {
                    ((_a) _bVar2)._a("资源加载异常");
                    return;
                }
                return;
            }
            _bVar = this._b;
            if (_bVar == null) {
                return;
            }
        }
        ((_a) _bVar)._a();
    }
}
