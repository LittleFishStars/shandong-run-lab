package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _iw implements Comparator<_bh> {
    @Override // java.util.Comparator
    public final int compare(_bh _bhVar, _bh _bhVar2) {
        _bh _bhVar3 = _bhVar;
        _cl _clVar = _bhVar2._c;
        long j = _clVar != null ? _clVar._h : 0L;
        _cl _clVar2 = _bhVar3._c;
        return Long.compare(j, _clVar2 != null ? _clVar2._h : 0L);
    }
}
