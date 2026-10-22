package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.beta.unit;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import com.beizi.fusion.lb;
import com.beizi.fusion.m0;
import com.beizi.fusion.no;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class UnitTestModel extends ASNPJsonResponseModel implements lb {

    @kg(key = "duration")
    private String mBetaDuration;

    @kg(key = "endTime")
    private String mBetaEndTime;

    @kg(key = "planId")
    private String mBetaPlanID;

    @kg(key = "startTime")
    private String mBetaStartTime;

    @kg(key = "random")
    private String mRandomProbability;

    public UnitTestModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.beizi.fusion.lb
    public String getBetaTestPlanID() {
        return this.mBetaPlanID;
    }

    @Override // com.beizi.fusion.lb
    public long getDurationMillisecond() {
        return no.j(this.mBetaDuration);
    }

    @Override // com.beizi.fusion.lb
    public long getEndTimestamp() {
        return no.j(this.mBetaEndTime);
    }

    @Override // com.beizi.fusion.lb
    public int getRandomProbability() {
        return no.i(this.mRandomProbability);
    }

    @Override // com.beizi.fusion.lb
    public String getSDKBizID() {
        return m0.e();
    }

    @Override // com.beizi.fusion.lb
    public long getStartTimestamp() {
        return no.j(this.mBetaStartTime);
    }
}
