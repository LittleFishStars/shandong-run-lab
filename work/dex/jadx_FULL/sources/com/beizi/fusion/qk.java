package com.beizi.fusion;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface qk extends IInterface {

    public static abstract class a extends Binder implements qk {

        /* JADX INFO: renamed from: com.beizi.fusion.qk$a$a, reason: collision with other inner class name */
        public static class C0320a implements qk {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f27695a;

            public C0320a(IBinder iBinder) {
                this.f27695a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27695a;
            }

            public String getSerID(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f27695a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (Exception e) {
                    om.a(e);
                    return null;
                } finally {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            }
        }

        public static qk a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof qk)) ? new C0320a(iBinder) : (qk) iInterfaceQueryLocalInterface;
        }
    }
}
