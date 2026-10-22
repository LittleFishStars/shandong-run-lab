package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.ext;

import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.ext.install.ReqAppInstallModel;
import com.beizi.fusion.kg;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ReqContextExtModel extends ASNPJsonRequestModel {

    @kg(key = "appInstall")
    private List<ReqAppInstallModel> appInstall;

    @kg(key = "blackListVersion")
    private String blackListVersion;

    public void setAppInstall(List<ReqAppInstallModel> list) {
        this.appInstall = list;
    }

    public void setBlackListVersion(String str) {
        this.blackListVersion = str;
    }
}
