package com.kc.aw;

import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gq implements _k9._b {
    public final _gp _a;

    public _gq(_gp _gpVar) {
        this._a = _gpVar;
    }

    @Override // com.kc.aw._k9._b
    public final void _a(long j, long j2) {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener != null) {
            ptgVideoAdListener.onVideoProgressUpdate(j, j2);
        }
    }
}
