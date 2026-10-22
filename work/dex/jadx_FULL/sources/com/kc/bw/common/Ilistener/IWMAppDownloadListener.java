package com.kc.bw.common.Ilistener;

import android.content.DialogInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
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
