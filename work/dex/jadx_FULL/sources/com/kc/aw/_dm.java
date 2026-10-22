package com.kc.aw;

import android.view.View;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _dm implements View.OnClickListener {
    public final _dn _a;

    public _dm(_dn _dnVar) {
        this._a = _dnVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdDismiss();
        }
        this._a._a();
    }
}
