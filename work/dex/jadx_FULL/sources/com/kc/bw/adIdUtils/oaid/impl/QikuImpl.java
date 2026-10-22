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
import com.kc.bw.adIdUtils.oaid.lib.qiku.id.IOAIDInterface;
import com.kc.bw.adIdUtils.oaid.lib.qiku.id.QikuIdmanager;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class QikuImpl implements IOAID {
    public static int alreadyQueried;
    public static boolean isSupported;
    public final Context context;
    public boolean mUseQikuId = true;

    public QikuImpl(Context context) {
        this.context = context;
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        if (this.mUseQikuId) {
            Intent intent = new Intent(dexg.dexa("rjlv/tfswjdf/bdujpo/je"));
            intent.setPackage(dexg.dexa("dpn/rjlv/je"));
            OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller(this) { // from class: com.kc.bw.adIdUtils.oaid.impl.QikuImpl.1
                public final QikuImpl this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.bw.adIdUtils.oaid.impl.OAIDService.RemoteCaller
                public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                    IOAIDInterface iOAIDInterfaceAsInterface = IOAIDInterface.Stub.asInterface(iBinder);
                    if (iOAIDInterfaceAsInterface != null) {
                        return iOAIDInterfaceAsInterface.getOAID();
                    }
                    throw new OAIDException(dexg.dexa("JetTvqqmjfs!jt!ovmm"));
                }
            });
            return;
        }
        try {
            String oaid = new QikuIdmanager().getOAID();
            if (oaid == null || oaid.length() == 0) {
                throw new OAIDException(dexg.dexa("PBJE0BBJE!bdrvjsf!gbjmfe"));
            }
            iGetter.onOAIDGetComplete(oaid);
        } catch (Exception e) {
            iGetter.onOAIDGetError(e);
        }
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
        try {
            alreadyQueried = i + 1;
            if (context.getPackageManager().getPackageInfo(dexg.dexa("dpn/rjlv/je"), 0) != null) {
                isSupported = true;
                return true;
            }
            this.mUseQikuId = false;
            boolean zIsSupported = new QikuIdmanager().isSupported();
            isSupported = zIsSupported;
            return zIsSupported;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
