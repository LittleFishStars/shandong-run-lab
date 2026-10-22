package com.fl.saas.config.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.fl.saas.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;
import com.fl.saas.config.oaid.IGetter;
import com.fl.saas.config.oaid.IOAID;
import com.fl.saas.config.oaid.OAIDLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class GmsImpl implements IOAID {
    private final Context context;

    public GmsImpl(Context context) {
        this.context = context;
    }

    @Override // com.fl.saas.config.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.fl.saas.config.oaid.impl.GmsImpl.1
            @Override // com.fl.saas.config.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                IAdvertisingIdService iAdvertisingIdServiceAsInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
                if (iAdvertisingIdServiceAsInterface.isLimitAdTrackingEnabled(true)) {
                    OAIDLog.print("User has disabled advertising identifier");
                }
                return iAdvertisingIdServiceAsInterface.getId();
            }
        });
    }

    @Override // com.fl.saas.config.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
