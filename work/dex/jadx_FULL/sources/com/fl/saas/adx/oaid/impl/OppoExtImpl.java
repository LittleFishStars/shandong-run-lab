package com.fl.saas.adx.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.fl.saas.adx.oaid.IGetter;
import com.fl.saas.adx.oaid.OAIDException;
import com.fl.saas.adx.oaid.OAIDLog;
import com.fl.saas.adx.oaid.com.stdid.IStdID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class OppoExtImpl extends OppoImpl {
    private static final String ACTION = "action.com.oplus.stdid.ID_SERVICE";
    private static final String CLASS_NAME = "com.oplus.stdid.IdentifyService";
    private static final String PACKAGE_NAME = "com.coloros.mcs";
    private final Context context;

    public OppoExtImpl(Context context) {
        super(context);
        this.context = context;
    }

    @Override // com.fl.saas.adx.oaid.impl.OppoImpl, com.fl.saas.adx.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent(ACTION);
        intent.setComponent(new ComponentName(PACKAGE_NAME, CLASS_NAME));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.fl.saas.adx.oaid.impl.OppoExtImpl.1
            @Override // com.fl.saas.adx.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws RemoteException {
                try {
                    return OppoExtImpl.this.realGetOUID(iBinder);
                } catch (RemoteException e) {
                    throw e;
                } catch (OAIDException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new OAIDException(e3);
                }
            }
        });
    }

    @Override // com.fl.saas.adx.oaid.impl.OppoImpl
    public String getSerId(IBinder iBinder, String str, String str2) {
        IStdID iStdIDAsInterface = IStdID.Stub.asInterface(iBinder);
        if (iStdIDAsInterface != null) {
            return iStdIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IStdID is null");
    }

    @Override // com.fl.saas.adx.oaid.impl.OppoImpl, com.fl.saas.adx.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(PACKAGE_NAME, 0) != null;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
