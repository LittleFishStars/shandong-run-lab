package com.kwad.framework.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, u {
    private volatile INTERFACE aCS;
    private final Class<?> aCo;
    private final HashMap<String, Object> aCT = new HashMap<>();
    private final List<Context> aCU = new ArrayList();
    private final ArrayList<Runnable> aAb = new ArrayList<>();
    private final CALLBACK aCR = (CALLBACK) BD();

    public a(Class<?> cls) {
        this.aCo = cls;
    }

    private void a(Context context, Runnable runnable) {
        if (com.kwad.framework.filedownloader.f.f.aZ(context)) {
            throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
        }
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
        }
        Intent intent = new Intent(context, this.aCo);
        if (!this.aCU.contains(context)) {
            this.aCU.add(context);
        }
        context.bindService(intent, this, 1);
        context.startService(intent);
    }

    private void by(boolean z) {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "release connect resources %s", this.aCS);
        }
        this.aCS = null;
        com.kwad.framework.filedownloader.f.Bl().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.lost, this.aCo));
    }

    public abstract CALLBACK BD();

    public final INTERFACE Dc() {
        return this.aCS;
    }

    public abstract void a(INTERFACE r1, CALLBACK callback);

    @Override // com.kwad.framework.filedownloader.u
    public final void aW(Context context) {
        a(context, (Runnable) null);
    }

    public abstract INTERFACE b(IBinder iBinder);

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return Dc() != null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.aCS = (INTERFACE) b(iBinder);
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceConnected %s %s", componentName, this.aCS);
        }
        try {
            a(this.aCS, this.aCR);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        List list = (List) this.aAb.clone();
        this.aAb.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        com.kwad.framework.filedownloader.f.Bl().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.aCo));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceDisconnected %s %s", componentName, this.aCS);
        }
        by(true);
    }
}
