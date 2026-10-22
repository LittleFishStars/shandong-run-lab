package com.byazt.w;

import android.util.SparseArray;
import com.byazt.c.AbsDownloadListener;
import com.byazt.c.IDownloadListener;
import com.byazt.c.my;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1017, 54})
public class ve {
    public static void c(int i, SparseArray<IDownloadListener> sparseArray, boolean z, DownloadInfo downloadInfo, BaseException baseException) {
        SparseArray<IDownloadListener> sparseArrayClone;
        if (!z || sparseArray == null) {
            return;
        }
        try {
            if (sparseArray.size() <= 0) {
                return;
            }
            synchronized (sparseArray) {
                sparseArrayClone = sparseArray.clone();
            }
            for (int i2 = 0; i2 < sparseArrayClone.size(); i2++) {
                IDownloadListener iDownloadListener = sparseArrayClone.get(sparseArrayClone.keyAt(i2));
                if (iDownloadListener != null) {
                    if (i == 1) {
                        iDownloadListener.onPrepare(downloadInfo);
                    } else if (i == 2) {
                        iDownloadListener.onStart(downloadInfo);
                    } else if (i == 4) {
                        iDownloadListener.onProgress(downloadInfo);
                    } else if (i == 5) {
                        iDownloadListener.onRetry(downloadInfo, baseException);
                    } else if (i == 6) {
                        iDownloadListener.onFirstStart(downloadInfo);
                    } else if (i == 7) {
                        iDownloadListener.onRetryDelay(downloadInfo, baseException);
                    } else if (i != 11) {
                        switch (i) {
                            case -7:
                                if (iDownloadListener instanceof AbsDownloadListener) {
                                    ((AbsDownloadListener) iDownloadListener).onIntercept(downloadInfo);
                                }
                                break;
                            case -6:
                                iDownloadListener.onFirstSuccess(downloadInfo);
                                break;
                            case -5:
                            case -2:
                                iDownloadListener.onPause(downloadInfo);
                                break;
                            case -4:
                                iDownloadListener.onCanceled(downloadInfo);
                                break;
                            case -3:
                                iDownloadListener.onSuccessed(downloadInfo);
                                break;
                            case -1:
                                iDownloadListener.onFailed(downloadInfo, baseException);
                                break;
                        }
                    } else if (iDownloadListener instanceof my) {
                        ((my) iDownloadListener).c(downloadInfo);
                    }
                }
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }
}
