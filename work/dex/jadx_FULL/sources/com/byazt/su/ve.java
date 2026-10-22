package com.byazt.su;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1486, 54})
@Deprecated
public class ve implements DownloadController {
    @Override // com.byazt.su.DownloadController
    public boolean enableAH() {
        return true;
    }

    @Override // com.byazt.su.DownloadController
    public boolean enableAM() {
        return true;
    }

    @Override // com.byazt.su.DownloadController
    public boolean enableNewActivity() {
        return true;
    }

    @Override // com.byazt.su.DownloadController
    public boolean enableShowComplianceDialog() {
        return true;
    }

    @Override // com.byazt.su.DownloadController
    public int getDowloadChunkCount() {
        return 0;
    }

    @Override // com.byazt.su.DownloadController
    public int getDownloadMode() {
        return 0;
    }

    @Override // com.byazt.su.DownloadController
    public Object getExtraClickOperation() {
        return null;
    }

    @Override // com.byazt.su.DownloadController
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.byazt.su.DownloadController
    public Object getExtraObject() {
        return null;
    }

    @Override // com.byazt.su.DownloadController
    public int getInterceptFlag() {
        return 0;
    }

    @Override // com.byazt.su.DownloadController
    public int getLinkMode() {
        return 0;
    }

    @Override // com.byazt.su.DownloadController
    public boolean isAddToDownloadManage() {
        return false;
    }

    @Override // com.byazt.su.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        return false;
    }

    @Override // com.byazt.su.DownloadController
    public boolean isEnableBackDialog() {
        return false;
    }

    @Override // com.byazt.su.DownloadController
    public boolean isEnableMultipleDownload() {
        return false;
    }

    @Override // com.byazt.su.DownloadController
    public void setDownloadMode(int i) {
    }

    @Override // com.byazt.su.DownloadController
    public void setEnableNewActivity(boolean z) {
    }

    @Override // com.byazt.su.DownloadController
    public void setEnableShowComplianceDialog(boolean z) {
    }

    @Override // com.byazt.su.DownloadController
    public void setLinkMode(int i) {
    }

    @Override // com.byazt.su.DownloadController
    public boolean shouldUseNewWebView() {
        return false;
    }
}
