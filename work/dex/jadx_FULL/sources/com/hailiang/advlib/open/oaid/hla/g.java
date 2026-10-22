package com.hailiang.advlib.open.oaid.hla;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
class g implements com.hailiang.advlib.open.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f32594a;
    private String b;

    @Keep
    public class a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g f32595a;

        public a(g gVar) {
            this.f32595a = gVar;
        }

        @Override // com.hailiang.advlib.open.oaid.hla.f.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            try {
                return this.f32595a.a(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (OAIDException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new OAIDException(e3);
            }
        }
    }

    public g(Context context) {
        this.f32594a = context instanceof Application ? context : context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(IBinder iBinder) throws OAIDException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException {
        String packageName = this.f32594a.getPackageName();
        String str = this.b;
        if (str != null) {
            return a(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f32594a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.b = string;
        return a(iBinder, packageName, string);
    }

    private String a(IBinder iBinder, String str, String str2) throws OAIDException, RemoteException {
        com.hailiang.advlib.open.oaid.hl.hla.hl.a aVarA = com.hailiang.advlib.open.oaid.hl.hla.hl.a.b.a(iBinder);
        if (aVarA != null) {
            return aVarA.a(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f32594a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        f.a(this.f32594a, intent, aVar, new a(this));
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        Context context = this.f32594a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
