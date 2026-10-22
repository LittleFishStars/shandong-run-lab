package com.kc.dw.core.oaid.impl;

import com.kc.dw.core.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d implements com.kc.dw.core.oaid.b {
    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (aVar == null) {
            return;
        }
        ((com.kc.dw.core.utils.n) aVar).a(new OAIDException("Unsupported"));
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        return false;
    }
}
