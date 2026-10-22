package cj.mobile.wm.adIdUtils.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CoolpadImpl extends IOAID {
    public final Context context;
    public final String PACKAGE_NAME = dexc.dexa("dpn/dppmqbe/efwjdfjetvqqpsu");
    public final String CLASS_NAME = dexc.dexa("dpn/dppmqbe/efwjdfjetvqqpsu/EfwjdfJeTfswjdf");

    public CoolpadImpl(Context context) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String dexa(IBinder iBinder) throws OAIDException, RemoteException {
        IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
        if (iDeviceIdManagerAsInterface != null) {
            return iDeviceIdManagerAsInterface.getOAID(this.context.getPackageName());
        }
        throw new OAIDException(dexc.dexa("DppmqbeJnqm!JEfwjdfJeNbobhfs!jt!ovmm"));
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this.PACKAGE_NAME, this.CLASS_NAME));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.zj.adlib.vv1
            @Override // cj.mobile.wm.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return this.f45461a.dexa(iBinder);
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
            OAIDLog.print(dexc.dexa("DppmqbeJnqm!difdl!tvqqpsufe"));
            IOAID.checkDone = true;
            IOAID.isSupported = this.context.getPackageManager().getPackageInfo(this.PACKAGE_NAME, 0) != null;
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("DppmqbeJnqm!difdl!tvqqpsufe!gbjm-") + th);
        }
        return IOAID.isSupported;
    }
}
