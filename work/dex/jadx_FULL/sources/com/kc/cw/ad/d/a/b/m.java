package com.kc.cw.ad.d.a.b;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class m implements com.kc.cw.ad.d.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38800a;
    private String b;

    public m(Context context) {
        this.f38800a = context instanceof Application ? context : context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, com.kc.cw.ad.d.a.e, RemoteException {
        String packageName = this.f38800a.getPackageName();
        String str = this.b;
        if (str != null) {
            return a(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f38800a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.b = string;
        return a(iBinder, packageName, string);
    }

    private String a(IBinder iBinder, String str, String str2) throws com.kc.cw.ad.d.a.e, RemoteException {
        com.kc.cw.ad.d.a.a.a.e.a.a aVarA = com.kc.cw.ad.d.a.a.a.e.a.a.AbstractBinderC0991a.a(iBinder);
        if (aVarA != null) {
            return aVarA.a(str, str2, "OUID");
        }
        throw new com.kc.cw.ad.d.a.e("IOpenID is null");
    }

    @Override // com.kc.cw.ad.d.a.d
    public void a(com.kc.cw.ad.d.a.c cVar) {
        if (this.f38800a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        l.a(this.f38800a, intent, cVar, new l.a(this) { // from class: com.kc.cw.ad.d.a.b.m.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final m f38801a;

            {
                this.f38801a = this;
            }

            @Override // com.kc.cw.ad.d.a.b.l.a
            public String a(IBinder iBinder) throws com.kc.cw.ad.d.a.e, RemoteException {
                try {
                    return this.f38801a.a(iBinder);
                } catch (RemoteException e) {
                    throw e;
                } catch (com.kc.cw.ad.d.a.e e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new com.kc.cw.ad.d.a.e(e3);
                }
            }
        });
    }

    @Override // com.kc.cw.ad.d.a.d
    public boolean a() {
        Context context = this.f38800a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
            return false;
        }
    }
}
