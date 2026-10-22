package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e0 implements _hl {
    public ArrayList _a = new ArrayList();

    public _e0(_hl... _hlVarArr) {
        for (_hl _hlVar : _hlVarArr) {
            this._a.add(_hlVar);
        }
    }

    @Override // com.kc.aw._hl
    public final boolean _a(_cl _clVar) {
        Iterator it = this._a.iterator();
        while (it.hasNext()) {
            if (!((_hl) it.next())._a(_clVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.kc.aw._hl
    public final boolean start() {
        Iterator it = this._a.iterator();
        while (it.hasNext()) {
            if (!((_hl) it.next()).start()) {
                return false;
            }
        }
        return true;
    }
}
