package com.alipay.sdk.m.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.alipay.sdk.m.a.a f25389a = null;
    public String b = null;
    public String c = null;
    public final Object d = new Object();
    public ServiceConnection e = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f25389a = com.alipay.sdk.m.a.a.AbstractBinderC0183a.a(iBinder);
            synchronized (b.this.d) {
                b.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f25389a = null;
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.b.b$b, reason: collision with other inner class name */
    public static class C0187b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f25391a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
    }

    public boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo != null && packageInfo.getLongVersionCode() >= 1;
            }
            return packageInfo != null && packageInfo.versionCode >= 1;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.c)) {
            String string = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e) {
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
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                }
            }
            this.c = string;
        }
        String strA = ((com.alipay.sdk.m.a.a.AbstractBinderC0183a.C0184a) this.f25389a).a(this.b, this.c, str);
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:45:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public synchronized String a(Context context, String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (this.f25389a == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.e, 1)) {
                    synchronized (this.d) {
                        try {
                            this.d.wait(3000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (this.f25389a == null) {
                        return "";
                    }
                    try {
                        return b(context, str);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        return "";
                    }
                }
                if (this.f25389a == null) {
                    return "";
                }
                return b(context, str);
            }
            try {
                return b(context, str);
            } catch (RemoteException e3) {
                e3.printStackTrace();
                return "";
            }
            throw th;
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }
}
