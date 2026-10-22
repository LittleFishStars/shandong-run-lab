package com.czhj.devicehelper.cnoaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.czhj.devicehelper.cnoaid.com.qiku.id.IOAIDInterface;
import com.czhj.devicehelper.cnoaid.com.qiku.id.QikuIdmanager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class q implements com.czhj.devicehelper.cnoaid.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f29362a;
    private boolean b = true;

    public q(Context context) {
        this.f29362a = context;
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public void a(com.czhj.devicehelper.cnoaid.c cVar) {
        if (this.f29362a == null || cVar == null) {
            return;
        }
        if (this.b) {
            Intent intent = new Intent("qiku.service.action.id");
            intent.setPackage("com.qiku.id");
            n.a(this.f29362a, intent, cVar, new n.a() { // from class: com.czhj.devicehelper.cnoaid.impl.q.1
                @Override // com.czhj.devicehelper.cnoaid.impl.n.a
                public String a(IBinder iBinder) throws com.czhj.devicehelper.cnoaid.f, RemoteException {
                    IOAIDInterface iOAIDInterfaceAsInterface = IOAIDInterface.Stub.asInterface(iBinder);
                    if (iOAIDInterfaceAsInterface != null) {
                        return iOAIDInterfaceAsInterface.getOAID();
                    }
                    throw new com.czhj.devicehelper.cnoaid.f("IdsSupplier is null");
                }
            });
            return;
        }
        try {
            String oaid = new QikuIdmanager().getOAID();
            if (oaid == null || oaid.length() == 0) {
                throw new com.czhj.devicehelper.cnoaid.f("OAID/AAID acquire failed");
            }
            cVar.a(oaid);
        } catch (Exception e) {
            cVar.a(e);
        }
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public boolean a() {
        Context context = this.f29362a;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.qiku.id", 0) != null) {
                return true;
            }
            this.b = false;
            return new QikuIdmanager().isSupported();
        } catch (Exception e) {
            com.czhj.devicehelper.cnoaid.g.a(e);
            return false;
        }
    }
}
