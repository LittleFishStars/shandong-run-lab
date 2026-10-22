package com.byazt.cv;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 597, 15})
public class uj extends com.byazt.nc.n {
    public com.byazt.yl.ve c;

    public uj(com.byazt.yl.ve veVar) {
        this.c = veVar;
    }

    @Override // com.byazt.nc.n
    public void cancelDownload() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            veVar.cancelDownload();
        }
    }

    @Override // com.byazt.nc.n
    public void changeDownloadStatus() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            if (veVar.getDownloadStatus() == 3) {
                this.c.resumeAppDownload();
            } else if (this.c.getDownloadStatus() == 2) {
                this.c.pauseAppDownload();
            }
        }
    }
}
