package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ShowModel extends ASNPJsonResponseModel {

    @kg(key = "av")
    private int av;

    @kg(key = "rt")
    private int rt;

    public ShowModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getAv() {
        return this.av;
    }

    public int getRt() {
        return this.rt;
    }
}
