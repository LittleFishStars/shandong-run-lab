package com.byazt.vm;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 66})
public class t extends ve<com.byazt.kbg.tt> {
    public final da c;
    public final sl tt;

    public t() {
        super("com.hihonor.id");
        this.c = new da();
        this.tt = new sl();
    }

    @Override // com.byazt.vm.ve
    public zm.tt<com.byazt.kbg.tt, String> c() {
        return new zm.tt<com.byazt.kbg.tt, String>() { // from class: com.byazt.vm.t.1
            @Override // com.byazt.vm.zm.tt
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public com.byazt.kbg.tt tt(IBinder iBinder) {
                return com.byazt.kbg.tt.c.c(iBinder);
            }

            @Override // com.byazt.vm.zm.tt
            public String c(com.byazt.kbg.tt ttVar) throws Exception {
                if (ttVar == null) {
                    com.byazt.nr.m.uj("honor# ", "service is null");
                    return null;
                }
                ttVar.c(t.this.c);
                ttVar.tt(t.this.tt);
                return "";
            }
        };
    }

    @Override // com.byazt.vm.ve, com.byazt.vm.nu
    public /* bridge */ /* synthetic */ boolean tt(Context context) {
        return super.tt(context);
    }

    @Override // com.byazt.vm.ve, com.byazt.vm.nu
    public nu.c ve(Context context) {
        new zm(context, c(context), c()).c();
        nu.c cVar = new nu.c();
        cVar.tt = this.c.c();
        cVar.ve = this.tt.c();
        return cVar;
    }

    @Override // com.byazt.vm.ve
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }
}
