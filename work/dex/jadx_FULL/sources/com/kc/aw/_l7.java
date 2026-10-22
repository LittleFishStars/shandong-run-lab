package com.kc.aw;

import com.kc.aw.lib.constants.PtgRewardConstant;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _l7 implements Runnable {
    public final WeakReference _a;

    public _l7(WeakReference weakReference) {
        this._a = weakReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _l9._b.set(true);
        _b3 _b3Var = (_b3) this._a.get();
        if (_b3Var != null) {
            AdErrorImpl adErrorImpl = new AdErrorImpl();
            PtgRewardConstant.ServerErr serverErr = PtgRewardConstant.ServerErr.ERR_TIMEOUT;
            adErrorImpl._a = serverErr.getCode();
            adErrorImpl._b = serverErr.getMsg();
            _b3Var.onError(adErrorImpl);
        }
    }
}
