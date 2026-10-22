package com.kwad.components.core.offline.b.a;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.kwad.components.offline.api.core.downloader.DownloadListener;
import com.kwad.components.offline.api.core.downloader.ResourceDownloader;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class t implements ResourceDownloader {
    public t() {
        com.kwad.sdk.core.d.c.d("UnionDownloader", "new UnionDownloader() instance: " + hashCode());
    }

    @Override // com.kwad.components.offline.api.core.downloader.ResourceDownloader
    public final int download(List<String> list, String str, String str2, final DownloadListener downloadListener, boolean z, boolean z2) {
        String str3 = str + WVNativeCallbackUtil.SEPERATER + str2;
        String str4 = list.get(0);
        com.kwad.sdk.core.d.c.d("UnionDownloader", "[" + hashCode() + " download: " + str3 + ", targetUrl: " + str4);
        com.kwad.framework.filedownloader.r.BG();
        com.kwad.framework.filedownloader.a aVarBV = com.kwad.framework.filedownloader.r.bV(str4);
        aVarBV.bT(str3);
        aVarBV.bt(z2);
        aVarBV.a(new com.kwad.framework.filedownloader.i() { // from class: com.kwad.components.core.offline.b.a.t.1
            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar) {
                super.a(aVar);
                com.kwad.sdk.core.d.c.d("UnionDownloader", "download started:" + aVar.getId());
                DownloadListener downloadListener2 = downloadListener;
                if (downloadListener2 != null) {
                    downloadListener2.onStart(aVar.getId());
                }
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
                com.kwad.sdk.core.d.c.d("UnionDownloader", "download progress:" + aVar.getId() + ", soFarBytes: " + aVar.AD() + ", totalBytes: " + aVar.AF());
                DownloadListener downloadListener2 = downloadListener;
                if (downloadListener2 != null) {
                    downloadListener2.onProgress(aVar.getId(), aVar.AD(), aVar.AF());
                }
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar) {
                com.kwad.sdk.core.d.c.d("UnionDownloader", "download warn:" + aVar.getId());
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
                com.kwad.sdk.core.d.c.d("UnionDownloader", "download pending:" + aVar.getId());
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th) {
                com.kwad.sdk.core.d.c.d("UnionDownloader", "download error:" + aVar.getId() + th.getMessage());
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                DownloadListener downloadListener2 = downloadListener;
                if (downloadListener2 != null) {
                    downloadListener2.onError(aVar.getId(), th);
                }
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar) {
                com.kwad.sdk.core.d.c.d("UnionDownloader", "download completed:");
                DownloadListener downloadListener2 = downloadListener;
                if (downloadListener2 != null) {
                    downloadListener2.onCompleted(aVar.getId(), aVar.getPath(), aVar.getFilename(), aVar.getTargetFilePath());
                }
            }
        });
        aVarBV.start();
        return aVarBV.getId();
    }

    @Override // com.kwad.components.offline.api.core.downloader.ResourceDownloader
    public final void startImmediately(int i) {
    }
}
