package com.fl.saas.adx.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.fl.saas.adx.oaid.IGetter;
import com.fl.saas.adx.oaid.IOAID;
import com.fl.saas.adx.oaid.OAIDException;
import com.fl.saas.adx.oaid.OAIDLog;
import com.fl.saas.adx.oaid.com.samsung.android.deviceidservice.IDeviceIdService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class SamsungImpl implements IOAID {
    private final Context context;

    public SamsungImpl(Context context) {
        this.context = context;
    }

    @Override // com.fl.saas.adx.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.fl.saas.adx.oaid.impl.SamsungImpl.1
            @Override // com.fl.saas.adx.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                IDeviceIdService iDeviceIdServiceAsInterface = IDeviceIdService.Stub.asInterface(iBinder);
                if (iDeviceIdServiceAsInterface != null) {
                    return iDeviceIdServiceAsInterface.getOAID();
                }
                throw new OAIDException("IDeviceIdService is null");
            }
        });
    }

    @Override // com.fl.saas.adx.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
