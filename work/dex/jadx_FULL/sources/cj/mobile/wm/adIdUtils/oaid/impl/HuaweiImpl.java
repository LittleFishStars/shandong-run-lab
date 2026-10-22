package cj.mobile.wm.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.adIdUtils.oaid.impl.HuaweiImpl;
import cj.mobile.wm.adIdUtils.oaid.lib.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HuaweiImpl extends IOAID {
    public final Context context;
    public String packageName;
    public final String PACKAGE_NAME1 = dexc.dexa("dpn/ivbxfj/ixje");
    public final String PACKAGE_NAME2 = dexc.dexa("dpn/ivbxfj/ixje/uw");
    public final String PACKAGE_NAME3 = dexc.dexa("dpn/ivbxfj/int");
    public final String ACTION = dexc.dexa("dpn/vpejt/pqfoefwjdf/PQFOJET`TFSWJDF");

    public HuaweiImpl(Context context) {
        this.context = context;
    }

    public static /* synthetic */ String dexa(IBinder iBinder) throws OAIDException, RemoteException {
        OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
        if (openDeviceIdentifierServiceAsInterface.isOaidTrackLimited()) {
            throw new OAIDException(dexc.dexa("IvbxfjJnqm!Vtfs!ibt!ejtbcmfe!bewfsujtjoh!jefoujgjfs"));
        }
        return openDeviceIdentifierServiceAsInterface.getOaid();
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Context context = this.context;
        if (context == null || iGetter == null) {
            return;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), dexc.dexa("qqt`pbje"));
            if (!TextUtils.isEmpty(string)) {
                OAIDLog.print(dexc.dexa("IvbxfjJnqm!Hfu!pbje!gspn!hmpcbm!tfuujoht-pbje>") + string);
                iGetter.onOAIDGetComplete(string);
                return;
            }
        } catch (Exception e) {
            OAIDLog.print(e);
        }
        if (TextUtils.isEmpty(this.packageName) && !supported()) {
            iGetter.onOAIDGetError(new OAIDException(dexc.dexa("IvbxfjJnqm!opu!tvqqpsufe")));
            return;
        }
        Intent intent = new Intent(this.ACTION);
        intent.setPackage(this.packageName);
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.zj.adlib.b34
            @Override // cj.mobile.wm.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return HuaweiImpl.dexa(iBinder);
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
            OAIDLog.print(dexc.dexa("IvbxfjJnqm!difdl!tvqqpsufe"));
            IOAID.checkDone = true;
            PackageManager packageManager = this.context.getPackageManager();
            if (packageManager.getPackageInfo(this.PACKAGE_NAME1, 0) != null) {
                this.packageName = this.PACKAGE_NAME1;
                IOAID.isSupported = true;
            } else if (packageManager.getPackageInfo(this.PACKAGE_NAME2, 0) != null) {
                this.packageName = this.PACKAGE_NAME2;
                IOAID.isSupported = true;
            } else {
                String str = this.PACKAGE_NAME3;
                this.packageName = str;
                IOAID.isSupported = packageManager.getPackageInfo(str, 0) != null;
            }
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("IvbxfjJnqm!difdl!tvqqpsufe!gbjm-") + th);
        }
        return IOAID.isSupported;
    }
}
