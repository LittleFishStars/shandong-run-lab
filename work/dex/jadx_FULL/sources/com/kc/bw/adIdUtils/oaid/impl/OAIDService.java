package com.kc.bw.adIdUtils.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OAIDService implements ServiceConnection {
    public final RemoteCaller caller;
    public final Context context;
    public final IGetter getter;

    @Keep
    @FunctionalInterface
    public interface RemoteCaller {
        String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException;
    }

    public OAIDService(Context context, IGetter iGetter, RemoteCaller remoteCaller) {
        this.context = context instanceof Application ? context : context.getApplicationContext();
        this.getter = iGetter;
        this.caller = remoteCaller;
    }

    public static void bind(Context context, Intent intent, IGetter iGetter, RemoteCaller remoteCaller) {
        new OAIDService(context, iGetter, remoteCaller).bind(intent);
    }

    private void bind(Intent intent) {
        try {
            if (!this.context.bindService(intent, this, 1)) {
                throw new OAIDException(dexg.dexa("Tfswjdf!cjoejoh!gbjmfe"));
            }
            OAIDLog.print(dexg.dexa("Tfswjdf!ibt!cffo!cpvoe;!") + intent);
        } catch (Exception e) {
            this.getter.onOAIDGetError(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        OAIDLog.print(dexg.dexa("Tfswjdf!ibt!cffo!dpoofdufe;!") + componentName.getClassName());
        try {
            try {
                try {
                    String strCallRemoteInterface = this.caller.callRemoteInterface(iBinder);
                    if (strCallRemoteInterface == null || strCallRemoteInterface.length() == 0) {
                        throw new OAIDException(dexg.dexa("PBJE0BBJE!bdrvjsf!gbjmfe"));
                    }
                    OAIDLog.print(dexg.dexa("PBJE0BBJE!bdrvjsf!tvddftt;!") + strCallRemoteInterface);
                    this.getter.onOAIDGetComplete(strCallRemoteInterface);
                    this.context.unbindService(this);
                    OAIDLog.print(dexg.dexa("Tfswjdf!ibt!cffo!vocpvoe;!") + componentName.getClassName());
                } catch (Exception e) {
                    OAIDLog.print(e);
                }
            } catch (Exception e2) {
                OAIDLog.print(e2);
                this.getter.onOAIDGetError(e2);
                this.context.unbindService(this);
                OAIDLog.print(dexg.dexa("Tfswjdf!ibt!cffo!vocpvoe;!") + componentName.getClassName());
            }
        } catch (Throwable th) {
            try {
                this.context.unbindService(this);
                OAIDLog.print(dexg.dexa("Tfswjdf!ibt!cffo!vocpvoe;!") + componentName.getClassName());
            } catch (Exception e3) {
                OAIDLog.print(e3);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        OAIDLog.print(dexg.dexa("Tfswjdf!ibt!cffo!ejtdpoofdufe;!") + componentName.getClassName());
    }
}
