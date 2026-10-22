package com.beizi.fusion;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface ae extends IInterface {

    public static abstract class a extends Binder implements ae {

        /* JADX INFO: renamed from: com.beizi.fusion.ae$a$a, reason: collision with other inner class name */
        public static class C0296a implements ae {
            public static ae b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f27003a;

            public C0296a(IBinder iBinder) {
                this.f27003a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27003a;
            }

            @Override // com.beizi.fusion.ae
            public String getSerID(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (!this.f27003a.transact(1, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().getSerID(str, str2, str3);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ae a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ae)) ? new C0296a(iBinder) : (ae) iInterfaceQueryLocalInterface;
        }

        public static ae b() {
            return C0296a.b;
        }
    }

    String getSerID(String str, String str2, String str3);
}
