package com.byazt.uk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface uj extends IInterface {
    void c(String str, int i, String str2) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 87, 123})
    public static abstract class c extends Binder implements uj {

        /* JADX INFO: renamed from: com.byazt.uk.uj$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 87, MediaPlayer.MEDIA_PLAYER_OPTION_AE_TAR_LUFS})
        public static class C0542c implements uj {
            public static uj c;
            public IBinder tt;

            public C0542c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            @Override // com.byazt.uk.uj
            public void c(String str, int i, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPluginInstallListener");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    if (this.tt.transact(1, parcelObtain, parcelObtain2, 0) || c.c() == null) {
                        parcelObtain2.readException();
                    } else {
                        c.c().c(str, i, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public c() {
            attachInterface(this, "com.bytedance.pangle.IPluginInstallListener");
        }

        public static uj c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPluginInstallListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof uj)) ? new C0542c(iBinder) : (uj) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.pangle.IPluginInstallListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPluginInstallListener");
            c(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        public static uj c() {
            return C0542c.c;
        }
    }
}
