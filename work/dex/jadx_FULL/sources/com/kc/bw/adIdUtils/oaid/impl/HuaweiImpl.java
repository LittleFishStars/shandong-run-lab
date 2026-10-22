package com.kc.bw.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.adIdUtils.oaid.lib.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HuaweiImpl implements IOAID {
    public static int alreadyQueried;
    public static boolean isSupported;
    public final Context context;
    public String packageName;

    public HuaweiImpl(Context context) {
        this.context = context;
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Context context = this.context;
        if (context == null || iGetter == null) {
            return;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), dexg.dexa("qqt`pbje"));
            if (!TextUtils.isEmpty(string)) {
                OAIDLog.print(dexg.dexa("Hfu!pbje!gspn!hmpcbm!tfuujoht;!") + string);
                iGetter.onOAIDGetComplete(string);
                return;
            }
        } catch (Exception e) {
            OAIDLog.print(e);
        }
        if (TextUtils.isEmpty(this.packageName) && !supported()) {
            iGetter.onOAIDGetError(new OAIDException(dexg.dexa("Ivbxfj!Bewfsujtjoh!JE!opu!bwbjmbcmf")));
            return;
        }
        Intent intent = new Intent(dexg.dexa("dpn/vpejt/pqfoefwjdf/PQFOJET`TFSWJDF"));
        intent.setPackage(this.packageName);
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller(this) { // from class: com.kc.bw.adIdUtils.oaid.impl.HuaweiImpl.1
            public final HuaweiImpl this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.bw.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
                if (openDeviceIdentifierServiceAsInterface.isOaidTrackLimited()) {
                    throw new OAIDException(dexg.dexa("Vtfs!ibt!ejtbcmfe!bewfsujtjoh!jefoujgjfs"));
                }
                return openDeviceIdentifierServiceAsInterface.getOaid();
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
        try {
            alreadyQueried = i + 1;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo(dexg.dexa("dpn/ivbxfj/ixje"), 0) == null) {
                if (packageManager.getPackageInfo(dexg.dexa("dpn/ivbxfj/ixje/uw"), 0) != null) {
                    this.packageName = dexg.dexa("dpn/ivbxfj/ixje/uw");
                } else {
                    String strDexa = dexg.dexa("dpn/ivbxfj/int");
                    this.packageName = strDexa;
                    isSupported = packageManager.getPackageInfo(strDexa, 0) != null;
                }
                return isSupported;
            }
            this.packageName = dexg.dexa("dpn/ivbxfj/ixje");
            isSupported = true;
        } catch (Throwable th) {
            OAIDLog.print(dexg.dexa("IvbxfjJnqm!tvqqpsufe!gbjm!") + th);
        }
        return isSupported;
    }
}
