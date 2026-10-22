package com.kc.bw.adIdUtils.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.adIdUtils.oaid.lib.heytap.openid.IOpenID;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OppoImpl implements IOAID {
    public static int alreadyQueried;
    public static boolean isSupported;
    public final Context context;
    public String sign;

    public OppoImpl(Context context) {
        this.context = context instanceof Application ? context : context.getApplicationContext();
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent(dexg.dexa("bdujpo/dpn/ifzubq/pqfoje/PQFO`JE`TFSWJDF"));
        intent.setComponent(new ComponentName(dexg.dexa("dpn/ifzubq/pqfoje"), dexg.dexa("dpn/ifzubq/pqfoje/JefoujgzTfswjdf")));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller(this) { // from class: com.kc.bw.adIdUtils.oaid.impl.OppoImpl.1
            public final OppoImpl this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.bw.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                try {
                    return this.this$0.realGetOUID(iBinder);
                } catch (RemoteException e) {
                    throw e;
                } catch (OAIDException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new OAIDException(e3);
                }
            }
        });
    }

    public String getSerId(IBinder iBinder, String str, String str2) throws OAIDException, RemoteException {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface != null) {
            return iOpenIDAsInterface.getSerID(str, str2, dexg.dexa("PVJE"));
        }
        throw new OAIDException(dexg.dexa("JPqfoJE!jt!ovmm"));
    }

    public String realGetOUID(IBinder iBinder) throws OAIDException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException {
        String packageName = this.context.getPackageName();
        String str = this.sign;
        if (str != null) {
            return getSerId(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance(dexg.dexa("TIB2")).digest(this.context.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.sign = string;
        return getSerId(iBinder, packageName, string);
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
            if (context.getPackageManager().getPackageInfo(dexg.dexa("dpn/ifzubq/pqfoje"), 0) == null) {
                z = false;
            }
            isSupported = z;
            return z;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
