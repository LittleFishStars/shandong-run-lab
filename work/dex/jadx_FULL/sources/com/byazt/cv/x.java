package com.byazt.cv;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 597, 71})
public class x extends com.byazt.sbm.tt {
    public com.byazt.oh.uj c;

    public x(com.byazt.oh.uj ujVar) {
        this.c = ujVar;
    }

    @Override // com.byazt.sbm.tt
    public String getAdType() {
        com.byazt.oh.uj ujVar = this.c;
        return ujVar != null ? ujVar.ve() : "";
    }

    @Override // com.byazt.sbm.tt
    public String getAdnName() {
        com.byazt.oh.uj ujVar = this.c;
        return ujVar != null ? ujVar.tt() : "";
    }

    @Override // com.byazt.sbm.tt
    public int getErrCode() {
        com.byazt.oh.uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.uj();
        }
        return -1;
    }

    @Override // com.byazt.sbm.tt
    public String getErrMsg() {
        com.byazt.oh.uj ujVar = this.c;
        return ujVar != null ? ujVar.n() : "";
    }

    @Override // com.byazt.sbm.tt
    public String getMediationRit() {
        com.byazt.oh.uj ujVar = this.c;
        return ujVar != null ? ujVar.c() : "";
    }
}
