package com.kc.aw;

import android.view.View;
import android.view.ViewTreeObserver;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _l1 implements ViewTreeObserver.OnPreDrawListener {
    public final _l2 _a;

    public _l1(_l2 _l2Var) {
        this._a = _l2Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view = this._a._o.get();
        if (view == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
        this._a._a(view.getWidth(), view.getHeight());
        return true;
    }
}
