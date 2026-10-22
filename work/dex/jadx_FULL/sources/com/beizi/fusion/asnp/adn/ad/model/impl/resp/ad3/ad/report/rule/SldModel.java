package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SldModel extends ASNPJsonResponseModel {

    @kg(key = "clk")
    private String clk;

    @kg(key = "other")
    private String other;

    @kg(key = "scroll")
    private String scroll;

    @kg(key = "shake")
    private String shake;

    @kg(key = "turn")
    private String turn;

    public SldModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getClk() {
        return this.clk;
    }

    public String getOther() {
        return this.other;
    }

    public String getScroll() {
        return this.scroll;
    }

    public String getShake() {
        return this.shake;
    }

    public String getTurn() {
        return this.turn;
    }
}
