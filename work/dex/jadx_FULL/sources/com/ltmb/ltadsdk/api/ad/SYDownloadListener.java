package com.ltmb.ltadsdk.api.ad;

import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\fJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0002H&¨\u0006\r"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYDownloadListener;", "", "", "onDownloadStart", "onDownloadPaused", "onDownloadCompleted", "onDownloadFailed", "", "totalBytes", "downloadedBytes", "onDownloadUpdate", "onInstalled", "SYDownloadListenerWrapper", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface SYDownloadListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYDownloadListener$SYDownloadListenerWrapper;", "Lcom/ltmb/ltadsdk/api/ad/SYDownloadListener;", "", "onDownloadStart", "onDownloadPaused", "onDownloadCompleted", "onDownloadFailed", "", "totalBytes", "downloadedBytes", "onDownloadUpdate", "onInstalled", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public static abstract class SYDownloadListenerWrapper implements SYDownloadListener {
        @Override // com.ltmb.ltadsdk.api.ad.SYDownloadListener
        public void onDownloadCompleted() {
        }

        @Override // com.ltmb.ltadsdk.api.ad.SYDownloadListener
        public void onDownloadFailed() {
        }

        @Override // com.ltmb.ltadsdk.api.ad.SYDownloadListener
        public void onDownloadPaused() {
        }

        @Override // com.ltmb.ltadsdk.api.ad.SYDownloadListener
        public void onDownloadStart() {
        }

        @Override // com.ltmb.ltadsdk.api.ad.SYDownloadListener
        public void onDownloadUpdate(long totalBytes, long downloadedBytes) {
        }

        @Override // com.ltmb.ltadsdk.api.ad.SYDownloadListener
        public void onInstalled() {
        }
    }

    void onDownloadCompleted();

    void onDownloadFailed();

    void onDownloadPaused();

    void onDownloadStart();

    void onDownloadUpdate(long totalBytes, long downloadedBytes);

    void onInstalled();
}
