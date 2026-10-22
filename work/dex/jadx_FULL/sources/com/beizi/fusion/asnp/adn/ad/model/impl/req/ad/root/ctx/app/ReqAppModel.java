package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.app;

import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.kg;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ReqAppModel extends ASNPJsonRequestModel {

    @kg(key = "appId")
    private String appId;

    @kg(key = "bundle")
    private String bundle;

    @kg(key = "install")
    private long install;

    @kg(key = "name")
    private String name;

    @kg(key = "update")
    private long update;

    @kg(key = "ver")
    private String ver;

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBundle(String str) {
        this.bundle = str;
    }

    public void setInstall(long j) {
        this.install = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUpdate(long j) {
        this.update = j;
    }

    public void setVer(String str) {
        this.ver = str;
    }
}
