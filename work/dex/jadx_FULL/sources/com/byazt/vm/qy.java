package com.byazt.vm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 110})
public final class qy implements nu {
    public final nu c;
    public tt<Boolean> tt;

    public qy() {
        this(null);
    }

    @Override // com.byazt.vm.nu
    public boolean tt(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolTt = this.tt.tt(context);
        return (this.c == null || boolTt.booleanValue()) ? boolTt.booleanValue() : this.c.tt(context);
    }

    @Override // com.byazt.vm.nu
    public nu.c ve(final Context context) {
        if (this.c != null && !this.tt.tt(new Object[0]).booleanValue()) {
            return this.c.ve(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new zm(context, intent, new zm.tt<com.byazt.fp.n, String>() { // from class: com.byazt.vm.qy.2
            @Override // com.byazt.vm.zm.tt
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public com.byazt.fp.n tt(IBinder iBinder) {
                return com.byazt.fp.n.c.c(iBinder);
            }

            @Override // com.byazt.vm.zm.tt
            public String c(com.byazt.fp.n nVar) throws Exception {
                if (nVar == null) {
                    return null;
                }
                String strC = qy.this.c(context);
                if (TextUtils.isEmpty(strC)) {
                    return null;
                }
                return nVar.c(context.getPackageName(), strC, "OUID");
            }
        }).c();
        nu.c cVar = new nu.c();
        cVar.tt = str;
        return cVar;
    }

    public qy(nu nuVar) {
        this.tt = new tt<Boolean>() { // from class: com.byazt.vm.qy.1
            @Override // com.byazt.vm.tt
            /* JADX INFO: renamed from: ve, reason: merged with bridge method [inline-methods] */
            public Boolean c(Object... objArr) {
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return Boolean.FALSE;
                    }
                    return Boolean.valueOf((Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode) >= 1);
                } catch (PackageManager.NameNotFoundException unused) {
                    return Boolean.FALSE;
                } catch (Throwable th) {
                    com.byazt.yv.da.c(th);
                    return Boolean.FALSE;
                }
            }
        };
        this.c = nuVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            signatureArr = packageInfo != null ? packageInfo.signatures : null;
        } catch (Exception e) {
            com.byazt.yv.da.c(e);
        }
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest != null) {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                    }
                    return sb.toString();
                }
            } catch (Exception e2) {
                com.byazt.yv.da.c(e2);
            }
        }
        return null;
    }
}
