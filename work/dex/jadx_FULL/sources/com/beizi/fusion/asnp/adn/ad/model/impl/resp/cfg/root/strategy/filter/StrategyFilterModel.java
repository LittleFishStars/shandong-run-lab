package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.complain.ComplainModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.frequency.StrategyFrequencyModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.unite.UniteControlModel;
import com.beizi.fusion.kg;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class StrategyFilterModel extends ASNPJsonResponseModel {

    @kg(key = "complain")
    private ComplainModel complainModel;

    @kg(key = "frequency")
    private List<StrategyFrequencyModel> frequencyModels;

    @kg(key = "minTime")
    private int minTime;

    @kg(key = "uniteControl")
    @Deprecated
    private UniteControlModel uniteControlModel;

    public StrategyFilterModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public ComplainModel getComplainModel() {
        return this.complainModel;
    }

    public List<StrategyFrequencyModel> getFrequencyModels() {
        return this.frequencyModels;
    }

    public int getMinTime() {
        return this.minTime;
    }

    @Deprecated
    public UniteControlModel getUniteControlModel() {
        return this.uniteControlModel;
    }
}
