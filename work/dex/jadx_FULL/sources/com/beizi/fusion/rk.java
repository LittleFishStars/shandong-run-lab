package com.beizi.fusion;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface rk extends IInterface {

    public static abstract class a extends Binder implements rk {

        /* JADX INFO: renamed from: com.beizi.fusion.rk$a$a, reason: collision with other inner class name */
        public static class C0322a implements rk {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f27728a;

            public C0322a(IBinder iBinder) {
                this.f27728a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27728a;
            }

            public String getSerID(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f27728a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                } finally {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            }
        }

        public static rk a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof rk)) ? new C0322a(iBinder) : (rk) iInterfaceQueryLocalInterface;
        }
    }
}
