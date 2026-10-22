package com.kc.bw.adIdUtils.oaid.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.adIdUtils.oaid.lib.honor.cloudservice.oaid.IHonorOAIDInterface;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HonorImpl implements IOAID {
    public Context context;
    public static final String PACKAGE_NAME = dexg.dexa("dpn/ijipops/je");
    public static final String ACTION = dexg.dexa("dpn/ijipops/je/IoPbJeTfswjdf");
    public static final String OaidLimitStateKey = dexg.dexa("pbje`mjnju`tubuf");
    public static final String OaidKey = dexg.dexa("pbje");
    public static final String TAG = HonorImpl.class.getSimpleName();
    public static boolean isSupported = false;
    public static int alreadyQueried = 0;

    public HonorImpl(Context context) {
        this.context = context;
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        String string;
        Context context = this.context;
        if (context == null || iGetter == null) {
            return;
        }
        String string2 = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            string = Settings.Global.getString(contentResolver, OaidLimitStateKey);
            try {
                string2 = Settings.Global.getString(contentResolver, OaidKey);
            } catch (Throwable th) {
                th = th;
                OAIDLog.print(TAG + dexg.dexa("!hfuBewfsujtjohJeJogp!dbdif!fssps>") + th);
            }
        } catch (Throwable th2) {
            th = th2;
            string = null;
        }
        if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string)) {
            if (supported()) {
                Intent intent = new Intent(ACTION);
                intent.setPackage(PACKAGE_NAME);
                OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller(this) { // from class: com.kc.bw.adIdUtils.oaid.impl.HonorImpl.1
                    public final HonorImpl this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // com.kc.bw.adIdUtils.oaid.impl.OAIDService.RemoteCaller
                    public String callRemoteInterface(IBinder iBinder) throws OAIDException {
                        return IHonorOAIDInterface.Stub.asInterface(iBinder).getOaid();
                    }
                });
                return;
            } else {
                iGetter.onOAIDGetError(new OAIDException(TAG + dexg.dexa("!Bewfsujtjoh!JE!opu!bwbjmbcmf")));
                return;
            }
        }
        OAIDLog.print(TAG + dexg.dexa("!pbje!gspn!hmpcbm!tfuujoht;!") + string2 + dexg.dexa("-jtMjnju>") + Boolean.parseBoolean(string));
        iGetter.onOAIDGetComplete(string2);
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        int i = alreadyQueried;
        if (i > 0) {
            Log.d(TAG, dexg.dexa("br"));
            return isSupported;
        }
        try {
            alreadyQueried = i + 1;
            PackageManager packageManager = context.getPackageManager();
            String str = PACKAGE_NAME;
            if (packageManager.getPackageInfo(str, 0) != null) {
                Intent intent = new Intent(ACTION);
                intent.setPackage(str);
                isSupported = !this.context.getPackageManager().queryIntentServices(intent, 0).isEmpty();
            }
        } catch (Throwable th) {
            OAIDLog.print(TAG + dexg.dexa("!tvqqpsufe!gbjm!") + th);
        }
        return isSupported;
    }
}
