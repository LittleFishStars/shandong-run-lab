package com.fl.saas.com;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class HonorOaidHelper {
    private static final String DESC_CALLBACK = "com.hihonor.cloudservice.oaid.IOAIDCallBack";
    private static final String DESC_SERVICE = "com.hihonor.cloudservice.oaid.IOAIDService";
    private static final String SERVICE_ACTION = "com.hihonor.id.HnOaIdService";
    private static final String SERVICE_PKG = "com.hihonor.id";

    public static class OaidCallback extends Binder implements IInterface {
        private final CountDownLatch latch;
        private final OaidResult result;

        public OaidCallback(CountDownLatch countDownLatch, OaidResult oaidResult) {
            this.latch = countDownLatch;
            this.result = oaidResult;
            attachInterface(this, HonorOaidHelper.DESC_CALLBACK);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            try {
                parcel.enforceInterface(HonorOaidHelper.DESC_CALLBACK);
            } catch (Exception unused) {
            }
            int i3 = parcel.readInt();
            if (parcel.readInt() != 0) {
                try {
                    Bundle bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    bundle.setClassLoader(OaidResult.class.getClassLoader());
                    String string = bundle.getString("oa_id_flag");
                    if (i3 == 0 && string != null) {
                        OaidResult oaidResult = this.result;
                        oaidResult.oaid = string;
                        oaidResult.isLimit = bundle.getBoolean("oa_id_limit_state");
                        this.latch.countDown();
                    }
                } catch (Exception unused2) {
                }
            }
            if (parcel2 == null) {
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    public static class OaidResult {
        public String oaid = null;
        public boolean isLimit = false;
    }

    public static OaidResult getOaid(Context context) {
        OaidResult oaidResult = new OaidResult();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final OaidCallback oaidCallback = new OaidCallback(countDownLatch, oaidResult);
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.fl.saas.com.HonorOaidHelper.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HonorOaidHelper.sendRequest(iBinder, oaidCallback, 1);
                HonorOaidHelper.sendRequest(iBinder, oaidCallback, 2);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                countDownLatch.countDown();
            }
        };
        Intent intent = new Intent(SERVICE_ACTION);
        intent.setPackage(SERVICE_PKG);
        try {
            if (context.bindService(intent, serviceConnection, 1)) {
                try {
                    countDownLatch.await(3L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            try {
                context.unbindService(serviceConnection);
            } catch (Exception unused2) {
            }
            throw th;
        }
        try {
            context.unbindService(serviceConnection);
        } catch (Exception unused3) {
        }
        return oaidResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendRequest(IBinder iBinder, OaidCallback oaidCallback, int i) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(DESC_SERVICE);
            parcelObtain.writeStrongBinder(oaidCallback);
            iBinder.transact(i, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } catch (Exception unused) {
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
