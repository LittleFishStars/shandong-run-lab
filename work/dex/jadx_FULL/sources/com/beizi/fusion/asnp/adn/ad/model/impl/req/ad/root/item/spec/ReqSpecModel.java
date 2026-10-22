package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.item.spec;

import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.item.spec.ext.ReqSpecExtModel;
import com.beizi.fusion.kg;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ReqSpecModel extends ASNPJsonRequestModel {

    @kg(key = LoginConstants.EXT)
    private ReqSpecExtModel ext;

    @kg(key = "sdk")
    private String sdk;

    @kg(key = "sdkver")
    private String sdkVersion;

    @kg(key = "strategyMD5")
    private String strategyMD5;

    @kg(key = "tagid")
    private String tagID;

    public void setExt(ReqSpecExtModel reqSpecExtModel) {
        this.ext = reqSpecExtModel;
    }

    public void setSdk(String str) {
        this.sdk = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public void setStrategyMD5(String str) {
        this.strategyMD5 = str;
    }

    public void setTagID(String str) {
        this.tagID = str;
    }
}
