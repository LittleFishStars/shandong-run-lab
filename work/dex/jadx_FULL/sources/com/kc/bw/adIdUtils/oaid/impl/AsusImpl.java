package com.kc.bw.adIdUtils.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.adIdUtils.oaid.lib.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AsusImpl implements IOAID {
    public static int alreadyQueried;
    public static boolean isSupported;
    public final Context context;

    public AsusImpl(Context context) {
        this.context = context;
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent(dexg.dexa("dpn/btvt/ntb/bdujpo/BDDFTT`EJE"));
        intent.setComponent(new ComponentName(dexg.dexa("dpn/btvt/ntb/TvqqmfnfoubszEJE"), dexg.dexa("dpn/btvt/ntb/TvqqmfnfoubszEJE/TvqqmfnfoubszEJETfswjdf")));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller(this) { // from class: com.kc.bw.adIdUtils.oaid.impl.AsusImpl.1
            public final AsusImpl this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.bw.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                IDidAidlInterface iDidAidlInterfaceAsInterface = IDidAidlInterface.Stub.asInterface(iBinder);
                if (iDidAidlInterfaceAsInterface == null) {
                    throw new OAIDException(dexg.dexa("JEjeBjemJoufsgbdf!jt!ovmm"));
                }
                if (iDidAidlInterfaceAsInterface.isSupport()) {
                    return iDidAidlInterfaceAsInterface.getOAID();
                }
                throw new OAIDException(dexg.dexa("JEjeBjemJoufsgbdf$jtTvqqpsu!sfuvso!gbmtf"));
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
            if (context.getPackageManager().getPackageInfo(dexg.dexa("dpn/btvt/ntb/TvqqmfnfoubszEJE"), 0) == null) {
                z = false;
            }
            isSupported = z;
            return z;
        } catch (Throwable th) {
            OAIDLog.print(dexg.dexa("BtvtJnqm!tvqqpsufe!gbjm!") + th);
            return false;
        }
    }
}
