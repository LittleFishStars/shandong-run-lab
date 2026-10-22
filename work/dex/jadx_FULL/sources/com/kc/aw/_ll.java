package com.kc.aw;

import android.content.DialogInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ll implements DialogInterface.OnDismissListener {
    public final _lg _a;

    public _ll(_lg _lgVar) {
        this._a = _lgVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this._a._a9 = null;
    }
}
