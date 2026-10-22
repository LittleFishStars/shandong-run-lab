package com.kc.aw.activity;

import android.graphics.Bitmap;
import com.kc.aw._d3;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e implements _d3._d {
    public final PtgInteractionPortraitActivity._b _a;

    public _e(_a _aVar) {
        this._a = _aVar;
    }

    @Override // com.kc.aw._d3._g
    public final void _a(Bitmap bitmap) {
        if (bitmap != null) {
            PtgInteractionPortraitActivity._b _bVar = this._a;
            if (_bVar != null) {
                ((_a) _bVar)._a();
                return;
            }
            return;
        }
        PtgInteractionPortraitActivity._b _bVar2 = this._a;
        if (_bVar2 != null) {
            ((_a) _bVar2)._a("资源加载异常!");
        }
    }

    @Override // com.kc.aw._d3._d
    public final void _a(Exception exc) {
        PtgInteractionPortraitActivity._b _bVar = this._a;
        if (_bVar != null) {
            ((_a) _bVar)._a("资源加载异常!");
        }
    }
}
