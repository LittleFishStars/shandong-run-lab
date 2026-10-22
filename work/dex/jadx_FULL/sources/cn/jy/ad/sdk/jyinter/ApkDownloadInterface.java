package cn.jy.ad.sdk.jyinter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ApkDownloadInterface {

    public interface DownloadDialogCallBack {
        @Deprecated
        void onDownloadDialogClose();
    }

    public interface DownloadStatus {
        public static final int STATUS_DOWNLOADING = 4;
        public static final int STATUS_DOWNLOAD_FAILED = 16;
        public static final int STATUS_DOWNLOAD_FINISHED = 8;
        public static final int STATUS_DOWNLOAD_PAUSED = 32;
        public static final int STATUS_INSTALLED = 1;
        public static final int STATUS_UNKNOWN = 0;
    }

    int getDownloadStatus();

    int getProgress();

    @Deprecated
    void pauseAppDownload();

    @Deprecated
    void resumeAppDownload();

    @Deprecated
    void setDownloadDialogCallBack(DownloadDialogCallBack downloadDialogCallBack);
}
