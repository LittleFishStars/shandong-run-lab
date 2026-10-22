package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.reg;

import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.kg;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ReqRegsModel extends ASNPJsonRequestModel {

    @kg(key = "ccpa")
    private int CCPA;

    @kg(key = "coppa")
    private int COPPA;

    @kg(key = "gdpr")
    private int GDPR;

    public void setCCPA(int i) {
        this.CCPA = i;
    }

    public void setCOPPA(int i) {
        this.COPPA = i;
    }

    public void setGDPR(int i) {
        this.GDPR = i;
    }
}
