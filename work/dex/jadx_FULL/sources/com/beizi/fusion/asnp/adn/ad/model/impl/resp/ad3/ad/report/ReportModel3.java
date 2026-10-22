package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.CSensorModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.ClkModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.ShowModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.TSensorModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ReportModel3 extends ASNPJsonResponseModel {

    @kg(key = "clk")
    private ClkModel clk;

    @kg(key = "csensor")
    private CSensorModel csensor;

    @kg(key = "show")
    private ShowModel show;

    @kg(key = "tsensor")
    private TSensorModel tsensor;

    public ReportModel3(JSONObject jSONObject) {
        super(jSONObject);
    }

    public CSensorModel getCSensor() {
        return this.csensor;
    }

    public ClkModel getClk() {
        return this.clk;
    }

    public ShowModel getShow() {
        return this.show;
    }

    public TSensorModel getTSensor() {
        return this.tsensor;
    }
}
