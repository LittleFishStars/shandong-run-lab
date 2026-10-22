package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fe implements _k9._b {
    public final _fa _a;

    public _fe(_fa _faVar) {
        this._a = _faVar;
    }

    @Override // com.kc.aw._k9._b
    public final void _a(long j, long j2) {
        PtgVideoAdListener ptgVideoAdListener;
        _fk _fkVar_a = _fk._a();
        String str = this._a._b;
        _fkVar_a.getClass();
        if (TextUtils.isEmpty(str) || (ptgVideoAdListener = _fkVar_a._e.get(str)) == null) {
            return;
        }
        ptgVideoAdListener.onVideoProgressUpdate(j, j2);
    }
}
