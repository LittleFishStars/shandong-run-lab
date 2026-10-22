package com.fl.saas.config.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.fl.saas.com.coolpad.deviceidsupport.IDeviceIdManager;
import com.fl.saas.config.oaid.IGetter;
import com.fl.saas.config.oaid.IOAID;
import com.fl.saas.config.oaid.OAIDException;
import com.fl.saas.config.oaid.OAIDLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CoolpadImpl implements IOAID {
    private final Context context;

    public CoolpadImpl(Context context) {
        this.context = context instanceof Application ? context : context.getApplicationContext();
    }

    @Override // com.fl.saas.config.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.fl.saas.config.oaid.impl.CoolpadImpl.1
            @Override // com.fl.saas.config.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
                if (iDeviceIdManagerAsInterface != null) {
                    return iDeviceIdManagerAsInterface.getOAID(CoolpadImpl.this.context.getPackageName());
                }
                throw new OAIDException("IDeviceIdManager is null");
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
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
