package com.byazt.vm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 34})
public class a extends ve<com.byazt.fp.c> {
    public final Context c;

    public a(Context context) {
        super("com.coolpad.deviceidsupport");
        this.c = context;
    }

    @Override // com.byazt.vm.ve, com.byazt.vm.nu
    public /* bridge */ /* synthetic */ boolean tt(Context context) {
        return super.tt(context);
    }

    @Override // com.byazt.vm.ve, com.byazt.vm.nu
    public nu.c ve(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                nu.c cVar = new nu.c();
                cVar.tt = string;
                return cVar;
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
        return super.ve(context);
    }

    @Override // com.byazt.vm.ve
    public zm.tt<com.byazt.fp.c, String> c() {
        return new zm.tt<com.byazt.fp.c, String>() { // from class: com.byazt.vm.a.1
            @Override // com.byazt.vm.zm.tt
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public com.byazt.fp.c tt(IBinder iBinder) {
                return com.byazt.fp.c.AbstractBinderC0403c.c(iBinder);
            }

            @Override // com.byazt.vm.zm.tt
            public String c(com.byazt.fp.c cVar) throws Exception {
                if (cVar == null) {
                    return null;
                }
                return cVar.tt(a.this.c.getPackageName());
            }
        };
    }

    @Override // com.byazt.vm.ve
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }
}
