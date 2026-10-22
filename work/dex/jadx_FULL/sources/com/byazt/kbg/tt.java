package com.byazt.kbg;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface tt extends IInterface {
    void c(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    void c(com.byazt.kbg.c cVar) throws RemoteException;

    void tt(com.byazt.kbg.c cVar) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static abstract class c extends Binder implements tt {
        public static tt c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof tt)) ? new C0449c(iBinder) : (tt) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                c(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                c(com.byazt.kbg.c.AbstractBinderC0447c.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDService");
                return true;
            }
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            tt(com.byazt.kbg.c.AbstractBinderC0447c.c(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static tt c() {
            return C0449c.c;
        }

        /* JADX INFO: renamed from: com.byazt.kbg.tt$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, 1944})
        public static class C0449c implements tt {
            public static tt c;
            public IBinder tt;

            public C0449c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            @Override // com.byazt.kbg.tt
            public void c(int i, long j, boolean z, float f, double d, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeString(str);
                    try {
                        if (this.tt.transact(1, parcelObtain, parcelObtain2, 0) || c.c() == null) {
                            parcelObtain2.readException();
                        } else {
                            c.c().c(i, j, z, f, d, str);
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

            @Override // com.byazt.kbg.tt
            public void tt(com.byazt.kbg.c cVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (this.tt.transact(3, parcelObtain, parcelObtain2, 0) || c.c() == null) {
                        parcelObtain2.readException();
                    } else {
                        c.c().tt(cVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.kbg.tt
            public void c(com.byazt.kbg.c cVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (!this.tt.transact(2, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(cVar);
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
