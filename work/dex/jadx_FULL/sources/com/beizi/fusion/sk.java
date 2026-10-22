package com.beizi.fusion;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.repeackage.com.heytap.openid.IOpenID;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class sk implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27753a;
    private String b;

    public class a implements ck.a {
        public a() {
        }

        @Override // com.beizi.fusion.ck.a
        public String a(IBinder iBinder) throws RemoteException {
            try {
                return sk.this.a(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (sj e2) {
                throw e2;
            } catch (Exception e3) {
                throw new sj(e3);
            }
        }
    }

    public sk(Context context) {
        if (context instanceof Application) {
            this.f27753a = context;
        } else {
            this.f27753a = context.getApplicationContext();
        }
    }

    @Override // com.beizi.fusion.xd
    public boolean a() {
        Context context = this.f27753a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e) {
            xj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.xd
    public void a(jc jcVar) {
        if (this.f27753a == null || jcVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        ck.a(this.f27753a, intent, jcVar, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(IBinder iBinder) {
        String packageName = this.f27753a.getPackageName();
        String str = this.b;
        if (str == null) {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f27753a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            String string = sb.toString();
            this.b = string;
            return a(iBinder, packageName, string);
        }
        return a(iBinder, packageName, str);
    }

    private String a(IBinder iBinder, String str, String str2) {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface != null) {
            return iOpenIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new sj("IOpenID is null");
    }
}
