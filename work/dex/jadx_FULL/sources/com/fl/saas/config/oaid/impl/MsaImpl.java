package com.fl.saas.config.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bun.miitmdid.content.StringValues;
import com.fl.saas.com.bun.lib.MsaIdInterface;
import com.fl.saas.config.oaid.IGetter;
import com.fl.saas.config.oaid.IOAID;
import com.fl.saas.config.oaid.OAIDException;
import com.fl.saas.config.oaid.OAIDLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class MsaImpl implements IOAID {
    private final Context context;

    public MsaImpl(Context context) {
        this.context = context;
    }

    private void startMsaKlService() {
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.context.getPackageName());
            this.context.startForegroundService(intent);
        } catch (Exception e) {
            OAIDLog.print(e);
        }
    }

    @Override // com.fl.saas.config.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        startMsaKlService();
        Intent intent = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.context.getPackageName());
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.fl.saas.config.oaid.impl.MsaImpl.1
            @Override // com.fl.saas.config.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
                if (msaIdInterfaceAsInterface == null) {
                    throw new OAIDException("MsaIdInterface is null");
                }
                if (msaIdInterfaceAsInterface.isSupported()) {
                    return msaIdInterfaceAsInterface.getOAID();
                }
                throw new OAIDException("MsaIdInterface#isSupported return false");
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
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
