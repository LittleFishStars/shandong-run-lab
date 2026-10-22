package com.kc.aw;

import android.view.ViewTreeObserver;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _do implements ViewTreeObserver.OnGlobalLayoutListener {
    public final _dp _a;

    public _do(_dp _dpVar) {
        this._a = _dpVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this._a.getParent() != null) {
            if (this._a.getViewTreeObserver().isAlive()) {
                this._a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            _dp _dpVar = this._a;
            _am _amVar = _dpVar._G;
            if (_amVar != null) {
                int width = _dpVar.getWidth();
                this._a.getHeight();
                _amVar._a(width);
            }
        }
    }
}
