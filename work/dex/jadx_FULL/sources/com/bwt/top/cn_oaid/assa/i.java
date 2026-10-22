package com.bwt.top.cn_oaid.assa;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bwt.top.cn_oaid.OAIDException;
import com.bwt.top.cn_oaid.ddksa;
import com.bwt.top.cn_oaid.dkkd;
import com.bwt.top.cn_oaid.repeackage.com.samsung.android.deviceidservice.IDeviceIdService;
import com.zj.adlib.ija;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class i implements dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f28258a;

    public class a implements ddddk.kdsksdda {
        public a(i iVar) {
        }

        @Override // com.bwt.top.cn_oaid.assa.ddddk.kdsksdda
        public String a(IBinder iBinder) {
            IDeviceIdService iDeviceIdServiceAsInterface = IDeviceIdService.Stub.asInterface(iBinder);
            if (iDeviceIdServiceAsInterface != null) {
                return iDeviceIdServiceAsInterface.getOAID();
            }
            throw new OAIDException("IDeviceIdService is null");
        }
    }

    public i(Context context) {
        this.f28258a = context;
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public boolean a() {
        Context context = this.f28258a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e) {
            ija.a(e);
            return false;
        }
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public void b(ddksa ddksaVar) {
        if (this.f28258a == null || ddksaVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        ddddk.a(this.f28258a, intent, ddksaVar, new a(this));
    }
}
