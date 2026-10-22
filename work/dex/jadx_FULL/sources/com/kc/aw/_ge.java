package com.kc.aw;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ge implements ViewTreeObserver.OnScrollChangedListener {
    public long _a = 0;
    public final _gg _b;

    public _ge(_gg _ggVar) {
        this._b = _ggVar;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        if (System.currentTimeMillis() - this._a < 200) {
            return;
        }
        this._a = System.currentTimeMillis();
        Rect rect = new Rect();
        boolean globalVisibleRect = this._b.getGlobalVisibleRect(rect);
        _gg _ggVar = this._b;
        if (_ggVar._r != globalVisibleRect) {
            _ggVar._r = _ggVar.getGlobalVisibleRect(rect);
            _gg _ggVar2 = this._b;
            this._b._a(_ggVar2._r ? _ggVar2.getWindowVisibility() : 8);
        }
    }
}
