package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.land.LandingOptimizeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.OptimizeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.speed.SpeedModel;
import com.beizi.fusion.kg;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class IncomeModel extends ASNPJsonResponseModel {

    @kg(key = "auto")
    public int invoke;

    @kg(key = "lpOptimize")
    private LandingOptimizeModel landingOptimizeModel;

    @kg(key = "nativeOptimize")
    private List<OptimizeModel> optimizeModelList;

    @kg(key = "speed")
    private SpeedModel speedModel;

    public IncomeModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getInvoke() {
        return this.invoke;
    }

    public LandingOptimizeModel getLandingOptimizeModel() {
        return this.landingOptimizeModel;
    }

    public List<OptimizeModel> getOptimizeModelList() {
        return this.optimizeModelList;
    }

    public SpeedModel getSpeedModel() {
        return this.speedModel;
    }
}
