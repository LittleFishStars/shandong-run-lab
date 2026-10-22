package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class e extends com.kwad.framework.filedownloader.event.c {
    private DownloadServiceConnectChangedEvent.ConnectStatus azG;

    public abstract void Bi();

    public abstract void Bj();

    public final DownloadServiceConnectChangedEvent.ConnectStatus Bk() {
        return this.azG;
    }

    @Override // com.kwad.framework.filedownloader.event.c
    public final boolean a(com.kwad.framework.filedownloader.event.b bVar) {
        if (!(bVar instanceof DownloadServiceConnectChangedEvent)) {
            return false;
        }
        DownloadServiceConnectChangedEvent.ConnectStatus connectStatusCF = ((DownloadServiceConnectChangedEvent) bVar).CF();
        this.azG = connectStatusCF;
        if (connectStatusCF == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            Bi();
            return false;
        }
        Bj();
        return false;
    }
}
