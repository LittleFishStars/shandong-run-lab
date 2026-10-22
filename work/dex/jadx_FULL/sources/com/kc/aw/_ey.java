package com.kc.aw;

import android.graphics.Bitmap;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ey implements _mk {
    public final _fs _a;

    public _ey(_ap _apVar) {
        this._a = _apVar;
    }

    @Override // com.kc.aw._mk
    public final void _a(Object obj) {
        if (obj instanceof Bitmap) {
            _fs _fsVar = this._a;
            if (_fsVar != null) {
                _fsVar._a((Bitmap) obj);
                return;
            }
            return;
        }
        _fs _fsVar2 = this._a;
        if (_fsVar2 != null) {
            _fsVar2._a();
        }
    }
}
