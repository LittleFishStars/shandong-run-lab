package cj.mobile.wm.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.adIdUtils.oaid.impl.LenovoImpl;
import cj.mobile.wm.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LenovoImpl extends IOAID {
    public final Context context;
    public final String PACKAGE_NAME = dexc.dexa("dpn/{vj/efwjdfjetfswjdf");
    public final String CLASS_NAME = dexc.dexa("dpn/{vj/efwjdfjetfswjdf/EfwjdfjeTfswjdf");

    public LenovoImpl(Context context) {
        this.context = context;
    }

    public static /* synthetic */ String dexa(IBinder iBinder) throws OAIDException, RemoteException {
        IDeviceidInterface iDeviceidInterfaceAsInterface = IDeviceidInterface.Stub.asInterface(iBinder);
        if (iDeviceidInterfaceAsInterface == null) {
            throw new OAIDException(dexc.dexa("MfopwpJnqm!JEfwjdfjeJoufsgbdf!jt!ovmm"));
        }
        if (iDeviceidInterfaceAsInterface.isSupport()) {
            return iDeviceidInterfaceAsInterface.getOAID();
        }
        throw new OAIDException(dexc.dexa("MfopwpJnqm!JEfwjdfjeJoufsgbdf$jtTvqqpsu!sfuvso!gbmtf"));
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(this.PACKAGE_NAME, this.CLASS_NAME);
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.zj.adlib.ww4
            @Override // cj.mobile.wm.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return LenovoImpl.dexa(iBinder);
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
            OAIDLog.print(dexc.dexa("MfopwpJnqm!difdl!tvqqpsufe"));
            IOAID.checkDone = true;
            IOAID.isSupported = this.context.getPackageManager().getPackageInfo(this.PACKAGE_NAME, 0) != null;
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("MfopwpJnqm!tvqqpsufe!gbjm!") + th);
        }
        return IOAID.isSupported;
    }
}
