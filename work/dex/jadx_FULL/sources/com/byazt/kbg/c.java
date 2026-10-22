package com.byazt.kbg;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface c extends IInterface {
    void c(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    void c(int i, Bundle bundle) throws RemoteException;

    /* JADX INFO: renamed from: com.byazt.kbg.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, 44})
    public static abstract class AbstractBinderC0447c extends Binder implements c {
        public AbstractBinderC0447c() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        public static c c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0448c(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        public static c tt() {
            return C0448c.c;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                c(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                return true;
            }
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            c(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.kbg.c$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_STAT_INFO})
        public static class C0448c implements c {
            public static c c;
            public IBinder tt;

            public C0448c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            @Override // com.byazt.kbg.c
            public void c(int i, long j, boolean z, float f, double d, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeString(str);
                    try {
                        if (this.tt.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0447c.tt() == null) {
                            parcelObtain2.readException();
                        } else {
                            AbstractBinderC0447c.tt().c(i, j, z, f, d, str);
                        }
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.byazt.kbg.c
            public void c(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.tt.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0447c.tt() != null) {
                        AbstractBinderC0447c.tt().c(i, bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
