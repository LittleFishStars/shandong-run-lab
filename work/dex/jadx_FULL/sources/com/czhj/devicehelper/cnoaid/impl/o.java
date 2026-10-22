package com.czhj.devicehelper.cnoaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.czhj.devicehelper.cnoaid.com.oplus.stdid.IStdID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class o extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29358a = "action.com.oplus.stdid.ID_SERVICE";
    private static final String b = "com.coloros.mcs";
    private static final String c = "com.oplus.stdid.IdentifyService";
    private final Context d;

    public o(Context context) {
        super(context);
        this.d = context;
    }

    @Override // com.czhj.devicehelper.cnoaid.impl.p
    public String a(IBinder iBinder, String str, String str2) throws com.czhj.devicehelper.cnoaid.f, RemoteException {
        IStdID iStdIDAsInterface = IStdID.Stub.asInterface(iBinder);
        if (iStdIDAsInterface != null) {
            return iStdIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new com.czhj.devicehelper.cnoaid.f("IStdID is null");
    }

    @Override // com.czhj.devicehelper.cnoaid.impl.p, com.czhj.devicehelper.cnoaid.d
    public void a(com.czhj.devicehelper.cnoaid.c cVar) {
        if (this.d == null || cVar == null) {
            return;
        }
        Intent intent = new Intent(f29358a);
        intent.setComponent(new ComponentName(b, c));
        n.a(this.d, intent, cVar, new n.a() { // from class: com.czhj.devicehelper.cnoaid.impl.o.1
            @Override // com.czhj.devicehelper.cnoaid.impl.n.a
            public String a(IBinder iBinder) throws com.czhj.devicehelper.cnoaid.f, RemoteException {
                try {
                    return o.this.a(iBinder);
                } catch (RemoteException e) {
                    throw e;
                } catch (com.czhj.devicehelper.cnoaid.f e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new com.czhj.devicehelper.cnoaid.f(e3);
                }
            }
        });
    }

    @Override // com.czhj.devicehelper.cnoaid.impl.p, com.czhj.devicehelper.cnoaid.d
    public boolean a() {
        Context context = this.d;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(b, 0) != null;
        } catch (Exception e) {
            com.czhj.devicehelper.cnoaid.g.a(e);
            return false;
        }
    }
}
