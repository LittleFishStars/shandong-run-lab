package com.kc.bw.adIdUtils.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.adIdUtils.oaid.lib.oplus.stdid.IStdID;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OppoExtImpl extends OppoImpl {
    public final Context context;
    public static final String ACTION = dexg.dexa("bdujpo/dpn/pqmvt/tueje/JE`TFSWJDF");
    public static final String PACKAGE_NAME = dexg.dexa("dpn/dpmpspt/ndt");
    public static final String CLASS_NAME = dexg.dexa("dpn/pqmvt/tueje/JefoujgzTfswjdf");
    public static boolean isSupported = false;
    public static int alreadyQueried = 0;

    public OppoExtImpl(Context context) {
        super(context);
        this.context = context;
    }

    @Override // com.kc.bw.adIdUtils.oaid.impl.OppoImpl, com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent(ACTION);
        intent.setComponent(new ComponentName(PACKAGE_NAME, CLASS_NAME));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller(this) { // from class: com.kc.bw.adIdUtils.oaid.impl.OppoExtImpl.1
            public final OppoExtImpl this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.bw.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                try {
                    return this.this$0.realGetOUID(iBinder);
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

    @Override // com.kc.bw.adIdUtils.oaid.impl.OppoImpl
    public String getSerId(IBinder iBinder, String str, String str2) throws OAIDException, RemoteException {
        IStdID iStdIDAsInterface = IStdID.Stub.asInterface(iBinder);
        if (iStdIDAsInterface != null) {
            return iStdIDAsInterface.getSerID(str, str2, dexg.dexa("PVJE"));
        }
        throw new OAIDException(dexg.dexa("JTueJE!jt!ovmm"));
    }

    @Override // com.kc.bw.adIdUtils.oaid.impl.OppoImpl, com.kc.bw.adIdUtils.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        int i = alreadyQueried;
        if (i > 0) {
            Log.d(dexg.dexa("je"), dexg.dexa("br"));
            return isSupported;
        }
        boolean z = true;
        try {
            alreadyQueried = i + 1;
            if (context.getPackageManager().getPackageInfo(PACKAGE_NAME, 0) == null) {
                z = false;
            }
            isSupported = z;
            return z;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
