package com.kc.aw;

import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gr implements _kc {
    public final _gp _a;

    public _gr(_gp _gpVar) {
        this._a = _gpVar;
    }

    @Override // com.kc.aw._kc
    public final void onVideoPause() {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener != null) {
            ptgVideoAdListener.onVideoPause();
        }
    }

    @Override // com.kc.aw._kc
    public final void onVideoResume() {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener != null) {
            ptgVideoAdListener.onVideoResume();
        }
    }

    @Override // com.kc.aw._kc
    public final void onVideoStart() {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener != null) {
            ptgVideoAdListener.onVideoStart();
        }
    }
}
