package cj.mobile.wm.adIdUtils.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OAIDService implements ServiceConnection {
    public final RemoteCaller caller;
    public final Context context;
    public final IGetter getter;

    @FunctionalInterface
    public interface RemoteCaller {
        String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException;
    }

    public OAIDService(Context context, IGetter iGetter, RemoteCaller remoteCaller) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
        this.getter = iGetter;
        this.caller = remoteCaller;
    }

    public static void bind(Context context, Intent intent, IGetter iGetter, RemoteCaller remoteCaller) {
        new OAIDService(context, iGetter, remoteCaller).bind(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        OAIDLog.print(dexc.dexa("Tfswjdf!ibt!cffo!dpoofdufe-") + componentName.getClassName());
        try {
            try {
                String strCallRemoteInterface = this.caller.callRemoteInterface(iBinder);
                if (strCallRemoteInterface == null || strCallRemoteInterface.length() == 0) {
                    throw new OAIDException(dexc.dexa("PBJE!bdrvjsf!gbjmfe"));
                }
                OAIDLog.print(dexc.dexa("PBJE!bdrvjsf!tvddftt-pbje>") + strCallRemoteInterface);
                this.getter.onOAIDGetComplete(strCallRemoteInterface);
                try {
                    this.context.unbindService(this);
                    OAIDLog.print(dexc.dexa("Tfswjdf!ibt!cffo!vocpvoe-") + componentName.getClassName());
                } catch (Exception e) {
                    OAIDLog.print(e);
                }
            } catch (Exception e2) {
                OAIDLog.print(e2);
                this.getter.onOAIDGetError(e2);
                try {
                    this.context.unbindService(this);
                    OAIDLog.print(dexc.dexa("Tfswjdf!ibt!cffo!vocpvoe-") + componentName.getClassName());
                } catch (Exception e3) {
                    OAIDLog.print(e3);
                }
            }
        } catch (Throwable th) {
            try {
                this.context.unbindService(this);
                OAIDLog.print(dexc.dexa("Tfswjdf!ibt!cffo!vocpvoe-") + componentName.getClassName());
            } catch (Exception e4) {
                OAIDLog.print(e4);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        OAIDLog.print(dexc.dexa("Tfswjdf!ibt!cffo!ejtdpoofdufe-") + componentName.getClassName());
    }

    private void bind(Intent intent) {
        try {
            if (!this.context.bindService(intent, this, 1)) {
                throw new OAIDException(dexc.dexa("Tfswjdf!cjoejoh!gbjmfe"));
            }
            OAIDLog.print(dexc.dexa("Tfswjdf!ibt!cffo!cpvoe;!") + intent);
        } catch (Exception e) {
            this.getter.onOAIDGetError(e);
        }
    }
}
