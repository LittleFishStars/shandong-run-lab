package cn.hzjizhun.admin;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import cn.hzjizhun.admin.cn_oaid.OAIDException;
import cn.hzjizhun.admin.cn_oaid.repeackage.com.heytap.openid.IOpenID;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g implements sdkdda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22720a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f298a;

    public class a implements dadkdadds.kdsksdda {
        public a() {
        }

        @Override // cn.hzjizhun.admin.dadkdadds.kdsksdda
        public String a(IBinder iBinder) throws RemoteException {
            try {
                return g.this.c(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (OAIDException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new OAIDException(th);
            }
        }
    }

    public g(Context context) {
        if (context instanceof Application) {
            this.f22720a = context;
        } else {
            this.f22720a = context.getApplicationContext();
        }
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public boolean a() {
        Context context = this.f22720a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Throwable th) {
            dddssad.a(th);
            return false;
        }
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public void b(ddakd ddakdVar) {
        if (this.f22720a == null || ddakdVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        dadkdadds.a(this.f22720a, intent, ddakdVar, new a());
    }

    public final String c(IBinder iBinder) {
        String packageName = this.f22720a.getPackageName();
        String str = this.f298a;
        if (str != null) {
            return d(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f22720a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.f298a = string;
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
