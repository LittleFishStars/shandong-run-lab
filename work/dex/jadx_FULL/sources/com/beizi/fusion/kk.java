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
public class kk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27475a;
    private String c;
    mk d;
    public String b = "OUID";
    ServiceConnection e = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            kk.this.d = mk.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            kk.this.d = null;
        }
    }

    public kk(Context context) {
        this.f27475a = context;
    }

    public String a(b7.b bVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot run on MainThread");
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        if (this.f27475a.bindService(intent, this.e, 1)) {
            try {
                SystemClock.sleep(3000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.d != null) {
                String strA = a("OUID");
                if (bVar == null) {
                    return strA;
                }
                bVar.a(strA);
                return strA;
            }
        }
        return null;
    }

    private String a(String str) {
        Signature[] signatureArr;
        String packageName = this.f27475a.getPackageName();
        if (this.c == null) {
            String string = null;
            try {
                signatureArr = this.f27475a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e) {
                e.printStackTrace();
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
                    e2.printStackTrace();
                }
            }
            this.c = string;
        }
        return ((mk.a.C0316a) this.d).getSerID(packageName, this.c, str);
    }
}
