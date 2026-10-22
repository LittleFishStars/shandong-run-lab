package cj.mobile.wm.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.adIdUtils.oaid.impl.SamsungImpl;
import cj.mobile.wm.adIdUtils.oaid.lib.samsung.android.deviceidservice.IDeviceIdService;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SamsungImpl extends IOAID {
    public final Context context;
    public final String PACKAGE_NAME = dexc.dexa("dpn/tbntvoh/boespje/efwjdfjetfswjdf");
    public final String CLASS_NAME = dexc.dexa("dpn/tbntvoh/boespje/efwjdfjetfswjdf/EfwjdfJeTfswjdf");

    public SamsungImpl(Context context) {
        this.context = context;
    }

    public static /* synthetic */ String dexa(IBinder iBinder) throws OAIDException, RemoteException {
        IDeviceIdService iDeviceIdServiceAsInterface = IDeviceIdService.Stub.asInterface(iBinder);
        if (iDeviceIdServiceAsInterface != null) {
            return iDeviceIdServiceAsInterface.getOAID();
        }
        throw new OAIDException(dexc.dexa("TbntvohJnqm!JEfwjdfJeTfswjdf!jt!ovmm"));
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(this.PACKAGE_NAME, this.CLASS_NAME);
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.zj.adlib.su7
            @Override // cj.mobile.wm.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return SamsungImpl.dexa(iBinder);
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
            OAIDLog.print(dexc.dexa("TbntvohJnqm!difdl!tvqqpsufe"));
            IOAID.checkDone = true;
            IOAID.isSupported = this.context.getPackageManager().getPackageInfo(this.PACKAGE_NAME, 0) != null;
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("TbntvohJnqm!difdl!tvqqpsufe!gbjm-") + th);
        }
        return IOAID.isSupported;
    }
}
