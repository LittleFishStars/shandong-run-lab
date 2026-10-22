package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.ext.install;

import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.kg;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ReqAppInstallModel extends ASNPJsonRequestModel {

    @kg(key = "install")
    private boolean install;

    @kg(key = "linkId")
    private String linkId;

    @kg(key = "updateTime")
    private long updateTime;

    public void setInstall(boolean z) {
        this.install = z;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }
}
