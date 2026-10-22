package com.kc.bw.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.adIdUtils.oaid.lib.google.android.gms.ads.identifier.internal.IAdvertisingIdService;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GmsImpl implements IOAID {
    public final Context context;

    public GmsImpl(Context context) {
        this.context = context;
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent(dexg.dexa("dpn/hpphmf/boespje/hnt/bet/jefoujgjfs/tfswjdf/TUBSU"));
        intent.setPackage(dexg.dexa("dpn/hpphmf/boespje/hnt"));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller(this) { // from class: com.kc.bw.adIdUtils.oaid.impl.GmsImpl.1
            public final GmsImpl this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.bw.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                IAdvertisingIdService iAdvertisingIdServiceAsInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
                if (iAdvertisingIdServiceAsInterface.isLimitAdTrackingEnabled(true)) {
                    OAIDLog.print(dexg.dexa("Vtfs!ibt!ejtbcmfe!bewfsujtjoh!jefoujgjfs"));
                }
                return iAdvertisingIdServiceAsInterface.getId();
            }
        });
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(dexg.dexa("dpn/boespje/wfoejoh"), 0) != null;
        } catch (Throwable th) {
            OAIDLog.print(dexg.dexa("HntJnqm!tvqqpsufe!gbjm!") + th);
            return false;
        }
    }
}
