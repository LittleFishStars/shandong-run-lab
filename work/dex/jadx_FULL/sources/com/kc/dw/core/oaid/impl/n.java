package com.kc.dw.core.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kc.dw.core.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class n implements com.kc.dw.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39291a;
    public String b;

    @Keep
    public class a implements m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f39292a;

        public a(n nVar) {
            this.f39292a = nVar;
        }

        @Override // com.kc.dw.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            try {
                return this.f39292a.a(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (OAIDException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new OAIDException(e3);
            }
        }
    }

    public n(Context context) {
        this.f39291a = context instanceof Application ? context : context.getApplicationContext();
    }

    public final String a(IBinder iBinder) throws OAIDException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException {
        String packageName = this.f39291a.getPackageName();
        String str = this.b;
        if (str != null) {
            return a(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f39291a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.b = string;
        return a(iBinder, packageName, string);
    }

    public final String a(IBinder iBinder, String str, String str2) throws OAIDException, RemoteException {
        com.kc.dw.core.oaid.repeackage.com.heytap.openid.a c1039a;
        int i = com.kc.dw.core.oaid.repeackage.com.heytap.openid.a.AbstractBinderC1038a.f39306a;
        if (iBinder == null) {
            c1039a = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            c1039a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.kc.dw.core.oaid.repeackage.com.heytap.openid.a)) ? new com.kc.dw.core.oaid.repeackage.com.heytap.openid.a.AbstractBinderC1038a.C1039a(iBinder) : (com.kc.dw.core.oaid.repeackage.com.heytap.openid.a) iInterfaceQueryLocalInterface;
        }
        if (c1039a != null) {
            return c1039a.a(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }

    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (this.f39291a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        m.a(this.f39291a, intent, aVar, new a(this));
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        Context context = this.f39291a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}
