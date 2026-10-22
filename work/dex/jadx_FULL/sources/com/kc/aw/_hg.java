package com.kc.aw;

import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _hg implements _hl {
    public String _a;

    public _hg(String str) {
        this._a = str;
    }

    @Override // com.kc.aw._hl
    public final boolean _a(_cl _clVar) {
        HashSet hashSet = _clVar._l;
        if (hashSet == null || hashSet.size() == 0) {
            return true;
        }
        Logger.d("OsVersionFilter", String.format("matchPolicyItem: %s", this._a));
        Iterator it = _clVar._l.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(this._a)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kc.aw._hl
    public final boolean start() {
        return true;
    }
}
