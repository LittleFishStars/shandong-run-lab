package com.byazt.c;

import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 20, GLMapStaticValue.MAP_PARAMETERNAME_POLYGON_FILL_CONTROL})
public abstract class AbsDownloadListener implements IDownloadListener {
    public static final String TAG = "AbsDownloadListener";

    @Override // com.byazt.c.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
        if (!com.byazt.x.c.c() || downloadInfo == null) {
            return;
        }
        com.byazt.x.c.tt(TAG, " onCanceled -- " + downloadInfo.getName());
    }

    @Override // com.byazt.c.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.byazt.x.c.c() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.byazt.x.c.tt(str, String.format("onFailed on %s because of : %s", objArr));
    }

    @Override // com.byazt.c.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
        if (!com.byazt.x.c.c() || downloadInfo == null) {
            return;
        }
        com.byazt.x.c.tt(TAG, " onFirstStart -- " + downloadInfo.getName());
    }

    @Override // com.byazt.c.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
        if (!com.byazt.x.c.c() || downloadInfo == null) {
            return;
        }
        com.byazt.x.c.tt(TAG, " onFirstSuccess -- " + downloadInfo.getName());
    }

    public void onIntercept(DownloadInfo downloadInfo) {
        if (!com.byazt.x.c.c() || downloadInfo == null) {
            return;
        }
        com.byazt.x.c.tt(TAG, " onIntercept -- " + downloadInfo.getName());
    }

    @Override // com.byazt.c.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (!com.byazt.x.c.c() || downloadInfo == null) {
            return;
        }
        com.byazt.x.c.tt(TAG, " onPause -- " + downloadInfo.getName());
    }

    @Override // com.byazt.c.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (!com.byazt.x.c.c() || downloadInfo == null) {
            return;
        }
        com.byazt.x.c.tt(TAG, " onPrepare -- " + downloadInfo.getName());
    }

    @Override // com.byazt.c.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (!com.byazt.x.c.c() || downloadInfo == null || downloadInfo.getTotalBytes() == 0) {
            return;
        }
        com.byazt.x.c.tt(TAG, String.format("onProgress %s %.2f%%", downloadInfo.getName(), Float.valueOf((downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()) * 100.0f)));
    }

    @Override // com.byazt.c.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.byazt.x.c.c() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.byazt.x.c.tt(str, String.format("onRetry on %s because of : %s", objArr));
    }

    @Override // com.byazt.c.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.byazt.x.c.c() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.byazt.x.c.tt(str, String.format("onRetryDelay on %s because of : %s", objArr));
    }

    @Override // com.byazt.c.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (!com.byazt.x.c.c() || downloadInfo == null) {
            return;
        }
        com.byazt.x.c.tt(TAG, " onStart -- " + downloadInfo.getName());
    }

    @Override // com.byazt.c.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (!com.byazt.x.c.c() || downloadInfo == null) {
            return;
        }
        com.byazt.x.c.tt(TAG, " onSuccessed -- " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
    }
}
