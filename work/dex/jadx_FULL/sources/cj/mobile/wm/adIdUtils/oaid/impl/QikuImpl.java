package cj.mobile.wm.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface;
import cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.QikuIdmanager;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class QikuImpl extends IOAID {
    public final Context context;
    public boolean mUseQikuId = true;
    public final String PACKAGE_NAME = dexc.dexa("dpn/rjlv/je");
    public final String ACTION = dexc.dexa("rjlv/tfswjdf/bdujpo/je");

    public QikuImpl(Context context) {
        this.context = context;
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        if (this.mUseQikuId) {
            Intent intent = new Intent(this.ACTION);
            intent.setPackage(this.PACKAGE_NAME);
            OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: cj.mobile.wm.adIdUtils.oaid.impl.QikuImpl.1
                @Override // cj.mobile.wm.adIdUtils.oaid.impl.OAIDService.RemoteCaller
                public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                    IOAIDInterface iOAIDInterfaceAsInterface = IOAIDInterface.Stub.asInterface(iBinder);
                    if (iOAIDInterfaceAsInterface != null) {
                        return iOAIDInterfaceAsInterface.getOAID();
                    }
                    throw new OAIDException(dexc.dexa("RjlvJnqm!JetTvqqmjfs!jt!ovmm"));
                }
            });
            return;
        }
        try {
            String oaid = new QikuIdmanager().getOAID();
            if (oaid == null || oaid.length() == 0) {
                throw new OAIDException(dexc.dexa("RjlvJnqm!rvfsz!gbjm-pbje!jt!ovmm"));
            }
            iGetter.onOAIDGetComplete(oaid);
        } catch (Exception e) {
            iGetter.onOAIDGetError(e);
        }
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
            OAIDLog.print(dexc.dexa("RjlvJnqm!difdl!tvqqpsufe"));
            IOAID.checkDone = true;
            if (this.context.getPackageManager().getPackageInfo(this.PACKAGE_NAME, 0) != null) {
                IOAID.isSupported = true;
            } else {
                this.mUseQikuId = false;
                IOAID.isSupported = new QikuIdmanager().isSupported();
            }
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("RjlvJnqm!difdl!tvqqpsufe!gbjm-") + th);
        }
        return IOAID.isSupported;
    }
}
