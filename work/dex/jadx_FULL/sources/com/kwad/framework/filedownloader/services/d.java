package com.kwad.framework.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends com.kwad.framework.filedownloader.c.b.a implements com.kwad.framework.filedownloader.message.e.b, i {
    private final RemoteCallbackList<com.kwad.framework.filedownloader.c.a> aDd = new RemoteCallbackList<>();
    private final g aDe;
    private final WeakReference<FileDownloadServiceProxy> aDf;

    public d(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.aDf = weakReference;
        this.aDe = gVar;
        com.kwad.framework.filedownloader.message.e.CR().a(this);
    }

    private synchronized int v(MessageSnapshot messageSnapshot) {
        int iBeginBroadcast;
        RemoteCallbackList<com.kwad.framework.filedownloader.c.a> remoteCallbackList;
        iBeginBroadcast = this.aDd.beginBroadcast();
        for (int i = 0; i < iBeginBroadcast; i++) {
            try {
                try {
                    ((com.kwad.framework.filedownloader.c.a) this.aDd.getBroadcastItem(i)).q(messageSnapshot);
                } catch (Throwable th) {
                    this.aDd.finishBroadcast();
                    throw th;
                }
            } catch (RemoteException e) {
                com.kwad.framework.filedownloader.f.d.a(this, e, "callback error", new Object[0]);
                remoteCallbackList = this.aDd;
                remoteCallbackList.finishBroadcast();
                return iBeginBroadcast;
            }
        }
        remoteCallbackList = this.aDd;
        remoteCallbackList.finishBroadcast();
        return iBeginBroadcast;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void CH() {
        this.aDe.CH();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void Dn() {
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final IBinder Do() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void a(com.kwad.framework.filedownloader.c.a aVar) {
        this.aDd.register(aVar);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(com.kwad.framework.filedownloader.c.a aVar) {
        this.aDd.unregister(aVar);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean cP(int i) {
        return this.aDe.cP(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long cQ(int i) {
        return this.aDe.db(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long cR(int i) {
        return this.aDe.cR(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean cv(int i) {
        return this.aDe.cv(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final byte cw(int i) {
        return this.aDe.cw(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean cx(int i) {
        return this.aDe.cx(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean isIdle() {
        return this.aDe.isIdle();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void onDestroy() {
        com.kwad.framework.filedownloader.message.e.CR().a(null);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void pauseAllTasks() {
        this.aDe.Dq();
    }

    @Override // com.kwad.framework.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        v(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void startForeground(int i, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.aDf;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.aDf.get().context.startForeground(i, notification);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void stopForeground(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.aDf;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.aDf.get().context.stopForeground(z);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean z(String str, String str2) {
        return this.aDe.B(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        this.aDe.b(str, str2, z, i, i2, i3, z2, bVar, z3);
    }
}
