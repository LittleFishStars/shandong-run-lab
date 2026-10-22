package com.kc.bw.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class LenovoImpl implements IOAID {
    public static int alreadyQueried;
    public static boolean isSupported;
    public final Context context;

    public LenovoImpl(Context context) {
        this.context = context;
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(dexg.dexa("dpn/{vj/efwjdfjetfswjdf"), dexg.dexa("dpn/{vj/efwjdfjetfswjdf/EfwjdfjeTfswjdf"));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller(this) { // from class: com.kc.bw.adIdUtils.oaid.impl.LenovoImpl.1
            public final LenovoImpl this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.bw.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                IDeviceidInterface iDeviceidInterfaceAsInterface = IDeviceidInterface.Stub.asInterface(iBinder);
                if (iDeviceidInterfaceAsInterface == null) {
                    throw new OAIDException(dexg.dexa("JEfwjdfjeJoufsgbdf!jt!ovmm"));
                }
                if (iDeviceidInterfaceAsInterface.isSupport()) {
                    return iDeviceidInterfaceAsInterface.getOAID();
                }
                throw new OAIDException(dexg.dexa("JEfwjdfjeJoufsgbdf$jtTvqqpsu!sfuvso!gbmtf"));
            }
        });
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
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
            if (context.getPackageManager().getPackageInfo(dexg.dexa("dpn/{vj/efwjdfjetfswjdf"), 0) == null) {
                z = false;
            }
            isSupported = z;
            return z;
        } catch (Throwable th) {
            OAIDLog.print(dexg.dexa("MfopwpJnqm!tvqqpsufe!gbjm!") + th);
            return false;
        }
    }
}
