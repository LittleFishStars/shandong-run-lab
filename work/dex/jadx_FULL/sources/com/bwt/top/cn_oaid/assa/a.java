package com.bwt.top.cn_oaid.assa;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.bwt.top.cn_oaid.OAIDException;
import com.bwt.top.cn_oaid.ddksa;
import com.bwt.top.cn_oaid.dkkd;
import com.bwt.top.cn_oaid.repeackage.com.heytap.openid.IOpenID;
import com.zj.adlib.ija;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a implements dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f28247a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1476a;

    /* JADX INFO: renamed from: com.bwt.top.cn_oaid.assa.a$a, reason: collision with other inner class name */
    public class C0344a implements ddddk.kdsksdda {
        public C0344a() {
        }

        @Override // com.bwt.top.cn_oaid.assa.ddddk.kdsksdda
        public String a(IBinder iBinder) throws RemoteException {
            try {
                return a.this.c(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (OAIDException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new OAIDException(e3);
            }
        }
    }

    public a(Context context) {
        this.f28247a = context instanceof Application ? context : context.getApplicationContext();
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public boolean a() {
        Context context = this.f28247a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e) {
            ija.a(e);
            return false;
        }
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public void b(ddksa ddksaVar) {
        if (this.f28247a == null || ddksaVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        ddddk.a(this.f28247a, intent, ddksaVar, new C0344a());
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public final String c(IBinder iBinder) {
        String packageName = this.f28247a.getPackageName();
        String str = this.f1476a;
        if (str != null) {
            return d(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f28247a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.f1476a = string;
        return d(iBinder, packageName, string);
    }

    public final String d(IBinder iBinder, String str, String str2) {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface != null) {
            return iOpenIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }
}
