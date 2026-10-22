package com.kwad.sdk.core.download.a;

import com.kwad.sdk.api.KsAppDownloadListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a implements KsAppDownloadListener {
    public String downloadId;

    public a() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    public void onPaused(int i) {
    }

    public final String qo() {
        return this.downloadId;
    }

    public a(String str) {
        this.downloadId = str;
    }
}
