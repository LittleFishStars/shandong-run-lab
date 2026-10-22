package com.fl.saas.config.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.fl.saas.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import com.fl.saas.config.oaid.IGetter;
import com.fl.saas.config.oaid.IOAID;
import com.fl.saas.config.oaid.OAIDException;
import com.fl.saas.config.oaid.OAIDLog;
import com.huawei.hms.common.PackageConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class HuaweiImpl implements IOAID {
    private final Context context;
    private String packageName;

    public HuaweiImpl(Context context) {
        this.context = context;
    }

    @Override // com.fl.saas.config.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Context context = this.context;
        if (context == null || iGetter == null) {
            return;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            if (!TextUtils.isEmpty(string) && !string.matches("^[0-]+$|^-+$")) {
                OAIDLog.print("Get oaid from global settings: " + string);
                iGetter.onOAIDGetComplete(string);
                return;
            }
        } catch (Exception e) {
            OAIDLog.print(e);
        }
        if (TextUtils.isEmpty(this.packageName) && !supported()) {
            iGetter.onOAIDGetError(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.packageName);
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.fl.saas.config.oaid.impl.HuaweiImpl.1
            @Override // com.fl.saas.config.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
                if (openDeviceIdentifierServiceAsInterface.isOaidTrackLimited()) {
                    throw new OAIDException("User has disabled advertising identifier");
                }
                return openDeviceIdentifierServiceAsInterface.getOaid();
            }
        });
    }

    @Override // com.fl.saas.config.oaid.IOAID
    public boolean supported() {
        String str = "com.huawei.hwid.tv";
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null) {
                if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                    this.packageName = PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
                    if (packageManager.getPackageInfo(PackageConstants.SERVICES_PACKAGE_ALL_SCENE, 0) == null) {
                        return false;
                    }
                }
                return true;
            }
            str = "com.huawei.hwid";
            this.packageName = str;
            return true;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
