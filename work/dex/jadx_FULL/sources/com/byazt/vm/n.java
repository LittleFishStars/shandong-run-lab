package com.byazt.vm;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bun.miitmdid.content.StringValues;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 46})
public final class n extends ve<com.byazt.fp.a> {
    public n() {
        super("com.mdid.msa");
    }

    @Override // com.byazt.vm.ve
    public zm.tt<com.byazt.fp.a, String> c() {
        return new zm.tt<com.byazt.fp.a, String>() { // from class: com.byazt.vm.n.1
            @Override // com.byazt.vm.zm.tt
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public com.byazt.fp.a tt(IBinder iBinder) {
                return com.byazt.fp.a.c.c(iBinder);
            }

            @Override // com.byazt.vm.zm.tt
            public String c(com.byazt.fp.a aVar) throws Exception {
                if (aVar == null) {
                    return null;
                }
                return aVar.c();
            }
        };
    }

    @Override // com.byazt.vm.ve, com.byazt.vm.nu
    public nu.c ve(Context context) {
        c(context, context.getPackageName());
        return super.ve(context);
    }

    @Override // com.byazt.vm.ve
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, context.getPackageName());
        return intent;
    }

    private void c(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction(StringValues.ACTION_START_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            com.byazt.yv.da.c(e);
        }
    }
}
