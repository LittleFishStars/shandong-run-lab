package com.byazt.e;

import android.text.TextUtils;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 443, 1132})
public class DownloadShortInfo {
    public String fileName;
    public boolean onlyWifi;
    public long id = -1;
    public int status = -1;
    public long totalBytes = -1;
    public long currentBytes = -1;
    public int failStatus = 0;

    public boolean equals(Object obj) {
        if (!(obj instanceof DownloadShortInfo) || obj == null) {
            return super.equals(obj);
        }
        DownloadShortInfo downloadShortInfo = (DownloadShortInfo) obj;
        return ((this.id > downloadShortInfo.id ? 1 : (this.id == downloadShortInfo.id ? 0 : -1)) == 0) && (this.status == downloadShortInfo.status) && ((this.totalBytes > downloadShortInfo.totalBytes ? 1 : (this.totalBytes == downloadShortInfo.totalBytes ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.fileName) && TextUtils.isEmpty(downloadShortInfo.fileName)) || (!TextUtils.isEmpty(this.fileName) && !TextUtils.isEmpty(downloadShortInfo.fileName) && this.fileName.equals(downloadShortInfo.fileName)));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.id), Integer.valueOf(this.status), Long.valueOf(this.totalBytes), this.fileName});
    }

    public void updateFromNewDownloadInfo(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.id = downloadInfo.getId();
        this.status = downloadInfo.getStatus();
        this.currentBytes = downloadInfo.getCurBytes();
        this.totalBytes = downloadInfo.getTotalBytes();
        this.fileName = downloadInfo.getTargetFilePath();
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException != null) {
            this.failStatus = failedException.getErrorCode();
        } else {
            this.failStatus = 0;
        }
        this.onlyWifi = downloadInfo.isOnlyWifi();
    }
}
