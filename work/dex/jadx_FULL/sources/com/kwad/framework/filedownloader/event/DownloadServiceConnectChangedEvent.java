package com.kwad.framework.filedownloader.event;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus aCn;
    private final Class<?> aCo;

    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.aCn = connectStatus;
        this.aCo = cls;
    }

    public final ConnectStatus CF() {
        return this.aCn;
    }
}
