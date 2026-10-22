package com.byazt.cv;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 597, 91})
public class sp extends com.byazt.sbm.c {
    public com.byazt.oh.tt c;

    public sp(com.byazt.oh.tt ttVar) {
        this.c = ttVar;
    }

    @Override // com.byazt.sbm.c
    public String getAbTestId() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.z() : "";
    }

    @Override // com.byazt.sbm.c
    public String getChannel() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.u() : "";
    }

    @Override // com.byazt.sbm.c
    public Map<String, String> getCustomData() {
        com.byazt.oh.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.c();
        }
        return null;
    }

    @Override // com.byazt.sbm.c
    public String getCustomSdkName() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.ve() : "";
    }

    @Override // com.byazt.sbm.c
    public String getDiscount() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.nu() : "";
    }

    @Override // com.byazt.sbm.c
    public String getEcpm() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.a() : "";
    }

    @Override // com.byazt.sbm.c
    public String getErrorMsg() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.x() : "";
    }

    @Override // com.byazt.sbm.c
    public String getLevelTag() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.n() : "";
    }

    @Override // com.byazt.sbm.c
    public int getReqBiddingType() {
        com.byazt.oh.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.sp();
        }
        return 0;
    }

    @Override // com.byazt.sbm.c
    public String getRequestId() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.i() : "";
    }

    @Override // com.byazt.sbm.c
    public String getRitType() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.da() : "";
    }

    @Override // com.byazt.sbm.c
    public String getScenarioId() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.m() : "";
    }

    @Override // com.byazt.sbm.c
    public String getSdkName() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.tt() : "";
    }

    @Override // com.byazt.sbm.c
    public String getSegmentId() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.t() : "";
    }

    @Override // com.byazt.sbm.c
    public String getSlotId() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.uj() : "";
    }

    @Override // com.byazt.sbm.c
    public String getSubChannel() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.yp() : "";
    }

    @Override // com.byazt.sbm.c
    public String getSubRitType() {
        com.byazt.oh.tt ttVar = this.c;
        return ttVar != null ? ttVar.sl() : "";
    }
}
