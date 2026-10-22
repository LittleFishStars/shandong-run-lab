package com.byazt.vm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 20})
public final class c extends ve<com.byazt.fp.uj> {
    public c() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.byazt.vm.ve
    public zm.tt<com.byazt.fp.uj, String> c() {
        return new zm.tt<com.byazt.fp.uj, String>() { // from class: com.byazt.vm.c.1
            @Override // com.byazt.vm.zm.tt
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public com.byazt.fp.uj tt(IBinder iBinder) {
                return com.byazt.fp.uj.c.c(iBinder);
            }

            @Override // com.byazt.vm.zm.tt
            public String c(com.byazt.fp.uj ujVar) throws Exception {
                if (ujVar == null) {
                    return null;
                }
                return ujVar.ve();
            }
        };
    }

    @Override // com.byazt.vm.ve
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
