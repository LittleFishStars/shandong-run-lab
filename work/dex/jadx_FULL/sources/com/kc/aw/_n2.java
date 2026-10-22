package com.kc.aw;

import com.kc.aw.lib.constants.PtgErrorCode;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _n2 implements Runnable {
    public final _n3 _a;

    public _n2(_n3 _n3Var) {
        this._a = _n3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _n3 _n3Var;
        _t _tVar;
        if (this._a._p || (_tVar = (_n3Var = this._a)._c) == null) {
            return;
        }
        _tVar._a(_n3Var, PtgErrorCode.SDK_RESOURCE_ERROR, new Exception("开屏模版素材加载失败"));
    }
}
