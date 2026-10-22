package cj.mobile.wm.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.adIdUtils.oaid.impl.FreemeImpl;
import cj.mobile.wm.adIdUtils.oaid.lib.android.creator.IdsSupplier;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FreemeImpl extends IOAID {
    public final Context context;
    public final String PACKAGE_NAME = dexc.dexa("dpn/boespje/dsfbups");
    public final String ACTION = dexc.dexa("boespje/tfswjdf/bdujpo/ntb");

    public FreemeImpl(Context context) {
        this.context = context;
    }

    public static /* synthetic */ String dexa(IBinder iBinder) throws OAIDException, RemoteException {
        IdsSupplier idsSupplierAsInterface = IdsSupplier.Stub.asInterface(iBinder);
        if (idsSupplierAsInterface != null) {
            return idsSupplierAsInterface.getOAID();
        }
        throw new OAIDException(dexc.dexa("GsffnfJnqm!JetTvqqmjfs!jt!ovmm"));
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent(this.ACTION);
        intent.setPackage(this.PACKAGE_NAME);
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.zj.adlib.mn3
            @Override // cj.mobile.wm.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return FreemeImpl.dexa(iBinder);
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
            OAIDLog.print(dexc.dexa("GsffnfJnqm!difdl!tvqqpsufe"));
            IOAID.checkDone = true;
            IOAID.isSupported = this.context.getPackageManager().getPackageInfo(this.PACKAGE_NAME, 0) != null;
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("GsffnfJnqm!difdl!tvqqpsufe!gbjm!") + th);
        }
        return IOAID.isSupported;
    }
}
