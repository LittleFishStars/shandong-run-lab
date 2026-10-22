package com.kc.aw;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _b8 implements View.OnClickListener {
    public final _b9 _a;

    public _b8(_b9 _b9Var) {
        this._a = _b9Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this._a.dismiss();
        _b9._a _aVar = this._a._h;
    }
}
