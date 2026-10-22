package com.huachenjie.common.bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class UnfinishedRun {
    private AlertTip alertTip;
    private boolean resume;
    private String runRecordCode;
    private int sportType;

    public AlertTip getAlertTip() {
        return this.alertTip;
    }

    public String getRunRecordCode() {
        return this.runRecordCode;
    }

    public int getSportType() {
        return this.sportType;
    }

    public boolean isResume() {
        return this.resume;
    }

    public void setAlertTip(AlertTip alertTip) {
        this.alertTip = alertTip;
    }

    public void setResume(boolean resume) {
        this.resume = resume;
    }

    public void setRunRecordCode(String runRecordCode) {
        this.runRecordCode = runRecordCode;
    }

    public void setSportType(int sportType) {
        this.sportType = sportType;
    }
}
