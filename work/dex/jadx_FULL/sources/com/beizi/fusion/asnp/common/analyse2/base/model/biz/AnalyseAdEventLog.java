package com.beizi.fusion.asnp.common.analyse2.base.model.biz;

import com.beizi.fusion.j2;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AnalyseAdEventLog extends AnalyseSimpleLog {

    @kg(exclude = true, key = "amps")
    private AnalyseAdCommon amps;

    @kg(exclude = true, key = "asnp")
    private AnalyseAdCommon asnp;

    public AnalyseAdEventLog(JSONObject jSONObject) {
        super(jSONObject);
    }

    public AnalyseAdCommon b() {
        AnalyseAdCommon analyseAdCommon = this.amps;
        if (analyseAdCommon != null) {
            return analyseAdCommon;
        }
        AnalyseAdCommon analyseAdCommon2 = this.asnp;
        if (analyseAdCommon2 != null) {
            return analyseAdCommon2;
        }
        return null;
    }

    public abstract j2.a c();

    @Override // com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseSimpleLog
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public j2.a a() {
        return c();
    }
}
