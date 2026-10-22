package XI.K0.XI;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface XI extends IInterface {

    public class K0 {

        /* JADX INFO: renamed from: XI, reason: collision with root package name */
        public XI f21173XI = null;
        public String K0 = null;
        public String kM = null;
        public final Object xo = new Object();
        public ServiceConnection CA = new ServiceConnectionC0001XI();

        /* JADX INFO: renamed from: XI.K0.XI.XI$K0$K0, reason: collision with other inner class name */
        public static class C0000K0 {

            /* JADX INFO: renamed from: XI, reason: collision with root package name */
            public static final K0 f21174XI = new K0();
        }

        /* JADX INFO: renamed from: XI.K0.XI.XI$K0$XI, reason: collision with other inner class name */
        public class ServiceConnectionC0001XI implements ServiceConnection {
            public ServiceConnectionC0001XI() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                XI c0003xi;
                K0 k0 = K0.this;
                int i = AbstractBinderC0002XI.f21176XI;
                if (iBinder == null) {
                    c0003xi = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                    c0003xi = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof XI)) ? new AbstractBinderC0002XI.C0003XI(iBinder) : (XI) iInterfaceQueryLocalInterface;
                }
                k0.f21173XI = c0003xi;
                synchronized (K0.this.xo) {
                    K0.this.xo.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                K0.this.f21173XI = null;
            }
        }

        public final String K0(Context context, String str) {
            Signature[] signatureArr;
            if (TextUtils.isEmpty(this.K0)) {
                this.K0 = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.kM)) {
                String string = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.K0, 64).signatures;
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
                this.kM = string;
            }
            XI xi = this.f21173XI;
            if (xi == null) {
                context.getPackageName();
                return "";
            }
            String str2 = this.K0;
            String str3 = this.kM;
            AbstractBinderC0002XI.C0003XI c0003xi = (AbstractBinderC0002XI.C0003XI) xi;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str3);
                parcelObtain.writeString(str);
                c0003xi.f21177XI.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                String string2 = parcelObtain2.readString();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return TextUtils.isEmpty(string2) ? "" : string2;
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }

        public synchronized String XI(Context context, String str) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return "";
            }
            if (this.f21173XI != null) {
                try {
                    return K0(context, str);
                } catch (RemoteException unused) {
                    return "";
                }
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (context.bindService(intent, this.CA, 1)) {
                synchronized (this.xo) {
                    try {
                        this.xo.wait(3000L);
                    } catch (InterruptedException unused2) {
                    }
                }
            }
            if (this.f21173XI == null) {
                return "";
            }
            try {
                return K0(context, str);
            } catch (RemoteException unused3) {
                return "";
            }
        }
    }

    /* JADX INFO: renamed from: XI.K0.XI.XI$XI, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0002XI extends Binder implements XI {

        /* JADX INFO: renamed from: XI, reason: collision with root package name */
        public static final /* synthetic */ int f21176XI = 0;

        /* JADX INFO: renamed from: XI.K0.XI.XI$XI$XI, reason: collision with other inner class name */
        public static class C0003XI implements XI {

            /* JADX INFO: renamed from: XI, reason: collision with root package name */
            public IBinder f21177XI;

            public C0003XI(IBinder iBinder) {
                this.f21177XI = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21177XI;
            }
        }
    }
}
