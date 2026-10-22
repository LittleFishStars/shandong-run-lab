package cj.mobile.wm.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.adIdUtils.oaid.impl.GmsImpl;
import cj.mobile.wm.adIdUtils.oaid.lib.google.android.gms.ads.identifier.internal.IAdvertisingIdService;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GmsImpl extends IOAID {
    public final Context context;
    public final String PACKAGE_NAME = dexc.dexa("dpn/boespje/wfoejoh");
    public final String ACTION = dexc.dexa("dpn/hpphmf/boespje/hnt/bet/jefoujgjfs/tfswjdf/TUBSU");
    public final String PACKAGE_NAME2 = dexc.dexa("dpn/hpphmf/boespje/hnt");

    public GmsImpl(Context context) {
        this.context = context;
    }

    public static /* synthetic */ String dexa(IBinder iBinder) throws OAIDException, RemoteException {
        IAdvertisingIdService iAdvertisingIdServiceAsInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
        if (iAdvertisingIdServiceAsInterface.isLimitAdTrackingEnabled(true)) {
            OAIDLog.print(dexc.dexa("HntJnqm!Vtfs!ibt!ejtbcmfe!bewfsujtjoh!jefoujgjfs"));
        }
        return iAdvertisingIdServiceAsInterface.getId();
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent(this.ACTION);
        intent.setPackage(this.PACKAGE_NAME2);
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.zj.adlib.ru3
            @Override // cj.mobile.wm.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return GmsImpl.dexa(iBinder);
            }
        });
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public boolean supported() {
        if (this.context == null) {
            return false;
        }
        if (IOAID.checkDone) {
            return IOAID.isSupported;
        }
        try {
            OAIDLog.print(dexc.dexa("HntJnqm!difdl!tvqqpsufe"));
            IOAID.checkDone = true;
            IOAID.isSupported = this.context.getPackageManager().getPackageInfo(this.PACKAGE_NAME, 0) != null;
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("HntJnqm!difdl!tvqqpsufe!gbjm-") + th);
        }
        return IOAID.isSupported;
    }
}
