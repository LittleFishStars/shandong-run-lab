package com.aliyun.downloader;

import com.aliyun.downloader.nativeclass.JniDownloader;
import com.aliyun.player.bean.ErrorInfo;
import com.aliyun.player.nativeclass.MediaInfo;
import com.aliyun.player.source.VidAuth;
import com.aliyun.player.source.VidSts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AliMediaDownloader {

    public interface ConvertURLCallback {
        String convertURL(String str, String str2);
    }

    public interface OnCompletionListener {
        void onCompletion();
    }

    public interface OnErrorListener {
        void onError(ErrorInfo errorInfo);
    }

    public interface OnPreparedListener {
        void onPrepared(MediaInfo mediaInfo);
    }

    public interface OnProgressListener {
        void onDownloadingProgress(int i);

        void onProcessingProgress(int i);
    }

    public static int deleteFile(String str, String str2, String str3, int i) {
        return JniDownloader.deleteFile(str, str2, str3, i);
    }

    public static void setConvertURLCallback(ConvertURLCallback convertURLCallback) {
        JniDownloader.setConvertURLCallback(convertURLCallback);
    }

    public abstract void deleteFile();

    public abstract String getFilePath();

    public abstract void prepare(VidAuth vidAuth);

    public abstract void prepare(VidSts vidSts);

    public abstract void release();

    public abstract void selectItem(int i);

    public abstract void setDownloaderConfig(DownloaderConfig downloaderConfig);

    public abstract void setOnCompletionListener(OnCompletionListener onCompletionListener);

    public abstract void setOnErrorListener(OnErrorListener onErrorListener);

    public abstract void setOnPreparedListener(OnPreparedListener onPreparedListener);

    public abstract void setOnProgressListener(OnProgressListener onProgressListener);

    public abstract void setSaveDir(String str);

    public abstract void start();

    public abstract void stop();

    public abstract void updateSource(VidAuth vidAuth);

    public abstract void updateSource(VidSts vidSts);
}
