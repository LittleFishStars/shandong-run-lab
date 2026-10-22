package com.beizi.fusion;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class tk implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27786a;
    private String b;

    public class a implements bk.a {
        public a() {
        }

        @Override // com.beizi.fusion.bk.a
        public String a(IBinder iBinder) throws RemoteException {
            try {
                return tk.this.a(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (tj e2) {
                throw e2;
            } catch (Exception e3) {
                throw new tj(e3);
            }
        }
    }

    public tk(Context context) {
        if (context instanceof Application) {
            this.f27786a = context;
        } else {
            this.f27786a = context.getApplicationContext();
        }
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        Context context = this.f27786a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e) {
            yj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        if (this.f27786a == null || kcVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        bk.a(this.f27786a, intent, kcVar, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(IBinder iBinder) {
        String packageName = this.f27786a.getPackageName();
        String str = this.b;
        if (str == null) {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f27786a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
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
        ae aeVarA = ae.a.a(iBinder);
        if (aeVarA != null) {
            return aeVarA.getSerID(str, str2, "OUID");
        }
        throw new tj("IOpenID is null");
    }
}
