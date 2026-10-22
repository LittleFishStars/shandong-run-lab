package com.beizi.fusion.asnp.adn.ad.model.impl.local;

import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AppInstallModel extends IBaseLocalModel {

    @kg(key = "install")
    private boolean install;

    @kg(key = "linkId")
    private String linkId;

    @kg(key = "updateTime")
    private long updateTime;

    public AppInstallModel() {
        super(null);
    }

    public String getLinkId() {
        return this.linkId;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isInstall() {
        return this.install;
    }

    public void setInstall(boolean z) {
        this.install = z;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public AppInstallModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
