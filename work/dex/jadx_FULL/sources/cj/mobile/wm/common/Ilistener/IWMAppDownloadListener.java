package cj.mobile.wm.common.Ilistener;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IWMAppDownloadListener {
    void handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

    void onDownloadDialogDismiss();

    void onDownloadDialogShow();

    void onDownloadFailed();

    void onDownloadFinished();

    void onDownloadPaused();

    void onDownloadResumed();

    void onDownloadStarted();

    void onProgressUpdate(int i);
}
