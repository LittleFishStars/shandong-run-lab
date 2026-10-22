package com.kc.aw;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gf implements View.OnClickListener {
    public final _gg _a;

    public _gf(_dp _dpVar) {
        this._a = _dpVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        _gg _ggVar = this._a;
        if (!_ggVar._t.get() && _ggVar._n && _ib._a(_ggVar._e)) {
            this._a._t.set(true);
            List<View> advertViews = this._a.getAdvertViews();
            if (advertViews == null || advertViews.isEmpty() || (view2 = advertViews.get(0)) == null || !view2.hasWindowFocus()) {
                return;
            }
            _o6._a(view2, 4);
        }
    }
}
