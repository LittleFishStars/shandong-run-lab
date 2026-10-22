package com.kc.dw.core.utils;

import android.content.Context;
import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DownloadInfo implements Serializable {
    public static final int STATUS_COMPLETE = 2;
    public static final int STATUS_INTERRUPTED = 1;
    public static final int STATUS_NONE = 0;
    private static final String TAG = "Download.DownloadInfo";
    public String cacheFile;
    public String deeplinkUrl;
    public String displayName;
    public String downloadFile;
    public String fileName;
    public String key;
    public int notificationId;
    public String packageName;
    public String[] reportDownloadStart;
    public String[] reportDownloadSuccess;
    public String[] reportInstallStart;
    public String[] reportInstallSucc;
    public String url;
    public int retryTime = 0;
    private Context context = com.kc.dw.base.a.getContext();
    public boolean downloadStartReported = false;
    public boolean downloadSuccessReported = false;
    public boolean installStartReported = false;
    public boolean installSuccessReported = false;
    public boolean hasNotifiedOpen = false;

    public DownloadInfo(String str, File file, String str2, com.kc.dw.platform.ad_adapter.c cVar) {
        this.url = null;
        this.fileName = null;
        this.downloadFile = null;
        this.cacheFile = null;
        this.packageName = null;
        int i = 0;
        this.displayName = null;
        this.key = cVar.toString();
        this.packageName = cVar.a().getPackageName();
        this.url = str;
        this.displayName = str2;
        this.fileName = makeFileName(str);
        this.cacheFile = new File(file, this.fileName + ".TempFile").getAbsolutePath();
        this.downloadFile = new File(file, this.fileName).getAbsolutePath();
        String[] dn_start = cVar.a().getDn_start();
        this.reportDownloadStart = dn_start;
        if (dn_start != null) {
            int i2 = 0;
            while (true) {
                String[] strArr = this.reportDownloadStart;
                if (i2 >= strArr.length) {
                    break;
                }
                strArr[i2] = f.a(strArr[i2], cVar);
                i2++;
            }
        }
        String[] dn_succ = cVar.a().getDn_succ();
        this.reportDownloadSuccess = dn_succ;
        if (dn_succ != null) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.reportDownloadSuccess;
                if (i3 >= strArr2.length) {
                    break;
                }
                strArr2[i3] = f.a(strArr2[i3], cVar);
                i3++;
            }
        }
        String[] dn_inst_start = cVar.a().getDn_inst_start();
        this.reportInstallStart = dn_inst_start;
        if (dn_inst_start != null) {
            int i4 = 0;
            while (true) {
                String[] strArr3 = this.reportInstallStart;
                if (i4 >= strArr3.length) {
                    break;
                }
                strArr3[i4] = f.a(strArr3[i4], cVar);
                i4++;
            }
        }
        String[] dn_inst_succ = cVar.a().getDn_inst_succ();
        this.reportInstallSucc = dn_inst_succ;
        if (dn_inst_succ != null) {
            while (true) {
                String[] strArr4 = this.reportInstallSucc;
                if (i >= strArr4.length) {
                    break;
                }
                strArr4[i] = f.a(strArr4[i], cVar);
                i++;
            }
        }
        this.deeplinkUrl = cVar.a().getDeep_link();
    }

    private static final String makeFileName(String str) {
        try {
            return o1.a(MessageDigest.getInstance("MD5").digest(str.getBytes())).toLowerCase() + ".apk";
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "tempName.apk";
        }
    }

    public int downloadStatus() {
        if (new File(this.downloadFile).exists()) {
            return 2;
        }
        return new File(this.cacheFile).exists() ? 1 : 0;
    }

    public String getDisplayName() {
        String str = this.displayName;
        return str == null ? "" : str;
    }

    public void onDownloadFailed() {
        LogUtil.d(TAG, "onDownloadFailed: 下载失败");
    }

    public void onDownloadStart() {
        String str;
        if (this.downloadStartReported) {
            str = "Report dn_start reported abandon(reported)";
        } else {
            this.downloadStartReported = true;
            String[] strArr = this.reportDownloadStart;
            if (strArr != null) {
                LogUtil.d(TAG, "Report send dn_start");
                for (String str2 : strArr) {
                    if (!TextUtils.isEmpty(str2)) {
                        com.kc.dw.ad.interstitial.c.a(this.context, str2);
                    }
                }
            }
            str = "onDownloaded: 下载开始";
        }
        LogUtil.d(TAG, str);
    }

    public void onDownloaded() {
        String str;
        if (this.downloadSuccessReported) {
            str = "Report dn_succ reported abandon(reported)";
        } else {
            this.downloadSuccessReported = true;
            String[] strArr = this.reportDownloadSuccess;
            if (strArr != null) {
                LogUtil.d(TAG, "Report send dn_succ");
                for (String str2 : strArr) {
                    if (!TextUtils.isEmpty(str2)) {
                        com.kc.dw.ad.interstitial.c.a(this.context, str2);
                    }
                }
            }
            str = "onDownloaded: 下载完成";
        }
        LogUtil.d(TAG, str);
    }

    public void onInstallStart() {
        String str;
        if (this.installStartReported) {
            str = "Report dn_inst_start abandon(reported)";
        } else {
            this.installStartReported = true;
            String[] strArr = this.reportInstallStart;
            if (strArr != null) {
                LogUtil.d(TAG, "Report send dn_inst_start");
                for (String str2 : strArr) {
                    if (!TextUtils.isEmpty(str2)) {
                        com.kc.dw.ad.interstitial.c.a(this.context, str2);
                    }
                }
            }
            str = "onInstallStart: 开始安装";
        }
        LogUtil.d(TAG, str);
    }

    public void onInstallSucc() {
        String str;
        if (this.installSuccessReported) {
            str = "Report dn_inst_succ abandon(reported)";
        } else {
            this.installSuccessReported = true;
            String[] strArr = this.reportInstallSucc;
            if (strArr != null) {
                LogUtil.d(TAG, "Report send dn_inst_succ");
                for (String str2 : strArr) {
                    if (!TextUtils.isEmpty(str2)) {
                        com.kc.dw.ad.interstitial.c.a(this.context, str2);
                    }
                }
            }
            str = "onInstallStart: 安装成功";
        }
        LogUtil.d(TAG, str);
    }

    public String toString() {
        return String.format("DownloadInfo: DisplayName: %s\r\nUrl: %s\r\nDownloadFile:%s", this.displayName, this.url, this.downloadFile);
    }
}
