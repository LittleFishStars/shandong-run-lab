package cj.mobile.wm.adIdUtils.oaid.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.adIdUtils.oaid.lib.honor.cloudservice.oaid.IHonorOAIDInterface;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HonorImpl extends IOAID {
    public final Context context;
    public final String PACKAGE_NAME = dexc.dexa("dpn/ijipops/je");
    public final String ACTION = dexc.dexa("dpn/ijipops/je/IoPbJeTfswjdf");
    public final String LIMIT_STATE = dexc.dexa("pbje`mjnju`tubuf");
    public final String KEY = dexc.dexa("pbje");

    public HonorImpl(Context context) {
        this.context = context;
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        String string;
        Context context = this.context;
        if (context == null || iGetter == null) {
            return;
        }
        String string2 = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            string = Settings.Global.getString(contentResolver, this.LIMIT_STATE);
            try {
                string2 = Settings.Global.getString(contentResolver, this.KEY);
            } catch (Throwable th) {
                th = th;
                OAIDLog.print(dexc.dexa("IpopsJnqm!hfuPbje!dbdif!gbjm-") + th);
            }
        } catch (Throwable th2) {
            th = th2;
            string = null;
        }
        if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string)) {
            if (!supported()) {
                iGetter.onOAIDGetError(new OAIDException(dexc.dexa("IpopsJnqm!opu!tvqqpsufe")));
                return;
            }
            Intent intent = new Intent(this.ACTION);
            intent.setPackage(this.PACKAGE_NAME);
            OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.zj.adlib.w14
                @Override // cj.mobile.wm.adIdUtils.oaid.impl.OAIDService.RemoteCaller
                public final String callRemoteInterface(IBinder iBinder) {
                    return IHonorOAIDInterface.Stub.asInterface(iBinder).getOaid();
                }
            });
            return;
        }
        OAIDLog.print(dexc.dexa("IpopsJnqm!pbje!gspn!hmpcbm!tfuujoht-pbje>") + string2 + dexc.dexa("-jtMjnju>") + Boolean.parseBoolean(string));
        iGetter.onOAIDGetComplete(string2);
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
            OAIDLog.print(dexc.dexa("IpopsJnqm!difdl!tvqqpsufe"));
            IOAID.checkDone = true;
            if (this.context.getPackageManager().getPackageInfo(this.PACKAGE_NAME, 0) != null) {
                Intent intent = new Intent(this.ACTION);
                intent.setPackage(this.PACKAGE_NAME);
                IOAID.isSupported = true ^ this.context.getPackageManager().queryIntentServices(intent, 0).isEmpty();
            }
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("IpopsJnqm!difdl!tvqqpsufe!gbjm-") + th);
        }
        return IOAID.isSupported;
    }
}
