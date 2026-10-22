package com.kc.aw;

import android.content.DialogInterface;
import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cq implements View.OnClickListener {
    public final _cr _a;

    public _cq(_cr _crVar) {
        this._a = _crVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DialogInterface.OnClickListener onClickListener;
        this._a.dismiss();
        _cr._a _aVar = this._a._g;
        if (_aVar == null || (onClickListener = ((_6) _aVar)._a) == null) {
            return;
        }
        onClickListener.onClick(null, -1);
    }
}
