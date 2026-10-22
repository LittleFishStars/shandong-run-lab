package cj.mobile.wm.adIdUtils.oaid.impl;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.adIdUtils.oaid.lib.heytap.openid.IOpenID;
import cj.mobile.wm.dexc;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OppoImpl extends IOAID {
    public final Context context;
    public String sign;
    public final String PACKAGE_NAME = dexc.dexa("dpn/ifzubq/pqfoje");
    public final String CLASS_NAME = dexc.dexa("dpn/ifzubq/pqfoje/JefoujgzTfswjdf");
    public final String ACTION = dexc.dexa("bdujpo/dpn/ifzubq/pqfoje/PQFO`JE`TFSWJDF");

    public OppoImpl(Context context) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String dexa(IBinder iBinder) throws OAIDException, RemoteException {
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

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent(this.ACTION);
        intent.setComponent(new ComponentName(this.PACKAGE_NAME, this.CLASS_NAME));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.zj.adlib.hd6
            @Override // cj.mobile.wm.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return this.f42105a.dexa(iBinder);
            }
        });
    }

    public String getSerId(IBinder iBinder, String str, String str2) throws OAIDException, RemoteException {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface != null) {
            return iOpenIDAsInterface.getSerID(str, str2, dexc.dexa("PVJE"));
        }
        throw new OAIDException(dexc.dexa("PqqpJnqm!JPqfoJE!jt!ovmm"));
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public String realGetOUID(IBinder iBinder) throws OAIDException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException {
        String packageName = this.context.getPackageName();
        String str = this.sign;
        if (str != null) {
            return getSerId(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance(dexc.dexa("TIB2")).digest(this.context.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.sign = string;
        return getSerId(iBinder, packageName, string);
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
            OAIDLog.print(dexc.dexa("PqqpJnqm!difdl!tvqqpsufe"));
            IOAID.checkDone = true;
            IOAID.isSupported = this.context.getPackageManager().getPackageInfo(this.PACKAGE_NAME, 0) != null;
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("PqqpJnqm!difdl!tvqqpsufe!gbjm-") + th);
        }
        return IOAID.isSupported;
    }
}
