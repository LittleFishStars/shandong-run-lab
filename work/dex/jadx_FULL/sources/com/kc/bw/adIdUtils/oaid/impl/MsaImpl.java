package com.kc.bw.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.adIdUtils.oaid.lib.bun.lib.MsaIdInterface;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsaImpl implements IOAID {
    public final Context context;

    public MsaImpl(Context context) {
        this.context = context;
    }

    private void startMsaKlService() {
        try {
            Intent intent = new Intent(dexg.dexa("dpn/cvo/ntb/bdujpo/tubsu/tfswjdf"));
            intent.setClassName(dexg.dexa("dpn/neje/ntb"), dexg.dexa("dpn/neje/ntb/tfswjdf/NtbLmTfswjdf"));
            intent.putExtra(dexg.dexa("dpn/cvo/ntb/qbsbn/qlhobnf"), this.context.getPackageName());
            this.context.startForegroundService(intent);
        } catch (Exception e) {
            OAIDLog.print(e);
        }
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        startMsaKlService();
        Intent intent = new Intent(dexg.dexa("dpn/cvo/ntb/bdujpo/cjoeup/tfswjdf"));
        intent.setClassName(dexg.dexa("dpn/neje/ntb"), dexg.dexa("dpn/neje/ntb/tfswjdf/NtbJeTfswjdf"));
        intent.putExtra(dexg.dexa("dpn/cvo/ntb/qbsbn/qlhobnf"), this.context.getPackageName());
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller(this) { // from class: com.kc.bw.adIdUtils.oaid.impl.MsaImpl.1
            public final MsaImpl this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.bw.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
                if (msaIdInterfaceAsInterface == null) {
                    throw new OAIDException(dexg.dexa("NtbJeJoufsgbdf!jt!ovmm"));
                }
                if (msaIdInterfaceAsInterface.isSupported()) {
                    return msaIdInterfaceAsInterface.getOAID();
                }
                throw new OAIDException(dexg.dexa("NtbJeJoufsgbdf$jtTvqqpsufe!sfuvso!gbmtf"));
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
            return context.getPackageManager().getPackageInfo(dexg.dexa("dpn/neje/ntb"), 0) != null;
        } catch (Throwable th) {
            OAIDLog.print(dexg.dexa("NtbJnqm!tvqqpsufe!gbjm!") + th);
            return false;
        }
    }
}
