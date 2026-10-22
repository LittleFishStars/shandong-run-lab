package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Calendar;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ea implements _hl {
    @Override // com.kc.aw._hl
    public final boolean _a(_cl _clVar) {
        HashSet hashSet = _clVar._k;
        if (hashSet == null || hashSet.size() == 0) {
            return true;
        }
        return _clVar._k.contains(Long.valueOf(Calendar.getInstance().get(11)));
    }

    @Override // com.kc.aw._hl
    public final boolean start() {
        return true;
    }
}
