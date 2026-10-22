package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ext;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.bl.BlackListModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ResponseExtModel extends ASNPJsonResponseModel {

    @kg(key = "blackInfo")
    private BlackListModel blackList;

    @kg(key = "switchBack")
    private int switchBack;

    @kg(key = "updateCfg")
    private boolean updateConfig;

    @kg(key = "updateTime")
    private long updateTime;

    public ResponseExtModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public BlackListModel getBlackList() {
        return this.blackList;
    }

    public int getSwitchBack() {
        return this.switchBack;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isUpdateConfig() {
        return this.updateConfig;
    }
}
