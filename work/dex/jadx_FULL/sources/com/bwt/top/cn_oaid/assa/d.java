package com.bwt.top.cn_oaid.assa;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bwt.top.cn_oaid.OAIDException;
import com.bwt.top.cn_oaid.ddksa;
import com.bwt.top.cn_oaid.dkkd;
import com.bwt.top.cn_oaid.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager;
import com.zj.adlib.ija;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d implements dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f28251a;

    public class a implements ddddk.kdsksdda {
        public a() {
        }

        @Override // com.bwt.top.cn_oaid.assa.ddddk.kdsksdda
        public String a(IBinder iBinder) {
            IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
            if (iDeviceIdManagerAsInterface != null) {
                return iDeviceIdManagerAsInterface.getOAID(d.this.f28251a.getPackageName());
            }
            throw new OAIDException("IDeviceIdManager is null");
        }
    }

    public d(Context context) {
        this.f28251a = context instanceof Application ? context : context.getApplicationContext();
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public boolean a() {
        Context context = this.f28251a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e) {
            ija.a(e);
            return false;
        }
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public void b(ddksa ddksaVar) {
        if (this.f28251a == null || ddksaVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        ddddk.a(this.f28251a, intent, ddksaVar, new a());
    }
}
