package com.hailiang.advlib.open.oaid.hla;

import com.hailiang.advlib.open.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
class a implements com.hailiang.advlib.open.oaid.b {
    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(new OAIDException("Unsupported"));
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        return false;
    }
}
