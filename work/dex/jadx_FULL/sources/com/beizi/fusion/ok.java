package com.beizi.fusion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27618a;
    private String c;
    qk d;
    public String b = "OUID";
    ServiceConnection e = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ok.this.d = qk.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ok.this.d = null;
        }
    }

    public ok(Context context) {
        this.f27618a = context;
    }

    public String a(c7.a aVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot run on MainThread");
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        if (this.f27618a.bindService(intent, this.e, 1)) {
            try {
                SystemClock.sleep(3000L);
            } catch (Exception e) {
                om.a(e);
            }
            if (this.d != null) {
                String strA = a("OUID");
                if (aVar == null) {
                    return strA;
                }
                aVar.a(strA);
                return strA;
            }
        }
        return null;
    }

    private String a(String str) {
        Signature[] signatureArr;
        String packageName = this.f27618a.getPackageName();
        if (this.c == null) {
            String string = null;
            try {
                signatureArr = this.f27618a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e) {
                om.a(e);
                signatureArr = null;
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
                        string = sb.toString();
                    }
                } catch (Exception e2) {
                    om.a(e2);
                }
            }
            this.c = string;
        }
        return ((qk.a.C0320a) this.d).getSerID(packageName, this.c, str);
    }
}
