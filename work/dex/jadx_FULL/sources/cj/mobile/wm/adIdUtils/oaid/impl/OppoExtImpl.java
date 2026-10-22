package cj.mobile.wm.adIdUtils.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.adIdUtils.oaid.lib.oplus.stdid.IStdID;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OppoExtImpl extends OppoImpl {
    public final String ACTION;
    public final String CLASS_NAME;
    public final String PACKAGE_NAME;
    public final Context context;

    public OppoExtImpl(Context context) {
        super(context);
        this.ACTION = dexc.dexa("bdujpo/dpn/pqmvt/tueje/JE`TFSWJDF");
        this.PACKAGE_NAME = dexc.dexa("dpn/dpmpspt/ndt");
        this.CLASS_NAME = dexc.dexa("dpn/pqmvt/tueje/JefoujgzTfswjdf");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String dexb(IBinder iBinder) throws OAIDException, RemoteException {
        try {
            return realGetOUID(iBinder);
        } catch (RemoteException e) {
            throw e;
        } catch (OAIDException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new OAIDException(e3);
        }
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.impl.OppoImpl, cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent(this.ACTION);
        intent.setComponent(new ComponentName(this.PACKAGE_NAME, this.CLASS_NAME));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.zj.adlib.fd6
            @Override // cj.mobile.wm.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return this.f41648a.dexb(iBinder);
            }
        });
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.impl.OppoImpl
    public String getSerId(IBinder iBinder, String str, String str2) throws OAIDException, RemoteException {
        IStdID iStdIDAsInterface = IStdID.Stub.asInterface(iBinder);
        if (iStdIDAsInterface != null) {
            return iStdIDAsInterface.getSerID(str, str2, dexc.dexa("PVJE"));
        }
        throw new OAIDException(dexc.dexa("PqqpFyuJnqm!JTueJE!jt!ovmm"));
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.impl.OppoImpl, cj.mobile.wm.adIdUtils.oaid.IOAID
    public boolean supported() {
        if (this.context == null) {
            return false;
        }
        if (IOAID.checkDone) {
            return IOAID.isSupported;
        }
        try {
            OAIDLog.print(dexc.dexa("PqqpFyuJnqm!difdl!tvqqpsufe"));
            IOAID.checkDone = true;
            IOAID.isSupported = this.context.getPackageManager().getPackageInfo(this.PACKAGE_NAME, 0) != null;
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("PqqpFyuJnqm!difdl!tvqqpsufe!gbjm-") + th);
        }
        return IOAID.isSupported;
    }
}
