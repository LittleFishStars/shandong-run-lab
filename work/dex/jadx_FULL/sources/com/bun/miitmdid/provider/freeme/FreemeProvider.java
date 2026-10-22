package com.bun.miitmdid.provider.freeme;

import XI.XI.K0.K0;
import XI.XI.K0.kM;
import XI.XI.K0.xo;
import XI.XI.XI.XI;
import android.content.Context;
import android.os.RemoteException;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class FreemeProvider extends BaseProvider {
    private static final String TAG = "SDK call Freeme: ";
    private Context context;
    private String packagename;

    /* JADX INFO: renamed from: com.bun.miitmdid.provider.freeme.FreemeProvider$1, reason: invalid class name */
    public class AnonymousClass1 implements xo {
        public final /* synthetic */ kM val$idSupplier;

        public AnonymousClass1(kM kMVar) {
            this.val$idSupplier = kMVar;
        }

        @Override // XI.XI.K0.xo
        public void connectSuccess(boolean z) {
            String oaid;
            String vaid;
            if (z) {
                if (((K0) this.val$idSupplier).XI()) {
                    FreemeProvider.access$002(FreemeProvider.this, true);
                    XI xi = ((K0) this.val$idSupplier).K0;
                    String aaid = null;
                    if (xi != null) {
                        try {
                            oaid = xi.getOAID();
                        } catch (RemoteException e) {
                            e.printStackTrace();
                            oaid = null;
                        }
                    } else {
                        oaid = null;
                    }
                    kM kMVar = this.val$idSupplier;
                    FreemeProvider.access$100(FreemeProvider.this);
                    XI xi2 = ((K0) kMVar).K0;
                    if (xi2 != null) {
                        try {
                            vaid = xi2.getVAID();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            vaid = null;
                        }
                    } else {
                        vaid = null;
                    }
                    kM kMVar2 = this.val$idSupplier;
                    String strAccess$100 = FreemeProvider.access$100(FreemeProvider.this);
                    K0 k0 = (K0) kMVar2;
                    if (k0.K0 != null) {
                        try {
                            Objects.toString(k0.K0);
                            aaid = k0.K0.getAAID(strAccess$100);
                        } catch (RemoteException e3) {
                            e3.printStackTrace();
                        }
                    }
                    FreemeProvider freemeProvider = FreemeProvider.this;
                    if (oaid == null) {
                        oaid = "";
                    }
                    FreemeProvider.access$202(freemeProvider, oaid);
                    FreemeProvider freemeProvider2 = FreemeProvider.this;
                    if (vaid == null) {
                        vaid = "";
                    }
                    FreemeProvider.access$302(freemeProvider2, vaid);
                    FreemeProvider freemeProvider3 = FreemeProvider.this;
                    if (aaid == null) {
                        aaid = "";
                    }
                    FreemeProvider.access$402(freemeProvider3, aaid);
                    FreemeProvider.this.returnCallResult();
                }
                K0 k1 = (K0) this.val$idSupplier;
                if (k1.K0 != null) {
                    k1.f21178XI.unbindService(k1.xo);
                }
            }
        }
    }

    public FreemeProvider(Context context) {
        this.context = context;
        this.packagename = context.getPackageName();
    }

    public static /* synthetic */ boolean access$002(FreemeProvider freemeProvider, boolean z) {
        Object[] objArr = new Object[5];
        objArr[1] = freemeProvider;
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = 53;
        objArr[4] = 1606976968525L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }

    public static /* synthetic */ String access$100(FreemeProvider freemeProvider) {
        Object[] objArr = new Object[4];
        objArr[1] = freemeProvider;
        objArr[2] = 54;
        objArr[3] = 1606976968526L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$202(FreemeProvider freemeProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = freemeProvider;
        objArr[2] = str;
        objArr[3] = 55;
        objArr[4] = 1606976968527L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$302(FreemeProvider freemeProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = freemeProvider;
        objArr[2] = str;
        objArr[3] = 56;
        objArr[4] = 1606976968528L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$402(FreemeProvider freemeProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = freemeProvider;
        objArr[2] = str;
        objArr[3] = 57;
        objArr[4] = 1606976968529L;
        return (String) Utils.rL(objArr);
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 58, 1606976968530L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 59, 1606976968531L})).booleanValue();
    }
}
