package com.kc.aw;

import android.content.DialogInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _5 implements DialogInterface.OnDismissListener {
    public final DialogInterface.OnClickListener _a;

    public _5(_cy _cyVar) {
        this._a = _cyVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        _8._a = null;
        DialogInterface.OnClickListener onClickListener = this._a;
        if (onClickListener != null) {
            onClickListener.onClick(null, -2);
        }
    }
}
