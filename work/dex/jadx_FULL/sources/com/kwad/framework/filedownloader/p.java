package com.kwad.framework.filedownloader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class p extends com.kwad.framework.filedownloader.services.a<a, com.kwad.framework.filedownloader.c.b> {

    public static class a extends com.kwad.framework.filedownloader.c.a.AbstractBinderC1255a {
        @Override // com.kwad.framework.filedownloader.c.a
        public final void q(MessageSnapshot messageSnapshot) {
            com.kwad.framework.filedownloader.message.e.CR().s(messageSnapshot);
        }
    }

    public p(Class<?> cls) {
        super(cls);
    }

    private static a BC() {
        return new a();
    }

    @Override // com.kwad.framework.filedownloader.services.a
    public final /* synthetic */ Binder BD() {
        return BC();
    }

    @Override // com.kwad.framework.filedownloader.services.a
    public final /* bridge */ /* synthetic */ void a(IInterface iInterface, Binder binder) {
        a((com.kwad.framework.filedownloader.c.b) iInterface, (a) binder);
    }

    @Override // com.kwad.framework.filedownloader.services.a
    public final /* synthetic */ IInterface b(IBinder iBinder) {
        return a(iBinder);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean cv(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.cv(i);
        }
        try {
            return Dc().cv(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte cw(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.cw(i);
        }
        try {
            return Dc().cw(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return (byte) 0;
        }
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean cx(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.cx(i);
        }
        try {
            return Dc().cx(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static com.kwad.framework.filedownloader.c.b a(IBinder iBinder) {
        return com.kwad.framework.filedownloader.c.b.a.a(iBinder);
    }

    private static void a(com.kwad.framework.filedownloader.c.b bVar, a aVar) {
        bVar.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.h(str, str2, z);
        }
        try {
            Dc().b(str, str2, z, i, i2, i3, z2, bVar, z3);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
