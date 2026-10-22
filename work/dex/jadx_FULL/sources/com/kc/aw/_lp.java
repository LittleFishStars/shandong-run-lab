package com.kc.aw;

import android.app.Activity;
import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lp implements View.OnClickListener {
    public final _lg _a;

    public _lp(_lg _lgVar, Activity activity) {
        this._a = _lgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        _lg _lgVar = this._a;
        _lgVar._b(!_lgVar._f);
    }
}
