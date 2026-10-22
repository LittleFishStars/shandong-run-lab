package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.RuleModel;
import com.beizi.fusion.kg;
import com.heytap.mcssdk.constant.b;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ReportModel extends ASNPJsonResponseModel {

    @kg(key = "exposureArea")
    private int exposureArea;

    @kg(key = b.p)
    private List<RuleModel> rules;

    public ReportModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getExposureArea() {
        return this.exposureArea;
    }

    public List<RuleModel> getRules() {
        return this.rules;
    }
}
