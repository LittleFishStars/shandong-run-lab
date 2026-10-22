package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RuleModel extends ASNPJsonResponseModel {

    @kg(key = "calExposureTime")
    private int calExposureTime;

    @kg(key = "calRandomNum")
    private int calRandomNum;

    @kg(key = "repDelay")
    private int repDelay;

    @kg(key = "repRandomDelay")
    private int repRandomDelay;

    @kg(key = "type")
    private int type;

    public RuleModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getCallbackExposureTime() {
        return this.calExposureTime;
    }

    public int getCallbackRandomNum() {
        return this.calRandomNum;
    }

    public int getRepDelay() {
        return this.repDelay;
    }

    public int getRepRandomDelay() {
        return this.repRandomDelay;
    }

    public int getType() {
        return this.type;
    }
}
