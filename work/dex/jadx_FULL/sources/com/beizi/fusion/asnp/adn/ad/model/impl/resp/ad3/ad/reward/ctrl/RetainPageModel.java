package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.ctrl;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RetainPageModel extends ASNPJsonResponseModel {

    @kg(key = "action")
    private int action;

    @kg(key = "probability")
    private int probability;

    public RetainPageModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getAction() {
        return this.action;
    }

    public int getProbability() {
        return this.probability;
    }
}
